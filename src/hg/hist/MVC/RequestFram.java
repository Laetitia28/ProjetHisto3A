package hg.hist.MVC;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.util.Enumeration;

	import javax.swing.AbstractButton;
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

	public class RequestFram  extends JFrame implements ActionListener,ChangeListener {
	

		/**
		 * 
		 */
		
		
		private static final long serialVersionUID = 123456L;
		
		private JLabel LabelChooseType = new JLabel("Choose your Cellule"); 
		private JLabel Sphericity = new JLabel("Choose your Spherecity");
		private JLabel Area  = new JLabel("Choose your Area");
		private JLabel Border= new JLabel("Choose your Border");

		
		private JPanel panel =  new JPanel();
		private JPanel paneCellule = new JPanel();
		private JPanel paneSphere = new JPanel();
		private JPanel paneArea = new JPanel();
		private JPanel paneBorder = new JPanel();
		private JPanel paneEnd = new JPanel();
		
		
		private JButton btOk=new JButton("Ok");
		private JButton btApply=new JButton("Apply");

		private JButton btSup = new JButton("Sup");
		private JButton btInf = new JButton("Inf");
		private JButton btEt = new JButton("ET");
		private JButton btOu = new JButton("OU");
		
		private JButton btSup2 =new JButton("Sup");
		private JButton btInf2=new JButton("Inf");
		private JButton btEt2=new JButton("ET");
		private JButton btOu2=new JButton("OU");
		
		private JButton btSup3=new JButton("Su");
		private JButton btInf3=new JButton("In");
		private JButton btEt3=new JButton("ET");
		private JButton btOu3=new JButton("OU");
		
		
		private JSlider slider =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);

		private JSlider slider2 =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		private JSlider slider3 =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);

		
	    

		private JTextField sliderDisplay = new JTextField();
		private JTextField sliderDisplay2 =new JTextField();
		private JTextField sliderDisplay3 =new JTextField();
		
		private JPanel rubrique1 = new JPanel();//contient les cellules
		private JPanel rubrique2 = new JPanel();
		private JPanel rubrique3 = new JPanel();
		private JPanel rubrique4 = new JPanel();
		
		JFrame frame2;
		
		static final int SLIDER_INIT =125 ;
		static final int SLIDER_MIN =0;
		static final int SLIDER_MAX =250;
		
		private ButtonGroup groupButton = new ButtonGroup(); ;
		
		private JRadioButton btRadio1  = new JRadioButton("AllCells",true);
		private JRadioButton btRadio2 = new JRadioButton("Nucleus DAB+ PRD+");
		private JRadioButton btRadio3 = new JRadioButton("Lymphocyte Nucleus");
		private JRadioButton btRadio4 = new JRadioButton("Tumor nucleus");
		private JRadioButton btRadio5 = new JRadioButton("NucleusPRD+");
		private JRadioButton btRadio6 = new JRadioButton("Granulocyte nucleus");
		private JRadioButton  btRadio7 = new JRadioButton("Nucleus DAB+");
		private JRadioButton btRadio8 = new JRadioButton("OO");
		private JRadioButton btRadio9 = new JRadioButton("NN");
	
	    
		private String b;
		
		
		
		
		
			
			
		
		
	public RequestFram (){

		
			panel.setBackground(Color.white);
			this.add(panel);
			//choisir la cellule
			
			
			rubrique1.setPreferredSize(new Dimension(1200,100));
			rubrique1.setBackground(Color.white);
		    
		    
		    Border blackline = BorderFactory.createLineBorder(Color.black);
		    paneCellule.setBorder(blackline);
		    paneCellule.setBounds(0, 200, 150, 200);
			paneCellule.setOpaque(true);
			paneCellule.setBackground(Color.white);
			paneCellule.setPreferredSize(new Dimension(600,50));;
			paneCellule.setLayout(new GridLayout(3,3));
			
		

		   
		    
			groupButton.add(btRadio1);
			groupButton.add(btRadio2);
			groupButton.add(btRadio3);
			groupButton.add(btRadio4);
			groupButton.add(btRadio4);
			groupButton.add(btRadio5);
			groupButton.add(btRadio6);
			groupButton.add(btRadio7);
			groupButton.add(btRadio8);
			groupButton.add(btRadio9);
			
			paneCellule.add(btRadio1);
			paneCellule.add(btRadio2);
			paneCellule.add(btRadio3);
			paneCellule.add(btRadio4);
			paneCellule.add(btRadio5);
			paneCellule.add(btRadio6);
			paneCellule.add(btRadio7);
			paneCellule.add(btRadio8);
			paneCellule.add(btRadio9);
			
			rubrique1.add(LabelChooseType,BorderLayout.NORTH);
			rubrique1.add(paneCellule,BorderLayout.NORTH);
			
			
			//choisir la sphericite
			
			
			rubrique2.setPreferredSize(new Dimension(1200,100));
			rubrique2.setBackground(Color.white);
			
			
			
			paneSphere.setLayout(new GridLayout(1,4));
			paneSphere.setBackground(Color.white);
			paneSphere.setPreferredSize(new Dimension(300,30));
			

			
		    
		    sliderDisplay2.setText("Value of slider");
		    sliderDisplay2.setPreferredSize(new Dimension(100,30));
		    sliderDisplay2.setForeground(Color.BLUE);
		    
		    
		    slider2.setMajorTickSpacing(50);
		    slider2.setMinorTickSpacing(1);
		    slider2.setPaintTicks(true);
		    slider2.setPaintLabels(true);
		    
		    slider.addChangeListener(this);
		    slider2.addChangeListener(this);

		    slider3.addChangeListener(this);

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
			   
			rubrique3.setPreferredSize(new Dimension(1200,100));
			rubrique3.setBackground(Color.white);
			
			paneArea.setLayout(new GridLayout(1,4));
			paneArea.setBackground(Color.white);
			paneArea.setPreferredSize(new Dimension(300,30));
			

		    sliderDisplay.setText("Value of slider");
		    sliderDisplay.setPreferredSize(new Dimension(100,30));
		    sliderDisplay.setForeground(Color.BLUE);

		    slider.setMajorTickSpacing(50);
		    slider.setMinorTickSpacing(1);
		    slider.setPaintTicks(true);
		    slider.setPaintLabels(true);

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
			   
		rubrique4.setPreferredSize(new Dimension(1200,100));
		rubrique4.setBackground(Color.white);

		paneBorder.setLayout(new GridLayout(1,4));
		paneBorder.setBackground(Color.white);
		paneBorder.setPreferredSize(new Dimension(300,30));
					

		sliderDisplay3.setText("Value of slider");
		sliderDisplay3.setPreferredSize(new Dimension(100,30));
	    sliderDisplay3.setForeground(Color.BLUE);
	    
		slider3.setMajorTickSpacing(50);
		slider3.setMinorTickSpacing(1);
	    slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
	
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
				
	    paneEnd.setPreferredSize(new Dimension(1200,100));
	    paneEnd.setBackground(Color.white);
	    
		btOk.addActionListener(this);
	  
	    btApply.addActionListener(this);
	    
	    
	    paneEnd.add(btOk,BorderLayout.WEST);
	    paneEnd.add(btApply,BorderLayout.WEST);
	    
			panel.add(rubrique1);
			panel.add(rubrique2);
			panel.add(rubrique3);
			panel.add(rubrique4);
			panel.add(paneEnd,BorderLayout.SOUTH);
						
		}
	
	public void stateChanged(ChangeEvent event) {
		System.out.println("Slider");
	       if(event.getSource() == slider3){
	                sliderDisplay3.setText(String.valueOf(slider3.getValue()));
	            }
	       
		    
	       if(slider == event.getSource()){
	                sliderDisplay.setText(String.valueOf(slider.getValue()));
	            }
	       if(slider2 == event.getSource()){

	                sliderDisplay2.setText(String.valueOf(slider2.getValue()));
	            }
	        
	        
		
	}
		public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	            	b=button.getText();
	                return b;
	                //System.out.println(button.getText());
	            }
	        }

	        return b;
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btOk ){
			this.setVisible(false);
			}
			//if(e.getSource() == btApply){
		       //fr.request.setText(getSelectedButtonText(g));//retourne la cellule selectionner
				
				
			//}
			
		}
			
			
		
		

	}


