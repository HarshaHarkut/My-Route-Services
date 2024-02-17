import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
class VehicleDetails extends JFrame implements ActionListener
{
	 JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	 JTextField tf1,tf2,tf3,tf4;
	 JButton b1,b2,b3,b4,b5,b6;

	 
	// String data

	 //JTable t=new JTable(data,col);
	 public VehicleDetails()
	 {
	 	setLayout(null);
	 	lb1=new JLabel("ID");
		lb2=new JLabel("Name");
		lb3=new JLabel("Number");
		lb4=new JLabel("Seater");
		lb5=new JLabel("***Vehicle  DETAILS***");
		lb6=new JLabel("____________________");
		lb7=new JLabel("____________________");
		lb5.setForeground(Color.BLUE);
		lb6.setForeground(Color.BLUE);
		lb7.setForeground(Color.BLUE);
		lb5.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb6.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb7.setFont(new Font("Comic Sans MS",Font.BOLD,22));

		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();

		b1=new JButton("Insert");
		b2=new JButton("Update");
		b3=new JButton("Delete");
		b4=new JButton("Show");
		b5=new JButton("Home");
		b6=new JButton("Set");


		lb5.setBounds(180,20,300,30);
		lb6.setBounds(180,22,300,30);
		lb7.setBounds(180,24,300,30);

		lb1.setBounds(50,100,100,30);
		tf1.setBounds(150,100,100,30);
		b4.setBounds(270,100,80,30);
		b6.setBounds(370,100,80,30);

		lb2.setBounds(50,180,100,30);
		tf2.setBounds(150,180,100,30);

		lb3.setBounds(50,260,100,30);
		tf3.setBounds(150,260,100,30);

		lb4.setBounds(50,340,100,30);
		tf4.setBounds(150,340,100,30);

		b1.setBounds(50,420,100,30);
		b2.setBounds(170,420,100,30);
		b3.setBounds(290,420,100,30);
		b5.setBounds(410,420,100,30);

		add(lb1); add(lb2); add(lb3); add(lb4); add(lb5); add(lb6); add(lb7);
		add(tf1); add(tf2); add(tf3); add(tf4);
		add(b1); add(b2); add(b3); add(b4); add(b5); add(b6);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);


		setTitle("Employee Salary");
		setVisible(true);
		setBounds(0,0,1366,768);
	 }
	 public void actionPerformed(ActionEvent ae)
	 {
	 	if(ae.getSource()==b4)	//show
	 	{
	 		try
	 		{
	 			int a=Integer.parseInt(tf1.getText());
	 			Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from vehicle where ID="+a+"");
				rs.next();
				tf2.setText(rs.getString(2)+"");
				tf3.setText(rs.getString(3)+"");
				tf4.setText(rs.getInt(4)+"");
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Not Found!!");	
	 		}
	 	}
	 	if(ae.getSource()==b6)		//set
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select max(ID) from vehicle");
				
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
					System.out.println(e);
				}
			}
	 	if(ae.getSource()==b1)	//insert
	 	{
	 		try
	 		{
	 			int a=Integer.parseInt(tf1.getText());		//id
				String b="'"+tf2.getText()+"'";				//name
				String c="'"+tf3.getText()+"'";				//number
				int d=Integer.parseInt(tf4.getText());		//seat

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				st.executeUpdate ("insert into vehicle values("+a+","+b+","+c+","+d+")");

				st.close();
				con.close(); 

				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Inserted");

	 		}
	 		catch(Exception e)
	 		{

	 		}
	 	}
	 	if(ae.getSource()==b2)	//update
	 	{
	 		try
	 		{
	 			Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int a=Integer.parseInt(tf1.getText());		//id
				String b="'"+tf2.getText()+"'";				//name
				String c="'"+tf3.getText()+"'";				//number
				int d=Integer.parseInt(tf4.getText());		//seat

				st.executeUpdate("update vehicle set Name="+b+",Number="+c+",Seater="+d+" where ID="+a+"");
				st.close();
				con.close();
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Updated!!");
	 		}
	 		catch(Exception e)
	 		{

	 		}
	 	}
	 	if(ae.getSource()==b3)	//delete
	 	{
	 		try
	 		{
	 			Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int x=Integer.parseInt(tf1.getText());	
				st.executeUpdate("delete from vehicle where ID="+x+" ");
				st.close();
				con.close();
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Deleted!!");
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

	 		}
	 	}
	 }

}
class Vehicle
{
	public static void main(String[] args) 
	{
		VehicleDetails vd=new VehicleDetails();
	}
}