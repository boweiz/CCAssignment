package cc333;

public class Solution01 {
	
	public static class array3Stack {
		
	int oneSize = 3;
	int[] buf =new int[oneSize * 3];
    // initial the top of each stack's value with -1, 
	int[] stackNum = {-1, -1, -1};
	
	
	void push(int index, int number) throws Exception {
		if (stackNum[index] >= oneSize - 1) {
			throw new Exception( " stack is out of room");
		}
		
		else { 
// System.out.println("push"+index);
			stackNum[index]++;
			buf[index * oneSize + stackNum[index]] = number;
		}
				
	}
	
	int pop(int index) throws Exception {
		
		if (stackNum[index] == -1) {
			throw new Exception( " stack is empty");
		}
		
		else { 
// System.out.println("pop"+index);
			return buf[index * oneSize + stackNum[index]--];			
		}
	
	}
	
	int peek(int index) throws Exception{
	// when we get the -1, the stack is empty	
		if (stackNum[index] == -1) {
			throw new Exception( " stack is empty");
		}
		
		else { 		
			return buf[index * oneSize + stackNum[index]];
		}

	}
	}
	
	public static void main(String[] args)  {
	
		array3Stack arr = new array3Stack();
		
		try {
			arr.push(2, 99);
			arr.push(2, 11);
			arr.push(1,123);
			arr.push(1, 77);
		  	arr.pop(2);
		  	System.out.println(arr.pop(1));
		  	System.out.println(arr.pop(1));
		  	System.out.println(arr.pop(2));
		  	System.out.println(arr.pop(2));

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		

	}
}
