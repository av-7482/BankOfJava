class pattern1 {
    public static void main(String args[]) {
        int i, j, k;
        for (i = 0; i < 10; i = i + 2) {
            for (k = 8; k > i; k = k - 2) {
                System.out.print(" ");
            }
            for (j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (i = 8; i > 0; i = i - 2) {
            for (k = 8; k >= i; k = k - 2) {
                System.out.print(" ");
            }
            for (j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
/*

    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
    */
