import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
import java.sql.*;

  class frmReservation extends JFrame implements ActionListener 
   {
    JLabel  lblTitle;

    JLabel  lblGUEST_ID;
    JLabel  lblGUEST_NAME;
    JLabel  lblROOM_TYPE;
    JLabel  lblFLOOR_NO; 
    JLabel  lblROOM_NO;
    JLabel  lblROOM_CHARGE;
    JLabel  lblADV;
    JLabel  lblADATE;
    JLabel  lblDDATE;
    JLabel  lblGUEST_TYPE;
    JLabel  lblREMARKS;


    JTextField   txtGUEST_ID;
    JTextField   txtGUEST_NAME;
    JTextField   txtROOM_TYPE;
    JTextField   txtFLOOR_NO;
    JTextField   txtROOM_NO;
    JTextField   txtROOM_CHARGE;
    JTextField   txtADV;
    JTextField   txtADATE;
    JTextField   txtDDATE;
    JTextField   txtGUEST_TYPE;
    JTextField   txtREMARKS;

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
    
    JPanel  pMAIN;
    JPanel  pADD;
    JPanel  pEDIT;  
                               
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
      rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_TYPE,FLOOR_NO,ROOM_NO,ROOM_CHARGE,ADV,ADATE,DDATE,GUEST_TYPE,REMARKS FROM GUEST_DETAILS");
      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}
      Statement st=cn.createStatement();

      }catch(SQLException ex){}
      }


    public frmReservation()
    {
    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");
    setSize(700,550);
    setLocation(45,15);
    cnt=getContentPane();
    cnt.setLayout(null);
    lblTitle    = new JLabel("Guest Details");
    lblTitle.setBounds(220,20,200,30);
    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
    lblTitle.setForeground(Color.red);


    cnt.add(lblTitle);

    lblGUEST_ID=new JLabel("GUEST ID");
    lblGUEST_ID.setBounds(150,60,100,30);
    lblGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_ID.setForeground(Color.black);

    lblGUEST_NAME=new JLabel("GUEST NAME");
    lblGUEST_NAME.setBounds(150,90,200,30);
    lblGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_NAME.setForeground(Color. black); 

    lblROOM_TYPE=new JLabel("ROOM TYPE");
    lblROOM_TYPE.setBounds(150,120,200,30);
    lblROOM_TYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_TYPE.setForeground(Color. black); 

    lblFLOOR_NO = new JLabel("FLOOR NO");
    lblFLOOR_NO.setBounds(150,150,100,30);
    lblFLOOR_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblFLOOR_NO.setForeground(Color.black); 


    lblROOM_NO = new JLabel("ROOM NO");
    lblROOM_NO.setBounds(150,180,200,30);
    lblROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_NO.setForeground(Color. black); 

    

    lblROOM_CHARGE=new JLabel("ROOM CHARGE");
    lblROOM_CHARGE.setBounds(150,210,200,30);
    lblROOM_CHARGE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblROOM_CHARGE.setForeground(Color. black); 

    
    lblADV   = new JLabel("ADVANCE");
    lblADV.setBounds(150,240,100,30);
    lblADV.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblADV.setForeground(Color.black); 

    lblADATE    = new JLabel("ADATE");
    lblADATE.setBounds(150,270,130,30);
    lblADATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblADATE.setForeground(Color.black); 

    lblDDATE     = new JLabel("DDATE"); 
    lblDDATE.setBounds(150,300,130,30);
    lblDDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblDDATE.setForeground(Color.black); 
    
    lblGUEST_TYPE= new JLabel("GUEST TYPE");
    lblGUEST_TYPE.setBounds(150,330,200,30);
    lblGUEST_TYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblGUEST_TYPE.setForeground(Color. black); 
   
    lblREMARKS = new JLabel("REMARKS");
    lblREMARKS.setBounds(150,360,100,30);
    lblREMARKS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblREMARKS.setForeground(Color. black);
    
    cnt.add(lblGUEST_ID);
    cnt.add(lblGUEST_NAME);
    cnt.add(lblROOM_TYPE);
    cnt.add(lblFLOOR_NO);
    cnt.add(lblROOM_NO);
    cnt.add(lblROOM_CHARGE);
    cnt.add(lblADV);
    cnt.add(lblADATE);
    cnt.add(lblDDATE);
    cnt.add(lblGUEST_TYPE);
    cnt.add(lblREMARKS);

    txtGUEST_ID  = new JTextField(12);

    txtGUEST_NAME    = new JTextField(30);
    txtROOM_TYPE = new JTextField(8);
    txtFLOOR_NO    = new JTextField(9);
    txtROOM_NO   = new JTextField(8);   
    txtROOM_CHARGE   = new JTextField(9);   
    txtADV    = new JTextField(30);
    txtADATE     = new JTextField(30);
    txtDDATE = new JTextField(15);
    txtGUEST_TYPE    = new JTextField(15);
    txtREMARKS=new JTextField(30);

    txtGUEST_ID.setBounds(350,60,100,25);
    txtGUEST_NAME.setBounds(350,90,175,25);
    txtROOM_TYPE.setBounds(350,120,130,25);
    txtFLOOR_NO.setBounds(350,150,100,25);
    txtROOM_NO.setBounds(350,180,100,25);
    txtROOM_CHARGE.setBounds(350,210,100,25);
    txtADV.setBounds(350,240,100,25);
    txtADATE.setBounds(350,270,130,25);
    txtDDATE.setBounds(350,300,130,25);
    txtGUEST_TYPE.setBounds(350,330,100,25);
    txtREMARKS.setBounds(350,360,100,25);

    txtGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_TYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtFLOOR_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtROOM_CHARGE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtADV.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtADATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtDDATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtGUEST_TYPE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtREMARKS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    
    cnt.add(txtGUEST_ID);
    cnt.add(txtGUEST_NAME);
    cnt.add(txtROOM_TYPE);
    cnt.add(txtFLOOR_NO);
    cnt.add(txtROOM_NO);
    cnt.add(txtROOM_CHARGE);
    cnt.add(txtADV);
    cnt.add(txtADATE);
    cnt.add(txtDDATE);
    cnt.add(txtGUEST_TYPE);

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
    pMAIN.setBounds(120,400,440,90);
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
    pADD.setBounds(225,400,240,30);
    pADD.setLayout(new GridLayout(1,3));
    
    pADD.add(btnSAVE);
    pADD.add(btnCLEAR);
    pADD.add(btnRETURN);

    pEDIT=new JPanel();
    pEDIT.setBounds(260,400,160,30);
    pEDIT.setLayout(new GridLayout(1,2));
       

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
    p1.setBounds(80,50,510,340);
    cnt.add(p1);

   
    
    JPanel p=new JPanel();
    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,3),"Reservation Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
    p.setForeground(Color.red);
    p.setBackground(Color.pink);
    p.setBounds(1,1,690,515);
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
      ResultSet rs1=st.executeQuery("SELECT * FROM GUEST_DETAILS WHERE GUEST_ID="+mGUEST_ID);
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


        JOptionPane.showMessageDialog(null,"The Search Employee No. Not Found","Search Result",JOptionPane.INFORMATION_MESSAGE);
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
          rs=st.executeQuery("SELECT GUEST_ID,GUEST_NAME,ROOM_TYPE,FLOOR_NO,ROOM_NO,ROOM_CHARGE,ADV,ADATE,DDATE,GUEST_TYPE,REMARKS FROM GUEST_DETAILS"); 
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
  System.out.println(" show records");
    try{         
      txtGUEST_ID.setText(rs.getString(1));
      txtGUEST_NAME.setText(rs.getString(2));
      txtROOM_TYPE.setText(rs.getString(3));

      txtFLOOR_NO.setText(rs.getString(4));
      txtROOM_NO.setText(rs.getString(5));
      txtROOM_CHARGE.setText(rs.getString(6));
      txtADV.setText(rs.getString(7));
      txtADATE.setText(rs.getString(8));
      txtDDATE.setText(rs.getString(9));
      txtGUEST_TYPE.setText(rs.getString(10));
      txtREMARKS.setText(rs.getString(11));     
     }catch(Exception e){}
  }

  public void clearEntry()
  {
      txtGUEST_ID.setText("");
      txtGUEST_NAME.setText("");
      txtROOM_TYPE.setText("");
      txtFLOOR_NO.setText("");
      txtROOM_NO.setText("");
      txtROOM_CHARGE.setText("");
      txtADV.setText("");
      txtADATE.setText("");
      txtDDATE.setText("");
      txtGUEST_TYPE.setText("");
      txtREMARKS.setText("");
 }
      
 
  public void enableEntry()
  {
      txtGUEST_ID.setEditable(true);
      txtGUEST_NAME.setEditable(true);
      txtROOM_TYPE.setEditable(true);
      txtFLOOR_NO.setEditable(true);
      txtROOM_NO.setEditable(true);
      txtROOM_CHARGE.setEditable(true);
      txtADV.setEditable(true);
      txtADATE.setEditable(true);
      txtDDATE.setEditable(true);
      txtGUEST_TYPE.setEditable(true);
      txtREMARKS.setEditable(true);    

     
  }
  public void disableEntry()
  {

      txtGUEST_ID.setEditable(false);
      txtGUEST_NAME.setEditable(false);
      txtROOM_TYPE.setEditable(false);
      txtFLOOR_NO.setEditable(false);
      txtROOM_NO.setEditable(false);
      txtROOM_CHARGE.setEditable(false);
      txtADV.setEditable(false);
      txtADATE.setEditable(false);
      txtDDATE.setEditable(false);
      txtGUEST_TYPE.setEditable(false);
      txtREMARKS.setEditable(false);    
  }

  public boolean saveRecord()
  {
    boolean result=true;
    try{
    String sql  = "INSERT INTO GUEST_DETAILS VALUES("+
                  "'"  +txtGUEST_ID.getText() + "'," +
                  "'"  +txtGUEST_NAME.getText() + "'," +
                  "'"  +txtROOM_TYPE.getText() + "'," +
                  txtFLOOR_NO.getText() + "," +
                  "'"+txtROOM_NO.getText() +"'," + 
                  txtROOM_CHARGE.getText() + "," +
                  txtADV.getText() + "," +
                  "'"  +txtADATE.getText() + "'," +
                  "'"  +txtDDATE.getText() + "'," +
                  "'"  +txtGUEST_TYPE.getText() + "'," +
                  "'"  +txtREMARKS.getText() +"')";
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
    String sql  = "UPDATE GUEST_DETAILS SET ("+                
                  "GUEST_ID='"   + txtGUEST_ID.getText() + "'," +
                  "GUEST_NAME='" + txtGUEST_NAME.getText() + "'," +
                  "ROOM_TYPE='"  + txtROOM_TYPE.getText()+"'," +
                  txtFLOOR_NO.getText() + "," +
                  "ROOM_NO='"    + txtROOM_NO.getText()+ "',"+
      
            txtROOM_CHARGE.getText()+","+
                  txtADV.getText() + "," +
                  "ADATE='"      +txtADATE.getText() + "," +
                  "DDATE='"      +txtDDATE.getText() + "," +
                  "GUEST_TYPE='" + txtGUEST_TYPE.getText() + "'," +
                  "REMARKS='"    + txtREMARKS.getText() +"')";  

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
    frmReservation frm  = new frmReservation();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
    }
  }
