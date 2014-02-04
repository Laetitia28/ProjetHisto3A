package hg.hist.MVC;

import hg.histo.Cell;
import hg.histo.FillCellWithCSV;
import hg.histo.Menu;
import hg.histo.SearchFile;

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
import javax.swing.JMenuItem;
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
	
	//private String path_Ressource_cvs_defautl = this.getClass().getResource("/ressources/image0046.csv").getFile();


	private SearchFile searchFile;

	private String cellselected;
	private Object key;

	private ImageIcon img ;
	private HashMap<String, String> mapColor = new HashMap<String, String>();

	private List<Cell> listCells;
	private List<Cell> temp ;


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
			System.out.println(" yes ");

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

		this.listCells = setListCell(path);

		ChangeMapColor(this.listCells);
		graph.getModel().beginUpdate();
		try {
			for (Cell c : this.listCells) {
				Object v2 = graph.insertVertex(graph.getDefaultParent(), null,
						c.getClass_name(), c.getInner_x() * 0.4,
						c.getInner_y() * 0.4, 10, 10,
						"shape=ellipse;per=ellipsePerimeter;fillColor="
								+ getMapColor().get(c.getClass_name()));
			}
		} finally {
			graph.getModel().endUpdate();
		}
		
		// display background
		ImageIcon img = new ImageIcon(getPath_image());
		
		img = scale(path_image, (int) (img.getIconWidth() * 0.4),
				(int) (img.getIconHeight() * 0.4));
		graphComponent.setBackgroundImage(img);
		return graphComponent;
	}
//ok
	public HashMap<String, JMenuItem> ChangeColorOfCell(Menu menu,
			HashMap<String, JMenuItem> JMenuItems) {
		JMenuItem newCell;
		for (String j : getMapColor().keySet()) {
			newCell = new JMenuItem(j);
			menu.getPropertyCells().add(newCell);
			JMenuItems.put(j.toString(), newCell);
			// System.out.println("element de la JMenuItems:" +
			// JMenuItems.keySet());
		}
		return JMenuItems;
	}

	public void ChangeFile(JFileChooser chooser,mxGraphComponent graphComponent, mxGraph graph) {
		
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
	public void MapColorCell() {
		mapColor.put("Tumor nucleus", "red");
		mapColor.put("Granulocyte nucleus", "yellow");
		mapColor.put("Lymphocyte Nucleus", "green");
		mapColor.put("Nucleus DAB+ PRD+", "black");
		mapColor.put("Nucleus DAB+", "blue");
	}

	//ok
	public mxGraphComponent initFrame(mxGraph graph,
			mxGraphComponent graphComponent) {
		graph.getModel().beginUpdate();

		try {
			for (Cell c : this.listCells) {
				Object v1 = graph.insertVertex(graph.getDefaultParent(), null,
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

		/*
		 * //ChangeColorOfCell(menu,JMenuItems); for(String a :
		 * JMenuItems.keySet()){ JMenuItems.get(a).addActionListener(new
		 * ActionListener(){ public void actionPerformed(ActionEvent event){
		 * String[] list = {"red", "green", "blue","yellow", "black",
		 * "white","orange", "purple"}; JComboBox jcb = new JComboBox(list);
		 * jcb.setEditable(false); jcb.getSelectedItem();
		 * JOptionPane.showMessageDialog( null,
		 * jcb,event.getActionCommand(),JOptionPane.QUESTION_MESSAGE);
		 * //controller.setCellselected(event.getActionCommand());
		 * //System.out.println("chosenCell:" + getCellselected());
		 * //controller.setColor(jcb.getSelectedItem().toString());
		 * //System.out.println("chosenColor:" + getColor());
		 * //changeMap(getCellselected(), getColor());
		 * //displaySelectedCells(getCellselected(),graph); } }); }
		 */
		return graphComponent;
		// getContentPane().add(graphComponent, BorderLayout.CENTER);
	}

	//ok
	public void displaySelectedCells(String nameSelected, mxGraph graph) {
		graph.getModel().beginUpdate();
		try {
			for (Cell c : this.listCells) {
				if (c.getClass_name().equals(nameSelected)) {

					Object v2 = graph.insertVertex(graph.getDefaultParent(),
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

	public void changeMap(String typeCell, String typeColor) {
		for (String e : getMapColor().keySet()) {
			if (typeCell.equals(e)) {
				getMapColor().put(e, typeColor);
			}
		}
	}

	public HashMap<String, String> ChangeMapColor(List<Cell> myNewList) {
		System.out.println("ChangeMapColor method");

		HashMap<String, String> tmp = new HashMap<String, String>();
		for (Cell c : myNewList) {
			tmp.put(c.getClass_name(), "orange");
		}
		HashMap<String, String> unionMap = new HashMap<String, String>();
		unionMap.putAll(tmp);
		unionMap.putAll(getMapColor());
		
		//debug
		for (String e : unionMap.keySet()) {
			//System.out.println("key : " + e);
			//System.out.println("object : " + unionMap.get(e));
		}
		setMapColor(unionMap);
		return getMapColor();
	}

	public List<Cell> FirstSortListCell(String typeName){
		List<Cell> list_tmp =new ArrayList<Cell>();
		for(Cell a : getListCells()){
			if(a.getClass_name().equals(typeName)){
				list_tmp.add(a);
			}
		}
		if(list_tmp.isEmpty()){
			list_tmp = getListCells();
		}
		return list_tmp;
	}
	public void SecondSortListCell(double valueBorderSup,
			double valueBorderInf, double valueSphericitySup ,
			double  valueSphericityInf , double valueAreaSup,
			double valueAreaInf, String type,mxGraph graph) {
		
		for (Cell a : FirstSortListCell(type)) {
			System.out.println("area "+a.getArea_pxl());
			System.out.println("border "+a.getBorder_Lenght_pxl());
			System.out.println("sphe "+ a.getSphericity());
				if (a.getBorder_Lenght_pxl() > valueBorderSup
						&& a.getBorder_Lenght_pxl() < valueBorderInf &&
						a.getArea_pxl() > valueAreaSup
						&& a.getArea_pxl() < valueAreaInf &&
						a.getSphericity() > valueSphericitySup
						&& a.getSphericity() < valueSphericityInf) {					
					this.temp.add(a);
				}				
		}
		graph.getModel().beginUpdate();
		try {
			for (Cell c : this.temp) {
					Object v2 = graph.insertVertex(graph.getDefaultParent(),
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

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public String getCellselected() {
		return cellselected;
	}

	public void setCellselected(String cellselected) {
		this.cellselected = cellselected;
	}

	public List<Cell> getTemp() {
		return temp;
	}

	public void setTemp(List<Cell> temp) {
		this.temp = temp;
	}


}
