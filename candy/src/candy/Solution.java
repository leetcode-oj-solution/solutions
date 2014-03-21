package candy;

// O(n^2) solution by me
public class Solution {
	public int candy(int[] ratings) {
		int[] candys = new int[ratings.length];
		// initial to be 1
		for (int i = 0; i < candys.length; i++) {
			candys[i] = 1;
		}
		// go through the list until no more change need
		while (true) {
			boolean changed = false;
			for (int i = 0; i < candys.length; i++) {
				// check left rating
				if (i > 0) { // if there is left neighbor
					int leftRating = ratings[i - 1];
					int leftCandy = candys[i - 1];
					if (ratings[i] > leftRating) {
						// rating greater the left neighbor?
						if (candys[i] <= leftCandy) {
							candys[i] = leftCandy + 1;
							changed = true;
						}
					} else if (ratings[i] == leftRating) {
						// rating equals to the left neighbor?
						if (candys[i] < leftCandy) {
							candys[i] = leftCandy;
							changed = true;
						}
					} else {
						// rating lower than left neighbor?
						// nothing need to be done here
					}
				}
				// check right rating
				if (i < candys.length - 1) { // if there is right neighbor
					int rightRating = ratings[i + 1];
					int rightCandy = candys[i + 1];
					if (ratings[i] > rightRating) {
						// rating greater the right neighbor?
						if (candys[i] <= rightCandy) {
							candys[i] = rightCandy + 1;
							changed = true;
						}
					} else if (ratings[i] == rightRating) {
						// rating equals to the right neighbor?
						if (candys[i] < rightCandy) {
							candys[i] = rightCandy;
							changed = true;
						}
					} else {
						// rating lower than right neighbor?
						// nothing need to be done here
					}
				}
			}

			// no more change?
			if (!changed) {
				break;
			}
		}
		// get the sum of final count
		int sum = 0;
		for (int i : candys) {
			sum += i;
		}
		return sum;
	}
}
