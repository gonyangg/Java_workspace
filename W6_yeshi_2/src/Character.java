
/**
 * 캐릭터 한 명 한 명에 대한 정보를 담기 위한 클래스입니다.
 */
public class Character {
	
	/**
	 * 캐릭터의 이름입니다.
	 */
	String name;
	
	/**
	 * 캐릭터의 공격력입니다.
	 */
	int atk;
	
	/**
	 * 캐릭터의 방어력입니다.
	 */
	int def;
	
	/**
	 * 캐릭터의 최대 체력입니다.
	 */
	int max_hp;
	
	/**
	 * 마무리 일격을 가할 때 출력할 멘트입니다. 
	 */
	String text_last_blow;
	
	/**
	 * 상대의 마무리 일격을 받을 때 출력할 멘트입니다.
	 */
	String text_last_blow_taken;
	int Duel(Character rhs)
	{
			int hp_;
			int hp_rhs;
			
			// 대결 시작
			hp_ = max_hp;
			hp_rhs = rhs.max_hp;
			
			
			while ( true ) {
				int dmg;
				
				// 왼쪽 캐릭터의 공격
				dmg = atk - rhs.def;
				
				System.out.println(name + "의 공격!");
				try {
					Thread.sleep(500);//스테틱 메서드 이름, 500밀로(=0.5초) 초 동안 중단
				} catch (InterruptedException e) {
				}
				
				if ( dmg >= hp_rhs )
				{
					System.out.println(name + ": " + text_last_blow);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}

					hp_rhs = hp_rhs - dmg;
					System.out.println(rhs.name + "에게 " + dmg + "만큼의 피해를 입혔습니다. 남은 체력: " + hp_rhs);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
					
					System.out.println(rhs.name + ": " + rhs.text_last_blow_taken);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					
					return -1;
				}

				hp_rhs = hp_rhs - dmg;
				System.out.println(rhs.name + "에게 " + dmg + "만큼의 피해를 입혔습니다. 남은 체력: " + hp_rhs);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				
				
				// 오른쪽 캐릭터의 공격
				dmg = rhs.atk - def;
				
				System.out.println(rhs.name + "의 공격!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				
				if ( dmg >= hp_ )
				{
					System.out.println(rhs.name + ": " + rhs.text_last_blow);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}

					hp_ = hp_ - dmg;
					System.out.println(name + "에게 " + dmg + "만큼의 피해를 입혔습니다. 남은 체력: " + hp_);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
					
					System.out.println(name + ": " + text_last_blow_taken);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					
					return 1;
				}

				hp_ = hp_ - dmg;
				System.out.println(name + "에게 " + dmg + "만큼의 피해를 입혔습니다. 남은 체력: " + hp_);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}

	 
}
