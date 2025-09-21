import java.util.Random;
import java.util.Scanner;

public class rockpapergame {
    public static void main(String[] args) {
        int i = 1;

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        while (i < 5) {

            int comp_ran = random.nextInt();
            int naveen = sc.nextInt();
            switch (naveen) {
                case 1:
                    System.out.println("rock");
                    break;
                case 2:
                    System.out.println("paper");
                    break;
                case 3:
                    System.out.println("scissor");
                    break;
                default:
                    System.out.println("enter number below  4");
            }

            if (comp_ran == 1) {
                System.out.println("rock");
            } else if (comp_ran == 2) {
                System.out.println("paper");
            } else if (comp_ran == 3) {
                System.out.println("scissor");
            }

            if (naveen == comp_ran) {
                System.out.println("no winner match is drawn ");
            } else if (naveen == 1 && comp_ran == 3) {
                System.out.println("naveen winner'");

            } else if (naveen == 2 && comp_ran == 1) {
                System.out.println("naveen winner");
            } else if (naveen == 3 && comp_ran == 2) {
                System.out.println("naveeen winner");
            } else if (comp_ran == 1 && naveen == 3) {
                System.out.println("laptop winner ");
            } else if (comp_ran == 2 && naveen == 1) {
                System.out.println("laptop winner ");
            } else if (comp_ran == 3 && naveen == 2) {
                System.out.println("laptop winner");
            }
            i++;
        }
    }
}