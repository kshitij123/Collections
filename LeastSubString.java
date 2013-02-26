/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author kshitij.jain
 * This code finds the small substring in main staring which sontain all characters in given in second string 
 */
public class LeastSubString {

	public static String[] suffix;
	static int[] shouldFind = new int[256];
	static int[] hasFound = new int[256];
	static int start = -1, end = 0, count = 0, minlen = 10000000;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String mstr = in.nextLine();
		String substr = in.nextLine();

		ArrayList<Character> mst = new ArrayList<Character>();
		ArrayList<Character> subst = new ArrayList<Character>();

		for (int i = 0; i < substr.length(); i++) {
			subst.add(substr.charAt(i));
			shouldFind[subst.get(i)] += 1;
		}

		for (int i = 0; i < mstr.length(); i++) {
			mst.add(mstr.charAt(i));
		}

		System.out.println("min string length = "
				+ getStringSizeCount(mst, subst));

	}// main ends

	public static int getStringSizeCount(ArrayList<Character> mst,
			ArrayList<Character> subst) {

		for (int i = 0; i < mst.size(); i++) {

			if (shouldFind[mst.get(i)] == 0) {
				continue;
			}

			count++;

			hasFound[mst.get(i)] += 1;

			if (start == -1) {
				start = i;
			}

			while (hasFound[mst.get(i)] > shouldFind[mst.get(i)]
					|| shouldFind[mst.get(start)] == 0) {

				if (mst.get(start) == mst.get(i)) {
					hasFound[mst.get(i)] -= 1;
					count--;
				}
				else if (shouldFind[mst.get(start)] != 0) {

					if (hasFound[mst.get(start)] > 0)
						hasFound[mst.get(start)] -= 1;
					count--;
				}

				start++;

			}// while loop ends here

			if (count == subst.size()) {

				if (minlen > (i - start + 1)) {
					minlen = i - start + 1;

				}// if ends
			}// if ends

		}// for loop ends here

		return minlen;

	}// Method getStringSizeCount ends here
}// Class ends here
