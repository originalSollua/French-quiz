import javax.swing.*;

import java.util.Random;
import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class Game {
	
	static Timer timer;
	static Timer timer2;
	static int interval = 10; // number of seconds each team gets to answer questions
	static int seed;
	static int false1;
	static int false2;
	static int min = interval / 60;
	static int sec = interval % 60;
	static boolean flags = true;
	static int points1 =0;
	static int points2 = 0;
	

	public static void main(String[]args)throws FileNotFoundException
	{
		System.out.println("French Game v 0.1");
		final ArrayList<String> questions = new ArrayList<String>();
		final ArrayList<String> answers = new ArrayList<String>();
		
		final Game fren = new Game();
		final GameFrame frame = new GameFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Team 1");
		
		File infile = new File ("src/list.txt");
		Scanner in = new Scanner(infile);
		
		while(in.hasNext())
		{
			
			String hold = in.nextLine();
			String[] temp = hold.split("#");
			questions.add(temp[0]);
			answers.add(temp[1]);
		}
		in.close();
			
		int delay = 1000;
		int period = 1000;
		
	
		timer = new Timer();
		
		TimerTask things = new TimerTask()
		
		{
			   public void run() 
			   {
				   interval--;
				   sec--;
				   if(sec < 0)
				   {
					   min--;
					   sec=59;
				   }
				   fren.setInterval(interval);
				   frame.redrawTime(min, sec);
				 
				   frame.repaint();
			   }
		};
		
		timer.scheduleAtFixedRate(things, delay, period);
		do
		{
			boolean won =false;
			int pos_real = g_rand()%3;
			if(pos_real == 0)
			{
				seed = g_rand()%questions.size();
				false1 =g_rand()%questions.size();
				false2=g_rand()%questions.size();
				
				won=frame.redraw(questions.get(seed),answers.get(seed), answers.get(false1), answers.get(false2), "one") ;
			}
			else if(pos_real == 1)
			{
				seed = g_rand()%questions.size();
				false1 =g_rand()%questions.size();
				false2=g_rand()%questions.size();
				
				won=frame.redraw(questions.get(seed),answers.get(false1), answers.get(seed), answers.get(false2), "two") ;
			}
			else if(pos_real == 2)
			{
				seed = g_rand()%questions.size();
				false1 =g_rand()%questions.size();
				false2=g_rand()%questions.size();
				
				won=frame.redraw(questions.get(seed),answers.get(false1), answers.get(false2), answers.get(seed), "three") ;
			}
			if(won)
				points1++;
		}while(flags);
		
		frame.end1(points1);
		frame.dispose();
		timer.purge();

		
		final GameFrame frame2 = new GameFrame();
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		frame2.setTitle("Team 2");
		interval = 10;
		min = interval / 60;
		sec = interval % 60;
		flags = true;
		timer2 = new Timer();
		TimerTask things2 = new TimerTask()
		
		{
			   public void run() 
			   {
				   interval--;
				   sec--;
				   if(sec < 0)
				   {
					   min--;
					   sec=59;
				   }
				   fren.setInterval2(interval);
				   frame2.redrawTime(min, sec);
				 
				   frame2.repaint();
			   }
		};
		timer2.scheduleAtFixedRate(things2, delay, period);
		do
		{
			boolean won =false;
			int pos_real = g_rand()%3;
			if(pos_real == 0)
			{
				seed = g_rand()%questions.size();
				false1 =g_rand()%questions.size();
				false2=g_rand()%questions.size();
				
				won=frame2.redraw(questions.get(seed),answers.get(seed), answers.get(false1), answers.get(false2), "one") ;
			}
			else if(pos_real == 1)
			{
				seed = g_rand()%questions.size();
				false1 =g_rand()%questions.size();
				false2=g_rand()%questions.size();
				
				won=frame2.redraw(questions.get(seed),answers.get(false1), answers.get(seed), answers.get(false2), "two") ;
			}
			else if(pos_real == 2)
			{
				seed = g_rand()%questions.size();
				false1 =g_rand()%questions.size();
				false2=g_rand()%questions.size();
				
				won=frame2.redraw(questions.get(seed),answers.get(false1), answers.get(false2), answers.get(seed), "three") ;
			}
			if(won)
				points2++;
		}while(flags);
		
		frame2.end2(points2, points1);
		frame2.dispose();
		 
	}
	private  int setInterval(int inte ) 
	{
		if(inte <= 10 && inte > 0)
		{
			System.out.println("WARNING: TIME IS ALMOST UP!");
			
		}
		else if (inte <= 1)
		{
			System.out.println("Time is up!");
			timer.cancel();
			flags = false;
		}
		return inte;
	}
	private  int setInterval2(int inte ) 
	{
		if(inte <= 10 && inte > 0)
		{
			System.out.println("WARNING: TIME IS ALMOST UP!");
			
		}
		else if (inte <= 1)
		{
			System.out.println("Time is up!");
			timer2.cancel();
			flags = false;
		}
		return inte;
	}
	
	
	
	public static int g_rand()
	{
		Random t = new Random();
		int m = t.nextInt();
		if(m < 0)
		{
			m = m*-1;
		}
		return m;
	}

}
