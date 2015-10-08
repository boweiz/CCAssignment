package cc666;

import java.util.ArrayList;

public class Solution10 {
	
	// the main function to find a positive bottle
	int findPbottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		runTests(bottles, strips);
		ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
		return setBits(positive);	
		
	}
	
	// add bottle contents to test strips
	void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
		for (Bottle bottle: bottles) {
			int id = bottle.getId();
			int bitIndex = 0;
			while (id > 0) {
				if ((id & 1) == 1) {
					testStrips.get(bitIndex).addDropOnDay(0, bottle);
				}
				bitIndex++;
				id >>= 1;
			}			
		}
		
	}
	
	// get test strips that are positive on a particular day
	ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day) {
		ArrayList<Integer> positive = new ArrayList<Integer>();
		for (TestStrip testStrip: teststrips) {
			int id = testStrip.getId();
			if (testStrip.isPositiveOnDay(day)) {
				positive.add(id);
			}	
		}
		
		return positive;
	}
	
	// create number by setting bits with indices specified in positive
	int setBits(ArrayList<Integer> positive) {
		int id = 0;
		for (Integer bitIndex : positive) {
			id |= 1 << bitIndex;
		}
		return id;
	}
	
	

	public static void main(String[] args) {

	}

}
// refer to cc150