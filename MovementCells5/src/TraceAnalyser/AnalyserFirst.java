package TraceAnalyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Model.GlobalManager;

public class AnalyserFirst {

	public static int numberRuns;
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
		
		//names to check
		String[] namesToCheck = {"I(11,19)", "I(0,17)", "I(10,1)", "I(14,14)", "I(19,4)", "I(13,6)", "I(1,13)", "I(19,2)", "I(5,6)", "I(16,16)", "I(13,2)", "I(11,3)", "I(9,0)", "I(9,1)", "I(3,15)", "I(16,9)", "I(16,4)", "I(4,8)", "I(4,1)", "I(15,0)", "I(9,5)", "I(4,10)", "I(3,3)", "I(2,6)", "I(8,12)", "I(3,12)", "I(16,14)", "I(6,3)", "I(7,4)", "I(5,0)", "I(1,15)", "I(1,2)", "I(15,13)", "I(14,1)", "I(3,10)", "I(9,4)", "I(7,12)", "I(11,18)", "I(1,18)", "I(3,19)", "I(12,4)", "I(11,4)", "I(7,14)", "I(0,0)", "I(12,16)", "I(1,0)", "I(3,5)", "I(5,19)", "I(9,11)", "I(10,8)", "I(1,7)", "I(15,18)", "I(0,15)", "I(10,9)", "I(19,12)", "I(2,1)", "I(3,8)", "I(17,11)", "I(19,15)", "I(2,8)", "I(18,18)", "I(17,10)", "I(0,14)", "I(4,5)", "I(6,18)", "I(10,14)", "I(11,0)", "I(6,0)", "I(9,14)", "I(10,0)", "I(17,19)", "I(9,15)", "I(19,18)", "I(15,12)", "I(11,7)", "I(17,6)", "I(0,12)", "I(5,8)", "I(13,3)", "I(16,8)", "I(3,17)", "I(19,16)", "I(5,18)", "I(11,5)", "I(15,16)", "I(15,17)", "I(14,7)", "I(3,18)", "I(16,1)", "I(8,5)", "I(11,12)", "I(10,11)", "I(6,7)", "I(17,2)", "I(17,17)", "I(8,18)", "I(4,14)", "I(4,16)", "I(18,13)", "I(17,13)", "I(3,2)", "I(3,1)", "I(7,3)", "I(0,13)", "I(2,11)", "I(9,17)", "I(8,7)", "I(13,14)", "I(8,3)", "I(8,8)", "I(14,6)", "I(12,2)", "I(7,7)", "I(16,10)", "I(5,9)", "I(9,12)", "I(7,6)", "I(10,16)", "I(6,5)", "I(6,12)", "I(15,2)", "I(15,8)", "I(14,3)", "I(10,7)", "I(11,17)", "I(4,15)", "I(14,4)", "I(16,6)", "I(0,11)", "I(6,1)", "I(15,14)", "I(17,3)", "I(8,14)", "I(15,19)", "I(19,1)", "I(12,14)", "I(1,10)", "I(12,9)", "I(4,6)", "I(17,5)", "I(13,1)", "I(10,18)", "I(12,13)", "I(6,19)", "I(14,0)", "I(12,15)", "I(7,0)", "I(7,9)", "I(8,17)", "I(7,8)", "I(10,12)", "I(8,16)", "I(12,12)", "I(10,6)", "I(14,11)", "I(8,10)", "I(16,15)", "I(6,8)", "I(16,5)", "I(18,19)", "I(5,12)", "I(7,1)", "I(7,17)", "I(6,4)", "I(4,13)", "I(5,13)", "I(0,18)", "I(1,16)", "I(17,18)", "I(3,11)", "I(9,3)", "I(13,10)", "I(11,13)", "I(14,15)", "I(15,9)", "I(15,15)", "I(15,5)", "I(16,18)", "I(13,7)", "I(0,7)", "I(9,6)", "I(1,4)", "I(12,8)", "I(3,6)", "I(13,4)", "I(14,19)", "I(8,0)", "I(2,10)", "I(2,16)", "I(14,16)", "I(13,13)", "I(9,13)", "I(18,16)", "I(14,10)", "I(16,0)", "I(15,1)", "I(7,2)", "I(6,17)", "I(18,10)", "I(18,6)", "I(10,10)"}; 
        int[] statMCValues = new int [namesToCheck.length];	
		
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
		
		// analysis of each column, to see if I(l)>0
 		int[] statMC = new int[namesToCheck.length];
		for (int r=0; r < namesToCheck.length; r++){
			int index = names.indexOf(namesToCheck[r]);	
			for (int t=0; t< timeValues.size(); t++){				
				if (separateIntValues.get(t).get(index) > 0){
					statMC[r] = 1;
					//System.out.println(namesToCheck[r] + " got infected in simulation " + k);
					break;
				}else{
					statMC[r] = 0;
				}
	    }
		statMCValues[r] = statMCValues[r] + statMC[r];
		}
        }
   
//        for (int f=0; f< statMCValues.length; f++){
//        	System.out.println(statMCValues[f]);
//        }
        
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
        	System.out.println(namesToCheck[f] + " -> " + valueMC + " \u00B1 " + confinterval);
        }
        
       // GlobalManager.ForPlotting();
        for (int y=0; y < StatMCPlot.size(); y++){
        	System.out.print(StatMCPlot.get(y) + ", ");
        }
       
	}}
