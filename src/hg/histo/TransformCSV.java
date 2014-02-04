package hg.histo;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	public class TransformCSV {

		private File file;
		private List<String> lines;
	    private List<String[] > data;

		public TransformCSV(File file) throws IOException{
			  this.file = file;
		      init();
		}
		

		    private void init() throws IOException {
		        lines = ReaderCSV.readFile(file);

		        data = new ArrayList<String[] >(lines.size());
		        String sep = ";";
		        for (String line : lines) {
		            String[] oneData = line.split(sep);
		            for(int i =0 ; i< oneData.length;i++){
			           // System.out.println("CSVToCell " + oneData[i]);

		            }
		            data.add(oneData);
		        }
		    }


			public List<String[]> getData() {
				return data;
			}


			public void setData(List<String[]> data) {
				this.data = data;
			}
	}
