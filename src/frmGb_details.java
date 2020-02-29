import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.sql.*;

class frmGb_details extends JFrame implements ActionListener
{
  JLabel  lblTitle;
  JLabel  lblBILL_NO;
  JLabel  lblBDATE;
  JLabel  lblGUEST_ID;
  JLabel  lblGUEST_NAME;
  JLabel  lblROOM_NO;
  JLabel  lblROOM_CHARGE;
  JLabel  lblFB_BILL;
  JLabel  lblMSC_BILL;
  JLabel  lblTOT;
  JLabel  lblTAX;
  JLabel  lblADV;
  JLabel  lblBAL;

  JTextField txtBILL_NO;
  JTextField txtBDATE;
  JTextField txtGUEST_ID;
  JTextField txtGUEST_NAME;
  JTextField txtROOM_NO;
  JTextField txtROOM_CHARGE;
  JTextField txtFB_BILL;
  JTextField txtMSC_BILL;
  JTextField txtTOT;
  JTextField txtTAX;
  JTextField txtADV;
  JTextField txtBAL;
   
  JButton btnFIRST;
  JButton btnPREV;
  JButton btnNEXT;
  JButton btnLAST;
  JButton btnADD;
  JButton btnEDIT;
  JButton btnFIND;

  JButton btnDELETE;
  JButton btnCLOSE;
  JButton btnREFRESH;
  JButton btnSAVE;
  JButton btnCLEAR;
  JButton btnRETURN;
  JButton btnUPDATE;
  JButton btnCANCLE;

  JPanel pMAIN,pADD,pEDIT;                                 
  Container cnt;
  Connection cn;
  Statement st;
  ResultSet rs,rs1;
  int rcount=0,rno=0;
  String mBILL_NO="";


