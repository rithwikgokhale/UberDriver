package hw1;

/**
 * Rithwik Gokhale 
 * ID: 831106304 
 * ComS 227 
 * Homework Assignment 1
 * 
 * @author rithw
 *
 */

public class UberDriver {

	/**
	 * Maximum number of passengers allowed in the vehicle at one time.
	 */
	public static final int MAX_PASSENGERS = 4;

	/**
	 * Cost to operate the vehicle per mile.
	 */
	public static final double OPERATING_COST = 0.5;

	// This variable will hold the given per mile rate from the user input in the
	// rest of the class
	private double milerate;
	// This variable will hold the given per minute rate from the user input for the
	// rest of the class
	private double minsrate;
	// this variable will hold the value for the total miles covered by the driver
	// in one instance
	private int totalmiles;
	// This variable will hold the total minutes the driver has driver in this
	// instance.
	private int totalmins;
	// This variable holds the total number of passengers who are in the Uber at any
	// given point
	private int numpassengers;
	// This variable holds the credit of the uber driver at the end of that instance
	private double credits;
	// This variable holds the profit of the uber driver which is accumulated at the
	// end of the instance
	private double profit;
	// This variable will hold the value of the profit per hour of the Driver
	private double profitperhour;

	/**
	 * 
	 * Constructs an UberDriver with the given per-mile rate and per-minute rate.
	 * 
	 * @param givenPerMileRate
	 * @param givenPerMinuteRate
	 */
	public UberDriver(double givenPerMileRate, double givenPerMinuteRate) {
		milerate = givenPerMileRate;
		minsrate = givenPerMinuteRate;

		/*
		 * This is a public constructor which sets up the Uber driver instance. This
		 * constructor has two user inputs. These are given rate per mile the other
		 * input will be given rate per minute. Within the constructor, these user
		 * inputs are assigned to public variables which will be used in the rest of the
		 * class
		 */

	}

	/**
	 * Returns the total miles driven since this UberDriver was constructed.
	 * 
	 * @return totalmiles
	 */
	public int getTotalMiles() {
		return totalmiles;
		// This method returns the total miles which is driven by the driver in this
		// instance of UberDriver
	}

	/**
	 * Returns the total minutes driven since this UberDriver was constructed.
	 * 
	 * @return totalmins
	 */
	public int getTotalMinutes() {
		return totalmins;
		// This method returns the total time which is driven by the driver in one
		// instance of the UberDriver
	}

	/**
	 * Drives the vehicle for the given number of miles over the given number of
	 * minutes.
	 * 
	 * @param miles
	 * @param minutes
	 */
	public void drive(int miles, int minutes) {

		totalmiles = totalmiles + miles;
		totalmins = totalmins + minutes;
		credits += ((milerate * miles) + (minsrate * minutes)) * numpassengers;
		profit = credits - (OPERATING_COST * totalmiles);

		// This method takes in two user inputs for the miles driven and the minutes
		// driven. These values are then added to the public variables which then affect
		// the entire class. This method also increases the credit of the UberDriver
		// depending on the miles and minutes driven. The profits are also calculated in
		// this method by subtracting the operating cost per mile driven.

	}

	/**
	 * Simulates sitting in the vehicle without moving for the given number of
	 * minutes. Equivalent to drive(0, minutes).
	 * 
	 * @param minutes
	 */
	public void waitAround(int minutes) {
		drive(0, minutes);

		// this method basically repeats the same actions and commands from the drive
		// method. The only difference is the input. Since the driver is only waiting,
		// there is only one input for the number of minutes waited in the car
	}

	/**
	 * Drives the vehicle for the given number of miles at the given speed.
	 * Equivalent to drive(miles, m), where m is the actual number of minutes
	 * required, rounded to the nearest integer. Caller of method must ensure that
	 * averageSpeed is positive.
	 * 
	 * @param miles
	 * @param averageSpeed
	 */
	public void driveAtSpeed(int miles, double averageSpeed) {
		double r; // create a local variable which will store the value to calculate the average
					// speed
		totalmiles = totalmiles + miles; // this will add miles to the total miles of the UberDriver instance

		// A conditional is used to make sure that the average speed value is above 0
		if (averageSpeed < 0) {

		} else {

			r = (miles / averageSpeed) * 60;
			int m = (int) Math.round(r);
			totalmins = totalmins + m;
			credits += numpassengers * ((milerate * miles) + (minsrate * m));

			// When the average speed is a positive value, the m value is calculated by
			// dividing the miles by average speed and multiplying by 60. Once the m value
			// is calculated, the total time spent in the car by the driver is also
			// increased. Finally the method also increases the credit value of the driver
			// by using the credits formula.
		}
	}

	/**
	 * Returns the number of passengers currently in the vehicle
	 * 
	 * @return numpassengers
	 */
	public int getPassengerCount() {
		return numpassengers;

		// this method returns the total number of passengers which are in the car at a
		// given time
	}

	/**
	 * Increases the passenger count by 1, not exceeding MAX_PASSENGERS.
	 */
	public void pickUp() {
		if (numpassengers < MAX_PASSENGERS) {
			numpassengers++;
		}

		// this method will increase the number of passengers in the car by 1 as long as
		// it is not over the max passenger limit of 4 people
		// this method can also be completed using the max and minimum method without
		// conditionals
	}

	/**
	 * Decreases the passenger count by 1, not going below zero.
	 */
	public void dropOff() {
		if (numpassengers > 0) {
			numpassengers--;
		}

		// this method will decrease the number of passengers in the car by 1 as long as
		// the number of people in the car is more than 0
		// this method can also be completed using the max and minimum method without
		// conditionals

	}

	/**
	 * Returns this UberDriver's total credits (money earned before deducting
	 * operating costs).
	 * 
	 * @return credits
	 */
	public double getTotalCredits() {

		return credits;
		// this method will return the total number of credits the driver has gained in
		// this UberDriver instance
	}

	/**
	 * Returns this UberDriver's profit (total credits, less operating costs).
	 * 
	 * @return profit
	 */
	public double getProfit() {

		return profit;

		// this method will return the total number of profit the driver has gained in
		// this UberDriver instance by subtracting the operating cost from the credits
	}

	/**
	 * Returns this UberDriver's average profit per hour worked. Caller of method
	 * must ensure that it is only called when the value of getTotalMinutes() is
	 * nonzero.
	 * 
	 * @return profitperhour
	 */
	public double getAverageProfitPerHour() {

		profitperhour += 60 * (profit / totalmins);
		return profitperhour;

		// This method will calculate the average profit of the driver per hour. This
		// value is calculated by calculating the value from the following formula. the
		// profit is divided by the total minutes the driver drives and this value
		// is then multiplied by 60 which is the number of minutes in an hour
	}

}
