import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

class frmR_checkout extends JFrame
{
  JLabel  lblTitle;
  JLabel  lblRECEP_CODE;
  JLabel  lblARR_RECEP_TIME;
  JLabel  lblDEP_RECEP_TIME;

  JTextField  txtARR_RECEP_TIME;
  JTextField  txtDEP_RECEP_TIME;

  JComboBox   cmbRECEP_CODE;
  
  JButton   btnCHECKIN;
  JButton   btnCLOSE;

  JPanel pMAIN;                           
  Container cnt;

  public frmR_checkout()
  {
    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");
    setSize(550,375);
    setLocation(120,100);
    cnt=getContentPane();
    cnt.setLayout(null);
    lblTitle    = new JLabel("RECEPTION   LOGOUT ");
    lblTitle.setBounds(140,40,300,28);
    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,20));
    lblTitle.setForeground(Color.red);
    cnt.add(lblTitle);

    lblRECEP_CODE    = new JLabel("RECEPTION CODE");
    lblRECEP_CODE.setBounds(80,120,300,20);
    lblRECEP_CODE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
    lblRECEP_CODE.setForeground(Color.black);


    lblARR_RECEP_TIME = new JLabel("ARR RECEP TIME");
    lblARR_RECEP_TIME.setBounds(80,160,300,20);
    lblARR_RECEP_TIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
    lblARR_RECEP_TIME.setForeground(Color.black);

    lblDEP_RECEP_TIME = new JLabel("DEP RECEP TIME");    
    lblDEP_RECEP_TIME.setBounds(80,200,300,20);
    lblDEP_RECEP_TIME. setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
    lblDEP_RECEP_TIME. setForeground(Color.black);

    cnt.add(lblRECEP_CODE);
    cnt.add(lblARR_RECEP_TIME);
    cnt.add(lblDEP_RECEP_TIME);

    cmbRECEP_CODE   = new JComboBox();
    txtARR_RECEP_TIME    = new JTextField(30);
    txtDEP_RECEP_TIME     = new JTextField(30);
   
    cmbRECEP_CODE.setBounds(300,120,130,25);
    txtARR_RECEP_TIME.setBounds(300,160,130,25);
    txtDEP_RECEP_TIME.setBounds(300,200,130,25);

    cnt.add(cmbRECEP_CODE);
    cnt.add(txtARR_RECEP_TIME);
    cnt.add(txtDEP_RECEP_TIME);

    pMAIN=new JPanel();
    pMAIN.setBounds(150,250,200,30);
    pMAIN.setLayout(new GridLayout(0,2));
    pMAIN.setBorder(BorderFactory.createTitledBorder(""));
    pMAIN.setBackground(Color.white);
    pMAIN.setForeground(Color.red);
    cnt.add(pMAIN);

    btnCHECKIN=new JButton("CHECKIN");
    btnCHECKIN.setForeground(Color.white);
    btnCHECKIN.setBackground(Color.blue);

    btnCLOSE=new JButton("CLOSE");
    btnCLOSE.setForeground(Color.white);
    btnCLOSE.setBackground(Color.blue);


    pMAIN.add(btnCHECKIN);
    pMAIN.add(btnCLOSE);

    JPanel p1=new JPanel();    
    p1.setBorder(BorderFactory.createTitledBorder(""));
    p1.setForeground(Color.red);
    p1.setBackground(Color.pink);
    p1.setBounds(60,100,400,200);
    cnt.add(p1);


JPanel p=new JPanel();
p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,3)," Reception Logout Form ",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
    p.setForeground(Color.red);
    p.setBackground(Color.pink);
    p.setBounds(1,1,540,350);
    cnt.add(p);

    }


    public static void main(String args[])
    {
    frmR_checkout frm=new frmR_checkout();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
    }
  }
