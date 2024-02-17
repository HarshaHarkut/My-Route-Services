import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
class Salary extends JFrame implements ActionListener
{
	
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	public Salary()
	{
		setLayout(null);
		lb1=new JLabel("EmpID");
		lb2=new JLabel("EmpName");
		lb3=new JLabel("CurrentDate");
		lb4=new JLabel("(DD-MM-YYYY)");
		lb5=new JLabel("Month");
        lb6=new JLabel("(MM-YYYY)");
		lb7=new JLabel("WorkedDays");
		lb8=new JLabel("SalaryPerDay");
		lb9=new JLabel("TotalAmt");
		lb10=new JLabel("***SALARY  DETAILS***");
		lb11=new JLabel("____________________");
		lb12=new JLabel("____________________");
		lb10.setForeground(Color.BLUE);
		lb11.setForeground(Color.BLUE);
		lb12.setForeground(Color.BLUE);
		lb10.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb11.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb12.setFont(new Font("Comic Sans MS",Font.BOLD,22));


		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		tf7=new JTextField();
		
		b1=new JButton("Add");
		b2=new JButton("Insert");
		b3=new JButton("Update");
		b4=new JButton("Delete");
		b5=new JButton("Home");
		b6=new JButton("Compute");
		b7=new JButton("Show");
		b8=new JButton("Clear");

		lb10.setBounds(180,20,500,30);
		lb11.setBounds(180,22,500,30);
		lb12.setBounds(180,24,500,30);

		lb1.setBounds(50,100,100,30);
		tf1.setBounds(150,100,100,30);
		b1.setBounds(260,100,80,30);		//add

		lb2.setBounds(50,180,100,30);
		tf2.setBounds(150,180,160,30);		//empName
		b7.setBounds(320,180,80,30);		//show

		lb3.setBounds(50,260,100,30);
		tf3.setBounds(150,260,100,30);
		lb4.setBounds(255,260,100,30);

		lb5.setBounds(370,260,100,30);
		tf4.setBounds(410,260,100,30);
		lb6.setBounds(510,260,100,30);

		lb7.setBounds(50,330,100,30);
		tf5.setBounds(150,330,100,30);

		lb8.setBounds(50,410,100,30);
		tf6.setBounds(150,410,100,30);
		b6.setBounds(260,410,100,30);		//compute

		lb9.setBounds(50,490,100,30);
        tf7.setBounds(150,490,100,30);
        
		b2.setBounds(50,570,100,30);		//insert
		b3.setBounds(170,570,100,30);		//update
		b4.setBounds(290,570,100,30);		//delete
		b8.setBounds(410,570,100,30);		//clear
		b5.setBounds(530,570,100,30);		//home


	

		add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);add(lb7); add(lb8); add(lb9); add(lb10); add(lb11); add(lb12);
		add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);add(tf6);add(tf7);
		add(b1);add(b2);add(b3);add(b4);add(b5);add(b6); add(b7); add(b8);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);

		tf2.setEnabled(false);
		tf7.setEnabled(false);


		setTitle("Employee Salary");
		setVisible(true);
		setBounds(0,0,1366,768);
		java.util.Date d=new java.util.Date();
		
		tf3.setText(d.getDate()+"-"+(d.getMonth()+1)+"-"+"20"+(d.getYear()-100));
		tf3.setEnabled(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)	//add
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select FirstName, LastName from employeedetails where EmpID="+a+" ");
				rs.next();
				tf2.setText(rs.getString(1)+"" +rs.getString(2)+"");
			}
			catch(Exception e)
			{

			}
		}
		if(ae.getSource()==b7)	//show
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from employeesalary where EmpID="+a+" ");
				rs.next();
				tf2.setText(rs.getString(2)+"");
				tf3.setText(rs.getString(3)+"");
				tf4.setText(rs.getString(4)+"");
				tf5.setText(rs.getInt(5)+"");
				tf6.setText(rs.getInt(6)+"");
				tf7.setText(rs.getInt(7)+"");
			}
			catch(Exception e)
			{
				System.out.println(e);
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Not Found!!");			
			}
		}
		if(ae.getSource()==b2)	//insert
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());		//id
				String b="'"+tf2.getText()+"'";				//name
				String c="'"+tf3.getText()+"'";				//date
				String d="'"+tf4.getText()+"'";				//month
				int e=Integer.parseInt(tf5.getText());		//days
				int f=Integer.parseInt(tf6.getText());		//sal
				int g=Integer.parseInt(tf7.getText());		//amt

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				st.executeUpdate("insert into employeesalary values ("+a+","+b+","+c+","+d+","+e+","+f+","+g+")");
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
				int a=Integer.parseInt(tf1.getText());
				String b="'"+tf2.getText()+"'";				//name
				String c="'"+tf3.getText()+"'";				//date
				String d="'"+tf4.getText()+"'";				//month
				int e=Integer.parseInt(tf5.getText());		//days
				int f=Integer.parseInt(tf6.getText());		//sal
				int g=Integer.parseInt(tf7.getText());		//amt

				st.executeUpdate("update employeesalary set EmpName="+b+",CurrentDate="+c+",Month="+d+",WorkedDays="+e+",SalaryPerDay="+f+",TotalAmt="+g+" where EmpID="+a+"");
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
				st.executeUpdate("delete from employeesalary where EmpID="+x+" ");
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
		if(ae.getSource()==b8)	//clear
		{
			try
			{
				tf1.setText("");
				tf2.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
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
				new HomePg();
				setVisible(false);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b6)	//compute
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int a=Integer.parseInt(tf5.getText());
				int b=Integer.parseInt(tf6.getText());

				int c=a*b;
				tf7.setText(c+"");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
class EmpSalary
{
	public static void main(String[] args) 
	{
		Salary s=new Salary();
	}
}