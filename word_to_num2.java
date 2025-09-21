
public class word_to_num2 {

    public static int num = 0;
    public static String str[];

    public int hundreds(int index) {
        word_to_num2 obj1 = new word_to_num2();
        if (index == str.length) {
            return 0;
        } else {
            if (str[index].equals("hundred")) {
                num = num * 100;
                obj1.upto_ten(index + 1);
                obj1.upto_20(index + 1);
                obj1.tens(index + 1);
            } else if (str[index].equals("thousand")) {
                num = num * 1000;
                obj1.upto_ten(index + 1);
                obj1.upto_20(index + 1);
                obj1.tens(index + 1);
            } else if (str[index].equals("million")) {
                num = num * 1000000;
                obj1.upto_ten(index + 1);
                obj1.upto_20(index + 1);
                obj1.tens(index + 1);
            } else if (str[index].equals("billion")) {
                num = num * 1000000000;

                obj1.upto_ten(index + 1);
                obj1.upto_20(index + 1);
                obj1.tens(index + 1);
            } else {
                return 0;
            }
        }
        return num;
    }

    public int upto_ten(int index) {
        word_to_num2 obj3 = new word_to_num2();
        if (index == str.length) {
            return 0;
        } else {
            if (str[index].equals("one")) {
                num = num + 1;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("two")) {
                num = num + 2;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("three")) {
                num = num + 3;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("four")) {
                num = num + 4;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("five")) {
                num = num + 5;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("six")) {
                num = num + 6;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("seven")) {
                num = num + 7;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("eight")) {
                num = num + 8;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("nine")) {
                num = num + 9;
                obj3.hundreds(index + 1);
            } else if (str[index].equals("ten")) {
                num = num + 10;
                obj3.hundreds(index + 1);
            } else {
                return 0;
            }
        }
        return num;
    }

    public int upto_20(int index) {
        if (index == str.length) {
            return 0;
        } else {
            if (str[index].equals("eleven")) {
                num = num + 11;
            } else if (str[index].equals("twelve")) {
                num = num + 12;
            } else if (str[index].equals("thirteen")) {
                num = num + 13;
            } else if (str[index].equals("fourteen")) {
                num = num + 14;
            } else if (str[index].equals("fifteen")) {
                num = num + 15;
            } else if (str[index].equals("sixteen")) {
                num = num + 16;
            } else if (str[index].equals("seventeen")) {
                num = num + 17;
            } else if (str[index].equals("eighteen")) {
                num = num + 18;
            } else if (str[index].equals("nineteen")) {
                num = num + 19;
            } else {
                return 0;
            }
        }
        return num;
    }

    public int tens(int index) {

        word_to_num2 obj1 = new word_to_num2();
        if (index == str.length) {
            return 0;
        } else {
            if (str[index].equals("twenty")) {
                num = num + 20;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else if (str[index].equals("thirty")) {
                num = num + 30;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else if (str[index].equals("forty")) {
                num = num + 40;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else if (str[index].equals("fifty")) {
                num = num + 50;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else if (str[index].equals("sixty")) {
                num = num + 60;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else if (str[index].equals("seventy")) {
                num = num + 70;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else if (str[index].equals("eighty")) {
                num = num + 80;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else if (str[index].equals("ninety")) {
                num = num + 90;
                obj1.hundreds(index + 1);
                obj1.upto_ten(index + 1);
            } else {
                return 0;
            }
        }
        return num;
    }

    public static void main(String args[]) {
        word_to_num2 obj = new word_to_num2();
        System.out.println("Enter the number in words");
        String a = System.console().readLine();
        str = a.split(" ");
        obj.upto_ten(0);
        obj.upto_20(0);
        obj.tens(0);

        System.out.println(num);
    }
}
