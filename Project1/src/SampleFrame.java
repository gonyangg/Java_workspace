import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import loot.GameFrame;
import loot.GameFrameSettings;
import loot.graphics.DrawableObject;
import loot.graphics.DrawableObject3D;
import loot.graphics.TextBox;
import loot.graphics.Viewport;

public class SampleFrame extends GameFrame {
	double coef_tension = 0.06;

	class Origin extends DrawableObject3D {
		public boolean isSelected;

		public Origin() {
			super(0, 0, 0, 50, 50, images.GetImage("origin"));
		}
	}
	
	class After1 extends DrawableObject3D {
		public boolean isSelected;

		public After1() {
			super(0, 0, 0, 50, 50, images.GetImage("first"));
		}
	}
	
	class After2 extends DrawableObject3D {
		public boolean isSelected;

		public After2() {
			super(0, 0, 0, 50, 50, images.GetImage("second"));
		}
	}
	
	class After3 extends DrawableObject3D {
		public boolean isSelected;

		public After3() {
			super(0, 0, 0, 50, 50, images.GetImage("third"));
		}
	}
	
	class After4 extends DrawableObject3D {
		public boolean isSelected;

		public After4() {
			super(0, 0, 0, 50, 50, images.GetImage("fourth"));
		}
	}
	
	class Half extends DrawableObject3D {
		public boolean isSelected;

		public Half() {
			super(0, 0, 0, 50, 50, images.GetImage("half"));
		}
	}

	class Final extends DrawableObject3D {
		public boolean isSelected;

		public Final() {
			super(0, 0, 0, 50, 50, images.GetImage("fin"));
		}

	}
	
	class Clear extends DrawableObject3D {
		public boolean isSelected;

		public Clear() {
			super(0, 0, 0,800, 600, images.GetImage("clear"));
		}

	}
	
	class Fail extends DrawableObject3D {
		public boolean isSelected;

		public Fail() {
			super(0, 0, 0, 800, 600, images.GetImage("fail"));
		}

	}

	TextBox tb_physics;
	Random rand;

	class MyObject extends DrawableObject3D // 여기서도 역시 Ctrl + Space
	{
		double vel_x, vel_y, vel_z; // 원래 있던 pos_x, pos_y는 지웁니다.
		double acc_x, acc_y, acc_z;
		private Random rand;

		public MyObject() {
			super(0, 0, 200, 50, 50, images.GetImage("img"));
			this.rand = new Random();
			vel_x = rand.nextInt(30)+15.5;
			vel_y = rand.nextInt(30)+15.5;
		}
	}
	



	boolean isSelected;
	MyObject myObject1;
	MyObject myObject2;
	MyObject myObject3;
	MyObject myObject4;
	MyObject myObject5;
	MyObject myObject6;
	MyObject myObject7;
	MyObject myObject8;
	Origin origin;
	After1 first;
	After2 second;
	After3 third;
	After4 fourth;
	Half half;
	Final fin;
	Clear clear;
	Fail fail;
	Viewport viewport;
	Viewport viewport1;
	Viewport viewport2;
	int bullet = 2;
	int knife = 5;
	int life=5;
	int refil_knife=1;
	int refil_bullet=1;
	/**
	 * 0: 둘 다 아님
	 * 1: bullet
	 * 2: knife
	 */
	int attack=0;

