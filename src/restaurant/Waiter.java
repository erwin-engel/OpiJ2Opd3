package restaurant;
/**
 * Class represents a Waiter 
 * @author Erwin Engel
 */
public class Waiter implements Runnable {
	private static int WALKINGTIME = 500; //Milliseconds
	private static int WAITINGTIMEATCOUNTER = 1000; //Milliseconds
	private String name = null;
	private ServingCounter servingCounter = null;
	public volatile Boolean stopWaiter = false;
	/**
	 * Create new Waiter
	 * @param name of the Waiter
	 * @param servingCounter from which Waiter takes meals
	 */
	public Waiter (String name, ServingCounter servingCounter){
		this.name = name;
		this.servingCounter = servingCounter;
	}
	/**
	 * Method for running thread that makes the Waiter working
	 */
	public void run(){
		System.out.println("waiter " + name + " starts working");
		while (stopWaiter == false){
			Meal meal = null;
			while (meal == null && stopWaiter == false){
				System.out.println("waiter " + name + " tries to get meal" );
				meal = servingCounter.getMealFromCounter();
				if (meal == null) {
					System.out.println("no meal present for " + name + ", starts waiting now" );
					try {
						Thread.sleep(WAITINGTIMEATCOUNTER);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (stopWaiter == true){
				System.out.println("waiter " + name + " stops working" );
			} else {
				System.out.println("meal present for " + name + ", going to start serving now" );
				serveMeal(meal);
			}
		}
	}
	/**
	 * Stops thread that makes Waiter working
	 */		
	public void stop(){
		stopWaiter = true;
	}
	/**
	 * Method to serve Meal
	 * @param meal that is to be served
	 */
	private void serveMeal(Meal meal){
		try {
			Thread.sleep(WALKINGTIME * meal.getTableNumer());
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("waiter " + name + " served " + meal.toString());
	}
}
