package hg.histo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class FramCell extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	private String param="white";


	public FramCell(List<Cell> listcells) throws IOException
	{
		super("Frame Cell!");
		//Le Graph Cell!!
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		
		try

		{
			for(Cell c:listcells){
				ColorCell(c);
				Object v1 = graph.insertVertex(parent, null,c.getClass_name(),c.getInner_x()/3,c.getInner_y()/3, 10,
						10,"shape=ellipse;per=ellipsePerimeter;fillColor="+param);
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setConnectable(false);
		graphComponent.getViewport().setOpaque(true);
		
		//graphComponent.setPreferredSize(new Dimension(10, 10));
		graphComponent.setBackgroundImage(new ImageIcon("src/images/loutre.jpg"));
		//graphComponent.getGraphControl().updatePreferredSize();
		
		
		getContentPane().add(graphComponent);
		
		//create a toolbar
		JPanel toolBar = new JPanel();
		toolBar.setLayout(new BorderLayout());
		
		//create toolbar Button
		JPanel buttonBar = new JPanel();
		buttonBar.setLayout(new FlowLayout());
		
		JButton btZoomToFit = new JButton("Zoom To Fit ViewPort");
		buttonBar.add(btZoomToFit);
		
		toolBar.add(buttonBar,BorderLayout.CENTER);
		getContentPane().add(toolBar, BorderLayout.EAST);
	
	}
	public void ColorCell(Cell c){
		if(c.getClass_name().equals("Tumor nucleus") ){

			param="red";
			//System.out.println(param);
		}
		else if (c.getClass_name().equals("Granulocyte nucleus") ){
			param="yellow";
			//System.out.println(param);
		}
		else if (c.getClass_name().equals("Lymphocyte Nucleus") ){
			param="green";
			//System.out.println(param);
		}
		else if (c.getClass_name().equals("Nucleus DAB+ PRD+") ){
			param="black";
			//System.out.println(param);
		}
		else if (c.getClass_name().equals("Nucleus DAB+") ){
			param="blue";
			//System.out.println(param);
		}
		else {
			param="white";
			//System.out.println(param);
		}

	} 
} 

