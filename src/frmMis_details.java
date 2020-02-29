import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
import java.sql.*;

class frmMis_details extends JFrame implements ActionListener
{
  JLabel   lblTitle;
  JLabel   lblGUEST_ID;
  JLabel   lblGUEST_NAME;
  JLabel   lblROOM_NO;
  JLabel   lblDDATE;
  JLabel   lblTYPE;
  JLabel   lblAMT;
  JLabel   lblRECEP_NO;
  JLabel   lblPAID;
  JLabel   lblTOT_BILL;
  JLabel   lblTOT_PAID;
  JLabel   lblTOT_BAL;


  JTextField    txtGUEST_ID;
  JTextField    txtGUEST_NAME;
  JTextField    txtROOM_NO,txtDDATE;
  JTextField    txtTYPE,txtAMT;
  JTextField    txtRECEP_NO;
  JTextField    txtPAID;
  JTextField    txtTOT_BILL;
  JTextField    txtTOT_PAID;
  JTextField    txtTOT_BAL;


  JButton    btnFIRST;
  JButton    btnPREV;
  JButton    btnNEXT;
  JButton    btnLAST;
  JButton    btnADD;
  JButton    btnEDIT;
  JButton    btnFIND;
  JButton    btnDELETE;

  JButton    btnCLOSE;
  JButton    btnREFRESH;
  JButton    btnSAVE;
  JButton    btnCLEAR;
  JButton    btnRETURN;
  JButton    btnUPDATE;
  JButton    btnCANCLE;