	public SampleFrame(GameFrameSettings settings) {
		super(settings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Initialize() {
		// TODO Auto-generated method stub

		images.LoadImage("Images/gaurd.png", "img");
		images.LoadImage("Images/watermelon.png", "origin");
		images.LoadImage("Images/1-5watermelon.png", "first");
		images.LoadImage("Images/2-5watermelon.png", "second");
		images.LoadImage("Images/3-5watermelon.png", "third");
		images.LoadImage("Images/4-5watermelon.png", "fourth");
		images.LoadImage("Images/1-2watermelon.png", "half");
		images.LoadImage("Images/broken_watermelon.png", "fin");
		images.LoadImage("Images/clear.png", "clear");
		images.LoadImage("Images/fail.png", "fail");

		myObject1 = new MyObject();
		myObject2 = new MyObject();
		myObject3 = new MyObject();
		myObject4 = new MyObject();
		myObject5 = new MyObject();
		myObject6 = new MyObject();
		myObject7 = new MyObject();
		myObject8 = new MyObject();
		origin = new Origin();
		tb_physics = new TextBox(10, 10, 200, 70);
		viewport = new Viewport(0, 0, settings.canvas_width, settings.canvas_height);
		viewport1 = new Viewport(0, 0, settings.canvas_width, settings.canvas_height);
		viewport2 = new Viewport(0, 0, settings.canvas_width, settings.canvas_height);

		viewport.children.add(myObject1);
		viewport.children.add(myObject2);
		viewport.children.add(myObject3);
		viewport.children.add(myObject4);
		viewport.children.add(myObject5);
		viewport.children.add(myObject6);
		viewport.children.add(myObject7);
		viewport.children.add(myObject8);
		viewport.children.add(origin);
		viewport.children.add(tb_physics);
		
		DrawableObject obj_clear = new DrawableObject(0, 0, settings.canvas_width, settings.canvas_height, images.GetImage("clear"));
		viewport1.children.add(obj_clear);
		DrawableObject obj_fail = new DrawableObject(0, 0, settings.canvas_width, settings.canvas_height, images.GetImage("fail"));
		viewport2.children.add(obj_fail);

		// '카메라' 설정 부분
		viewport.pointOfView_z = 500;
		viewport.view_baseDistance = 500;
		viewport.view_minDistance = 0.1;
		viewport.view_maxDistance = 1000;
		viewport.view_width = settings.canvas_width;
		viewport.view_height = settings.canvas_height;
		
		viewport1.pointOfView_z = 500;
		viewport1.view_baseDistance = 500;
		viewport1.view_minDistance = 0.1;
		viewport1.view_maxDistance = 1000;
		viewport1.view_width = settings.canvas_width;
		viewport1.view_height = settings.canvas_height;
		
		viewport2.pointOfView_z = 500;
		viewport2.view_baseDistance = 500;
		viewport2.view_minDistance = 0.1;
		viewport2.view_maxDistance = 1000;
		viewport2.view_width = settings.canvas_width;
		viewport2.view_height = settings.canvas_height;

		inputs.BindKey(KeyEvent.VK_H, 0); // 소총 선택
		inputs.BindKey(KeyEvent.VK_J, 1); // 총알 충전
		inputs.BindKey(KeyEvent.VK_K, 2);// 단도 선택
		inputs.BindKey(KeyEvent.VK_L, 3); // 단도 충전
		inputs.BindMouseButton(MouseEvent.BUTTON1, 4);// 쏘기

		return true;

	}

	@Override
	public boolean Update(long timeStamp) {
		// TODO Auto-generated method stub

		inputs.AcceptInputs(); //이제까지 들어온 입력을 가상 버튼에 반영 
		 
		//현재 마우스를 누르고 있다면 원점의 위치를 현재 마우스 포인터의 위치로 설정 
		if ( inputs.buttons[4].IsPressedNow() == true && attack==1 && bullet>0) 
		{ 
			if ( viewport.HitTest(inputs.pos_mouseCursor) ) {
				
				// Viewport.GetObjectAt()은 해당 좌표에 있는 요소를 return해요. 만약 그런 요소가 없다면 null 을 return해요. 
				if(origin == viewport.GetObjectAt(inputs.pos_mouseCursor )){
					life-=3;
					if(life<=0) {
						origin.image = images.GetImage("fin");	
					}
					else if(life<=2) {
						origin.image = images.GetImage("half");
					}
					bullet-=1;
				}
				else {
					bullet-=1;
				}
				
			}
		}
		
		else if ( inputs.buttons[4].IsPressedNow() == true && attack==2 && knife>0) 
		{ 
			if ( viewport.HitTest(inputs.pos_mouseCursor) ) {
				
				// Viewport.GetObjectAt()은 해당 좌표에 있는 요소를 return해요. 만약 그런 요소가 없다면 null 을 return해요. 
				if(origin == viewport.GetObjectAt(inputs.pos_mouseCursor )){
					life-=1;
					
					if(life<=0) {
						origin.image = images.GetImage("fin");	
					}
					else if(life<=1) {
						origin.image = images.GetImage("fourth");
					}
					else if(life<=2) {
						origin.image = images.GetImage("third");
					}
					else if(life<=3) {
						origin.image = images.GetImage("second");
					}
					else if(life<=4) {
						origin.image = images.GetImage("first");
					}
					
					knife-=1;
					
				}
				else {
					knife-=1;
				}
				
			}
		}
		
		 
		//현재 E 키를 누르고 있다면 원점의 위치를 화면 중앙으로 초기화 
		if ( inputs.buttons[0].isPressed == true ) 
		{ 
			attack= 1;	
		} 
		 
		//이번 프레임에 space bar를 누르기 시작했다면 
		//공전 운동을 하는 요소의 물리값을 현재 원점을 기준으로 하는 초기 상태로 재설정 
		if ( inputs.buttons[1].IsPressedNow() == true && bullet==0) 
		{ 
			if(refil_bullet!=0) {
				bullet+=1;
				refil_bullet-=1;
			}
		} 
		
		if ( inputs.buttons[2].IsPressedNow() == true ) 
		{ 
			attack=2;
		} 
		
		if ( inputs.buttons[3].IsPressedNow() == true && knife==0) 
		{ 
			if(refil_knife!=0) {
				knife+=2;
				refil_knife-=1;
			}
		} 
		
		
		
		//물체들 움직임 처리
		myObject1.acc_x = ( origin.pos_x - myObject1.pos_x ) * coef_tension; 
		myObject1.acc_y = ( origin.pos_y - myObject1.pos_y ) * coef_tension; 
		myObject1.acc_z = ( origin.pos_z - myObject1.pos_z ) * coef_tension; 
		 
		myObject1.vel_x += myObject1.acc_x; 
		myObject1.vel_y += myObject1.acc_y; 
		myObject1.vel_z += myObject1.acc_z; 
		 
		myObject1.pos_x += myObject1.vel_x; 
		myObject1.pos_y += myObject1.vel_y; 
		myObject1.pos_z += myObject1.vel_z; 
		
		myObject2.acc_x = ( origin.pos_x - myObject2.pos_x ) * coef_tension; 
		myObject2.acc_y = ( origin.pos_y - myObject2.pos_y ) * coef_tension; 
		myObject2.acc_z = ( origin.pos_z - myObject2.pos_z ) * coef_tension; 
		 
		myObject2.vel_x -= myObject2.acc_x; 
		myObject2.vel_y -= myObject2.acc_y; 
		myObject2.vel_z -= myObject2.acc_z; 
		 
		myObject2.pos_x -= myObject2.vel_x; 
		myObject2.pos_y -= myObject2.vel_y; 
		myObject2.pos_z -= myObject2.vel_z;
		//Object 3
		myObject3.acc_x = ( origin.pos_x - myObject3.pos_x ) * coef_tension; 
		myObject3.acc_y = ( origin.pos_y - myObject3.pos_y ) * coef_tension; 
		myObject3.acc_z = ( origin.pos_z - myObject3.pos_z ) * coef_tension; 
		 
		myObject3.vel_x -= myObject3.acc_x; 
		myObject3.vel_y += myObject3.acc_y; 
		myObject3.vel_z += myObject3.acc_z; 
		 
		myObject3.pos_x -= myObject3.vel_x; 
		myObject3.pos_y += myObject3.vel_y; 
		myObject3.pos_z += myObject3.vel_z;
		// 4
		myObject4.acc_x = ( origin.pos_x - myObject4.pos_x ) * coef_tension; 
		myObject4.acc_y = ( origin.pos_y - myObject4.pos_y ) * coef_tension; 
		myObject4.acc_z = ( origin.pos_z - myObject4.pos_z ) * coef_tension; 
		 
		myObject4.vel_x += myObject4.acc_x; 
		myObject4.vel_y -= myObject4.acc_y; 
		myObject4.vel_z -= myObject4.acc_z; 
		 
		myObject4.pos_x += myObject4.vel_x; 
		myObject4.pos_y -= myObject4.vel_y; 
		myObject4.pos_z -= myObject4.vel_z;
		
		myObject5.acc_x = ( origin.pos_x - myObject5.pos_x ) * coef_tension; 
		myObject5.acc_y = ( origin.pos_y - myObject5.pos_y ) * coef_tension; 
		myObject5.acc_z = ( origin.pos_z - myObject5.pos_z ) * coef_tension; 
		 
		myObject5.vel_x -= myObject5.acc_x; 
		myObject5.vel_y += myObject5.acc_y; 
		myObject5.vel_z -= myObject5.acc_z; 
		 
		myObject5.pos_x -= myObject5.vel_x; 
		myObject5.pos_y += myObject5.vel_y; 
		myObject5.pos_z -= myObject5.vel_z; 
		
		myObject6.acc_x = ( origin.pos_x - myObject6.pos_x ) * coef_tension; 
		myObject6.acc_y = ( origin.pos_y - myObject6.pos_y ) * coef_tension; 
		myObject6.acc_z = ( origin.pos_z - myObject6.pos_z ) * coef_tension; 
		
		myObject6.vel_x += myObject6.acc_x; 
		myObject6.vel_y -= myObject6.acc_y; 
		myObject6.vel_z += myObject6.acc_z; 
		 
		myObject6.pos_x += myObject6.vel_x; 
		myObject6.pos_y -= myObject6.vel_y; 
		myObject6.pos_z += myObject6.vel_z;
		//Object 7
		myObject7.acc_x = ( origin.pos_x - myObject7.pos_x ) * coef_tension; 
		myObject7.acc_y = ( origin.pos_y - myObject7.pos_y ) * coef_tension; 
		myObject7.acc_z = ( origin.pos_z - myObject7.pos_z ) * coef_tension; 
		 
		myObject7.vel_x -= myObject7.acc_x; 
		myObject7.vel_y -= myObject7.acc_y; 
		myObject7.vel_z += myObject7.acc_z; 
		 
		myObject7.pos_x -= myObject7.vel_x; 
		myObject7.pos_y -= myObject7.vel_y; 
		myObject7.pos_z += myObject7.vel_z;
		// 8
		myObject8.acc_x = ( origin.pos_x - myObject8.pos_x ) * coef_tension; 
		myObject8.acc_y = ( origin.pos_y - myObject8.pos_y ) * coef_tension; 
		myObject8.acc_z = ( origin.pos_z - myObject8.pos_z ) * coef_tension; 
		 
		myObject8.vel_x += myObject8.acc_x; 
		myObject8.vel_y += myObject8.acc_y; 
		myObject8.vel_z -= myObject8.acc_z; 
		 
		myObject8.pos_x += myObject8.vel_x; 
		myObject8.pos_y += myObject8.vel_y; 
		myObject8.pos_z -= myObject8.vel_z;
		 
		tb_physics.text = String.format( 
		"bullet: (%d)\nknife: (%d)\nrefil_bullet: (%d)\nrefil_knife: (%d)\nlife: (%d)\n",bullet, knife,refil_bullet, refil_knife, life);
		
		return true;
		}



	@Override
	public void Draw(long timeStamp) {
		// TODO Auto-generated method stub

		BeginDraw();
		
		ClearScreen();
		viewport.Draw(g);
		
		if(life<=0) {
			ClearScreen();
			life=0;
			viewport1.Draw(g);
			EndDraw();
			
		}
		
		else if(refil_knife==0 && refil_bullet==0) {
				if(bullet*3 + knife < life) {
					ClearScreen();
					viewport2.Draw(g);
					EndDraw();
				}
			}
		EndDraw();
		
		
	}

}
