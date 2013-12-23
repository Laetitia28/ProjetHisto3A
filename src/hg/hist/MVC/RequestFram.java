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
		private JPanel paneArea = new JPanel();
		private JPanel paneBorder = new JPanel();
		private JPanel paneEnd = new JPanel();
		
		
		private JButton btFinish=new JButton("Finish");
		private JButton btApply=new JButton("Apply");

		private JButton btSupSphericity = new JButton("Sup");
		private JButton btInfSphericity = new JButton("Inf");
		private JButton btEt = new JButton("ET");
		private JButton btOu = new JButton("OU");
		
		//private JButton btSupArea =new JButton("Sup");
		//private JButton btInfArea=new JButton("Inf");
		private JCheckBox btSupArea = new JCheckBox("Sup");
		private JCheckBox btInfArea = new JCheckBox("Inf");

		private JButton btEt2=new JButton("ET");
		private JButton btOu2=new JButton("OU");
		
		private JButton btSupBorder=new JButton("Su");
		private JButton btInfBorder=new JButton("In");
		private JButton btEtBorder=new JButton("ET");
		private JButton btOuBorder=new JButton("OU");
		
		
		private JSlider sliderSphericity =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);

		private JSlider sliderArea =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		private JSlider sliderBorder =new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);

		
	    

		private JTextField sliderDisplaySphericity = new JTextField();
		private JTextField sliderDisplayArea =new JTextField();
		private JTextField sliderDisplayBorder =new JTextField();
		
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
			
			
			//choisir la sphericite
			
			
			rubrique2.setPreferredSize(new Dimension(1200,100));
			rubrique2.setBackground(Color.white);
			
			
			
			paneSphere.setLayout(new GridLayout(1,4));
			paneSphere.setBackground(Color.white);
			paneSphere.setPreferredSize(new Dimension(300,30));
			

			
		    
		    sliderDisplayArea.setText("Value of slider");
		    sliderDisplayArea.setPreferredSize(new Dimension(100,30));
		    sliderDisplayArea.setForeground(Color.BLUE);
		    
		    
		    sliderArea.setMajorTickSpacing(50);
		    sliderArea.setMinorTickSpacing(1);
		    sliderArea.setPaintTicks(true);
		    sliderArea.setPaintLabels(true);
		    
		    sliderSphericity.addChangeListener(this);
		    sliderArea.addChangeListener(this);

		    sliderBorder.addChangeListener(this);

		    sliderDisplayArea.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplayArea.getText();
	                sliderArea.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                sliderArea.setValue(value);
	            }
	        });
			paneSphere.add(btSupArea,BorderLayout.WEST);
			paneSphere.add(btInfArea,BorderLayout.CENTER);
			paneSphere.add(btEt2,BorderLayout.WEST);
			paneSphere.add(btOu2,BorderLayout.CENTER);
			
			//paneSphere.add(slider,BorderLayout.EAST);
			rubrique3.add(Sphericity,BorderLayout.NORTH);
			rubrique3.add(paneSphere,BorderLayout.WEST);
			rubrique3.add(sliderArea);
			rubrique3.add(sliderDisplayArea);
			
			
			
			//choisir la surface
			   
			rubrique3.setPreferredSize(new Dimension(1200,100));
			rubrique3.setBackground(Color.white);
			
			paneArea.setLayout(new GridLayout(1,4));
			paneArea.setBackground(Color.white);
			paneArea.setPreferredSize(new Dimension(300,30));
			

		    sliderDisplaySphericity.setText("Value of slider");
		    sliderDisplaySphericity.setPreferredSize(new Dimension(100,30));
		    sliderDisplaySphericity.setForeground(Color.BLUE);

		    sliderSphericity.setMajorTickSpacing(50);
		    sliderSphericity.setMinorTickSpacing(1);
		    sliderSphericity.setPaintTicks(true);
		    sliderSphericity.setPaintLabels(true);

		    sliderDisplaySphericity.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplaySphericity.getText();
	                sliderSphericity.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                sliderSphericity.setValue(value);
	            }
	        });
		    
		    
			paneArea.add(btSupSphericity,BorderLayout.WEST);
			paneArea.add(btInfSphericity,BorderLayout.CENTER);
			paneArea.add(btEt,BorderLayout.WEST);
			paneArea.add(btOu,BorderLayout.CENTER);
			
			rubrique2.add(Area,BorderLayout.NORTH);
			rubrique2.add(paneArea,BorderLayout.WEST);
			rubrique2.add(sliderSphericity);
			rubrique2.add(sliderDisplaySphericity);
		
			
			//choisir area
			   
		rubrique4.setPreferredSize(new Dimension(1200,100));
		rubrique4.setBackground(Color.white);

		paneBorder.setLayout(new GridLayout(1,4));
		paneBorder.setBackground(Color.white);
		paneBorder.setPreferredSize(new Dimension(300,30));
					

		sliderDisplayBorder.setText("Value of slider");
		sliderDisplayBorder.setPreferredSize(new Dimension(100,30));
	    sliderDisplayBorder.setForeground(Color.BLUE);
	    
		sliderBorder.setMajorTickSpacing(50);
		sliderBorder.setMinorTickSpacing(1);
	    sliderBorder.setPaintTicks(true);
		sliderBorder.setPaintLabels(true);
	
		    sliderDisplayBorder.addKeyListener(new KeyAdapter(){
	            @Override
	            public void keyReleased(KeyEvent ke) {
	                String typed = sliderDisplayBorder.getText();
	                sliderBorder.setValue(0);
	                if(!typed.matches("\\d+")) {
	                    return;
	                }
	                int value = Integer.parseInt(typed);
	                sliderBorder.setValue(value);
	            }
	        });
		    
		    
		paneBorder.add(btSupBorder,BorderLayout.WEST);
		paneBorder.add(btInfBorder,BorderLayout.CENTER);
		paneBorder.add(btEtBorder,BorderLayout.WEST);
		paneBorder.add(btOuBorder,BorderLayout.CENTER);
					
		rubrique4.add(Border,BorderLayout.NORTH);
		rubrique4.add(paneBorder,BorderLayout.WEST);
		rubrique4.add(sliderBorder);
		rubrique4.add(sliderDisplayBorder);
				
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
	       if(event.getSource() == sliderBorder){
	                sliderDisplayBorder.setText(String.valueOf(sliderBorder.getValue()));
	        		System.out.println("Border : " + String.valueOf(sliderBorder.getValue()));

	            }
	       
		    
	       if(sliderSphericity == event.getSource()){
	                sliderDisplaySphericity.setText(String.valueOf(sliderSphericity.getValue()));
	        		System.out.println("Sphéericity : " + String.valueOf(sliderSphericity.getValue()));

	            }
	       if(sliderArea == event.getSource()){

	                sliderDisplayArea.setText(String.valueOf(sliderArea.getValue()));
	        		System.out.println("Area : " + String.valueOf(sliderArea.getValue()));
	        		if(btInfArea.isSelected() ){
						//System.out.println("btInfArea is Selected : ");
						this.stringAreaInf = String.valueOf(sliderArea.getValue());
						System.out.println("InfArea is : "+this.stringAreaInf);

					}
	        		if(btSupArea.isSelected()){
						this.stringAreaSup = String.valueOf(sliderArea.getValue());
						System.out.println("SupArea is  : "+this.stringAreaSup);
	
					}

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
					this.stringAreaSup = sliderDisplayArea.getText();

				}
			}
			if(e.getSource() == btInfArea ){
				
				if(btInfArea.isSelected()){
					System.out.println("btInfArea is Selected : ");
					this.stringAreaInf = sliderDisplayArea.getText();

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


