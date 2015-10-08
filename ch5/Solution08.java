package cc555;

public class Solution08 {
	
	static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		
		
		/* we first set the full bytes position by setting screen[] = 0xff
		 * then we set the other bytes by using the mask
		 * 
		 */
		int start_mod = x1 % 8;
		int end_mod = x2 % 8;
		int first_fullbyte = x1 / 8;
		int last_fullbyte = x2 / 8;
		
		// if start_mod != 0 then first full byte should plus one
		if (start_mod != 0) first_fullbyte++;
		
		// if end_mod != 7 then last full byte should minus one
		if (end_mod != 7) last_fullbyte--;
		
		// set full byte
		for (int i=first_fullbyte; i<=last_fullbyte; i++) {
			screen[(width / 8) * y + i] = (byte)0xff;    // 0xff: 11111111
		
		}
		
		// build mask
		byte start_mask = (byte)(0xff >> start_mod);
		byte end_mask = (byte)~(0xff >> (end_mod + 1));
		
		// set mask
		
		// if x1 and x2 are in the same byte
		if ((x1 / 8) == (x2 / 8)) {
			
			screen[(width / 8) * y + (x1 / 8)] |= (byte)(start_mask & end_mask);
			
		} else {
			
			if (start_mod != 0) {
				screen[(width / 8) * y + first_fullbyte - 1] |= start_mask;
			} 
			if (end_mod != 7) {
				screen[(width / 8) * y + last_fullbyte + 1] |= end_mask;
			}
		}
	}
		
		
	public static void main(String[] args) {
		
		byte[] screen = {0, 0, 0, 0};
		int width = 16;
		int x1 = 1;
		int x2 = 8;
		int y = 1;
		
		drawLine(screen, width, x1, x2, y);
		
		for (int i=0; i<screen.length; i++) {
			
			for (int k=0; k<8; k++) {
				int r = (screen[i] & 0x80) >> 7;
				System.out.print(r);
				screen[i] = (byte)(screen[i] << 1);
				
			}
			
			if ((i+1) % (width / 8) == 0) {
				System.out.println("");
			}
		}
		
		

	}

}
