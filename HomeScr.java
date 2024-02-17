import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class HomePg extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu mnu1,mnu2,mnu3,mnu4,mnu5,mnu6;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11;
	JLabel lb1;
	public HomePg()
	{
	
		mb=new JMenuBar();
		mnu1=new JMenu("Maintenance");
		mnu2=new JMenu("Employee");
		mnu3=new JMenu("Vehicle");
		mnu4=new JMenu("Booking");
		mnu5=new JMenu("Reports");
		mnu6=new JMenu("Packages");

		mi1=new JMenuItem("Maintenance Bill");
		mi2=new JMenuItem("Employee Details");
		mi3=new JMenuItem("Employee Salary");
		mi4=new JMenuItem("Vehicle Details");
		mi5=new JMenuItem("Booking Details");
		mi6=new JMenuItem("MaintenanceReport");
		mi7=new JMenuItem("EmployeeReport");
		mi8=new JMenuItem("SalaryReport");
		mi9=new JMenuItem("VehicleReport");
		mi10=new JMenuItem("BookingReport");
		mi11=new JMenuItem("Packages Details");

		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		mi10.addActionListener(this);
		mi11.addActionListener(this);

		ImageIcon img=new ImageIcon("HomePgPic.jpg");
		lb1=new JLabel("",img,JLabel.CENTER);
		lb1.setBounds(0,0,600,450);

		mnu1.add(mi1); mnu2.add(mi2); mnu2.add(mi3); mnu3.add(mi4); mnu6.add(mi11);	mnu4.add(mi5); mnu5.add(mi6); mnu5.add(mi7); mnu5.add(mi8); mnu5.add(mi9); mnu5.add(mi10); 
		mb.add(mnu1); mb.add(mnu2); mb.add(mnu3);mb.add(mnu6); mb.add(mnu4); mb.add(mnu5);
		setJMenuBar(mb);
		add(lb1); 

		setTitle("Home Screen");
		setVisible(true);
		setBounds(0,0,1366,768);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==mi1)
		{
			new MaintenanceScr();
			setVisible(false);
		}

		if(ae.getSource()==mi2)
		{
			new Employee();
			setVisible(false);
		}
		
		if(ae.getSource()==mi3)
		{
			new Salary();
			setVisible(false);
		}
		
		if(ae.getSource()==mi4)
		{
			new VehicleDetails();
			setVisible(false);
		}
		
		if(ae.getSource()==mi11)
		{
			new PackageDetails();
			setVisible(false);
		}
		
		if(ae.getSource()==mi5)
		{
			new Booking();
			setVisible(false);
		}
		
		if(ae.getSource()==mi6)
		{
			new mpreport();
			setVisible(false);
		}
		
		if(ae.getSource()==mi7)
		{
			new EmpDetRp();
			setVisible(false);
		}
		
		if(ae.getSource()==mi8)
		{
			new EmpSalRp();
			setVisible(false);
		}
		
		if(ae.getSource()==mi9)
		{
			new VehicleRp();
			setVisible(false);
		}
		
		if(ae.getSource()==mi10)
		{
			new BookingRp();
			setVisible(false);
		}
	
		if(ae.getSource()==mi11)
		{
			new Package();
			setVisible(false);
		}
	}
	

}

class HomeScr
{
	public static void main(String[] args) 
	{
		HomeScr h=new HomeScr();

	}
}