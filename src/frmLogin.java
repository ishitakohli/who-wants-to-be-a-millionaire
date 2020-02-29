import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class frmLogin extends JFrame {
    JTextField txtName;
    JPasswordField txtPwd;
    JLabel lbl1, lbl2;
    JRadioButton rdoAddministrator, rdoSuperuser, rdoUser;
    JButton btnOk, btnCancel;

    JPanel pmain;
    Connection cn;
    ResultSet rs;
    Statement st;
    Container cnt;

    public void connect() {
        try {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection("jdbc:odbc:Ashish", "system", "manager");
        } catch (Exception e) {
        }
    }

    public void openRecord() {
        String query = "SELECT USER_ID,USER_PWD,USER_TYPE " +
                " FROM SECURITY";
        try {
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(query);
        } catch (SQLException e) {
        }
    }

    public frmLogin() {
        setBackground(Color.gray);
        setSize(800, 600);
        setTitle("Employee Login form ");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        cnt = getContentPane();

        lbl1 = new JLabel("USER ID:");
        lbl1.setBounds(520, 460, 100, 20);
        lbl1.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        lbl1.setForeground(Color.red);
        cnt.add(lbl1);

        lbl2 = new JLabel("PASSWARD:");
        lbl2.setBounds(520, 485, 300, 20);
        lbl2.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        lbl2.setForeground(Color.red);
        cnt.add(lbl2);

        txtName = new JTextField(10);
        txtName.setBounds(620, 460, 120, 20);
        txtName.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        txtName.setForeground(Color.black);
        cnt.add(txtName);

        txtPwd = new JPasswordField(8);
        txtPwd.setBounds(620, 485, 120, 20);
        txtPwd.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        txtPwd.setForeground(Color.black);
        cnt.add(txtPwd);

        rdoAddministrator = new JRadioButton("Addministrator");
        rdoAddministrator.setBounds(500, 435, 110, 20);
        rdoAddministrator.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 10));
        rdoAddministrator.setForeground(Color.red);
        rdoAddministrator.setBackground(Color.orange);

        rdoSuperuser = new JRadioButton("Superuser");
        rdoSuperuser.setBounds(620, 435, 85, 20);
        rdoSuperuser.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 10));
        rdoSuperuser.setForeground(Color.red);
        rdoSuperuser.setBackground(Color.orange);

        rdoUser = new JRadioButton("User");
        rdoUser.setBounds(710, 435, 55, 20);

        rdoUser.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 10));
        rdoUser.setForeground(Color.red);
        rdoUser.setBackground(Color.orange);
        cnt.add(rdoAddministrator);
        cnt.add(rdoSuperuser);
        cnt.add(rdoUser);

        pmain = new JPanel();
        pmain.setLayout(new GridLayout(0, 2));
        pmain.setBounds(570, 510, 160, 20);
        pmain.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
        pmain.setBackground(Color.orange);
        pmain.setForeground(Color.red);
        cnt.add(pmain);

        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");
        pmain.add(btnOk);
        pmain.add(btnCancel);

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red, 3), "Reception Login Form", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD + Font.ITALIC, 10), Color.black));
        p.setBackground(Color.green);
        p.setBounds(480, 415, 300, 125);
        cnt.add(p);

        ImageIcon img = new ImageIcon("c:\\jdk1.4\\bin\\picLogin.jpg");
        JLabel lblimg = new JLabel(img);
        lblimg.setBounds(1, 1, 800, 600);
        cnt.add(lblimg);

        ImageIcon img1 = new ImageIcon("c:\\jdk1.4\\bin\\A.jpg");
        JLabel lblimg1 = new JLabel(img1);
        lblimg1.setBounds(1, 1, 80, 60);
        cnt.add(lblimg);

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                char pArr[] = txtPwd.getPassword();

                String strPWD = new String(pArr);
                String strUID = new String(txtName.getText());
                String oriPWD = "";
                if (strUID.equals("Ashish") && strPWD.equals("ashish")) {
                    setVisible(false);
                    showMainForm();
                } else {
                    try {
                        connect();
                        openRecord();
                        rs.beforeFirst();
                        while (rs.next()) {
                            if (strUID.equals(rs.getString("USER_ID"))) {
                                oriPWD = rs.getString("USER_PWD");
                                found = true;
                                break;
                            }
                        }
                    } catch (Exception k) {
                    }
                    if (found) {
                        if (strPWD.equals(oriPWD)) {
                            setVisible(false);
                            showMainForm();
                        } else
                            JOptionPane.showMessageDialog(null, "Invalid Password. Login Failed!",
                                    "Login message", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Invalid Username. Login Failed!",
                                "Login message", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Login Failed!",
                        "Login message", JOptionPane.INFORMATION_MESSAGE);

                setVisible(false);
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        frmLogin log = new frmLogin();
        log.show();
    }

    public void showMainForm() {
        MainForm mfrm = new MainForm();
        mfrm.show();
    }
}
