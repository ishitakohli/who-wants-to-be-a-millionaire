import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 
import java.sql.*;
public class Setup extends JFrame implements ActionListener
{
    JLabel lblmsg;
    JPanel p1,p2,p3;
    JProgressBar pbar;
    Container cnt;
    Connection cn;
    Statement st;
    JButton btnSetup,btnExit;
    public Setup ()
    {
       setTitle("Employee Management System :: Database Setup");
       setSize(400,200);
       setLocation(200,200);
       addWindowListener(new WindowAdapter(){
       public void windowClosing(WindowEvent e){setVisible(false);}});
       cnt=getContentPane();
       p1 = new JPanel();
       lblmsg = new JLabel();

       cnt.setLayout(new GridLayout(0, 1));
       p1.setBorder(BorderFactory.createTitledBorder("Database Setup"));
       p1.setLayout(new BorderLayout());

       lblmsg.setMinimumSize(new Dimension(50, 25));
       p1.add(lblmsg, BorderLayout.CENTER);
       cnt.add(p1);

       p2 = new JPanel();
       pbar = new JProgressBar();

       p2.setBorder(BorderFactory.createTitledBorder(""));
       p2.setLayout(new BorderLayout());
       pbar.setMinimum(0);
       pbar.setMaximum(10);
       pbar.setValue(0);
       p2.add(pbar, "Center");
       cnt.add(p2);

       p3 = new JPanel();
       btnSetup = new JButton("Setup");
       btnExit = new JButton("Exit");

       p3.setLayout(new FlowLayout());

       btnSetup.setMnemonic('S');
       btnExit.setMnemonic('E');

       btnSetup.addActionListener(this);
       btnExit.addActionListener(this);

       p3.add(btnSetup);
       p3.add(btnExit);
       cnt.add(p3);
    }

