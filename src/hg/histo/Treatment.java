package hg.histo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class Treatment {

	private String img_default = "src/ressources/image0046.jpg";
	private String path_image = img_default;
	private String path_excel_default = "src/ressources/image0046.csv";
	private String path_current = path_excel_default;
	private String path_initial;
	SearchFile searchFile ;
	private HashMap<String, String> m = new HashMap<String,String>();

	
	public String getPath_image() {
		return path_image;
	}
	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}
	public HashMap<String, String> getM() {
		return m;
	}
	public void setM(HashMap<String, String> m) {
		this.m = m;
	}
	List<Cell> listCells;

	public Treatment (){
		
		listCells = new ArrayList<Cell>();
		listCells = setListCell(path_current);


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
	public void MapColorCell(){

		m.put("Tumor nucleus", "red");
		m.put("Granulocyte nucleus", "yellow");
		m.put("Lymphocyte Nucleus", "green");
		m.put("Nucleus DAB+ PRD+", "black");
		m.put("Nucleus DAB+", "blue");
		//System.out.println(m.keySet());



	}
	public mxGraphComponent initFrame( mxGraph graph,  mxGraphComponent graphComponent){
		graph.getModel().beginUpdate();
		try
		{
			for (Cell c : listCells) {

				Object v1 = graph
						.insertVertex(graph.getDefaultParent(), null, c.getClass_name(),
								c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
								"shape=ellipse;per=ellipsePerimeter;fillColor="
										+ m.get(c.getClass_name()));
			}
		} finally {
			graph.getModel().endUpdate();
		}
		//display background
		graphComponent.setBackgroundImage(new ImageIcon("src/ressources/image0046.jpg"));			
		ImageIcon img = new ImageIcon(img_default);
		img = ImageToIcon.scale(img_default, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
		graphComponent.setBackgroundImage(img);			

		return graphComponent;
		
		//getContentPane().add(graphComponent, BorderLayout.CENTER);
	}
	public mxGraphComponent changeFrame(String path,mxGraph graph,  mxGraphComponent graphComponent){


		graph.setCellsDeletable(true);
		graph.removeCells(graph.getChildVertices(graph.getDefaultParent()));
		graph.refresh();
		graph.setCellsDeletable(false);
		listCells.clear();
		listCells = setListCell(path);

		
		graph.getModel().beginUpdate();
		try
		{
			for (Cell c : listCells) {

				Object v2 = graph
						.insertVertex(graph.getDefaultParent(), null, c.getClass_name(),
								c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
								"shape=ellipse;per=ellipsePerimeter;fillColor="
										+ m.get(c.getClass_name()));
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		//display background

		ImageIcon img = new ImageIcon(path_image);
		img = ImageToIcon.scale(path_image, (int)(img.getIconWidth()*0.4),(int)(img.getIconHeight()*0.4));
		graphComponent.setBackgroundImage(img);	
		return graphComponent;
		//getContentPane().add(graphComponent, BorderLayout.CENTER);

	}
	public void displaySelectedCells(String nameSelected,mxGraph graph){
		graph.getModel().beginUpdate();
		try
		{
			for (Cell c : listCells) {
				if(c.getClass_name().equals(nameSelected)){

					Object v2 = graph
							.insertVertex(graph.getDefaultParent(), null, c.getClass_name(),
									c.getInner_x()*0.4, c.getInner_y()*0.4 , 10, 10,
									"shape=ellipse;per=ellipsePerimeter;fillColor="
											+ m.get(c.getClass_name()));
				}
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}

	}
	public String GetPath_Ext(String path_current){	
		StringTokenizer st = new StringTokenizer(path_current, "."); 
		String ext = "";
		while (st.hasMoreTokens()) { 
			path_initial = st.nextToken();
			//System.out.println("path_initial get ext : " + path_initial); 
			ext=st.nextToken();
			//System.out.println("ext : " + ext);
		}
		return ext;
 
	}
	public double newScale(mxGraphComponent graphComponent){
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
		return newScale;
		
	}

	public boolean GoodFile(String ext,String path_current){
		boolean found= false;
		System.out.println("Path selected currentG : " + path_current);
		
		StringTokenizer st = new StringTokenizer(path_current, "."); 
		
		while (st.hasMoreTokens()) { 
			 path_initial = st.nextToken();
			System.out.println("path_initialG : " + path_initial); 
		}

		if(GetPath_Ext(path_current).equals("csv")){
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
			found = searchFile.searchFileImage(searchFile.name, searchFile.filePath);
			
		}
		
		return found;
	}

}

