package blackJack;

/*
 * BlackJack Code
 * Author: Austin Raffelock
 * Date: 6/11/20
 */

import java.util.Scanner;

/*
 * This is the code that runs the game itself. Please note that you may play as many 
 * times as you want. each win will result in you gaining a point on the win counter.
 * Though i have not added prizes, please use your imagination to win something well
 * deserving of your win count at the end of your game. I hope you enjoy playing while 
 * you grade.
 */

public class BlackJackTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//first arg is #of decks, 2nd is for whether to shuffle or not
		Deck theDeck = new Deck(6, true); 
		
		//init players
		Player me = new Player("Austin");
		Player dealer = new Player("Dealer");
		
		boolean Continue = true;
		int winCount = 0;
		
		while (Continue == true) {
			
		
		me.emptyHand();
		dealer.emptyHand();
			
		me.addCard(theDeck.dealNext());
		dealer.addCard(theDeck.dealNext());
		me.addCard(theDeck.dealNext());
		dealer.addCard(theDeck.dealNext());
		
		
		//print initial hands
		System.out.println("Cards are dealt\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		//flags for when finished hitting
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while(!meDone || !dealerDone) {
			
			//player turn
			if (!meDone) {
				
				//anything other than an h will result in staying
				
				System.out.print("Hit or Stay? (Enter H or S): ");
				ans = sc.next();
				System.out.println();
				
				//if hit
				if (ans.compareToIgnoreCase("H") == 0) {
					//add card from deck, store if bust
					meDone = !me.addCard(theDeck.dealNext());
					me.printHand(true);
				}else {
					meDone = true;
				}
			}
			
			//dealer turn
			if (!dealerDone) {
				if (dealer.getHandSum() < 17) {
					System.out.println("The Dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNext());
					dealer.printHand(false);
				}else {
					System.out.println("The Dealer stays\n");
					dealerDone = true;
				}
			}
			System.out.println();
		}
				
		//print final hands
		me.printHand(true);
		dealer.printHand(true);
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
			System.out.println("You Win!");
			winCount++;
		} else {
			System.out.println("Dealer Wins!");
		}
		
		//Continue playing for prizes
		System.out.print("Keep Playing? (Enter Y or N): ");
		ans = sc.next();
		System.out.println();
		
		//if continuing
		if (ans.compareToIgnoreCase("Y") == 0) {
			//Continue playing
			Continue = true;
		}else {//Stop playing
			Continue = false;
		}
		
		}
		sc.close();
		System.out.println();
		System.out.println("Your win credit is " + winCount + ", please see the desk on your way out.");
	}
}
