import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

class Package extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JRadioButton rb1,rb2; 
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12;
	JButton b1,b2,b3;
	
	public Package()
	{
		setLayout(null);
		lb1=new JLabel("***PACKAGE  DETAILS***");
		lb2=new JLabel("==>2/3 Days");
		lb3=new JLabel("==>5 Days");
		lb4=new JLabel("==>7 Days");
		lb5=new JLabel("==>More than 7 Days");
		lb6=new JLabel("____________________");
		lb7=new JLabel("____________________");
		b1=new JButton("Select");
		b2=new JButton("Clear");
		b3=new JButton("Home");
		
		lb1.setForeground(Color.BLUE);
		lb6.setForeground(Color.BLUE);
		lb7.setForeground(Color.BLUE);
		lb1.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb6.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		lb7.setFont(new Font("Comic Sans MS",Font.BOLD,22));
		
		
		lb1.setBounds(500,20,300,50);
		lb6.setBounds(500,30,400,30);
		lb7.setBounds(500,34,400,30);
		
		lb2.setBounds(300, 100, 250, 50);
		
		lb3.setBounds(600, 100, 250, 50);
		
		lb4.setBounds(300, 350 , 250, 50);
		
		lb5.setBounds(600, 350, 250, 50);
		
		b1.setBounds(300, 630, 100, 30);
		b2.setBounds(430, 630, 100, 30);
		b3.setBounds(560, 630, 100, 30);
		
		
		rb1=new JRadioButton("Breakfast");
		rb2=new JRadioButton("HighTea");
		
		rb1.setBounds(350,150,100,30);    
		rb2.setBounds(350,180,100,30);
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);bg.add(rb2);   
		
		
		cb1= new JCheckBox("Breakfast");  
		cb2= new JCheckBox("Lunch");  
		cb3= new JCheckBox("HighTea");  
		
		cb1.setBounds(640,150,100,30);  
		cb2.setBounds(640,180,100,30);  
		cb3.setBounds(640,210,100,30);
		
		cb4= new JCheckBox("Breakfast"); 
		cb5= new JCheckBox("Lunch"); 
		cb6= new JCheckBox("HighTea"); 
		cb7= new JCheckBox("Dinner");
		
		cb4.setBounds(350,400,100,30);
		cb5.setBounds(350,430,100,30);
		cb6.setBounds(350,460,100,30);
		cb7.setBounds(350,490,100,30);
		
		cb8= new JCheckBox("Breakfast");
		cb9= new JCheckBox("Lunch");
		cb10= new JCheckBox("HighTea");
		cb11= new JCheckBox("Dinner");
		cb12= new JCheckBox("Need Cook With You	? (Extra Charges For His/Her Maintanance)");
		
		cb8.setBounds(640,400,100,30);	
		cb9.setBounds(640,430,100,30);	
		cb10.setBounds(640,460,100,30);	
		cb11.setBounds(640,490,100,30);	
		cb12.setBounds(640,520,400,30);	

		
		
		add(lb1); add(lb2); add(lb3); add(lb4); add(lb5); add(lb6); add(lb7);
		add(b1); add(b2); add(b3);
		add(rb1); add(rb2);
		add(cb1); add(cb2); add(cb3); add(cb4); add(cb5); add(cb6); add(cb7); add(cb8); add(cb9); add(cb10); add(cb11); add(cb12); 


		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		
		setVisible(true);
		setTitle("Package Details");
		setBounds(0,0,1366,768);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b3)	//home
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
		
		if(ae.getSource()==b1)	//select
		{
			String msg="";  
	        if(cb1.isSelected())
	        {  
	            msg="Breakfast\n";  
	        }  
	        if(cb2.isSelected())
	        {  
	        	msg+="Lunch\n";  
	        }  
	        if(cb3.isSelected())
	        {  
	            msg+="HighTea\n";  
	        }  
	        if(cb4.isSelected())
	        {  
	            msg="Breakfast\n";  
	        }  
	        if(cb5.isSelected())
	        {  
	        	msg+="Lunch\n";  
	        }  
	        if(cb6.isSelected())
	        {  
	            msg+="HighTea\n";  
	        }  
	        if(cb7.isSelected())
	        {  
	            msg="Dinner\n";  
	        }  
	        if(cb8.isSelected())
	        {  
	        	msg+="Breakfast\n";  
	        }  
	        if(cb9.isSelected())
	        {  
	            msg+="Lunch\n";  
	        }  
	        if(cb10.isSelected())
	        {  
	            msg="HighTea\n";  
	        }  
	        if(cb11.isSelected())
	        {  
	        	msg+="Dinner\n";  
	        }  
	        if(cb12.isSelected())
	        {  
	            msg+="Cook With You\n";  
	        }  
	        JOptionPane.showMessageDialog(this,"You have Selected\n"+"\t"+msg);
		}
		
		if(ae.getSource()==b2)		//clear
		{
			cb1.setSelected(false);
			cb2.setSelected(false);
			cb3.setSelected(false);
			cb4.setSelected(false);
			cb5.setSelected(false);
			cb6.setSelected(false);
			cb7.setSelected(false);
			cb8.setSelected(false);
			cb9.setSelected(false);
			cb10.setSelected(false);
			cb11.setSelected(false);
			cb12.setSelected(false);
			JFrame jf=new JFrame();
			JOptionPane.showMessageDialog(jf,"Cleared!!");
		}
		
	}
	

}

class PackageDetails 
{
	public static void main(String[] args) 
	{
		Package p =new Package();
	}
}
