package hg.hist.MVC;

import javax.swing.JFrame;

public class MainMVC {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub		
		
		Controller controller = new Controller();
		View frame = new View(controller);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 700);
		frame.setVisible(true);
		
		/*
		Max Area : 10079.0Max Border : 580.0Max Shpericity : 0.76503277439
		Min Area : 626.0Min Border : 128.0Min Shpericity : 0.39167791161
		*/
		/*
		RequestFram  frame2 = new RequestFram(10079 , 0.765,580,626,0.391,128);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(1200, 700);
		frame2.setVisible(true);
		*/
		}

		
}
