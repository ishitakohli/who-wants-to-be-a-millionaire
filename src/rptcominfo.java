import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class rptcominfo extends JFrame implements ActionListener
{
    JPanel p,t;
    JLabel      lblGUEST_ID;
    JComboBox   cmbGUEST_ID;
    JButton     btnSHOW;
    JButton     btnSHOWALL;
    JButton     btnPrint;
    JButton     btnPgSetup;
    JButton     btnCLOSE;

   // PrintPanelEmp canvas;
    PageFormat pageFormat;
    PrinterJob printJob;
    Connection cn;
    ResultSet  rs,rs1;
    ResultSetMetaData rsmd;
    Statement  st,st1;
    int rcount=0,ccount=0;
    String columnNames[];
    Object[][] cells;
    Container cnt;
    JTable table;
    String wCOND="";
    public void connect() {
       try{
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          cn=DriverManager.getConnection("jdbc:odbc:Ashish","scott","tiger");
       }catch(Exception e) { }
    }
    public void setGUEST_ID()
    {
        String query = "SELECT GUEST_ID FROM COMPLATE_INFO" ;
        try{
            st1 = cn.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,
                                           ResultSet.CONCUR_READ_ONLY);
            rs1 = st1.executeQuery(query);
            rs1.beforeFirst();
            while(rs1.next())
              cmbGUEST_ID.addItem(rs1.getString(1));
            rs1.close();
            st1.close();
       }catch (SQLException e){ }
    }
    public void openRecord() 
    {
        String query = "SELECT GUEST_ID,TO_CHAR(ARR_DATE,'DD-Mon-YYYY') AS ARR_DATE,GUEST_TYPE from COMPLATE_INFO "+ wCOND;
        try{
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                         ResultSet.CONCUR_UPDATABLE);
            st.setFetchSize (1);
            rs = st.executeQuery(query);
            rcount = 0;
      while(rs.next()){ rcount++; }
            rsmd=rs.getMetaData();
            ccount=rsmd.getColumnCount();
        
        }catch (SQLException e){ }
    }

    public void setData()
    {
            int i,j;
        try{
            for(i=0;i<ccount;i++)
              columnNames[i]=rsmd.getColumnName(i+1);
            i=0;
            rs.first();
            do{
              for(j=0;j<ccount;j++)
                 cells[i][j]=rs.getString(j+1);
              i++;
            }while(rs.next());
            rs.first();
        }catch (SQLException e){ }
    }
   public rptcominfo()
   {
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

       setTitle("Guest Report");
       setSize(screenSize.width-20,screenSize.height-20);

       setLocation(10,10);

      addWindowListener(new WindowAdapter()
         {  public void windowClosing(WindowEvent e)
            { 
               setVisible(false);
            }});
     cnt = getContentPane();
     p=new JPanel();
     p.setLayout(new GridLayout(1,6));
     lblGUEST_ID  = new JLabel("Guest_id :  ",SwingConstants.RIGHT);
     cmbGUEST_ID  = new JComboBox();
     btnSHOW       = new JButton("Show");      btnSHOW.setMnemonic('S');
     btnSHOWALL   = new JButton("Show All");  btnSHOW.setMnemonic('A');
     btnPrint     = new JButton("Print");     btnPrint.setMnemonic('P');
     btnPgSetup   = new JButton("Page setup");btnPgSetup.setMnemonic('G');
     btnCLOSE         = new JButton("Close");     btnCLOSE.setMnemonic('C');

     cmbGUEST_ID.setEditable(false);

     btnSHOW.addActionListener(this);
     btnSHOWALL.addActionListener(this);
     btnPrint.addActionListener(this);
     btnPgSetup.addActionListener(this);
     btnCLOSE.addActionListener(this);

     btnSHOW.setForeground(Color.blue);
     btnSHOWALL.setForeground(Color.blue);
     btnPrint.setForeground(Color.blue);
     btnPgSetup.setForeground(Color.blue);
     btnCLOSE.setForeground(Color.blue);
     lblGUEST_ID.setForeground(Color.blue);
     cmbGUEST_ID.setForeground(Color.blue);


     p.add(lblGUEST_ID);
     p.add(cmbGUEST_ID);
     p.add(btnSHOW);
     p.add(btnSHOWALL);
     p.add(btnPrint);
     p.add(btnPgSetup);
     p.add(btnCLOSE);
     cnt.add(p,"North");
      connect();
      setGUEST_ID();
      t=new JPanel();
      openRecord();
     // canvas = new PrintPanelEmp();
      //cnt.add(canvas, "Center");

   }
   public void actionPerformed(ActionEvent e)
   {
        if(e.getSource()==btnSHOW)
        {
              wCOND="WHERE GUEST_ID=" + (String)cmbGUEST_ID.getSelectedItem();
            //   canvas.setCondition(wCOND);
              openRecord();
              if(rcount==0)
              {
                JOptionPane.showMessageDialog(null,"Data not Found.",
                       "eMPLOYEE rEPORT",JOptionPane.INFORMATION_MESSAGE);
              }
              else
              {
                columnNames=new String[ccount];
                cells=new Object[rcount][ccount];
                setData();
                table = new JTable(cells, columnNames);
                remove(t);
                t=new JPanel();
                t.setBorder(BorderFactory.createTitledBorder("GuestWise Guest Report"));
                t.setLayout(new BorderLayout());
                t.add(new JScrollPane(table));
                cnt.add(t, "Center");
                setVisible(true);
              }
              show();
        }
            if(e.getSource()==btnSHOWALL)
            {
              wCOND = "";
              // canvas.setCondition(wCOND);
              openRecord();
              if(rcount==0)
              {
                JOptionPane.showMessageDialog(null,"Data not Found.",


                       "GUEST_IDWise GUEST Report",JOptionPane.INFORMATION_MESSAGE);
              }
              else
              {
                columnNames=new String[ccount];
                cells=new Object[rcount][ccount];
                setData();
                table = new JTable(cells, columnNames);
                remove(t);
                t=new JPanel();
                t.setBorder(BorderFactory.createTitledBorder("Guestwise Guest Report"));
                t.setLayout(new BorderLayout());
                t.add(new JScrollPane(table));
                cnt.add(t, "Center");
                setVisible(true);
              }
              show();
        }
      if (e.getSource()==btnPrint)
      {
        printJob = PrinterJob.getPrinterJob();
         if (pageFormat == null)
            pageFormat = printJob.defaultPage();
       //  printJob.setPrintable(canvas, pageFormat);
         if (printJob.printDialog())
         {  try
            {  printJob.print();
            }
            catch (PrinterException exception)
            {  JOptionPane.showMessageDialog(this, exception);
            }
         }
         show();
      }

      if(e.getSource()==btnPgSetup)
      {
        printJob = PrinterJob.getPrinterJob();
         if (pageFormat == null)
            pageFormat = printJob.defaultPage();
         else
         pageFormat = printJob.pageDialog(pageFormat);
         show();
      }

        if(e.getSource()==btnCLOSE)
        {
          if(cn != null) {
               try{
                 cn.close();
               }catch(Exception zx) {}
           }
           setVisible(false);
        }
    }
    public void itemStateChanged(ItemEvent ie)
    {
        if(ie.getSource()==cmbGUEST_ID)
        {
          show();
        }
    }
  public static void main(String args[])
    { rptcominfo rptc=new rptcominfo();
       rptc.show();
    } 
}
