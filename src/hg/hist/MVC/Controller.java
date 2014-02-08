package hg.hist.MVC;

import hg.histo.Cell;
import hg.histo.FillCellWithCSV;
import hg.histo.SearchFile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class Controller {

	private String img_default = "ressources/image0046.jpg";
	private String path_image = img_default;
	
	private String path_excel_default = "/ressources/image0046.csv";
	private String path_current = path_excel_default;
	
	private String path_initial = "";
	private String color = "black";
	
	
	final double MAX = 0.0;
	final double MIN = 20000.0;
	//Max
	private double maxSphericity = MAX;
	private double maxArea = MAX;
	private double maxBorder = MAX;
	
	//Min
	private double minSphericity = MIN;
	private double minArea = MIN;
	private double minBorder = MIN;
	
	
	private SearchFile searchFile;

	private ImageIcon img ;
	private HashMap<String, String> mapColor = new HashMap<String, String>();

	private List<Cell> listCells;
	//C'est la liste de cellule qui est selectionner dans la fenetre request
	private List<Cell> temp ;

	private String[] listColor = {"red","white","green","black","blue","cyan","darkGray","gray","magenta","orange","pink","yellow"};


	

	public Controller() {

	//	System.out.println(this.getClass().getClassLoader().getResource("ressources/image0046.jpg")==null);
		listCells = new ArrayList<Cell>();
		listCells = setListCell("/ressources/image0046.csv");
		img = new ImageIcon(this.getClass().getClassLoader().getResource("ressources/image0046.jpg"));
		temp = new ArrayList<Cell>();
	}

	public ImageIcon scale(String source, int width, int height) {

		System.out.println("img : "+ source);
		
		if(source.equals("ressources/image0046.jpg")){
			source = this.getClass().getClassLoader().getResource("ressources/image0046.jpg").getFile();
		}
		
		ImageIcon icon = new ImageIcon(source);
		
		Image imag = icon.getImage();
		
		BufferedImage bi = new BufferedImage(imag.getWidth(null),imag.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		
		g.drawImage(imag, 0, 0, width, height, null);
		
		ImageIcon newIcon = new ImageIcon(bi);
		
		return newIcon;
	}
//ok
	public List<Cell> setListCell(String path) {
		System.out.println("pathhee :" +path);
		if(path.equals("/ressources/image0046.csv")){
			path = this.getClass().getResource(path).getFile();
		}

		File myFile = new File(path);
	
		//debug
		    System.out.println(path);
	        System.out.println(myFile.getAbsolutePath());
	        System.out.println(myFile.exists());
	        
		FillCellWithCSV f;
		try {
			f = new FillCellWithCSV(myFile);
			List<Cell> listcells = f.allCells();
			return listcells;
		} catch (IOException e) {
			e.printStackTrace();
			setListCell(path);
		}
		return null;
	}

	public mxGraphComponent changeFrame(String path, mxGraph graph,
			mxGraphComponent graphComponent) {
		graph.setCellsDeletable(true);
		graph.removeCells(graph.getChildVertices(graph.getDefaultParent()));
		graph.refresh();
		graph.setCellsDeletable(false);
		
		this.listCells.clear();

		setMaxArea(MAX);
		setMaxBorder(MAX);
		setMaxSphericity(MAX);
		setMinArea(MIN);
		setMinBorder(MIN);
		setMinSphericity(MIN);

		//change ListCell
		this.listCells = setListCell(path);
		
		//find Max and Min of Boerder,  Area , Sphérictiy
		getMaxMin(this.listCells);
		
		//change map of cell color
		createNewMapColor(this.listCells);
		
		//draw the grpah
		graph.getModel().beginUpdate();
		try {
			for (Cell c : this.listCells) {
				graph.insertVertex(graph.getDefaultParent(), null,
						c.getClass_name(), c.getInner_x() * 0.4,
						c.getInner_y() * 0.4, 10, 10,
						"shape=ellipse;per=ellipsePerimeter;fillColor="
								+ getMapColor().get(c.getClass_name()));
			}
		} finally {
			graph.getModel().endUpdate();
		}
		
		System.out.println("path changeFrame : "+ path);
		if(path.equals("/ressources/image0046.csv")){
			
			ImageIcon img = new ImageIcon(this.getClass().getClassLoader().getResource("ressources/image0046.jpg"));
			img = scale("ressources/image0046.jpg", (int) (img.getIconWidth() * 0.4),
					(int) (img.getIconHeight() * 0.4));
			graphComponent.setBackgroundImage(img);
			
		}
		else {
		// display background
		ImageIcon img = new ImageIcon(getPath_image());
		
		img = scale(path_image, (int) (img.getIconWidth() * 0.4),
				(int) (img.getIconHeight() * 0.4));
		graphComponent.setBackgroundImage(img);
		}
		return graphComponent;
	}

	public void ChangeFile(JFileChooser chooser,mxGraphComponent graphComponent, mxGraph graph) {
		
		int val = chooser.showOpenDialog(chooser);
		
		if(val == JFileChooser.APPROVE_OPTION){
		
			path_current = chooser.getSelectedFile().getAbsolutePath();
		
			System.out.println("Path selected current : " + path_current);

		StringTokenizer st = new StringTokenizer(path_current, ".");

		while (st.hasMoreTokens()) {
			path_initial = st.nextToken();
			System.out.println("path_initial : " + path_initial);
			break;
		}

		System.out.println("path_initial : " + path_initial);
		String extension = "";

		int i = path_current.lastIndexOf('.');
		if (i > 0) {
			extension = path_current.substring(i + 1);
		}

		if (extension.equals("csv")) {
			System.out.println("Ceci est un bon fichier ");
			System.out.println("Ceci est l'extension :" + extension);

			// remplace .cvs to jpg
			String newPath1 = extension.replace(extension.charAt(0), 'j');
			String newPath2 = newPath1.replace(extension.charAt(1), 'p');
			String newPath3 = newPath2.replace(extension.charAt(2), 'g');

			// creation de path.jpg
			System.out.println("path_initial : " + path_initial);
			path_image = path_initial + "." + newPath3;
			
			System.out.println("path_image " + path_image);
			
			// aller chercher path.jpg dans le dossier
			searchFile = new SearchFile(path_image);
			
			boolean found = searchFile.searchFileImage(searchFile.getName(),searchFile.getFilePath());
			
			if (found) {
				System.out.println("I found file .jpg ");
				JOptionPane.showMessageDialog(graphComponent,"File .jpn  found ! Name is :" + path_image,"avertissement", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(graphComponent,
						"File .jpn not found ! Default image is image0046 ","avertissement", JOptionPane.ERROR_MESSAGE);
				System.out.println("Ko not found .jpg ");
				
				path_image = "ressources/images0046.jpg";
			}
			
			// if .cvs is found then display new graph
			System.out.println("path using with change Frame " + path_current);
			
			changeFrame(path_current, graph, graphComponent);
			
		} else if (!extension.equals("csv")) {
			
			System.out.println("Ceci n'est pas un bon fichier ");
			
			JOptionPane.showMessageDialog(graphComponent,"File choosen is not expected", "avertissement",JOptionPane.ERROR_MESSAGE);
		}
		}
		else 
		{
			System.out.println("Open command cancelled by user.\n");
		}
	}

	// }
	//ok
	public double newScale(mxGraphComponent graphComponent) {
		double newScale = 1;

		Dimension graphSize = graphComponent.getGraphControl().getSize();

		Dimension viewPortSize = graphComponent.getViewport().getSize();

		int gw = (int) graphSize.getWidth();
		int gh = (int) graphSize.getHeight();
		System.out.println("size graphSize : " + gw);
		System.out.println("size graphSize : " + gh);

		System.out.println("size viewPortSize : "
				+ (int) viewPortSize.getWidth());
		System.out.println("size viewPortSiee : "
				+ (int) viewPortSize.getHeight());

		if (gw > 0 && gh > 0) {
			int w = (int) viewPortSize.getWidth();
			int h = (int) viewPortSize.getHeight();
			newScale = Math.min((double) w / gw, (double) h / gh);
		}
		return newScale;
	}

	//ok
	public void mapColorCellInit() {
		mapColor.put("Tumor nucleus", "red");
		mapColor.put("Granulocyte nucleus", "pink");
		mapColor.put("Lymphocyte Nucleus", "green");
		mapColor.put("Nucleus DAB+ PRD+", "black");
		mapColor.put("Nucleus DAB+", "blue");
	}

	//ok
	public mxGraphComponent initFrame(mxGraph graph,
			mxGraphComponent graphComponent) {
		graph.getModel().beginUpdate();
		
		// create list of cells
		setListCell("/ressources/image0046.csv");

		// create color of cell
		mapColorCellInit();
		
		//find Max and Min of Border, Area, Sphericity
		getMaxMin(this.listCells);
		
		System.out.println("Max Area : " + getMaxArea() +"Max Border : "+  getMaxBorder()+"Max Shpericity : " + getMaxSphericity());
		System.out.println("Min Area : " + getMinArea() +"Min Border : "+  getMinBorder()+"Min Shpericity : " + getMinSphericity());

		
		try {
			for (Cell c : this.listCells) {
				graph.insertVertex(graph.getDefaultParent(), null,
						c.getClass_name(), c.getInner_x() * 0.4,
						c.getInner_y() * 0.4, 10, 10,
						"shape=ellipse;per=ellipsePerimeter;fillColor="
								+ getMapColor().get(c.getClass_name()));
			}
		} finally {
			graph.getModel().endUpdate();
		}
		// display background
		
		ImageIcon img = new ImageIcon(this.getClass().getClassLoader().getResource("ressources/image0046.jpg"));
		img = scale("ressources/image0046.jpg", (int) (img.getIconWidth() * 0.4),
				(int) (img.getIconHeight() * 0.4));
		graphComponent.setBackgroundImage(img);

		return graphComponent;
		// getContentPane().add(graphComponent, BorderLayout.CENTER);
	}

	//ok
	public void displaySelectedCells(String nameSelected, mxGraph graph) {
		graph.getModel().beginUpdate();
		try {
			for (Cell c : this.listCells) {
				if (c.getClass_name().equals(nameSelected)) {

					graph.insertVertex(graph.getDefaultParent(),
							null, c.getClass_name(), c.getInner_x() * 0.4,
							c.getInner_y() * 0.4, 10, 10,
							"shape=ellipse;per=ellipsePerimeter;fillColor="
									+ getMapColor().get(c.getClass_name()));
				}
			}
		} finally {
			graph.getModel().endUpdate();
		}
	}

	//Add a new color value for a specify type
	public void changeMapColor(String typeCell, String typeColor) {
		for (String type : getMapColor().keySet()) {
			if (typeCell.equals(type)) {
				getMapColor().put(type, typeColor);
			}
		}
	}

	//Create new MapColor when change file 
	public void createNewMapColor(List<Cell> newList) {
		System.out.println("CreateNewMapColor method");
		HashMap<String, String> tmp_map = new HashMap<String, String>();
		
		for(int i = 0 ; i<newList.size();i++){
			tmp_map.put(newList.get(i).getClass_name(), listColor[5]);
			
		}
		HashMap<String, String> unionMap = new HashMap<String, String>();
		
		unionMap.putAll(tmp_map);

		unionMap.putAll(getMapColor());
		
		int i = 0;
		for (String mapKeyUnion : unionMap.keySet()) {
			boolean found = false;
			for (String mapKey : getMapColor().keySet()) {
				if(mapKey.equals(mapKeyUnion)){
					found = true;
				}
			}
			if(found == false){
				unionMap.put(mapKeyUnion, listColor[5+i]);
				i = i+1 ;
			}
		}
		
		//debug
		for (String e : unionMap.keySet()) {
			System.out.println("key : " + e);
			System.out.println("object : " + unionMap.get(e));
		}
		
		setMapColor(unionMap);
	}

	public List<Cell> firstSortListCell(String typeName){
		List<Cell> list_tmp =new ArrayList<Cell>();
	//	System.out.println("type" + typeName);
		for(Cell a : getListCells()){
			//System.out.println(a.getClass_name());
			if(a.getClass_name().equals(typeName)){
				list_tmp.add(a);
			}
		}
		if(list_tmp.isEmpty()){
			list_tmp = getListCells();
		}
		return list_tmp;
	}

	public Color stringToColor(String mrd){
		if(mrd.equals("red")){
			return Color.red;
		}
		else if(mrd.equals("yellow")){
			return Color.yellow;
		}
		else if(mrd.equals("blue")){
			return Color.blue;
		}
		else if(mrd.equals("cyan")){
			return Color.cyan;
		}
		else if(mrd.equals("darkGray")){
			return Color.darkGray;
		}
		else if(mrd.equals("gray")){
			return Color.gray;
		}
		else if(mrd.equals("magenta")){
			return Color.magenta;
		}
		else if(mrd.equals("orange")){
			return Color.orange;
		}
		else if(mrd.equals("pink")){
			return Color.pink;
		}
		else if(mrd.equals("white")){
			return Color.white;
		}
		else if(mrd.equals("green")){
			return Color.green;
		}
		else {
		return Color.black;
		}
	} 
	public void secondSortListCell(double valueBorderSup,
			double valueBorderInf, double valueSphericitySup ,
			double  valueSphericityInf , double valueAreaSup,
			double valueAreaInf, String type,mxGraph graph) {
		
		for (Cell a : firstSortListCell(type)) {
			//debug
			/*
			System.out.println("area "+a.getArea_pxl());
			System.out.println("border "+a.getBorder_Lenght_pxl());
			System.out.println("sphe "+ a.getSphericity());
			*/
				if (a.getBorder_Lenght_pxl() > valueBorderSup
						&& a.getBorder_Lenght_pxl() < valueBorderInf &&
						a.getArea_pxl() > valueAreaSup
						&& a.getArea_pxl() < valueAreaInf &&
						a.getSphericity() > valueSphericitySup
						&& a.getSphericity() < valueSphericityInf) {					
					this.temp.add(a);
					System.out.println("I add in finale list");
				}				
		}
		graph.getModel().beginUpdate();
		try {
			for (Cell c : this.temp) {
					graph.insertVertex(graph.getDefaultParent(),
							null, c.getClass_name(), c.getInner_x() * 0.4,
							c.getInner_y() * 0.4, 10, 10,
							"shape=ellipse;per=ellipsePerimeter;fillColor="
									+ getMapColor().get(c.getClass_name()));
				}
		} finally {
			graph.getModel().endUpdate();
		}
		//return this.temp;
	}

	public void getMaxMin(List<Cell> list){
	    for(int i=0; i<list.size(); i++){
	    	//max
	        if(list.get(i).getSphericity() > getMaxSphericity()){
	            setMaxSphericity(list.get(i).getSphericity());
	        }
	        if(list.get(i).getArea_pxl() > getMaxArea()){
	        	setMaxArea(list.get(i).getArea_pxl());
	        }
	        if(list.get(i).getBorder_Lenght_pxl() > getMaxBorder()){
	            setMaxBorder(list.get(i).getBorder_Lenght_pxl());
	        }
	        //min
	        
	        if(list.get(i).getSphericity() < getMinSphericity()){
	            setMinSphericity(list.get(i).getSphericity());
	        }
	        if(list.get(i).getBorder_Lenght_pxl() < getMinBorder()){
	            setMinBorder(list.get(i).getBorder_Lenght_pxl());
	        }
	        if(list.get(i).getArea_pxl()< getMinArea()){
	        	setMinArea(list.get(i).getArea_pxl());
	        }
	    }
	    
	}
	
	public void neighbourhood(){
	long startTime = System.nanoTime();
	System.out.println("time begin "+startTime+"ns");

	System.out.println("size" + getListCells().size());
	int a = 0; 
	//a ramplacer par une liste deja sort 
	for (Cell lamerde : getListCells()) {
		//System.out.println("type" + lamerde.getClass_name());
		if ((lamerde.getClass_name()).equals("Tumor nucleus")) {
			
			for (Cell merde : getListCells()) {
				if ((Math.abs(merde.getInner_x() - lamerde.getInner_x()) < 3) && (Math.abs(merde.getInner_y() - lamerde.getInner_y()) < 3)) {
					a = a+1;
					System.out.println("in"+a);
				}

			}

		}
	}

	long endTime = System.nanoTime();
	System.out.println("time end "+endTime+"ns");
	long duration = endTime - startTime;
	System.out.println("time duration "+duration*Math.pow(10,-9)+"s");
	
	}
	
	// Getter and Setter
	public List<Cell> getListCells() {
		return listCells;
	}

	public void setListCells(List<Cell> listCells) {
		this.listCells = listCells;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImg_default() {
		return img_default;
	}

	public void setImg_default(String img_default) {
		this.img_default = img_default;
	}

	public String getPath_excel_default() {
		return path_excel_default;
	}

	public void setPath_excel_default(String path_excel_default) {
		this.path_excel_default = path_excel_default;
	}

	public String getPath_current() {
		return path_current;
	}

	public void setPath_current(String path_current) {
		this.path_current = path_current;
	}

	public String getPath_initial() {
		return path_initial;
	}

	public void setPath_initial(String path_initial) {
		this.path_initial = path_initial;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public String getPath_image() {
		return path_image;
	}

	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}

	public HashMap<String, String> getMapColor() {
		return mapColor;
	}

	public void setMapColor(HashMap<String, String> m) {
		this.mapColor = m;
	}

	public List<Cell> getTemp() {
		return temp;
	}

	public void setTemp(List<Cell> temp) {
		this.temp = temp;
	}
	public double getMaxSphericity() {
		return maxSphericity;
	}

	public void setMaxSphericity(double maxSphericity) {
		this.maxSphericity = maxSphericity;
	}

	public double getMaxArea() {
		return maxArea;
	}

	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}

	public double getMaxBorder() {
		return maxBorder;
	}

	public void setMaxBorder(double maxBorder) {
		this.maxBorder = maxBorder;
	}

	public double getMinSphericity() {
		return minSphericity;
	}

	public void setMinSphericity(double minSphericity) {
		this.minSphericity = minSphericity;
	}

	public double getMinArea() {
		return minArea;
	}

	public void setMinArea(double minArea) {
		this.minArea = minArea;
	}

	public double getMinBorder() {
		return minBorder;
	}

	public void setMinBorder(double minBorder) {
		this.minBorder = minBorder;
	}
	public String[] getListColor() {
		return listColor;
	}


}
