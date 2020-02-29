import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.sql.*;

class frmGco_details extends JFrame implements ActionListener
{
  JLabel lblTitle;

  JLabel  lblGUEST_ID;
  JLabel  lblGUEST_NAME;
  JLabel  lblROOM_NO;
  JLabel  lblINDATE;
  JLabel  lblOUTDATE;
  JLabel  lblOUTTIME;
  JLabel  lblREMARKS;

  JTextField   txtGUEST_ID;
  JTextField   txtGUEST_NAME;
  JTextField   txtROOM_NO;
  JTextField   txtINDATE;
  JTextField   txtOUTDATE;
  JTextField   txtOUTTIME;
  JTextField   txtREMARKS;

  JButton   btnFIRST;
  JButton   btnPREV;
  JButton   btnNEXT;
  JButton   btnLAST;
  JButton   btnADD;
  JButton   btnEDIT;
  JButton   btnFIND;
  JButton   btnDELETE;
  JButton   btnCLOSE;
  JButton   btnREFRESH;
  JButton   btnSAVE;
  JButton   btnCLEAR;
  JButton   btnRETURN;
  JButton   btnUPDATE;
  JButton   btnCANCLE;


  JPanel   pMAIN;
  JPanel   pADD;
  JPanel   pEDIT;                                 

  Container cnt;
  Connection cn;
  Statement st;
  ResultSet rs,rs1;
  int rcount=0,rno=0;
  String mGUEST_ID="";


