
public class Individual {
	
	static int defaultGeneLength = 64;
	private byte[] genes = new byte[defaultGeneLength];
	
	private int fitness = 0;
	
	public void generateIndividual(){
		
		for(int i = 0; i < genes.length; i++)
		{
			byte gene = (byte) Math.round(Math.random());
			System.out.println(gene);
			genes[i] = gene;
		}
	}
	
	
	public static void setDefaultGeneLength(int length)
	{
		defaultGeneLength = length;
	}
	
	public byte getGene(int index)
	{
		return genes[index];
	}
	public void setGene(int index, byte value)
	{
		genes[index] = value;
		fitness = 0;
	}
	
	public int size()
	{
		return genes.length;
	}
	public int getFitness()
	{
		if(fitness==0){
			fitness = FitnessCalc.getFitness(this);
		}
		return fitness;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < size(); i++) {
			str += getGene(i);
		}
		return str;

	}

}
