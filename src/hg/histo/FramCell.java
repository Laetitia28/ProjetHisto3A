package hg.histo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class FramCell extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	private String param = "white";

    Menu menu=new Menu();
    JPanel optionBox = new JPanel();
    JPanel buttonBar = new JPanel();
    JButton btZoomToFit = new JButton("Zoom To Fit ViewPort");
    
    mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();
	mxGraphComponent graphComponent ;
	
	
	
	public FramCell() {
		
		super("Frame Cell!");
	
		graphComponent = new mxGraphComponent(graph);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);
		//graphComponent.setSize(20, HEIGHT);
		
		
		optionBox.setLayout(new BorderLayout());
		
		//create toolbar Button
		
		buttonBar.setLayout(new FlowLayout());
		
		
		buttonBar.add(btZoomToFit);
		//btZoomToFit.addActionListener(this);
		
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
				JFileChooser chooser = new JFileChooser();// création dun

				chooser.setApproveButtonText("Choose File..."); // intitulé du
				// bouton
				chooser.showOpenDialog(null); // affiche la boite de dialogue
				String path = chooser.getSelectedFile().getAbsolutePath();
				System.out.println(path);
				//StringBuffer pathmodif =new StringBuffer(path);
				//System.out.println(pathmodif.charAt(5) );
				/*String[]temp;
				String delimiter=(".");
				temp=path.split(delimiter);
				System.out.println(temp.length);
				for(int i = 0; i < temp.length ; i++)
				    System.out.println(temp[i]);*/
				StringTokenizer st = new StringTokenizer(path, "."); 
				while (st.hasMoreTokens()) { 
				System.out.println(st.nextToken()); 
				String ext=st.nextToken();
				System.out.println(ext);
			    if(ext.equals("csv")){
			    	System.out.println("Ceci est un bon fichier ");
			    	System.out.println(ext);
			    	String newPath1=ext.replace(ext.charAt(0), 'j');
			    	String newPath2=newPath1.replace(ext.charAt(1), 'p');
			    	String newPath3=newPath2.replace(ext.charAt(2), 'g');
			    	System.out.println(newPath3);//nouvelle extention de limage
			    	//System.out.println("token2"+ st.nextToken());
			    	}
			    
			    else System.out.println("Ceci n'est pas un bon fichier ");
					
				
				} 
									
			}
				
			
		});
	      menu.getImage().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//display or remove image 
			}
		});
			
			
}
	public void initFrame(String path){
		List<Cell> listcells = setListCell(path);
		graph.getModel().beginUpdate();

		try

		{
			for (Cell c : listcells) {
				ColorCell(c);
				Object v1 = graph
						.insertVertex(parent, null, c.getClass_name(),
								c.getInner_x() / 3, c.getInner_y() / 3, 10, 10,
								"shape=ellipse;per=ellipsePerimeter;fillColor="
										+ param);
			}
		} finally {
			graph.getModel().endUpdate();
		}

		graphComponent.setConnectable(false);//edges
		graphComponent.getViewport().setOpaque(true);//background



		graphComponent.setBackgroundImage(new ImageIcon(
				"src/ressources/image0046.jpg"));			
		

		getContentPane().add(graphComponent);
      
	}
	public void changeFrame(String path){
		setListCell(path);
		graph.removeCells(graph.getChildVertices(graph.getDefaultParent()));
		graph.getModel().beginUpdate();
		
		try

		{
			
				Object v1 = graph.insertVertex(parent, null,2,6,6, 10,
						10,"shape=ellipse;per=ellipsePerimeter;fillColor="+param);
			}
		
		finally
		{
			graph.getModel().endUpdate();
		}
		
			graphComponent.setBackgroundImage(new ImageIcon("src/images/image0046.jpg"));
		
		
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
			setListCell("src/images/image0046.csv");
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
