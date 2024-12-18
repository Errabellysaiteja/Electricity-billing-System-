package electricity_billing_system;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class HomePage {
private JFrame frmHome;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
HomePage window = new HomePage();
window.frmHome.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the application.
*/
public HomePage() {
initialize();
frmHome.setVisible(true);

}
/**
* Initialize the contents of the frame.
*/
private void initialize() {
frmHome = new JFrame();
frmHome.setTitle("home");
frmHome.setBounds(100, 100, 651, 525);
frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmHome.getContentPane().setLayout(null);
JButton btnNewButton = new JButton("Customer Details");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmHome.dispose();
CustomerDetails Cdetails = new CustomerDetails();
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton.setBounds(232, 159, 180, 40);
frmHome.getContentPane().add(btnNewButton);
JButton btnNewButton_1 = new JButton("Deposit Details");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmHome.dispose();
DepositDetails Ddetails = new DepositDetails();
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_1.setBounds(232, 230, 180, 40);
frmHome.getContentPane().add(btnNewButton_1);
JButton btnNewButton_2 = new JButton("Calculate Bill");
btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmHome.dispose();
CalculateBill win = new CalculateBill();
}

});
btnNewButton_2.setBounds(232, 302, 180, 40);
frmHome.getContentPane().add(btnNewButton_2);
JButton btnNewButton_3 = new JButton("New Customer");
btnNewButton_3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
frmHome.dispose();
Newcustomer cus = new Newcustomer();
}
});
btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_3.setBounds(232, 87, 180, 40);
frmHome.getContentPane().add(btnNewButton_3);
JButton back = new JButton("LogOut");
back.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
 int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to
log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
 if(option == JOptionPane.YES_OPTION) {
 frmHome.dispose();
 Login cu = new Login();
 }
}
});
back.setFont(new Font("Tahoma", Font.BOLD, 12));
back.setBounds(538, 10, 89, 34);
frmHome.getContentPane().add(back);
}
}