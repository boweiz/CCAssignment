package ccc10;

public class Solution03 {

	static int searchRotatedArr (int[] arr) {
		
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (low <= high) {
			
			// when arr[low] <= arr[high] means the array is in correct order
			if (arr[low] <= arr[high]) return low;
			mid = (low + high) / 2;
			
			if (arr[mid] > arr[low]) {
				low = mid + 1;
			} else if (arr[mid] < arr[high]) {
				high = mid;
			}
			
		}
		
		return Integer.MAX_VALUE;    // means error;
		
		
	}
	public static void main(String[] args) {
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int result = searchRotatedArr(arr);
		System.out.println(result);

	}

}
