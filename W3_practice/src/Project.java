import java.util.Scanner;

public class Project {

	public static void main(String[] args) {
		int numToMistake;
		int num=1;
	
		Scanner scanner=new Scanner(System.in);
		System.out.print("어떤 숫자에서 틀렸으면 좋겠나?>");
		numToMistake=scanner.nextInt();
		scanner.close();
		
		while (num<numToMistake) {
			Say(num);//cntrl+1눌러서 자동완성
			num+=1;
		}
		System.out.println("아.. 뭐였지..");
		
		System.out.println("요시 좋은 승부였네");
	}

	private static void Say(int num) {
		// TODO Auto-generated method stub
		int shipJari =num/10;
		int illJari=num%10;

		
		int numOfClaps=0;
		
		if(shipJari%3==0 && num>9) {
			numOfClaps+=1;
		}
		
		if(illJari%3==0) {
			numOfClaps+=1;
		}
		
		if(numOfClaps>0){
			if(numOfClaps==1) {
				System.out.println("짝");
			}
			if(numOfClaps==2) {
				System.out.println("짝짝");
			}
		}
		
		else {
		  if(shipJari==1) {
			  System.out.print("십");
		  }
		  if(shipJari==2) {
			  System.out.print("이십");
		  }
		  if(shipJari==4) {
			  System.out.print("사십");
		  }
		  if(shipJari==5) {
			  System.out.print("오십");
		  }
		  if(shipJari==7) {
			  System.out.print("칠십");
		  }
		  if(shipJari==8) {
			  System.out.print("팔십");
		  }
		  
		  if(illJari==1) {
			  System.out.print("일");
		  }
		  if(illJari==2) {
			  System.out.print("이");
		  }if(illJari==4) {
			  System.out.print("사");
		  }if(illJari==5) {
			  System.out.print("오");
		  }if(illJari==7) {
			  System.out.print("칠");
		  }if(illJari==8) {
			  System.out.print("팔");
		  }
		  System.out.println();
		}
	}
	
	
	
}
