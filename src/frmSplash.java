import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class frmSplash extends JDialog
{
  JLabel lbl1,lbl2,lbl3;
  Container cnt;
  frmSplash()
  {
    setTitle("Hotel Management System");
    setSize(400,360);
    setLocation(200,70);
    cnt=getContentPane();

    lbl1=new JLabel("Hotel");
    lbl1.setFont(new Font("Arial",Font.BOLD,40));
    lbl1.setBounds(80,90,150,40);
    lbl1.setForeground(Color.red);
    cnt.add(lbl1);

    lbl2=new JLabel("Management ");
    lbl2.setBounds(160,180,150,40);
    lbl2.setFont(new Font("Arial",Font.BOLD,40));
    lbl2.setForeground(Color.red);
    cnt.add(lbl2);

    lbl3=new JLabel("System");
    lbl3.setBounds(200,270,150,40);
    lbl3.setFont(new Font("Arial",Font.BOLD,40));
    lbl3.setForeground(Color.red);
    cnt.add(lbl3);
    
  }
  public static void main(String args[])
  {
    frmSplash frm=new frmSplash();
    frm.show();
  }
}
