package Login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gameSQL.Choose;

public class ChoosePlay extends JFrame implements ActionListener
{
	JButton btnFile = new JButton("FILE");
	JButton btnSql = new JButton("SQL");
	private String user;
	
	public ChoosePlay(String u)
	{
		super("Select Choose Play");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.user = u;
		addToFrame();
		addActionListener();
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void addToFrame()
	{
		btnFile.setPreferredSize(new Dimension(200, 100));
		btnFile.setFont(new Font("Serif", Font.BOLD, 30));
		btnSql.setPreferredSize(new Dimension(200, 100));
		btnSql.setFont(new Font("Serif", Font.BOLD, 30));
		
		add(btnFile);
		add(btnSql);
	}
	
	public void addActionListener()
	{
		btnFile.addActionListener(this);
		btnSql.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnFile)
		{
			setVisible(false);
			QueueandStack qs = new QueueandStack(user);
		}
		
		if (e.getSource() == btnSql)
		{
			setVisible(false);
			Choose ch = new Choose(user);
		}
	}
}
