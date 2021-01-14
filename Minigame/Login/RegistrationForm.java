package Login;

import javax.swing.*;

import connection.JDBCconnection;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegistrationForm extends JFrame implements ActionListener
{
	JPanel p1, p2, p3, p4, p5, p6;
	JLabel headerLabel = new JLabel("REGISTRATION", JLabel.CENTER);
	JLabel userNameLabel = new JLabel(" USERNAME ");
	JTextField userNameTextField = new JTextField(15);
	JLabel passWordLabel = new JLabel(" PASSWORD ");
	JPasswordField passWordTextField = new JPasswordField(15);
	JLabel reEnterPassWordLabel = new JLabel(" RE - ENTER PASSWORD ");
	JPasswordField reEnterPassWordTextField = new JPasswordField(15);
	JCheckBox showPassAndRePass = new JCheckBox("show password");
	JButton confirmButton = new JButton("Confirm");
	JButton cancelButton = new JButton("Cancel");
	
	public RegistrationForm()
	{
		super("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1,1));
		
		addToFrame();
		addActionListener();
		
		setVisible(true);
	}
	
	public void addToFrame()
	{
		p1 = new JPanel();
		p1.setLayout(new GridLayout(6,1));
		
		headerLabel.setFont(new Font("Serif", Font.BOLD, 32));
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.add(userNameLabel);
		p2.add(userNameTextField);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(passWordLabel);
		p3.add(passWordTextField);
		
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.add(reEnterPassWordLabel);
		p4.add(reEnterPassWordTextField);
		
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.add(showPassAndRePass);
		
		p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.add(confirmButton);
		p6.add(cancelButton);
		
		p1.add(headerLabel);
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		p1.add(p5);
		p1.add(p6);
		
		add(p1);
	}
	
	public void addActionListener()
	{
		confirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		showPassAndRePass.addActionListener(this);
	}
	
	public void LoadData(String username, String password)
	{
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCconnection.getConnection();
			
			String sql = "insert into loginacc (username, pass) values (?,?)";
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, username);
			pst.setString(2, password);
			int rowAffected = pst.executeUpdate();
            if(rowAffected == 1)
            {
                rs = pst.getGeneratedKeys();
            }		
		}
		catch (Exception e1) {}
	}
	
	public void LoadMarkData(String username)
	{
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCconnection.getConnection();
			
			String sql = "insert into accMark (name) values (?)";
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, username);
			int rowAffected = pst.executeUpdate();
            if(rowAffected == 1)
            {
                rs = pst.getGeneratedKeys();
            }		
		}
		catch (Exception e1) {}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == confirmButton)
		{
			if (userNameTextField.getText().equals("") || passWordTextField.getText().equals("") || reEnterPassWordTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter full information");
			}
			else
			{
				if (passWordTextField.getText().equals(reEnterPassWordTextField.getText()))
				{
					LoadData(userNameTextField.getText(), passWordTextField.getText());
					LoadMarkData(userNameTextField.getText());
					JOptionPane.showMessageDialog(null, "Successfully");
					setVisible(false);
					LoginForm lg = new LoginForm();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter re-enter password like password");
				}
			}
		}
		
		if (e.getSource() == cancelButton)
		{
			setVisible(false);
			LoginForm lg = new LoginForm();
		}
		
		if (e.getSource() == showPassAndRePass)
		{
			if (showPassAndRePass.isSelected())
			{
				passWordTextField.setEchoChar((char) 0);
				reEnterPassWordTextField.setEchoChar((char) 0);
			}
			else
			{
				passWordTextField.setEchoChar('*');
				reEnterPassWordTextField.setEchoChar('*');
			}
		}
	}
}
