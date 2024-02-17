import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
class Employee extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton b1,b2,b3,b4,b5,b6,b7;

	public Employee()
	{
		setLayout(null);

		lb1=new JLabel("EmpID");
		lb2=new JLabel("FirstName");
		lb3=new JLabel("LastName");
		lb4=new JLabel("ContactNo");
		lb5=new JLabel("Address");
		lb6=new JLabel("MailID");
		lb7=new JLabel("DrivingExperience");
		lb8=new JLabel("***EMPLOYEE  DETAILS***");
		lb9=new JLabel("______________________");
		lb10=new JLabel("______________________");
		lb8.setForeground(Color.BLUE);
		lb9.setForeground(Color.BLUE);
		lb10.setForeground(Color.BLUE);
		lb9.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb8.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb10.setFont(new Font("Comic Sans MS",Font.BOLD,22));


		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		tf7=new JTextField();

		b1=new JButton("Show");
		b2=new JButton("Insert");
		b3=new JButton("Update");
		b4=new JButton("Delete");
		b5=new JButton("Clear");
		b6=new JButton("Home");
		b7=new JButton("Set");


		lb8.setBounds(180,20,500,30);
		lb9.setBounds(180,22,500,30);
		lb10.setBounds(180,24,500,30);

		/*lb11.setBounds(550,50,100,30);
		tf8.setBounds(550,75,100,30);
		java.util.Date d=new java.util.Date();
		tf8.setText(d.getDate()+"-"+(d.getMonth()+1)+"-"+"20"+(d.getYear()-100));
		tf8.setEnabled(false);*/

		lb1.setBounds(50,100,100,30);
		tf1.setBounds(170,100,100,30);
		b1.setBounds(290,100,80,30);
		b7.setBounds(390,100,80,30);

		lb2.setBounds(50,180,150,30);
		tf2.setBounds(170,180,100,30);
		lb3.setBounds(300,180,150,30);
		tf3.setBounds(380,180,100,30);

		lb4.setBounds(50,260,150,30);
		tf4.setBounds(170,260,100,30);

		lb5.setBounds(50,330,150,30);
		tf5.setBounds(170,330,320,50);

		lb6.setBounds(50,410,100,30);
		tf6.setBounds(170,410,150,30);

		lb7.setBounds(50,490,200,30);
		tf7.setBounds(170,490,100,30);

		b2.setBounds(20,570,100,30);
		b3.setBounds(140,570,100,30);
		b4.setBounds(260,570,100,30);
		b5.setBounds(380,570,100,30);
		b6.setBounds(500,570,100,30);


		add(tf1); add(tf2); add(tf3); add(tf4); add(tf5); add(tf6); add(tf7);
		add(lb1); add(lb2); add(lb3); add(lb4); add(lb5); add(lb6); add(lb7); add(lb8); add(lb9); add(lb10);
		add(b1); add(b2); add(b3); add(b4); add(b5); add(b6); add(b7);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);


		setTitle("Employee Details");
		setVisible(true);
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
				ResultSet rs=st.executeQuery("select * from employeedetails where EmpID="+a+" ");
				rs.next();
				tf2.setText(rs.getString(2)+"");
				tf3.setText(rs.getString(3)+"");
				tf4.setText(rs.getString(4)+"");
				tf5.setText(rs.getString(5)+"");
				tf6.setText(rs.getString(6)+"");
				tf7.setText(rs.getInt(7)+"");

			}
			catch(Exception e)
			{
				System.out.println(e);
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Not Found!!");
			}
		}
		if(ae.getSource()==b7)		//set
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select max(EmpID) from employeedetails");
				
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
				int a=Integer.parseInt(tf1.getText());	//Empid
				String b="'"+tf2.getText()+"'";			//Firstname
				String c="'"+tf3.getText()+"'";			//LastName
				String d="'"+tf4.getText()+"'";			//Contact
				String e="'"+tf5.getText()+"'";			//Address
				String f="'"+tf6.getText()+"'";			//Mail
				int g=Integer.parseInt(tf7.getText());	//driExp

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				st.executeUpdate("insert into employeedetails values("+a+","+b+","+c+","+d+","+e+","+f+","+g+")");
				st.close();
				con.close(); 
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Inserted!!");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b3)	//update
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int a=Integer.parseInt(tf1.getText());	//Empid
				String b="'"+tf2.getText()+"'";			//Firstname
				String c="'"+tf3.getText()+"'";			//LastName
				String d="'"+tf4.getText()+"'";			//Contact
				String e="'"+tf5.getText()+"'";			//Address
				String f="'"+tf6.getText()+"'";			//Mail
				int g=Integer.parseInt(tf7.getText());	//driExp
	
				st.executeUpdate("update employeedetails set FirstName="+b+", LastName="+c+", ContactNo="+d+", Address="+e+", MailID="+f+", DrivingExp="+g+" where EmpID="+a+"");
				st.close();
				con.close();
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Updated!!");
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		if(ae.getSource()==b4) 	//delete
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int x=Integer.parseInt(tf1.getText());	
				st.executeUpdate("delete from employeedetails where EmpID="+x+" ");
				st.close();
				con.close();
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Deleted!!");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b5)	//clear
		{
			try
			{
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Cleared!!");

			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		if(ae.getSource()==b6)	//home
		{
			try
			{
				new HomePg();
				setVisible(false);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
}
class EmpDetails
{
	public static void main(String[] args) 
	{
		Employee e=new Employee();
	}
}