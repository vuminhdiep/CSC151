package proj1;  // Don't change the package name.  Gradescope expects this.

/**
 * FILL THIS IN FOR EVERY PROJECT.  Include a class description, name, and date (for version) 
 * @author Emma Vu
 * @version 4/15/2020
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus
 *
 */
public class Coinbank {
	
	// Denominations
	public static final int PENNY_VALUE = 1;
	public static final int NICKEL_VALUE = 5;
	public static final int DIME_VALUE = 10;
	public static final int QUARTER_VALUE = 25;
	
	// give meaningful names to holder array indices
	private final int PENNY = 0;
	private final int NICKEL = 1;
	private final int DIME = 2;
	private final int QUARTER = 3;
	
	// how many types of coins does the bank hold?
	private final int COINTYPES = 4;
	
	private int[] holder;
	
	/**
	 * Default constructor
	 */
	public Coinbank() {

		this.holder = new int[COINTYPES];

	}

	/**
	 * Take the coinType and return its name in holder array.
	 * This helper will do all the work of if-else statements that can be used later in getter, setter and remove method.
	 * @param coinType the denomination of coin. 1, 5, 10, 25 are valid
	 * @return the name of the given coinType
	 */

	private int coinTypeName(int coinType){
		int typeName;
		if(coinType == PENNY_VALUE){
			typeName = PENNY;
		}
		else if(coinType == NICKEL_VALUE){
			typeName = NICKEL;
		}
		else if(coinType == DIME_VALUE){
			typeName = DIME;
		}
		// coinType == QUARTER_VALUE
		else{
			typeName = QUARTER;
		}
		return typeName;

	}

	/**
	 * a helper method to get number of coins given the coinType
	 * @param type the denomination of coin. 1, 5, 10, 25 are valid
	 * @return the number of coins
	 */

	private int getNumCoins(int type){
		return this.holder[coinTypeName(type)];
	}

	/**
	 * getter
	 * @param coinType denomination of coin to get. Valid denominations are 1,5,10,25
	 * @return number of coins that bank is holding of that type, or -1 if denomination not valid
	 */
	public int get(int coinType){

		if (isBankable(coinType)) {

			return this.getNumCoins(coinType);
		}
		else {
			return -1;
		}
	}



	/**
	 * setter
	 * @param coinType denomination of coin to set
	 * @param numCoins number of coins
	 */
	private void set(int coinType, int numCoins) {
		if (numCoins >= 0 && isBankable(coinType)) {

			this.setNumCoins(numCoins, coinType);
		}

	}


	/**
	 * helper method to set the number of coins given the coinType
	 * @param numToSet the amount of coins want to set
	 * @param type the denomination of coins. 1, 5, 10, 25 are valid
	 */
	private void setNumCoins(int numToSet, int type){
		this.holder[coinTypeName(type)] = numToSet;
	}
	
	/**
	 * Return true if given coin can be held by this bank.  Else false.
	 * @param coin penny, nickel, dime, or quarter is bankable.  All others are not.
	 * @return true if bank can hold this coin, else false
	 */
	private boolean isBankable(int coin){
		switch (coin) {
		case PENNY_VALUE: case NICKEL_VALUE: 
		case DIME_VALUE: case QUARTER_VALUE:
			return true;
		default: 
			return false;
		}
	}
	
	/** 
	 * insert valid coin into bank.  Returns true if deposit
	 * successful (i.e. coin was penny, nickel, dime, or quarter).
	 * Returns false if coin not recognized
	 * 
	 * @param coinType either 1, 5, 10, or 25 to be valid
	 * @return true if deposit successful, else false
	 */
	public boolean insert(int coinType){
		if (!isBankable(coinType)) {
			return false;
		}
		else {
			set(coinType, get(coinType)+1);
			return true;
		}
	}
	
	/**
	 * returns the requested number of the requested coin type, if possible.
	 * Does nothing if the coin type is invalid.  If bank holds
	 * fewer coins than is requested, then all of the coins of that
	 * type will be returned.
	 * @param coinType either 1, 5, 10, or 25 to be valid
	 * @param requestedCoins number of coins to be removed
	 * @return number of coins that are actually removed
	 */
	public int remove(int coinType, int requestedCoins) {
		int removedCoins = 0;
		if (isBankable(coinType) && requestedCoins >= 0) {

			removedCoins = this.calculateRemovedCoins(coinType, requestedCoins);

		}
		return removedCoins;

	}

	/**
	 * calculate the coins been removed given the type and the amount want to be removed
	 * @param type the denomination of coins. 1, 5, 10, 25 are valid
	 * @param coinsRequest the amount want to be removed
	 * @return the coins that are removed
	 */

	public int calculateRemovedCoins(int type, int coinsRequest){
		int coinsBefore;
		int coinsAfter;
		coinsBefore = this.get(type);
		coinsAfter = this.numLeft(coinsRequest, coinsBefore);
		this.set(type, coinsAfter);
		return coinsBefore - coinsAfter;
	}


	/**
	 * returns number of coins remaining after removing the
	 * requested amount.  Returns zero if requested amount > what we have
	 * @param numWant number of coins to be removed
	 * @param numHave number of coins you have
	 * @return number of coins left after removal
	 */
	private int numLeft(int numWant, int numHave){
		return Math.max(0, numHave-numWant);
	}
	
	/**
	 * Returns bank as a printable string
	 */
	public String toString() {
		double total = (get(PENNY_VALUE) * PENNY_VALUE +
				get(NICKEL_VALUE) * NICKEL_VALUE + 
				get(DIME_VALUE) * DIME_VALUE +
				get(QUARTER_VALUE) * QUARTER_VALUE) / 100.0;
				
		String toReturn = "The bank currently holds $" + total + " consisting of \n";
		toReturn+=get(PENNY_VALUE) + " pennies\n";
		toReturn+=get(NICKEL_VALUE) + " nickels\n";
		toReturn+=get(DIME_VALUE) + " dimes\n";
		toReturn+=get(QUARTER_VALUE) + " quarters\n";
		return toReturn;
	}
}
