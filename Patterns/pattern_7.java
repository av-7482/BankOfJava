public class pattern_7 {
    public static void main(String args[]) {
        int i, j, b, k = 0;
        for (i = 1; i <= 5; i++) {
            b = 4;
            for (j = 1; j <= i; j++) {
                if (j == 1) {
                    k = i;
                    System.out.print(k + " ");

                } else {
                    k = k + b;
                    System.out.print(k + " ");
                    b--;
                }
            }
            System.out.println();
        }
    }
}