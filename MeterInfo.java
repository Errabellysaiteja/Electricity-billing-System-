package electricity_billing_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class MeterInfo extends JFrame implements ActionListener{
 JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
 JButton next, cancel;
 JLabel lblmeter;
 Choice meterlocation, metertype, phasecode, billtype;
 String meternumber;
 MeterInfo(String meternumber) {
 this.meternumber = meternumber;

 setSize(700, 500);
 setLocation(400, 200);

 JPanel p = new JPanel();
 p.setLayout(null);
 p.setBackground(SystemColor.control);
 getContentPane().add(p);

 JLabel heading = new JLabel("Meter Information");
 heading.setBounds(228, 10, 200, 25);
 heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
 p.add(heading);

 JLabel lblname = new JLabel("Meter Number");
 lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblname.setBounds(100, 80, 174, 20);
 p.add(lblname);

 JLabel lblmeternumber = new JLabel(meternumber);
 lblmeternumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
 lblmeternumber.setBounds(311, 80, 100, 20);
 p.add(lblmeternumber);

 JLabel lblmeterno = new JLabel("Meter Location");
 lblmeterno.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblmeterno.setBounds(100, 122, 174, 20);
 p.add(lblmeterno);

 meterlocation = new Choice();
 meterlocation.add("Outside");
 meterlocation.add("Inside");
 meterlocation.setBounds(311, 124, 200, 20);
 p.add(meterlocation);

 JLabel lbladdress = new JLabel("Meter Type");
 lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
 lbladdress.setBounds(100, 172, 174, 20);
 p.add(lbladdress);

 metertype = new Choice();

 metertype.add("Electric Meter");
 metertype.add("Solar Meter");
 metertype.add("Smart Meter");
 metertype.setBounds(311, 174, 200, 20);
 p.add(metertype);

 JLabel lblcity = new JLabel("Phase Code");
 lblcity.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblcity.setBounds(100, 215, 174, 20);
 p.add(lblcity);

 phasecode = new Choice();
 phasecode.add("011");
 phasecode.add("022");
 phasecode.add("033");
 phasecode.add("044");
 phasecode.add("055");
 phasecode.add("066");
 phasecode.add("077");
 phasecode.add("088");
 phasecode.add("099");
 phasecode.setBounds(311, 217, 200, 20);
 p.add(phasecode);

 JLabel lblstate = new JLabel("Bill Type");
 lblstate.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblstate.setBounds(100, 261, 174, 20);
 p.add(lblstate);

 billtype = new Choice();
 billtype.add("Normal");
 billtype.add("Industial");
 billtype.setBounds(311, 263, 200, 20);
 p.add(billtype);

 JLabel lblemail = new JLabel("Days");
 lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblemail.setBounds(100, 307, 174, 20);
 p.add(lblemail);

 JLabel lblemails = new JLabel("30 Days");
 lblemails.setFont(new Font("Tahoma", Font.ITALIC, 18));
 lblemails.setBounds(311, 308, 100, 20);
 p.add(lblemails);

 JLabel lblphone = new JLabel("Note");
 lblphone.setFont(new Font("Tahoma", Font.BOLD, 20));
 lblphone.setBounds(100, 346, 174, 20);
 p.add(lblphone);

 JLabel lblphones = new JLabel("By Default Bill is calculated for 30 days only");
 lblphones.setFont(new Font("Tahoma", Font.ITALIC, 18));
 lblphones.setBounds(309, 347, 500, 20);

 p.add(lblphones);

 next = new JButton("Submit");
 next.setFont(new Font("Tahoma", Font.BOLD, 18));
 next.setBounds(226, 406, 113,25);
 next.setBackground(SystemColor.control);
 next.setForeground(SystemColor.desktop);
 next.addActionListener(this);
 p.add(next);
 setVisible(true);
 }

 public void actionPerformed(ActionEvent ae) {
 if (ae.getSource() == next) {
 String meter_no = meternumber;
 String meter_location = meterlocation.getSelectedItem();
 String meter_type = metertype.getSelectedItem();
 String phase_code = phasecode.getSelectedItem();
 String bill_type = billtype.getSelectedItem();
 String days = "30";

 String query = "insert into meter_info values('"+meter_no+"', '"+meter_location+"',
'"+meter_type+"', '"+phase_code+"', '"+bill_type+"', '"+days+"')";

 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
Statement s = con.createStatement();
s.executeUpdate(query);

 JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
 setVisible(false);

 } catch (Exception e) {
 e.printStackTrace();
 }
 } else {
 setVisible(false);
 }
 }

 public static void main(String[] args) {
 new MeterInfo("");
 }
}
