/** Class that prints the Collatz sequence starting from a given number.
 *  @author lsq
 */
public class Collatz {

    /** Buggy implementation of nextNumber! */
    public static int nextNumber(int n) {
        int ret;
        if (n % 2 == 0){
            ret = n / 2;
        }else{
            ret = n * 3 + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

