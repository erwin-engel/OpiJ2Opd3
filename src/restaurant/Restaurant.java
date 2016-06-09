package restaurant;
/**
 * Class represents and manages a restaurant: create cooks and waiters, set them to work, and 
 * stop them to work
 * @author Erwin Engel
 */
public class Restaurant {
	public final static int NUMBEROFTABLES = 10;
	private final int SIMULATIONDURATION = 12000; // Milliseconds
	public ServingCounter servingCounter = null;

	public Restaurant(){
		servingCounter = new ServingCounter();
		Cook cook1 = new Cook("Gordon", servingCounter );
		Thread cook1Thread = new Thread(cook1);

		Cook cook2 = new Cook("Herman", servingCounter );
		Thread cook2Thread = new Thread(cook2);
		
		Cook cook3 = new Cook("Baard", servingCounter );
		Thread cook3Thread = new Thread(cook3);

		Waiter waiter1 = new Waiter("Roos", servingCounter );
		Thread waiter1Thread = new Thread(waiter1);
		
		Waiter waiter2 = new Waiter("Knor", servingCounter );
		Thread waiter2Thread = new Thread(waiter2);
		
		Waiter waiter3 = new Waiter("Jack", servingCounter );
		Thread waiter3Thread = new Thread(waiter3);

		cook1Thread.start();
		cook2Thread.start();
		cook3Thread.start();
		waiter1Thread.start();
		waiter2Thread.start();
		waiter3Thread.start();
		
		try {
			Thread.sleep(SIMULATIONDURATION);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		cook1.stop();
		cook2.stop();
		cook3.stop(); 
		waiter1.stop();
		waiter2.stop();
		waiter3.stop();
		
	} 
	public static void main(String[] args) {
		Restaurant r = new Restaurant();
	}
}
