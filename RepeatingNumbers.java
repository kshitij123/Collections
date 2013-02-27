package Number;

import java.util.Scanner;

public class RepeatingNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String list = in.nextLine();

		String s[] = list.split(" ");
		int a[] = new int[100];

		for (int i = 0; i < s.length; i++) {
			a[i] = Integer.parseInt(s[i]);
		}

		getRepeatingNum(a, s.length);

	}// main method

	private static void getRepeatingNum(int[] a, int size) {

		int res1 = 0, res2 = 0;

		for (int i = 1; i <=size - 2; i++) {
			res1 ^= i;
		}

		for (int i = 0; i < size; i++)
			res2 ^= a[i];

		double rightMostBit = getRightmostBit(res1 ^ res2);

		System.out.println(" rightMostBit = "+rightMostBit);
		
		int l = 0;
		int x = 0, y = 0;

		while (l < size) {

			if (getRightmostBit(a[l]) == rightMostBit)
				x = x ^ a[l];
			else
				y = y ^ a[l];

			l++;
		}		
		

		l = 1;

		while (l <=size-2) {

			if (getRightmostBit(l) == rightMostBit)
				x = x ^ l;
			else
				y = y ^ l;

			l++;
		}
		
		System.out.println(" X = "+x);
		System.out.println(" Y = "+y);

	}// Method ends here

	public static double getRightmostBit(int n) {

		double k = -n & n;
		System.out.println(" k = "+k+" n = "+n);
		return Math.log10(k) / Math.log10(2);

	}

}// class ends here
