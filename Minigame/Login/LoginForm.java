package Login;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

import connection.JDBCconnection;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import game.MiniGame;

public class LoginForm extends JFrame implements ActionListener
{
	JPanel p1, p2, p3, p4, p5, p6;
	JLabel headerLabel = new JLabel("LOGIN", JLabel.CENTER);
	JLabel userNameLabel = new JLabel(" USERNAME ");
	JLabel passWordLabel = new JLabel(" PASSWORD ");
	JTextField userNameTextField = new JTextField(15);
	JPasswordField passWordTextField = new JPasswordField(15);
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton newAccountButton = new JButton("Create a new Account");
	JCheckBox showPass = new JCheckBox("show password");
	
	public static void main(String[] args)
	{
		new LoginForm();
	}
	
	public LoginForm()
	{
		super("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 350);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2,1));
		
		addToFrame();
		addActionListener();
		
		setVisible(true);
	}
	
	public void addToFrame()
	{
		
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1));
		
		headerLabel.setFont(new Font("Serif", Font.BOLD, 32));
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.add(userNameLabel);
		p2.add(userNameTextField);
		
		p3 = new JPanel();
		p3.add(passWordLabel);
		p3.add(passWordTextField);
		
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		p5.add(showPass);
		
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.add(loginButton);
		p4.add(resetButton);
		p4.add(newAccountButton);
		
		p1.add(headerLabel);
		p1.add(p2);
		p1.add(p3);
		p1.add(p5);
		
		
		add(p1);
		add(p4);
	}
	
	public void addActionListener()
	{
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPass.addActionListener(this);
		newAccountButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()== loginButton)
		{
			
			if (userNameTextField.getText().equals("") || passWordTextField.getText().equals(""))
			{
				JOptionPane.showConfirmDialog(rootPane, "Some Fields Are is Empty", "Error", JOptionPane.DEFAULT_OPTION);
			}
			else
			{
				PreparedStatement pst = null;
				Connection conn = null;
				try
				{
					conn = JDBCconnection.getConnection();
					
					String sql = "select * from loginacc where username = ? and pass = ?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, userNameTextField.getText());
		            pst.setString(2, passWordTextField.getText());
	            
					ResultSet rs = pst.executeQuery();
					
					if (rs.next())
					{
						setVisible(false);
						ChoosePlay cp = new ChoosePlay(userNameTextField.getText());
					}
					else
					{
						JOptionPane.showConfirmDialog(rootPane, "Fail", "Error", JOptionPane.DEFAULT_OPTION);
					}
				}
				catch (Exception e1) {}
			}
		}
		
		if (e.getSource() == resetButton)
		{
			userNameTextField.setText("");
			passWordTextField.setText("");
		}
		
		if (e.getSource() == newAccountButton)
		{
			setVisible(false);
			RegistrationForm rf = new RegistrationForm();	
		}
		
		if (e.getSource() == showPass)
		{
			if (showPass.isSelected())
			{
				passWordTextField.setEchoChar((char) 0);
			}
			else
			{
				passWordTextField.setEchoChar('*');
			}
		}
	}
}
