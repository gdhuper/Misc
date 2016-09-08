
public class Algorithm {
	
	private static final double uniformRate = 0.5;
	private static final double mutationRate = 0.015;
	private static final int tournamentSize = 5;
	private static final boolean elitism = true;
	
	public static Population evolvePopulation(Population pop)
	{
		Population newPop  = new Population(pop.size(), false);
		
		if(elitism)
		{
			newPop.saveIndividual(0,  pop.getFittest());
		}
			
			int elitismOffset;
			if(elitism)
			{
				elitismOffset = 1;
			}
			else
			{
				elitismOffset = 0;
			}
			
			for(int i = elitismOffset; i < newPop.size(); i++)
			{
				Individual indiv1 = tournamentSelection(pop);
				Individual indiv2 = tournamentSelection(pop);
				Individual newIndiv = crossover(indiv1, indiv2);
				newPop.saveIndividual(i, newIndiv);
			}
			
			for(int i = elitismOffset; i < newPop.size(); i++)
			{
				mutate(newPop.getIndividual(i));
			}
			return newPop;
		
	}
	
	private static Individual crossover(Individual indiv1, Individual indiv2)
	{
		Individual newSol = new Individual();
		for(int i = 0; i < indiv1.size(); i++)
		{
			if(Math.random() <= uniformRate)
			{
				newSol.setGene(i, indiv1.getGene(i));
			}
			else
			{
				newSol.setGene(i, indiv2.getGene(i));
			}
		}
		return newSol;
	}

	public static void mutate(Individual indiv)
	{
		for(int i = 0; i < indiv.size(); i++)
		{
			if(Math.random() <= mutationRate)
			{
				byte gene = (byte)Math.round(Math.random());
				indiv.setGene(i, gene);
			}
		}
	}
	
	
	private static Individual tournamentSelection(Population pop)
	{
		Population tournament = new Population(tournamentSize, false);
		for(int i = 0; i < tournamentSize; i++){
			int randomId = (int) (Math.random() * pop.size());
			tournament.saveIndividual(i, pop.getIndividual(randomId));
			
		}
		Individual fittest = tournament.getFittest();
		return fittest;
	}

}
