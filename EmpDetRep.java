import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import javax.swing.table.*;

class EmpDetRp extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3;
	JButton b1,btnBack;
	JComboBox cb1;
	Connection con;
	Statement st;
	ResultSet rs1;
	String ids;
	static JTable table;
  String sub="";
	String[] columnnames={"Employee ID","Frist Name","Last Name","Contact Number","Address","EMail ID","Driving Experience"};
	String from;
	JFrame frame1;
	public EmpDetRp()
	{
		lb1=new JLabel("Fetching Employee Information");
		lb1.setForeground(Color.BLUE);
		lb1.setFont(new Font("Comic Sans MS",Font.BOLD,22));

		lb2=new JLabel("Employee ID");

		b1=new JButton("Submit");
		btnBack=new JButton("Home");

		lb1.setBounds(100,50,350,40);
    lb2.setBounds(75,110,100,20);
		b1.setBounds(180,350,100,30);
		btnBack.setBounds(50,350,100,30);

	  b1.addActionListener(this);
		btnBack.addActionListener(this);

	  setTitle("Employee Detail Report ");
		setLayout(null);
	  setVisible(true);
	  setSize(1366,768);

	  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    add(lb1); add(lb2);
	  add(b1); add(btnBack);
		
    try
		{
			Class.forName("com.mysql.jdbc.Driver");
                                  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                                  
			st=con.createStatement();
			
			rs1=st.executeQuery("select distinct(EmpID) from employeedetails");
      if(rs1==null)
      System.out.println("null");
                                  
			Vector v=new Vector();
                                  
			while(rs1.next())
			{                          
      	ids=rs1.getString("EmpID");
				v.add(ids);	
      }
      cb1 =new JComboBox(v);
			cb1.setBounds(175,110,150,50);
			add(cb1);
			st.close();
			rs1.close();
    }
    catch(Exception e)
    {} 
  }
public void actionPerformed(ActionEvent ae)
	{
      if(ae.getSource()==b1)
			showTableData();

			if(ae.getSource()==btnBack)
			{
				new HomePg();
				setVisible(false);
			}
		}
		public void showTableData()
		{
		  frame1=new JFrame("Employee Details Information");
		  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setLayout(new BorderLayout());
		  DefaultTableModel model=new  DefaultTableModel();
		  model.setColumnIdentifiers(columnnames);
		  table = new JTable();
		  table.setModel(model);
		  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  JScrollPane scroll = new JScrollPane(table);
		  scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      from = (String)cb1.getSelectedItem();
			int cid,bill;
			String cname,bdate;
		  try
		  {
		   PreparedStatement pst=con.prepareStatement("select * from employeedetails where EmpID='"+from+"' " );
	     ResultSet rs=pst.executeQuery();

		   	int i=0;
		 		String fn,pe,lv,pk,fs,pc,ib;
        fn=from;
        int a,g;
        String b,c,d,e,f;
		   while(rs.next())
		   {
          a=rs.getInt(1);
          b=rs.getString(2);
       		c=rs.getString(3);
          d=rs.getString(4);
          e=rs.getString(5);
          f=rs.getString(6);
          g=rs.getInt(7);
		      model.addRow(new Object[]{a,b,c,d,e,f,g});		
		      i++;			      

        	}	 
          if(i<1)
		      JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);

        }catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
           frame1.add(scroll);
		       frame1.setVisible(true);
		       frame1.setSize(1366,768); 	
				}
}
class EmpDetRep
{
  public static void main(String cp[])
  {
      new EmpDetRp();
    }
}