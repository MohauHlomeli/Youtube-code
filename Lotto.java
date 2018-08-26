

import java.util.Random;


public class Lotto {
	
	int []numbers = new int[6]; //  array start from element 0 to the defined number
	
	Random randomlotto = new Random();
	
	
	public Lotto(){
		
		System.out.println("Lotto winning numbers");
		
		for(int i=0;i<numbers.length;i++){
			
			numbers[i] = randomlotto.nextInt(53);
			if(numbers[i] == 0){
				numbers[i] = numbers[i] + 1;
			}
			
				System.out.print(numbers[i] + "\t");
				
		}
		System.out.println("                            ");
		System.out.println("                            ");
		System.out.println("Bonusball is not requested from the task but we can add the same");
		
	}
	
	public static void main(String[]args){
		
		new Lotto();	
		
	}

}
