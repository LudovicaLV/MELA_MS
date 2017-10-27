package TraceAnalyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SignalAnalysis {

	public static int numberRuns;
	public static int intProperty;
	public static String whichProperty;
	public static String symbolProperty;
	public static ArrayList<String> namesToCheckList = new ArrayList<>();
		
   	
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

		String[] namesToCheck = new String[Analyser.namesToCheckList.size()];
		
		for (int i=0; i < Analyser.namesToCheckList.size(); i++){
			namesToCheck[i] = Analyser.namesToCheckList.get(i);
		}

		
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
		
		int entry = timeValues.size() - 1;
		Double timeEnd = timeValues.get(entry);
		
				
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
		
		//create the signal
		
		//for each agent in namesToCheck I have to create a signal -> 2D array with time and value 0/1
		
		ArrayList<ArrayList<Double>> Times = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Integer>> BooleanValues = new ArrayList<ArrayList<Integer>>();
				
		if (Analyser.whichProperty == "A(l)"){
			System.out.println("Not the correct syntax!");}		
		else{if (Analyser.whichProperty == "#A(l)"){    
					
		    		for (int r=0; r < namesToCheck.length; r++){
		    			ArrayList<Double> TimesLoop = new ArrayList<Double>();
		    			ArrayList<Integer> BooleanValuesLoop = new ArrayList<Integer>();
		    			int index = names.indexOf(namesToCheck[r]);		    					    			
		    			if (Analyser.symbolProperty == ">="){
		        					if (separateIntValues.get(0).get(index) >= Analyser.intProperty){
		        						TimesLoop.add(0.0);
		        						BooleanValuesLoop.add(1);}else{
		        							TimesLoop.add(0.0);
			        						BooleanValuesLoop.add(0);
		        						}
		        					for (int t=1; t< timeValues.size(); t++){	
			        					if (separateIntValues.get(t).get(index) >= Analyser.intProperty){
			        						if (separateIntValues.get(t-1).get(index) >= Analyser.intProperty){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(1);		
			        						}			        						
			        					}else{
			        						if (!(separateIntValues.get(t-1).get(index) >= Analyser.intProperty)){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(0);		
			        						}}		        						
		        					}
		        				}else{		        					
		        					if (Analyser.symbolProperty == ">"){
				        					if (separateIntValues.get(0).get(index) > Analyser.intProperty){
				        						TimesLoop.add(0.0);
				        						BooleanValuesLoop.add(1);}else{
				        							TimesLoop.add(0.0);
					        						BooleanValuesLoop.add(0);
				        						}
				        					for (int t=1; t< timeValues.size(); t++){	
					        					if (separateIntValues.get(t).get(index) > Analyser.intProperty){
					        						if (separateIntValues.get(t-1).get(index) > Analyser.intProperty){	
					        						}else{
					        						TimesLoop.add(timeValues.get(t));
					        						BooleanValuesLoop.add(1);		
					        						}			        						
					        					}else{
					        						if (!(separateIntValues.get(t-1).get(index) > Analyser.intProperty)){	
					        							}else{
					        						TimesLoop.add(timeValues.get(t));
					        						BooleanValuesLoop.add(0);		
					        						}}		        						
				        					}	

//				        					for (int t=1; t< timeValues.size(); t++){	
//					        					if (separateIntValues.get(t).get(index) > Analyser.intProperty){
//					        						if (separateIntValues.get(t-1).get(index) <= Analyser.intProperty){	
//					        						TimesLoop.add(timeValues.get(t));
//					        						BooleanValuesLoop.add(1);		}			        						
//					        					}else{
//					        						if ((separateIntValues.get(t-1).get(index) > Analyser.intProperty)){	
//					        						TimesLoop.add(timeValues.get(t));
//					        						BooleanValuesLoop.add(0);		
//					        						}}		        						
//				        					}
				        					
				        					
				        				}
		        				else{if (Analyser.symbolProperty == "="){	
		        					if (separateIntValues.get(0).get(index) == Analyser.intProperty){
		        						TimesLoop.add(0.0);
		        						BooleanValuesLoop.add(1);}else{
		        							TimesLoop.add(0.0);
			        						BooleanValuesLoop.add(0);
		        						}
		        					for (int t=1; t< timeValues.size(); t++){	
			        					if (separateIntValues.get(t).get(index) == Analyser.intProperty){
			        						if (separateIntValues.get(t-1).get(index) == Analyser.intProperty){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(1);		
			        						}			        						
			        					}else{
			        						if (!(separateIntValues.get(t-1).get(index) == Analyser.intProperty)){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(0);		
			        						}}		        						
		        					}
		        				}
		        				else{if (Analyser.symbolProperty == "<="){	
		        					if (separateIntValues.get(0).get(index) <= Analyser.intProperty){
		        						TimesLoop.add(0.0);
		        						BooleanValuesLoop.add(1);}else{
		        							TimesLoop.add(0.0);
			        						BooleanValuesLoop.add(0);
		        						}
		        					for (int t=1; t< timeValues.size(); t++){	
			        					if (separateIntValues.get(t).get(index) <= Analyser.intProperty){
			        						if (separateIntValues.get(t-1).get(index) <= Analyser.intProperty){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(1);		
			        						}			        						
			        					}else{
			        						if (!(separateIntValues.get(t-1).get(index) <= Analyser.intProperty)){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(0);		
			        						}}		        						
		        					}
		        				}
                                else{if (Analyser.symbolProperty == "<"){                               	
		        					if (separateIntValues.get(0).get(index) < Analyser.intProperty){
		        						TimesLoop.add(0.0);
		        						BooleanValuesLoop.add(1);}else{
		        							TimesLoop.add(0.0);
			        						BooleanValuesLoop.add(0);
		        						}
		        					for (int t=1; t< timeValues.size(); t++){	
			        					if (separateIntValues.get(t).get(index) < Analyser.intProperty){
			        						if (separateIntValues.get(t-1).get(index) < Analyser.intProperty){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(1);		
			        						}			        						
			        					}else{
			        						if (!(separateIntValues.get(t-1).get(index) < Analyser.intProperty)){		        							
			        						}else{
			        						TimesLoop.add(timeValues.get(t));
			        						BooleanValuesLoop.add(0);		
			        						}}		        						
		        					}
		        				}
	        						
		        					}}}}
		    			   Times.add(TimesLoop); 		
		    			   BooleanValues.add(BooleanValuesLoop);		
		    		
		    		}}}
		

		System.out.println("This is the result of run " + k + ":");
		
		for (int i=0; i < Times.size(); i++){
			for (int j = 0; j < Times.get(i).size(); j++){
				System.out.println(Times.get(i).get(j) + " " + BooleanValues.get(i).get(j));
			}
			System.out.println("---");
		}
		
		
		//sum and create the unique one
		//now I have the information I need to create, after each run, the sequence of values time/number I need
		
		
		ArrayList<Double> TotalTimes = new ArrayList<Double>();
		ArrayList<Integer> LocationsCount = new ArrayList<Integer>();
		
		int InitialValue = 0;
		for (int i=0; i < BooleanValues.size(); i++){
				InitialValue = InitialValue + BooleanValues.get(i).get(0);		
		}
		
		TotalTimes.add(0.0);
		LocationsCount.add(InitialValue);
		//here we need to check if it is not always true/false, so we have just one value
		
		ArrayList<Double> ListToCheck = new ArrayList<Double>();
		ArrayList<Integer> Positions = new ArrayList<Integer>();
		ArrayList<Integer> PositionsNotStable = new ArrayList<Integer>();
		
		for (int i=0; i < Times.size(); i++){
			if (Times.get(i).size() != 1){		
			ListToCheck.add(Times.get(i).get(1));
			Positions.add(1);
			PositionsNotStable.add(i);
			}
	    }
		
		int WhileValue = 0;
		for (int i=0; i < PositionsNotStable.size(); i++){
			int ValueForBool = PositionsNotStable.get(i);
			WhileValue = WhileValue + BooleanValues.get(ValueForBool).size() - 1;
		}
		
		int Loop = 0;
		
		while (Loop < WhileValue) {
			
		Double minTime = getMin(ListToCheck);				
		TotalTimes.add(minTime);
		
		int indexTime = ListToCheck.indexOf(minTime);		
		int ValuePositionArray = PositionsNotStable.get(indexTime);
		int ValuePositionInArray = Positions.get(indexTime);
		int ValueToCheck = BooleanValues.get(ValuePositionArray).get(ValuePositionInArray);
	
		if (ValueToCheck == 0){
			InitialValue--;
			LocationsCount.add(InitialValue);
		}else{
			if (ValueToCheck==1){
				InitialValue++;
				LocationsCount.add(InitialValue);			
			}
		}		
		Positions.set(indexTime, Positions.get(indexTime)+1);
			
		int ValueForIf = ValuePositionInArray + 1;
		
		if (ValueForIf != Times.get(ValuePositionArray).size()){
		ListToCheck.set(indexTime, Times.get(ValuePositionArray).get(ValuePositionInArray + 1));}else{
			ListToCheck.remove(indexTime);
			Positions.remove(indexTime);
			PositionsNotStable.remove(indexTime);
		}

		Loop++;
		
        } 
		
		int entryLoc = LocationsCount.size() - 1;
		int lastValue = LocationsCount.get(entryLoc);
		TotalTimes.add(timeEnd);
		LocationsCount.add(lastValue);
		
		
		for (int i=0; i < TotalTimes.size(); i++){
			System.out.println(TotalTimes.get(i) + " " +  LocationsCount.get(i));
		}
		
		System.out.println("For plotting:");
		System.out.print("x = [");
		for (int i=0; i < TotalTimes.size() - 1; i++){
			System.out.print(TotalTimes.get(i) + ", ");
		}
		int lastEntry = TotalTimes.size() - 1;
		System.out.println(TotalTimes.get(lastEntry) + "]");
		
		System.out.print("y = [");
		for (int i=0; i < LocationsCount.size() - 1; i++){
			System.out.print(LocationsCount.get(i)  + ", ");
		}
		int lastEntryLoc = LocationsCount.size() - 1;
		System.out.println(LocationsCount.get(lastEntryLoc) + "]");
		
	       
	}}
	
	//method get min
	  public static double getMin(ArrayList<Double> inputArrayList){ 
		    Double minValue = inputArrayList.get(0); 
		    for(int i=1;i<inputArrayList.size();i++){ 
		      if(inputArrayList.get(i) < minValue){ 
		        minValue = inputArrayList.get(i); 
		      } 
		    } 
		    return minValue; 
		  } 
		

}
