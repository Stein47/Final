package blackJack;

public class Tests {
	
	public static void main(String[] args) throws Exception{
	
	Tests tests = new Tests();
	tests.testShuffle();
	tests.testDeckNumber();
	tests.testDealNextDecrementsTheDeck();
	tests.testDealToPlayer();
	tests.testEmptyHand();
	}
	
	//Tests what should be a non-shuffled and shuffled deck against each other
	public void testShuffle() {
		Deck deck1 = new Deck(1, false);
		Deck deck2 = new Deck(1, true);
		if (deck1.equals(deck2)) {
            throw new RuntimeException("): testShuffle Fail: deck after shuffle must be different.");
        }
        System.out.println(">> testShuffle passed.");
	}
        
	//Tests what should be a single deck and 6 decks against each other
	public void testDeckNumber() {
		Deck deck1 = new Deck(1, true);
		Deck deck2 = new Deck(6, true);
		if (deck1.equals(deck2)) {
            throw new RuntimeException("): testDeckNumber Fail: There should be a difference in number of decks used.");
        }
        System.out.println(">> testDeckNumber passed.");
	
	}
	
	//Tests that a card has been dealt and removed from the deck
	public void testDealNextDecrementsTheDeck() {
		Deck deck = new Deck(1, true);
		deck.dealNext();
		if (deck.getDeck() != 51) {
            throw new RuntimeException("): testDealNextDecrementsTheDeck Fail: Deck didn't decrement when dealing");
        }
        System.out.println(">> testDealNextDecrementsTheDeck passed.");
	}
	
	//If the Console prints any card, Then this test passes. this also tests the printing of hands
	public void testDealToPlayer() {
		Deck deck = new Deck(1, true);
		Player me = new Player("Austin");
		me.addCard(deck.dealNext());
		me.printHand(true);
	}
	
	//Tests for the emptying of a hand, used for the reset of games
	public void testEmptyHand() {
		Deck deck = new Deck(1, true);
		Player me = new Player("Austin");
		me.addCard(deck.dealNext());
		me.printHand(true);
		me.emptyHand();
		if (me.getHandSum() != 0) {
            throw new RuntimeException("): testEmptyHand Fail: Hand not empty");
        }
		System.out.println(">> testEmptyHand passed.");
	}//M01- Write code to throw a specific exception, write in the output of said exception
	
}








