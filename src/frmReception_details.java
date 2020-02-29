import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

class frmReception_details extends JFrame implements ActionListener
{
  JLabel  lblTitle;
  JLabel  lblRECEP_CODE;
  JLabel  lblRECEP_NAME;
  JLabel  lblADDRESS;
  JLabel  lblARR_RECEP_TIME;
  JLabel  lblDEP_RECEP_TIME;


  JTextField   txtRECEP_CODE;
  JTextField   txtRECEP_NAME;
  JTextField   txtADDRESS;
  JTextField   txtARR_RECEP_TIME;
  JTextField   txtDEP_RECEP_TIME;


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


  JPanel  pMAIN;

  JPanel  pADD;
  JPanel  pEDIT;                               
  
  Container cnt;
  Connection cn;
  Statement st;
  ResultSet rs,rs1;
  int rcount=0,rno=0;
  String mRECEP_CODE="";

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
      rs=st.executeQuery("SELECT RECEP_CODE,RECEP_NAME,ADDRESS,ARR_RECEP_TIME,DEP_RECEP_TIME FROM RECEPTION_DETAILS");
      while(rs.next()){ rcount++;}
      if(rcount>0){rno=1;rs.first();}
      Statement st=cn.createStatement();
      }catch(SQLException ex){}
      }
 
  public frmReception_details()
  {
    setTitle("The Hotel Suraj Excutive, Shirur-pune, Maharashtra");
    setSize(650,470);
    setLocation(100,70);
    cnt=getContentPane();
    cnt.setLayout(null);

    lblTitle    = new JLabel("Reception details Form ");
    lblTitle.setBounds(150,30,350,30);
    lblTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
    lblTitle.setForeground(Color.red);
    cnt.add(lblTitle);

    lblRECEP_CODE    = new JLabel("RECEP CODE");
    lblRECEP_CODE.setBounds(150,90,200,30);
    lblRECEP_CODE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblRECEP_CODE.setForeground(Color.black);

    lblRECEP_NAME    = new JLabel("RECEP NAME");
    lblRECEP_NAME.setBounds(150,120,200,30);
    lblRECEP_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblRECEP_NAME.setForeground(Color.black);

    lblADDRESS      = new JLabel("ADDRESS");
    lblADDRESS.setBounds(150,150,200,30);
    lblADDRESS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblADDRESS.setForeground(Color.black);

    lblARR_RECEP_TIME      = new JLabel("ARR RECEP TIME");
    lblARR_RECEP_TIME.setBounds(150,180,200,30);
    lblARR_RECEP_TIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblARR_RECEP_TIME.setForeground(Color.black);

    lblDEP_RECEP_TIME = new JLabel("DEP RECEP TIME"); 
    lblDEP_RECEP_TIME.setBounds(150,210,200,30);
    lblDEP_RECEP_TIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    lblDEP_RECEP_TIME.setForeground(Color.black);

    cnt.add(lblRECEP_CODE);
    cnt.add(lblRECEP_NAME);
    cnt.add(lblADDRESS);
    cnt.add(lblARR_RECEP_TIME);
    cnt.add(lblDEP_RECEP_TIME);

    txtRECEP_CODE   = new JTextField(10);
    txtRECEP_NAME    = new JTextField(30);
    txtADDRESS     = new JTextField(30);
    txtARR_RECEP_TIME      = new JTextField(30);
    txtDEP_RECEP_TIME = new JTextField(30);
   

    txtRECEP_CODE.setBounds(330,90,80,25);
 
   txtRECEP_CODE.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtRECEP_CODE.setForeground(Color.black);

    txtRECEP_NAME.setBounds(330,120,170,25);
    txtRECEP_NAME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtRECEP_NAME.setForeground(Color.black);

    txtADDRESS.setBounds(330,150,150,25);
    txtADDRESS.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtADDRESS.setForeground(Color.black);

    txtARR_RECEP_TIME.setBounds(330,180,150,25);
    txtARR_RECEP_TIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtARR_RECEP_TIME.setForeground(Color.black);

    txtDEP_RECEP_TIME.setBounds(330,210,150,25);
    txtDEP_RECEP_TIME.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
    txtDEP_RECEP_TIME.setForeground(Color.black);

    cnt.add(txtRECEP_CODE);
    cnt.add(txtRECEP_NAME);
    cnt.add(txtADDRESS);
    cnt.add(txtARR_RECEP_TIME);
    cnt.add(txtDEP_RECEP_TIME);

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
   

    pMAIN=new JPanel();
    pMAIN.setBounds(100,300,420,90);
    pMAIN.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.green,5),"Main Menu",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.red));
    pMAIN.setLayout(new GridLayout(2,5));
    pMAIN.setBackground(Color.white);
   
    pADD=new JPanel();
    pADD.setBounds(170,300,240,30);
    pADD.setLayout(new GridLayout(1,3));

    pEDIT=new JPanel();
    pEDIT.setBounds(230,300,160,30);
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
    p1.setBounds(100,75,420,200);
    cnt.add(p1);

    JPanel p=new JPanel();
    p.setBorder(BorderFactory.createTitledBorder("Reception details Form"));
    p.setBackground(Color.pink);
    p.setBounds(2,2,800,600);
    cnt.add(p);

    
    p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue,3),"Reception details  Form",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("Arial",Font.BOLD+Font.ITALIC,15),Color.black));
    p.setBackground(Color.pink);
    p.setBounds(1,1,640,440);
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
      try{mRECEP_CODE=rs.getString(1);}catch(SQLException ex){}
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
     if(e.getSource()==btnCLOSE)
    {
    setVisible(false);
    }
    if(e.getSource()==btnFIND)
    {
      boolean result=true;
      String fRECEP_CODE=JOptionPane.showInputDialog(null,"Enter Recep code . to Find","Find Dialog",JOptionPane.PLAIN_MESSAGE);
      try{
      Statement st=cn.createStatement();
      ResultSet rs1=st.executeQuery("SELECT * FROM RECEPTION_DETAILS WHERE RECEP_CODE="+fRECEP_CODE);
      if(rs1.next())
      {
        JOptionPane.showMessageDialog(null,"The Search Recep code . Found Successfully","Search Result",JOptionPane.INFORMATION_MESSAGE);
        rs.beforeFirst();
        while(rs.next())
          if(rs.getString(1).equals(fRECEP_CODE))
          {
            showRecord();
            break;
          }
      }
      else
        JOptionPane.showMessageDialog(null,"The Search Recep code. Not Found","Search Result",JOptionPane.INFORMATION_MESSAGE);
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
          rs=st.executeQuery("SELECT RECEP_CODE,RECEP_NAME,ADDRESS,ARR_RECEP_TIME,DEP_RECEP_TIME FROM RECEPTION_DETAILS"); 
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
      txtRECEP_CODE.setText(rs.getString(1));
      txtRECEP_NAME.setText(rs.getString(2));
      txtADDRESS.setText(rs.getString(3));
      txtARR_RECEP_TIME.setText(rs.getString(4));
      txtDEP_RECEP_TIME.setText(rs.getString(5));
          }catch(Exception e){}
  }
  public void clearEntry()
  {
      txtRECEP_CODE.setText("");
      txtRECEP_NAME.setText("");
      txtADDRESS.setText("");
      txtARR_RECEP_TIME.setText("");
      txtDEP_RECEP_TIME.setText("");
      
  }
  public void enableEntry()
  {
      txtRECEP_CODE.setEditable(true);
      txtRECEP_NAME.setEditable(true);
      txtADDRESS.setEditable(true);
      txtARR_RECEP_TIME.setEditable(true);

      txtDEP_RECEP_TIME.setEditable(true);
           
  }
  public void disableEntry()
  {
      txtRECEP_CODE.setEditable(false);
      txtRECEP_NAME.setEditable(false);
      txtADDRESS.setEditable(false);
      txtARR_RECEP_TIME.setEditable(false);
      txtDEP_RECEP_TIME.setEditable(false);
      
     
  }
  public boolean saveRecord()
  {
    boolean result=true;
    try{
    String sql  = "INSERT INTO RECEPTION_DETAILS VALUES("+
                  "'" + txtRECEP_CODE.getText() +"'," +
                  "'" + txtRECEP_NAME.getText() + "'," +
                  "'" + txtADDRESS.getText() + "'," +
                  "'" + txtARR_RECEP_TIME.getText() + "',"+
                  "'" + txtDEP_RECEP_TIME.getText()+ "')";
                  
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
    String sql  = "UPDATE RECEPTION_DETAILS SET "+
                  "RECEP_CODE= '" +txtRECEP_CODE.getText() + "'," +
                  "RECEP_NAME= '" + txtRECEP_NAME.getText() + "," +
                  "ADDRESS= '"+ txtADDRESS.getText() + "'," +
                  "ARR_RECEP_CODE = '" +txtARR_RECEP_TIME.getText() + "," +
                  "DEP_RECEP_TIME = '" +txtDEP_RECEP_TIME.getText()+ "')";
                
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
    frmReception_details frm=new frmReception_details();
    frm.show();
    frm.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){System.exit(0);}});
  }
}
