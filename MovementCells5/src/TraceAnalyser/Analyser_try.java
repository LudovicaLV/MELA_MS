package TraceAnalyser;

public class Analyser_try {
	
	

//	public static void main(String[] args) throws IOException {

//		CSVReader reader = new CSVReader(new FileReader("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Data/Output1_data.txt"), '\t');
//		String [] nextLine;
//		while ((nextLine = reader.readNext()) != null) {
//		    // nextLine[] is an array of values from the line
//		    System.out.println(nextLine[1]);
//		}

	
//      int i = 1;
//	  FileInputStream inputFile = null;
//	  inputFile = new FileInputStream("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Data/Output" + i + "_data.txt");
//	  inputFile.close();
//			         		
//	}
//}

	
//public static void main(String[] args) throws IOException{
//    Scanner scanner = new Scanner("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Data/Output1_data.txt");
//    while(scanner.hasNext()){
//        String[] tokens = scanner.nextLine().split(" ");
//        String last = tokens[tokens.length - 1];
//        System.out.println(last);
//    }
//  }

	
//	public static void main(String[] args) {
//	    List<String> list = new ArrayList<String>(); 
//	    List<String> time = new ArrayList<String>(); 
//   	
//	    File file = new File("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Data/Output1_data.txt");
//	    if(file.exists()){
//	        try { 
//	            list = Files.readAllLines(file.toPath(),Charset.defaultCharset());
//	        } catch (IOException ex) {
//	            ex.printStackTrace();
//	        }
//	      if(list.isEmpty())
//	          return;
//	    }
//	    
//	    ArrayList<ArrayList<String>> popCount = new  ArrayList<ArrayList<String>>();
//	    
//	    for(String line : list){
//	    	String [] res = line.split(" ");	        
//	        time.add(res[0]);
//	        for (int i=0; i < dim ; i++){
//	        popCount.get(i).add(res[i]);
//	        }
//	    }
//	    
//	    
//	    for (int j=0; j < 5; j++){
//	    	System.out.println(popCount.get(8).get(j));
//	    }
//	}
	
//	public static void main(String[] args) throws IOException {
//    
//	BufferedReader br = new BufferedReader(new FileReader("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Log/Output1_log.txt"));
//	String line = br.readLine();
//	String[] singleline = line.split(" ");
//	String[] ColNames = new String[singleline.length];
//	for(int i = 0; i < singleline.length; i++){
//	ColNames[i] = singleline[i];
//	}
//	
//	for(int i = 0; i < ColNames.length; i++){
//	System.out.println(ColNames[i]);
//	}
	
	
//    List<String> list = new ArrayList<String>(); 
//   File file = new File("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Data/Output1_data.txt");
//if(file.exists()){
//    try { 
//        list = Files.readAllLines(file.toPath(),Charset.defaultCharset());
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    }
//  if(list.isEmpty())
//      return;
//}

//    BufferedReader br2 = new BufferedReader(new FileReader("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Data/Output1_data.txt"));
//    String line2 = br2.readLine();
//    String[] singleline2 = line2.split(" ");
//    for(int i = 0; i < singleline2.length; i++){
//    System.out.println(singleline2[i]);
//    }}
		

}
