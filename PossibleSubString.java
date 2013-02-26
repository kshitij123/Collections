package String;

import java.util.ArrayList;
import java.util.Scanner;

public class PossibleSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String mstr = in.nextLine();
		
		ArrayList<Character> mst = new ArrayList<Character>();
		
		for (int i = 0; i < mstr.length(); i++) {
			mst.add(mstr.charAt(i));
		}
		
		mst.add('0');
		
		System.out.println("min string length = "
				+ getTotalPossiblities(mst));

	}// main method ends here

	private static int getTotalPossiblities(ArrayList<Character> mst) {
		
		int flip1=0, start=0,res=0, en=0,st=0;
		char a1=0,b1=0, pre=0;
				
		for(int i=0; i<mst.size(); i++){
						
			if(a1==0){
				a1=mst.get(i);
			}// if ends here
			
			if(b1==0 && a1!=mst.get(i)){
				b1=mst.get(i);
			}// if ends
						
			
			if(mst.get(i)!=a1 && mst.get(i)!=b1){
								
				res+=getCount(i-start);
				
				if((en-st)>0)
				res=res-getCount(en-st);			
				start=flip1;
				a1=mst.get(i-1);
				b1=mst.get(i);
				st=flip1;
				en=i;
			}// if ends here
			
			if(pre!=mst.get(i)){
				flip1=i;
			}				
				
			pre = mst.get(i);
		}// for loop ends here
				
		return res;
	}
	
	public static int getCount(int n){
		
		return n*(n+1)/2;
	}

}// class ends here
