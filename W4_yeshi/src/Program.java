import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// 아래에서 사용할 이름들에 대한 선언들
		Scanner scanner = new Scanner(System.in);
		int input;
		int absoluteNumberOfInput;
		int nextEvenNumberOfInput;
		
		// 프로그램 밖에서 Data 획득해 오기
		System.out.print("숫자를 입력하세요>");
		input = scanner.nextInt();
		
		// Data 조합하기
		
		// 목표: input 값에 대한 절대값을 absoluteNumberOfInput 자리에 담기 
		absoluteNumberOfInput = GetAbsoluteNumber(input);
		
		// 목표: input 값보다 크거나 같은 가장 작은 짝수를 nextEvenNumberOfInput 자리에 담기
		// TODO 같이 한 번 시도해 볼께요. 지금은 오류 방지를 위해 임시로 이렇게 적어 놨어요.
		nextEvenNumberOfInput = 0;
		if (input%2==1)//input%2와 같이 true false로 조건문을 사용하는 것 불가능
		{
			//nENOI와 같은 방식으로 cntrl+space바와 같은 자동 완성이 가능함
			nextEvenNumberOfInput=input+1;
		}
		else
		{
			nextEvenNumberOfInput=input;
		}
		// 조합한 Data를 토대로 프로그램 밖에 무언가 내보내기
		System.out.println("입력한 숫자에 대한 절대값은 " + absoluteNumberOfInput + "입니다.");
		System.out.println("입력한 숫자보다 크거나 같은 가장 작은 짝수는 " + nextEvenNumberOfInput + "입니다.");
		
		// 마지막 문단속
		scanner.close();
	}

	private static int GetAbsoluteNumber(int input) {
		int absoluteNumberOfInput;
		if ( input < 0 )
		{
			absoluteNumberOfInput = -input;
		}
		else
		{
			absoluteNumberOfInput = +input;
		}
		return absoluteNumberOfInput;
	}//extract method를 사용한 것이다 

}
