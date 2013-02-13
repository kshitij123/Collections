import java.util.Scanner;

class ADDREV {

    static StringBuilder s = null;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] s=null;
        String s1 = null;
        int cases = Integer.parseInt(in.nextLine());

        while (cases != 0){
            
            s1 = in.nextLine();
            s=s1.split(" ");
            
            System.out.println(""+(rev(rev(Integer.parseInt(s[0]))+rev(Integer.parseInt(s[1])))));
            cases--;
        }

    }// main ends here

    private static int rev(int number) {

        int res = 0;
        while (number > 0) {
            res = res*10 + number%10;
            number /= 10;
        }
        return res;
    }
}// class ends here

