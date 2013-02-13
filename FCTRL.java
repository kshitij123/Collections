import java.util.Scanner;

class FCTRL {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        while (cases != 0) {

            System.out.println("" + getZeros(in.nextInt()));

            cases--;
        }

    }// main ends here

    private static int getZeros(int nextInt) {

        int trail = 0;

        for (int i = 5; i <= nextInt; i *= 5) {

            trail += nextInt / i;

        }
        return trail;
    }
}// class ends here

