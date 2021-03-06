package candy;

// O(n) solution
public class Solution2 {
	public int candy(int[] ratings) {
		int[] candys = new int[ratings.length];
		// initial all to 1
		for (int i = 0; i < candys.length; i++) {
			candys[i] = 1;
		}
		// first left to right
		for (int i = 1; i < candys.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candys[i] = candys[i] > candys[i - 1] ? candys[i]
						: candys[i - 1] + 1;
			}
		}
		// then right to left
		for (int i = candys.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candys[i] = candys[i] > candys[i + 1] ? candys[i]
						: candys[i + 1] + 1;
			}
		}
		int sum = 0;
		for (int i : candys) {
			sum += i;
		}
		return sum;
	}
}
