package electricity_billing_system;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
public class Login {
private JFrame frmLogin;
private JTextField txtUname;
private JTextField txtpwd;
private String Uname,pwd;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Login window = new Login();
window.frmLogin.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
public Login() {
initialize();
frmLogin.setVisible(true);
}
/**
* Initialize the contents of the frame.
10
*/
private void initialize() {
frmLogin = new JFrame();
frmLogin.setTitle("login");
frmLogin.setBounds(100, 100, 651, 525);
frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmLogin.getContentPane().setLayout(null);
JLabel lblNewlabel = new JLabel("Username");
lblNewlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewlabel.setBounds(45, 30, 122, 31);
frmLogin.getContentPane().add(lblNewlabel);
JLabel lblNewLabel_1 = new JLabel("Password");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_1.setBounds(47, 96, 120, 31);
frmLogin.getContentPane().add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Login in as");
lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_2.setBounds(45, 166, 122, 25);
frmLogin.getContentPane().add(lblNewLabel_2);
txtUname = new JTextField();
txtUname.setBounds(205, 36, 143, 25);
frmLogin.getContentPane().add(txtUname);
txtUname.setColumns(10);
txtpwd = new JPasswordField();
txtpwd.setBounds(205, 102, 143, 25);
frmLogin.getContentPane().add(txtpwd);
txtpwd.setColumns(10);
JComboBox acctype = new JComboBox();
acctype.setBounds(205, 166, 143, 27);
frmLogin.getContentPane().add(acctype);
acctype.addItem("");
acctype.addItem("Admin");
acctype.addItem("Customer");
JButton btnLogin = new JButton("Login");
btnLogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if(acctype.getSelectedItem().equals("Customer")) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
Uname = txtUname.getText();
pwd = txtpwd.getText();
String user = (String) acctype.getSelectedItem();
String query = "select * from login where username =
'"+Uname+"' and password = '"+pwd+"' and user = '"+user+"'";
11

 ResultSet rs = s.executeQuery(query);

 if (rs.next()) {
 String meter = rs.getString("meter_no");

 new ChomePage(meter);
 }
 else {
 JOptionPane.showMessageDialog(null, "Invalid Login");
 }

 } catch (Exception ge) {
 ge.printStackTrace();
 }
} else if(acctype.getSelectedItem().equals("Admin")) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
Uname = txtUname.getText();
pwd = txtpwd.getText();
String user = (String) acctype.getSelectedItem();
String query = "select * from login where
username = '"+Uname+"' and password = '"+pwd+"' and user = '"+user+"'";

 ResultSet rs = s.executeQuery(query);

 if (rs.next()) {
 frmLogin.dispose();
 new HomePage();
 }
 else {
 JOptionPane.showMessageDialog(null, "Invalid Login");
 }

 } catch (Exception ge) {
 ge.printStackTrace();
 }
}
else {
JOptionPane.showMessageDialog(null, "Please select
Login Type");
}
}
});
btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
btnLogin.setBounds(98, 228, 113, 25);
frmLogin.getContentPane().add(btnLogin);
JButton btnNewButton_1 = new JButton("Cancel");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

txtUname.setText(null);
txtpwd.setText(null);
acctype.setToolTipText("");
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_1.setBounds(289, 228, 113, 25);
frmLogin.getContentPane().add(btnNewButton_1);
JButton btnNewButton_2 = new JButton("Sign up");
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmLogin.dispose();
Signup log = new Signup(); }
});
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_2.setBounds(205, 305, 113, 25);
frmLogin.getContentPane().add(btnNewButton_2);
}
}