  public void connect()
  {
  try{
      //    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      //   cn=DriverManager.getConnection("jdbc:oracle:oci8:@","APJ","PROJECTS");
  
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      cn=DriverManager.getConnection("jdbc:odbc:Ashish","APJ","PROJECTS");
      }catch(SQLException e){}
      catch(Exception e) {}
      }
      public void openRecord()
      {
      try{
      st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
      rs=st.executeQuery("SELECT BILL_NO,BDATE,GUEST_ID,GUEST_NAME,ROOM_NO,ROOM_CHARGE,FB_BILL,MSC_BILL,TOT,TAX,ADV,BAL FROM GUEST_BILLING_DETAILS");
      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}
      Statement st=cn.createStatement();
      }catch(SQLException ex){}
      }

    public frmGb_details()

    {
    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");
    setSize(780,580);
    cnt=getContentPane();
    cnt.setLayout(null);

    lblTitle    = new JLabel("Guest billing details");
    lblTitle.setBounds(270,20,350,30);
    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
    lblTitle.setForeground(Color.red);
    cnt.add(lblTitle);

    lblBILL_NO   = new JLabel("BILL NO");
    lblBDATE     = new JLabel("BILLING DATE ");
    lblGUEST_ID    = new JLabel("GUEST ID");
    lblGUEST_NAME     = new JLabel("GUEST NAME");
    lblROOM_NO   =new JLabel("ROOM NO");
    lblROOM_CHARGE  =new JLabel("ROOM CHARGE");
    lblFB_BILL   = new JLabel("FODDING BILL");
    lblTOT=   new JLabel("TOTAL");
    lblMSC_BILL   = new JLabel("MSCELLANEOUS BILL");
    lblTAX     = new JLabel("PAID TAX");
    lblADV= new JLabel("TOTAL ADV");
    lblBAL= new JLabel("BALANCE");


    lblBILL_NO.setBounds(200,70,150,30);
    lblBILL_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblBILL_NO.setForeground(Color.black);

    lblBDATE.setBounds(200,100,150,30);
    lblBDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblBDATE.setForeground(Color.black);


    lblGUEST_ID.setBounds(200,130,150,30);
    lblGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_ID.setForeground(Color.black);


    lblGUEST_NAME.setBounds(200,160,150,30);
    lblGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_NAME.setForeground(Color.black);

    lblROOM_NO.setBounds(200,190,150,30);

    lblROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_NO.setForeground(Color.black);

    lblROOM_CHARGE.setBounds(200,220,150,30);
    lblROOM_CHARGE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_CHARGE.setForeground(Color.black);

    lblFB_BILL.setBounds(200,250,150,30);
    lblFB_BILL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblFB_BILL.setForeground(Color.black);

    lblMSC_BILL.setBounds(200,280,200,30);
    lblMSC_BILL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblMSC_BILL.setForeground(Color.black);

    lblTOT.setBounds(200,310,150,30);
    lblTOT.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTOT.setForeground(Color.black);

    lblTAX.setBounds(200,340,150,30);
    lblTAX.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTAX.setForeground(Color.black);

    lblADV.setBounds(200,370,150,30);
    lblADV.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblADV.setForeground(Color.black);

    lblBAL.setBounds(200,400,150,30);
    lblBAL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblBAL.setForeground(Color.black);


    cnt.add(lblBILL_NO);
    cnt.add(lblBDATE);
    cnt.add(lblGUEST_ID);
    cnt.add(lblGUEST_NAME);
    cnt.add(lblROOM_NO);
    cnt.add(lblROOM_CHARGE);
    cnt.add(lblFB_BILL);
    cnt.add(lblMSC_BILL);
    cnt.add(lblTOT);
    cnt.add(lblTAX);
    cnt.add(lblADV);
    cnt.add(lblBAL);


    txtBILL_NO = new JTextField(15);
    txtBDATE= new JTextField(15);
    txtGUEST_ID= new JTextField(12);
    txtGUEST_NAME  = new JTextField(30);
    txtROOM_NO= new JTextField(8);
    txtROOM_CHARGE = new JTextField(9);
    txtFB_BILL = new JTextField(9);
    txtMSC_BILL = new JTextField(9);
    txtTOT= new JTextField(9);
    txtTAX= new JTextField(9);
    txtADV = new JTextField(9);
    txtBAL= new JTextField(9);

    txtBILL_NO.setBounds(420,70,100,25);
    txtBDATE.setBounds(420,100,130,25);
    txtGUEST_ID.setBounds(420,130,90,25);
    txtGUEST_NAME.setBounds(420,160,200,25);
    txtROOM_NO.setBounds(420,190,75,25);
    txtROOM_CHARGE.setBounds(420,220,150,25);
    txtFB_BILL.setBounds(420,250,100,25);
    txtMSC_BILL.setBounds(420,280,150,25);
    txtTOT.setBounds(420,310,100,25);
    txtTAX.setBounds(420,340,80,25);
    txtADV.setBounds(420,370,70,25);
    txtBAL.setBounds(420,400,100,25);

    cnt.add(txtBILL_NO);
    cnt.add(txtBDATE);
    cnt.add(txtGUEST_ID);
    cnt.add(txtGUEST_NAME);
    cnt.add(txtROOM_NO);
    cnt.add(txtROOM_CHARGE);
    cnt.add(txtFB_BILL);
    cnt.add(txtMSC_BILL);
    cnt.add(txtTOT);
    cnt.add(txtTAX);
    cnt.add(txtADV);
    cnt.add(txtBAL);
    
    btnFIRST=new JButton("First");
    btnPREV=new JButton("Prev");
    btnNEXT=new JButton("Next");
    btnLAST=new JButton("Last");
    btnADD=new JButton("ADD");
    btnSAVE=new JButton("Save");

    btnCLEAR=new JButton("Clear");
    btnRETURN=new JButton("Return");
    btnEDIT=new JButton("Edit");
    btnUPDATE=new JButton("Update");
    btnCANCLE=new JButton("Cancel");
    btnFIND=new JButton("Find");
    btnDELETE=new JButton("Delete");
    btnCLOSE=new JButton("Close");
    btnREFRESH=new JButton("Refresh");

    btnFIRST.setBackground(Color.blue);
    btnPREV.setBackground(Color.blue);
    btnNEXT.setBackground(Color.blue);
    btnLAST.setBackground(Color.blue);
    btnADD.setBackground(Color.blue);
    btnSAVE.setBackground(Color.blue);
    btnCLEAR.setBackground(Color.blue);
    btnRETURN.setBackground(Color.blue);
    btnEDIT.setBackground(Color.blue);
    btnUPDATE.setBackground(Color.blue);
    btnCANCLE.setBackground(Color.blue);
    btnFIND.setBackground(Color.blue);
    btnDELETE.setBackground(Color.blue);
    btnCLOSE.setBackground(Color.blue);
    btnREFRESH.setBackground(Color.blue);

    btnFIRST.setForeground(Color.white);
    btnPREV.setForeground(Color.white);
    btnNEXT.setForeground(Color.white);
    btnLAST.setForeground(Color.white);
    btnADD.setForeground(Color.white);
    btnSAVE.setForeground(Color.white);
    btnCLEAR.setForeground(Color.white);
    btnRETURN.setForeground(Color.white);
    btnEDIT.setForeground(Color.white);
    btnUPDATE.setForeground(Color.white);
    btnCANCLE.setForeground(Color.white);
    btnFIND.setForeground(Color.white);
    btnDELETE.setForeground(Color.white);
    btnCLOSE.setForeground(Color.white);
    btnREFRESH.setForeground(Color.white);

    btnREFRESH.setToolTipText("Enter to show Report of Employee");
    btnFIRST.addActionListener(this);
    btnPREV.addActionListener(this);

    btnNEXT.addActionListener(this);
    btnLAST.addActionListener(this);
    btnADD.addActionListener(this);
    btnSAVE.addActionListener(this);
    btnCLEAR.addActionListener(this);
    btnRETURN.addActionListener(this);
    btnEDIT.addActionListener(this);
    btnUPDATE.addActionListener(this);
    btnCANCLE.addActionListener(this);
    btnFIND.addActionListener(this);
    btnDELETE.addActionListener(this);
    btnCLOSE.addActionListener(this);
    btnREFRESH.addActionListener(this);

     
    pMAIN=new JPanel();
    pMAIN.setBounds(200,440,430,90);
    pMAIN.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,5),"Main Menu",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.red));
    pMAIN.setLayout(new GridLayout(2,5));
    pMAIN.setBackground(Color.white);
   

    pMAIN.add(btnFIRST);
    pMAIN.add(btnPREV);
    pMAIN.add(btnNEXT);
    pMAIN.add(btnLAST);
    pMAIN.add(btnCLOSE);
    pMAIN.add(btnADD);
    pMAIN.add(btnEDIT);
    pMAIN.add(btnFIND);
    pMAIN.add(btnDELETE);
    pMAIN.add(btnREFRESH);
    cnt.add(pMAIN);

    pADD=new JPanel();
    pADD.setBounds(290,450,240,30);
    pADD.setLayout(new GridLayout(1,3));
    
    pADD.add(btnSAVE);
    pADD.add(btnCLEAR);
    pADD.add(btnRETURN);

    cnt.add(pADD);

    pEDIT=new JPanel();
    pEDIT.setBounds(320,450,160,30);
    pEDIT.setLayout(new GridLayout(1,2));

    pEDIT.add(btnUPDATE);
    pEDIT.add(btnCANCLE);    
    cnt.add(pEDIT);

    pADD.setVisible(false);
    pEDIT.setVisible(false);

    JPanel p1=new JPanel();       
    p1.setBorder(BorderFactory.createTitledBorder(""));
    p1.setForeground(Color.red);
    p1.setBackground(Color.pink);
    p1.setBounds(150,60,520,375);
    cnt.add(p1);

    JPanel p=new JPanel();    
    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,5),"Room Details Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
    p.setForeground(Color.pink);
    p.setBackground(Color.pink);
    p.setBounds(1,1,790,550);
    cnt.add(p);

 }


  public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==btnFIRST)
    {
      try{
        if(rcount>0)
        {
          rs.first();
          rno=1;
          showRecord();
        }

      }catch(Exception ex){}
    }
    if(e.getSource()==btnPREV)
    {
      try{
        if(rcount>0 && rno>1)
        {
          rs.previous();
          rno--;
          showRecord();
        }
      }catch(Exception ex){}
    }

    if(e.getSource()==btnNEXT)
    {
      try{
        if(rcount>0 && rno<rcount)
        {
          rs.next();
          rno++;
          showRecord();
        }
      }catch(Exception ex){}
    }

    if(e.getSource()==btnLAST)
    {
      try{
        if(rcount>0)
        {
          rs.last();
          rno=rcount;
          showRecord();
        }
      }catch(Exception ex){}
    }
    if(e.getSource()==btnADD)
    {
      pMAIN.setVisible(false);
      pADD.setVisible(true);
      clearEntry();
      enableEntry();
    }
    if(e.getSource()==btnSAVE)

    {
      if(saveRecord())
        JOptionPane.showMessageDialog(null,"1 Record Saved Successfully","Save Result",JOptionPane.INFORMATION_MESSAGE);
      else
        JOptionPane.showMessageDialog(null,"Record not Saved","Save Result",JOptionPane.INFORMATION_MESSAGE);
    }
    if(e.getSource()==btnCLEAR)
    {
      clearEntry();
    }
    if(e.getSource()==btnRETURN)
    {
      pADD.setVisible(false);
      pMAIN.setVisible(true);
      disableEntry();
      if(rcount>0) try{showRecord();}catch(Exception ex){}
    }
    if(e.getSource()==btnEDIT)
    {
      pMAIN.setVisible(false);
      pEDIT.setVisible(true);
      enableEntry();
      try{mBILL_NO=rs.getString(1);}catch(SQLException ex){}
    }
    if(e.getSource()==btnUPDATE)
    {
      if(updateRecord())
        JOptionPane.showMessageDialog(null,"1 Record Updated Successfully","Update Result",JOptionPane.INFORMATION_MESSAGE);
         
      else
        JOptionPane.showMessageDialog(null,"Record not Updated","Update Result",JOptionPane.INFORMATION_MESSAGE);
    }
     if(e.getSource()==btnCLOSE)
    {
    setVisible(false);
    }
    if(e.getSource()==btnCANCLE)
    {
      pEDIT.setVisible(false);
      pMAIN.setVisible(true);
      openRecord();
 
     showRecord();
      disableEntry();
    }
    if(e.getSource()==btnFIND)
    {
      boolean result=true;
      String fROOM_NO=JOptionPane.showInputDialog(null,"Enter Bill No. to Find","Find Dialog",JOptionPane.PLAIN_MESSAGE);
      try{
      Statement st=cn.createStatement();
      ResultSet rs1=st.executeQuery("SELECT * FROM GUEST_BILLING_DETAILS WHERE BILL_NO="+mBILL_NO);
      if(rs1.next())
      {
        JOptionPane.showMessageDialog(null,"The Search Bill No. Found Successfully","Search Result",JOptionPane.INFORMATION_MESSAGE);
        rs.beforeFirst();
        while(rs.next())
          if(rs.getString(1).equals(mBILL_NO))
          {
            showRecord();
            break;
          }
      }
      else
        JOptionPane.showMessageDialog(null,"The Search Bill No. Not Found","Search Result",JOptionPane.INFORMATION_MESSAGE);
      }catch(Exception ex){}
    }
    if(e.getSource()==btnDELETE)
    {
      if(deleteRecord())
        JOptionPane.showMessageDialog(null,"1 Record Deleted Successfully","Delete Result",JOptionPane.INFORMATION_MESSAGE);        
      else
        JOptionPane.showMessageDialog(null,"Record not Deleted","Delete Result",JOptionPane.INFORMATION_MESSAGE);        
    }
   if(e.getSource()==btnREFRESH)
    {
      try{
           
          rs.close();
          st.close();
          st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
          rs=st.executeQuery("SELECT BILL_NO,BDATE,GUEST_ID,GUEST_NAME,ROOM_NO,ROOM_CHARGE,FB_BILL,MSC_BILL,TOT,TAX,ADV,BAL FROM GUEST_BILLING_DETAILS"); 
          rcount=0;
          while(rs.next())
          rcount++;
          if(rcount>0)
          {
           rno=1;
           rs.first();
           showRecord();
        }
      }catch(Exception ex){}
    }
  }
  public void showRecord()
  {
    try{         

      txtBILL_NO.setText(rs.getString(1));
      txtBDATE.setText(rs.getString(2));
      txtGUEST_ID.setText(rs.getString(3));
      txtGUEST_NAME.setText(rs.getString(4));
      txtROOM_NO.setText(rs.getString(5));
      txtROOM_CHARGE.setText(rs.getString(6));
      txtFB_BILL.setText(rs.getString(7));
      txtMSC_BILL.setText(rs.getString(8));
      txtTOT.setText(rs.getString(9));
      txtTAX.setText(rs.getString(10));
      txtADV.setText(rs.getString(11));
      txtBAL.setText(rs.getString(12));
      

      
    }catch(Exception e){}
  }
  public void clearEntry()
  {


      txtBILL_NO.setText("");
      txtBDATE.setText("");
      txtGUEST_ID.setText("");

      txtGUEST_NAME.setText("");
      txtROOM_NO.setText("");
      txtROOM_CHARGE.setText("");
      txtFB_BILL.setText("");
      txtMSC_BILL.setText("");
      txtTOT.setText("");
      txtTAX.setText("");
      txtADV.setText("");
      txtBAL.setText("");
      
  }
  public void enableEntry()
  {


      txtBILL_NO.setEditable(true);
      txtBDATE.setEditable(true);
      txtGUEST_ID.setEditable(true);
      txtGUEST_NAME.setEditable(true);
      txtROOM_NO.setEditable(true);
      txtROOM_CHARGE.setEditable(true);
      txtFB_BILL.setEditable(true);
      txtMSC_BILL.setEditable(true);
      txtTOT.setEditable(true);
      txtTAX.setEditable(true);
      txtADV.setEditable(true);
      txtBAL.setEditable(true);

     
  }
  public void disableEntry()
  {

      txtBILL_NO.setEditable(false);
      txtBDATE.setEditable(false);
      txtGUEST_ID.setEditable(false);
      txtGUEST_NAME.setEditable(false);
      txtROOM_NO.setEditable(false);
      txtROOM_CHARGE.setEditable(false);
      txtFB_BILL.setEditable(false);
      txtMSC_BILL.setEditable(false);
      txtTOT.setEditable(false);
      txtTAX.setEditable(false);
      txtADV.setEditable(false);
      txtBAL.setEditable(false);     
     
  }

  public boolean saveRecord()
  {
    boolean result=true;
    try{
    String sql  = "INSERT INTO ROOM_DETAILS VALUES("+
                  "'"  +txtBILL_NO.getText() + "'," +
                  "'" + txtGUEST_ID.getText() + "'," +
                  "'" + txtGUEST_NAME.getText() + "'," +
                  "'"  +txtROOM_NO.getText() + "'," +
                  txtROOM_CHARGE.getText()+ ","+
                  txtFB_BILL.getText() + ","+
                  txtMSC_BILL.getText() + "," +
                  txtTOT.getText() + "," +
                  txtTAX.getText() + "," +
                  txtADV.getText() + "," +
                  txtBAL.getText()+ ")";
                 

           Statement st=cn.createStatement();
      System.out.println(sql);
      st.execute(sql);
    }catch(SQLException ex){result=false;}
    return result;
  }
 public boolean updateRecord()
  {
    boolean result=true;
    try{
    String sql  = "UPDATE ROOM_DETAILS SET "+
                  "BILL_NO='" +txtROOM_NO.getText() + "'," +
                  "GUEST_ID='" + txtGUEST_ID.getText() + "'," +
                  "GUEST_NAME='" + txtGUEST_NAME.getText() + "'," +
                  "ROOM_NO='" +txtROOM_NO.getText() + "'," +
                  "ROOM_CHARGE="+txtROOM_CHARGE.getText()+ ","+
                  "FB_BILL=" +txtFB_BILL.getText() + "," +
                  "MSC_BILL=" +txtMSC_BILL.getText() + "," +
                  "TOT=" + txtTOT.getText() + "," +
                  "ADV=" + txtADV.getText() + "," +
                  "BAL=" +txtBAL.getText()  +")";             
        Statement st=cn.createStatement();
      System.out.println(sql);
    st.execute(sql); 
    }catch(SQLException ex){result=false;}

    return result;
  }
  public boolean deleteRecord()
  {
    boolean result=true;
      try{
        if(rcount>0)
        {
          rs.deleteRow();
          if(rcount==1)
          {
            rcount=0;
            rno=0;
            clearEntry();
          }
          else if(rno==rcount)
          {
            rs.last();
            showRecord();
            rcount--;
            rno=rcount;
          }
          else
          {
            rs.next();
            rcount--;
            showRecord();
          }
        }    
      }catch(Exception ex){result=false;}
    return result;
  }

    public static void main(String args[])
    {
    frmGb_details frm=new frmGb_details();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
    }
    }
