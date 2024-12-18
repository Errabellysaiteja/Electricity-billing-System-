package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Newcustomer extends JFrame implements ActionListener{
 JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
 JButton next, cancel;
 JLabel lblmeter;
 Newcustomer() {
 setSize(700, 500);
 setLocation(400, 200);

 JPanel p = new JPanel();
 p.setLayout(null);
 p.setBackground(SystemColor.control);
 getContentPane().add(p);

 JLabel heading = new JLabel("New Customer");
 heading.setBounds(243, 10, 200, 25);
 heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
 p.add(heading);

 JLabel lblname = new JLabel("Customer Name");
 lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblname.setBounds(100, 80, 174, 20);
 p.add(lblname);

 tfname = new JTextField();
 tfname.setBounds(302, 85, 200, 25);
 p.add(tfname);

 JLabel lblmeterno = new JLabel("Meter Number");
 lblmeterno.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblmeterno.setBounds(100, 120, 174, 20);
 p.add(lblmeterno);

 lblmeter = new JLabel("");
 lblmeter.setFont(new Font("Tahoma", Font.ITALIC, 18));
 lblmeter.setBounds(302, 120, 100, 20);
 p.add(lblmeter);

 Random ran = new Random();
 long number = ran.nextLong() % 1000000;
 lblmeter.setText("" + Math.abs(number));

 JLabel lbladdress = new JLabel("Address");
 lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
 lbladdress.setBounds(100, 160, 174, 20);
 p.add(lbladdress);

 tfaddress = new JTextField();
 tfaddress.setBounds(302, 161, 200, 25);
 p.add(tfaddress);

 JLabel lblcity = new JLabel("City");
 lblcity.setFont(new Font("Tahoma", Font.BOLD, 20));

 lblcity.setBounds(100, 200, 174, 20);
 p.add(lblcity);

 tfcity = new JTextField();
 tfcity.setBounds(302, 201, 200, 25);
 p.add(tfcity);

 JLabel lblstate = new JLabel("State");
 lblstate.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblstate.setBounds(100, 240, 174, 20);
 p.add(lblstate);

 tfstate = new JTextField();
 tfstate.setBounds(302, 245, 200, 25);
 p.add(tfstate);

 JLabel lblemail = new JLabel("Email");
 lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblemail.setBounds(100, 280, 174, 20);
 p.add(lblemail);

 tfemail = new JTextField();
 tfemail.setBounds(302, 285, 200, 25);
 p.add(tfemail);

 JLabel lblphone = new JLabel("Phone Number");
 lblphone.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblphone.setBounds(100, 320, 174, 20);
 p.add(lblphone);

 tfphone = new JTextField();
 tfphone.setBounds(302, 325, 200, 25);
 p.add(tfphone);

 next = new JButton("Next");
 next.setFont(new Font("Tahoma", Font.BOLD, 18));
 next.setBounds(120, 390, 100,25);

 next.setForeground(SystemColor.desktop);
 next.addActionListener(this);
 p.add(next);

 cancel = new JButton("Cancel");
 cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
 cancel.setBounds(250, 390, 113,25);
 cancel.setForeground(SystemColor.desktop);
 cancel.addActionListener(this);
 p.add(cancel);

 JButton btnNewButton = new JButton("back");
 btnNewButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {


 }
 });
 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
 btnNewButton.setBounds(408, 393, 113, 25);
 p.add(btnNewButton);

 setVisible(true);
 }

 public void actionPerformed(ActionEvent ae) {

try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
String name = tfname.getText();
String meter_no = lblmeter.getText();
String address = tfaddress.getText();
String city = tfcity.getText();
String state = tfstate.getText();
String email = tfemail.getText();
String phone = tfphone.getText();
String qry = "insert into customer values('"+name+"',
'"+meter_no+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
s.executeUpdate(qry);
JOptionPane.showMessageDialog(null, "customer
addded successfully");
setVisible(false);
new MeterInfo(meter_no);
 } catch (Exception re) {
 re.printStackTrace();
 }
}

 public static void main(String[] args) {
 new Newcustomer();
 }
}