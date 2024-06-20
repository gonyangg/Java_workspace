import java.awt.Color;
import java.awt.event.KeyEvent;

import loot.GameFrame;
import loot.GameFrameSettings;
import loot.graphics.DrawableObject3D;
import loot.graphics.Viewport;

/**
 * Viewport의 'Point of View'를 변경함으로써 일종의 '카메라'를 조작할 수 있어요.<br>
 * 여기서는 직접 키보드를 사용하여 카메라의 위치를 자유롭게 옮겨볼 수 있도록 만들어 두었어요.<br>
 * <br>
 *  W                              <br>
 * ASD   - 카메라를 x축, y축 방향으로 이동<br>
 * Q, E  - 카메라를 z축 방향으로 이동    <br>
 * Shift - 누르고 있는 동안 더 빠르게 이동<br>
 * Ctrl  - 누르고 있는 동안 더 느리게 이동<br>
 * <br>
 * - Initialize() 내용은 불필요하게 복잡하니, Update() 내용물 위주로 구경해 보면 충분할 것 같아요.
 */
public class SampleFrame2_Viewport extends GameFrame {
	
	static final double Max_Pos_X = 800.0;
	static final double Max_Pos_Y = 600.0;
	static final double Max_Pos_Z = 1.0;
	
	static final int Amount_X = 39;
	static final int Amount_Y = 29;
	static final int Amount_Z = 9;
	
	static final double Fill_Rate = 0.2;
	
	static final double Distance_X = Max_Pos_X * 2 / (Amount_X - 1);
	static final double Distance_Y = Max_Pos_Y * 2 / (Amount_Y - 1);
	static final double Distance_Z = Max_Pos_Z * 2 / (Amount_Z - 1);
	
	static final double Radius_X = Distance_X * Fill_Rate / 2.0;
	static final double Radius_Y = Distance_Y * Fill_Rate / 2.0;
	
	static final double Move_Speed_X_Normal = 1.0;
	static final double Move_Speed_X_Fast = 10.0;
	static final double Move_Speed_X_Slow = 0.1;
	static final double Move_Speed_Y_Normal = 1.0;
	static final double Move_Speed_Y_Fast = 10.0;
	static final double Move_Speed_Y_Slow = 0.1;
	static final double Move_Speed_Z_Normal = 0.01;
	static final double Move_Speed_Z_Fast = 0.1;
	static final double Move_Speed_Z_Slow = 0.001;

	Viewport viewport;
	
	public SampleFrame2_Viewport(GameFrameSettings settings) {
		super(settings);
	}

	@Override
	public boolean Initialize() {
		images.CreateTempImage(Color.black, "black");
		
		inputs.BindKey(KeyEvent.VK_W, 0);
		inputs.BindKey(KeyEvent.VK_A, 1);
		inputs.BindKey(KeyEvent.VK_S, 2);
		inputs.BindKey(KeyEvent.VK_D, 3);
		inputs.BindKey(KeyEvent.VK_Q, 4);
		inputs.BindKey(KeyEvent.VK_E, 5);
		inputs.BindKey(KeyEvent.VK_SHIFT, 6);
		inputs.BindKey(KeyEvent.VK_CONTROL, 7);
		
		viewport = new Viewport(0, 0, settings.canvas_width, settings.canvas_height);
		
		// viewport로 다루는 3D 공간 안에 일정 간격마다 DO3D 인스턴스 배치
		for ( double pos_z = 0.0; pos_z <= Max_Pos_Z; ) {
			for ( double pos_y = 0.0; pos_y <= Max_Pos_Y; ) {
				for ( double pos_x = 0.0; pos_x <= Max_Pos_X; ) {
					viewport.children.add(new DrawableObject3D(pos_x, pos_y, pos_z, Radius_X, Radius_Y, images.GetImage("black")));
					
					if ( pos_x > 0 ) {
						pos_x *= -1;
					}
					else {
						pos_x = -pos_x + Distance_X;
					}
				}
				
				if ( pos_y > 0 ) {
					pos_y *= -1;
				}
				else {
					pos_y = -pos_y + Distance_Y;
				}
			}
			
			if ( pos_z > 0 ) {
				pos_z *= -1;
			}
			else {
				pos_z = -pos_z + Distance_Z;
			}
		}
		
		
		return true;
	}

	@Override
	public boolean Update(long timeStamp) {
		inputs.AcceptInputs();
		
		// W
		if (inputs.buttons[0].isPressed) {
			if (inputs.buttons[6].isPressed && inputs.buttons[7].isPressed == false) {
				// viewport.pointOfView_x, y, z 값을 변경함으로써 카메라의 위치를 바꿀 수 있어요
				viewport.pointOfView_y += Move_Speed_Y_Fast;
			}
			else if (inputs.buttons[6].isPressed == false && inputs.buttons[7].isPressed) {
				viewport.pointOfView_y += Move_Speed_Y_Slow;
			}
			else {
				viewport.pointOfView_y += Move_Speed_Y_Normal;
			}
		}
		
		// A
		if (inputs.buttons[1].isPressed) {
			if (inputs.buttons[6].isPressed && inputs.buttons[7].isPressed == false) {
				viewport.pointOfView_x -= Move_Speed_X_Fast;
			}
			else if (inputs.buttons[6].isPressed == false && inputs.buttons[7].isPressed) {
				viewport.pointOfView_x -= Move_Speed_X_Slow;
			}
			else {
				viewport.pointOfView_x -= Move_Speed_X_Normal;
			}
		}
		
		// S
		if (inputs.buttons[2].isPressed) {
			if (inputs.buttons[6].isPressed && inputs.buttons[7].isPressed == false) {
				viewport.pointOfView_y -= Move_Speed_Y_Fast;
			}
			else if (inputs.buttons[6].isPressed == false && inputs.buttons[7].isPressed) {
				viewport.pointOfView_y -= Move_Speed_Y_Slow;
			}
			else {
				viewport.pointOfView_y -= Move_Speed_Y_Normal;
			}
		}

		// D
		if (inputs.buttons[3].isPressed) {
			if (inputs.buttons[6].isPressed && inputs.buttons[7].isPressed == false) {
				viewport.pointOfView_x += Move_Speed_X_Fast;
			}
			else if (inputs.buttons[6].isPressed == false && inputs.buttons[7].isPressed) {
				viewport.pointOfView_x += Move_Speed_X_Slow;
			}
			else {
				viewport.pointOfView_x += Move_Speed_X_Normal;
			}
		}
		
		// Q
		if (inputs.buttons[4].isPressed) {
			if (inputs.buttons[6].isPressed && inputs.buttons[7].isPressed == false) {
				viewport.pointOfView_z -= Move_Speed_Z_Fast;
			}
			else if (inputs.buttons[6].isPressed == false && inputs.buttons[7].isPressed) {
				viewport.pointOfView_z -= Move_Speed_Z_Slow;
			}
			else {
				viewport.pointOfView_z -= Move_Speed_Z_Normal;
			}
		}
		
		// E
		if (inputs.buttons[5].isPressed) {
			if (inputs.buttons[6].isPressed && inputs.buttons[7].isPressed == false) {
				viewport.pointOfView_z += Move_Speed_Z_Fast;
			}
			else if (inputs.buttons[6].isPressed == false && inputs.buttons[7].isPressed) {
				viewport.pointOfView_z += Move_Speed_Z_Slow;
			}
			else {
				viewport.pointOfView_z += Move_Speed_Z_Normal;
			}
		}
		
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
