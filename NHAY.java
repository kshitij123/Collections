import java.util.Scanner;

class NHAY {

    private static int[] F;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean a = true;


        while (a) {
            try {
                int n = Integer.parseInt(in.nextLine());
                String P = in.nextLine();
                String T = in.nextLine();
               // char[] t = new char[T.length()];
              //  char[] p = new char[P.length()];

                F = new int[T.length()];

             /*   for (int i = 0; i < T.length(); i++) {
                    t[i] = T.charAt(i);
                }

                for (int i = 0; i < P.length(); i++) {
                    p[i] = P.charAt(i);
                }*/
                
                matchAlgo(T, T.length(), P, P.length());
                System.out.println("");
                
            }catch(NumberFormatException e){
                return;
            }
            catch (Exception e) {
                System.out.println("\n");
            }
        }

    }// main ends here

    public static void PrefixTable(String P, int m) {

        int i = 1, j = 0;
        F[0] = 0;

        while (i < m) {

            if (P.charAt(i) == P.charAt(j)) {
                F[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = F[j - 1];
            } else {
                F[i] = 0;
                i++;
            }

        }

    }

    public static int matchAlgo(String T, int n, String P, int m) {

        int i = 0, j = 0;
        PrefixTable(P, m);

        while (i < n) {

            if (T.charAt(i) == P.charAt(j)) {
                if (j == m - 1) {
                    System.out.println("" + (i - j));
                    i++;
                    j = F[j];
                } else {
                    i++;
                    j++;
                }

            } else if (j > 0) {
                j = F[j - 1];
            } else {
                i++;
            }
        }// while ends here
        return -1;
    }
}// class ends here

