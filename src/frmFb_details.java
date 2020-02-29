import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.sql.*;

class frmFb_details extends JFrame implements ActionListener
{
  JLabel  lblTitle;
  JLabel  lblGUEST_ID;
  JLabel  lblGUEST_NAME;
  JLabel  lblROOM_NO;
  JLabel  lblDDATE;
  JLabel  lblTYPE;
  JLabel  lblAMT;
  JLabel  lblRECEP_NO;
  JLabel  lblPAID;
  JLabel  lblTOT_BILL;
  JLabel  lblTOT_PAID;
  JLabel  lblTOT_BAL;


  JTextField   txtGUEST_ID;
  JTextField   txtGUEST_NAME;
  JTextField   txtROOM_NO;
  JTextField   txtDDATE;
  JTextField   txtTYPE;
  JTextField   txtAMT;
  JTextField   txtRECEP_NO;
  JTextField   txtPAID;
  JTextField   txtTOT_BILL;
  JTextField   txtTOT_PAID;
  JTextField   txtTOT_BAL;


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
      rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_NO,DDATE,TYPE,AMT,RECEP_NO,PAID,TOT_BILL,TOT_PAID,TOT_BAL FROM FOODING_DETAILS");
      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}

      Statement st=cn.createStatement();
      }catch(SQLException ex){}
     }


  public frmFb_details()
  {
    setTitle("The Hotel Suraj Executive,Shirur-pune,Maharashtra");
    setSize(780,580);
    cnt=getContentPane();
    cnt.setLayout(null);
    lblTitle    = new JLabel("Fooding Beverage Details");
    lblTitle.setBounds(220,30,350,30);
    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
    lblTitle.setForeground(Color.red);
    cnt.add(lblTitle);    

    lblGUEST_ID    = new JLabel("GUEST ID");
    lblGUEST_ID.setBounds(200,70,100,30);
    lblGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_ID.setForeground(Color.black);

    lblGUEST_NAME     = new JLabel("GUEST NAME");
    lblGUEST_NAME.setBounds(200,100,200,30);
    lblGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_NAME.setForeground(Color.black);

    lblROOM_NO   =new JLabel("ROOM NO");  
    lblROOM_NO.setBounds(200,130,100,30);
    lblROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_NO.setForeground(Color.black);

    lblTYPE    = new JLabel("TYPE");
    lblTYPE.setBounds(200,160,100,30);
    lblTYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTYPE.setForeground(Color.black);

    lblDDATE    = new JLabel("DDATE");
    lblDDATE.setBounds(200,190,100,30);
    lblDDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblDDATE.setForeground(Color.black);

    lblAMT     = new JLabel("AMT");
    lblAMT.setBounds(200,220,100,30);
    lblAMT.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));

    lblAMT.setForeground(Color.black);

    lblRECEP_NO = new JLabel("RECEP NO");
    lblRECEP_NO.setBounds(200,250,100,30);
    lblRECEP_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblRECEP_NO.setForeground(Color.black);

    lblPAID = new JLabel("PAID");
    lblPAID.setBounds(200,280,100,30);
    lblPAID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblPAID.setForeground(Color.black);

    lblTOT_BILL    = new JLabel("TOTAL BILL");
    lblTOT_BILL.setBounds(200,310,100,30);
    lblTOT_BILL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTOT_BILL.setForeground(Color.black);

    lblTOT_PAID    = new JLabel("TOTAL PAID");
    lblTOT_PAID.setBounds(200,340,100,30);
    lblTOT_PAID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTOT_PAID.setForeground(Color.black);

    lblTOT_BAL     = new JLabel("TOTAL BAL");
    lblTOT_BAL.setBounds(200,370,100,30);
    lblTOT_BAL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTOT_BAL.setForeground(Color.black);


    cnt.add(lblGUEST_ID);
    cnt.add(lblGUEST_NAME);
    cnt.add(lblROOM_NO);
    cnt.add(lblDDATE);
    cnt.add(lblTYPE);
    cnt.add(lblAMT);
    cnt.add(lblRECEP_NO);
    cnt.add(lblPAID);
    cnt.add(lblTOT_BILL);
    cnt.add(lblTOT_PAID);
    cnt.add(lblTOT_BAL);

    txtGUEST_ID   = new JTextField(10);
    txtGUEST_NAME     = new JTextField(30);
    txtROOM_NO = new JTextField(50);
    txtDDATE   = new JTextField(50);
    txtTYPE = new JTextField(10);

    txtAMT    = new JTextField(9);
    txtRECEP_NO= new JTextField(15);
    txtPAID = new JTextField(15);
    txtTOT_BILL  = new JTextField(15);
    txtTOT_PAID  = new JTextField(15);
    txtTOT_BAL     = new JTextField(15);

    txtGUEST_ID.setBounds(400,70,100,25);
    txtGUEST_NAME.setBounds(400,100,200,25);
    txtROOM_NO.setBounds(400,130,80,25);
    txtDDATE.setBounds(400,160,140,25);
    txtTYPE.setBounds(400,190,80,25);
    txtAMT.setBounds(400,220,100,25);
    txtRECEP_NO.setBounds(400,250,80,25);
    txtPAID.setBounds(400,280,120,25);
    txtTOT_BILL.setBounds(400,310,140,25);
    txtTOT_PAID.setBounds(400,340,100,25);
    txtTOT_BAL.setBounds(400,370,100,25);


    cnt.add(txtGUEST_ID);
    cnt.add(txtGUEST_NAME);
    cnt.add(txtROOM_NO);
    cnt.add(txtDDATE);
    cnt.add(txtTYPE);
    cnt.add(txtAMT);
    cnt.add(txtRECEP_NO);
    cnt.add(txtPAID);
    cnt.add(txtTOT_BILL);
    cnt.add(txtTOT_PAID);
    cnt.add(txtTOT_BAL);

    btnFIRST=new JButton("First");
    btnPREV=new JButton("Prev");
    btnNEXT=new JButton("Next");
    btnLAST=new JButton("Last");
    btnADD=new JButton("Add");
    btnSAVE=new JButton("Save");
    btnCLEAR=new JButton("Clear");
    btnRETURN=new JButton("Return");
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
    pMAIN.setBounds(150,420,440,90);
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

    pADD=new JPanel();
    pADD.setBounds(250,410,240,35);
    pADD.setLayout(new GridLayout(1,3));


    pADD.add(btnSAVE);
    pADD.add(btnCLEAR);
    pADD.add(btnRETURN);

    pEDIT=new JPanel();
    pEDIT.setBounds(280,410,160,35);
    pEDIT.setLayout(new GridLayout(1,2));


    pEDIT.add(btnUPDATE);
    pEDIT.add(btnCANCLE);

    cnt.add(pMAIN);
    cnt.add(pADD);
    cnt.add(pEDIT);

    pADD.setVisible(false);
    pEDIT.setVisible(false);

    JPanel p=new JPanel();


    JPanel p1=new JPanel();    
    p1.setBorder(BorderFactory.createTitledBorder(""));
    p1.setForeground(Color.red);
    p1.setBackground(Color.pink);
    p1.setBounds(100,60,550,350);
    cnt.add(p1);

    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,5),"Fooding Beverage Details Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
    p.setForeground(Color.red);
    p.setBackground(Color.pink);
    p.setBounds(1,1,790,550);
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
      String fGUEST_ID=JOptionPane.showInputDialog(null,"Enter Guest id. to Find","Find Dialog",JOptionPane.PLAIN_MESSAGE);
      try{
      Statement st=cn.createStatement();
      ResultSet rs1=st.executeQuery("SELECT * FROM FOODING_DETAILS WHERE GUEST_ID="+fGUEST_ID);
      if(rs1.next())
      {
        JOptionPane.showMessageDialog(null,"The Search Guest id. Found Successfully","Search Result",JOptionPane.INFORMATION_MESSAGE);
        rs.beforeFirst();
        while(rs.next())
          if(rs.getString(1).equals(fGUEST_ID))
          {
            showRecord();
            break;
          }
      }
      else
        JOptionPane.showMessageDialog(null,"The Search Guest id. Not Found","Search Result",JOptionPane.INFORMATION_MESSAGE);
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
          rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_NO,DDATE,TYPE,AMT,RECEP_NO,PAID,TOT_BILL,TOT_PAID,TOT_BAL FROM FOODING_DETAILS"); 
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
      txtDDATE.setText(rs.getString(4));
      txtTYPE.setText(rs.getString(5));
      txtAMT.setText(rs.getString(6));
      txtRECEP_NO.setText(rs.getString(7));
      txtPAID.setText(rs.getString(8));
      txtTOT_BILL.setText(rs.getString(9));
      txtTOT_PAID.setText(rs.getString(10));
      txtTOT_BAL.setText(rs.getString(11));

    }catch(Exception e){}
  }
  public void clearEntry()
  {
      txtGUEST_ID.setText("");
      txtGUEST_NAME.setText("");
      txtROOM_NO.setText("");

      txtDDATE.setText("");
      txtTYPE.setText("");
      txtAMT.setText("");
      txtRECEP_NO.setText("");
      txtPAID.setText("");
      txtTOT_BILL.setText("");
      txtTOT_PAID.setText("");
      txtTOT_BAL.setText("");
          
  }
  public void enableEntry()
  {

      txtGUEST_ID.setEditable(true);
      txtGUEST_NAME.setEditable(true);
      txtROOM_NO.setEditable(true);
      txtDDATE.setEditable(true);
      txtTYPE.setEditable(true);
      txtAMT.setEditable(true);
      txtRECEP_NO.setEditable(true);
      txtPAID.setEditable(true);
      txtTOT_BILL.setEditable(true);
      txtTOT_PAID.setEditable(true);
      txtTOT_BAL.setEditable(true);    
     
  }
  public void disableEntry()
  {
      txtGUEST_ID.setEditable(false);
      txtGUEST_NAME.setEditable(false);
      txtROOM_NO.setEditable(false);
      txtDDATE.setEditable(false);
      txtTYPE.setEditable(false);
      txtAMT.setEditable(false);
      txtRECEP_NO.setEditable(false);
      txtPAID.setEditable(false);
      txtTOT_BILL.setEditable(false);
      txtTOT_PAID.setEditable(false);
      txtTOT_BAL.setEditable(false);    
  }


  public boolean saveRecord()
  {
    boolean result=true;

    try{
    String sql  = "INSERT INTO ROOM_DETAILS VALUES("+
                  "'" + txtGUEST_ID.getText() +"'," +
                  "'" + txtGUEST_NAME.getText() + "'," +
                  "'" + txtROOM_NO.getText() + "'," +
                  "'" + txtDDATE.getText() + "'," +
                  "'" + txtTYPE.getText()+ "',"+
                  txtAMT.getText()+ "," +
                  "'" + txtRECEP_NO.getText() +"'," +
                  "'" + txtPAID.getText() + "'," +
                  txtTOT_BILL.getText() + "," +
                  txtTOT_PAID.getText() + "," +
                  txtTOT_BILL.getText()+")"; 

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
                  "GUEST_ID='"   +txtGUEST_ID.getText() +"'," +
                  "GUEST_NAME='" +txtGUEST_NAME.getText() + "'," +
                  "ROOM_NO='"    +txtROOM_NO.getText() + "'," +
                  "DDATE='"      +txtDDATE.getText() + "'," +
                  "TYPE='"       +txtTYPE.getText()+ "',"+
                  "AMT="         +txtAMT.getText()+ "," +
                  "RECEP_NO='"   +txtRECEP_NO.getText() +"'," +
                  "PAID='"       +txtPAID.getText() + "'," +
                  "TOT_BILL="    +txtTOT_BILL.getText() + "," +
                  "TOT_PAID="    +txtTOT_PAID.getText() + "," +
                  "TOT_BAL="     +txtTOT_BILL.getText()+")"; 

                
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
    frmFb_details frm=new frmFb_details();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});

    }
    }
