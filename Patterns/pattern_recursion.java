
class pattern_recursion {

    static void pr(int p) {
        for (int i = p; i > 0; i--) {
            System.out.print("*");

        }
        System.out.print("\n");
    }

    static void ma(int q) {
        if (q > 1) {
            pattern_recursion.pr(q);
            ma(q - 1);

        } else {
            pattern_recursion.pr(1);
        }

    }

    public static void main(String args[]) {
        pattern_recursion.ma(5);
    }

}
