import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainForm extends JFrame implements ActionListener
{
  JMenuBar mbar;
  JMenu mnu;
  JMenuItem itm;
  Container cnt;
  public MainForm()
  {
    setSize(800,600);
    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");
    setLocation(10,10);
    mbar=new JMenuBar();

    mnu=new JMenu("Room status");
    itm=(JMenuItem)mnu.add(new JMenuItem("Room status")); 
    itm.addActionListener(this);
    itm.setActionCommand("Room_status");

    itm=(JMenuItem)mnu.add(new JMenuItem("Reservation Form")); 
    itm.addActionListener(this);
    itm.setActionCommand("Reservation");

    mbar.add(mnu);
    

    mnu=new JMenu("Guest Details");
    itm=(JMenuItem)mnu.add(new JMenuItem("General"));
    itm.addActionListener(this);
    itm.setActionCommand("General");

    itm=(JMenuItem)mnu.add(new JMenuItem("Company"));
    itm.addActionListener(this);
    itm.setActionCommand("Company");
    
    mbar.add(mnu);

    mnu=new JMenu("Miscellaneous");

    itm=(JMenuItem)mnu.add(new JMenuItem("Fooding/Beverage"));
    itm.addActionListener(this);
    itm.setActionCommand("Fooding");

    itm=(JMenuItem)mnu.add(new JMenuItem("Mescellaneous Details"));
    itm.addActionListener(this);
    itm.setActionCommand("Mis");

    mbar.add(mnu);

    mnu=(JMenu)mnu.add(new JMenu("Billing"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Guest Check Out Bill"));
    itm.addActionListener(this);
    itm.setActionCommand("Check Out");

    itm=(JMenuItem)mnu.add(new JMenuItem("Paid Out By Guest"));
    itm.addActionListener(this);
    itm.setActionCommand("Paid Out");
    mbar.add(mnu);

    mnu=(JMenu)mnu.add(new JMenu("Reports"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Complate Information"));
    itm.addActionListener(this);
    itm.setActionCommand("complate");

    itm=(JMenuItem)mnu.add(new JMenuItem("Total Room Rent"));
    itm.addActionListener(this);
    itm.setActionCommand("total");

    itm=(JMenuItem)mnu.add(new JMenuItem("Miscelleneous"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Gross Report"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Greetings Of Appriciation"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Cash Credit Status"));
    mbar.add(mnu);

    mnu=(JMenu)mnu.add(new JMenu("Receptions"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Reception's Detail"));
    itm.addActionListener(this);
    itm.setActionCommand("Reception");

    itm=(JMenuItem)mnu.add(new JMenuItem("Reception's Check In"));
    itm.addActionListener(this);
    itm.setActionCommand("Checkin");
    itm=(JMenuItem)mnu.add(new JMenuItem("Reception's Check Out"));
    itm.addActionListener(this);


    itm.setActionCommand("Checkout");
    mbar.add(mnu);

    mnu=(JMenu)mnu.add(new JMenu("Windows"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Cascade"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Window List"));
    mbar.add(mnu);

    mnu=(JMenu)mnu.add(new JMenu("Help"));
    itm=(JMenuItem)mnu.add(new JMenuItem("Content And Index"));
    itm=(JMenuItem)mnu.add(new JMenuItem("About H.M System"));
    itm.addActionListener(this);
    itm.setActionCommand("About");
    mbar.add(mnu);

    
    mnu=(JMenu)new JMenu("Exit");
    mnu.addActionListener(this);
    mnu.setActionCommand("Ext");
    mbar.add(mnu);
    setJMenuBar(mbar);
    cnt=getContentPane();
    cnt.setLayout(null);
    ImageIcon img=new ImageIcon("c:\\jdk1.4\\bin\\picMain.jpg");
    JLabel lblimg=new JLabel(img);
    lblimg.setBounds(1,1,800,600);
    cnt.add(lblimg);
  }
 
  public void actionPerformed(ActionEvent e)
  {

    if(e.getActionCommand().equals("Room_status"))
     {
      frmRoom_status frm =new frmRoom_status();
      frm.show();
     }


     if(e.getActionCommand().equals("Reservation"))
     {
      frmReservation frm =new frmReservation();
      frm.show();
     }


     if(e.getActionCommand().equals("complate"))
     {
      rptcominfo rptc =new rptcominfo();
      rptc.show();
     }
     if(e.getActionCommand().equals("total"))
     {
      rptrtotal rptc =new rptrtotal();
      rptc.show();
     }

      if(e.getActionCommand().equals("General"))
     {
      frmGg_details frm =new frmGg_details();
      frm.show();
     }


     if(e.getActionCommand().equals("Company"))
       {
        frmCg_details frm =new frmCg_details();
        frm.show();
       }


     if(e.getActionCommand().equals("Fooding"))
       {
        frmFb_details frm =new frmFb_details();
        frm.show();
       }

     if(e.getActionCommand().equals("Mis"))
       {
        frmMis_details frm =new frmMis_details();
        frm.show();
       }
    
     if(e.getActionCommand().equals("Check Out"))
      {
       frmGco_details frm =new frmGco_details();
       frm.show();
      }

     if(e.getActionCommand().equals("Paid Out"))
       {
        frmGb_details frm =new frmGb_details();
        frm.show();
       }

     if(e.getActionCommand().equals("Reception"))
      {
       frmReception_details frm =new frmReception_details();
       frm.show();
      }

     if(e.getActionCommand().equals("Checkin"))
      {
      frmR_checkin frm =new frmR_checkin();
      frm.show();
     }

    if(e.getActionCommand().equals("Checkout"))
      {
      frmR_checkout frm =new frmR_checkout();
      frm.show();
      }
    if(e.getActionCommand().equals("About"))
      {
      frmAbout frm=new frmAbout();
      frm.show();
      }
      if(e.getActionCommand().equals("Ext"))
       {
        setVisible(false);
        System.exit(0);
       }
  }

  public static void main(String args[])
  {
    MainForm frm=new MainForm();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
  }
}
