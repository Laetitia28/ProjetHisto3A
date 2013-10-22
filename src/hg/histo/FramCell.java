package hg.histo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class FramCell extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	private String param = "white";
    private JMenuBar menu_bar1;
    private JMenu File,Edition;
    private JMenuItem open,exit,image;
    
    
    
    
	public FramCell(List<Cell> listcells) throws IOException {
		super("Frame Cell!");
		// Le Graph Cell!!
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

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

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);


		// graphComponent.setPreferredSize(new Dimension(10, 10));
		graphComponent.setBackgroundImage(new ImageIcon(
				"src/ressources/image0046.jpg"));
		// graphComponent.getGraphControl().updatePreferredSize();


		
		//graphComponent.setPreferredSize(new Dimension(10, 10));
		graphComponent.setBackgroundImage(new ImageIcon("src/ressources/image0046.jpg"));
		//graphComponent.getGraphControl().updatePreferredSize();
		
		

		getContentPane().add(graphComponent);

		// create a JmenuMar
		menu_bar1 = new JMenuBar();
		setJMenuBar(menu_bar1);
		
		File=new JMenu("File");
		Edition=new JMenu("Edition");
		menu_bar1.add(File);
		menu_bar1.add(Edition);
		open= new JMenuItem("Open File");
		exit = new JMenuItem("Exit");
		image = new JMenuItem("Display Image");
        File.add(open);		
        File.add(exit);
        Edition.add(image);
		
	open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();// création dun
															// nouveau
															// filechosser
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
				System.out.println("token:"+st.nextToken()); 
				String ext=st.nextToken();
				System.out.println(ext);
			    if(ext.equals("csv")){
			    	System.out.println("Ceci est un bon fichier ");
			    	System.out.println(ext);
			    	String newPath1=ext.replace(ext.charAt(0), 'j');
			    	String newPath2=newPath1.replace(ext.charAt(1), 'p');
			    	String newPath3=newPath2.replace(ext.charAt(2), 'g');
			    	System.out.println(newPath3);
			    	//System.out.println(x);
			    	}
			    
			    else System.out.println("Ceci n'est pas un bon fichier ");
					
				
				} 
									
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FramCell.this.setVisible(false);
			}

		});

		image.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// create a toolbar
		JPanel toolBar = new JPanel();
		toolBar.setLayout(new BorderLayout());

		// create toolbar Button
		JPanel buttonBar = new JPanel();
		buttonBar.setLayout(new FlowLayout());

		JButton btZoomToFit = new JButton("Zoom To Fit ViewPort");
		buttonBar.add(btZoomToFit);

		toolBar.add(buttonBar, BorderLayout.CENTER);
		getContentPane().add(toolBar, BorderLayout.EAST);
		

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
