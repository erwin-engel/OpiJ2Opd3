package restaurant;
/**
 * Class represents a Meal 
 * @author Erwin Engel
 */
public class Meal {
	private String description= null;
	private int tableNumber = 0;
	/**
	 * Create new Meal
	 * @param description of a Meal
	 * @param tableNumber of Meal to be served to
	 */
	public Meal (String description, int tableNumber){
		this.description = description;
		this.tableNumber = tableNumber;
	}
	/**
	 * Prints meal description and Table Number	
	 */
	public String toString(){
		return ("This meal is a " + description + " for table number " + tableNumber);
	}
	/**
	 * Method to get table number of Meal
	 * @return able number of Meal
	 */
	public int getTableNumer(){
		return this.tableNumber;
	}
}
