import loot.GameFrame;
import loot.GameFrameSettings;
import loot.graphics.Layer;
import loot.graphics.Viewport;

/**
 * 시작 화면이나 성공, 실패 화면을 따로 다루기 위해 Layer를 사용하는 예시입니다.<br>
 * <br>
 * - 이 예시는 본문에 해당하는 내용은 비워 두었어요.<br>
 *   강사와 함께 구경해 보고, 잠시 시간을 들여 이것저것 시도해 보면 좋을 것 같아요.
 */
public class SampleFrame3_Layer extends GameFrame {
	
	Layer layer_startScreen;
	Layer layer_win;
	Layer layer_lose;
	
	Viewport viewport;
	
	public SampleFrame3_Layer(GameFrameSettings settings) {
		super(settings);
	}

	@Override
	public boolean Initialize() {
		// 그림이나 키 입력을 준비하기에 적당한 곳
		
		
		layer_startScreen = new Layer(0, 0, settings.canvas_width, settings.canvas_height);
		// 시작 화면을 구성하기 위한 코드를 적기에 적당한 곳

		layer_win = new Layer(0, 0, settings.canvas_width, settings.canvas_height);
		layer_win.trigger_hide = true; // 프로그램 시작할 때는 성공 화면은 보여주지 않음
		// 성공 화면을 구성하기 위한 코드를 적기에 적당한 곳
		

		layer_lose = new Layer(0, 0, settings.canvas_width, settings.canvas_height);
		layer_lose.trigger_hide = true; // 프로그램 시작할 때는 실패 화면은 보여주지 않음
		// 실패 화면을 구성하기 위한 코드를 적기에 적당한 곳
		
		
		viewport = new Viewport(0, 0, settings.canvas_width, settings.canvas_height);
		viewport.children.add(layer_startScreen);
		viewport.children.add(layer_win);
		viewport.children.add(layer_lose);

		// 본 게임에서 다룰 요소들을 준비하기에 적당한 곳

		return true;
	}

	@Override
	public boolean Update(long timeStamp) {
		inputs.AcceptInputs();
		
		
		
		return true;
	}

	@Override
	public void Draw(long timeStamp) {
		BeginDraw();
		ClearScreen();
		
		viewport.Draw(g);
		
		EndDraw();
	}

}
