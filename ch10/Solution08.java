package ccc10;


// build a BitSet class
class BitSet {
	
	int[] bitset;
	
	// construction method
	public BitSet(int size) {
		
		bitset = new int[(size >> 5) + 1];	
	}
	
	// getBit method
	boolean getBit(int key) {
		int groupNumber = (key >> 5);  // divide 32
		int modNumber = (key & 0x1F);  // mod 32
		
		// to determine whether this position already be set 1
		return (bitset[groupNumber] & (1 << modNumber)) != 0; 		
	}
	
	// setBit method
	void setBit(int key) {
		int groupNumber = (key >> 5);
		int modNumber = (key & 0x1F);
		
		// set this position's value to 1
		bitset[groupNumber] = bitset[groupNumber] | (1 << modNumber);
	}
	
}

public class Solution08 {

	static void findDuplicates(int[] array) {
		
		BitSet bitset = new BitSet(32000);

		
		for (int i=0; i<array.length; i++) {
			int num = array[i];
			
			// bitset starts at 0
			int num0 = num - 1;
			if (bitset.getBit(num0)) {
				System.out.println(num);

			} else {
				bitset.setBit(num0);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {1, 2, 4, 4, 999, 999, 2, 32000, 32000};
		
		findDuplicates(array);
	}

}
