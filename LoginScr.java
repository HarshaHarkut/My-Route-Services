import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class Login extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField tf1,tf2;
	JButton b1,b2;

	public Login()
	{
		lb1=new JLabel("LOGIN  DETAILS");
		lb1.setForeground(Color.BLUE);
		lb1.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb2=new JLabel("Username");
		lb3=new JLabel("Password");
		lb4=new JLabel("****************");
		lb4.setForeground(Color.BLUE);
		lb4.setFont(new Font("Comic Sans MS",Font.BOLD,22));

		tf1=new JTextField();
		tf2=new JPasswordField();
		b1=new JButton("Login");
		b2=new JButton("Cancle");

		setLayout(null);
		lb1.setBounds(120,100,300,30);
		lb4.setBounds(120,120,250,30);
		lb2.setBounds(50,200,100,30);
		tf1.setBounds(150,200,200,30);
		lb3.setBounds(50,300,100,30);
		tf2.setBounds(150,300,150,30);
		b1.setBounds(50,400,100,30);
		b2.setBounds(170,400,100,30);

		b1.addActionListener(this);
		b2.addActionListener(this);

		ImageIcon img=new ImageIcon("LogInPic1.jpg");
		lb6=new JLabel("",img,JLabel.CENTER);
		lb6.setBounds(500,100,600,450);

		add(lb1); add(lb2); add(lb3); add(lb4); add(lb6);
		add(tf1); add(tf2);
		add(b1); add(b2);

		setVisible(true);
		setBounds(0,0,1366,768);
		setTitle("Login Screen");

		
	}
	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==b1)
	{
		String a=tf1.getText();
		String b=tf2.getText();

		try 
		{
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			System.out.println("3");
			Statement st=con.createStatement();
			System.out.println("4");
			ResultSet rs=st.executeQuery("select * from login");
			System.out.println("5");
			int flag=0;
			System.out.println("6");
			while(rs.next())
			{
				String x=rs.getString(1);
				String y=rs.getString(2);
				if(x.equals(a) && y.equals(b))
				{
					flag=1;
					break;
				}
			}
			JFrame f=new JFrame();
				if (flag==1)
				{
					JOptionPane.showMessageDialog(f,"Login Successful!!");
					new HomePg();
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(f,"Login Failed!!");				
				}
				rs.close();
				con.close();
				st.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

		if(ae.getSource()==b2)

		{
			System.exit(0);
		}
	}
}
class LoginScr
{
	public static void main(String[] args) 
	{
		Login l=new Login();
	}
}