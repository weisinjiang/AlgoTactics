import java.util.*;

class Program {
  public static int longestPeak(int[] array) {
		
		// need 3 numbers to form a peak
		if (array.length < 3) {
			return 0;
		}
		
		if (array.length == 3) {
			return isPeak(1, array) ? 3 : 0; 
		}
	
    int longestPeak = 0;
		
		// Peak is only possible from index 1 to second to last index
		// or else it will be out of bound
		for(int i = 1; i < array.length-1; i++) {
			if (isPeak(i, array)) {
				
				// 3 bc we checked that i-1, i, i+1 = peak
				int peakLength = 3;
				int left = i-2; // -2 bc we know i-1 forms a peak already
				int right = i+2; // same logic above
				
				// Move the left as much to the left as possible
				// checking that it is decreasing and not out of bound
				// decreasing bc starting from peak and back, it should decrease
				// but reading from right to left = increasing
				while(left > -1 && array[left] < array[left+1]) {
					left--;
					peakLength++;
				}
				
				// Check that the number are decreasing starting at 
				// index+2 because going tom peak and onward it should be decreasing
				while(right < array.length && array[right] < array[right-1]) {
					right++;
					peakLength++;
				}
				
				// if the peakLength of this peak is longer than curr longest, update
				if (longestPeak < peakLength) {
					longestPeak = peakLength;
				}
					
			}
		}
		
		return longestPeak;
		
		
  }
	
	// given an index, check if it is a peak 
	// by checking if the val in array is (index-1) < (index) > (index+1)
	public static boolean isPeak(int index, int[] array) {
		int left = array[index-1];
		int peak = array[index];
		int right = array[index+1];
		// Strictly increasing and the strictly decrease
		return (left < peak && peak > right);
		
	}
}