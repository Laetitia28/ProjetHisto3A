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
import javax.swing.JCheckBox;
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
	

		private static final long serialVersionUID = 123456L;
		
		private JLabel LabelChooseType = new JLabel("Choose your Cellule"); 
		private JLabel Sphericity = new JLabel("Choose your Spherecity");
		private JLabel Area  = new JLabel("Choose your Area");
		private JLabel Border= new JLabel("Choose your Border");

		
		private JPanel panel =  new JPanel();
		private JPanel paneCellule = new JPanel();
		private JPanel paneSphere = new JPanel();
		private JPanel paneSphere2 = new JPanel();
		private JPanel paneArea = new JPanel();
		private JPanel paneArea2 = new JPanel();
		private JPanel paneBorder = new JPanel();
		private JPanel paneBorder2 = new JPanel();
		private JPanel paneEnd = new JPanel();
		
		
		private JButton btFinish=new JButton("Finish");
		private JButton btApply=new JButton("Apply");

		//private JButton btSupSphericity = new JButton("Sup");
		//private JButton btInfSphericity = new JButton("Inf");
		private JCheckBox btSupSphericity = new JCheckBox("Sup");
	    private JCheckBox btInfSphericity = new JCheckBox("Inf");
		private JButton btEt = new JButton("ET");
		private JButton btOu = new JButton("OU");
		
		//private JButton btSupArea =new JButton("Sup");
		//private JButton btInfArea=new JButton("Inf");
		private JCheckBox btSupArea = new JCheckBox("Sup");
		private JCheckBox btInfArea = new JCheckBox("Inf");

		private JButton btEt2=new JButton("ET");
		private JButton btOu2=new JButton("OU");
		
		//private JButton btSupBorder=new JButton("Su");
		//private JButton btInfBorder=new JButton("In");
		private JCheckBox btSupBorder=new JCheckBox("Sup");
		private JCheckBox btInfBorder=new JCheckBox("Inf");
		private JButton btEtBorder=new JButton("ET");
		private JButton btOuBorder=new JButton("OU");
		
		
		private JSlider sliderSphericitySup =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		private JSlider sliderSphericityInf =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
        private JSlider sliderAreaSup =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
        private JSlider sliderAreaInf =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		private JSlider sliderBorderSup =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		private JSlider sliderBorderInf =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);

		
	    

		private JTextField sliderDisplaySphericitySup = new JTextField();
		private JTextField sliderDisplaySphericityInf = new JTextField();
		private JTextField sliderDisplayAreaSup =new JTextField();
		private JTextField sliderDisplayAreaInf =new JTextField();
		private JTextField sliderDisplayBorderSup =new JTextField();
		private JTextField sliderDisplayBorderInf =new JTextField();
		
		private JPanel rubrique1 = new JPanel();//contient les cellules
		private JPanel rubrique2 = new JPanel();
		private JPanel rubrique3 = new JPanel();
		private JPanel rubrique4 = new JPanel();
		
		
		
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
		private JRadioButton btRadio7 = new JRadioButton("Nucleus DAB+");
		private JRadioButton btRadio8 = new JRadioButton("OO");
		private JRadioButton btRadio9 = new JRadioButton("NN");
	
	    
		private String stringResultOfRequest = "empty";
		private String stringAreaSup = "0";
		private String stringAreaInf = "250";

		
	public RequestFram (){

		this.setSize(500, 500);
		
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
			
			
			//choisir la surface
			
			
			rubrique2.setPreferredSize(new Dimension(1200,100));
			rubrique2.setBackground(Color.white);

			paneArea.setLayout(new GridLayout(1,3));
			paneArea.setBackground(Color.white);
			paneArea.setPreferredSize(new Dimension(400,50));
			paneArea2.setLayout(new GridLayout(1,3));
			paneArea2.setBackground(Color.white);
			paneArea2.setPreferredSize(new Dimension(400,50));
						

			sliderDisplayAreaSup.setText("Value of sup");
			sliderDisplayAreaSup.setPreferredSize(new Dimension(100,30));
		    sliderDisplayAreaSup.setForeground(Color.BLUE);
		    sliderDisplayAreaInf.setText("Value of inf");
			sliderDisplayAreaInf.setPreferredSize(new Dimension(100,30));
		    sliderDisplayAreaInf.setForeground(Color.BLUE);
		    
			sliderAreaSup.setMajorTickSpacing(50);
			sliderAreaSup.setMinorTickSpacing(1);
		    sliderAreaSup.setPaintTicks(true);
			sliderAreaSup.setPaintLabels(true);
			
			sliderAreaInf.setMajorTickSpacing(50);
			sliderAreaInf.setMinorTickSpacing(1);
		    sliderAreaInf.setPaintTicks(true);
			sliderAreaInf.setPaintLabels(true);
		
			
			 sliderAreaSup.addChangeListener(this);
			 sliderAreaInf.addChangeListener(this);
		
			   sliderDisplayAreaSup.addKeyListener(new KeyAdapter(){
		            @Override
		            public void keyReleased(KeyEvent ke) {
		                String typed = sliderDisplayAreaSup.getText();
		                sliderAreaSup.setValue(0);
		                if(!typed.matches("\\d+")) {
		                    return;
		                }
		                int value = Integer.parseInt(typed);
		                sliderAreaSup.setValue(value);
		            }
		        });
			    sliderDisplayAreaInf.addKeyListener(new KeyAdapter(){
		            @Override
		            public void keyReleased(KeyEvent ke) {
		                String typed = sliderDisplayAreaInf.getText();
		                sliderAreaInf.setValue(0);
		                if(!typed.matches("\\d+")) {
		                    return;
		                }
		                int value = Integer.parseInt(typed);
		                sliderAreaInf.setValue(value);
		            }
		        });
			    
			    
			paneArea.add(btSupArea,BorderLayout.WEST);
			paneArea.add(sliderAreaSup);
			paneArea.add(sliderDisplayAreaSup);
			paneArea2.add(btInfArea,BorderLayout.WEST);
			paneArea2.add(sliderAreaInf);
			paneArea2.add(sliderDisplayAreaInf);
						
			rubrique2.add(Area,BorderLayout.NORTH);
			rubrique2.add(paneArea);
			rubrique2.add(paneArea2);
		

			
			//choisir la sphericité
			   
			rubrique3.setPreferredSize(new Dimension(1200,100));
			rubrique3.setBackground(Color.white);
			
			paneSphere.setLayout(new GridLayout(1,3));
			paneSphere.setBackground(Color.white);
			paneSphere.setPreferredSize(new Dimension(400,50));
			paneSphere2.setLayout(new GridLayout(1,3));
			paneSphere2.setBackground(Color.white);
			paneSphere2.setPreferredSize(new Dimension(400,50));
			

		    sliderDisplaySphericitySup.setText("Value of slider");
		    sliderDisplaySphericitySup.setPreferredSize(new Dimension(100,30));
		    sliderDisplaySphericitySup.setForeground(Color.BLUE);
		    sliderDisplaySphericityInf.setText("Value of slider");
		    sliderDisplaySphericityInf.setPreferredSize(new Dimension(100,30));
		    sliderDisplaySphericityInf.setForeground(Color.BLUE);

		    sliderSphericitySup.setMajorTickSpacing(50);
		    sliderSphericitySup.setMinorTickSpacing(1);
		    sliderSphericitySup.setPaintTicks(true);
		    sliderSphericitySup.setPaintLabels(true);
		    
		    
		    sliderSphericityInf.setMajorTickSpacing(50);
		    sliderSphericityInf.setMinorTickSpacing(1);
		    sliderSphericityInf.setPaintTicks(true);
		    sliderSphericityInf.setPaintLabels(true);
		    
		    sliderSphericityInf.addChangeListener(this);
			 sliderSphericitySup.addChangeListener(this);


		    sliderDisplaySphericitySup.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplaySphericitySup.getText();
	                sliderSphericitySup.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                sliderSphericitySup.setValue(value);
	            }
	        });
		    sliderDisplaySphericityInf.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplaySphericityInf.getText();
	                sliderSphericityInf.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                sliderSphericityInf.setValue(value);
	            }
	        });
		    
		    
			paneSphere.add(btSupSphericity,BorderLayout.WEST);
			paneSphere.add(sliderSphericitySup);
			paneSphere.add(sliderDisplaySphericitySup);
			paneSphere2.add(btInfSphericity,BorderLayout.WEST);
			paneSphere2.add(sliderSphericityInf);
			paneSphere2.add(sliderDisplaySphericityInf);
			
			rubrique3.add(Sphericity,BorderLayout.NORTH);
			rubrique3.add(paneSphere);
			rubrique3.add(paneSphere2);
		
		
			
			//choisir Border
			   
		rubrique4.setPreferredSize(new Dimension(1200,100));
		rubrique4.setBackground(Color.white);

		paneBorder.setLayout(new GridLayout(1,3));
		paneBorder.setBackground(Color.white);
		paneBorder.setPreferredSize(new Dimension(400,50));
		paneBorder2.setLayout(new GridLayout(1,3));
		paneBorder2.setBackground(Color.white);
		paneBorder2.setPreferredSize(new Dimension(400,50));
					

		sliderDisplayBorderSup.setText("Value of sup");
		sliderDisplayBorderSup.setPreferredSize(new Dimension(100,30));
	    sliderDisplayBorderSup.setForeground(Color.BLUE);
	    sliderDisplayBorderInf.setText("Value of inf");
		sliderDisplayBorderInf.setPreferredSize(new Dimension(100,30));
	    sliderDisplayBorderInf.setForeground(Color.BLUE);
	    
		sliderBorderSup.setMajorTickSpacing(50);
		sliderBorderSup.setMinorTickSpacing(1);
	    sliderBorderSup.setPaintTicks(true);
		sliderBorderSup.setPaintLabels(true);
		
		sliderBorderInf.setMajorTickSpacing(50);
		sliderBorderInf.setMinorTickSpacing(1);
	    sliderBorderInf.setPaintTicks(true);
		sliderBorderInf.setPaintLabels(true);
	
		
		 sliderBorderSup.addChangeListener(this);
		 sliderBorderInf.addChangeListener(this);
	
		   sliderDisplayBorderSup.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplayBorderSup.getText();
	                sliderBorderSup.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                sliderBorderSup.setValue(value);
	            }
	        });
		    sliderDisplayBorderInf.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplayBorderInf.getText();
	                sliderBorderInf.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                sliderBorderInf.setValue(value);
	            }
	        });
		    
		    
		paneBorder.add(btSupBorder,BorderLayout.WEST);
		paneBorder.add(sliderBorderSup);
		paneBorder.add(sliderDisplayBorderSup);
		paneBorder2.add(btInfBorder,BorderLayout.WEST);
		paneBorder2.add(sliderBorderInf);
		paneBorder2.add(sliderDisplayBorderInf);
					
		rubrique4.add(Border,BorderLayout.NORTH);
		rubrique4.add(paneBorder);
		rubrique4.add(paneBorder2);
	
				
	    paneEnd.setPreferredSize(new Dimension(1200,100));
	    paneEnd.setBackground(Color.white);
	    
	    
	    
	    btFinish.addActionListener(this);
	    btApply.addActionListener(this);
	    btInfArea.addActionListener(this);
	    btSupArea.addActionListener(this);
	    
	    paneEnd.add(btFinish,BorderLayout.WEST);
	    paneEnd.add(btApply,BorderLayout.WEST);
	    
			panel.add(rubrique1);
			panel.add(rubrique2);
			panel.add(rubrique3);
			panel.add(rubrique4);
			panel.add(paneEnd,BorderLayout.SOUTH);
						
		}
	
	public void stateChanged(ChangeEvent event) {
	       if(event.getSource() == sliderBorderSup){
	                sliderDisplayBorderSup.setText(String.valueOf(sliderBorderSup.getValue()));
	        		System.out.println("Border : " + String.valueOf(sliderBorderSup.getValue()));

	            }
	       if(event.getSource() == sliderBorderInf){
               sliderDisplayBorderInf.setText(String.valueOf(sliderBorderInf.getValue()));
       		System.out.println("Border : " + String.valueOf(sliderBorderInf.getValue()));

           }
	       
		    
	       if( event.getSource() == sliderSphericitySup){
	                sliderDisplaySphericitySup.setText(String.valueOf(sliderSphericitySup.getValue()));
	        		System.out.println("Sphéericity : " + String.valueOf(sliderSphericitySup.getValue()));

	            }
	       
	       if( event.getSource() == sliderSphericityInf ){
               sliderDisplaySphericityInf.setText(String.valueOf(sliderSphericityInf.getValue()));
       		System.out.println("Sphéericity : " + String.valueOf(sliderSphericityInf.getValue()));

           }
	       if(sliderAreaSup == event.getSource()){

	                sliderDisplayAreaSup.setText(String.valueOf(sliderAreaSup.getValue()));
	        		System.out.println("Area : " + String.valueOf(sliderAreaSup.getValue()));
	        		/*if(btInfArea.isSelected() ){
						//System.out.println("btInfArea is Selected : ");
						this.stringAreaInf = String.valueOf(sliderAreaInf.getValue());
						System.out.println("InfArea is : "+this.stringAreaInf);

					}
	        		if(btSupArea.isSelected()){
						this.stringAreaSup = String.valueOf(sliderAreaSup.getValue());
						System.out.println("SupArea is  : "+this.stringAreaSup);
	
					}*/

	            }
	       if(sliderAreaInf == event.getSource()){

              sliderDisplayAreaInf.setText(String.valueOf(sliderAreaInf.getValue()));
       		System.out.println("Area : " + String.valueOf(sliderAreaInf.getValue()));
       		

           }
	        
	        
		
	}
		public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	            	stringResultOfRequest=button.getText();
	                System.out.println(button.getText());

	                return stringResultOfRequest;
	            }
	        }

	        return stringResultOfRequest;
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btFinish ){
				System.out.println("It is finish !");
				this.setVisible(false);
			}
	
			if(e.getSource() == btApply ){
				System.out.println("It is apply !");
				if(btSupArea.isSelected()){
					System.out.println("btSupArea is Selected : ");
					System.out.println("Sup Area : "+ this.stringAreaSup);
				}
				else
				{
					 this.stringAreaSup = "0";
					 System.out.println("Sup Area : "+ this.stringAreaSup);

				}
				if(btInfArea.isSelected()){
					System.out.println("btInfArea is Selected : ");
					System.out.println("Inf Area : "+ this.stringAreaInf);
				}
				else
				{
					 this.stringAreaSup = "250";
					 System.out.println("Inf Area : "+ this.stringAreaInf);

				}
				
				this.setVisible(true);
			}
			if(e.getSource() == btSupArea ){
				
				if(btSupArea.isSelected()){
					System.out.println("btSupArea is Selected : ");
					this.stringAreaSup = sliderDisplayAreaSup.getText();

				}
			}
			if(e.getSource() == btInfArea ){
				
				if(btInfArea.isSelected()){
					System.out.println("btInfArea is Selected : ");
					this.stringAreaInf = sliderDisplayAreaInf.getText();

				}
			}
			
		}

		public String getStringResultOfRequest() {
			return stringResultOfRequest;
		}

		public void setStringResultOfRequest(String stringResultOfRequest) {
			this.stringResultOfRequest = stringResultOfRequest;
		}

		public String getStringAreaSup() {
			return stringAreaSup;
		}

		public void setStringAreaSup(String stringAreaSup) {
			this.stringAreaSup = stringAreaSup;
		}

		public String getStringAreaInf() {
			return stringAreaInf;
		}

		public void setStringAreaInf(String stringAreaInf) {
			this.stringAreaInf = stringAreaInf;
		}		
	}