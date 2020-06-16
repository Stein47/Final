package blackJack;

import java.util.Random;

import blackJack.Cards.Suit;
public class Deck {
	
	//Deck Array
	private Cards[] deck;
	
	//number of cards in deck
	private int numCards;
	
	/* this is a default deck*/
	public Deck() {
		//call on default for one deck minus shuffling
		this(1, false);
	}
	
	/*
	 * Defines number of deck, and if want to shuffle
	 * numDeck = number of decks in total
	 * shuffle is if shuffle is wanted
	 */
	public Deck(int numDecks, boolean shuffle) {
		this.numCards = numDecks * 52;
		this.deck = new Cards[this.numCards];
		
		//starting card index
		int c = 0;
		
		//for deck
		for (int d = 0; d < numDecks; d++) {
			
			//for suit
			for (int s = 0; s < 4; s++) {
				
				//for number
				for (int n = 1; n <= 13; n++) {
					
					//add new card
					this.deck[c] = new Cards(Suit.values()[s], n);
					c++;
				}
			}
		}
		
		//shuffle if needed
		if (shuffle) {
			this.shuffle();
		}
	}

	//shuffle by random card swapping
	public void shuffle() {
		
		//init RNG
		Random rng = new Random();
		
		//temp card
		Cards temp;
		
		int j;
		for (int i = 0; i < this.numCards; i++) {
				
			// get random card j to swap i
			j = rng.nextInt(this.numCards);
						
			//do swap
			temp = this.deck[i];
			this.deck[i] = this.deck[j];
			this.deck[j] = temp;
		}
	}

	//deal from top of deck
	public Cards dealNext() {
		
		//get top
		Cards top = this.deck[0];
		
		//remove top and shift rest up
		for (int c = 1; c < this.numCards; c++) {
			this.deck[c-1] = this.deck[c];
		}
		this.deck[this.numCards-1] = null;
		
		//cards in deck -1
		this.numCards--;
		
		return top;
	}
	
	//print top cards of deck
	public void printDeck(int numToPrint) {
		for (int c = 0; c < numToPrint; c++) {
			System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.deck[c].toString());
		}
		System.out.printf("\t\t[%d other]\n",  this.numCards-numToPrint);
	}

	public int getDeck() {
		return numCards;
	}











}
