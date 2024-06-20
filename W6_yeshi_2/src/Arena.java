
public class Arena {
	
	// TODO 여기에 '파란 주석'을 적어 볼 예정
	/**
	 * 
	 * @param lhs 왼쪽 캐릭터입니다.-먼저 공격합니다
	 * @param rhs 오른쪽 캐릭터입니다.
	 * @return 대결 결과를 return합니다.
	 */
	
	 static int Duel(Character lhs, Character rhs)
	{
		int hp_lhs;
		int hp_rhs;
		
		// 대결 시작
		hp_lhs = lhs.max_hp;
		hp_rhs = rhs.max_hp;
		
		
		while ( true ) {
			int dmg;
			
			// 왼쪽 캐릭터의 공격
			dmg = lhs.atk - rhs.def;
			
			System.out.println(lhs.name + "의 공격!");
			try {
				Thread.sleep(500);//스테틱 메서드 이름, 500밀로(=0.5초) 초 동안 중단
			} catch (InterruptedException e) {
			}
			
			if ( dmg >= hp_rhs )
			{
				System.out.println(lhs.name + ": " + lhs.text_last_blow);
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
			dmg = rhs.atk - lhs.def;
			
			System.out.println(rhs.name + "의 공격!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			
			if ( dmg >= hp_lhs )
			{
				System.out.println(rhs.name + ": " + rhs.text_last_blow);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}

				hp_lhs = hp_lhs - dmg;
				System.out.println(lhs.name + "에게 " + dmg + "만큼의 피해를 입혔습니다. 남은 체력: " + hp_lhs);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				
				System.out.println(lhs.name + ": " + lhs.text_last_blow_taken);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				
				return 1;
			}

			hp_lhs = hp_lhs - dmg;
			System.out.println(lhs.name + "에게 " + dmg + "만큼의 피해를 입혔습니다. 남은 체력: " + hp_lhs);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
