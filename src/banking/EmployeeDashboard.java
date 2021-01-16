package banking;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class EmployeeDashboard implements ActionListener
{
	protected Database db = Database.getnewDB();
	protected JFrame empFrame;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8,field9,field10;
	private JLabel label1,label3,label4,label5,label6,label7;
	private JLabel label8,label9,label10,label11,label13,label14;
	private JButton custDetail,logbtn,passChangebtn;
	private ArrayList<String>list = new ArrayList<String>();
	
	EmployeeDashboard(String id)
	{
		empFrame = new JFrame();
		empFrame.getContentPane().setLayout(null);
		
		addLabelAndField();
		
		getDetails(id);
		
		addButton();
		
		empFrame.getContentPane().setBackground(new Color(245, 245, 245));
		empFrame.getContentPane().add(field10);
		empFrame.setSize(1048,659);
        empFrame.setLocation(300,80);
        empFrame.setVisible(true);
        
	}
	
	private void addLabelAndField()
	{
		label1 = new JLabel("ADMIN LOGS");
		label1.setForeground(new Color(0, 0, 255));
		label1.setBackground(new Color(255, 250, 250));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		label1.setBounds(45, 56, 325, 58);
		empFrame.getContentPane().add(label1);
		
		label3 = new JLabel("PERSONAL CREDENTIALS");
		label3.setForeground(new Color(255, 0, 0));
		label3.setFont(new Font("Times New Roman", Font.BOLD, 32));
		label3.setBounds(307, 163, 424, 58);
		empFrame.getContentPane().add(label3);
		
		label4 = new JLabel("NAME");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label4.setBounds(45, 249, 72, 31);
		empFrame.getContentPane().add(label4);
		
		label5 = new JLabel("DoB");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label5.setBounds(45, 293, 72, 31);
		empFrame.getContentPane().add(label5);
		
		label6 = new JLabel("GENDER");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label6.setBounds(45, 334, 103, 31);
		empFrame.getContentPane().add(label6);
		
		label7 = new JLabel("ADDRESS");
		label7.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label7.setBounds(45, 375, 103, 31);
		empFrame.getContentPane().add(label7);
		
		label8 = new JLabel("CITY");
		label8.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label8.setBounds(555, 334, 56, 31);
		empFrame.getContentPane().add(label8);
		
		label9 = new JLabel("STATE");
		label9.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label9.setBounds(555, 293, 72, 31);
		empFrame.getContentPane().add(label9);
		
		label10 = new JLabel("YOUR ID");
		label10.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label10.setBounds(457, 27, 122, 31);
		empFrame.getContentPane().add(label10);
		
		label11= new JLabel("PHONE");
		label11.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label11.setBounds(555, 249, 84, 31);
		empFrame.getContentPane().add(label11);

		label13 = new JLabel("PIN CODE");
		label13.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label13.setBounds(555, 375, 122, 31);
		empFrame.getContentPane().add(label13);
		
		label14 = new JLabel("YOUR SALARY");
		label14.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label14.setBounds(460, 99, 151, 31);
		empFrame.getContentPane().add(label14);
		
	}
	
	private void addButton() 
	{
		
		custDetail = new JButton("CUSTOMER INFO");
		custDetail.setForeground(new Color(255, 255, 255));
		custDetail.setBackground(new Color(0, 100, 0));
		custDetail.setFont(new Font("Times New Roman", Font.BOLD, 21));
		custDetail.setBounds(358, 482, 221, 37);
		empFrame.getContentPane().add(custDetail);
		
		passChangebtn = new JButton("PASSWORD");
		passChangebtn.setForeground(Color.WHITE);
		passChangebtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		passChangebtn.setBackground(new Color(0, 100, 0));
		passChangebtn.setBounds(122, 482, 157, 37);
		empFrame.getContentPane().add(passChangebtn);
		
		logbtn = new JButton("LOGOUT");
		logbtn.setForeground(Color.WHITE);
		logbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		logbtn.setBackground(new Color(0, 100, 0));
		logbtn.setBounds(659, 482, 151, 37);
		empFrame.getContentPane().add(logbtn);
		
        custDetail.addActionListener(this);
        passChangebtn.addActionListener(this);
        logbtn.addActionListener(this);
	}
	
	private void getDetails(String id)
	{
		String temp1;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("EmployeeDataBase.txt")));
			int x=1;
			while((temp1=br.readLine())!=null)
			{
				if(x>=12)
					x%=11;
				if(temp1.equals(id))
				{
					list.add(temp1);
					temp1=br.readLine();
					while(x!=11)
					{	
						list.add(temp1);
						x++;
						temp1=br.readLine();
					}
					break;
				}
				else
				{
					while(x!=11)
					{
						x++;
						temp1=br.readLine();
					}
				}
				x++;
			}
				field1 = new JTextField(list.get(3));
				field1.setFont(new Font("Tahoma", Font.BOLD, 14));
				field1.setBackground(new Color(255, 255, 255));
				field1.setEditable(false);
				field1.setBounds(162, 252, 309, 31);
				field1.setColumns(10);
				empFrame.getContentPane().add(field1);
				
				field2 = new JTextField(list.get(5));
				field2.setFont(new Font("Tahoma", Font.BOLD, 14));
				field2.setBackground(new Color(255, 255, 255));
				field2.setEditable(false);
				field2.setColumns(10);
				field2.setBounds(162, 375, 309, 31);
				empFrame.getContentPane().add(field2);
				
				field3 = new JTextField(list.get(6));
				field3.setFont(new Font("Tahoma", Font.BOLD, 14));
				field3.setBackground(new Color(255, 255, 255));
				field3.setEditable(false);
				field3.setColumns(10);
				field3.setBounds(678, 337, 309, 31);
				empFrame.getContentPane().add(field3);
				
				field4 = new JTextField(list.get(0));
				field4.setFont(new Font("Tahoma", Font.BOLD, 14));
				field4.setBackground(new Color(255, 255, 255));
				field4.setEditable(false);
				field4.setColumns(10);
				field4.setBounds(638, 25, 325, 37);
				empFrame.getContentPane().add(field4);
				
				field5 = new JTextField(list.get(8));
				field5.setFont(new Font("Tahoma", Font.BOLD, 14));
				field5.setBackground(new Color(255, 255, 255));
				field5.setEditable(false);
				field5.setColumns(10);
				field5.setBounds(678, 252, 309, 31);
				empFrame.getContentPane().add(field5);
				
				field6 = new JTextField(list.get(10));
				field6.setFont(new Font("Tahoma", Font.BOLD, 14));
				field6.setBackground(new Color(255, 255, 255));
				field6.setEditable(false);
				field6.setColumns(10);
				field6.setBounds(162, 334, 309, 31);
				empFrame.getContentPane().add(field6);
				
				field7 = new JTextField(list.get(4));
				field7.setFont(new Font("Tahoma", Font.BOLD, 14));
				field7.setBackground(new Color(255, 255, 255));
				field7.setEditable(false);
				field7.setColumns(10);
				field7.setBounds(162, 293, 309, 31);
				empFrame.getContentPane().add(field7);
				
				field8 = new JTextField(list.get(7));
				field8.setFont(new Font("Tahoma", Font.BOLD, 14));
				field8.setBackground(new Color(255, 255, 255));
				field8.setEditable(false);
				field8.setColumns(10);
				field8.setBounds(678, 293, 309, 31);
				empFrame.getContentPane().add(field8);
				
				field9 = new JTextField(list.get(9));
				field9.setFont(new Font("Tahoma", Font.BOLD, 14));
				field9.setBackground(new Color(255, 255, 255));
				field9.setEditable(false);
				field9.setColumns(10);
				field9.setBounds(678, 378, 309, 31);
				empFrame.getContentPane().add(field9);
				
				field10 = new JTextField(list.get(2));
				field10.setFont(new Font("Tahoma", Font.BOLD, 14));
				field10.setBackground(new Color(255, 255, 255));
				field10.setEditable(false);
				field10.setColumns(10);
				field10.setBounds(638, 97, 328, 37);
				
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getSource()==custDetail)
			Database.printData();
		
		else if(e.getSource()==logbtn)
		{
			list.clear();
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			empFrame.setVisible(false);
		}	
		
		else if(e.getSource()==passChangebtn)
		{
			JPanel panel = new JPanel(new GridLayout(3,2));
			JLabel label1 = new JLabel("Enter Old Password : ");
		    JTextField text1,text2,text3;
		    text1 = new JTextField();
		    JLabel label2 = new JLabel("Enter New Password : ");
		    text2 = new JTextField();
		    JLabel label3 = new JLabel("Re-enter New Password : ");
		    text3 = new JTextField();
		    panel.add(label1);
		    panel.add(text1);
		    panel.add(label2);
		    panel.add(text2);
		    panel.add(label3);
		    panel.add(text3);
		    JOptionPane.showMessageDialog(null, panel);
		    if(text1.getText().equals(list.get(1)) && text2.getText().equals(text3.getText()))
		    {
		    	list.set(1,text2.getText());
		    	Database.modifyAccount(list,"Employee Account");
		    	JOptionPane.showMessageDialog(null,"Password Changed Successfully !!");
		    }
		    else
		    	JOptionPane.showMessageDialog(null,"Invalid Old Pin or New Passwords do not match !!");
		}
	}
}
