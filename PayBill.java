package electricity_billing_system;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class PayBill {
private JFrame frmBill;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
PayBill window = new PayBill("");
window.frmBill.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
String meter;
public PayBill(String meter) {
this.meter = meter;
initialize(meter);
frmBill.setVisible(true);
}
/**
* Initialize the contents of the frame.
*/
private void initialize(String meter) {
frmBill = new JFrame();
frmBill.setTitle("Bill");
frmBill.setBounds(200, 200, 650, 500);
frmBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmBill.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("Meter Number");
lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel.setBounds(38, 53, 140, 28);
frmBill.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Name");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_1.setBounds(38, 101, 140, 28);
frmBill.getContentPane().add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Month");
lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_2.setBounds(38, 145, 140, 28);
frmBill.getContentPane().add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("Units");
lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_3.setBounds(38, 190, 140, 28);
frmBill.getContentPane().add(lblNewLabel_3);
JComboBox Month = new JComboBox();
Month.setBounds(259, 145, 149, 28);
frmBill.getContentPane().add(Month);
Month.addItem("January");
Month.addItem("February");
Month.addItem("March");
Month.addItem("April");
Month.addItem("May");
Month.addItem("June");
Month.addItem("July");
Month.addItem("August");
Month.addItem("September");
Month.addItem("October");
Month.addItem("November");
Month.addItem("December");
JLabel lblNewLabel_4 = new JLabel("Total Bill");
lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_4.setBounds(38, 228, 140, 28);
frmBill.getContentPane().add(lblNewLabel_4);
JLabel lblNewLabel_5 = new JLabel("Status");
lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblNewLabel_5.setBounds(38, 266, 140, 28);
frmBill.getContentPane().add(lblNewLabel_5);
JButton btnNewButton = new JButton("Pay");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 s.executeUpdate("update bill set status = 'Paid' where meter_no =
'"+meter+"' AND month='"+Month.getSelectedItem()+"'");
 JOptionPane.showMessageDialog(null,"Paid Successfully!");
 frmBill.dispose();
 new ChomePage(meter);
 } catch (Exception ae) {
 ae.printStackTrace();
 }
}
});
btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
btnNewButton.setBounds(122, 341, 96, 28);
frmBill.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("Back");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmBill.dispose();
new ChomePage(meter);
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
btnNewButton_1.setBounds(341, 341, 96, 28);
frmBill.getContentPane().add(btnNewButton_1);
JLabel mno = new JLabel("");
mno.setFont(new Font("Tahoma", Font.PLAIN, 18));
mno.setBounds(259, 60, 149, 23);
frmBill.getContentPane().add(mno);
JLabel nam = new JLabel("");
nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
nam.setBounds(259, 108, 149, 23);
frmBill.getContentPane().add(nam);
JLabel uni = new JLabel("");
uni.setFont(new Font("Tahoma", Font.PLAIN, 18));
uni.setBounds(259, 197, 149, 23);
frmBill.getContentPane().add(uni);
JLabel tbill = new JLabel("");
tbill.setFont(new Font("Tahoma", Font.PLAIN, 18));
tbill.setBounds(259, 235, 149, 23);
frmBill.getContentPane().add(tbill);
JLabel sta = new JLabel("\r\n");
sta.setFont(new Font("Tahoma", Font.PLAIN, 18));
sta.setBounds(259, 273, 149, 23);
frmBill.getContentPane().add(sta);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select * from customer where meter_no =
'"+meter+"'");
 while(rs.next()) {
 mno.setText(meter);
 nam.setText(rs.getString("name"));
 }

 rs = s.executeQuery("select * from bill where meter_no = '"+meter+"' AND
month = 'January'");
 while(rs.next()) {
 uni.setText(rs.getString("units"));
 tbill.setText(rs.getString("totalbill"));
 sta.setText(rs.getString("status"));
 }
 } catch (Exception e) {
 e.printStackTrace();
 }

Month.addItemListener(new ItemListener() {
 public void itemStateChanged(ItemEvent ae) {
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select * from bill where meter_no =
'"+meter+"' AND month = '"+Month.getSelectedItem()+"'");
 while(rs.next()) {
 uni.setText(rs.getString("units"));
 tbill.setText(rs.getString("totalbill"));
 sta.setText(rs.getString("status"));
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 });

}
}
