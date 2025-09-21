class pattern2 {
      public static void main(String args[]) {
            int i, k, a = 1, r;
            for (i = 0; i < 5; i++) {
                  for (k = 6; k > i; k--) {
                        System.out.print(" ");
                  }
                  int n = a;
                  while (n > 0) {
                        r = n % 10;
                        n = n / 10;
                        System.out.print(r);
                        System.out.print(" ");
                  }
                  a = a * 11;
                  System.out.println();
            }
      }
}
/*
 * 
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 */