package TraceAnalyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Analyser {

	public static int numberRuns;
	public static int intProperty;
	public static String whichProperty;
	public static String symbolProperty;
	public static ArrayList<String> namesToCheckList = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> namesToCheckListArray = new ArrayList<>();
		    	
	public static void main(String[] args) throws IOException {
		// names
		BufferedReader br = new BufferedReader(
				new FileReader("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Log/Output1_log.txt"));
		String line = br.readLine();
		String[] singleline = line.split(" ");
		ArrayList<String> names = new ArrayList<>();
		for (int i = 0; i < singleline.length; i++) {
			names.add(singleline[i]);
		}	

		String[] namesToCheck = new String[namesToCheckList.size()];
		
		for (int i=0; i < namesToCheckList.size(); i++){
			namesToCheck[i] = namesToCheckList.get(i);
		}
				
		int[] statMCValues = new int [namesToCheck.length];	

		int[] countArray = new int[numberRuns];
		
        for (int k=1; k<=numberRuns; k++){
		BufferedReader buf = new BufferedReader(
				new FileReader("/Users/ludovicaluisavissat/anaconda/pyTSA/Output/Data/Output" + k + "_data.txt"));
		ArrayList<String> values = new ArrayList<>();
		String lineJustFetched = null;
		String[] valuesArray;
		while (true) {
			lineJustFetched = buf.readLine();
			if (lineJustFetched == null) {
				break;
			} else {
				valuesArray = lineJustFetched.split("\t");
				for (String each : valuesArray) {
					if (!"".equals(each)) {
						values.add(each);
					}
				}
			}
		}
		buf.close();
		
		// time
		ArrayList<Double> timeValues = new ArrayList<>();
		for (int i = 0; i < values.size(); i++) {
			String[] newline = values.get(i).split(" ");
			double timeval = Double.parseDouble(newline[0]);
			timeValues.add(timeval);
		}
				
		// popValues
		ArrayList<ArrayList<Integer>> separateIntValues = new ArrayList<>();
		for (int i = 0; i < values.size(); i++) {
			String[] newline = values.get(i).split(" ");
			ArrayList<Integer> newone = new ArrayList<>();
			for (int j = 1; j < newline.length; j++) {
				int intvalue = Integer.parseInt(newline[j]);
				newone.add(intvalue);
			}
			separateIntValues.add(newone);
		}
		
 		int[] statMC = new int[namesToCheck.length];
 		
		int count = 0;
		
		if (whichProperty == "A(l)"){
		for (int r=0; r < namesToCheck.length; r++){			
			int index = names.indexOf(namesToCheck[r]);	
			for (int t=0; t< timeValues.size(); t++){		
				if (symbolProperty == ">="){
					if (separateIntValues.get(t).get(index) >= intProperty){
						statMC[r] = 1;
						break;
					}else{
						statMC[r] = 0;
					}
				}else{if (symbolProperty == ">"){
					if (separateIntValues.get(t).get(index) > intProperty){
						statMC[r] = 1;
						break;
					}else{
						statMC[r] = 0;
					}
				}else{if (symbolProperty == "="){
					if (separateIntValues.get(t).get(index) == intProperty){
						statMC[r] = 1;
						break;
					}else{
						statMC[r] = 0;
					}
				}else{if (symbolProperty == "<="){
					if (separateIntValues.get(t).get(index) <= intProperty){
						statMC[r] = 1;
						break;
					}else{
						statMC[r] = 0;
					}
				}else{if (symbolProperty == "<"){
					if (separateIntValues.get(t).get(index) < intProperty){
						statMC[r] = 1;
						break;
					}else{
						statMC[r] = 0;
				}}}}}}}
		statMCValues[r] = statMCValues[r] + statMC[r];		
		}
        }else{if (whichProperty == "#A(l)"){       	
    		for (int r=0; r < namesToCheck.length; r++){			
    			int index = names.indexOf(namesToCheck[r]);	
    			for (int t=0; t< timeValues.size(); t++){		
    				if (symbolProperty == ">="){
    					if (separateIntValues.get(t).get(index) >= intProperty){
    						count ++;
    						break;
    					}
    				}else{if (symbolProperty == ">"){
    					if (separateIntValues.get(t).get(index) > intProperty){
    						count ++;
    						break;
    					}
    				}else{if (symbolProperty == "="){
    					if (separateIntValues.get(t).get(index) == intProperty){
    						count ++;
    						break;
    					}
    				}else{if (symbolProperty == "<="){
    					if (separateIntValues.get(t).get(index) <= intProperty){
    						count ++;
    						break;
    					}
    				}else{if (symbolProperty == "<"){
    					if (separateIntValues.get(t).get(index) < intProperty){
    						count ++;
    						break;
    					}}}}}}}}
    		countArray[k-1] = count; }}}
   
        if (whichProperty == "A(l)"){ 
        ArrayList<Double> StatMCPlot = new ArrayList<>();
        System.out.println("Stat MC:");
        for (int f=0; f< statMCValues.length; f++){
        	Integer valueToUse = statMCValues[f];
        	double statMCdouble = valueToUse.doubleValue();
        	double valueMC = statMCdouble/numberRuns; 
        	StatMCPlot.add(valueMC);
        	double conflevel = 1.96;
        	double root = Math.sqrt((1.0/numberRuns) * valueMC * (1 - valueMC));
        	double confinterval = conflevel * root;
        	ArrayList<Double> resultSMC = new ArrayList<>();
        	resultSMC.add(valueMC);
        	resultSMC.add(confinterval);    	
            HashMap <ArrayList<Integer>, ArrayList<Double>> toAdd = new HashMap<>();
        	toAdd.put(namesToCheckListArray.get(f),resultSMC);       	
        	System.out.println(namesToCheck[f] + " -> " + valueMC + " \u00B1 " + confinterval);
        }      
        
        
       // GlobalManager.ForPlotting();
        System.out.print("statMC = [");
        for (int y=0; y < (StatMCPlot.size()-1); y++){
        	System.out.print(StatMCPlot.get(y) + ", ");
        }
        System.out.print(StatMCPlot.get(StatMCPlot.size()-1) + "]");}else{
        
        if (whichProperty == "#A(l)"){         
        for (int k=0; k<numberRuns; k++){
         System.out.println("Simulation" + (k+1) + " -> " + countArray[k]);	
        }       
        
        Integer sum = IntStream.of(countArray).sum();       
        double sumDouble = sum.doubleValue();       
        double meanSim = sumDouble/countArray.length;        
        double[] countArrayDouble = new double[countArray.length];        
        for (int i=0; i<countArray.length; i++){
        	Integer intValue = countArray[i];
        	countArrayDouble[i] = intValue.doubleValue(); 
        }       
        Stat MyData = new Stat(countArrayDouble);                
        System.out.println("The mean is " + MyData.getMean() + " and the standard deviation is " + MyData.getStdDev());}}
              
	}}
