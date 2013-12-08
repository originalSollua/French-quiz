import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax .swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GameFrame extends JFrame
{
	private static final int FRAME_W = 400;
	private static final int FRAME_H = 350;
	private JLabel questionField;
	private JLabel timeField;
	private int min;
	private int sec;
	
	private JRadioButton one;
	private JRadioButton two;
	private JRadioButton three;
	
	
	public GameFrame()
	{
		min = 0;
		sec = 0;
		questionField = new JLabel("Big Java");
		timeField = new JLabel("Reamining Time: "+min+":"+sec);
		
		add(questionField, BorderLayout.CENTER);
		add(timeField, BorderLayout.NORTH);
		
		one = new JRadioButton("");
		two = new JRadioButton("");
		three = new JRadioButton("");
		ButtonGroup group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);
		
		JPanel b = new JPanel();
		b.setLayout(new GridLayout(3, 1));
		b.add(one);
		b.add(two);
		b.add(three);
		add(b, BorderLayout.SOUTH);
		
		setSize(FRAME_W,FRAME_H);
	}
	public void redrawTime(int min, int sec)
	{
		timeField.setText("Reamining Time: "+min+":"+sec);
	}
	public boolean redraw(String n, String on, String tw, String th, String ans)
	{
		questionField.setText(n);
		one.setText(on);
		two.setText(tw);
		three.setText(th);
		ButtonGroup group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);
		boolean flag = false;
		repaint();
		boolean win = false;
		do
		{
			
			if(one.isSelected()&& ans.equals("one"))
			{
				System.out.println("Correct");
				flag = true;
				win=true;
			
			}
			else if(two.isSelected()&& ans.equals("two"))
			{
				System.out.println("Correct");
				flag = true;
				win = true;
			
			}
			else if(three.isSelected()&& ans.equals("three"))
			{
				System.out.println("Correct");
				flag = true;
				win = true;
				
			}
			else if((one.isSelected() && !ans.equals("one")) || (two.isSelected() && !ans.equals("two")) || (three.isSelected() && !ans.equals("three")))
			{
				flag = true;
				System.out.println("Incorrect");
				win = false;
				
			}
			else
			{
				flag = false;
			}
		}while(!flag);
		group.clearSelection();
		return win;
	}
	public void end1(int points)
	{
		JOptionPane.showMessageDialog(null, "Team one scored "+points+" Team 2 get ready!");
	}
	public void end2(int points, int points1)
	{
		JOptionPane.showMessageDialog(null, "Team two scored "+points);
		if(points > points1)
			JOptionPane.showMessageDialog(null, "Team 2 Wins! ");
		else if( points1 > points)
			JOptionPane.showMessageDialog(null, "Team ! Wins!");
		else
			JOptionPane.showMessageDialog(null, "Its a Tie!!");
	}
	
}
