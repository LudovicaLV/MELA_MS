package TotalCells;

import java.util.ArrayList;
import java.util.Random;

import ParserProg5Cells.ModelCells;

public class TotalCells {

	public static String Folder = "/afs/inf.ed.ac.uk/user/s13/s1372511/eclipse-workspace/MovementCells5/src/";
	
	public static int numberOfRuns = 1;
	public static double simulationTime = 25.0;
	
	public static int gridX = 15;
	public static int gridY = 15;
	
	public static ArrayList<Integer> point = new ArrayList<>();
	
	//cost analysis
	public static String[] ListAction = {};
	public static double[] ListCost = {};
	
	//agents to count
	//public static String[] AgentNames = {"P", "C", "M", "L"};
	public static String[] AgentNames = {"C", "M"};
	
	//name of MELA model 
	public static String Model = "Rate7";
	
	public static void main(String[] args) throws Exception {
		ModelCells._EXPERIMENT_ID = 1;
		ModelCells.main(null);
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}

