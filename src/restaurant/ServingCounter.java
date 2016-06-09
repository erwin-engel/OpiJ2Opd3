package restaurant;
/**
 * Class represents the Serving Counter
 * @author Erwin Engel
 */
import java.util.ArrayList;

public class ServingCounter {
	private ArrayList<Meal> mealList = null;
	/**
	 * Create a Counting Server with empty Meal list
	 */
	public ServingCounter(){
		mealList = new ArrayList<Meal>();
	}
	/**
	 * Method puts meal to Serving Counter
	 * @param meal put to Serving Counter
	 */
	public synchronized void putMealToCounter(Meal meal){
		mealList.add(meal);
	}
	/**
	 * Method to get Meal Serving Counter
	 * @return if present a meal, else null
	 */
	public synchronized Meal getMealFromCounter(){
		if (mealList.size() > 0) {
			Meal meal = mealList.get(0);
			mealList.remove(0);
			return meal;
		}
		return null;
	}
}
