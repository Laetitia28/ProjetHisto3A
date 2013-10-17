package hg.histo;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

	public class FillCellWithCSV {
		private File file;
	    private  TransformCSV transformCSV;
	    List<Cell> cells = new ArrayList<Cell>();
	    private FillCellWithCSV() {
	        super();
	    }

	    public FillCellWithCSV(File file) throws IOException {
	        this();
	        this.file = file;
	        //on remplit lines l'array list des lignes du csv
	        //on remplit data une array de tableaux de string  par les elements des lignes du CSV
	        this.transformCSV = new TransformCSV(file);
	        
	    }
	    public List<Cell> allCells() throws IOException {
	        

	        List<String[]> data = transformCSV.getData();
	        //On envele la premiere ligne (blabla colonne)
	        data.remove(0);
	        for(String[] oneData : data) {
	            Cell cell = tabToCell(oneData);
	            //System.out.println("name " + cell.getScene_ver());
	            
	            //affichage de cell
	            this.cells.add(cell);
	        }
	        /*
	        Iterator iter = cells.iterator();
	        while (iter.hasNext())
	       {
	     
	          System.out.println(iter.next());
	        }
	        */
	        /*
	        ListIterator<Cell> iter = cells.listIterator();
		    while (iter.hasNext())
		   {
		 
		      System.out.println("liste_ " + iter.next());
		    }*/
	        return cells;
	    }

		private Cell tabToCell(String[] tab) {
			Cell cell = new Cell();

			cell.setScene_name(tab[0]);
			cell.setInner_x(Double.parseDouble(tab[4]));
			cell.setInner_y(Double.parseDouble(tab[5]));
			cell.setScene_ver(Double.parseDouble(tab[2]));
			cell.setClass_name(tab[7]);

		    return cell;
		}
			
		
	}

