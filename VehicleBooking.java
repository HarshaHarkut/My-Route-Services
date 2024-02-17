import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

class Booking extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;

	public Booking()
	{
		setLayout(null);
		lb6=new JLabel("Book ID");
	 	lb1=new JLabel("Vehical ID");
		lb2=new JLabel("Date");
		lb3=new JLabel("Vehical Name");
		lb4=new JLabel("Number");
		lb5=new JLabel("Seater");
		lb7=new JLabel("Date");
		lb8=new JLabel("(DD-MM-YYYY)");
		lb9=new JLabel("PricePerKM");
		lb10=new JLabel("Source");
		lb11=new JLabel("> > > > > >");
		lb12=new JLabel("Destination");
		lb13=new JLabel("Distance");
		lb14=new JLabel("Amount");
		lb15=new JLabel("***Booking Details***");
		lb16=new JLabel("_________________");
		lb17=new JLabel("_________________");
		lb18=new JLabel("Cust Name");
		lb19=new JLabel("Contact");
		lb15.setForeground(Color.BLUE);
		lb16.setForeground(Color.BLUE);
		lb17.setForeground(Color.BLUE);
		lb15.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb16.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb17.setFont(new Font("Comic Sans MS",Font.BOLD,22));

		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();	//bid
		tf7=new JTextField();
		tf8=new JTextField();
		tf9=new JTextField();
		tf10=new JTextField();
		tf11=new JTextField();
		tf12=new JTextField();
		tf13=new JTextField();
		tf14=new JTextField();


		b1=new JButton("Add");
		b2=new JButton("Set");
		b3=new JButton("Compute");
		b4=new JButton("Book");
		b5=new JButton("Update");
		b6=new JButton("Delete");
		b7=new JButton("Clear");
		b8=new JButton("Home");
		b9=new JButton("Show");


		lb15.setBounds(240,20,300,30);
		lb16.setBounds(240,22,300,30);
		lb17.setBounds(240,24,300,30);

		lb6.setBounds(50,100,100,30);
		tf6.setBounds(150,100,100,30);
		b2.setBounds(270,100,80,30);
		b9.setBounds(370,100,80,30);

		lb1.setBounds(50,160,100,30);
		tf1.setBounds(150,160,100,30);
		b1.setBounds(270,160,100,30);
		lb2.setBounds(550,50,100,30);
		tf2.setBounds(550,75,100,30);
		java.util.Date d=new java.util.Date();
		tf2.setText(d.getDate()+"-"+(d.getMonth()+1)+"-"+"20"+(d.getYear()-100));
		tf2.setEnabled(false);
		
		

		lb3.setBounds(50,220,100,30);
		tf3.setBounds(150,220,100,30);
		lb4.setBounds(270,220,100,30);
		tf4.setBounds(340,220,100,30);
		lb5.setBounds(470,220,100,30);
		tf5.setBounds(540,220,100,30);
		
		lb18.setBounds(50, 280, 100, 30);
		tf13.setBounds(150,280, 300, 30);
		
		lb19.setBounds(470, 280, 100, 30);
		tf14.setBounds(540,280,200,30);

		lb7.setBounds(50,340,100,30);
		tf7.setBounds(150,340,100,30);
		lb8.setBounds(260,210,100,300);

		lb9.setBounds(50,400,100,30);
		tf8.setBounds(150,400,100,30);

		lb10.setBounds(50,460,100,30);
		tf9.setBounds(150,460,100,30);
		lb11.setBounds(280,460,100,30);
		lb12.setBounds(370,460,100,30);
		tf10.setBounds(470,460,100,30);

		lb13.setBounds(50,520,100,30);
		tf11.setBounds(150,520,100,30);
		b3.setBounds(270,520,100,30);

		lb14.setBounds(50,580,100,30);
		tf12.setBounds(150,580,100,30);

		b4.setBounds(10,650,100,30);
		b5.setBounds(130,650,100,30);
		b6.setBounds(250,650,100,30);
		b7.setBounds(370,650,100,30);
		b8.setBounds(490,650,100,30);


		add(lb1); add(lb2); add(lb3); add(lb4); add(lb5); add(lb6); add(lb7); add(lb8); add(lb9); add(lb10); add(lb11); add(lb12); add(lb13); add(lb14); add(lb15); add(lb16); add(lb17); add(lb18); add(lb19);
		add(tf1); add(tf2); add(tf3); add(tf4); add(tf5); add(tf6); add(tf7); add(tf8); add(tf9); add(tf10); add(tf11); add(tf12); add(tf13); add(tf14);
		add(b1); add(b2); add(b3); add(b4); add(b5); add(b6);add(b7); add(b8); add(b9);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		tf3.setEnabled(false);
		tf4.setEnabled(false);
		tf5.setEnabled(false);
		setTitle("Booking Details");
		setVisible(true);
		setBounds(0,0,1366,768);
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
				ResultSet rs=st.executeQuery("select * from vehicle where ID="+a+" ");
				rs.next();
				tf3.setText(rs.getString(2)+"");
				tf4.setText(rs.getString(3)+"");
				tf5.setText(rs.getInt(4)+"");
			}
			catch(Exception e)
			{
				System.out.print(e);
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Not Found!!");
			}
		}

		if(ae.getSource()==b9)		//show
		{
			try
			{
				int z=Integer.parseInt(tf6.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from vehiclebooking where BID="+z+" ");
				rs.next();
				tf2.setText(rs.getString(3)+"");	//cdate
				tf1.setText(rs.getInt(2)+"");		//id
				tf3.setText(rs.getString(4)+"");	//name
				tf4.setText(rs.getString(5)+"");	//num
				tf5.setText(rs.getInt(6)+"");		//seat
				//tf13.setText(rs.)
				tf7.setText(rs.getString(7)+"");	//date
				tf8.setText(rs.getInt(8)+"");		//km
				tf9.setText(rs.getString(9)+"");	//source
				tf10.setText(rs.getString(10)+"");	//desti
				tf11.setText(rs.getInt(11)+"");		//dis
				tf12.setText(rs.getInt(12)+"");		//amt
			}
			catch(Exception e)
			{
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Not Found!!");
			}
		}
		if(ae.getSource()==b2)		//set
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select max(BID) from vehiclebooking");
				
				rs.next();
				int x=rs.getInt(1)+1;
				tf6.setText(x+"");
				tf6.setEnabled(false);
				rs.close();
				st.close();
				con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
		if(ae.getSource()==b3)		//Compute
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int a=Integer.parseInt(tf8.getText());
				int b=Integer.parseInt(tf11.getText());

				int c=a*b;
				tf12.setText(c+"");
			}
			catch(Exception e)
			{

			}
		}

		if(ae.getSource()==b4)		//book
		{
			try
			{
				int z=Integer.parseInt(tf6.getText());		//bid
				int a=Integer.parseInt(tf1.getText());		//id
				String b="'"+tf2.getText()+"'";				//cdate
				String c="'"+tf3.getText()+"'";				//name
				String d="'"+tf4.getText()+"'";				//num
				int e=Integer.parseInt(tf5.getText());		//Seat
				
				String f="'"+tf7.getText()+"'";				//date
				int g=Integer.parseInt(tf8.getText());		//km
				String h="'"+tf9.getText()+"'";				//source
				String i="'"+tf10.getText()+"'";			//desti
				int j=Integer.parseInt(tf11.getText());		//dis
				int k=Integer.parseInt(tf12.getText());		//amt

				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();

				st.executeUpdate("insert into vehiclebooking values ("+z+","+a+","+b+","+c+","+d+","+e+","+f+","+g+","+h+","+i+","+j+","+k+")");

				st.close();
				con.close(); 
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Inserted!!");

			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}

		if(ae.getSource()==b5)		//update
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int z=Integer.parseInt(tf6.getText());

				int a=Integer.parseInt(tf1.getText());		//id
				String b="'"+tf2.getText()+"'";				//cdate
				String c="'"+tf3.getText()+"'";				//name
				String d="'"+tf4.getText()+"'";				//num
				int e=Integer.parseInt(tf5.getText());		//Seat
				String f="'"+tf7.getText()+"'";				//date
				int g=Integer.parseInt(tf8.getText());		//km
				String h="'"+tf9.getText()+"'";				//source
				String i="'"+tf10.getText()+"'";			//desti
				int j=Integer.parseInt(tf11.getText());		//dis
				int k=Integer.parseInt(tf12.getText());		//amt

				st.executeUpdate("update vehiclebooking set ID="+a+",CDate="+b+",Name="+c+",Number="+d+",Seater="+e+",Date="+f+",PricePerKM="+g+",Source="+h+",Destination="+i+",Distance="+j+",Amount="+k+" where BID="+z+"");
				st.close();
				con.close();
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Updated!!");
			}
			catch(Exception e)
			{

			}
		}

		if(ae.getSource()==b6)		//delete
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
				Statement st=con.createStatement();
				int z=Integer.parseInt(tf6.getText());	
				st.executeUpdate("delete from vehiclebooking where BID="+z+" ");
				st.close();
				con.close();
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				tf9.setText("");
				tf10.setText("");
				tf11.setText("");
				tf12.setText("");
				
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Record Deleted!!");
			}
			catch(Exception e)
			{

			}
		}

		if(ae.getSource()==b7)		//clear
		{
			try
			{
				tf1.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				tf9.setText("");
				tf10.setText("");
				tf11.setText("");
				tf12.setText("");
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"Cleared!!");

			}
			catch(Exception e)
			{

			}
		}

		if(ae.getSource()==b8)		//home
		{
			new HomePg();
			setVisible(false);
		}
	}
}

class VehicleBooking
{
	public static void main(String[] args) 
	{
		Booking b=new Booking();
	}
}
