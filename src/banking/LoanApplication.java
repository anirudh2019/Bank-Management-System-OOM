package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoanApplication implements ActionListener
{	
	protected JFrame loanFrame = new JFrame();
	private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    private JTextField txtField1,txtField2,txtField3,txtField4,txtField5,txtField6;
    private JRadioButton male,female,terms;
    private JComboBox<String> state,photoID;
    private JButton backbtn,proceedbtn;
    private ButtonGroup bg = new ButtonGroup();
    
	LoanApplication()
	{
		loanFrame.getContentPane().setLayout(null);
		
		addLabelAndFields();
        
        addButton();
        
        loanFrame.setSize(1047,684);
        loanFrame.setLocation(300,90);
        loanFrame.setVisible(true);
        
	}
	
	private void addLabelAndFields()
	{
		label = new JLabel("LOAN APPLICATION WINDOW");
        label.setBounds(25,22,529,60);
        label.setForeground(Color.RED);
        label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 35));
        loanFrame.getContentPane().add(label);
        
        label1 = new JLabel("NAME : ");
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(25, 145, 95, 27);
        loanFrame.getContentPane().add(label1);
        
        label2 = new JLabel("DoB : ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setBounds(25, 213, 75, 27);
        loanFrame.getContentPane().add(label2);
        
        label3 = new JLabel("ADDRESS : ");
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setBounds(25, 280, 128, 27);
        loanFrame.getContentPane().add(label3);
        
        label4 = new JLabel("GENDER : ");
        label4.setFont(new Font("Tahoma", Font.BOLD, 20));
        label4.setBounds(25, 349, 119, 27);
        loanFrame.getContentPane().add(label4);
        
        label5 = new JLabel("STATE : ");
        label5.setFont(new Font("Tahoma", Font.BOLD, 20));
        label5.setBounds(25, 418, 87, 32);
        loanFrame.getContentPane().add(label5);
        
        label6 = new JLabel("PHOTO ID : ");
        label6.setFont(new Font("Tahoma", Font.BOLD, 20));
        label6.setBounds(455, 152, 148, 27);
        loanFrame.getContentPane().add(label6);
        
        label7 = new JLabel("ID NUMBER : ");
        label7.setFont(new Font("Tahoma", Font.BOLD, 20));
        label7.setBounds(455, 213, 148, 27);
        loanFrame.getContentPane().add(label7);
        
        label8 = new JLabel("LOAN AMOUNT : ");
        label8.setFont(new Font("Tahoma", Font.BOLD, 20));
        label8.setBounds(455, 349, 172, 27);
        loanFrame.getContentPane().add(label8);
        
        label9 = new JLabel("LOAN DURATION (in months) : ");
        label9.setFont(new Font("Tahoma", Font.BOLD, 20));
        label9.setBounds(456, 421, 312, 27);
        loanFrame.getContentPane().add(label9);
        
        label10 = new JLabel("LOAN DETAILS : ");
        label10.setForeground(Color.RED);
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        label10.setFont(new Font("Tahoma", Font.BOLD, 26));
        label10.setBounds(480, 280, 410, 43);
        loanFrame.getContentPane().add(label10);
        
        txtField1 = new JTextField();
        txtField1.setBounds(150, 147, 277, 32);
        loanFrame.getContentPane().add(txtField1);
        txtField1.setColumns(10);
        
        txtField2 = new JTextField();
        txtField2.setColumns(10);
        txtField2.setBounds(150, 215, 277, 32);
        loanFrame.getContentPane().add(txtField2);
        
        txtField3 = new JTextField();
        txtField3.setColumns(10);
        txtField3.setBounds(150, 282, 277, 32);
        loanFrame.getContentPane().add(txtField3);
        
        txtField4 = new JTextField();
        txtField4.setColumns(10);
        txtField4.setBounds(613, 215, 277, 32);
        loanFrame.getContentPane().add(txtField4);
        
        txtField5 = new JTextField();
        txtField5.setColumns(10);
        txtField5.setBounds(642, 351, 347, 32);
        loanFrame.getContentPane().add(txtField5);
        
        txtField6 = new JTextField();
        txtField6.setColumns(10);
        txtField6.setBounds(778, 423, 211, 32);
        loanFrame.getContentPane().add(txtField6);
        
        male = new JRadioButton("MALE");
        male.setFont(new Font("Tahoma", Font.BOLD, 20));
        male.setBounds(150, 353, 95, 27);
        loanFrame.getContentPane().add(male);
        
        female = new JRadioButton("FEMALE");
        female.setFont(new Font("Tahoma", Font.BOLD, 20));
        female.setBounds(268, 356, 138, 27);
        loanFrame.getContentPane().add(female);
        
        bg.add(male);
        bg.add(female);
        
        terms = new JRadioButton("I Agree to the Terms and Conditions");
        terms.setBackground(new Color(255, 250, 250));
        terms.setFont(new Font("Tahoma", Font.BOLD, 22));
        terms.setBounds(257, 491, 445, 44);
        loanFrame.getContentPane().add(terms);
        
        state = new JComboBox(new DefaultComboBoxModel(new String[] {"SELECT STATE", "JAMMU AND KASHMIR", "PUNJAB", "HIMACHAL PRADESH", "HARYANA", "UTTARAKHAND", "UTTAR PRADESH", "NEW DELHI", "BIHAR", "RAJASTHAN", "GUJRAT", "ASSAM", "SIKKIM", "TRIPURA", "MEGHALAYA", "ARUNACHAL PRADESH", "NAGALAND", "WEST BENGAL", "ODISHA", "JHARKHAND", "CHATTISGARH", "TELANGANA", "ANDHRA PRADESH", "KARNATAKA", "MAHARASHTRA", "MADHYA PRADESH", "KERELA", "TAMIL NADU", "LAKSHWDEEP", "DAMAN AND DIU", "ANDAMAN AND NICOBAR", "CHANDIGARH", "PONDUCHERRY", "DADRA AND NAGAR HAWELLI"}));
        state.setBounds(150, 422, 277, 32);
        loanFrame.getContentPane().add(state);
        
        photoID = new JComboBox();
        photoID.setModel(new DefaultComboBoxModel(new String[] {"SELECT PHOTO ID", "AADHAR CARD", "DRIVING LICENSE", "PAN CAD", "VOTER ID CARD"}));
        photoID.setBounds(613, 146, 277, 32);
        loanFrame.getContentPane().add(photoID);
	}
	
	private void addButton()
	{
		proceedbtn = new JButton("CONTINUE");
        proceedbtn.setFont(new Font("System", Font.BOLD, 18));
        proceedbtn.setBackground(new Color(0, 128, 0));
        proceedbtn.setForeground(Color.WHITE);
        proceedbtn.setBounds(514,561,231,50);
        loanFrame.getContentPane().add(proceedbtn);
        
        backbtn = new JButton("BACK");
        backbtn.setForeground(Color.WHITE);
        backbtn.setFont(new Font("Dialog", Font.BOLD, 18));
        backbtn.setBackground(new Color(0, 128, 0));
        backbtn.setBounds(209, 561, 231, 50);
        loanFrame.getContentPane().add(backbtn);
        loanFrame.getContentPane().setBackground(new Color(255, 250, 250));

        proceedbtn.addActionListener(this);
        backbtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==proceedbtn)
		{
			if(isFormFilled())
			{
				if(terms.isSelected()==false)
					JOptionPane.showMessageDialog(null,"Please Accept the Terms and Conditions !!");
				else
				{
					createLoanAccount();
					Database.saveDataBase();
					new Authentication().theFrame.setVisible(true);
					loanFrame.setVisible(false);
				}
			}
			else
				JOptionPane.showMessageDialog(null,"Please fill the complete form !!");
		}
		if(e.getSource()==backbtn)
		{
			new CustomerLogin().xframe.setVisible(true);
			loanFrame.setVisible(false);
		}
	}
    
	boolean isFormFilled()
	{
		if(txtField1.getText().isEmpty() || txtField2.getText().isEmpty() || txtField3.getText().isEmpty() || txtField4.getText().isEmpty() || txtField6.getText().isEmpty() || txtField6.getText().isEmpty() || !terms.isSelected() || state.getSelectedItem().equals("SELECT STATE"))
			return false;
		return true;
	}
	
	void createLoanAccount()
	{
		String stat=(String) state.getSelectedItem();
		String gen;
		if(male.isSelected())
			gen="male";
		else
			gen="female";
		Data ob = new Data();
		ob.getLoanData(txtField1.getText(),txtField2.getText(),txtField3.getText(),gen,stat,stat,txtField4.getText(),txtField5.getText(),txtField6.getText());
		//Database.saveLoanData(ob,"LoanAccountDataBase.txt");
		Database.addLoanData(ob);
	}
}