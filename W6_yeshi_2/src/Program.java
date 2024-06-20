
public class Program {

	public static void main(String[] args) {
		Character me;// 캐릭터, 경기장 데이터를 다루기 위한 각각의 이름 도입
		Character you;
		Arena arena;
		
		
		me = new Character();//이름에 새로운 캐릭터, 새로운 경기장을 만들어 담는다
		you = new Character();//new는 새로운 인스턴스를 구성하고 수식을 계산하면서 얻은
		//특정 가능한 값을 Data이름 you에 담는다
		arena = new Arena();
		
		
		// TODO '내 캐릭터'에 대한 Data를 자유롭게 지정해 주세요		
		me.name = "우짤램";//"우짤램"은 string 형식 인스턴스에 담기고 그 인스턴스의 자리값이 name에 담긴다.
		me.atk = 10;//해당 인스턴스가 포함된 nonstatic field atk자리를 특정할 수 있다.
		me.def = 5;
		me.max_hp = 540;
		me.text_last_blow = "알빠누";
		me.text_last_blow_taken = "개낑받누";
		
		you.name = "마스터 이";
		you.atk = 20;
		you.def = 0;
		you.max_hp = 40;
		you.text_last_blow = "C 뿌리기";
		you.text_last_blow_taken = "A+은 나야 둘이 될 수 없어";
		
				
		//Arena.Duel(me, you);
		me.Duel(you);
		// TODO 여기에 실제 대결을 수행하기 위한 코드를 적을 예정이에요
	}

}
