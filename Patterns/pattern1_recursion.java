
class pattern1_recursion {

    static void pr(int p) {
        for (int i = 0; i < p; i++) {
            System.out.print("*");

        }
        System.out.print("\n");
    }

    static void ma(int q) {
        if (q < 5) {
            pattern1_recursion.pr(q);
            ma(q + 1);

        } else {
            pattern1_recursion.pr(5);
        }

    }

    public static void main(String args[]) {
        pattern1_recursion.ma(1);
    }

}
