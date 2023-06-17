package main;

//Eileen Andert
//Nachdem ich es selbstständig erarbeitet hatte, habe ich mich mit Line Abele gemeinsam über die jeweiligen Fehler ausgetauscht, die bei uns aufgetreten sind,
//da man beim eigenen Code irgendwann "blind" wird und auch kleine Fehler schwer zu finden werden :)

public class AnimalSpotting {

    // ----------------------------------------------------------------
    // Exercise 1 (b)
    // ----------------------------------------------------------------
    
	public static Animal[] generateRandomZoo(int n) {
		
		Animal[] randomZoo = new Animal [n];
		
		for(int i = 0; i < randomZoo.length; i++) {
			
			int r = RandomTools.randomValue(Animal.values().length);
			
			randomZoo[i] = (Animal.values()[r]);		
			
		}
		
		return randomZoo;
		
	}
    
    
    
    // ----------------------------------------------------------------
    // Exercise 1 (c)
    // ----------------------------------------------------------------
    
    public static void printZoo(Animal[] zoo) {
    	
    	if(zoo == null) {
    		System.out.println();
    	} else {  	
    		for(int i=0; i < zoo.length; i++) {
    			System.out.println(zoo[i]);
    		}	
    	}
    	
    }
    
    
    
    // ----------------------------------------------------------------
    // Exercise 1 (d)
    // ----------------------------------------------------------------
    
    public static int[] countAnimals(Animal[] zoo) {
    
    	
    	int [] animalQuantity = new int[Animal.values().length];
    	
    	for(Animal animal : zoo) {
   		 		
    			for(int i = 0; i < animalQuantity.length; i++) {
    					 				
    				if(animal == Animal.values()[i]) {
    					
    				animalQuantity[i] +=  1;
    				
    				}  				
    			}
    	}   	
    	return animalQuantity;  	
    }
    
    
    
    // ----------------------------------------------------------------
    // Exercise 1 (e)
    // ----------------------------------------------------------------
    
  
    
    public static Animal mostFrequentAnimal(Animal[] zoo) {
    	
    	if(zoo == null) {
    		return null;
    	} 
    	
    	int[] counter = countAnimals(zoo);
    	int maximum = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < counter.length; i++) {
    		
    		
    		
    		if(maximum < counter[i]) {
    			
    			maximum = counter[i];
    			
    			//bestimmen des größten integers im Array
    		}
    		
    	}
    	
    	int trueMaximum = searchHelper(counter, maximum);
    	// mit Hilfe der Funktion vom letzten Mal den ersten Index mit der größten Zahl herausfinden
    	
    	Animal result = Animal.values()[trueMaximum];
    	
    	return result;
    	
    }
    
    
    
 public static int searchHelper(int[] array, int value) {
        
        int i = 0;
           
       while(i <= array.length)  {
    	   
    	   if(value == array [i]) {
    		   return i;
    	   }    	   
    	   	i++;	   
       }
       return 0;
    }

    

    // ----------------------------------------------------------------
    // Exercise 1 (f)
    // ----------------------------------------------------------------
    
    public static double calculateBiomass(Animal[] zoo) {
    	

		// einen Zähler festlegen
		double totalMass = 0;
		
		
    	
    	for(Animal element : zoo) {
    		
    		if(element == null) {
    			continue;
    		}
     		
    		switch (element) {
    		
  	
    		case ELEPHANT:
    			double massElephant = 5000;
    			totalMass += massElephant;
    			break;
    		
    		case LION:
    			double massLion = 150;
    			totalMass += massLion;
    			break;
    			
    		case TIGER:
    			double massTiger = 200;
    			totalMass += massTiger;
    			break;
    			
    		case WASP:
    			double massWasp = 6e-5;
    			totalMass += massWasp;
    			break;
    			
    		case SNAKE:
    			double massSnake = 35;
    			totalMass += massSnake;
    			break;
    			
    		case MONKEY:
    			double massMonkey = 160;
    			totalMass += massMonkey;
    			break;
    			
    		case EMU:
    			double massEmu = 40;
    			totalMass += massEmu;
    			break;
    		}		   		
    	}
    	
    	return totalMass;
    			
    }



    // ----------------------------------------------------------------
    
    public static void main(String[] args) {

       Animal[] zoo = generateRandomZoo(100);
        
        printZoo(zoo);
        
        System.out.println();
        
        int[] counting = countAnimals(zoo);
        System.out.println(ArrayTools.asString(counting));
        System.out.println();
        
        System.out.println(mostFrequentAnimal(zoo));
        
        System.out.println();
        
        System.out.println(calculateBiomass(zoo));
    }
    
}