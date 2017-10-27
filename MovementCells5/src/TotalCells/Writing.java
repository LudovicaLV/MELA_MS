package TotalCells;

import ParserProg5Cells.ModelCells;

public class Writing {
	
	//used in SimulatorCells
	public static String Log (){	
		String log = TotalCells.Folder + "Output/Log/Output" + TotalCells.Model + "_" + ModelCells._EXPERIMENT_ID  + "_" +  ModelCells._SIMULATION_ID;
		return log;
	}

	//used in SimulatorCells
	public static String Meta (){	
		String meta = TotalCells.Folder + "Output/Meta/Output" + TotalCells.Model + "_" + ModelCells._EXPERIMENT_ID  + "_" +  ModelCells._SIMULATION_ID;
		return meta;
	}
	
	//used in SimulatorCells
	public static String Data (){	
		String meta = TotalCells.Folder + "Output/Data/Output" + TotalCells.Model + "_" + ModelCells._EXPERIMENT_ID  + "_" +  ModelCells._SIMULATION_ID;
		return meta;
	}

	//used in SimulatorCells
	public static String Cost (){	
		String meta = TotalCells.Folder + "Output/Cost/Output" + TotalCells.Model + "_" + ModelCells._EXPERIMENT_ID  + "_" +  ModelCells._SIMULATION_ID;
		return meta;
	}
	
	//used in SimulatorCells
	public static String Agents (){	
		String meta = TotalCells.Folder + "Output/Agents/Output" + TotalCells.Model + "_" + ModelCells._EXPERIMENT_ID  + "_" +  ModelCells._SIMULATION_ID;
		return meta;
	}
}
