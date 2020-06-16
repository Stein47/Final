package blackJack;

public class Player {
	
	//player's name
	private String name;
	
	//players cards
	private Cards[] hand = new Cards[10];

	//number of cards in players hand
	private int numCards;
	
	public Player(String name) {
		this.name = name;
		
		this.emptyHand();
		
	}
	
	public void emptyHand() {
		for (int c = 0; c < 10; c++) {
			this.hand[c] = null;
		}
		this.numCards = 0;
	}

	public boolean addCard(Cards card) {
		
		//error for if max number of cards reached
		if (this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; " + "cannot add another\n", this.name);
			System.exit(1);
		}
		
		//add new card into array and increment card number
		this.hand[this.numCards] = card;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
	}
	
	public int getHandSum() {
		
		int handSum = 0;
		int cardNumber;
		int numAces = 0;
		
		//add each card value to total hand sum
		for (int c = 0; c < this.numCards; c++) {
			
			//get number for current card
			cardNumber = this.hand[c].getValue();
			
			if (cardNumber == 1) { //Ace
				numAces++;
				handSum += 11;
			} else if (cardNumber > 10) {
				handSum += 10;
			} else {
				handSum += cardNumber;
			}
		}
		
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		
		return handSum;
	}
	
	public void printHand(boolean showFirstCard) {
		
		System.out.printf("%s's cards:\n", this.name);
		for (int c = 0; c < this.numCards; c++) {
			if (c ==0 && !showFirstCard) {
			}else{
				System.out.printf("  %s\n", this.hand[c].toString());
			}
		}
	}
	
	
	
	
	

}
