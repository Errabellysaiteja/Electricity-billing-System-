package electricity_billing_system;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Signup {
private JFrame frmLoginpage;
private JTextField uname;
private JTextField Name;
private JPasswordField passwordField;
13
private JTextField mnumber;
private JButton create, back;
private JComboBox accounttype;
private Signup window;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Signup window = new Signup();
window.frmLoginpage.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
public Signup() {
initialize();
frmLoginpage.setVisible(true);
}
/**
* Initialize the contents of the frame.
*/
private void initialize() {
frmLoginpage = new JFrame();
frmLoginpage.getContentPane().setFont(new Font("Tahoma", Font.PLAIN,
17));
frmLoginpage.setTitle("sign up");
frmLoginpage.setBounds(100, 100, 651, 525);
frmLoginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmLoginpage.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("create account as");
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel.setBounds(52, 38, 190, 30);
frmLoginpage.getContentPane().add(lblNewLabel);
JComboBox accounttype = new JComboBox();
accounttype.setFont(new Font("Tahoma", Font.BOLD, 17));
accounttype.setBounds(252, 37, 162, 31);
frmLoginpage.getContentPane().add(accounttype);
accounttype.addItem("");
accounttype.addItem("Admin");
accounttype.addItem("Customer");
14
JLabel lblNewLabel_1 = new JLabel("Username");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_1.setBounds(52, 107, 154, 23);
frmLoginpage.getContentPane().add(lblNewLabel_1);
uname = new JTextField();
uname.setBounds(252, 101, 162, 31);
frmLoginpage.getContentPane().add(uname);
uname.setColumns(10);
JLabel lblNewLabel_2 = new JLabel("Name");
lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_2.setBounds(52, 170, 116, 23);
frmLoginpage.getContentPane().add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("Password");
lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_3.setBounds(52, 238, 103, 30);
frmLoginpage.getContentPane().add(lblNewLabel_3);
Name = new JTextField();
Name.setBounds(252, 170, 162, 31);
frmLoginpage.getContentPane().add(Name);
Name.setColumns(10);
JButton create = new JButton("Create");
create.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
 String atype = (String) accounttype.getSelectedItem();
 String username = uname.getText();
 String name = Name.getText();
 String password = passwordField.getText();
 String meter_no = mnumber.getText();

 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 String query = null;
 if (atype.equals("Admin")) {
 query = "insert into login values('"+meter_no+"', '"+username+"',
'"+name+"', '"+password+"', '"+atype+"')";
 }
 else if (atype.equals("Customer")) {
 query = "insert into login values('"+meter_no+"', '"+username+"',
'"+name+"', '"+password+"', '"+atype+"')";
 }
 else {
15
 query = "update login set username = '"+username+"', password =
'"+password+"', user = '"+atype+"' where meter_no = '"+meter_no+"'";
 }
 s.executeUpdate(query);
 JOptionPane.showMessageDialog(null, "Account Created
Successfully");

 frmLoginpage.dispose();
 new Login();
 } catch (Exception re) {
 re.printStackTrace();
 }
}
});
create.setFont(new Font("Tahoma", Font.PLAIN, 18));
create.setBounds(157, 356, 103, 21);
frmLoginpage.getContentPane().add(create);
JButton back = new JButton("Back");
back.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmLoginpage.dispose();
Login ch = new Login();
}
});
back.setFont(new Font("Tahoma", Font.PLAIN, 18));
back.setBounds(312, 356, 102, 21);
frmLoginpage.getContentPane().add(back);
passwordField = new JPasswordField();
passwordField.setBounds(252, 239, 162, 29);
frmLoginpage.getContentPane().add(passwordField);
JLabel lblmeter = new JLabel("Meter Number");
lblmeter.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblmeter.setBounds(52, 309, 136, 30);
frmLoginpage.getContentPane().add(lblmeter);
mnumber = new JTextField();
mnumber.setBounds(252, 309, 162, 29);
frmLoginpage.getContentPane().add(mnumber);
mnumber.setColumns(10);
mnumber.addFocusListener(new FocusListener() {
 public void focusGained(FocusEvent fe) {}
 public void focusLost(FocusEvent fe) {
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select * from customer where meter_no =
'"+mnumber.getText()+"'");
 while(rs.next()) {
 Name.setText(rs.getString("name"));
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 });
accounttype.addItemListener(new ItemListener() {
 public void itemStateChanged(ItemEvent ae) {
 String user = (String) accounttype.getSelectedItem();
 if (user.equals("Customer")) {
 lblmeter.setVisible(true);
 mnumber.setVisible(true);
 Name.setEditable(false);

 } else {
 lblmeter.setVisible(false);
 mnumber.setVisible(false);
 Name.setEditable(true);
 }
 }
 });



}
}