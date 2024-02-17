import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import javax.swing.table.*;

class mpreport extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3;
	JButton b1,b2;
	JComboBox cb1;
	Connection con;
	Statement st;
	ResultSet rs1;
	String ids;
	static JTable table;
  	String sub="";
	String[] columnnames={"Maintenance Number","Date of Maintenance","Details","Responsible","Amount"};
	String from;
	JFrame frame1;
	public mpreport()
	{
		lb1=new JLabel("Maintenance Information");
		lb1.setForeground(Color.BLUE);
		lb1.setFont(new Font("Comic Sans MS",Font.BOLD,22));

		lb2=new JLabel(" Person Name");

		b1=new JButton("Home");
		b2=new JButton("Submit");

		lb1.setBounds(50,50,400,40);
   	lb2.setBounds(75,110,100,20);

	 	b1.setBounds(75,300,100,30);
		b2.setBounds(190,300,100,30);

	  b1.addActionListener(this);
		b2.addActionListener(this);

	  setTitle("Maintenance Report ");
		setLayout(null);
	  setVisible(true);
	  setSize(1366,768);

	  	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	add(lb1); add(lb2);
	  	add(b1); add(b2);
		
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
                                  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                                  
			st=con.createStatement();
			
			rs1=st.executeQuery("select distinct(personres) from maintenance");
     	 	if(rs1==null)
     		System.out.println("null");
                                  
			Vector v=new Vector();
                                  
			while(rs1.next())
			{
				ids=rs1.getString("personres");
      			//sub=rs.getString("subjectname");
				v.add(ids);	
			}
			cb1 =new JComboBox(v);
			cb1.setBounds(175,110,150,50);
			add(cb1);
			st.close();
			rs1.close();
		}
		catch(Exception e)
		{

		}
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b2)
			showTableData();

		if(ae.getSource()==b1)
		{
			new HomePg();
				setVisible(false);
			//btnUpdate.setEnabled(false);
		}
    }
    public void showTableData()
		{
		  frame1=new JFrame("Maintenance Person-wise from Database Search");
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
		  	PreparedStatement pst=con.prepareStatement("select * from maintenance where personres='"+from+"' " );
	    	 ResultSet rs=pst.executeQuery();

		   		int i=0;
		 		String fn,pe,lv,pk,fs,pc,ib;
       			fn=from;
        		int a,b;
        		String c,d,e,f;
		  	 	while(rs.next())
		  		{
		  			a=rs.getInt(1);
       				c=rs.getString(2);
          			d=rs.getString(3);
         			e=rs.getString(4);
          			b=rs.getInt(5);
          			f=rs.getString(6);
		      		model.addRow(new Object[]{a,c,d,e,b,f});		
		      		i++;			      
		   		}
		   		if(i<1)
		      JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception e)
        	{
          		JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        	}
        	frame1.add(scroll);
		    frame1.setVisible(true);
		    frame1.setSize(1366,768); 	
		}
}
class MaintenanceRep
{
  public static void main(String cp[])
  	{
      new mpreport();
    }
}