package hg.hist.MVC;

import java.util.HashMap;

import javax.swing.JFrame;


public class MainLaetitiaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerRequest contR= new ControllerRequest();

		RequestFrameLaetitia  frame2 = new RequestFrameLaetitia(contR,10079,0.765,580,626,0.391,128);
		//frame2.setPreferredSize(new Dimension(600, 300));
		HashMap<String,String> mp = new HashMap<String, String>();
		mp.put("Tumor nucleus", "red");
		mp.put("Granulocyte nucleus", "pink");
		mp.put("Lymphocyte Nucleus", "green");
		mp.put("Nucleus DAB+ PRD+", "black");
		mp.put("Nucleus DAB+", "blue");
		
		frame2.init(10079, 0.765, 580, 326, 0.391, 128, mp);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(1200, 700);
		frame2.setVisible(true);
	}

}
