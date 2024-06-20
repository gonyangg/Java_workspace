import java.util.Scanner;//기본적인 소속관계 작성
//cntrl+space 바를 통한 import문, import 문은  실행의 대상이 아니다

public class Program {

	// 여기서 정한 새 이름 number는 Program 소속 이름이에요(마우스 포인터 갖다 대 봐요)
	static int number;
	

	// 여기서 정한 새 이름 main은 Program 소속 이름이에요(마우스 포인터 갖다 대 봐요)
	public static void main(String[] args)
	{
		number = 3;
		
		System.out.println("number 자리에 담긴 값은 " + number + "입니다.");
		
		// TODO 여기에 . 연산자 곁들인 수식(수식문)들을 몇 개 적어보려고 해요
		double number=3.0;
		int result;
		result=(int)(number+ 5);
		System.out.println //코드 뒤에 점 작성 불가
		Program.number.//primitive 형식의 이름은 아무 관계가 없음
		"Hello".//수식에 점을 찍어서 
	}
	

	// 여기서 정한 새 이름 Inner는 Program 소속 이름이에요(마우스 포인터 갖다 대 봐요)
	static class Inner
	{
		// 여기서 정한 새 이름 text는 Inner 소속 이름이고, 따라서 Program 소속 이름이기도 해요. 
		static String text;
		
		// 여기서 정한 새 이름 SetAndPrintAndReturnText는 Inner 소속 이름이고, 따라서 Program 소속 이름이기도 해요.
		static String SetAndPrintAndReturnText(String text)
		{
			Inner.text = text;
			
			System.out.println("text 자리에 담긴 값은 " + text + "입니다.");
			
			return Program.Inner.text;
		}
	}
}
