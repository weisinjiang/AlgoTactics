import java.util.*;

class TwoNumberSum {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		
		// After seeing each num, add it to this set
		Set<Integer> seen = new HashSet<>();
		
		for(int number: array) {
			/* 
				Find difference and check if it is in the seen set 
			 	The difference must be in the seen set because it needs to be
			 	from the same array.
			*/
			int diff  = targetSum - number;
			if (seen.contains(diff)) {
				return new int[]{number, diff};
			}
			else {
				seen.add(number);
			}
		}
		// If at the end and no matches were found, return an empty array
		return new int[]{};
  }
}

