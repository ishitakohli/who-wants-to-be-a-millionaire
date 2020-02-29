import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.lang.*;
import java.sql.*;

class frmRoom_status extends JFrame implements ActionListener
{
  JLabel  lblTitle;
  JLabel  lblROOM_NO;
  JLabel  lblFLOOR_NO;
  JLabel  lblROOM_TYPE;
  JLabel  lblROOM_CHARGE;
  JLabel  lblREMARKS;
  JLabel  lblROOM_STATUS;


  JTextField   txtROOM_NO;
  JTextField   txtFLOOR_NO;
  JTextField   txtROOM_TYPE;
  JTextField   txtROOM_CHARGE;
  JTextField   txtREMARKS;
  JTextField   txtROOM_STATUS;

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
  String mROOM_NO="";

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
      rs=st.executeQuery("SELECT ROOM_NO,FLOOR_NO,ROOM_TYPE,ROOM_CHARGE,REMARKS,ROOM_STATUS FROM ROOM_DETAILS");
      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}
      Statement st=cn.createStatement();
      }catch(SQLException ex){}
  }

  public frmRoom_status()
  {
   


    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");

    setSize(790,580);
    setLocation(5,10);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();       
    cnt=getContentPane();
    cnt.setLayout(null);

    lblTitle        = new JLabel("Room Status Form");
    lblROOM_NO      = new JLabel("ROOM NO");
    lblFLOOR_NO     = new JLabel("FLOOR NO");
    lblROOM_TYPE    = new JLabel("ROOM TYPE");
    lblROOM_CHARGE  = new JLabel("ROOM CHARGE");
    lblREMARKS      = new JLabel("REMARKS");
    lblROOM_STATUS  = new JLabel("ROOM STATUS"); 

    lblTitle.setBounds(185,35,300,30);
     
    lblROOM_NO.setBounds(200,120,100,25);
    lblFLOOR_NO.setBounds(200,150,100,25);
    lblROOM_TYPE.setBounds(200,180,200,25);
    lblROOM_CHARGE.setBounds(200,210,200,25);
    lblREMARKS.setBounds(200,240,200,25);
    lblROOM_STATUS.setBounds(200,270,200,25);

    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
    lblROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblFLOOR_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_TYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_CHARGE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblREMARKS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_STATUS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));

    lblTitle.setForeground(Color.red);     
    lblROOM_NO.setForeground(Color.black);
    lblFLOOR_NO.setForeground(Color.black);
    lblROOM_TYPE.setForeground(Color.black);   
    lblROOM_CHARGE.setForeground(Color.black);       
    lblREMARKS.setForeground(Color.black);   
    lblROOM_STATUS.setForeground(Color.black);

    cnt.add(lblTitle);
    cnt.add(lblROOM_NO);
    cnt.add(lblFLOOR_NO);
    cnt.add(lblROOM_TYPE);
 


   cnt.add(lblROOM_CHARGE);
    cnt.add(lblREMARKS);
    cnt.add(lblROOM_STATUS);

    txtROOM_NO       = new JTextField(10);
    txtFLOOR_NO      = new JTextField(20);
    txtROOM_TYPE     = new JTextField(20);
    txtROOM_CHARGE   = new JTextField(20);
    txtREMARKS       = new JTextField(20);
    txtROOM_STATUS   = new JTextField(20); 
    
    txtROOM_NO.setBounds(420,120,120,25);
    txtFLOOR_NO.setBounds(420,150,120,25);
    txtROOM_TYPE.setBounds(420,180,120,25);
    txtROOM_CHARGE.setBounds(420,210,120,25);
    txtREMARKS.setBounds(420,240,120,25);
    txtROOM_STATUS.setBounds(420,270,120,25);

    txtROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtFLOOR_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_TYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_CHARGE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtREMARKS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_STATUS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));

    txtROOM_NO.setForeground(Color.black);    
    txtFLOOR_NO.setForeground(Color.black);  
    txtROOM_TYPE.setForeground(Color.black);    
    txtROOM_CHARGE.setForeground(Color.black);    
    txtREMARKS.setForeground(Color.black);  
    txtROOM_STATUS.setForeground(Color.black);

    cnt.add(txtROOM_NO);
    cnt.add(txtFLOOR_NO);
    cnt.add(txtROOM_TYPE);
    cnt.add(txtROOM_CHARGE);
    cnt.add(txtREMARKS);
    cnt.add(txtROOM_STATUS);
   
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
    pMAIN.setBounds(140,350,420,90);
    pMAIN.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,5),"Main Menu",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.red));
    pMAIN.setLayout(new GridLayout(2,5));
    pMAIN.setBackground(Color.white);
   
    pADD=new JPanel();
    pADD.setBounds(230,350,240,30);
    pADD.setLayout(new GridLayout(1,3));

    pEDIT=new JPanel();
    pEDIT.setBounds(280,350,160,30);
    pEDIT.setLayout(new GridLayout(1,2));

   

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

    pADD.add(btnSAVE);
    pADD.add(btnCLEAR);
    pADD.add(btnRETURN);
    pEDIT.add(btnUPDATE);
    pEDIT.add(btnCANCLE);

    cnt.add(pMAIN);
    cnt.add(pADD);
    cnt.add(pEDIT);
    pADD.setVisible(false);
    pEDIT.setVisible(false);
    
    JPanel p1=new JPanel();    
    p1.setBorder(BorderFactory.createTitledBorder(""));
    p1.setForeground(Color.red);
    p1.setBackground(Color.pink);
    p1.setBounds(120,100,460,230);
    cnt.add(p1);

    JPanel p=new JPanel();    
    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,3),"Room Details Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
    p.setForeground(Color.red);
    p.setBackground(Color.pink);
    p.setBounds(1,1,790,560);
    cnt.add(p);

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
      try{mROOM_NO=rs.getString(1);}catch(SQLException ex){}
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
      String fROOM_NO=JOptionPane.showInputDialog(null,"Enter Room No. to Find","Find Dialog",JOptionPane.PLAIN_MESSAGE);
      try{
      Statement st=cn.createStatement();
      ResultSet rs1=st.executeQuery("SELECT * FROM ROOM_DETAILS WHERE ROOM_NO="+fROOM_NO);
      if(rs1.next())
      {
        JOptionPane.showMessageDialog(null,"The Search Room No. Found Successfully","Search Result",JOptionPane.INFORMATION_MESSAGE);
        rs.beforeFirst();
        while(rs.next())
          if(rs.getString(1).equals(fROOM_NO))
          {
            showRecord();
            break;
          }
      }
      else
        JOptionPane.showMessageDialog(null,"The Search Room No. Not Found","Search Result",JOptionPane.INFORMATION_MESSAGE);
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
          st.close();          st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
          rs=st.executeQuery("SELECT ROOM_NO,FLOOR_NO,ROOM_TYPE,ROOM_CHARGE,REMARKS,ROOM_STATUS FROM ROOM_DETAILS"); 
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
      txtROOM_NO.setText(rs.getString(1));
      txtFLOOR_NO.setText(rs.getString(2));
      txtROOM_TYPE.setText(rs.getString(3));
      txtROOM_CHARGE.setText(rs.getString(4));
      txtREMARKS.setText(rs.getString(5));
      txtROOM_STATUS.setText(rs.getString(6));
    }catch(Exception e){}
  }

  public void clearEntry()
  {
      txtROOM_NO.setText("");
      txtFLOOR_NO.setText("");
      txtROOM_TYPE.setText("");
      txtROOM_CHARGE.setText("");
      txtREMARKS.setText("");
      txtROOM_STATUS.setText("");     

  }

  public void enableEntry()
  {
      txtROOM_NO.setEditable(true);
      txtFLOOR_NO.setEditable(true);
      txtROOM_TYPE.setEditable(true);
      txtROOM_CHARGE.setEditable(true);
      txtREMARKS.setEditable(true);
      txtROOM_STATUS.setEditable(true);   
  }

  public void disableEntry()
  {
      txtROOM_NO.setEditable(false);
      txtFLOOR_NO.setEditable(false);
      txtROOM_TYPE.setEditable(false);
      txtROOM_CHARGE.setEditable(false);
      txtREMARKS.setEditable(false);
      txtROOM_STATUS.setEditable(false);     
  }

  public boolean saveRecord()
  {
    boolean result=true;
    try{
    String sql  = "INSERT INTO ROOM_DETAILS VALUES("+
                  "'"+txtROOM_NO.getText() +"'," +
                  txtFLOOR_NO.getText() + "," +
                  "'" + txtROOM_TYPE.getText() + "'," +
                  txtROOM_CHARGE.getText() + "," +
                  "'"+txtREMARKS.getText()+ "',"+
                  "'"+txtROOM_STATUS.getText()+"')";

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
 
   String sql  = "UPDATE ROOM_DETAILS SET("+
                  "ROOM_NO='"        +txtROOM_NO.getText() + "'," +
                  "FLOOR_NO="        +txtFLOOR_NO.getText() + "," +
                  "ROOM_TYPE='"      +txtROOM_TYPE.getText() + "'," +
                  "ROOM_CHARGE="     +txtROOM_CHARGE.getText() + "," +
                  "REMARKS='"        +txtREMARKS.getText()+ "',"+
                  "ROOM_STATUS='"    +txtROOM_STATUS.getText() + ")"; 
                  
                
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
    frmRoom_status frm=new frmRoom_status();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
  }
}
