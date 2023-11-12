package MapReduce.VersionTask;

import HadoopMini.Tupla;
import MapReduce.Interface.MapReduceTaskInterface;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Lenin Guaminga
 */
abstract class VersionTask {

	public abstract void map(Tupla elemento, ArrayList output);

	public abstract void reduce(Tupla elemento, ArrayList output);

	


	}

