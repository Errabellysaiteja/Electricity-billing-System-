package electricity_billing_system;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class CalculateBill {
private JFrame frmCalculateElectricityBill;
private JTextField nam;
private JTextField add;
private JTextField uni;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
CalculateBill window = new CalculateBill();
window.frmCalculateElectricityBill.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
public CalculateBill() {
initialize();
frmCalculateElectricityBill.setVisible(true);
}
29
/**
* Initialize the contents of the frame.
*/
private void initialize() {
frmCalculateElectricityBill = new JFrame();
frmCalculateElectricityBill.setTitle("calculate electricity bill");
frmCalculateElectricityBill.setBounds(100, 100, 651, 525);
frmCalculateElectricityBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmCalculateElectricityBill.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("Calculate electricity bill");
lblNewLabel.setBounds(163, 10, 316, 25);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
frmCalculateElectricityBill.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Meter no");
lblNewLabel_1.setBounds(111, 52, 117, 35);
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
frmCalculateElectricityBill.getContentPane().add(lblNewLabel_1);
JComboBox comboBox = new JComboBox();
comboBox.setBounds(266, 52, 151, 31);
frmCalculateElectricityBill.getContentPane().add(comboBox);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select * from customer");
 while(rs.next()) {
 comboBox.addItem(rs.getString("meter_no"));
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
JLabel lblNewLabel_2 = new JLabel("Name\r\n");
lblNewLabel_2.setBounds(111, 115, 117, 35);
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
frmCalculateElectricityBill.getContentPane().add(lblNewLabel_2);
nam = new JTextField();
nam.setBounds(266, 115, 151, 31);
frmCalculateElectricityBill.getContentPane().add(nam);
nam.setColumns(10);
JLabel lblNewLabel_3 = new JLabel("Address\r\n");
lblNewLabel_3.setBounds(111, 178, 117, 35);
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
frmCalculateElectricityBill.getContentPane().add(lblNewLabel_3);
add = new JTextField();
add.setBounds(266, 178, 151, 31);
frmCalculateElectricityBill.getContentPane().add(add);
add.setColumns(10);
JLabel lblNewLabel_4 = new JLabel("Units consumed");
lblNewLabel_4.setBounds(111, 247, 151, 35);
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
frmCalculateElectricityBill.getContentPane().add(lblNewLabel_4);
uni = new JTextField();
uni.setBounds(266, 247, 151, 31);
frmCalculateElectricityBill.getContentPane().add(uni);
uni.setColumns(10);
JLabel lblNewLabel_5 = new JLabel("month");
lblNewLabel_5.setBounds(111, 315, 117, 25);
lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
frmCalculateElectricityBill.getContentPane().add(lblNewLabel_5);
JComboBox months = new JComboBox();
months.setBounds(266, 315, 151, 31);
frmCalculateElectricityBill.getContentPane().add(months);
months.addItem("");
months.addItem("January");
months.addItem("February");
months.addItem("March");
months.addItem("April");
months.addItem("May");
months.addItem("June");
months.addItem("July");
months.addItem("August");
months.addItem("September");
months.addItem("October");
months.addItem("November");
months.addItem("December");
JButton btnNewButton = new JButton("Submit");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String meter_no = (String) comboBox.getSelectedItem();
 String month = (String) months.getSelectedItem();
 String units = uni.getText();
 int totalbill = 0;
 int unit_consumed = Integer.parseInt(units);
 String query = "select * from tax";

 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery(query);

 while(rs.next()) {
 totalbill += unit_consumed *
Integer.parseInt(rs.getString("cost_per_unit"));
 totalbill += Integer.parseInt(rs.getString("meter_rent"));
 totalbill += Integer.parseInt(rs.getString("service_charge"));
 totalbill += Integer.parseInt(rs.getString("service_tax"));
 totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
 totalbill += Integer.parseInt(rs.getString("fixed_tax"));
 }
 } catch (Exception ge) {
 ge.printStackTrace();
 }
 int option = JOptionPane.showConfirmDialog(null, "do you want to Submit
","Confrimation", JOptionPane.YES_NO_OPTION);
 if(option == JOptionPane.YES_OPTION) {
 nam.setText(null);
 add.setText(null);
 uni.setText(null);

 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 String query1 = null;
 query1 = "insert into bill values('"+meter_no+"', '"+month+"', '"+units+"',
'"+totalbill+"', 'Not Paid')";
 s.executeUpdate(query1);
 JOptionPane.showMessageDialog(null, "Bill Calculated successfully");

 } catch (Exception re) {
 re.printStackTrace();
 }
 }
 else {

 }
}
});
btnNewButton.setBounds(163, 397, 117, 25);
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
frmCalculateElectricityBill.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("Back");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmCalculateElectricityBill.dispose();
HomePage hp = new HomePage();
}
});
btnNewButton_1.setBounds(327, 397, 117, 25);
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
frmCalculateElectricityBill.getContentPane().add(btnNewButton_1);
JButton btnNewButton_1_1 = new JButton("Back");
btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_1_1.setBounds(327, 397, 117, 25);
frmCalculateElectricityBill.getContentPane().add(btnNewButton_1_1);
}
}
