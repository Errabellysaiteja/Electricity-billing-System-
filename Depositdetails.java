package electricity_billing_system;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DepositDetails {
private JFrame frmDepositDetails;
private JTable table;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
DepositDetails window = new DepositDetails();
window.frmDepositDetails.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
public DepositDetails() {
initialize();
frmDepositDetails.setVisible(true);
}
/**
* Initialize the contents of the frame.
*/
private void initialize() {
frmDepositDetails = new JFrame();
frmDepositDetails.setTitle("Deposit Details");
frmDepositDetails.setBounds(100, 100, 651, 525);
frmDepositDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmDepositDetails.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("Search by meter no");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel.setBounds(10, 31, 205, 23);
frmDepositDetails.getContentPane().add(lblNewLabel);
JComboBox meterno = new JComboBox();
meterno.setBounds(174, 34, 117, 21);
frmDepositDetails.getContentPane().add(meterno);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
 ResultSet rs = s.executeQuery("select * from customer");
 while(rs.next()) {
 meterno.addItem(rs.getString("meter_no"));
 }
 } catch (Exception e) {
 e.printStackTrace();
 }
JLabel lblNewLabel_1 = new JLabel("Search by month");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setBounds(328, 31, 144, 23);
frmDepositDetails.getContentPane().add(lblNewLabel_1);
JComboBox month = new JComboBox();
month.setBounds(468, 33, 117, 23);
frmDepositDetails.getContentPane().add(month);
month.addItem("");
month.addItem("January");
month.addItem("February");
month.addItem("March");
month.addItem("April");
month.addItem("May");
month.addItem("June");
month.addItem("July");
month.addItem("August");
month.addItem("September");
month.addItem("October");
month.addItem("November");
month.addItem("December");
JButton btnNewButton = new JButton("Search");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from bill where
meter_no = '"+meterno.getSelectedItem()+"' and month = '"+month.getSelectedItem()+"'");
ResultSetMetaData rmd = rs.getMetaData();
int cc = rmd.getColumnCount();
String cols[] = new String[cc];
for(int i = 0; i< cc; i++)
cols[i] = rmd.getColumnName(i+1);
DefaultTableModel model = (DefaultTableModel)
table.getModel();
model.setColumnIdentifiers(cols);
while(rs.next()) {
String[] row =
{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
model.addRow(row);
}
if (month.getSelectedItem().equals("")) {
 JOptionPane.showMessageDialog(null, "Please Select
the Month first");
}
} catch (Exception e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
btnNewButton.setBounds(55, 76, 124, 23);
frmDepositDetails.getContentPane().add(btnNewButton);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(31, 149, 564, 154);
frmDepositDetails.getContentPane().add(scrollPane);
table = new JTable();
scrollPane.setViewportView(table);
JButton btnNewButton_1 = new JButton("back");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmDepositDetails.dispose();
new HomePage();
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
btnNewButton_1.setBounds(468, 79, 103, 23);
frmDepositDetails.getContentPane().add(btnNewButton_1);
}
}
