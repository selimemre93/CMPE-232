package selim;
public class RodCutting { 

	public static int RodCut(int[] value, int length) {
		int[] fix = new int[length + 1];
		fix[0] = 0;

		for (int i = 1; i <= length; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, value[j] + fix[i - (j + 1)]);
				fix[i] = max;
			}
		}
		return fix[length];
	}

	public static void main(String[] args) {
		int[] value = {1, 5, 8, 9}; // length for 1,2,3,4
		int len = 4;
		System.out.println("Max profit for length is " + len + ":"+ RodCut(value, len));

	}
	
	
}
