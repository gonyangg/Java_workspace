import loot.GameFrameSettings;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrameSettings settings = new GameFrameSettings(); 
		/* TODO 여기서 settings. 을 입력하여 게임 화면 관련 설정 가능 */ 
		SampleFrame window = new SampleFrame(settings); // SampleFrame 대신 여러분이 만든 클래스 이름 적어요 
		window.setVisible(true); 
	}

}
