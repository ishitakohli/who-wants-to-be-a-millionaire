import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class frmAbout extends JFrame 
{
  JTextArea txtTitle;                          
  Container cnt;
  public frmAbout()
  {
    setTitle("The Hotel Suraj Executive,Shirur-pune,Maharashtra");
    setSize(550,340);
    setLocation(120,100);
    cnt=getContentPane();
    cnt.setLayout(null);

    JButton btnCLOSE;
    btnCLOSE=new JButton("close");
    btnCLOSE.setBounds(400,260,70,30);
    
  
    cnt.add(btnCLOSE);

    JLabel lbl1;
    lbl1    = new JLabel("About Hotel Managment System");
    lbl1.setBounds(70,20,400,30);
    lbl1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
    cnt.add(lbl1);
     
    JTextArea txtTitle;
    txtTitle    = new JTextArea("                           \n "+
     "                          This is project is developed to fullfill the all requirments\n"+
     "   of the  hotel Suraj Executive . The  Hotel  Suraj is  started  in 2000 , the \n"+
     "   company is continuously rising on the growth chart and  setting  high \n"+
     "   quality standards.Our strict emphasis on quality is combined with the \n"+
     "   latest technology to offer our customers a competative edge.\n\n"+


     "     Since its inception, the company has established a reputaion for itself\n"+
     "   as a supplier of quality porducts.We focus on quality and aim to acheve\n "+
     "  total customer satisfaction, both in the products and services, we offer. \n",10,1);
    
    txtTitle.setEditable(false);
    txtTitle.setBounds(0,70,600,500);
    txtTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    cnt.add(txtTitle);
  }
 
    public static void main(String args[])
    {
    frmAbout frm=new frmAbout();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});

    }
  }
