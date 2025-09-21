public class words_to_num {
    public static void main(String[] args) {
        String a;
        System.out.println("entr the 3 digit number in words");
        a = System.console().readLine();
        int num = 0;
        String[] str = a.split(" ");
        /*
         * if (str[0].equals("twenty")) {
         * num = 20;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         * } else if (str[0].equals("thirty")) {
         * num = 30;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         * } else if (str[0].equals("forty")) {
         * num = 40;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         * } else if (str[0].equals("fifty")) {
         * num = 50;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         * } else if (str[0].equals("sixty")) {
         * num = 60;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         * } else if (str[0].equals("seventy")) {
         * num = 70;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         * } else if (str[0].equals("eighty")) {
         * num = 80;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         * } else if (str[0].equals("ninety")) {
         * num = 90;
         * if (str[1].equals("one")) {
         * num = num + 1;
         * } else if (str[1].equals("two")) {
         * num = num + 2;
         * } else if (str[1].equals("three")) {
         * num = num + 3;
         * } else if (str[1].equals("four")) {
         * num = num + 4;
         * } else if (str[1].equals("five")) {
         * num = num + 5;
         * } else if (str[1].equals("six")) {
         * num = num + 6;
         * } else if (str[1].equals("seven")) {
         * num = num + 7;
         * } else if (str[1].equals("eight")) {
         * num = num + 8;
         * } else if (str[1].equals("nine")) {
         * num = num + 9;
         * }
         */
        if (str[0].equals("one")) {
            num = 1;
        } else if (str[0].equals("two")) {
            num = 2;
        } else if (str[0].equals("three")) {
            num = 3;
        } else if (str[0].equals("four")) {
            num = 4;
        } else if (str[0].equals("five")) {
            num = 5;
        } else if (str[0].equals("six")) {
            num = 6;
        } else if (str[0].equals("seven")) {
            num = 7;
        } else if (str[0].equals("eight")) {
            num = 8;
        } else if (str[0].equals("nine")) {
            num = 9;
        } else if (str[0].equals("ten")) {
            num = 10;
        }
        /*
         * } else if (str[0].equals("eleven")) {
         * num = 11;
         * } else if (str[0].equals("twelve")) {
         * num = 12;
         * } else if (str[0].equals("thirteen")) {
         * num = 13;
         * } else if (str[0].equals("fourteen")) {
         * num = 14;
         * } else if (str[0].equals("fifteen")) {
         * num = 15;
         * } else if (str[0].equals("sixteen")) {
         * num = 16;
         * } else if (str[0].equals("seventeen")) {
         * num = 17;
         * } else if (str[0].equals("eighteen")) {
         * num = 18;
         * } else if (str[0].equals("nineteen")) {
         * num = 19;
         * }
         */

        if (str.length == 1) {
            System.out.println(num);
        } else {// str's index is now 1
            if (str[1].equals("hundred")) {
                num = num * 100;
            }
        }
        if (str.length == 2) {
            System.out.println(num);
        } else {
            if (str[2].equals("ten")) {
                num = num + 10;
            } else if (str[2].equals("twenty")) {
                num = num + 20;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }
            } else if (str[2].equals("thirty")) {
                num = num + 30;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }
            } else if (str[2].equals("forty")) {
                num = num + 40;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }
            } else if (str[2].equals("fifty")) {
                num = num + 50;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }

            } else if (str[2].equals("sixty")) {
                num = num + 60;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }
            } else if (str[2].equals("seventy")) {
                num = num + 70;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }
            } else if (str[2].equals("eighty")) {
                num = num + 80;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }

            } else if (str[2].equals("ninety")) {
                num = num + 90;
                if (str[3].equals("one")) {
                    num = num + 1;
                } else if (str[3].equals("two")) {
                    num = num + 2;
                } else if (str[3].equals("three")) {
                    num = num + 3;
                } else if (str[3].equals("four")) {
                    num = num + 4;
                } else if (str[3].equals("five")) {
                    num = num + 5;
                } else if (str[3].equals("six")) {
                    num = num + 6;
                } else if (str[3].equals("seven")) {
                    num = num + 7;
                } else if (str[3].equals("eight")) {
                    num = num + 8;
                } else if (str[3].equals("nine")) {
                    num = num + 9;
                } else if (str[3].equals("ten")) {
                    num = num + 10;
                }

            } else if (str[2].equals("one")) {
                num = num + 1;
            } else if (str[2].equals("two")) {
                num = num + 2;
            } else if (str[2].equals("three")) {
                num = num + 3;
            } else if (str[2].equals("four")) {
                num = num + 4;
            } else if (str[2].equals("five")) {
                num = num + 5;
            } else if (str[2].equals("six")) {
                num = num + 6;
            } else if (str[2].equals("seven")) {
                num = num + 7;
            } else if (str[2].equals("eight")) {
                num = num + 8;
            } else if (str[2].equals("nine")) {
                num = num + 9;
            } else if (str[2].equals("ten")) {
                num = num + 10;
            }
            System.out.println(num);
        }

    }

}
