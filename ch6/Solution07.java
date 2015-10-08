package cc666;

import java.util.Random;

public class Solution07 {

	static double nFamily (int n) {
		int boys = 0;
		int girls = 0;
		
		for (int i=0; i<n; i++) {
			
			// every family follows the same rules
			int[] genders = oneFamily();
			girls = girls + genders[0];
			boys = boys + genders[1];
			
		}
		// get the ratio of boys after n generations
		double ratio = boys / (double) (boys + girls);
		return ratio;
	}
	
	
	// every family follows same principle
	static int[] oneFamily() {
		
		Random random = new Random();
		int boys = 0;
		int girls = 0;
		while (girls == 0) {   // we stop until we have a girl
			
			// get a random boolean type, and if it is true, set it to girl, otherwise to boy.
			if (random.nextBoolean()) {  // set it to girl
				System.out.println(random.nextBoolean());
				girls++;
			} else {   // set it to boy
				boys ++;
			}
			
		}
		
		// store girls number in genders[0], boys number in genders[1]
		int[] genders = {girls, boys};
		System.out.print(girls+"  ");
		System.out.print(boys);
		return genders;
		
	}
	
	public static void main(String[] args) {
		int generation = 5;
		double result = nFamily(generation);
		System.out.println(result);
		

	}

}
