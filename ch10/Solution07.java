package ccc10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution07 {

	long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
	byte[] bitfield = new byte [(int) (numberOfInts / 8)];
	String filename = 
			
	void findOpenNumber() throws FileNotFoundException {
		
		// read information
		Scanner in = new Scanner(new FileReader(filename));
		while (in.hasNextInt()) {
			int n = in.nextInt ();
			
			// we use byte[], try to locate the position 
			bitfield [n / 8] |= (1 << (n % 8));
			
		}
		
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
				
			}
			
		}	
	}
	

}

// refer to the solution of CC150