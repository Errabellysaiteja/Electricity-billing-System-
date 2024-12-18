package electricity_billing_system;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class ViewCustomerinfo {
private JFrame frmViewCustomerDetails;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
ViewCustomerinfo window = new
ViewCustomerinfo("");
window.frmViewCustomerDetails.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
public String meter;
public ViewCustomerinfo(String meter) {
initialize(meter);
frmViewCustomerDetails.setVisible(true);
}
/**
* Initialize the contents of the frame.
*/
private void initialize(String meter) {
frmViewCustomerDetails = new JFrame();
frmViewCustomerDetails.setTitle("view customer details");
frmViewCustomerDetails.setBounds(100, 100, 651, 525);
frmViewCustomerDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmViewCustomerDetails.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("Name");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel.setBounds(37, 52, 100, 23);
frmViewCustomerDetails.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("meter no");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_1.setBounds(37, 102, 100, 23);
frmViewCustomerDetails.getContentPane().add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Address");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_2.setBounds(37, 159, 100, 23);
frmViewCustomerDetails.getContentPane().add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("City");
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_3.setBounds(37, 216, 100, 23);
frmViewCustomerDetails.getContentPane().add(lblNewLabel_3);
JLabel lblNewLabel_4 = new JLabel("State");
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_4.setBounds(350, 52, 64, 23);
frmViewCustomerDetails.getContentPane().add(lblNewLabel_4);
JLabel lblNewLabel_5 = new JLabel("email");
lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_5.setBounds(350, 109, 64, 23);
frmViewCustomerDetails.getContentPane().add(lblNewLabel_5);
JLabel lblNewLabel_6 = new JLabel("phno");
lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_6.setBounds(350, 159, 64, 23);
frmViewCustomerDetails.getContentPane().add(lblNewLabel_6);
JLabel names = new JLabel("");
names.setFont(new Font("Tahoma", Font.PLAIN, 14));
names.setBounds(147, 54, 100, 23);
frmViewCustomerDetails.getContentPane().add(names);
JLabel meterno = new JLabel("");
meterno.setFont(new Font("Tahoma", Font.PLAIN, 14));
meterno.setBounds(147, 104, 100, 23);
frmViewCustomerDetails.getContentPane().add(meterno);
JLabel adder = new JLabel("");
adder.setFont(new Font("Tahoma", Font.PLAIN, 14));
adder.setBounds(147, 161, 100, 23);
frmViewCustomerDetails.getContentPane().add(adder);
JLabel citi = new JLabel("");
citi.setFont(new Font("Tahoma", Font.PLAIN, 14));
citi.setBounds(147, 218, 100, 23);
frmViewCustomerDetails.getContentPane().add(citi);
JLabel sta = new JLabel("");
sta.setFont(new Font("Tahoma", Font.PLAIN, 14));
sta.setBounds(438, 54, 100, 23);
frmViewCustomerDetails.getContentPane().add(sta);
JLabel emai = new JLabel("");
emai.setFont(new Font("Tahoma", Font.PLAIN, 14));
emai.setBounds(438, 111, 100, 23);
frmViewCustomerDetails.getContentPane().add(emai);
JLabel pno = new JLabel("");
pno.setFont(new Font("Tahoma", Font.PLAIN, 14));
pno.setBounds(438, 161, 100, 23);
frmViewCustomerDetails.getContentPane().add(pno);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select * from customer where meter_no =
'"+meter+"'");
 while(rs.next()) {
 names.setText(rs.getString("name"));
 adder.setText(rs.getString("address"));
 citi.setText(rs.getString("city"));
 sta.setText(rs.getString("state"));
 emai.setText(rs.getString("email"));
 pno.setText(rs.getString("phone"));
 meterno.setText(rs.getString("meter_no"));
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
JButton btnNewButton = new JButton("Back");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmViewCustomerDetails.dispose();
new ChomePage(meter);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton.setBounds(248, 307, 100, 32);
frmViewCustomerDetails.getContentPane().add(btnNewButton);
}
}