  public void connect()
  {
  try{
    //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
     //cn=DriverManager.getConnection("jdbc:oracle:oci8:@","system","manager");
  
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      cn=DriverManager.getConnection("jdbc:odbc:Ashish","scott","tiger");
      }catch(SQLException e){}
      catch(Exception e) {}
      }
      public void openRecord()
      {
      try{
      st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
      rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_NO,TO_CHAR(INDATE,'DD-MON-YYYY') AS INDATE,TO_CHAR(OUTDATE,'DD-MON-YYYY') AS OUTDATE,OUTTIME,REMARKS FROM GUEST_CHECK_OUT_DETAILS");
      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}
      Statement st=cn.createStatement();
      }catch(SQLException ex){}
      }

    public frmGco_details()
    {
    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");
    setSize(650,470);
    setLocation(100,70);
    cnt=getContentPane();
   
    cnt.setLayout(null);

    lblTitle    = new JLabel("Guest Check Out details");
    lblGUEST_ID    = new JLabel("GUEST ID");
    lblGUEST_NAME     = new JLabel("GUEST NAME");
    lblROOM_NO   =new JLabel("ROOM NO");
    lblINDATE  =new JLabel("INDATE");
    lblOUTDATE   = new JLabel("OUTDATE");
    lblOUTTIME=   new JLabel("OUTTIME");
    lblREMARKS   = new JLabel("REMARKS");

    lblTitle.setBounds(185,35,300,30);
    lblGUEST_ID.setBounds(150,90,150,30);
    lblGUEST_NAME.setBounds(150,120,150,30);
    lblROOM_NO.setBounds(150,150,150,30);
    lblINDATE.setBounds(150,180,150,30);
    lblOUTDATE.setBounds(150,210,150,30);
    lblOUTTIME.setBounds(150,240,150,30);
    lblREMARKS.setBounds(150,270,150,30);

    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
    lblGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblINDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblOUTDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblOUTTIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblREMARKS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));  
    
    lblTitle.setForeground(Color.red);
    lblGUEST_ID.setForeground(Color.black);
    lblGUEST_NAME.setForeground(Color.black);
    lblROOM_NO.setForeground(Color.black);
    lblINDATE.setForeground(Color.black);
    lblOUTDATE.setForeground(Color.black);
    lblOUTTIME.setForeground(Color.black);
    lblREMARKS.setForeground(Color.black);

    cnt.add(lblTitle);
    cnt.add(lblGUEST_ID);
    cnt.add(lblGUEST_NAME);
    cnt.add(lblROOM_NO);
    cnt.add(lblINDATE);
    cnt.add(lblOUTDATE);
    cnt.add(lblOUTTIME);

    cnt.add(lblREMARKS);

    txtGUEST_ID= new JTextField(12);
    txtGUEST_NAME  = new JTextField(30);
    txtROOM_NO= new JTextField(8);
    txtINDATE = new JTextField(9);
    txtOUTDATE = new JTextField(9);
    txtOUTTIME = new JTextField(9);
    txtREMARKS= new JTextField(9);

    txtGUEST_ID.setBounds(330,90,100,25);
    txtGUEST_NAME.setBounds(330,120,170,25);
    txtROOM_NO.setBounds(330,150,70,25);
    txtINDATE.setBounds(330,180,140,25);
    txtOUTDATE.setBounds(330,210,140,25);
    txtOUTTIME.setBounds(330,240,100,25);
    txtREMARKS.setBounds(330,270,120,25);
   
    txtGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtINDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtOUTDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtOUTTIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtREMARKS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));

    cnt.add(txtGUEST_ID);
    cnt.add(txtGUEST_NAME);
    cnt.add(txtROOM_NO);
    cnt.add(txtINDATE);
    cnt.add(txtOUTDATE);
    cnt.add(txtOUTTIME);
    cnt.add(txtREMARKS);
    
    btnFIRST=new JButton("First");
    btnPREV=new JButton("Prev");
    btnNEXT=new JButton("Next");
    btnLAST=new JButton("Last");
    btnADD=new JButton("Add");
    btnSAVE=new JButton("Save");
    btnCLEAR=new JButton("Clear");
    btnRETURN=new JButton("Retrurn");
    btnEDIT=new JButton("Edit");
    btnUPDATE=new JButton("Update");
    btnCANCLE=new JButton("Cancle");

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
    pMAIN.setBounds(100,320,420,90);
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
    pADD.setBounds(170,320,240,30);
    pADD.setLayout(new GridLayout(1,3));
    cnt.add(pADD);

    pADD.add(btnSAVE);
    pADD.add(btnCLEAR);
    pADD.add(btnRETURN);

    pEDIT=new JPanel();
    pEDIT.setBounds(230,320,160,30);
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
    p1.setBounds(100,75,420,230);
    cnt.add(p1);

    JPanel p=new JPanel();    
    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,3),"Room Details Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
    p.setForeground(Color.red);
    p.setBackground(Color.pink);
    p.setBounds(1,1,640,440);
    cnt.add(p);

    pADD.setVisible(false);
    pEDIT.setVisible(false);
    disableEntry();
    connect();
    openRecord();
    if(rcount>0)try{showRecord();}catch(Exception e){}
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
      try{mGUEST_ID=rs.getString(1);}catch(SQLException ex){}
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
      String fGUEST_ID=JOptionPane.showInputDialog(null,"Enter Guest id No. to Find","Find Dialog",JOptionPane.PLAIN_MESSAGE);
      try{
      Statement st=cn.createStatement();
      ResultSet rs1=st.executeQuery("SELECT * FROM GUEST_CHECK_OUT_DETAILS WHERE GUEST_ID="+mGUEST_ID);
      if(rs1.next())
      {
        JOptionPane.showMessageDialog(null,"The Search Guest id No. Found Successfully","Search Result",JOptionPane.INFORMATION_MESSAGE);
        rs.beforeFirst();
        while(rs.next())
          if(rs.getString(1).equals(mGUEST_ID))
          {
            showRecord();
            break;
          }
      }
      else
        JOptionPane.showMessageDialog(null,"The Search Guest id No. Not Found","Search Result",JOptionPane.INFORMATION_MESSAGE);
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
          rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_NO,TO_CHAR(INDATE,'DD-MON-YYYY') AS INDATE,TO_CHAR(OUTDATE,'DD-MON-YYYY') AS OUTDATE,OUTTIME,REMARKS FROM GUEST_CHECK_OUT_DETAILS"); 
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
      txtGUEST_ID.setText(rs.getString(1));
      txtGUEST_NAME.setText(rs.getString(2));
      txtROOM_NO.setText(rs.getString(3));
      txtINDATE.setText(rs.getString(4));
      txtOUTDATE.setText(rs.getString(5));
      txtOUTTIME.setText(rs.getString(6));
      txtREMARKS.setText(rs.getString(7));     
    }catch(Exception e){}
  }

  public void clearEntry()
  {
      txtGUEST_ID.setText("");
      txtGUEST_NAME.setText("");
      txtROOM_NO.setText("");
      txtINDATE.setText("");
      txtOUTDATE.setText("");
      txtOUTTIME.setText("");
      txtREMARKS.setText("");
      
  }
  public void enableEntry()
  {
      txtGUEST_ID.setEditable(true);
   
   txtGUEST_NAME.setEditable(true);
      txtROOM_NO.setEditable(true);
      txtINDATE.setEditable(true);
      txtOUTDATE.setEditable(true);
      txtOUTTIME.setEditable(true);
      txtREMARKS.setEditable(true);
     
  }
  public void disableEntry()
  {
      txtGUEST_ID.setEditable(false);
      txtGUEST_NAME.setEditable(false);
      txtROOM_NO.setEditable(false);
      txtINDATE.setEditable(false);
      txtOUTDATE.setEditable(false);
      txtOUTTIME.setEditable(false);
      txtREMARKS.setEditable(false);    
  }

  public boolean saveRecord()
  {
    boolean result=true;
    try{
    String sql  = "INSERT INTO GUEST_CHECK_OUT_DETAILS VALUES("+
                  "'"  +txtGUEST_ID.getText()   + "'," +
                  "'"  +txtGUEST_NAME.getText() + "'," +
                  "'"  +txtROOM_NO.getText() + "'," +
                  "'"  +txtINDATE.getText()+ "',"+
                  "'"  +txtOUTDATE.getText() + "',"+ 
                  "'"  +txtOUTTIME.getText() + "'," +
                  "'"  +txtREMARKS.getText() + ")"; 

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
    String sql  = "UPDATE GUEST_CHECK_OUT_DETAILS SET "+
                  
                  "GUEST_ID='" + txtGUEST_ID.getText() + "'," +
       
           "GUEST_NAME='" + txtGUEST_NAME.getText() + "'," +
                  "ROOM_NO='" +txtROOM_NO.getText() + "'," +
                  "INDATE='"+txtINDATE.getText()+ ","+
                  "OUTDATE='" +txtOUTDATE.getText() + "," +
                  "OUTTIME='" +txtOUTTIME.getText() + "," +
                  "REMARKS='" + txtREMARKS.getText()+")";

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
    frmGco_details frm=new frmGco_details();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
    }
    }
