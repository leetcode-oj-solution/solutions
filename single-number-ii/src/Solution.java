/*
 we use one to track those 1 digits occur once
 we use two to track those 1 digits occur twice
 we use reset to track those 1 digits occur three times
 and when three times, we reset
 
 one two a | one two rest
  0   0  0 |  0   0   1
  0   0  1 |  1   0   1
  0   1  0 |  0   1   1
  0   1  1 |  1   1   0
  1   0  0 |  1   0   1
  1   0  1 |  0   1   1
 
 from the above table, we know
 one = one ^ a
 two = two | (one & a)
 reset = ~(one & two)
 
 and we use the following to reset
 one = one & reset
 two = two & reset
 */
public class Solution {
	public int singleNumber(int[] A) {
		int one = 0, two = 0, reset = 0;
		for (int a: A) {
			two |= one & a;
			one ^= a;
			reset = ~(one & two);
			// now let's reset
			one &= reset;
			two &= reset;
		}
		return one;
	}
}
