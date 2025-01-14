import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import loot.GameFrame;
import loot.GameFrameSettings;
import loot.graphics.DrawableObject3D;
import loot.graphics.Viewport;

/**
 * 인스턴스'들'을 한데 모아 다루기 위한 방안들을 소개하는 예시입니다.<br>
 * <br>
 * - 임의의 값을 사용하기 위한 java.util.Random<br>
 * - 어떤 클래스 형식에 대한 '생성자'<br>
 * - 특정 형식 인스턴스'들'을 다루기 위한 java.util.ArrayList<><br>
 * - Viewport.GetObjectAt()을 사용하여 화면 위 특정 위치에 보이는 요소 찾기 
 * - Python의 for문과 유사한 느낌으로 사용할 수 있는 Java의 foreach문<br>
 */
public class SampleFrame1_ArrayList extends GameFrame {

	/*
	 * 어떤 Data 이름 자리에 담긴 값을 프로그램 실행 도중 '변경'하지 않을 예정이라면,
	 * 아래와 같이 final을 그 선언에 적어둘 수 있어요.
	 * -> 미래의 내가 해당 이름을 = 수식 좌항 자리에 적을 수 없게끔 막아 두는 셈이 돼요 
	 */
	static final double Reposition_X = -400.0;
	static final double Reposition_Y_min = -300.0;
	static final double Reposition_Y_max = 300.0;
	static final double Reposition_Z_min = 0.0;
	static final double Reposition_Z_max = -1.0;
	
	static final double Velocity_Normal_X = 5.0;
	static final double Velocity_Selected_X = 2.5;
	
	static final double Pos_Vanish_X = 400;
	
	/**
	 * java.util.Random 형식 nonstatic 필드 선언을 적어 둔 다음,
	 * Initialize()에서 새 Random 인스턴스를 만들어 담아 두도록 = 수식을 적어둘 수 있어요.
	 * 사용 방법은 rand. 까지 적으면 보일 메서드 이름들을 둘러보면 알 수 있을 듯 
	 */
	Random rand;

	class Rect extends DrawableObject3D {
		/*
		 * TODO#1 새 클래스 Rect에 대한 '생성자' 정의 적어보기
		 * 
		 * 1. 이 주석 바로 아래에서 Ctrl + Space를 누르고 바로 엔터 키를 치면
		 *    public Rect() { }
		 *    ...와 같은 느낌으로 Eclipse가 메서드 정의 비슷한 무언가를 적어줄 거예요.
		 *   
		 * 2. 정의 중괄호 안에서 super( 까지 적고 Ctrl + Space를 누르면
		 *    이름이 DrawableObject3D인 메서드?들이 목록에 보일 거예요.
		 *    일단 지금은 아무거나 골라도 돼요.
		 *    
		 * 3. 지금은 아래 한 줄을 괄호 안에 복붙해 둡시다:
		 *    0, 0, 0, 16, 16
		 *    ...그 다음 적당히 ; 를 적어 문장을 완성해 주세요.
		 *    
		 * 4. 방금 완성한 문장 아래에
		 *    Reposition();
		 *    ...을 복붙해서 적어 주세요.
		 */
		public Rect() {
			super(0,0,0,16,16);
			Reposition();// TODO Auto-generated constructor stub
		}
		
			
		boolean isSelected;
		
		/**
		 * 이 네모의 위치를 다시 지정합니다.
		 */
		void Reposition() {
			pos_x = Reposition_X;
			pos_y = rand.nextDouble() * (Reposition_Y_max - Reposition_Y_min) + Reposition_Y_min;
			pos_z = rand.nextDouble() * (Reposition_Z_max - Reposition_Z_min) + Reposition_Z_min;
			
			isSelected = false;
			
			image = images.GetImage("rect_normal");
		}
	}

	/*
	 * Rect 인스턴스들을 여러 개, 순서대로 담아 두기 위해
	 * ArrayList<Rect> '형식'을 사용할 수 있어요.
	 */
	ArrayList<Rect> rects;
	
	Viewport viewport;
	
	public SampleFrame1_ArrayList(GameFrameSettings settings) {
		super(settings);
	}

	@Override
	public boolean Initialize() {
		/*
		 * 1x1픽셀짜리 단색 그림을 직접 만들어 사용할 수 있어요.
		 * 초기 버전 만들 때는 단색 그림을 사용하다가 나중에 최종 버전 만들 때 따로 준비한 그림을 사용하도록 구성해도 돼요. 
		 */
		images.CreateTempImage(Color.black, "rect_normal");
		images.CreateTempImage(Color.blue, "rect_selected");

		
		rand = new Random();

		rects = new ArrayList<>();
		
		// 원근감을 어느 정도 활용하고 싶을 때는 '화면 전체를 차지하는 Viewport'를 하나 만들어 둔 다음 진행하는 것을 추천해요 
		viewport = new Viewport(0, 0, settings.canvas_width, settings.canvas_height);
		
		/*
		 * Java의 for문은 Python의 for문과는 조금 다르게 생겼고,
		 * C의 for문과는 매우 비슷하게 생겼어요.
		 * 
		 * 여기서는 새 Rect 인스턴스 100개를 만들어서
		 * rects와 viewport에 추가해 두고 있어요.
		 * 
		 * - new 수식의 생김새를 보니,
		 *   위에다 적어 둔 생성자 정의 내용물을
		 *   new 수식을 계산할 때마다 한 번씩 실행해줄 것 같아요 -> 맞음
		 */ 
		for (int count = 0; count < 100; count++) {
			Rect newRect = new Rect();
			
			rects.add(newRect);
			viewport.children.add(newRect);
		}
		
		return true;
	}

	@Override
	public boolean Update(long timeStamp) {
		inputs.AcceptInputs();
		
		/*
		 * Viewport.HitTest()를 통해,
		 * 특정 좌표에 요소(지금은 네모)가 하나라도 존재하는지 여부를 확인할 수 있어요.
		 */
		if ( viewport.HitTest(inputs.pos_mouseCursor) ) {
			
			// Viewport.GetObjectAt()은 해당 좌표에 있는 요소를 return해요. 만약 그런 요소가 없다면 null 을 return해요. 
			Rect rect_selected = (Rect)viewport.GetObjectAt(inputs.pos_mouseCursor);
			
			if ( rect_selected.isSelected == false ) {
				rect_selected.isSelected = true;
				rect_selected.image = images.GetImage("rect_selected");
			}
		}
		
		/*
		 * 이 아래에 적혀 있는 것은 Java의 'foreach문'이에요.
		 * 실행 양상은 Python의 for문과 비슷해요.
		 * 
		 * - 여기서는 rects에 담아 둔 Rect 인스턴스들을
		 *   하나씩 가져와서 새 이름 rect에 담고,
		 *   그렇게 담는 데에 성공할 때마다 내용물 문장들을 한 번씩 실행해요   
		 */
		for (Rect rect : rects) {
			if ( rect.isSelected ) {
				rect.pos_x += Velocity_Selected_X;
			}
			else {
				rect.pos_x += Velocity_Normal_X;
			}
			
			if ( rect.pos_x >= Pos_Vanish_X ) {
				rect.Reposition();
			}
		}
		
		return true;
	}

	@Override
	public void Draw(long timeStamp) {
		BeginDraw();
		ClearScreen();
		
		// Tutorial에서 확인해 보았듯, Viewport를 사용하면 Draw() 내용물을 간단하게 적어둘 수 있어서 편해요.
		viewport.Draw(g);
		
		EndDraw();
	}

}
