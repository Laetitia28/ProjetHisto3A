package hg.histo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	private JMenuBar menu_bar1;
	private JMenu File, Edition;
	private JMenuItem open, exit, image;

	public Menu() {

	}

	public JMenuItem getExit() {
		return exit;
	}

	public JMenuItem getOpen() {
		return open;
	}

	public void setOpen(JMenuItem open) {
		this.open = open;
	}

	public JMenuItem getImage() {
		return image;
	}

	public void setImage(JMenuItem image) {
		this.image = image;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}

	public JMenuBar buildMenu() {
		menu_bar1 = new JMenuBar();
		File = new JMenu("File");
		Edition = new JMenu("Edition");
		menu_bar1.add(File);
		menu_bar1.add(Edition);
		open = new JMenuItem("Open File");
		exit = new JMenuItem("Exit");
		image = new JMenuItem("Display Image");
		File.add(open);
		File.add(exit);
		Edition.add(image);
		this.open.addActionListener(new ActionListener() {

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
			    	System.out.println(newPath3);
			    	//System.out.println(x);
			    	}
			    
			    else System.out.println("Ceci n'est pas un bon fichier ");
					
				
				} 
									
			}
		});
		

		image.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		return menu_bar1;
	}

	
}
