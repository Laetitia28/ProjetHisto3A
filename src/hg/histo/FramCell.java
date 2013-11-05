package hg.histo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.view.mxGraph;

public class FramCell extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	private String param = "white";

	private String img_default = "src/ressources/image0046.jpg";
	private String path_image = img_default;
	private String path_excel_default = "src/ressources/image0046.csv";
	private String path_current = path_excel_default;
	private JCheckBox checkAll;
	private JCheckBox check_Tumor;
	private JCheckBox check_Granulocyte_nucleus;
	private JCheckBox checkNucleus1;
	private JCheckBox checkNucleus2;
	private JCheckBox checkNucleus3;
	Menu menu=new Menu();
	JPanel down = new JPanel(new GridLayout(0,1));
	JPanel optionBox = new JPanel();
	JPanel buttonBar = new JPanel();
	JButton btZoomToFit = new JButton("Zoom Off");
	JButton btDisplay=new JButton("Display");

	mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
	mxGraphComponent graphComponent ;

	SearchFile searchFile ;

	List<Cell> listCells;

	ImageIcon img = new ImageIcon(img_default);
	public FramCell() {

		super("Frame Cell!");
		listCells = new ArrayList<Cell>();

		graphComponent = new mxGraphComponent(graph);
		graphComponent.setBounds(0, 0, (int)(img.getIconWidth()*0.4), (int)(img.getIconHeight()*0.4));

		graphComponent.setPreferredSize(new Dimension( (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4)));

		graphComponent.setGridVisible(true);
		graphComponent.setGridColor(Color.BLACK);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);

		graph.setCellsCloneable(false);
		graph.setCellsDeletable(false);
		graph.setCellsMovable(false);
		graph.setCellsSelectable(false);
		graph.setCellsResizable(false);

		listCells = setListCell(path_current);

		optionBox.setLayout(new BorderLayout());   	
		//buttonBar.setLayout(new FlowLayout());

		buttonBar.add(btZoomToFit);



		//Zoom out graph
		final mxGraphOutline graphOutline = new mxGraphOutline(graphComponent);
		graphOutline.setPreferredSize(new Dimension(150, 150));
		optionBox.add(graphOutline, BorderLayout.NORTH);



		//Check Box 
		Border border = BorderFactory.createTitledBorder("Selected Cell");
		down.setBorder(border);
		down.setBackground(Color.BLUE);
		down.setBounds(0, 200, 150, 200);
		down.setOpaque(true);

		//creation des checkbox
		checkAll = new JCheckBox("All cells");
		checkAll.setSelected(true);
		down.add(checkAll);

		check_Tumor = new JCheckBox("Tumor nucleus");
		check_Tumor.setSelected(false);
		down.add(check_Tumor);

		check_Granulocyte_nucleus = new JCheckBox("Granulocyte nucleus");
		check_Granulocyte_nucleus.setSelected(false);
		down.add(check_Granulocyte_nucleus);

		checkNucleus1 = new JCheckBox("Nucleus1");
		checkNucleus1.setSelected(false);
		down.add(checkNucleus1);

		checkNucleus2 = new JCheckBox("Nucleus2");
		checkNucleus2.setSelected(false);
		down.add(checkNucleus2);

		checkNucleus3 = new JCheckBox("Nucleus2");
		checkNucleus3.setSelected(false);
		down.add(checkNucleus3);

		//Ada ButtonDisplay in  down  JPanel
		down.add(btDisplay,BorderLayout.CENTER);

		//Ada JPanel down ie check box in OptionBox JPanel
		optionBox.add(down);
		optionBox.add(buttonBar,BorderLayout.CENTER);//because Zoom is on NORTH


		getContentPane().add(optionBox, BorderLayout.EAST);

		setJMenuBar(menu.buildMenu());

		//Add ActionListener elements				
		menu.getExit().addActionListener(this);
		menu.getImage_hidden().addActionListener(this);
		menu.getImage().addActionListener(this);
		menu.getOpen().addActionListener(this);
		menu.getAddCell().addActionListener(this);
		menu.getChangeColor().addActionListener(this);
		btZoomToFit.addActionListener(this);
		btDisplay.addActionListener(this);
		
		getContentPane().add(graphComponent);

	}


	public void initFrame(){
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
		graphComponent.setBackgroundImage(new ImageIcon("src/ressources/image0046.jpg"));			
		ImageIcon img = new ImageIcon(img_default);
		img = scale(img_default, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
		graphComponent.setBackgroundImage(img);			
		
		getContentPane().add(graphComponent, BorderLayout.CENTER);
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
		graph.setCellsDeletable(true);
		this.graph.removeCells(this.graph.getChildVertices(this.parent));
		graph.refresh();
		graph.setCellsDeletable(false);
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
		getContentPane().add(graphComponent, BorderLayout.CENTER);

	}
	public void displaySelectedCells(String nameSelected){
		graph.getModel().beginUpdate();
		try
		{
			for (Cell c : listCells) {
				if(c.getClass_name().equals(nameSelected)){
					ColorCell(c);
					Object v2 = graph
							.insertVertex(parent, null, c.getClass_name(),
									c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
									"shape=ellipse;per=ellipsePerimeter;fillColor="
											+ param);
				}
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}

	}
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == menu.getExit() ){
			FramCell.this.setVisible(false);
		}
		if(e.getSource() == menu.getImage_hidden()){
			graphComponent.setBackgroundImage(new ImageIcon("src/ressources/Back_White.png"));			
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}
		if(e.getSource() == menu.getImage()){
			//display or remove image 
			ImageIcon img = new ImageIcon(path_image);
			img = scale(path_image, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
			graphComponent.setBackgroundImage(img);			
			getContentPane().add(graphComponent);
			graphComponent.refresh();
		}
		if(e.getSource() == menu.getOpen()){

			JFileChooser chooser = new JFileChooser();

			chooser.setApproveButtonText("Choose File..."); // intitulé du
			// bouton
			chooser.showOpenDialog(null); // affiche la boite de dialogue
			path_current = chooser.getSelectedFile().getAbsolutePath();
			System.out.println("Path selected current : " + path_current);

			StringTokenizer st = new StringTokenizer(path_current, "."); 

			while (st.hasMoreTokens()) { 

				//System.out.println("token:"+st.nextToken()); 

				String path_initial = st.nextToken();
				System.out.println("path_initial : " + path_initial); 

				String ext=st.nextToken();
				System.out.println("ext : " + ext);

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
						JOptionPane.showMessageDialog(graphComponent, "File .jpn  found ! Name is :"+path_image,"avertissement",
								JOptionPane.WARNING_MESSAGE);
						FramCell.this.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(graphComponent, "File .jpn not found ! Default image is image0046 ",
								"avertissement",
								 JOptionPane.ERROR_MESSAGE);
						System.out.println("Ko not found .jpg ");
						path_image = img_default;
						FramCell.this.setVisible(true);
					}

					//if .cvs is found then display new graph
					System.out.println("path using with change Frame"+ path_current);
					changeFrame(path_current);

				}

				else if (!ext.equals("csv")){
					System.out.println("Ceci n'est pas un bon fichier ");

					JOptionPane.showMessageDialog(graphComponent, "File choosen is not expected",
							"avertissement",
							JOptionPane.ERROR_MESSAGE);
					FramCell.this.setVisible(false);


				}

			} 

		}
		if(e.getSource() == btZoomToFit){

			double newScale = 1;

			Dimension graphSize = graphComponent.getGraphControl().getSize();

			Dimension viewPortSize = graphComponent.getViewport().getSize();

			int gw = (int) graphSize.getWidth();
			int gh = (int) graphSize.getHeight();
			System.out.println("size graphSize : " + gw);
			System.out.println("size graphSize : " + gh);

			System.out.println("size viewPortSize : " + (int) viewPortSize.getWidth());
			System.out.println("size viewPortSiee : " + (int) viewPortSize.getHeight());

			if (gw > 0 && gh > 0) {
				int w = (int) viewPortSize.getWidth();
				int h = (int) viewPortSize.getHeight();
				newScale = Math.min((double) w / gw, (double) h / gh);
			}
			graphComponent.zoom(newScale);
			graphComponent.getGraphControl().scrollRectToVisible(new Rectangle(0,0,0,0));
		}
		if(e.getSource() == btDisplay){
			graph.setCellsDeletable(true);
			this.graph.removeCells(this.graph.getChildVertices(this.parent));
			graph.refresh();
			graph.setCellsDeletable(false);
			if(checkAll.isSelected()){
				changeFrame(path_current);
			}
			if(check_Tumor.isSelected()){
				System.out.println("check_Tumor selected");
				displaySelectedCells("Tumor nucleus");
			}
			if(check_Granulocyte_nucleus.isSelected()){
				System.out.println("Granulocyte nucleus selected");
				displaySelectedCells("Granulocyte nucleus");
			}
			if(checkNucleus1.isSelected()){
				System.out.println("les checkNucleus1 sont selectionnee");
			}
			if(checkNucleus2.isSelected()){
				System.out.println("les checkNucleus2 sont selectionnee");
			}
			if(checkNucleus3.isSelected()){
				System.out.println("les checkNucleus3 sont selectionnee");
			}
		}
		if(e.getSource() == menu.getAddCell()){
			JOptionPane.showMessageDialog(graphComponent, "File choosen is not expected",
					"avertissement",
					JOptionPane.WARNING_MESSAGE);
			FramCell.this.setVisible(false);
		}
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
			setListCell(path_excel_default);
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
