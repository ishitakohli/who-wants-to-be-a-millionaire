import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.sql.*;

class frmGg_details extends JFrame implements ActionListener
  {
  JLabel  lblTitle;
  JLabel  lblBB_NO;
  JLabel  lblGUEST_ID;
  JLabel  lblGUEST_NAME;
  JLabel  lblFH_NAME;
  JLabel  lblARR_FROM;
  JLabel  lblPUR_VISIT;
  JLabel  lblARR_DATE;
  JLabel  lblTIME;
  JLabel  lblDEP_DATE;
  JLabel  lblNO_PERSON;
  JLabel  lblWHERE_TO_GO;
  JLabel  lblH_NO_NAME;
  JLabel  lblS_NO_NAME;
  JLabel  lblLOCALITY;
  JLabel  lblPIN;
  JLabel  lblCITY;
  JLabel  lblSTATE;
  JLabel  lblOFF_PHONE;
  JLabel  lblH_PHONE;
  JLabel  lblFAX_NO;
  JLabel  lblEMAIL_ID;
  JLabel  lblROOM_NO;
  JLabel  lblROOM_CHARGE;
  JLabel  lblADV,lblDUES;
  JLabel  lblRECEP_CODE;
  JLabel  lblPAY_MODE;


  JTextField   txtBB_NO;
  JTextField   txtGUEST_ID;
  JTextField   txtGUEST_NAME;
  JTextField   txtFH_NAME;

  JTextField   txtARR_FROM;
  JTextField   txtPUR_VISIT;
  JTextField   txtARR_DATE;
  JTextField   txtTIME;
  JTextField   txtDEP_DATE;
  JTextField   txtNO_PERSON;
  JTextField   txtWHERE_TO_GO;
  JTextField   txtH_NO_NAME;
  JTextField   txtS_NO_NAME;
  JTextField   txtLOCALITY;
  JTextField   txtPIN,txtCITY;
  JTextField   txtSTATE;
  JTextField   txtOFF_PHONE;
  JTextField   txtH_PHONE;
  JTextField   txtFAX_NO;
  JTextField   txtEMAIL_ID;
  JTextField   txtROOM_NO;
  JTextField   txtROOM_CHARGE;
  JTextField   txtADV;
  JTextField   txtDUES;
  JTextField   txtRECEP_CODE;
  JTextField   txtPAY_MODE;


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
      rs=st.executeQuery("SELECT BB_NO_NO,GUEST_ID,GUEST_NAME,FH_NAME,ARR_FROM,PUR_VISIT,ARR_DATE,TIME,DEP_DATE,NO_PERSON,WHERE_TO_GO,H_NO_NAME,S_NO_NAME,LOCALITY,PIN,CITY,      STATE,OFF_PHONE,H_PHONE,FAX_NO,EMAIL_ID,ROOM_NO,ROOM_CHARGE,ADV,DUES,RECEP_CODE,PAY_MODE FROM GENERAL_GUEST_DETAILS ");

      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}
      Statement st=cn.createStatement();
      }catch(SQLException ex){}
      }
 
  public frmGg_details()
  {
    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");
    setSize(780,580);
    cnt=getContentPane();
    cnt.setLayout(null);
    lblTitle    = new JLabel("General Guest Details");

    lblTitle.setBounds(250,20,250,30);
    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,20));
    lblTitle.setForeground(Color.red);
    cnt.add(lblTitle);


    lblBB_NO    = new JLabel("BB NO");
    lblGUEST_ID    = new JLabel("GUEST ID");
    lblGUEST_NAME     = new JLabel("GUEST NAME");
    lblFH_NAME     = new JLabel("FATHER NAME");
    lblARR_FROM = new JLabel("ARR FROM");
    lblPUR_VISIT    = new JLabel("PUR VISIT");
    lblARR_DATE    = new JLabel("ARR DATE");
    lblTIME     = new JLabel("TIME");
    lblDEP_DATE     = new JLabel("DEP DATE");
    lblNO_PERSON = new JLabel("NO. PERSON");
    lblWHERE_TO_GO = new JLabel("WHERE TO GO");
    lblH_NO_NAME    = new JLabel("H NO NAME");
    lblS_NO_NAME    = new JLabel("S NAME NO");
    lblLOCALITY     = new JLabel("LOCALITY");
    lblPIN     = new JLabel("PIN");
    lblCITY = new JLabel("CITY");
    lblSTATE    = new JLabel("STATE");
    lblOFF_PHONE   = new JLabel("OFFICE PHONE");
    lblH_PHONE     = new JLabel("HOME PHONE");
    lblFAX_NO     = new JLabel("FAX. NO");
    lblEMAIL_ID = new JLabel("EMAIL ID");
    lblROOM_NO    = new JLabel("ROOM NO");
    lblROOM_CHARGE    = new JLabel("ROOM CHARGE");
    lblADV   = new JLabel("ADV");
    lblDUES     = new JLabel("DUES");
    lblRECEP_CODE = new JLabel("RECEP CODE");
    lblPAY_MODE = new JLabel("PAY MODE");


    lblBB_NO.setBounds(100,60,100,25);
    lblBB_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblBB_NO.setForeground(Color.black);

    lblGUEST_ID.setBounds(100,85,100,25);
    lblGUEST_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblGUEST_ID.setForeground(Color.black);

    lblGUEST_NAME.setBounds(100,110,100,25);
    lblGUEST_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));

    lblGUEST_NAME.setForeground(Color.black);


    lblFH_NAME.setBounds(100,135,100,25);
    lblFH_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblFH_NAME.setForeground(Color.black);

    lblARR_FROM.setBounds(100,160,100,25);
    lblARR_FROM.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblARR_FROM.setForeground(Color.black);

    lblPUR_VISIT.setBounds(100,185,100,25);
    lblPUR_VISIT.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblPUR_VISIT.setForeground(Color.black);

    lblARR_DATE.setBounds(100,210,100,25);
    lblARR_DATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblARR_DATE.setForeground(Color.black);

    lblTIME.setBounds(100,235,100,25);
    lblTIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblTIME.setForeground(Color.black);

    lblDEP_DATE.setBounds(100,260,100,25);
    lblDEP_DATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblDEP_DATE.setForeground(Color.black);

    lblNO_PERSON.setBounds(100,285,100,25);
    lblNO_PERSON.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblNO_PERSON.setForeground(Color.black);

    lblWHERE_TO_GO.setBounds(100,310,140,25);
    lblWHERE_TO_GO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblWHERE_TO_GO.setForeground(Color.black);

    lblH_NO_NAME.setBounds(100,335,100,25);
    lblH_NO_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblH_NO_NAME.setForeground(Color.black);

    lblS_NO_NAME.setBounds(100,360,100,25);
    lblS_NO_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblS_NO_NAME.setForeground(Color.black);

    lblLOCALITY.setBounds(100,385,100,25);
    lblLOCALITY.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));

    lblLOCALITY.setForeground(Color.black);

    lblPIN.setBounds(400,60,100,25);
    lblPIN.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblPIN.setForeground(Color.black);

    lblCITY.setBounds(400,85,100,25);
    lblCITY.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblCITY.setForeground(Color.black);

    lblSTATE.setBounds(400,110,100,25);
    lblSTATE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblSTATE.setForeground(Color.black);

    lblOFF_PHONE.setBounds(400,135,130,25);
    lblOFF_PHONE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblOFF_PHONE.setForeground(Color.black);

    lblH_PHONE.setBounds(400,160,120,25);
    lblH_PHONE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblH_PHONE.setForeground(Color.black);

    lblFAX_NO.setBounds(400,185,100,25);
    lblFAX_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblFAX_NO.setForeground(Color.black);

    lblEMAIL_ID.setBounds(400,210,100,25);
    lblEMAIL_ID.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblEMAIL_ID.setForeground(Color.black);

    lblROOM_NO.setBounds(400,235,100,25);
    lblROOM_NO.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblROOM_NO.setForeground(Color.black);

    lblROOM_CHARGE.setBounds(400,260,130,25);
    lblROOM_CHARGE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblROOM_CHARGE.setForeground(Color.black);

    lblADV.setBounds(400,285,100,25);
    lblADV.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblADV.setForeground(Color.black);

    lblDUES.setBounds(400,310,100,25);
    lblDUES.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblDUES.setForeground(Color.black);

    lblRECEP_CODE.setBounds(400,335,100,25);
    lblRECEP_CODE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblRECEP_CODE.setForeground(Color.black);

    lblPAY_MODE.setBounds(400,360,100,25);
    lblPAY_MODE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
    lblPAY_MODE.setForeground(Color.black);

    cnt.add(lblBB_NO);
    cnt.add(lblGUEST_ID);
    cnt.add(lblGUEST_NAME);
    cnt.add(lblFH_NAME);
    cnt.add(lblARR_FROM);
    cnt.add(lblPUR_VISIT);
    cnt.add(lblARR_DATE);
    cnt.add(lblTIME);
    cnt.add(lblDEP_DATE);
    cnt.add(lblNO_PERSON);
    cnt.add(lblWHERE_TO_GO);
    cnt.add(lblH_NO_NAME);
    cnt.add(lblS_NO_NAME);
    cnt.add(lblLOCALITY);
    cnt.add(lblPIN);
    cnt.add(lblCITY);
    cnt.add(lblSTATE);
    cnt.add(lblOFF_PHONE);
    cnt.add(lblH_PHONE);
    cnt.add(lblFAX_NO);
    cnt.add(lblEMAIL_ID);
    cnt.add(lblROOM_NO);
    cnt.add(lblROOM_CHARGE);
    cnt.add(lblADV);
    cnt.add(lblDUES);
    cnt.add(lblRECEP_CODE);
    cnt.add(lblPAY_MODE);

    txtBB_NO   = new JTextField(9);
    txtGUEST_ID   = new JTextField(10);
    txtGUEST_NAME     = new JTextField(25);
    txtFH_NAME   = new JTextField(25);
    txtARR_FROM = new JTextField(50);
    txtPUR_VISIT   = new JTextField(50);
    txtARR_DATE    = new JTextField(100);
    txtTIME  = new JTextField(10);
    txtDEP_DATE     = new JTextField(9);

    txtNO_PERSON = new JTextField(15);
    txtWHERE_TO_GO = new JTextField(15);
    txtH_NO_NAME   = new JTextField(15);
    txtS_NO_NAME  = new JTextField(15);
    txtLOCALITY     = new JTextField(15);
    txtPIN   = new JTextField(10);
    txtCITY= new JTextField(15);
    txtSTATE   = new JTextField(15);
    txtOFF_PHONE   = new JTextField(10);
    txtH_PHONE  = new JTextField(10);
    txtFAX_NO     = new JTextField(10);
    txtEMAIL_ID = new JTextField(25);
    txtROOM_NO = new JTextField(10);
    txtROOM_CHARGE   = new JTextField(10);
    txtADV   = new JTextField(10);
    txtDUES  = new JTextField(10);
    txtRECEP_CODE     = new JTextField(10);
    txtPAY_MODE = new JTextField(10);
    

    txtBB_NO.setBounds(230,60,75,20);
    txtGUEST_ID.setBounds(230,85,100,20);
    txtGUEST_NAME.setBounds(230,110,155,20);
    txtFH_NAME.setBounds(230,135,155,20);
    txtARR_FROM.setBounds(230,160,100,20);
    txtPUR_VISIT.setBounds(230,185,150,20);
    txtARR_DATE.setBounds(230,210,125,20);
    txtTIME.setBounds(230,235,100,20);
    txtDEP_DATE.setBounds(230,260,125,20);
    txtNO_PERSON.setBounds(230,285,75,20);
    txtWHERE_TO_GO.setBounds(230,310,125,20);
    txtH_NO_NAME.setBounds(230,335,150,20);
    txtS_NO_NAME.setBounds(230,360,135,20);
    txtLOCALITY.setBounds(230,385,130,20);
    txtPIN.setBounds(520,60,80,20);
    txtCITY.setBounds(520,85,100,20);
    txtSTATE.setBounds(520,110,130,20);
    txtOFF_PHONE.setBounds(520,135,110,20);
    txtH_PHONE.setBounds(520,160,110,20);
    txtFAX_NO.setBounds(520,185,140,20);
    txtEMAIL_ID.setBounds(520,210,150,20);
    txtROOM_NO.setBounds(520,235,70,20);
    txtROOM_CHARGE.setBounds(520,260,90,20);
    txtADV.setBounds(520,285,80,20);
    txtDUES.setBounds(520,310,110,20);

    txtRECEP_CODE.setBounds(520,335,80,20);
    txtPAY_MODE.setBounds(520,360,110,20);    


    cnt.add(txtBB_NO);
    cnt.add(txtGUEST_ID);
    cnt.add(txtGUEST_NAME);
    cnt.add(txtFH_NAME);
    cnt.add(txtARR_FROM);
    cnt.add(txtPUR_VISIT);
    cnt.add(txtARR_DATE);
    cnt.add(txtTIME);
    cnt.add(txtDEP_DATE);
    cnt.add(txtNO_PERSON);
    cnt.add(txtWHERE_TO_GO);
    cnt.add(txtH_NO_NAME);
    cnt.add(txtS_NO_NAME);
    cnt.add(txtLOCALITY);
    cnt.add(txtPIN);
    cnt.add(txtCITY);
    cnt.add(txtSTATE);
    cnt.add(txtOFF_PHONE);
    cnt.add(txtH_PHONE);
    cnt.add(txtFAX_NO);
    cnt.add(txtEMAIL_ID);
    cnt.add(txtROOM_NO);
    cnt.add(txtROOM_CHARGE);
    cnt.add(txtADV);
    cnt.add(txtDUES);
    cnt.add(txtRECEP_CODE);
    cnt.add(txtPAY_MODE);

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
    pMAIN.setBounds(150,420,470,90);
    pMAIN.setLayout(new GridLayout(2,5));
    pMAIN.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,5),"Main Menu",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.red));
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

    pEDIT=new JPanel();
    pEDIT.setBounds(320,420,170,30);
    pEDIT.setLayout(new GridLayout(1,2));

    pEDIT.add(btnUPDATE);
    pEDIT.add(btnCANCLE);
    cnt.add(pEDIT);

    pADD=new JPanel();
    pADD.setBounds(260,420,240,30);
    pADD.setLayout(new GridLayout(1,3));

    pADD.add(btnSAVE);
    pADD.add(btnCLEAR);

    pADD.add(btnRETURN);   
    cnt.add(pADD);


    JPanel p1=new JPanel();    
    p1.setBorder(BorderFactory.createTitledBorder(""));
    p1.setForeground(Color.red);
    p1.setBackground(Color.pink);
    p1.setBounds(70,50,620,410);
    cnt.add(p1);

   

    JPanel p=new JPanel();
    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,5),"General Guest Details Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
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
      String fGUEST_ID=JOptionPane.showInputDialog(null,"Enter Guest id to Find","Find Dialog",JOptionPane.PLAIN_MESSAGE);
      try{
         Statement st=cn.createStatement();
      ResultSet rs1=st.executeQuery("SELECT * FROM GENERAL_GUEST_DETAILS WHERE GUEST_ID="+fGUEST_ID);
      if(rs1.next())
      {
        JOptionPane.showMessageDialog(null,"The Search Guest id Found Successfully","Search Result",JOptionPane.INFORMATION_MESSAGE);
        rs.beforeFirst();
        while(rs.next())
          if(rs.getString(1).equals(fGUEST_ID))
          {
            showRecord();
            break;
          }
      }
      else
        JOptionPane.showMessageDialog(null,"The Search Guest id Not Found","Search Result",JOptionPane.INFORMATION_MESSAGE);
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
          rs=st.executeQuery("SELECT BB_NO_NO,GUEST_ID,GUEST_NAME,FH_NAME,ARR_FROM,PUR_VISIT,ARR_DATE,TIME,DEP_DATE,NO_PERSON,WHERE_TO_GO,H_NO_NAME,S_NO_NAME,LOCALITY,PIN,CITY,      STATE,OFF_PHONE,H_PHONE,FAX_NO,EMAIL_ID,ROOM_NO,ROOM_CHARGE,ADV,DUES,RECEP_CODE,PAY_MODE FROM GENERAL_GUEST_DETAILS"); 
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
      
      txtBB_NO.setText(rs.getString(1));
      txtGUEST_ID.setText(rs.getString(2));
      txtGUEST_NAME.setText(rs.getString(3));
      txtFH_NAME.setText(rs.getString(4));
      txtARR_FROM.setText(rs.getString(5));
      txtPUR_VISIT.setText(rs.getString(6));
      txtARR_DATE.setText(rs.getString(7));
      txtTIME.setText(rs.getString(8));
      txtDEP_DATE.setText(rs.getString(9));
      txtNO_PERSON.setText(rs.getString(10));
      txtWHERE_TO_GO.setText(rs.getString(11));
      txtH_NO_NAME.setText(rs.getString(12));
      txtS_NO_NAME.setText(rs.getString(13));
      txtLOCALITY.setText(rs.getString(14));
      txtPIN.setText(rs.getString(15));
      txtCITY.setText(rs.getString(16));
      txtSTATE.setText(rs.getString(17));
      txtOFF_PHONE.setText(rs.getString(18));
      txtH_PHONE.setText(rs.getString(19));
      txtFAX_NO.setText(rs.getString(20));
      txtEMAIL_ID.setText(rs.getString(21));
      txtROOM_NO.setText(rs.getString(22));
      txtROOM_CHARGE.setText(rs.getString(23));
      txtADV.setText(rs.getString(24));
      txtDUES.setText(rs.getString(25));
      txtRECEP_CODE.setText(rs.getString(26));
      txtPAY_MODE.setText(rs.getString(27));

    }catch(Exception e){}
  }
  public void clearEntry()
  {
      txtBB_NO.setText("");
      txtGUEST_ID.setText("");
      txtGUEST_NAME.setText("");
      txtFH_NAME.setText("");
      txtARR_FROM.setText("");
      txtPUR_VISIT.setText("");
      txtARR_DATE.setText("");
      txtTIME.setText("");
      txtDEP_DATE.setText("");
      txtNO_PERSON.setText("");
      txtWHERE_TO_GO.setText("");
      txtH_NO_NAME.setText("");
      txtS_NO_NAME.setText("");
      txtLOCALITY.setText("");
      txtPIN.setText("");
      txtCITY.setText("");
      txtSTATE.setText("");
      txtOFF_PHONE.setText("");
      txtH_PHONE.setText("");
      txtFAX_NO.setText("");
      txtEMAIL_ID.setText("");
      txtROOM_NO.setText("");
      txtROOM_CHARGE.setText("");
      txtADV.setText("");
      txtDUES.setText("");
      txtRECEP_CODE.setText("");
      txtPAY_MODE.setText("");

  }
  public void enableEntry()
  {
      txtBB_NO.setEditable(true);
      txtGUEST_ID.setEditable(true);
      txtGUEST_NAME.setEditable(true);

      txtFH_NAME.setEditable(true);
      txtARR_FROM.setEditable(true);
      txtPUR_VISIT.setEditable(true);
      txtARR_DATE.setEditable(true);
      txtTIME.setEditable(true);
      txtDEP_DATE.setEditable(true);
      txtNO_PERSON.setEditable(true);
      txtWHERE_TO_GO.setEditable(true);
      txtH_NO_NAME.setEditable(true);
      txtS_NO_NAME.setEditable(true);
      txtLOCALITY.setEditable(true);
      txtPIN.setEditable(true);
      txtCITY.setEditable(true);
      txtSTATE.setEditable(true);
      txtOFF_PHONE.setEditable(true);
      txtH_PHONE.setEditable(true);
      txtFAX_NO.setEditable(true);
      txtEMAIL_ID.setEditable(true);
      txtROOM_NO.setEditable(true);
      txtROOM_CHARGE.setEditable(true);
      txtADV.setEditable(true);
      txtDUES.setEditable(true);
      txtRECEP_CODE.setEditable(true);
      txtPAY_MODE.setEditable(true);     
  }

  public void disableEntry()
  {
      txtBB_NO.setEditable(false);
      txtGUEST_ID.setEditable(false);
      txtGUEST_NAME.setEditable(false);
      txtFH_NAME.setEditable(false);
      txtARR_FROM.setEditable(false);
      txtPUR_VISIT.setEditable(false);
      txtARR_DATE.setEditable(false);
      txtTIME.setEditable(false);
      txtDEP_DATE.setEditable(false);
      txtNO_PERSON.setEditable(false);
      txtWHERE_TO_GO.setEditable(false);
      txtH_NO_NAME.setEditable(false);
      txtS_NO_NAME.setEditable(false);
      txtLOCALITY.setEditable(false);
      txtPIN.setEditable(false);
      txtCITY.setEditable(false);
      txtSTATE.setEditable(false);
      
      txtOFF_PHONE.setEditable(false);
      txtH_PHONE.setEditable(false);
      txtFAX_NO.setEditable(false);
      txtEMAIL_ID.setEditable(false);
      txtROOM_NO.setEditable(false);
      txtROOM_CHARGE.setEditable(false);
      txtADV.setEditable(false);
      txtDUES.setEditable(false);
      txtRECEP_CODE.setEditable(false);
      txtPAY_MODE.setEditable(false);    
  }

  public boolean saveRecord()
  {
    boolean result=true;
    try{
    String sql  = "INSERT INTO GENERAL_GUEST_DETAILS VALUES("+
                  txtBB_NO.getText() + "," +
                  "'" + txtGUEST_ID.getText() + "'," +
                  "'" + txtGUEST_NAME.getText() + "'," +
                  "'" + txtFH_NAME.getText() + "'," +
                  "'"+ txtARR_FROM.getText()+ "',"+
                  "'" + txtPUR_VISIT.getText() + "'," +
                  "'" + txtARR_DATE.getText() + "'," +
                  "'" + txtTIME.getText() + "'," +
                  "'"+ txtDEP_DATE.getText()+ "',"+
                  txtNO_PERSON.getText() + "," +
                  "'" + txtWHERE_TO_GO.getText() + "'," +
                  "'" + txtH_NO_NAME.getText() + "'," +
                  "'"+ txtS_NO_NAME.getText()+ "',"+
                  "'" + txtLOCALITY.getText() + "'," +
                  txtPIN.getText() + "," +
                  "'" + txtCITY.getText() + "'," +
                  "'"+ txtSTATE.getText()+ "',"+
                  txtOFF_PHONE.getText() + "," +
                  txtH_PHONE.getText() + "," +
                  txtFAX_NO.getText() + "," +
                  "'" + txtEMAIL_ID.getText() + "'," +
                  "'"+ txtROOM_NO.getText()+ "',"+
                  txtROOM_CHARGE.getText() + "," +
                  txtADV.getText() + "," +
                  txtDUES.getText() + "," +
                  "'" + txtRECEP_CODE.getText()+ "',"+
                  "'" + txtPAY_MODE.getText()+"')";


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
    String sql  = "UPDATE GENERAL_GUEST_DETAILS SET "+
                  txtBB_NO.getText() + "," +
                  "'" + txtGUEST_ID.getText() + "'," +
                  "'" + txtGUEST_NAME.getText() + "'," +
                  "'" + txtFH_NAME.getText() + "'," +
                  "'"+ txtARR_FROM.getText()+ "',"+
                  "'" + txtPUR_VISIT.getText() + "'," +
                  "'" + txtARR_DATE.getText() + "'," +
                  "'" + txtTIME.getText() + "'," +
                  "'"+ txtDEP_DATE.getText()+ "',"+
                  txtNO_PERSON.getText() + "," +
                  "'" + txtWHERE_TO_GO.getText() + "'," +
                  "'" + txtH_NO_NAME.getText() + "'," +
                  "'"+ txtS_NO_NAME.getText()+ "',"+
                  "'" + txtLOCALITY.getText() + "'," +
                  txtPIN.getText() + "," +
                  "'" + txtCITY.getText() + "'," +
                  "'"+ txtSTATE.getText()+ "',"+
                  txtOFF_PHONE.getText() + "," +
                  txtH_PHONE.getText() + "," +
                  txtFAX_NO.getText() + "," +
                  "'" + txtEMAIL_ID.getText() + "'," +
                  "'"+ txtROOM_NO.getText()+ "',"+
                  txtROOM_CHARGE.getText() + "," +
                  txtADV.getText() + "," +
                  txtDUES.getText() + "," +
                  "'" + txtRECEP_CODE.getText()+ "',"+
                  "'" + txtPAY_MODE.getText()+"')";

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
    frmGg_details frm=new frmGg_details();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
  }
}

