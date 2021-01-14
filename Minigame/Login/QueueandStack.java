package Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import game.MiniGame;
import game.MiniGameStack;

public class QueueandStack extends JFrame implements ActionListener
{
	JPanel p1;
	JButton btnQueue = new JButton("A --> Z");
	JButton btnStack = new JButton("Z --> A");
	private String user;
	
	public QueueandStack(String u)
	{
		super("Queue and Stack");
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
		p1 = new JPanel();
		
		p1.setLayout(new GridLayout(2,0));
		
		btnQueue.setPreferredSize(new Dimension(200, 100));
		btnQueue.setFont(new Font("Serif", Font.BOLD, 30));
		
		btnStack.setPreferredSize(new Dimension(200, 100));
		btnStack.setFont(new Font("Serif", Font.BOLD, 30));
		
		
		add(btnQueue);
		add(btnStack);
		
		add(p1);
	}
	
	public void addActionListener()
	{
		btnQueue.addActionListener(this);
		btnStack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnQueue)
		{
			try
			{
				setVisible(false);
				MiniGame mn = new MiniGame(user);
			}
			catch(IOException e1) {}
		}
		
		if (e.getSource() == btnStack)
		{
			try
			{
				setVisible(false);
				MiniGameStack mns = new MiniGameStack(user);
			}
			catch(IOException e1) {}
		}
	}
}
