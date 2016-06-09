package restaurant;
/**
 * Class represents a Cook 
 * @author Erwin Engel
 */
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cook implements Runnable{
	private final int COOKINGTIME = 4000;
	private String name = null;
	private ServingCounter servingCounter = null;
	private List<String> mealList = Arrays.asList("Hamburger", "Patat", "La Plata"); 
	private Random rand = new Random();
	private volatile boolean stopCooking = false;
	/**
	 * 	Create a Cook
	 * @param name of the Cook
	 * @param servingCounter to which the Cook delivers a Meal
	 */
	public Cook (String name, ServingCounter servingCounter){
		this.name = name;
		this.servingCounter = servingCounter;
	}
	/**
	 * Method for running thread that makes the Cook working
	 */
	public void run(){
		System.out.println("cook " + name + " starts working");
		while (stopCooking == false){
			cookMeal();
			if (stopCooking == true){
				System.out.println("cook " + name + " stops working");
			}	
		}
	}
	/**
	 * Stops thread that makes Cook working
	 */	
	public void stop (){
		this.stopCooking = true;
	}
	/**
	 * Method to cook a Meal 
	 */
	private void cookMeal(){
		System.out.println("cook " + name + " started cooking meal");
		int tableNumber = chooseTable();
		try {
			Thread.sleep(COOKINGTIME);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		Meal meal = new Meal(mealList.get(rand.nextInt(mealList.size())), tableNumber);
		System.out.println("cook " + name + " finished cooking and puts meal to counter. " + meal.toString());
		servingCounter.putMealToCounter(meal);
		System.out.println("cook " + name + " has put meal to counter. " + meal.toString());
	}
	/**
	 * Method to generate random table number
	 */	
	private int chooseTable(){
		int tableNumber = rand.nextInt(Restaurant.NUMBEROFTABLES) + 1;
		return tableNumber;
	}
}