    public void createUser() throws Exception
    {
       // Establishing Connection with Oracle

      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      cn=DriverManager.getConnection("jdbc:odbc:Ashish","system","manager");
       // Creating user and Setting Permissions");
       st = cn.createStatement ();
      try{
       st.execute ("drop user apj cascade");
       }catch (SQLException e) { }     
       st.execute ("CREATE USER APJ IDENTIFIED BY PROJECTS");
       st.execute ("GRANT CONNECT,RESOURCE TO APJ");
       st.close();
       if (cn != null) {
           cn.close();
       }
    }
    public void createTable() throws Exception
    {
       // Establishing Connection with Oracle as user

      cn=DriverManager.getConnection("jdbc:odbc:Ashish","APJ","PROJECTS");

       // Creating Tables..
       String sql;

       st = cn.createStatement ();

        sql  = "CREATE TABLE SECURITY ( " +
               "USR_ID   VARCHAR2(12) PRIMARY KEY," +
               "USR_PWD  VARCHAR2(12) NOT NULL   ," +
               "status   varchar(1)   NOT NULL)";   
       st.execute (sql);
       System.out.println("Security table is created");

        sql = "CREATE TABLE ROOM_DETAILS(" +
               "ROOM_NO      VARCHAR2(8)    PRIMARY KEY,"+
               "FLOOR_NO     NUMBER (10)    NOT NULL,"+
               "ROOM_TYPE    VARCHAR2(15)   NOT NULL,"+
               "ROOM_CHARGE  NUMBER(10,5)   NOT NULL,"+
               "REMARKS      VARCHAR2(80)   NOT NULL,"+
               "ROOM_STATUS  VARCHAR2(25)   NOT NULL)";
               st.execute (sql); 
               System.out.println("Room_details table is created"); 

          sql   = "CREATE TABLE RECEPTION_DETAILS("+
               "RECEP_CODE     VARCHAR2(10)   PRIMARY KEY,"+
               "RECEP_NAME     VARCHAR2(30)   NOT NULL,"+              
               "ADDRESS        VARCHAR2(80)   NOT NULL,"+
               "ARR_RECEP_TIME DATE           NOT NULL,"+
               "DEP_RECEP_TIME DATE           NOT NULL)";      
                st.execute (sql); 
                System.out.println("Reception_details table is created"); 


          sql   ="CREATE TABLE MIS_DETAILS_TABLE("+
                " ARR_DATE       DATE        PRIMARY KEY,"+
                " OCCUPANCY      NUMBER(4)   NOT NULL,"+
                " OCCU_PERCENT   NUMBER(10)  NOT NULL,"+
                " NO_OF_PERSON   NUMBER(10)  NOT NULL,"+
                " NO_OF_EXT_BED  NUMBER(10)  NOT NULL,"+
                " NO_ARR         NUMBER(10)  NOT NULL,"+
                " NO_DEP         NUMBER(10)  NOT NULL,"+
                " NO_OF_IND      NUMBER(10)  NOT NULL,"+
                " NO_OF_FOREIGN  NUMBER(8)   NOT NULL,"+
                " TOT_ROOM_RENT  NUMBER(8,2) NOT NULL,"+
                " FB_TOT         NUMBER(8,2) NOT NULL,"+
                " MIS_TOT        NUMBER(8,2) NOT NULL,"+
                " CASH_SALE      NUMBER(8,2) NOT NULL,"+
                " CREDIT_SALE    NUMBER(8,2) NOT NULL,"+
                " GROSS_SALE     NUMBER(8,2) NOT NULL,"+
                " GUEST_TYPE     VARCHAR2(11) NOT NULL)";
                 st.execute (sql);
                 System.out.println("Mis_details_table table is created");  

          sql      =" CREATE TABLE GUEST_DETAILS("+
                " GUEST_ID     VARCHAR2(12) PRIMARY KEY,"+
                " GUEST_NAME   VARCHAR2(30) NOT NULL,"+
                " ROOM_TYPE    VARCHAR2(15) NOT NULL,"+
                " FLOOR_NO     NUMBER(9)    NOT NULL,"+
                " ROOM_NO      VARCHAR2(8)  REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+ 
                " ROOM_CHARGE  NUMBER(9)    NOT NULL,"+
                " ADV          NUMBER(9)    NOT NULL,"+
                " ADATE        DATE         NOT NULL,"+
                " DDTAE        DATE         NOT NULL,"+
                " GUEST_TYPE   VARCHAR2(15) NOT NULL,"+
                " REMARKS      VARCHAR2(30) NOT NULL)";
              st.execute (sql);
              System.out.println("Guest_details table is created");
  
         sql    =" CREATE TABLE  MIS_DETAILS("+
                 " GUEST_ID   VARCHAR2(12)  REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+
                 " GUEST_NAME VARCHAR2(30) NOT NULL,"+
                 " ROOM_NO    VARCHAR2(8) REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+  
                 " DDATE      DATE NOT     NULL,"+
                 " TYPE       VARCHAR2(9)  NOT NULL,"+
                 " AMT        NUMBER(9)    NOT NULL,"+
                 " RECEP_NO   VARCHAR2(15) NOT NULL,"+
                 " PAID       VARCHAR2(15) NOT NULL,"+
                 " TOT_BILL   NUMBER(8,2)  NOT NULL,"+
                 " TOT_PAID   NUMBER(8,2)  NOT NULL,"+
                 " TOT_BAL    NUMBER(8,2)  NOT NULL)";
                  st.execute (sql);
                  System.out.println("Mis_details table is created"); 
 
        sql     =" CREATE TABLE GUEST_MSC_CHECK_OUT_DETAILS("+
                 " BB_NO      VARCHAR2(10) NOT NULL,"+
                 " DDATE      DATE NOT     NULL,"+
                 " GUEST_ID   VARCHAR2(12) REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+
                 " GUEST_NAME VARCHAR2()   NOT NULL,"+
                 " ROOM_NO    VARCHAR2(8)  REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+
                 " RECEP_NO   VARCHAR2(12) NOT NULL,"+
                 " M_DATE     DATE         NOT NULL,"+
                 " M_TOT_BILL NUMBER (8,2) NOT NULL,"+  
                 " M_TOT_PAID NUMBER (8,2) NOT NULL,"+ 
                 " M_BAL      NUMBER (8,2) NOT NULL)"; 
                 st.execute (sql);
                 System.out.println("Guest_msc_check_out_details table is created"); 

      
        sql     =" CREATE TABLE GUEST_FB_CHECK_OUT_DETAILS("+
                 " TDATE       DATE         NOT NULL,"+
                 " GUEST_ID    VARCHAR2(12)REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+
                 " GUEST_NAME  VARCHAR(30)  NOT NULL,"+
                 " ROOM_NO     VARCHAR2(8) REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+ 
                 " RECEP_NO    VARCHAR2(15) NOT NULL,"+
                 " F_DATE      DATE         NOT NULL,"+
                 " F_TOT_BILL  NUMBER(9,2)  NOT NULL,"+
                 " F_TOT_PAID  NUMBER(9,2)  NOT NULL,"+
                 " F_BAL       NUMBER(9,2)  NOT NULL)";
               st.execute (sql);
               System.out.println("Guest_fb_check_out_details table is created"); 
   
                    
       sql      =" CREATE TABLE GUEST_CHECK_OUT_DETAILS("+
                 " GUEST_ID VARCHAR2(12)REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+
                 " GUEST_NAME VARCHAR2(30) NOT NULL,"+
                 " ROOM_NO VARCHAR2(8) REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+
                 " INDATE DATE NOT NULL,"+
                 " OUTDATE DATE NOT NULL,"+
                 " OUTTIME VARCHAR2(10) NOT NULL,"+
                 " REMARKS VARCHAR2(25) NOT NULL)";
             st.execute (sql);
             System.out.println("Guest_check_out_details table is created");

      sql     =" CREATE TABLE GUEST_BILLING_DETAILS("+
               " BILL_NO     VARCHAR2(15) PRIMARY KEY,"+
               " BDATE       DATE      NOT NULL,"+
               " GUEST_ID    VARCHAR2(12) REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+ 
               " GUEST_NAME  VARCHAR2(30) NOT NULL,"+
               " ROOM_NO     VARCHAR2(8) REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+
               " ROOM_CHARGE NUMBER(9) NOT NULL,"+   
               " FB_BILL     NUMBER(9) NOT NULL,"+
               " MSC_BILL    NUMBER(9) NOT NULL,"+
               " TOTAL       NUMBER(9) NOT NULL,"+
               " TAX         NUMBER(9) NOT NULL,"+
               " ADV         NUMBER(9) NOT NULL,"+
               " BAL         NUMBER(9) NOT NULL)";
          st.execute (sql);
          System.out.println("Guest_billing_details table is created");

       sql     =" CREATE TABLE GENERAL_GUEST_DETAILS("+  
                " BB_NO        VARCHAR2(15)   NOT NULL,"+ 
                " GUEST_ID VARCHAR2(12)REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+ 
                " GUEST_NAME   VARCHAR2(30)   NOT NULL,"+
                " FH_NAME      VARCHAR2(30)   NOT NULL,"+
                " ARR_FROM     VARCHAR2(50)   NOT NULL,"+
                " PUR_VISIT    VARCHAR2(100)  NOT NULL,"+
                " TIME         VARCHAR(10)    NOT NULL,"+
                " DEP_DATE     DATE           NOT NULL,"+
                " NO_PERSON    NUMBER(9)      NOT NULL,"+
                " WHERE_TO_GO  VARCHAR2(15)   NOT NULL,"+
                " H_NO_NAME    VARCHAR2(15)   NOT NULL,"+
                " S_NAME_NO    VARCHAR2(15)   NOT NULL,"+
                " LOCALITY     VARCHAR2(15)   NOT NULL,"+
                " PIN          NUMBER(10)     NOT NULL,"+
                " CITY         VARCHAR2(15)   NOT NULL,"+
                " STATE        VARCHAR2(15)   NOT NULL,"+
                " OFF_PHONE    NUMBER(10)     NOT NULL,"+
                " H_PHONE      NUMBER(10)     NOT NULL,"+
                " FAX_NO       NUMBER(10)     NOT NULL,"+
                " EMAIL_ID     VARCHAR2(2)    NOT NULL,"+
                " ROOM_NO VARCHAR2(8) REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+    
                " ROOM_CHARGE  NUMBER(10)     NOT NULL,"+
                " ADV          NUMBER(10)     NOT NULL,"+
                " DUES         NUMBER(10)     NOT NULL,"+
                " RECEP_CODE VARCHAR2(10)REFERENCES RECEPTION_DETAILS(RECEP_CODE) NOT NULL,"+ 
                " PAY_MODE     VARCHAR2(10) NOT NULL)";
              st.execute (sql);
              System.out.println("General_guest_details table is created");


sql     =" CREATE TABLE COMPANY_GUEST_DETAILS("+  
                " BB_NO         VARCHAR2(15)     NOT NULL,"+ 
                " GUEST_ID VARCHAR2(12)REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+ 
                " GUEST_NAME    VARCHAR2(30)     NOT NULL,"+
                " DIR_EX_NAME   VARCHAR2(30)     NOT NULL,"+
                " ARR_FROM      VARCHAR2(50)     NOT NULL,"+
                " PUR_VISIT     VARCHAR2(100)    NOT NULL,"+
                " TIME          VARCHAR(10)      NOT NULL,"+
                " DEP_DATE      DATE             NOT NULL,"+
                " NO_PERSON     NUMBER(9)        NOT NULL,"+
                " WHERE_TO_GO   VARCHAR2(15)     NOT NULL,"+
                " COM_NAME      VARCHAR2(25)     NOT NULL,"+
                " S_NAME_NO     VARCHAR2(15)     NOT NULL,"+
                " LOCALITY      VARCHAR2(15)     NOT NULL,"+
                " PIN           NUMBER(10)       NOT NULL,"+
                " CITY          ARCHAR2(15)      NOT NULL,"+
                " STATE         VARCHAR2(15)     NOT NULL,"+
                " OFF_PHONE     NUMBER(10)       NOT NULL,"+
                " H_PHONE       NUMBER(10)       NOT NULL,"+
                " FAX_NO        NUMBER(10)       NOT NULL,"+
                " EMAIL_ID      VARCHAR2(2)      NOT NULL,"+
                " ROOM_NO       VARCHAR2(8) REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+    
                " ROOM_CHARGE   NUMBER(10)       NOT NULL,"+
                " ADV           NUMBER(10)       NOT NULL,"+
                " DUES          NUMBER(10)       NOT NULL,"+
                " RECEP_CODE VARCHAR2(10)REFERENCES    RECEPTION_DETAILS(RECEP_CODE) NOT NULL,"+ 
                " PAY_MODE      VARCHAR2(10)     NOT NULL)";
            st.execute (sql);
            System.out.println("Company_guest_detail table is created");

        sql   = "CREATE TABLE FB_DETAILS("+
                " GUEST_ID VARCHAR2(12)REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+ 
                " GUEST_NAME       VARCHAR2(30)    NOT NULL,"+
                " ROOM_NO VARCHAR2(8)REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+ 
                " DDATE            DATE            NOT NULL,"+
                " TYPE             VARCHAR2(25)    NOT NULL,"+
                " AMT              NUMBER(9)       NOT NULL,"+
                " RECEP_NO         VARCHAR2(15)    NOT NULL,"+
                " PAID             VARCHAR2(15)    NOT NULL,"+
                " TOT_BILL         NUMBER(9,2)     NOT NULL,"+
                " TOT_PAID         NUMBER(9,2)     NOT NULL,"+
                " TOT_BAL          NUMBER(9,2)     NOT NULL)";
              st.execute (sql);
              System.out.println("Fb_details table is created");
    
      sql    = "CREATE TABLE CREDIT ("+
               " GUEST_ID  VARCHAR2(12)REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+ 
               " ROOM_NO   VARCHAR2(8)REFERENCES ROOM_DETAILS(ROOM_NO) NOT NULL,"+  
               " CDATE      DATE         NOT NULL,"+
               " AMT        NUMBER(9)    NOT NULL,"+
               " DUES       NUMBER(10)   NOT NULL,"+
               " PAY_CODE   VARCHAR2(10) NOT NULL,"+
               " RECEP_MODE VARCHAR2(10))";
             st.execute (sql);
             System.out.println("Credit table is created");

     sql     = "CREATE TABLE COMPLATE_INFO("+
               " GUEST_ID  VARCHAR2(12)REFERENCES GUEST_DETAILS(GUEST_ID) NOT NULL,"+ 
               " ARR_DATE    DATE REFERENCES RECEPTION_DETAILS(ARR_DATE) NOT NULL,"+ 
               " GUEST_TYPE VARCHAR2(11) NOT NULL)";
           st.execute (sql);
           System.out.println("Compalate_info table is created");
 
     sql     = "CREATE TABLE CASH("+
               " CDATE DATE        NOT NULL,"+
               " CASH  NUMBER(9,2) NOT NULL)";
              st.execute (sql);
              System.out.println("Cash table is created");
 
   
       st.close();
       if (cn != null){
         cn.close();
       }

       // Installation Completed Successfully
    }

    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==btnSetup)
       {
          try{
            pbar.setValue(0);
            lblmsg.setText("Connecting with Oracle :: Creating user");
            createUser();
            pbar.setValue(4);
            
            lblmsg.setText("Connecting with Oracle :: Creating tables");
            createTable();
            pbar.setValue(10);

            lblmsg.setForeground(Color.black);
            lblmsg.setText(" Database Installation Completed ");
          }catch(Exception k){}
       }
       if(e.getSource()==btnExit)
       {
          this.setVisible(false);
       }
    }

    public static void main(String args[])
    {
       Setup  s=new Setup();
       s.setVisible(true);
    }
}
