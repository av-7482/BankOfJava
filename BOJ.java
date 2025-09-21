import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class BOJ {
    public static JFrame f1;
    public static JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19;
    static ResultSet rs = null;
    static Connection cnnt = null;
    static Statement st = null;
    static PreparedStatement preparedStatement = null;
    static int rowsAffected;
    static String query;

    public static void create_account() {

        String acc_no;
        int acc1_no = 0, bal = 0;

        Random r = new Random();
        String pre = "107000";
        for (int i = 0; i < 4; i++) {
            acc1_no = acc1_no * 10 + r.nextInt(9);
        }
        acc_no = pre + acc1_no;

        p2 = new JPanel();
        p2.setBackground(new Color(235, 229, 213)); // custom RGB color
        p2.setVisible(true);
        p2.setLayout(null);
        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(80, -40, 200, 300);
        p2.add(lb0);

        p3 = new JPanel();
        p3.setBackground(new Color(235, 229, 213)); // custom RGB color
        p3.setLayout(null);
        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
        p3.setSize(screenSize1);
        ImageIcon icon1 = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage1 = icon1.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage);

        JLabel lb = new JLabel(scaledIcon1);
        lb.setBounds(80, -40, 200, 300);
        p3.add(lb);

        JLabel lb1 = new JLabel("Create Account");
        lb1.setFont(new Font("Aerial", Font.BOLD, 70));
        lb1.setBounds(680, 20, 800, 70);

        JLabel label = new JLabel("(Enter the details carefully below to create an account)");
        label.setFont(new Font("Aerial", Font.BOLD, 30));
        label.setBounds(550, 110, 900, 30);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p2.setSize(screenSize);
        f1.setVisible(true);

        JLabel lb2 = new JLabel("Enter Your Name: ");
        lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        lb2.setBounds(300, 200, 270, 30);

        JTextField tf1 = new JTextField(50);
        tf1.setFont(new Font("Aerial", Font.BOLD, 25));
        tf1.setBounds(600, 200, 900, 30);
        tf1.setBackground(Color.WHITE);

        JLabel lb3 = new JLabel("Enter Your DOB (DD-MMM-YYYY): ");
        lb3.setFont(new Font("Aerial", Font.BOLD, 25));
        lb3.setBounds(300, 260, 500, 30);

        JTextField tf2 = new JTextField(50);
        tf2.setFont(new Font("Aerial", Font.BOLD, 25));
        tf2.setBounds(830, 260, 670, 30);
        tf2.setBackground(Color.WHITE);

        JLabel lb4 = new JLabel("Enter Your MOB : ");
        lb4.setFont(new Font("Aerial", Font.BOLD, 25));
        lb4.setBounds(300, 320, 270, 30);

        JTextField tf3 = new JTextField(50);
        tf3.setFont(new Font("Aerial", Font.BOLD, 25));
        tf3.setBounds(600, 320, 900, 30);
        tf3.setBackground(Color.WHITE);
        tf3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 6 digits
                if (tf3.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 6
                }
            }
        });

        JLabel lb5 = new JLabel("Gender : ");
        lb5.setFont(new Font("Aerial", Font.BOLD, 25));
        lb5.setBounds(300, 380, 150, 30);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Aerial", Font.BOLD, 25));
        male.setBounds(700, 380, 200, 30);
        male.setBackground(new Color(239, 233, 217));
        male.setFocusPainted(false);
        male.setActionCommand("male");

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Aerial", Font.BOLD, 25));
        female.setBounds(1300, 380, 200, 30);
        female.setBackground(new Color(239, 233, 217));
        female.setFocusPainted(false);
        female.setActionCommand("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        JLabel lb6 = new JLabel("Account Type : ");
        lb6.setFont(new Font("Aerial", Font.BOLD, 25));
        lb6.setBounds(300, 440, 350, 30);

        JRadioButton saving = new JRadioButton("Savings Account");
        saving.setFont(new Font("Aerial", Font.BOLD, 25));
        saving.setBounds(700, 440, 300, 30);
        saving.setBackground(new Color(239, 233, 217));
        saving.setFocusPainted(false);

        JRadioButton current = new JRadioButton("Current Account");
        current.setFont(new Font("Aerial", Font.BOLD, 25));
        current.setBounds(1200, 440, 300, 30);
        current.setBackground(new Color(239, 233, 217));
        current.setFocusPainted(false);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(saving);
        group1.add(current);

        JLabel lb7 = new JLabel("Enter UIDAI No. : ");
        lb7.setFont(new Font("Aerial", Font.BOLD, 25));
        lb7.setBounds(300, 500, 350, 30);

        JTextField tf4 = new JTextField(50);
        tf4.setFont(new Font("Aerial", Font.BOLD, 25));
        tf4.setBounds(680, 500, 820, 30);
        tf4.setBackground(Color.WHITE);
        tf4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 6 digits
                if (tf4.getText().length() >= 12) {
                    e.consume(); // Ignore key if length is already 6
                }
            }
        });

        JLabel lb8 = new JLabel("Enter your Address : ");
        lb8.setFont(new Font("Aerial", Font.BOLD, 25));
        lb8.setBounds(300, 560, 350, 30);

        JTextField tf5 = new JTextField(50);
        tf5.setFont(new Font("Aerial", Font.BOLD, 20));
        tf5.setBounds(680, 560, 820, 30);
        tf5.setBackground(Color.WHITE);

        JLabel lb9 = new JLabel("Enter your 6-Digit Login Pin : ");
        lb9.setFont(new Font("Aerial", Font.BOLD, 25));
        lb9.setBounds(300, 620, 450, 30);

        JTextField tf6 = new JTextField(50);
        tf6.setFont(new Font("Aerial", Font.BOLD, 25));
        tf6.setBounds(780, 620, 720, 30);
        tf6.setBackground(Color.WHITE);
        tf6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 6 digits
                if (tf6.getText().length() >= 6) {
                    e.consume(); // Ignore key if length is already 6
                }

            }
        });

        JLabel lb10 = new JLabel("Enter your Transaction Password : ");
        lb10.setFont(new Font("Aerial", Font.BOLD, 25));
        lb10.setBounds(300, 680, 420, 30);

        JTextField tf7 = new JTextField(50);
        tf7.setFont(new Font("Aerial", Font.BOLD, 25));
        tf7.setBounds(750, 680, 750, 30);
        tf7.setBackground(Color.WHITE);

        JButton cr_b1 = new JButton("Create Account");
        cr_b1.setFont(new Font("Aerial", Font.BOLD, 25));
        cr_b1.setBounds(350, 750, 300, 50);
        cr_b1.setBackground(new Color(239, 233, 217));
        cr_b1.setFocusPainted(false);
        cr_b1.addActionListener(e -> {
            if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty()
                    || tf4.getText().isEmpty() || tf5.getText().isEmpty()
                    || tf6.getText().isEmpty() || tf7.getText().isEmpty()) {
                JOptionPane.showMessageDialog(f1, "Please fill all the fields", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (tf6.getText().length() < 6) {
                JOptionPane.showMessageDialog(f1, "LOGIN PIN must be of 6 digit ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (tf4.getText().length() < 12) {
                JOptionPane.showMessageDialog(f1, "UIDAI must be of 12 digit ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (tf3.getText().length() < 10) {
                JOptionPane.showMessageDialog(f1, "MOBILE NO must be of 10 digit ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "insert into bank(acc_no,name,ac_type,ac_bal,mob,uidai,gender,dob,address,login,tpass) values (?,?,?,?,?,?,?,?,?,?,?)";
                    String gender;
                    if (male.isSelected()) {
                        gender = "Male";
                    } else if (female.isSelected()) {
                        gender = "Female";
                    } else {
                        JOptionPane.showMessageDialog(f1, "Please select a gender.");
                        return;
                    }

                    String acc_type;
                    if (saving.isSelected()) {
                        acc_type = "Saving";
                    } else if (current.isSelected()) {
                        acc_type = "Current";
                    } else {
                        JOptionPane.showMessageDialog(f1, "Please select an account type.");
                        return;
                    }
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, acc_no);
                    preparedStatement.setString(2, tf1.getText()); // name
                    preparedStatement.setString(3, acc_type);
                    preparedStatement.setInt(4, bal);
                    preparedStatement.setString(5, tf3.getText()); // mob
                    preparedStatement.setString(6, tf4.getText()); // uidai
                    preparedStatement.setString(7, gender);
                    preparedStatement.setString(8, tf2.getText()); // dob
                    preparedStatement.setString(9, tf5.getText()); // address
                    preparedStatement.setString(10, tf6.getText()); // login pin
                    preparedStatement.setString(11, tf7.getText()); // transaction password
                    rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(f1, "Account Created Successfully",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        p2.setVisible(false);
                        p3.setVisible(true);

                        JLabel p3_lb1 = new JLabel(
                                "         Account has been successfully created with the account number :"
                                        + acc_no);
                        p3_lb1.setFont(new Font("Aerial", Font.BOLD, 40));
                        p3_lb1.setBounds(200, 20, 2000, 100);
                        JLabel p3_lb2 = new JLabel(
                                "Note:- Always remember your login pin and transaction password and do not share it with anyone.Bank will never ask for your credentials ");
                        p3_lb2.setFont(new Font("Aerial", Font.BOLD, 20));
                        p3_lb2.setBounds(300, 200, 2000, 200);
                        JButton p3_b1 = new JButton("Back to Main Menu");
                        p3_b1.setBounds(700, 450, 500, 60);
                        p3_b1.setFont(new Font("Aerial", Font.BOLD, 40));
                        p3_b1.setBackground(new Color(239, 233, 217));
                        p3_b1.setFocusPainted(false);
                        p3.add(p3_lb1);
                        p3.add(p3_lb2);
                        p3.add(p3_b1);
                        p3_b1.addActionListener(e1 -> {
                            p3.setVisible(false);
                            p1.setVisible(true);
                        });
                    } else {
                        JOptionPane.showMessageDialog(f1, "Account Creation Failed", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: " + e2.getMessage());
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (st != null)
                            st.close();
                        if (cnnt != null)
                            cnnt.close();
                    } catch (SQLException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        });

        JButton cr_b2 = new JButton("Reset");
        cr_b2.setFont(new Font("Aerial", Font.BOLD, 25));
        cr_b2.setBounds(750, 750, 300, 50);
        cr_b2.setBackground(new Color(239, 233, 217));
        cr_b2.setFocusPainted(false);
        cr_b2.addActionListener(e -> {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            group.clearSelection();
            group1.clearSelection();
        });

        JButton cr_b3 = new JButton("Back");
        cr_b3.setFont(new Font("Aerial", Font.BOLD, 25));
        cr_b3.setBounds(1150, 750, 300, 50);
        cr_b3.setBackground(new Color(239, 233, 217));
        cr_b3.setFocusPainted(false);
        cr_b3.addActionListener(e -> {
            p2.setVisible(false);
            p1.setVisible(true);
        });

        p2.add(lb1);
        p2.add(label);
        p2.add(lb2);
        p2.add(tf1);
        p2.add(lb3);
        p2.add(tf2);
        p2.add(lb4);
        p2.add(tf3);
        p2.add(lb5);
        p2.add(male);
        p2.add(female);
        p2.add(lb6);
        p2.add(saving);
        p2.add(current);
        p2.add(lb7);
        p2.add(tf4);
        p2.add(lb8);
        p2.add(tf5);
        p2.add(lb9);
        p2.add(tf6);
        p2.add(lb10);
        p2.add(tf7);
        p2.add(cr_b1);
        p2.add(cr_b2);
        p2.add(cr_b3);
        f1.add(p2);
        f1.add(p3);

    }

    public static void delete_account() {
        p4 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p4.setSize(screenSize);
        p4.setBackground(new Color(235, 229, 213)); // custom RGB color
        p4.setVisible(true);
        p4.setLayout(null);
        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(80, -40, 200, 300);
        p4.add(lb0);

        JLabel p4_lb1 = new JLabel("Delete Account");
        p4_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p4_lb1.setBounds(550, 50, 800, 100);

        JLabel p4_lb2 = new JLabel("Enter Your Account Number :");
        p4_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p4_lb2.setBounds(400, 200, 430, 50);

        JTextField p4_tf1 = new JTextField();
        p4_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p4_tf1.setBounds(860, 200, 500, 50);
        p4_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 6 digits
                if (p4_tf1.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 6
                }

            }
        });

        JButton p4_b1 = new JButton("Search");
        p4_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p4_b1.setBounds(550, 300, 250, 50);
        p4_b1.setBackground(new Color(239, 233, 217));
        p4_b1.setFocusPainted(false);
        p4_b1.addActionListener(e -> {
            if (p4_tf1.getText().length() < 10) {
                JOptionPane.showMessageDialog(f1, "Account number must be of 10 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    int rowsAffected;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "SELECT * FROM BANK WHERE ACC_NO=?";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, p4_tf1.getText());
                    rs = preparedStatement.executeQuery();

                    StringBuilder accountDetails = new StringBuilder();

                    JTextArea p4_ta1 = new JTextArea();
                    p4_ta1.setFont(new Font("Aerial", Font.BOLD, 40));
                    p4_ta1.setBounds(650, 400, 800, 200); // Set the position and size
                    p4_ta1.setBackground(new Color(200, 245, 200));
                    p4_ta1.setEditable(false); // Make it non-editable
                    p4_ta1.setLineWrap(true); // Enable line wrapping for better readability
                    p4_ta1.setWrapStyleWord(true); // Wrap words instead of breaking in the middle
                    p4.add(p4_ta1);

                    boolean found = false;
                    while (rs.next()) {
                        found = true; // At least one row is found

                        String acc_no = rs.getString("acc_no");
                        String name = rs.getString("name");
                        String ac_type = rs.getString("ac_type");
                        int ac_bal = rs.getInt("ac_bal");
                        String mob = rs.getString("mob");
                        String uidai = rs.getString("uidai");

                        accountDetails.append("Account Number: ").append(acc_no).append("\n")
                                .append("Name: ").append(name).append("\n")
                                .append("Account Type: ").append(ac_type).append("\n")
                                .append("Balance: ").append(ac_bal).append("\n")
                                .append("Mobile: ").append(mob).append("\n")
                                .append("UIDAI: ").append(uidai).append("\n\n");

                        p4_ta1.setText(accountDetails.toString());

                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(f1, "Account not found", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    JLabel p4_lb3 = new JLabel("Are you sure you want to delete this account?");
                    p4.add(p4_lb3);
                    p4_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
                    p4_lb3.setBounds(500, 650, 800, 50);

                    JButton p4_b2 = new JButton("Delete Account");
                    p4.add(p4_b2);
                    p4_b2.setFont(new Font("Aerial", Font.BOLD, 30));
                    p4_b2.setBounds(700, 750, 300, 50);
                    p4_b2.setBackground(new Color(239, 233, 217));
                    p4_b2.setFocusPainted(false);
                    p4_b2.addActionListener(e1 -> {
                        try {
                            ResultSet rs1 = null;
                            Connection cnnt1 = null;
                            Statement st1 = null;
                            PreparedStatement preparedStatement1 = null;
                            int rowsAffected1;
                            String query1;

                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            cnnt1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                                    "system", "12345678");

                            query1 = "DELETE FROM BANK WHERE ACC_NO=?";
                            preparedStatement1 = cnnt1.prepareStatement(query1);
                            preparedStatement1.setString(1, p4_tf1.getText());
                            rowsAffected1 = preparedStatement1.executeUpdate();
                            if (rowsAffected1 > 0) {
                                JOptionPane.showMessageDialog(f1,
                                        "Account Deleted Successfully",
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                p4.setVisible(false);
                                p1.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(f1,
                                        "Account Deletion Failed", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (ClassNotFoundException e11) {
                            System.out.println("Database driver not found.");
                        } catch (SQLException e2) {
                            System.out.println("Database connection error: "
                                    + e2.getMessage());
                        }
                    });

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: " + e2.getMessage());
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (st != null)
                            st.close();
                        if (cnnt != null)
                            cnnt.close();
                    } catch (SQLException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        });

        JButton p4_b2 = new JButton("Back");
        p4_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p4_b2.setBounds(850, 300, 250, 50);
        p4_b2.setBackground(new Color(239, 233, 217));
        p4_b2.setFocusPainted(false);
        p4_b2.addActionListener(e -> {
            p4.setVisible(false);
            p1.setVisible(true);
        });

        p4.add(p4_lb1);
        p4.add(p4_lb2);
        p4.add(p4_tf1);
        p4.add(p4_b1);
        p4.add(p4_b2);
        f1.add(p4);
        f1.setVisible(true);

    }

    public static void user_login() {
        p5 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p5.setSize(screenSize);
        p5.setBackground(new Color(235, 229, 213)); // custom RGB color
        p5.setVisible(true);
        p5.setLayout(null);
        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(80, -40, 200, 300);
        p5.add(lb0);

        JLabel p5_lb1 = new JLabel("USER LOGIN");
        p5_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p5_lb1.setBounds(650, 50, 800, 100);

        JLabel p5_lb2 = new JLabel("LOGIN USING :");
        p5_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p5_lb2.setBounds(850, 200, 800, 50);

        JButton p5_b1 = new JButton("Account Number");
        p5_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p5_b1.setBounds(750, 300, 400, 50);
        p5_b1.setBackground(new Color(239, 233, 217));
        p5_b1.setFocusPainted(false);
        p5_b1.addActionListener(e -> {
            p5.setVisible(false);
            BOJ.login_acc_no();
        });

        JButton p5_b2 = new JButton("UIDAI Number");
        p5_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p5_b2.setBounds(750, 400, 400, 50);
        p5_b2.setBackground(new Color(239, 233, 217));
        p5_b2.setFocusPainted(false);
        p5_b2.addActionListener(e -> {
            p5.setVisible(false);
            BOJ.login_uidai();
        });

        JButton p5_b3 = new JButton("Mobile Number");
        p5_b3.setFont(new Font("Aerial", Font.BOLD, 30));
        p5_b3.setBounds(750, 500, 400, 50);
        p5_b3.setBackground(new Color(239, 233, 217));
        p5_b3.setFocusPainted(false);
        p5_b3.addActionListener(e -> {
            p5.setVisible(false);
            BOJ.login_mob();
        });

        JButton p5_b4 = new JButton("Back");
        p5_b4.setFont(new Font("Aerial", Font.BOLD, 30));
        p5_b4.setBounds(750, 700, 400, 50);
        p5_b4.setBackground(new Color(239, 233, 217));
        p5_b4.setFocusPainted(false);
        p5_b4.addActionListener(e -> {
            p5.setVisible(false);
            p1.setVisible(true);
        });

        p5.add(p5_lb1);
        p5.add(p5_lb2);
        p5.add(p5_b1);
        p5.add(p5_b2);
        p5.add(p5_b3);
        p5.add(p5_b4);
        f1.add(p5);
        f1.setVisible(true);

    }

    public static void login_acc_no() {
        p6 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p6.setSize(screenSize);
        p6.setBackground(new Color(235, 229, 213)); // custom RGB color
        p6.setVisible(true);
        p6.setLayout(null);
        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(80, -40, 200, 300);
        p6.add(lb0);

        JLabel p6_lb1 = new JLabel("LOGIN ");
        p6_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p6_lb1.setBounds(750, 50, 500, 100);

        JLabel p6_lb2 = new JLabel("Enter Your Account Number :");
        p6_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p6_lb2.setBounds(400, 200, 430, 50);

        JTextField p6_tf1 = new JTextField();
        p6_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p6_tf1.setBounds(860, 200, 500, 50);
        p6_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p6_tf1.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JLabel p6_lb3 = new JLabel("Enter Your Login Pin :");
        p6_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p6_lb3.setBounds(400, 300, 350, 50);

        JPasswordField p6_tf2 = new JPasswordField();
        p6_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p6_tf2.setBounds(750, 300, 610, 50);
        p6_tf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p6_tf2.getPassword().length >= 6) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JButton p6_b1 = new JButton("Login");
        p6_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p6_b1.setBounds(800, 400, 250, 50);
        p6_b1.setBackground(new Color(239, 233, 217));
        p6_b1.setFocusPainted(false);
        p6_b1.addActionListener(e -> {
            if (p6_tf1.getText().length() < 10) {
                JOptionPane.showMessageDialog(f1,
                        "Account number must be of 10 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (p6_tf2.getPassword().length < 6) {
                JOptionPane.showMessageDialog(f1,
                        "Login pin must be of 6 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "SELECT * FROM BANK WHERE ACC_NO=? AND LOGIN=?";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, p6_tf1.getText());
                    preparedStatement.setString(2, new String(p6_tf2.getPassword()));
                    rs = preparedStatement.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(f1,
                                "Login Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        p6.setVisible(false);
                        String name = p6_tf1.getText();
                        BOJ.user_menu(name);
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Invalid Account Number or Login Pin", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }

        });

        JButton p6_b2 = new JButton("Back");
        p6_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p6_b2.setBounds(800, 600, 250, 50);
        p6_b2.setBackground(new Color(239, 233, 217));
        p6_b2.setFocusPainted(false);
        p6_b2.addActionListener(e -> {
            p6.setVisible(false);
            p5.setVisible(true);
        });

        p6.add(p6_lb1);
        p6.add(p6_lb2);
        p6.add(p6_lb3);
        p6.add(p6_tf1);
        p6.add(p6_tf2);
        p6.add(p6_b1);
        p6.add(p6_b2);
        f1.add(p6);
        f1.setVisible(true);

    }

    public static void login_uidai() {
        p7 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p7.setSize(screenSize);
        p7.setBackground(new Color(235, 229, 213)); // custom RGB color
        p7.setVisible(true);
        p7.setLayout(null);
        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(80, -40, 200, 300);
        p7.add(lb0);

        JLabel p7_lb1 = new JLabel("LOGIN ");
        p7_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p7_lb1.setBounds(750, 50, 500, 100);

        JLabel p7_lb2 = new JLabel("Enter Your UIDAI Number :");
        p7_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p7_lb2.setBounds(400, 200, 430, 50);

        JTextField p7_tf1 = new JTextField();
        p7_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p7_tf1.setBounds(860, 200, 500, 50);
        p7_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p7_tf1.getText().length() >= 12) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JLabel p7_lb3 = new JLabel("Enter Your Login Pin :");
        p7_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p7_lb3.setBounds(400, 300, 350, 50);

        JPasswordField p7_tf2 = new JPasswordField();
        p7_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p7_tf2.setBounds(750, 300, 610, 50);
        p7_tf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p7_tf2.getPassword().length >= 6) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JButton p7_b1 = new JButton("Login");
        p7_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p7_b1.setBounds(800, 400, 250, 50);
        p7_b1.setBackground(new Color(239, 233, 217));
        p7_b1.setFocusPainted(false);
        p7_b1.addActionListener(e -> {
            if (p7_tf1.getText().length() < 12) {
                JOptionPane.showMessageDialog(f1,
                        "UIDAI number must be of 12 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (p7_tf2.getPassword().length < 6) {
                JOptionPane.showMessageDialog(f1,
                        "Login pin must be of 6 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "SELECT ACC_NO FROM BANK WHERE UIDAI=? AND LOGIN=?";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, p7_tf1.getText());
                    preparedStatement.setString(2, new String(p7_tf2.getPassword()));
                    rs = preparedStatement.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(f1,
                                "Login Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        p7.setVisible(false);
                        String name = rs.getString("ACC_NO");
                        BOJ.user_menu(name);
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Invalid Account Number or Login Pin", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }

        });

        JButton p7_b2 = new JButton("Back");
        p7_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p7_b2.setBounds(800, 600, 250, 50);
        p7_b2.setBackground(new Color(239, 233, 217));
        p7_b2.setFocusPainted(false);
        p7_b2.addActionListener(e -> {
            p7.setVisible(false);
            p5.setVisible(true);
        });

        p7.add(p7_lb1);
        p7.add(p7_lb2);
        p7.add(p7_lb3);
        p7.add(p7_tf1);
        p7.add(p7_tf2);
        p7.add(p7_b1);
        p7.add(p7_b2);
        f1.add(p7);
        f1.setVisible(true);

    }

    public static void login_mob() {
        p8 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p8.setSize(screenSize);
        p8.setBackground(new Color(235, 229, 213)); // custom RGB color
        p8.setVisible(true);
        p8.setLayout(null);
        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(80, -40, 200, 300);
        p8.add(lb0);

        JLabel p8_lb1 = new JLabel("LOGIN ");
        p8_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p8_lb1.setBounds(750, 50, 500, 100);

        JLabel p8_lb2 = new JLabel("Enter Your Mobile Number :");
        p8_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p8_lb2.setBounds(400, 200, 430, 50);

        JTextField p8_tf1 = new JTextField();
        p8_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p8_tf1.setBounds(860, 200, 500, 50);
        p8_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p8_tf1.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JLabel p8_lb3 = new JLabel("Enter Your Login Pin :");
        p8_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p8_lb3.setBounds(400, 300, 350, 50);

        JPasswordField p8_tf2 = new JPasswordField();
        p8_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p8_tf2.setBounds(750, 300, 610, 50);
        p8_tf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p8_tf2.getPassword().length >= 6) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JButton p8_b1 = new JButton("Login");
        p8_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p8_b1.setBounds(800, 400, 250, 50);
        p8_b1.setBackground(new Color(239, 233, 217));
        p8_b1.setFocusPainted(false);
        p8_b1.addActionListener(e -> {
            if (p8_tf1.getText().length() < 10) {
                JOptionPane.showMessageDialog(f1,
                        "Mobile number must be of 10 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (p8_tf2.getPassword().length < 6) {
                JOptionPane.showMessageDialog(f1,
                        "Login pin must be of 6 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "SELECT ACC_NO FROM BANK WHERE MOB=? AND LOGIN=?";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, p8_tf1.getText());
                    preparedStatement.setString(2, new String(p8_tf2.getPassword()));
                    rs = preparedStatement.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(f1,
                                "Login Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        p8.setVisible(false);
                        String name = rs.getString("ACC_NO");
                        BOJ.user_menu(name);
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Invalid Account Number or Login Pin", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }

        });

        JButton p8_b2 = new JButton("Back");
        p8_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p8_b2.setBounds(800, 600, 250, 50);
        p8_b2.setBackground(new Color(239, 233, 217));
        p8_b2.setFocusPainted(false);
        p8_b2.addActionListener(e -> {
            p8.setVisible(false);
            p5.setVisible(true);
        });

        p8.add(p8_lb1);
        p8.add(p8_lb2);
        p8.add(p8_lb3);
        p8.add(p8_tf1);
        p8.add(p8_tf2);
        p8.add(p8_b1);
        p8.add(p8_b2);
        f1.add(p8);
        f1.setVisible(true);

    }

    public static void user_menu(String acc_no) {
        p9 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Set the preferred size for the panel to make sure scrollbars appear
        p9.setSize(screenSize);
        p9.setBackground(new Color(235, 229, 213));
        p9.setVisible(true);
        p9.setLayout(null);
        String name = null;
        int bal = 0;

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p9_lb1 = new JLabel("BANK OF JAVA");
        p9_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p9_lb1.setBounds(550, 50, 800, 100);

        try {
            ResultSet rs = null;
            Connection cnnt = null;
            PreparedStatement preparedStatement;
            String query;

            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                    "system", "12345678");
            query = "SELECT NAME,AC_BAL FROM BANK WHERE ACC_NO=?";
            preparedStatement = cnnt.prepareStatement(query);
            preparedStatement.setString(1, acc_no);

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                name = rs.getString("NAME");
                bal = rs.getInt("AC_BAL");
            }

        } catch (ClassNotFoundException e1) {
            System.out.println("Database driver not found.");
        } catch (SQLException e2) {
            System.out.println("Database connection error: "
                    + e2.getMessage());
        }
        String welcomeMessage = "Welcome, " + name
                + ", to the Bank Of Java, where every Indian trusts.This is your bank of your dreams.";
        JLabel p9_lb2 = new JLabel(welcomeMessage);
        p9_lb2.setFont(new Font("Aerial", Font.BOLD, 40));
        p9_lb2.setBounds(30, 350, 3000, 70);
        p9_lb2.setBackground(new Color(235, 229, 213));

        String welcomeMessage1 = " we are here to help you achieve them. We are committed to providing you with the best banking";
        JLabel p9_lb3 = new JLabel(welcomeMessage1);
        p9_lb3.setFont(new Font("Aerial", Font.BOLD, 40));
        p9_lb3.setBounds(30, 410, 3000, 70);
        p9_lb3.setBackground(new Color(235, 229, 213));

        String welcomeMessage2 = " experience. We are here to help you achieve your financial goals and dreams.";
        JLabel p9_lb4 = new JLabel(welcomeMessage2);
        p9_lb4.setFont(new Font("Aerial", Font.BOLD, 40));
        p9_lb4.setBounds(180, 470, 3000, 70);
        p9_lb4.setBackground(new Color(235, 229, 213));

        JButton p9_b1 = new JButton("Account Info");
        p9_b1.setBounds(150, 600, 300, 70);
        p9_b1.setFont(new Font("Aerial", Font.BOLD, 35));
        p9_b1.setBackground(new Color(239, 233, 217));
        p9_b1.setFocusPainted(false);
        p9_b1.addActionListener(e -> {
            p9.setVisible(false);
            BOJ.check_bal(acc_no);
        });

        JButton p9_b2 = new JButton("Deposit");
        p9_b2.setBounds(525, 600, 300, 70);
        p9_b2.setFont(new Font("Aerial", Font.BOLD, 40));
        p9_b2.setBackground(new Color(239, 233, 217));
        p9_b2.setFocusPainted(false);
        p9_b2.addActionListener(e -> {
            p9.setVisible(false);
            BOJ.deposit(acc_no);
        });

        JButton p9_b3 = new JButton("Withdraw");
        p9_b3.setBounds(900, 600, 300, 70);
        p9_b3.setFont(new Font("Aerial", Font.BOLD, 40));
        p9_b3.setBackground(new Color(239, 233, 217));
        p9_b3.setFocusPainted(false);
        p9_b3.addActionListener(e -> {
            p9.setVisible(false);
            BOJ.withdraw(acc_no);
        });

        JButton p9_b4 = new JButton("Bank Statement");
        p9_b4.setBounds(1275, 600, 375, 70);
        p9_b4.setFont(new Font("Aerial", Font.BOLD, 40));
        p9_b4.setBackground(new Color(239, 233, 217));
        p9_b4.setFocusPainted(false);
        p9_b4.addActionListener(e -> {
            p9.setVisible(false);
            BOJ.statement(acc_no);
        });

        JButton p9_b6 = new JButton("Money Transfer");
        p9_b6.setBounds(675, 700, 400, 70);
        p9_b6.setFont(new Font("Aerial", Font.BOLD, 45));
        p9_b6.setBackground(new Color(239, 233, 217));
        p9_b6.setFocusPainted(false);
        p9_b6.addActionListener(e -> {
            p9.setVisible(false);
            BOJ.mt(acc_no);
        });

        JButton p9_b5 = new JButton("Logout");
        p9_b5.setBounds(675, 850, 400, 70);
        p9_b5.setFont(new Font("Aerial", Font.BOLD, 50));
        p9_b5.setBackground(new Color(239, 233, 217));
        p9_b5.setFocusPainted(false);
        p9_b5.addActionListener(e -> {
            p9.setVisible(false);
            p1.setVisible(true);
        });

        p9.add(lb0);
        p9.add(p9_lb1);
        p9.add(p9_lb2);
        p9.add(p9_lb3);
        p9.add(p9_lb4);
        p9.add(p9_b1);
        p9.add(p9_b2);
        p9.add(p9_b3);
        p9.add(p9_b4);
        p9.add(p9_b5);
        p9.add(p9_b6);
        f1.add(p9);
        f1.setVisible(true);

    }

    public static void mt(String acc_no) {
        p13 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p13.setSize(screenSize);
        p13.setBackground(new Color(235, 229, 213));
        p13.setVisible(true);
        p13.setLayout(null);

        final int[] bal = { 0 };

        try {
            ResultSet rs1 = null;
            Connection cnnt1 = null;
            Statement st1 = null;
            PreparedStatement preparedStatement1 = null;
            String query1;

            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnnt1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                    "system", "12345678");
            query1 = "SELECT AC_BAL FROM BANK WHERE ACC_NO=? ";
            preparedStatement1 = cnnt1.prepareStatement(query1);
            preparedStatement1.setString(1, acc_no);
            rs1 = preparedStatement1.executeQuery();

            while (rs1.next()) {
                bal[0] = rs1.getInt("AC_BAL");
            }

        } catch (ClassNotFoundException e1) {
            System.out.println("Database driver not found.");
        } catch (SQLException e2) {
            System.out.println("Database connection error: "
                    + e2.getMessage());
        }

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p13_lb1 = new JLabel("BANK OF JAVA");
        p13_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p13_lb1.setBounds(550, 50, 800, 100);

        JLabel p13_lb3 = new JLabel("Enter Account Number to Transfer :");
        p13_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_lb3.setBounds(300, 270, 530, 50);

        JTextField p13_tf2 = new JTextField();
        p13_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_tf2.setBounds(860, 270, 530, 50);

        p13_tf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p13_tf2.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JLabel p13_lb2 = new JLabel("Enter Amount to Transfer :");
        p13_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_lb2.setBounds(300, 670, 530, 50);
        p13_lb2.setVisible(false);

        JTextField p13_tf1 = new JTextField();
        p13_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_tf1.setBounds(860, 670, 500, 50);
        p13_tf1.setVisible(false);
        p13_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p13_tf1.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JButton p13_b2 = new JButton("Transfer");
        p13_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_b2.setBounds(800, 750, 250, 50);
        p13_b2.setBackground(new Color(239, 233, 217));
        p13_b2.setFocusPainted(false);
        p13_b2.setVisible(false);

        JTextArea p13_ta = new JTextArea();
        p13_ta.setBounds(600, 450, 1500, 200);
        p13_ta.setFont(new Font("Aerial", Font.BOLD, 50));
        p13_ta.setBackground(new Color(235, 229, 213));
        p13_ta.setEditable(false); // Make it non-editable
        p13_ta.setLineWrap(true); // Enable line wrapping for better readability
        p13_ta.setWrapStyleWord(true); // Wrap words instead of breaking in the middle

        JButton p13_b1 = new JButton("Search");
        p13_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_b1.setBounds(800, 370, 250, 50);
        p13_b1.setBackground(new Color(239, 233, 217));
        p13_b1.setFocusPainted(false);
        p13_b1.addActionListener(e -> {
            if (p13_tf2.getText().length() < 10) {
                JOptionPane.showMessageDialog(f1,
                        "Account number must be of 10 digits", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "SELECT NAME,MOB FROM BANK WHERE ACC_NO=?";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, p13_tf2.getText());
                    rs = preparedStatement.executeQuery();

                    boolean found = false;

                    if (rs.next()) {
                        found = true;
                        JOptionPane.showMessageDialog(f1,
                                "Account Found", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        StringBuilder stb = new StringBuilder();
                        String name = rs.getString("NAME");
                        String mob = rs.getString("MOB");

                        stb.append("Account Number: ").append(p13_tf2.getText()).append("\n")
                                .append("Name: ").append(name).append("\n")
                                .append("Mobile: ").append(mob);

                        p13_ta.setText(stb.toString());
                        p13_lb2.setVisible(true);
                        p13_tf1.setVisible(true);
                        p13_b2.setVisible(true);
                        p13_ta.repaint();

                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "No account found with " + "\n" + " Account Number: " + p13_tf2.getText(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                        p13.setVisible(false);
                        p9.setVisible(true);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (st != null)
                            st.close();
                        if (preparedStatement != null)
                            preparedStatement.close();
                        if (cnnt != null)
                            cnnt.close();
                    } catch (SQLException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        });

        JLabel p13_lb4 = new JLabel("Enter the Transaction Password");
        p13_lb4.setFont(new Font("Aerial", Font.BOLD, 25));
        p13_lb4.setBounds(300, 270, 630, 50);
        p13_lb4.setVisible(false);

        JPasswordField p13_tf3 = new JPasswordField();
        p13_tf3.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_tf3.setBounds(860, 270, 530, 50);
        p13_tf3.setVisible(false);

        JButton p13_b4 = new JButton("Submit");
        p13_b4.setFont(new Font("Aerial", Font.BOLD, 30));
        p13_b4.setBounds(800, 370, 250, 50);
        p13_b4.setBackground(new Color(239, 233, 217));
        p13_b4.setFocusPainted(false);
        p13_b4.setVisible(false);

        p13_b2.addActionListener(e -> {
            if (p13_tf1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(f1,
                        "Transfer Amount cannot be 0", "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else {
                p13_lb2.setVisible(false);
                p13_tf1.setVisible(false);
                p13_lb3.setVisible(false);
                p13_tf2.setVisible(false);
                p13_b1.setVisible(false);
                p13_b2.setVisible(false);
                p13_ta.setVisible(false);
                p13_lb4.setVisible(true);
                p13_b4.setVisible(true);
                p13_tf3.setVisible(true);

            }
        });

        JButton p13_b3 = new JButton("Back");
        p13_b3.setFont(new Font("Aerial", Font.BOLD, 50));
        p13_b3.setBounds(800, 900, 250, 50);
        p13_b3.setBackground(new Color(239, 233, 217));
        p13_b3.setFocusPainted(false);
        p13_b3.addActionListener(e -> {
            p13.setVisible(false);
            p9.setVisible(true);
        });

        p13_b4.addActionListener(e -> {
            if (p13_tf3.getPassword().length == 0) {
                JOptionPane.showMessageDialog(f1,
                        "Password cannot be null", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (Integer.parseInt(p13_tf1.getText()) > (bal[0])) {
                JOptionPane.showMessageDialog(f1,
                        "Not Enough Balance", "Error",
                        JOptionPane.ERROR_MESSAGE);
                p13.setVisible(false);
                p9.setVisible(true);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "UPDATE BANK SET AC_BAL=AC_BAL-? WHERE ACC_NO=? AND TPASS= ? ";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setInt(1, Integer.parseInt(p13_tf1.getText()));
                    preparedStatement.setString(2, acc_no);
                    preparedStatement.setString(3, new String(p13_tf3.getPassword()));
                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        query = "UPDATE BANK SET AC_BAL=AC_BAL+? WHERE ACC_NO=? ";
                        preparedStatement = cnnt.prepareStatement(query);
                        preparedStatement.setInt(1, Integer.parseInt(p13_tf1.getText()));
                        preparedStatement.setString(2, p13_tf2.getText());
                        int rowsUpdated1 = preparedStatement.executeUpdate();
                        if (rowsUpdated1 > 0) {
                            JOptionPane.showMessageDialog(f1,
                                    "Money Transfer Successfull", "SUCCESS",
                                    JOptionPane.INFORMATION_MESSAGE);
                            p13.setVisible(false);
                            p9.setVisible(true);
                            query = "INSERT INTO BANK_TRANSACTION(ACC_NO,ACTION,AMOUNT,ACC_BAL) VALUES(?,?,?,?)";
                            preparedStatement = cnnt.prepareStatement(query);
                            preparedStatement.setString(1, acc_no);
                            preparedStatement.setString(2, "Transfer");
                            preparedStatement.setInt(3, Integer.parseInt(p13_tf1.getText()));
                            preparedStatement.setInt(4, bal[0] - Integer.parseInt(p13_tf1.getText()));
                            preparedStatement.executeUpdate();

                            // data entry for the reciever
                            final int bal1[] = { 0 };
                            try {
                                ResultSet rs1 = null;
                                Connection cnnt1 = null;
                                Statement st1 = null;
                                PreparedStatement preparedStatement1 = null;
                                String query1;

                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                cnnt1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                                        "system", "12345678");
                                query1 = "SELECT AC_BAL FROM BANK WHERE ACC_NO=? ";
                                preparedStatement1 = cnnt1.prepareStatement(query1);
                                preparedStatement1.setString(1, p13_tf2.getText());
                                rs1 = preparedStatement1.executeQuery();

                                while (rs1.next()) {
                                    bal1[0] = rs1.getInt("AC_BAL");
                                }

                            } catch (ClassNotFoundException e1) {
                                System.out.println("Database driver not found.");
                            } catch (SQLException e2) {
                                System.out.println("Database connection error: "
                                        + e2.getMessage());
                            }

                            query = "INSERT INTO BANK_TRANSACTION(ACC_NO,ACTION,AMOUNT,ACC_BAL) VALUES(?,?,?,?)";
                            preparedStatement = cnnt.prepareStatement(query);
                            preparedStatement.setString(1, p13_tf2.getText());
                            preparedStatement.setString(2, "Recieved");
                            preparedStatement.setInt(3, Integer.parseInt(p13_tf1.getText()));
                            preparedStatement.setInt(4, bal1[0]);
                            preparedStatement.executeUpdate();

                        } else {
                            JOptionPane.showMessageDialog(f1,
                                    "Transfer Failed", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Wrong Transaction Password", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        p13.setVisible(false);
                        p9.setVisible(true);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }
        });

        p13.add(lb0);
        p13.add(p13_lb1);
        p13.add(p13_lb2);
        p13.add(p13_tf1);
        p13.add(p13_lb3);
        p13.add(p13_tf2);
        p13.add(p13_b1);
        p13.add(p13_b2);
        p13.add(p13_ta);
        p13.add(p13_b3);
        p13.add(p13_lb4);
        p13.add(p13_b4);
        p13.add(p13_tf3);
        f1.add(p13);
        f1.setVisible(true);

    }

    public static void deposit(String acc_no) {
        p11 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p11.setSize(screenSize);
        p11.setBackground(new Color(235, 229, 213));
        p11.setVisible(true);
        p11.setLayout(null);

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p11_lb1 = new JLabel("BANK OF JAVA");
        p11_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p11_lb1.setBounds(550, 50, 800, 100);

        final int[] bal = { 0 };

        try {
            ResultSet rs1 = null;
            Connection cnnt1 = null;
            Statement st1 = null;
            PreparedStatement preparedStatement1 = null;
            String query1;

            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnnt1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                    "system", "12345678");
            query1 = "SELECT AC_BAL FROM BANK WHERE ACC_NO=? ";
            preparedStatement1 = cnnt1.prepareStatement(query1);
            preparedStatement1.setString(1, acc_no);
            rs1 = preparedStatement1.executeQuery();

            while (rs1.next()) {
                bal[0] = rs1.getInt("AC_BAL");
            }

        } catch (ClassNotFoundException e1) {
            System.out.println("Database driver not found.");
        } catch (SQLException e2) {
            System.out.println("Database connection error: "
                    + e2.getMessage());
        }

        JLabel p11_lb2 = new JLabel("Enter Amount to Deposit :");
        p11_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p11_lb2.setBounds(400, 200, 430, 50);

        JTextField p11_tf1 = new JTextField();
        p11_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p11_tf1.setBounds(860, 200, 500, 50);
        p11_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p11_tf1.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JLabel p11_lb3 = new JLabel("Enter your Transaction Password :");
        p11_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p11_lb3.setBounds(300, 300, 530, 50);

        JPasswordField p11_tf2 = new JPasswordField();
        p11_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p11_tf2.setBounds(860, 300, 500, 50);

        JButton p11_b1 = new JButton("Deposit");
        p11_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p11_b1.setBounds(800, 500, 250, 50);
        p11_b1.setBackground(new Color(239, 233, 217));
        p11_b1.setFocusPainted(false);
        p11_b1.addActionListener(e -> {
            if (p11_tf1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(f1,
                        "Amount must be greater than 0", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "UPDATE BANK SET AC_BAL=AC_BAL+? WHERE ACC_NO=? AND TPASS= ? ";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setInt(1, Integer.parseInt(p11_tf1.getText()));
                    preparedStatement.setString(2, acc_no);
                    preparedStatement.setString(3, new String(p11_tf2.getPassword()));
                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(f1,
                                "Deposit Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        query = "INSERT INTO BANK_TRANSACTION(ACC_NO,ACTION,AMOUNT,ACC_BAL) VALUES(?,?,?,?)";
                        preparedStatement = cnnt.prepareStatement(query);
                        preparedStatement.setString(1, acc_no);
                        preparedStatement.setString(2, "Deposited");
                        preparedStatement.setInt(3, Integer.parseInt(p11_tf1.getText()));
                        preparedStatement.setInt(4, bal[0] + Integer.parseInt(p11_tf1.getText()));
                        preparedStatement.executeUpdate();
                        p11.setVisible(false);
                        BOJ.user_menu(acc_no);
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Wrong Transaction Password", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }

        });

        JButton p11_b2 = new JButton("Back");
        p11_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p11_b2.setBounds(800, 600, 250, 50);
        p11_b2.setBackground(new Color(239, 233, 217));
        p11_b2.setFocusPainted(false);
        p11_b2.addActionListener(e -> {
            p11.setVisible(false);
            p9.setVisible(true);
        });

        p11.add(lb0);
        p11.add(p11_lb1);
        p11.add(p11_lb2);
        p11.add(p11_tf1);
        p11.add(p11_lb3);
        p11.add(p11_tf2);
        p11.add(p11_b1);
        p11.add(p11_b2);
        f1.add(p11);
        f1.setVisible(true);

    }

    public static void withdraw(String acc_no) {
        p12 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p12.setSize(screenSize);
        p12.setBackground(new Color(235, 229, 213));
        p12.setVisible(true);
        p12.setLayout(null);

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p12_lb1 = new JLabel("BANK OF JAVA");
        p12_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p12_lb1.setBounds(550, 50, 800, 100);

        JLabel p12_lb2 = new JLabel("Enter Amount to Withdraw :");
        p12_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p12_lb2.setBounds(400, 200, 430, 50);

        JTextField p12_tf1 = new JTextField();
        p12_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p12_tf1.setBounds(860, 200, 500, 50);
        p12_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p12_tf1.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JLabel p12_lb3 = new JLabel("Enter your Transaction Password :");
        p12_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p12_lb3.setBounds(300, 300, 530, 50);

        JPasswordField p12_tf2 = new JPasswordField();
        p12_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p12_tf2.setBounds(860, 300, 500, 50);

        final int[] bal = { 0 };

        try {
            ResultSet rs1 = null;
            Connection cnnt1 = null;
            Statement st1 = null;
            PreparedStatement preparedStatement1 = null;
            String query1;

            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnnt1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                    "system", "12345678");
            query1 = "SELECT AC_BAL FROM BANK WHERE ACC_NO=? ";
            preparedStatement1 = cnnt1.prepareStatement(query1);
            preparedStatement1.setString(1, acc_no);
            rs1 = preparedStatement1.executeQuery();

            while (rs1.next()) {
                bal[0] = rs1.getInt("AC_BAL");
            }

        } catch (ClassNotFoundException e1) {
            System.out.println("Database driver not found.");
        } catch (SQLException e2) {
            System.out.println("Database connection error: "
                    + e2.getMessage());
        }

        JButton p12_b1 = new JButton("Withdraw");
        p12_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p12_b1.setBounds(800, 500, 250, 50);
        p12_b1.setBackground(new Color(239, 233, 217));
        p12_b1.setFocusPainted(false);
        p12_b1.addActionListener(e -> {
            if (p12_tf1.getText().length() < 1) {
                JOptionPane.showMessageDialog(f1,
                        "Amount must be greater than 0", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (Integer.parseInt(p12_tf1.getText()) > bal[0]) {
                JOptionPane.showMessageDialog(f1,
                        "Not Enough Balance", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "UPDATE BANK SET AC_BAL=AC_BAL-? WHERE ACC_NO=? AND TPASS= ? ";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setInt(1, Integer.parseInt(p12_tf1.getText()));
                    preparedStatement.setString(2, acc_no);
                    preparedStatement.setString(3, new String(p12_tf2.getPassword()));
                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(f1,
                                "Withdraw Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        query = "INSERT INTO BANK_TRANSACTION(ACC_NO,ACTION,AMOUNT,ACC_BAL) VALUES(?,?,?,?)";
                        preparedStatement = cnnt.prepareStatement(query);
                        preparedStatement.setString(1, acc_no);
                        preparedStatement.setString(2, "Withdrawn");
                        preparedStatement.setInt(3, Integer.parseInt(p12_tf1.getText()));
                        preparedStatement.setInt(4, bal[0] - Integer.parseInt(p12_tf1.getText()));
                        preparedStatement.executeUpdate();
                        p12.setVisible(false);
                        BOJ.user_menu(acc_no);
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Wrong Transaction Password", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }

        });

        JButton p12_b2 = new JButton("Back");
        p12_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p12_b2.setBounds(800, 600, 250, 50);
        p12_b2.setBackground(new Color(239, 233, 217));
        p12_b2.setFocusPainted(false);
        p12_b2.addActionListener(e -> {
            p12.setVisible(false);
            p9.setVisible(true);
        });

        p12.add(lb0);
        p12.add(p12_lb1);
        p12.add(p12_lb2);
        p12.add(p12_tf1);
        p12.add(p12_lb3);
        p12.add(p12_tf2);
        p12.add(p12_b1);
        p12.add(p12_b2);
        f1.add(p12);
        f1.setVisible(true);

    }

    public static void check_bal(String acc_no) {
        System.out.println(acc_no);

        p10 = new JPanel();
        p10.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p10.setSize(screenSize);
        p10.setBackground(new Color(235, 229, 213));
        p10.setVisible(true);

        ResultSet rs = null;
        Connection cnnt = null;
        Statement st = null;
        PreparedStatement preparedStatement = null;
        String query = null, name = null, ac_type = null, mob = null, uidai = null, gender = null, dob = null,
                address = null;
        int ac_bal = 0;

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel p10_lb0 = new JLabel(scaledIcon);
        p10_lb0.setBounds(280, -60, 200, 300);

        JLabel p10_lb1 = new JLabel("BANK OF JAVA");
        p10_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p10_lb1.setBounds(550, 50, 800, 100);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle", "system", "12345678");
            query = "SELECT NAME,AC_TYPE,AC_BAL,MOB,UIDAI,ADDRESS FROM BANK WHERE ACC_NO= ? ";
            preparedStatement = cnnt.prepareStatement(query);
            preparedStatement.setString(1, acc_no);
            rs = preparedStatement.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                StringBuilder stb = new StringBuilder();

                JTextArea p10_ta = new JTextArea();
                p10_ta.setBounds(250, 300, 1500, 500);
                p10_ta.setFont(new Font("Aerial", Font.BOLD, 50));
                p10_ta.setBackground(new Color(235, 229, 213));
                p10_ta.setEditable(false); // Make it non-editable
                p10_ta.setLineWrap(true); // Enable line wrapping for better readability
                p10_ta.setWrapStyleWord(true); // Wrap words instead of breaking in the middle
                p10.add(p10_ta);

                name = rs.getString("NAME");
                ac_type = rs.getString("AC_TYPE");
                ac_bal = rs.getInt("AC_BAL");
                mob = rs.getString("MOB");
                uidai = rs.getString("UIDAI");
                address = rs.getString("ADDRESS");

                stb.append("Account Number: ").append(acc_no).append("\n")
                        .append("Name: ").append(name).append("\n")
                        .append("Account Type: ").append(ac_type).append("\n")
                        .append("Balance: ").append(ac_bal).append("\n")
                        .append("Mobile: ").append(mob).append("\n")
                        .append("UIDAI: ").append(uidai).append("\n")
                        .append("Address: ").append(address).append("\n\n");

                if (found) {
                    p10_ta.setText(stb.toString());
                    p10_ta.repaint();
                } else {
                    p10_ta.setText("No account found with Account Number: " + acc_no);
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found.");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (st != null)
                    st.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (cnnt != null)
                    cnnt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        JButton p10_b1 = new JButton("Back");
        p10_b1.setBounds(725, 850, 400, 70);
        p10_b1.setFont(new Font("Aerial", Font.BOLD, 40));
        p10_b1.setBackground(new Color(239, 233, 217));
        p10_b1.setFocusPainted(false);
        p10_b1.addActionListener(e -> {
            p10.setVisible(false);
            p9.setVisible(true);
        });

        p10.add(p10_lb0);
        p10.add(p10_lb1);
        p10.add(p10_b1);
        f1.add(p10);
        f1.setVisible(true);
    }

    public static void admin_login() {
        p15 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p15.setSize(screenSize);
        p15.setBackground(new Color(235, 229, 213));
        p15.setVisible(true);
        p15.setLayout(null);

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p15_lb1 = new JLabel("BANK OF JAVA");
        p15_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p15_lb1.setBounds(550, 50, 800, 100);

        JLabel p15_lb2 = new JLabel("Enter your Admin ID :");
        p15_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p15_lb2.setBounds(400, 250, 430, 50);

        JTextField p15_tf1 = new JTextField();
        p15_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p15_tf1.setBounds(860, 250, 500, 50);

        JLabel p15_lb3 = new JLabel("Enter your Password :");
        p15_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p15_lb3.setBounds(400, 350, 430, 50);

        JPasswordField p15_tf2 = new JPasswordField();
        p15_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p15_tf2.setBounds(860, 350, 500, 50);

        JButton p15_b1 = new JButton("Login");
        p15_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p15_b1.setBounds(800, 550, 250, 50);
        p15_b1.setBackground(new Color(239, 233, 217));
        p15_b1.setFocusPainted(false);
        // Add action listener for the login button
        p15_b1.addActionListener(e -> {

            if (p15_tf1.getText().length() < 4) {
                JOptionPane.showMessageDialog(f1,
                        "Admin_ID must be of 4 Letters ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "SELECT NAME FROM BANK_ADMIN WHERE ADMIN_ID=? AND ADMIN_PASS=?";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, p15_tf1.getText());
                    preparedStatement.setString(2, String.valueOf(p15_tf2.getPassword()));
                    rs = preparedStatement.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(f1,
                                "Login Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        p15.setVisible(false);
                        String name = rs.getString("NAME");
                        BOJ.admin_menu(name);
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Invalid Admin_ID or Password", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }
        });

        JButton p15_b2 = new JButton("Back");
        p15_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p15_b2.setBounds(800, 750, 250, 50);
        p15_b2.setBackground(new Color(239, 233, 217));
        p15_b2.setFocusPainted(false);
        p15_b2.addActionListener(e -> {
            p15.setVisible(false);
            p1.setVisible(true);

        });

        p15.add(lb0);
        p15.add(p15_lb1);
        p15.add(p15_lb2);
        p15.add(p15_tf1);
        p15.add(p15_lb3);
        p15.add(p15_tf2);
        p15.add(p15_b1);
        p15.add(p15_b2);
        f1.add(p15);
        f1.setVisible(true);
    }

    public static void statement(String acc_no) {
        p14 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p14.setSize(screenSize);
        p14.setBackground(new Color(235, 229, 213));
        p14.setVisible(true);
        p14.setLayout(null);

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -35, 200, 300);

        JLabel p14_lb1 = new JLabel("BANK OF JAVA");
        p14_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p14_lb1.setBounds(600, 40, 800, 100);

        JButton p14_b2 = new JButton("Back");
        p14_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p14_b2.setBounds(850, 950, 250, 50);
        p14_b2.setBackground(new Color(239, 233, 217));
        p14_b2.setFocusPainted(false);
        p14_b2.addActionListener(e -> {
            p14.setVisible(false);
            BOJ.user_menu(acc_no);
        });

        try {
            ResultSet rs = null;
            Connection cnnt = null;
            PreparedStatement preparedStatement;
            String query;

            String[] columns = { "ACTION", "AMOUNT", "BALANCE" };
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            JTable table = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(400, 250, 1200, 600); // Set position and size
            p14.add(scrollPane);
            table.setFont(new Font("Aerial", Font.BOLD, 40));
            table.setRowHeight(50);
            table.setBackground(new Color(235, 229, 213));
            table.setFillsViewportHeight(true);

            model.addRow(new Object[] { "   ", "  ", "  " });
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            // Apply it to all columns
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            JTableHeader header = table.getTableHeader();
            header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Height = 40
            header.setFont(new Font("Arial", Font.BOLD, 40));
            header.setBackground(new Color(235, 229, 213));

            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                    "system", "12345678");
            query = "SELECT ACTION,AMOUNT,ACC_BAL FROM BANK_TRANSACTION WHERE ACC_NO=?";
            preparedStatement = cnnt.prepareStatement(query);
            preparedStatement.setString(1, acc_no);

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String action = rs.getString("ACTION");
                int amount = rs.getInt("AMOUNT");
                int balance = rs.getInt("ACC_BAL");
                model.addRow(new Object[] { action, amount, balance });
                model.addRow(new Object[] { "   ", "  ", "  " });
            }

        } catch (ClassNotFoundException e1) {
            System.out.println("Database driver not found.");
        } catch (SQLException e2) {
            System.out.println("Database connection error: "
                    + e2.getMessage());
        }

        p14.add(lb0);
        p14.add(p14_lb1);

        p14.add(p14_b2);
        f1.add(p14);
        f1.setVisible(true);

    }

    public static void admin_menu(String name) {

        p16 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p16.setSize(screenSize);
        p16.setBackground(new Color(235, 229, 213));
        p16.setVisible(true);
        p16.setLayout(null);

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p16_lb1 = new JLabel("BANK OF JAVA");
        p16_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p16_lb1.setBounds(650, 50, 800, 100);

        JLabel p16_lb2 = new JLabel("Welcome " + name + ",");
        p16_lb2.setFont(new Font("Aerial", Font.BOLD, 50));
        p16_lb2.setBounds(400, 250, 900, 80);
        p16_lb2.setVisible(true);

        String[] columns = { "ACCOUNT_NO", "NAME", "ACC_TYPE", "BALANCE", "MOBILE", "UIDAI", "GENDER",
                "DOB", "ADDRESS" };

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(350, 270, 1200, 600); // Set position and size
        p16.add(scrollPane);
        table.setFont(new Font("Aerial", Font.BOLD, 20));
        table.setRowHeight(50);
        table.setBackground(new Color(235, 229, 213));
        table.setFillsViewportHeight(true);

        model.addRow(new Object[] { "   ", "  ", "  ", "   ", "  ", "  ", " " });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(130);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);// UIDAI
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(150);
        // Apply it to all columns
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Height = 40
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBackground(new Color(235, 229, 213));
        scrollPane.setVisible(false);

        JButton p16_b2 = new JButton("Back");
        p16_b2.setFont(new Font("Aerial", Font.BOLD, 50));
        p16_b2.setBounds(700, 900, 450, 60);
        p16_b2.setBackground(new Color(239, 233, 217));
        p16_b2.setFocusPainted(false);
        p16_b2.setVisible(false);

        JButton p16_b3 = new JButton("View Transactions");
        p16_b3.setFont(new Font("Aerial", Font.BOLD, 35));
        p16_b3.setFont(new Font("Aerial", Font.BOLD, 35));
        p16_b3.setBounds(750, 400, 450, 50);
        p16_b3.setBackground(new Color(239, 233, 217));
        p16_b3.setFocusPainted(false);
        p16_b3.setVisible(true);

        JButton p16_b5 = new JButton("Update Data");
        p16_b5.setFont(new Font("Aerial", Font.BOLD, 35));
        p16_b5.setBounds(1250, 400, 450, 50);
        p16_b5.setBackground(new Color(239, 233, 217));
        p16_b5.setFocusPainted(false);
        p16_b5.setVisible(true);
        p16_b5.addActionListener(e -> {
            p16.setVisible(false);
            BOJ.admin_update();
        });

        JButton p16_b4 = new JButton("Logout");
        p16_b4.setFont(new Font("Aerial", Font.BOLD, 50));
        p16_b4.setBounds(750, 650, 450, 60);
        p16_b4.setBackground(new Color(239, 233, 217));
        p16_b4.setFocusPainted(false);
        p16_b4.setVisible(true);
        p16_b4.addActionListener(e -> {
            p16.setVisible(false);
            p1.setVisible(true);
        });

        JButton p16_b1 = new JButton("View All Accounts");
        p16_b1.setFont(new Font("Aerial", Font.BOLD, 35));
        p16_b1.setBounds(250, 400, 450, 50);
        p16_b1.setBackground(new Color(239, 233, 217));
        p16_b1.setFocusPainted(false);
        p16_b1.setVisible(true);
        // Add action listener for the view all accounts button
        p16_b1.addActionListener(e -> {
            p16_lb2.setVisible(false);
            p16_b1.setVisible(false);

            p16_b3.setVisible(false);
            p16_b5.setVisible(false);
            p16_b4.setVisible(false);

            scrollPane.setVisible(true);
            p16_b2.setVisible(true);
            try {
                ResultSet rs = null;
                Connection cnnt = null;
                Statement st = null;
                PreparedStatement preparedStatement = null;
                String query;

                Class.forName("oracle.jdbc.driver.OracleDriver");
                cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                        "system", "12345678");
                query = "SELECT  ACC_NO,NAME,AC_TYPE,AC_BAL,MOB,UIDAI,GENDER,DOB,ADDRESS FROM BANK";
                preparedStatement = cnnt.prepareStatement(query);
                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String acc_no = rs.getString("ACC_NO");
                    String name1 = rs.getString("NAME");
                    String ac_type = rs.getString("AC_TYPE");
                    int ac_bal = rs.getInt("AC_BAL");
                    String mob = rs.getString("MOB");
                    String uidai = rs.getString("UIDAI");
                    String gender = rs.getString("GENDER");
                    String dob = rs.getString("DOB");
                    String address = rs.getString("ADDRESS");
                    model.addRow(new Object[] { acc_no, name1, ac_type, ac_bal, mob, uidai, gender, dob, address });
                    model.addRow(new Object[] { "   ", "  ", "  ", "   ", "  ", "  ", " " });

                }

            } catch (ClassNotFoundException e1) {
                System.out.println("Database driver not found.");
            } catch (SQLException e2) {
                System.out.println("Database connection error: "
                        + e2.getMessage());
            }

        });

        p16_b2.addActionListener(e1 -> {
            scrollPane.setVisible(false);
            p16_b2.setVisible(false);
            p16_lb2.setVisible(true);
            p16_b1.setVisible(true);
            p16_b3.setVisible(true);
            p16_b4.setVisible(true);
            p16_b5.setVisible(true);

            model.setRowCount(0); // Clear the table model
        });

        p16_b3.addActionListener(e1 -> {
            p16.setVisible(false);
            BOJ.admin_transaction();
        });

        p16.add(lb0);
        p16.add(p16_lb1);
        p16.add(p16_lb2);
        p16.add(p16_b1);
        p16.add(p16_b2);
        p16.add(p16_b4);
        p16.add(p16_b3);
        p16.add(p16_b5);

        f1.add(p16);
        f1.setVisible(true);
    }

    public static void admin_update() {
        final String[] action = { null };

        p18 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p18.setSize(screenSize);
        p18.setBackground(new Color(235, 229, 213));
        p18.setVisible(true);
        p18.setLayout(null);

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p18_lb1 = new JLabel("BANK OF JAVA");
        p18_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p18_lb1.setBounds(550, 50, 800, 100);

        JLabel p18_lb2 = new JLabel("Enter Account Number :");
        p18_lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_lb2.setBounds(400, 200, 430, 50);
        JTextField p18_tf1 = new JTextField();
        p18_tf1.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_tf1.setBounds(860, 200, 500, 50);
        p18_tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Restrict non-digit characters
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore non-digit key
                }

                // Restrict to 10 digits
                if (p18_tf1.getText().length() >= 10) {
                    e.consume(); // Ignore key if length is already 10
                }

            }
        });

        JLabel p18_lb3 = new JLabel("Choose the field to update :");
        p18_lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_lb3.setBounds(400, 300, 530, 50);

        String[] options = { "NAME", "MOBILE", "ADDRESS", "DOB", "UIDAI" };

        // Create a JComboBox with the options
        JComboBox<String> p18_CB1 = new JComboBox<>(options);
        p18_CB1.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_CB1.setBounds(860, 300, 500, 50);
        p18_CB1.setBackground(new Color(239, 233, 217));
        p18_CB1.setFocusable(false);
        p18_CB1.setSelectedIndex(-1); // Set the initial selection to none
        p18_CB1.addActionListener(e -> {
            String selectedOption = (String) p18_CB1.getSelectedItem();
            if (selectedOption != null) {
                // Perform action based on the selected option
                if (selectedOption.equals("NAME")) {
                    action[0] = "NAME";
                } else if (selectedOption.equals("MOBILE")) {
                    action[0] = "MOB";
                } else if (selectedOption.equals("ADDRESS")) {
                    action[0] = "ADDRESS";
                } else if (selectedOption.equals("DOB")) {
                    action[0] = "DOB";
                } else if (selectedOption.equals("UIDAI")) {
                    action[0] = "UIDAI";
                }
            }
        });

        JLabel p18_lb4 = new JLabel("Enter new value :");
        p18_lb4.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_lb4.setBounds(400, 400, 430, 50);
        JTextField p18_tf2 = new JTextField();
        p18_tf2.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_tf2.setBounds(860, 400, 500, 50);

        JButton p18_b1 = new JButton("Update");
        p18_b1.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_b1.setBounds(800, 500, 250, 50);
        p18_b1.setBackground(new Color(239, 233, 217));
        p18_b1.setFocusPainted(false);
        p18_b1.addActionListener(e -> {
            if (p18_tf1.getText().length() < 1) {
                JOptionPane.showMessageDialog(f1,
                        "Account Number must be greater than 0", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (action[0] == null) {
                JOptionPane.showMessageDialog(f1,
                        "Please select a field to update", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (p18_tf2.getText().length() < 1) {
                JOptionPane.showMessageDialog(f1,
                        "New value must be greater than 0", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ResultSet rs = null;
                    Connection cnnt = null;
                    Statement st = null;
                    PreparedStatement preparedStatement = null;
                    String query;

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                            "system", "12345678");
                    query = "UPDATE BANK SET " + action[0] + "= ? WHERE ACC_NO= ? ";
                    preparedStatement = cnnt.prepareStatement(query);
                    preparedStatement.setString(1, p18_tf2.getText());
                    preparedStatement.setString(2, p18_tf1.getText());
                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(f1,
                                "Update Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        p18.setVisible(false);
                        BOJ.admin_menu("Admin");
                    } else {
                        JOptionPane.showMessageDialog(f1,
                                "Account Number not found", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ClassNotFoundException e1) {
                    System.out.println("Database driver not found.");
                } catch (SQLException e2) {
                    System.out.println("Database connection error: "
                            + e2.getMessage());
                }
            }

        });

        JButton p18_b2 = new JButton("Back");
        p18_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p18_b2.setBounds(800, 950, 250, 50);
        p18_b2.setBackground(new Color(239, 233, 217));
        p18_b2.setFocusPainted(false);
        p18_b2.addActionListener(e -> {
            p18.setVisible(false);
            BOJ.admin_menu("Admin");
        });

        // Add components to the panel
        p18.add(lb0);
        p18.add(p18_lb1);
        p18.add(p18_b2);
        p18.add(p18_lb2);
        p18.add(p18_tf1);
        p18.add(p18_lb3);
        p18.add(p18_CB1);
        p18.add(p18_lb4);
        p18.add(p18_tf2);
        p18.add(p18_b1);
        p18.setVisible(true);

        f1.add(p18);
        f1.setVisible(true);
    }

    public static void admin_transaction() {
        p17 = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p17.setSize(screenSize);
        p17.setBackground(new Color(235, 229, 213));
        p17.setVisible(true);
        p17.setLayout(null);

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel p17_lb1 = new JLabel("BANK OF JAVA");
        p17_lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        p17_lb1.setBounds(550, 50, 800, 100);

        JButton p17_b2 = new JButton("Back");
        p17_b2.setFont(new Font("Aerial", Font.BOLD, 30));
        p17_b2.setBounds(800, 950, 250, 50);
        p17_b2.setBackground(new Color(239, 233, 217));
        p17_b2.setFocusPainted(false);
        p17_b2.addActionListener(e -> {
            p17.setVisible(false);
            p16.setVisible(true);
        });

        try {
            ResultSet rs = null;
            Connection cnnt = null;
            PreparedStatement preparedStatement;
            String query;

            String[] columns = { "ACCOUNT_NO", "ACTION", "AMOUNT", "BALANCE" };
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            JTable table = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(400, 250, 1200, 600); // Set position and size
            p17.add(scrollPane);
            table.setFont(new Font("Aerial", Font.BOLD, 20));
            table.setRowHeight(50);
            table.setBackground(new Color(235, 229, 213));
            table.setFillsViewportHeight(true);

            model.addRow(new Object[] { "   ", "  ", "  ", "   " });
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            table.getColumnModel().getColumn(0).setPreferredWidth(160);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(130);
            table.getColumnModel().getColumn(3).setPreferredWidth(120);
            // Apply it to all columns
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
            JTableHeader header = table.getTableHeader();
            header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Height = 40

            header.setFont(new Font("Arial", Font.BOLD, 20));
            header.setBackground(new Color(235, 229, 213));
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cnnt = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle",
                    "system", "12345678");
            query = "SELECT * FROM BANK_TRANSACTION";
            preparedStatement = cnnt.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String acc_no = rs.getString("ACC_NO");
                String action = rs.getString("ACTION");
                int amount = rs.getInt("AMOUNT");
                int balance = rs.getInt("ACC_BAL");
                model.addRow(new Object[] { acc_no, action, amount, balance });
                model.addRow(new Object[] { "   ", "  ", "  ", "   " });

            }
        } catch (ClassNotFoundException e1) {
            System.out.println("Database driver not found.");
        } catch (SQLException e2) {
            System.out.println("Database connection error: "
                    + e2.getMessage());
        }
        p17.add(lb0);
        p17.add(p17_lb1);
        p17.add(p17_b2);
        f1.add(p17);
        f1.setVisible(true);
    }

    public static void main(String args[]) throws Exception {
        f1 = new JFrame("bank_of_java");
        p1 = new JPanel();

        ImageIcon icon = new ImageIcon("C:/JAVA_JDBC/jdbc_project/src/jdbc_1/sora_logo1.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lb0 = new JLabel(scaledIcon);
        lb0.setBounds(280, -40, 200, 300);

        JLabel lb1 = new JLabel("BANK OF JAVA");
        lb1.setFont(new Font("Aerial", Font.BOLD, 100));
        lb1.setBounds(550, 50, 800, 100);

        JLabel lb2 = new JLabel("THE ONLY TRUST OF INDIANS ");
        lb2.setFont(new Font("Aerial", Font.BOLD, 30));
        lb2.setBounds(700, 180, 800, 50);

        JLabel lb3 = new JLabel("(CHOOSE FROM THE OPTIONS BELOW :- )");
        lb3.setFont(new Font("Aerial", Font.BOLD, 30));
        lb3.setBounds(650, 300, 800, 50);

        JButton b1 = new JButton("Create Account");
        b1.setFont(new Font("Aerial", Font.BOLD, 50));
        b1.setBounds(700, 400, 450, 60);

        JButton b2 = new JButton("Delete Account");
        b2.setFont(new Font("Aerial", Font.BOLD, 50));
        b2.setBounds(700, 500, 450, 60);

        JButton b3 = new JButton("User Login");
        b3.setFont(new Font("Aerial", Font.BOLD, 50));
        b3.setBounds(700, 600, 450, 60);

        JButton b4 = new JButton("Admin Login");
        b4.setFont(new Font("Aerial", Font.BOLD, 50));
        b4.setBounds(700, 700, 450, 60);

        JButton b5 = new JButton("Exit");
        b5.setFont(new Font("Aerial", Font.BOLD, 50));
        b5.setBounds(700, 800, 450, 60);

        b1.addActionListener(e -> {
            p1.setVisible(false);
            BOJ.create_account();
        });
        b2.addActionListener(e -> {
            p1.setVisible(false);
            BOJ.delete_account();
        });
        b3.addActionListener(e -> {
            p1.setVisible(false);
            BOJ.user_login();
        });
        b4.addActionListener(e -> {
            p1.setVisible(false);
            BOJ.admin_login();
        });
        b5.addActionListener(e -> {
            p1.setVisible(false);
            System.exit(0);
        });

        p1.add(lb0);
        p1.add(lb1);
        p1.add(lb2);
        p1.add(lb3);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        f1.add(p1);
        p1.setBackground(new Color(235, 229, 213));
        b1.setFocusPainted(false);
        b1.setBackground(new Color(239, 233, 217));
        b2.setFocusPainted(false);
        b2.setBackground(new Color(239, 233, 217));
        b3.setFocusPainted(false);
        b3.setBackground(new Color(239, 233, 217));
        b4.setFocusPainted(false);
        b4.setBackground(new Color(239, 233, 217));
        b5.setFocusPainted(false);
        b5.setBackground(new Color(239, 233, 217));
        f1.setLayout(null);
        p1.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        p1.setSize(screenSize);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }
}