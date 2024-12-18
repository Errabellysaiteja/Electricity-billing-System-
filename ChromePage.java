package electricity_billing_system;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
public class ChomePage {
private JFrame frame;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
ChomePage window = new ChomePage("");
window.frame.setVisible(true);
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
public ChomePage(String meter) {
this.meter=meter;
initialize();
frame.setVisible(true);
}
/**
* Initialize the contents of the frame.

*/
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 651, 525);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
JButton btnNewButton = new JButton("Modify Details");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frame.dispose();
new UpdateCustomerinfo(meter);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton.setBounds(232, 159, 180, 40);
frame.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("Pay Bill");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frame.dispose();
new PayBill(meter);
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_1.setBounds(232, 230, 180, 40);
frame.getContentPane().add(btnNewButton_1);
JButton btnNewButton_2 = new JButton("Generate Bill");
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frame.dispose();
new Gbill(meter);
}
});
btnNewButton_2.setBounds(232, 302, 180, 40);
frame.getContentPane().add(btnNewButton_2);
JButton btnNewButton_3 = new JButton("View Details");
btnNewButton_3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
new ViewCustomerinfo(meter);
}
});
btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_3.setBounds(232, 87, 180, 40);
frame.getContentPane().add(btnNewButton_3);
JButton btnNewButton_4 = new JButton("logout");
btnNewButton_4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int option = JOptionPane.showConfirmDialog(null, "Are you
sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
 if(option == JOptionPane.YES_OPTION) {
 frame.dispose();
 Login cu = new Login();
 }
}
});
btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
btnNewButton_4.setBounds(542, 10, 85, 21);
frame.getContentPane().add(btnNewButton_4);
}
}