  JPanel    pMAIN;
  JPanel    pADD;
  JPanel    pEDIT;                               
  

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
      rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_NO,DDATE,TYPE,AMT,RECEP_NO,PAID,TOT_BILL,TOT_PAID,TOT_BAL FROM MIS_DETAILS");
      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}

      Statement st=cn.createStatement();
      }catch(SQLException ex){}
     }


  public frmMis_details()
  {
    setTitle("The Hotel Suraj Executive,Shirur-pune,Maharashtra");
    setSize(780,580);
    cnt=getContentPane();
    cnt.setLayout(null);
    lblTitle    = new JLabel("Miscellaneous Details");
    lblTitle.setBounds(240,20,300,30);
    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
    lblTitle.setForeground(Color.red);
    cnt.add(lblTitle);


    lblGUEST_ID    = new JLabel("GUEST ID");
    lblGUEST_ID.setBounds(200,70,80,25);
    lblGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_ID.setForeground(Color.black);



    lblGUEST_NAME    = new JLabel("GUEST NAME");
    lblGUEST_NAME.setBounds(200,100,200,25);
    lblGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_NAME.setForeground(Color.black);


    lblROOM_NO      = new JLabel("ROOM NO");
    lblROOM_NO.setBounds(200,130,80,25);
    lblROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_NO.setForeground(Color.black);


    lblDDATE      = new JLabel("DDATE");
    lblDDATE.setBounds(200,160,150,25);
    lblDDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblDDATE.setForeground(Color.black);

    lblTYPE = new JLabel("TYPE");
    lblTYPE.setBounds(200,190,100,25);
    lblTYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));

    lblTYPE.setForeground(Color.black);

    lblAMT   = new JLabel("AMOUNT");
    lblAMT.setBounds(200,220,100,25);
    lblAMT.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblAMT.setForeground(Color.black);

    lblRECEP_NO    = new JLabel("RECEP NO");
    lblRECEP_NO.setBounds(200,250,100,25);
    lblRECEP_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblRECEP_NO.setForeground(Color.black);

    lblPAID     = new JLabel("PAID");
    lblPAID.setBounds(200,280,100,25);
    lblPAID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblPAID.setForeground(Color.black);

    lblTOT_BILL      = new JLabel("TOTAL BIL");
    lblTOT_BILL.setBounds(200,310,100,25);
    lblTOT_BILL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTOT_BILL.setForeground(Color.black);

    lblTOT_PAID= new JLabel("TOTAL PAID");
    lblTOT_PAID.setBounds(200,340,100,25);
    lblTOT_PAID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblTOT_PAID.setForeground(Color.black);

    lblTOT_BAL=  new JLabel("TOTAL BALANCE"); 
    lblTOT_BAL.setBounds(200,370,150,25);
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

    txtGUEST_ID   = new JTextField(15);

    txtGUEST_ID.setBounds(380,70,80,25);
    txtGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtGUEST_ID.setForeground(Color.black);

    txtGUEST_NAME    = new JTextField(30);
    txtGUEST_NAME.setBounds(380,100,200,25);
    txtGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtGUEST_NAME.setForeground(Color.black);

    txtROOM_NO     = new JTextField(8);
    txtROOM_NO.setBounds(380,130,100,25);
    txtROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_NO.setForeground(Color.black);

    txtDDATE      = new JTextField(30);
    txtDDATE.setBounds(380,160,150,25);
    txtDDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtDDATE.setForeground(Color.black);


    txtTYPE = new JTextField(30);
    txtTYPE.setBounds(380,190,100,25);
    txtTYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtTYPE.setForeground(Color.black);

    txtAMT   = new JTextField(9);
    txtAMT.setBounds(380,220,100,25);
    txtAMT.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtAMT.setForeground(Color.black);

    txtRECEP_NO    = new JTextField(15);
    txtRECEP_NO.setBounds(380,250,70,25);
    txtRECEP_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtRECEP_NO.setForeground(Color.black);


    txtPAID     = new JTextField(15);
    txtPAID.setBounds(380,280,50,25);
    txtPAID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtPAID.setForeground(Color.black);

    txtTOT_BILL      = new JTextField(30);
    txtTOT_BILL.setBounds(380,310,100,25);
    txtTOT_BILL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtTOT_BILL.setForeground(Color.black);

    txtTOT_PAID = new JTextField(10);
    txtTOT_PAID.setBounds(380,340,100,25);
    txtTOT_PAID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtTOT_PAID.setForeground(Color.black);

    txtTOT_BAL  =new JTextField(10);   
    txtTOT_BAL.setBounds(380,370,100,25);
    txtTOT_BAL.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtTOT_BAL.setForeground(Color.black);

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
    pMAIN.setBounds(150,400,450,90);
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
    pADD.setBounds(250,400,240,40);
    pADD.setLayout(new GridLayout(1,3));
     
    pADD.add(btnSAVE);
    pADD.add(btnCLEAR);
    pADD.add(btnRETURN);

    pEDIT=new JPanel();
    pEDIT.setBounds(250,400,160,40);
    pEDIT.setLayout(new GridLayout(1,2));

    pEDIT.add(btnUPDATE);
    pEDIT.add(btnCANCLE);

    cnt.add(pMAIN);
    cnt.add(pADD);
    cnt.add(pEDIT);


    JPanel p1=new JPanel();    
    p1.setBorder(BorderFactory.createTitledBorder(""));
    p1.setForeground(Color.red);
    p1.setBackground(Color.pink);
    p1.setBounds(100,60,550,440);
    cnt.add(p1);


  JPanel p=new JPanel();    
p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,5),"Miscelleneous Details Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,12),Color.black));
    p.setForeground(Color.red);
    p.setBackground(Color.pink);
    p.setBounds(1,1,790,550);
    cnt.add(p);


    pADD.setVisible(false);
    pEDIT.setVisible(false);

    disableEntry();
    connect();
    openRecord();
    if(rcount>0) try{showRecord();}catch(Exception e){}
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

    if(e.getSource()==btnREFRESH)
    {
      try{
           
          rs.close();
          st.close();
          st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);


 rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_NO,DDATE,TYPE,AMT,RECEP_NO,PAID,TOT_BILL,TOT_PAID,TOT_BAL FROM MIS_DETAILS"); 
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
      ResultSet rs1=st.executeQuery("SELECT * FROM MIS_DETAILS WHERE GUEST_ID="+fGUEST_ID);
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
    String sql  = "INSERT INTO MIS_DETAILS VALUES("+
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
                  txtTOT_BAL.getText()+")"; 

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
    String sql  = "UPDATE MIS_DETAILS SET "+
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
                  "TOT_BAL="     +txtTOT_BAL.getText()+")"; 

                
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
    frmMis_details frm=new frmMis_details();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});

    }
 }
