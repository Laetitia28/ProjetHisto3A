package hg.histo;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	public class ReaderCSV {
		
		 public static  List<String> readFile(File file) throws IOException {

			    List<String> listOfLines = new ArrayList<String>();

		        FileReader fr = new FileReader(file);
		        BufferedReader br = new BufferedReader(fr);

			        for (String line = br.readLine(); line != null; line = br.readLine()) {
			        	listOfLines.add(line);
			           // System.out.println("line : "+ line);
			        }

		        br.close();
		        fr.close();
		        return listOfLines;
		    }
		

	}

