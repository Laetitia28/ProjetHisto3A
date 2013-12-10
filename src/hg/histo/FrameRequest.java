package hg.histo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FrameRequest extends JFrame  {


	/**
	 * 
	 */
	JLabel Cellule1;
	JLabel Cellule2;
	JLabel Cellule3;
	JLabel Cellule4;
	JLabel Sphericity;
	JLabel Area;
	JLabel Border;
	JPanel panel;
	JPanel paneCellule;
	JPanel paneSphere;
	JPanel paneArea;
	JPanel paneBorder;
	JPanel paneEnd;
	JButton btSup,btInf,btEt,btOu,btOk,btApply;
	JButton btSup2,btInf2,btEt2,btOu2,btSup3,btInf3,btEt3,btOu3;
	JSlider slider;
	JSlider slider2;
	JSlider slider3;
	JTextField sliderDisplay;
	JTextField sliderDisplay2;
	JTextField sliderDisplay3;
	JPanel rubrique1;
	JPanel rubrique2;
	JPanel rubrique3;
	JPanel rubrique4;
	static final int SLIDER_INIT =125 ;
	static final int SLIDER_MIN =0;
	static final int SLIDER_MAX =250;
	ButtonGroup g ;
	private JRadioButton btRadio1;
	private JRadioButton btRadio2;
	private JRadioButton btRadio3;
	private JRadioButton btRadio4;
	private JRadioButton btRadio5;
	private JRadioButton btRadio6;
	private JRadioButton btRadio7;
	private JRadioButton btRadio8;
	private JRadioButton btRadio9;
	private static final long serialVersionUID = 1L;
	
	public FrameRequest(){
	}
	
	public JFrame advancedRequest(){
		JFrame frame2 = new JFrame("Advanced Request");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(800,1000);
		frame2.setVisible(true);
		frame2.setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		panel.setBackground(Color.white);
		frame2.add(panel);
		//choisir la cellule
		
		rubrique1 = new JPanel();//contient les cellule
		rubrique1.setPreferredSize(new Dimension(1200,100));
		rubrique1.setBackground(Color.white);
	    Cellule1 = new JLabel("Choose your Cellule");
	    paneCellule = new JPanel();
	    Border blackline = BorderFactory.createLineBorder(Color.black);
	    paneCellule.setBorder(blackline);
	    paneCellule.setBounds(0, 200, 150, 200);
		paneCellule.setOpaque(true);
		paneCellule.setBackground(Color.white);
		paneCellule.setPreferredSize(new Dimension(600,50));;
		paneCellule.setLayout(new GridLayout(3,3));
	     g = new ButtonGroup();
	     btRadio1 = new JRadioButton("AllCells",true);
	     btRadio2 = new JRadioButton("NucleusDAB+PRD+");
	     btRadio3 = new JRadioButton("Lymphocyte Nucleus");
	     btRadio4 = new JRadioButton("Tumor nucleus");
	     btRadio5 = new JRadioButton("NucleusPRD+");
	     btRadio6 = new JRadioButton("Granulocyte nucleus");
	     btRadio7 = new JRadioButton("Nucleus DAB+");
	    btRadio8 = new JRadioButton("OO");
	     btRadio9 = new JRadioButton("NN");
	   
	    
	    g.add(btRadio1);
	    g.add(btRadio2);
	    g.add(btRadio3);
	    g.add(btRadio4);
		g.add(btRadio4);
		g.add(btRadio5);
		g.add(btRadio6);
		g.add(btRadio7);
		g.add(btRadio8);
		g.add(btRadio9);
		paneCellule.add(btRadio1);
		paneCellule.add(btRadio2);
		paneCellule.add(btRadio3);
		paneCellule.add(btRadio4);
		paneCellule.add(btRadio5);
		paneCellule.add(btRadio6);
		paneCellule.add(btRadio7);
		paneCellule.add(btRadio8);
		paneCellule.add(btRadio9);
		rubrique1.add(Cellule1,BorderLayout.NORTH);
		rubrique1.add(paneCellule,BorderLayout.NORTH);
		//choisir la sphericite
		rubrique2 = new JPanel();//contient les cellule
		rubrique2.setPreferredSize(new Dimension(1200,100));
		rubrique2.setBackground(Color.white);
		Sphericity = new JLabel("Choose your Spherecity");
		paneSphere=new JPanel();
		paneSphere.setLayout(new GridLayout(1,4));
		paneSphere.setBackground(Color.white);
		paneSphere.setPreferredSize(new Dimension(300,30));
		
		btSup2=new JButton("Sup");
        btInf2=new JButton("Inf");
        btEt2=new JButton("ET");
		btOu2=new JButton("OU");
	    sliderDisplay2 =new JTextField();
	    sliderDisplay2.setText("Value of slider");
	    sliderDisplay2.setPreferredSize(new Dimension(100,30));
	    sliderDisplay2.setForeground(Color.BLUE);
	    slider2 =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
	    slider2.setMajorTickSpacing(50);
	    slider2.setMinorTickSpacing(1);
	    slider2.setPaintTicks(true);
	    slider2.setPaintLabels(true);
	    slider2.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderDisplay2.setText(String.valueOf(slider2.getValue()));
            }
        });
	    sliderDisplay2.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke) {
                String typed = sliderDisplay2.getText();
                slider2.setValue(0);
                if(!typed.matches("\\d+")) {
                    return;
                }
                int value = Integer.parseInt(typed);
                slider2.setValue(value);
            }
        });
		paneSphere.add(btSup2,BorderLayout.WEST);
		paneSphere.add(btInf2,BorderLayout.CENTER);
		paneSphere.add(btEt2,BorderLayout.WEST);
		paneSphere.add(btOu2,BorderLayout.CENTER);
		//paneSphere.add(slider,BorderLayout.EAST);
		rubrique2.add(Sphericity,BorderLayout.NORTH);
		rubrique2.add(paneSphere,BorderLayout.WEST);
		rubrique2.add(slider2);
		rubrique2.add(sliderDisplay2);
		
		
		
		//choisir la surface
		   
		rubrique3 = new JPanel();//contient les cellule
		rubrique3.setPreferredSize(new Dimension(1200,100));
		rubrique3.setBackground(Color.white);
	    Area = new JLabel("Choose your Area");
		paneArea=new JPanel();
		paneArea.setLayout(new GridLayout(1,4));
		paneArea.setBackground(Color.white);
		paneArea.setPreferredSize(new Dimension(300,30));
		
		btSup=new JButton("Sup");
        btInf=new JButton("Inf");
        btEt=new JButton("ET");
		btOu=new JButton("OU");
	    sliderDisplay =new JTextField();
	    sliderDisplay.setText("Value of slider");
	    sliderDisplay.setPreferredSize(new Dimension(100,30));
	    sliderDisplay.setForeground(Color.BLUE);
	    slider =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
	    slider.setMajorTickSpacing(50);
	    slider.setMinorTickSpacing(1);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
	    slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderDisplay.setText(String.valueOf(slider.getValue()));
            }
        });
	    sliderDisplay.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke) {
                String typed = sliderDisplay.getText();
                slider.setValue(0);
                if(!typed.matches("\\d+")) {
                    return;
                }
                int value = Integer.parseInt(typed);
                slider.setValue(value);
            }
        });
		paneArea.add(btSup,BorderLayout.WEST);
		paneArea.add(btInf,BorderLayout.CENTER);
		paneArea.add(btEt,BorderLayout.WEST);
		paneArea.add(btOu,BorderLayout.CENTER);
		
		rubrique3.add(Area,BorderLayout.NORTH);
		rubrique3.add(paneArea,BorderLayout.WEST);
		rubrique3.add(slider);
		rubrique3.add(sliderDisplay);
	
		
		//choisir area
		   
	rubrique4 = new JPanel();//contient les cellule
	rubrique4.setPreferredSize(new Dimension(1200,100));
	rubrique4.setBackground(Color.white);
    Border= new JLabel("Choose your Border");
    paneBorder=new JPanel();
	paneBorder.setLayout(new GridLayout(1,4));
	paneBorder.setBackground(Color.white);
	paneBorder.setPreferredSize(new Dimension(300,30));
				
	btSup3=new JButton("Su");
    btInf3=new JButton("In");
    btEt3=new JButton("ET");
	btOu3=new JButton("OU");
	sliderDisplay3 =new JTextField();
	sliderDisplay3.setText("Value of slider");
	sliderDisplay3.setPreferredSize(new Dimension(100,30));
    sliderDisplay3.setForeground(Color.BLUE);
    slider3 =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
	slider3.setMajorTickSpacing(50);
	slider3.setMinorTickSpacing(1);
    slider3.setPaintTicks(true);
	slider3.setPaintLabels(true);
	  slider3.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderDisplay3.setText(String.valueOf(slider3.getValue()));
            }
        });
	    sliderDisplay3.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke) {
                String typed = sliderDisplay3.getText();
                slider3.setValue(0);
                if(!typed.matches("\\d+")) {
                    return;
                }
                int value = Integer.parseInt(typed);
                slider3.setValue(value);
            }
        });
	paneBorder.add(btSup3,BorderLayout.WEST);
	paneBorder.add(btInf3,BorderLayout.CENTER);
	paneBorder.add(btEt3,BorderLayout.WEST);
	paneBorder.add(btOu3,BorderLayout.CENTER);
				
	rubrique4.add(Border,BorderLayout.NORTH);
	rubrique4.add(paneBorder,BorderLayout.WEST);
	rubrique4.add(slider3);
	rubrique4.add(sliderDisplay3);
			
    paneEnd =new JPanel();
    paneEnd.setPreferredSize(new Dimension(1200,100));
    paneEnd.setBackground(Color.white);
	btOk=new JButton("Ok");
    btApply=new JButton("Apply");
    paneEnd.add(btOk,BorderLayout.WEST);
    paneEnd.add(btApply,BorderLayout.WEST);
    
		panel.add(rubrique1);
		panel.add(rubrique2);
		panel.add(rubrique3);
		panel.add(rubrique4);
		panel.add(paneEnd,BorderLayout.SOUTH);
		
		
		
		return frame2;
		
	}
		
		
	
	

}
