package hg.histo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path ="src/ressources/image0046.csv";
		File myFile = new File(path);
		FillCellWithCSV f;
		Menu menu=new Menu();
		
			try {
				f = new FillCellWithCSV(myFile);
				List<Cell> listcells = f.allCells();// liste de toutes les cellules
				//List<Cell> listcells = f.allCells();// liste de toutes les cellules
				FramCell frame = new FramCell();
				frame.initFrame("src/ressources/image0046.csv");

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000, 700);
				frame.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	

}