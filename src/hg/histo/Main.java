package hg.histo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String path ="src/ressources/image0046.csv";
		File myFile = new File(path);
		FillCellWithCSV f;
		try {
			f = new FillCellWithCSV(myFile);
			List<Cell> listcells = f.allCells();// liste de toutes les cellules
			
			FramCell frame = new FramCell(listcells);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1000, 700);
			
			frame.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	}


