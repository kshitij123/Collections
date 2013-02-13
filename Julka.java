import java.math.BigInteger;
import java.util.Scanner;

class Julka {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int cases = 10;
        BigInteger totApples=new BigInteger("0");
        BigInteger diff=new BigInteger("0");
        BigInteger natalia=new BigInteger("0");
            
        while (cases != 0) {
            
            totApples= new BigInteger(in.nextLine());
            diff=new BigInteger(in.nextLine());
            natalia=getApples(totApples,diff);
            System.out.println(""+natalia+"\n"+(totApples.subtract(natalia)));            

            cases--;
        }

    }// main ends here

    private static BigInteger getApples(BigInteger totApples, BigInteger diff) {
        
        BigInteger res=new BigInteger("0");
        
        res = totApples.subtract(diff);
        res=res.divide(new BigInteger("2"));
        
        return res.add(diff);        
    }

}
