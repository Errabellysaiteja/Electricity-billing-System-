package electricity_billing_system;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class UpdateCustomerinfo {
private JFrame frmModifyCustomerDetails;
private JTextField adder;
private JTextField citi;
private JTextField sta;
private JTextField ema;
private JTextField pno;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
UpdateCustomerinfo window = new
UpdateCustomerinfo("");
window.frmModifyCustomerDetails.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
public UpdateCustomerinfo(String meter) {
initialize(meter);
frmModifyCustomerDetails.setVisible(true);
}
/**
* Initialize the contents of the frame.
*/
private void initialize(String meter) {
frmModifyCustomerDetails = new JFrame();
frmModifyCustomerDetails.setTitle("modify customer details");
frmModifyCustomerDetails.setBounds(100, 100, 651, 525);
frmModifyCustomerDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmModifyCustomerDetails.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("Name");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel.setBounds(97, 52, 117, 22);
frmModifyCustomerDetails.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Meter no");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_1.setBounds(97, 94, 117, 22);
frmModifyCustomerDetails.getContentPane().add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Address");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_2.setBounds(97, 137, 117, 22);
frmModifyCustomerDetails.getContentPane().add(lblNewLabel_2);
adder = new JTextField();
adder.setBounds(259, 140, 180, 23);
frmModifyCustomerDetails.getContentPane().add(adder);
adder.setColumns(10);
JLabel lblNewLabel_3 = new JLabel("city");
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_3.setBounds(97, 183, 117, 22);
frmModifyCustomerDetails.getContentPane().add(lblNewLabel_3);
citi = new JTextField();
citi.setBounds(259, 186, 180, 23);
frmModifyCustomerDetails.getContentPane().add(citi);
citi.setColumns(10);
JLabel lblNewLabel_4 = new JLabel("state");
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_4.setBounds(97, 227, 117, 22);
frmModifyCustomerDetails.getContentPane().add(lblNewLabel_4);
sta = new JTextField();
sta.setBounds(259, 230, 180, 23);
frmModifyCustomerDetails.getContentPane().add(sta);
sta.setColumns(10);
JLabel lblNewLabel_5 = new JLabel("email");
lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_5.setBounds(97, 274, 117, 22);
frmModifyCustomerDetails.getContentPane().add(lblNewLabel_5);
ema = new JTextField();
ema.setFont(new Font("Tahoma", Font.PLAIN, 18));
ema.setBounds(259, 273, 180, 23);
frmModifyCustomerDetails.getContentPane().add(ema);
ema.setColumns(10);
JLabel lblNewLabel_6 = new JLabel("phone no");
lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
lblNewLabel_6.setBounds(97, 319, 117, 22);
frmModifyCustomerDetails.getContentPane().add(lblNewLabel_6);
pno = new JTextField();
pno.setBounds(259, 322, 180, 23);
frmModifyCustomerDetails.getContentPane().add(pno);
pno.setColumns(10);
JButton btnNewButton = new JButton("Update");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String address = adder.getText();
 String city = citi.getText();
 String state = sta.getText();
 String email = ema.getText();
 String phone = pno.getText();

 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 s.executeUpdate("update customer set address = '"+address+"', city =
'"+city+"', state = '"+state+"', email = '"+email+"', phone = '"+phone+"' where meter_no =
'"+meter+"'");
 JOptionPane.showMessageDialog(null, "User Information Updated
Successfully");
 frmModifyCustomerDetails.dispose();
 new ChomePage(meter);
 } catch (Exception ae) {
 ae.printStackTrace();
 }
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton.setBounds(156, 385, 117, 22);
frmModifyCustomerDetails.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("Back");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmModifyCustomerDetails.dispose();
new ChomePage(meter);
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton_1.setBounds(350, 385, 117, 22);
frmModifyCustomerDetails.getContentPane().add(btnNewButton_1);
JLabel nam = new JLabel("");
nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
nam.setBounds(259, 52, 180, 23);
frmModifyCustomerDetails.getContentPane().add(nam);
JLabel mno = new JLabel("");
mno.setFont(new Font("Tahoma", Font.PLAIN, 18));
mno.setBounds(259, 94, 180, 23);
frmModifyCustomerDetails.getContentPane().add(mno);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select * from customer where meter_no =
'"+meter+"'");
 while(rs.next()) {
 nam.setText(rs.getString("name"));
 adder.setText(rs.getString("address"));
 citi.setText(rs.getString("city"));
 sta.setText(rs.getString("state"));
 ema.setText(rs.getString("email"));
 pno.setText(rs.getString("phone"));
 mno.setText(rs.getString("meter_no"));
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
}
}
