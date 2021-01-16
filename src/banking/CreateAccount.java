package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateAccount implements ActionListener
{
	protected JFrame newFrame = new JFrame();
    private JButton backbtn,exitbtn,proceedbtn;
    private JLabel label1,lblName,lblDoB,lblAddress,lblState,lblCity,lblPhone,lblGender,lblPhotoID,lblPin,acType;
    private JTextField fieldname,fieldDoB,fieldaddress,fieldcity,fieldphone,fieldpin;
    private JRadioButton male,female,terms;
    private JComboBox<String> state = new JComboBox();
    private JComboBox<String> photoID = new JComboBox();
    private JComboBox<String> accType = new JComboBox();

    private ButtonGroup bg = new ButtonGroup();
    
	CreateAccount()
	{
		newFrame.getContentPane().setLayout(null);
        label1 = new JLabel("Create Account !!");
        label1.setBounds(25,22,338,60);
        label1.setForeground(Color.RED);
        label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 35));
        newFrame.getContentPane().add(label1);
        
        
        proceedbtn = new JButton("PROCEED");
        proceedbtn.setFont(new Font("System", Font.BOLD, 18));
        proceedbtn.setBackground(new Color(0, 128, 0));
        proceedbtn.setForeground(Color.WHITE);
        proceedbtn.setBounds(698,541,231,50);
        newFrame.getContentPane().add(proceedbtn);
        
        backbtn = new JButton("BACK");
        backbtn.setForeground(Color.WHITE);
        backbtn.setFont(new Font("Dialog", Font.BOLD, 18));
        backbtn.setBackground(new Color(0, 128, 0));
        backbtn.setBounds(48, 541, 231, 50);
        newFrame.getContentPane().add(backbtn);
        
        
        exitbtn = new JButton("EXIT");
        exitbtn.setForeground(Color.WHITE);
        exitbtn.setFont(new Font("Dialog", Font.BOLD, 18));
        exitbtn.setBackground(new Color(0, 128, 0));
        exitbtn.setBounds(366, 541, 231, 50);
        newFrame.getContentPane().add(exitbtn);
        
        newFrame.getContentPane().setBackground(new Color(255, 250, 250));
        
        lblName = new JLabel("NAME");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblName.setBounds(27, 117, 70, 38);
        newFrame.getContentPane().add(lblName);
        
        fieldname = new JTextField();
        fieldname.setBounds(145, 122, 288, 38);
        newFrame.getContentPane().add(fieldname);
        fieldname.setColumns(10);
        
        lblDoB = new JLabel("DoB");
        lblDoB.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblDoB.setBounds(25, 180, 70, 38);
        newFrame.getContentPane().add(lblDoB);
        
        fieldDoB = new JTextField();
        fieldDoB.setColumns(10);
        fieldDoB.setBounds(145, 185, 288, 38);
        newFrame.getContentPane().add(fieldDoB);
        
        lblAddress = new JLabel("ADDRESS\r\n");
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblAddress.setBounds(25, 243, 97, 38);
        newFrame.getContentPane().add(lblAddress);
        
        fieldaddress = new JTextField();
        fieldaddress.setColumns(10);
        fieldaddress.setBounds(145, 248, 288, 38);
        newFrame.getContentPane().add(fieldaddress);
        
        lblState = new JLabel("STATE");
        lblState.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblState.setBounds(25, 307, 97, 38);
        newFrame.getContentPane().add(lblState);
        
        state.setModel(new DefaultComboBoxModel(new String[] {"SELECT STATE", "JAMMU AND KASHMIR", "PUNJAB", "HIMACHAL PRADESH", "HARYANA", "UTTARAKHAND", "UTTAR PRADESH", "NEW DELHI", "BIHAR", "RAJASTHAN", "GUJRAT", "ASSAM", "SIKKIM", "TRIPURA", "MEGHALAYA", "ARUNACHAL PRADESH", "NAGALAND", "WEST BENGAL", "ODISHA", "JHARKHAND", "CHATTISGARH", "TELANGANA", "ANDHRA PRADESH", "KARNATAKA", "MAHARASHTRA", "MADHYA PRADESH", "KERELA", "TAMIL NADU", "LAKSHWDEEP", "DAMAN AND DIU", "ANDAMAN AND NICOBAR", "CHANDIGARH", "PONDUCHERRY", "DADRA AND NAGAR HAWELLI"}));
        state.setBackground(new Color(255, 250, 250));
        state.setBounds(145, 311, 288, 38);
        newFrame.getContentPane().add(state);
        
        lblCity = new JLabel("CITY");
        lblCity.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblCity.setBounds(25, 367, 97, 38);
        newFrame.getContentPane().add(lblCity);
        
        fieldcity = new JTextField();
        fieldcity.setColumns(10);
        fieldcity.setBounds(145, 372, 288, 38);
        newFrame.getContentPane().add(fieldcity);
        
        lblPhone = new JLabel("PHONE NO.");
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblPhone.setBounds(498, 122, 110, 38);
        newFrame.getContentPane().add(lblPhone);
        
        fieldphone = new JTextField();
        fieldphone.setColumns(10);
        fieldphone.setBounds(677, 122, 288, 38);
        newFrame.getContentPane().add(fieldphone);
        
        lblPhotoID = new JLabel("PHOTO ID");
        lblPhotoID.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblPhotoID.setBounds(498, 180, 110, 38);
        newFrame.getContentPane().add(lblPhotoID);
        
        photoID.setModel(new DefaultComboBoxModel(new String[] {"SELECT PHOTO ID", "AADHAR CARD", "PAN CARD", "VOTER ID CARD", "DRIVING LICENSE"}));
        photoID.setBackground(new Color(255, 250, 250));
        photoID.setBounds(677, 180, 288, 38);
        newFrame.getContentPane().add(photoID);
        
        lblPin = new JLabel("PIN CODE");
        lblPin.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblPin.setBounds(498, 243, 110, 38);
        newFrame.getContentPane().add(lblPin);
        
        fieldpin = new JTextField();
        fieldpin.setColumns(10);
        fieldpin.setBounds(677, 248, 288, 38);
        newFrame.getContentPane().add(fieldpin);
        
        acType = new JLabel("ACCOUNT TYPE");
        acType.setFont(new Font("Tahoma", Font.BOLD, 19));
        acType.setBounds(498, 307, 165, 38);
        newFrame.getContentPane().add(acType);
        
        accType.setModel(new DefaultComboBoxModel(new String[] {"SELECT ACCOUNT TYPE", "SAVING ACCOUNT",}));
        accType.setBackground(new Color(255, 250, 250));
        accType.setBounds(677, 311, 288, 38);
        newFrame.getContentPane().add(accType);
        
        terms = new JRadioButton("I Agree to the Terms and Conditions");
        terms.setBackground(new Color(255, 250, 250));
        terms.setFont(new Font("Tahoma", Font.BOLD, 19));
        terms.setBounds(274, 446, 406, 44);
        newFrame.getContentPane().add(terms);
        
        lblGender = new JLabel("GENDER");
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblGender.setBounds(498, 367, 88, 38);
        newFrame.getContentPane().add(lblGender);
        
        male = new JRadioButton("MALE");
        male.setBackground(new Color(255, 250, 250));
        male.setFont(new Font("Times New Roman", Font.BOLD, 19));
        male.setBounds(677, 367, 88, 38);
        newFrame.getContentPane().add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBackground(new Color(255, 250, 250));
        female.setFont(new Font("Times New Roman", Font.BOLD, 19));
        female.setBounds(796, 367, 124, 38);
        newFrame.getContentPane().add(female);
        
        bg.add(male);
        bg.add(female);
        
        newFrame.setSize(1047,684);
        newFrame.setLocation(300,90);
        newFrame.setVisible(true);
        
        proceedbtn.addActionListener(this);
        backbtn.addActionListener(this);
        exitbtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==proceedbtn)
		{
			if(areDetailsComplete())
			{
				if(terms.isSelected()==false)
					JOptionPane.showMessageDialog(null,"Please Accept the Terms and Conditions !!");
				else
				{
					createAccount();
					Database.saveDataBase();
					new Authentication().theFrame.setVisible(true);
					newFrame.setVisible(false);
				}
			}
			else
				JOptionPane.showMessageDialog(null,"Please fill the complete form !!");
		}
		if(e.getSource()==backbtn)
		{
			new CustomerLogin().xframe.setVisible(true);
			newFrame.setVisible(false);
		}
		else if(e.getSource()==exitbtn)
			System.exit(0);
	}
     
	private void createAccount()
	{
		String gen = null;
		if(male.isSelected())
			gen="male";
		else
			gen="female";
		String stat=(String) state.getSelectedItem();
		String acTpe=(String) accType.getSelectedItem();
		
		Data ob = new Data();
		ob.getData(fieldname.getText(),fieldDoB.getText(),fieldaddress.getText(),fieldcity.getText(),stat,fieldphone.getText(),fieldpin.getText(),acTpe,gen);
		Database.addAccount(ob);
	}
	
	private boolean areDetailsComplete()
	{
		if(fieldname.getText().isEmpty() || fieldDoB.getText().isEmpty() || fieldaddress.getText().isEmpty() || fieldcity.getText().isEmpty() ||  fieldphone.getText().isEmpty() || fieldpin.getText().isEmpty())
			return false;
		return true;
	}
}