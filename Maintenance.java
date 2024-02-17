import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
class MaintenanceScr extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JRadioButton r1,r2;
	
	public MaintenanceScr()
	{  
		setLayout(null);
		lb1=new JLabel("MaintenanceNumber");
		lb2=new JLabel("Date");
		lb3=new JLabel("(DD-MM-YYYY)");
		lb4=new JLabel("Description");
		lb5=new JLabel("PersonResponsible");
		lb6=new JLabel("Amount");
		lb7=new JLabel("***MAINTENANCE  BILL***");
		lb8=new JLabel("_______________________");
		lb9=new JLabel("_______________________");
		lb10=new JLabel("Date");
		lb12=new JLabel("Servecing");
		lb7.setForeground(Color.BLUE);
		lb7.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb8.setForeground(Color.BLUE);
		lb8.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb9.setForeground(Color.BLUE);
		lb9.setFont(new Font("Comic Sans MS",Font.BOLD,22));


		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();

		b1=new JButton("Show");
		b2=new JButton("Insert");
		b3=new JButton("Update");
		b4=new JButton("Delete");
		b5=new JButton("Home");
		b6=new JButton("Set");
		b7=new JButton("Clear");
		
		
		r1=new JRadioButton("Free");    
		r2=new JRadioButton("Paid");    


		lb7.setBounds(180,20,400,30);
		lb8.setBounds(180,22,400,30);
		lb9.setBounds(180,24,400,30);

		/*lb10.setBounds(550,50,100,30);
		tf6.setBounds(550,75,100,30);
		java.util.Date d=new java.util.Date();
		tf6.setText(d.getDate()+"-"+(d.getMonth()+1)+"-"+"20"+(d.getYear()-100));
		tf6.setEnabled(false);*/

		lb1.setBounds(50,100,150,30);
		tf1.setBounds(200,100,100,30);
		b1.setBounds(310,100,80,30);
		b6.setBounds(400,100,80,30);

		lb2.setBounds(50,180,100,30);
		tf2.setBounds(200,180,100,30);
		lb3.setBounds(300,180,100,30);

		lb4.setBounds(50,260,100,30);
		tf3.setBounds(200,260,320,50);
		lb12.setBounds(530,260,100,30);
		lb5.setBounds(50,370,200,30);
		tf4.setBounds(200,370,100,30);
		r1.setBounds(620,260,100,30);    
		r2.setBounds(620,300,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);    
		//f.add(r1);f.add(r2);      

		lb6.setBounds(50,450,100,30);
		tf5.setBounds(200,450,100,30);

		b2.setBounds(50,520,100,30);
		b3.setBounds(170,520,100,30);
		b4.setBounds(290,520,100,30);
		b5.setBounds(530,520,100,30);
		b7.setBounds(410,520,100,30);

		ImageIcon img=new ImageIcon("ball.jpg");
		lb11=new JLabel("",img,JLabel.CENTER);
		lb11.setBounds(0,0,800,800);
		
		

		add(lb1); add(lb2); add(lb3); add(lb4); add(lb5); add(lb6); add(lb7); add(lb8); add(lb9); add(lb10); add(lb11); add(lb12);
		add(tf1); add(tf2); add(tf3); add(tf4); add(tf5); add(tf6);
		add(b1); add(b2); add(b3); add(b4); add(b5); add(b6); add(b7);
		add(r1); add(r2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);

		setVisible(true);
		setTitle("Maintenance");
		setBounds(0,0,1366,768);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)	//show
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from maintenance where MaintenanceNumber="+a+" ");
				rs.next();
				tf2.setText(rs.getString(2)+"");
				tf3.setText(rs.getString(3)+"");
				tf4.setText(rs.getString(4)+"");
				tf5.setText(rs.getInt(5)+"");
				tf6.setText(rs.getString(6)+"");
			}

			catch(Exception e)
			{
				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Record Not Found!!");
			}
		}

		if(ae.getSource()==b6)		//set
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select max(MaintenanceNumber) from maintenance");
				
				rs.next();
				int x=rs.getInt(1)+1;
				tf1.setText(x+"");
				tf1.setEnabled(false);
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{

			}
		}
		if(ae.getSource()==b2)	//insert
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());	//MainNum
				String b="'"+tf2.getText()+"'";			//Date
				String c="'"+tf3.getText()+"'";			//Descp
				String d="'"+tf4.getText()+"'";			//PerRes
				int e=Integer.parseInt(tf5.getText());	//Amt
				String f="'"+tf6.getText()+"'";			//cdate

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				st.executeUpdate("insert into maintenance values("+a+","+b+","+c+","+d+","+e+","+f+")");
				st.close();
				con.close(); 
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Inserted!!");
			}
			catch(Exception e)
			{
				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Record Not Found!!");
			}
		}
		if(ae.getSource()==b3)	//update
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int a=Integer.parseInt(tf1.getText());	
				String b="'"+tf2.getText()+"'";			
				String c="'"+tf3.getText()+"'";			
				String d="'"+tf4.getText()+"'";			
				int e=Integer.parseInt(tf5.getText());
				String f="'"+tf6.getText()+"'";

				st.executeUpdate("update maintenance set Date="+b+", Description="+c+", PersonRes="+d+", Amount="+e+",CDate="+f+" where MaintenanceNumber="+a+" ");		
				st.close();
				con.close();
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Updated!!");				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b4)	//delete
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int x=Integer.parseInt(tf1.getText());	
				st.executeUpdate("delete from maintenance where MaintenanceNumber="+x+" ");
				st.close();
				con.close();
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Record Deleted!!");
			}
			catch(Exception e)
			{

			}
		}
		if(ae.getSource()==b7)	//clear
		{
			try
			{
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Cleared!!");
			}
			catch(Exception e)
			{

			}
		}
		if(ae.getSource()==b5)	//home
		{
			try
			{
				setVisible(false);
				new HomePg();
				
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
}
class Maintenance
{
	public static void main(String[] args) 
	{
		MaintenanceScr m=new MaintenanceScr();
	}
}