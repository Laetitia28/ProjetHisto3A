package hg.histo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.view.mxGraph;

public class FramCell extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	private String param = "white";
	
	private String img_default = "src/ressources/image0046.jpg";
	private String path_image = img_default;
	private String excel_default = "src/ressources/image0046.csv";
	Menu menu=new Menu();
	JPanel optionBox = new JPanel();
	JPanel buttonBar = new JPanel();
	JButton btZoomToFit = new JButton("Zoom Off");

	mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
	mxGraphComponent graphComponent ;
	AlertView alertview = new AlertView();
	SearchFile searchFile ;

	List<Cell> listCells;

	public FramCell() {

		super("Frame Cell!");
		listCells = new ArrayList<Cell>();
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setGridVisible(true);
		graphComponent.setGridColor(Color.BLACK);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);

		graph.setCellsCloneable(false);
		graph.setCellsDeletable(false);
		graph.setCellsMovable(false);
		graph.setCellsSelectable(false);
		graph.setCellsResizable(false);



		optionBox.setLayout(new BorderLayout());
		buttonBar.setLayout(new FlowLayout());
	
		buttonBar.add(btZoomToFit);
		
		 final mxGraphOutline graphOutline = new mxGraphOutline(graphComponent);
	        graphOutline.setPreferredSize(new Dimension(150, 150));
	        optionBox.add(graphOutline, BorderLayout.NORTH
	        		);
	        
	    	btZoomToFit.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent arg0) {

	                double newScale = 1;

	                Dimension graphSize = graphComponent.getGraphControl().getSize();
	                Dimension viewPortSize = graphComponent.getViewport().getSize();

	                int gw = (int) graphSize.getWidth();
	                int gh = (int) graphSize.getHeight();

	                if (gw > 0 && gh > 0) {
	                    int w = (int) viewPortSize.getWidth();
	                    int h = (int) viewPortSize.getHeight();

	                    newScale = Math.min((double) w / gw, (double) h / gh);
	                }

	                graphComponent.zoom(newScale);

	            }
	        });
		optionBox.add(buttonBar,BorderLayout.CENTER);
		getContentPane().add(optionBox, BorderLayout.EAST);

		setJMenuBar(menu.buildMenu());

		menu.getExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				FramCell.this.setVisible(false);
			}

		});
		menu.getOpen().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();// cr�ation dun

				chooser.setApproveButtonText("Choose File..."); // intitul� du
				// bouton
				chooser.showOpenDialog(null); // affiche la boite de dialogue
				String path = chooser.getSelectedFile().getAbsolutePath();
				System.out.println("Path selected : " + path);

				StringTokenizer st = new StringTokenizer(path, "."); 

				while (st.hasMoreTokens()) { 

					//System.out.println("token:"+st.nextToken()); 

					String path_initial = st.nextToken();
					System.out.println("path : " + path_initial); 

					String ext=st.nextToken();
					System.out.println("ext : " + ext);

					/*String path_initial = st.nextToken();
					System.out.println("token : " + path_initial); 

					String ext = st.nextToken();
					System.out.println("extention : " + ext); */



					if(ext.equals("csv")){
						System.out.println("Ceci est un bon fichier ");
						System.out.println(ext);

						//remplace .cvs to jpg
						String newPath1=ext.replace(ext.charAt(0), 'j');
						String newPath2=newPath1.replace(ext.charAt(1), 'p');
						String newPath3=newPath2.replace(ext.charAt(2), 'g');

						// creation de path.jpg
						path_image = path_initial +"."+ newPath3;

						System.out.println("path_image " + path_image);

						// aller chercher path.jpg dans le dossier

						searchFile = new SearchFile(path_image);
						boolean found = searchFile.searchFileImage(searchFile.name, searchFile.filePath);
						if (found ){
							System.out.println("ok found file .jpg ");
							JOptionPane.showMessageDialog(graphComponent, "File .jpn  found ! Name is :"+path_image,
									"avertissement",
									JOptionPane.WARNING_MESSAGE);
							FramCell.this.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(graphComponent, "File .jpn not found ! Default image is image0046 ",
									"avertissement",
									JOptionPane.WARNING_MESSAGE);
							System.out.println("Ko not found .jpg ");
							path_image = img_default;
							FramCell.this.setVisible(true);
						}

						//if .cvs is found then display new graph
						System.out.println("path using with change Frame"+ path);
						changeFrame(path);
						
					}

					else if (!ext.equals("csv")){
						System.out.println("Ceci n'est pas un bon fichier ");

						JOptionPane.showMessageDialog(graphComponent, "File choosen is not expected",
								"avertissement",
								JOptionPane.WARNING_MESSAGE);
						FramCell.this.setVisible(false);


					}

				} 

			}


		});
		 menu.getImage().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//display or remove image 
				ImageIcon img = new ImageIcon(path_image);
				img = scale(path_image, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
				graphComponent.setBackgroundImage(img);			
				getContentPane().add(graphComponent);
				graphComponent.refresh();

			}
		});
		 menu.getImage_hidden().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//display or remove image 
					
					graphComponent.setBackgroundImage(new ImageIcon("src/ressources/Back_White.png"));			

					
					getContentPane().add(graphComponent);
					graphComponent.refresh();
					
				}
			});


	}

	
	public void initFrame(){
		listCells = setListCell(excel_default);
		graph.getModel().beginUpdate();

		try

		{
			for (Cell c : listCells) {
				ColorCell(c);
				Object v1 = graph
						.insertVertex(parent, null, c.getClass_name(),
								c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
								"shape=ellipse;per=ellipsePerimeter;fillColor="
										+ param);
			}
		} finally {
			graph.getModel().endUpdate();
		}

		//display background

		ImageIcon img = new ImageIcon(img_default);
		img = scale(img_default, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
		graphComponent.setBackgroundImage(img);			


		getContentPane().add(graphComponent);

	}
	public static ImageIcon scale(String source, int width, int height) {

		ImageIcon icon = new ImageIcon(source);
		Image imag = icon.getImage();
		BufferedImage bi = new BufferedImage(imag.getWidth(null), imag.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(imag, 0, 0, width, height, null);
		ImageIcon newIcon = new ImageIcon(bi);
		return newIcon;
	}
	public void changeFrame(String path){


		this.graph.removeCells(this.graph.getChildVertices(this.parent));
		graph.refresh();
		listCells.clear();
		listCells = setListCell(path);

		graph.getModel().beginUpdate();

		try
		{
			for (Cell c : listCells) {
				ColorCell(c);
				Object v2 = graph
						.insertVertex(parent, null, c.getClass_name(),
								c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
								"shape=ellipse;per=ellipsePerimeter;fillColor="
										+ param);
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		//display background

				ImageIcon img = new ImageIcon(path_image);
				img = scale(path_image, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
				graphComponent.setBackgroundImage(img);	
		getContentPane().add(graphComponent,BorderLayout.CENTER);

	}
	public List<Cell> setListCell(String path){


		File myFile = new File(path);
		FillCellWithCSV f;
		try {
			f = new FillCellWithCSV(myFile);
			List<Cell> listcells = f.allCells();
			return listcells;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setListCell(excel_default);
		}
		return null;



	}
	public void ColorCell(Cell c) {
		if (c.getClass_name().equals("Tumor nucleus")) {

			param = "red";
			// System.out.println(param);
		} else if (c.getClass_name().equals("Granulocyte nucleus")) {
			param = "yellow";
			// System.out.println(param);
		} else if (c.getClass_name().equals("Lymphocyte Nucleus")) {
			param = "green";
			// System.out.println(param);
		} else if (c.getClass_name().equals("Nucleus DAB+ PRD+")) {
			param = "black";
			// System.out.println(param);
		} else if (c.getClass_name().equals("Nucleus DAB+")) {
			param = "blue";
			// System.out.println(param);
		} else {
			param = "white";
			// System.out.println(param);
		}

	}
}
