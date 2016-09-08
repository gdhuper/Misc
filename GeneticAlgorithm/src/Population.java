
public class Population {
	Individual[] individuals;
	
	public Population(int populationSize, boolean initialize)
	{
		individuals = new Individual[populationSize];
		
		if(initialize)
		{
			for(int i = 0; i < individuals.length; i++)
			{
				Individual newIndividual = new Individual();
				newIndividual.generateIndividual();
				saveIndividual(i, newIndividual);
			}
		}
	}
	
	public Individual getIndividual(int index)
	{
		return individuals[index];
	}
	
	public Individual getFittest()
	{
		Individual fittest = individuals[0];
		
		for(int i = 0; i < individuals.length; i++)
		{
			if(fittest.getFitness() <= getIndividual(i).getFitness())
			{
				fittest = getIndividual(i);
			}
		}
		return fittest;
	}
	
	public int size()
	{
		return individuals.length;
		
	}
	public void saveIndividual(int index, Individual indiv)
	{
		individuals[index] = indiv;
	}
	

}
