
public class Program
{
	// TODO 여기에 static 필드 선언을 적을 예정
	
	public static void main(String[] args)
	{
		/**
		 * 얘는 '필드'가 아니에요. Program 소속 내지는 Program.main 소속도 아니에요. - 마우스 갖다 대 봐요
		 */
		int number;
		
		number = 3;
		
		System.out.println(number);
		
		
		// TODO 여기에 수식문을 몇 개 적어볼 예정
		MyClass2.number=3;
		MyClass2.PrintNumber();//소속 관계 명시해서 작성하기 성공
		//MyClass2=mc2;
		//mc2.number=3;로 static field 이름을 쓸 필요가 없다.
		
		MyClass mc=new MyClass();
		
		mc.number=3;//계산하면 MyClass 형식이 나오는 수식
		mc.PrintNumber();
	}
}
