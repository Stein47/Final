package blackJack;

public class Cards {
	enum Suit {
        HEARTS,
        CLUBS,
        DIAMONDS,
        SPADES
	}
	
	
	private Suit suit;
	
	private int value;
	
	//M03- Use of a Generic Class through use of created parameters
	public Cards(Suit suit, int value) {
        this.suit = suit;
        
        if(value >= 1 && value <= 13) {
        this.value = value;
        }else {
        	System.err.println(value + " is not a valid Card number");
        	System.exit(1);
        }
    }
	
	public Suit getSuit() {
        return this.suit;
    }
	
	public int getValue() {
        return value;
    }
	
	//M05- Use of Annotations to override the string method
	@Override
    public String toString() {
               
        String numStr = "None";
        
        switch(this.value) {
        
        case 1:
        	numStr = "Ace";
        	break;
        
        case 2:
        	numStr = "Two";
        	break;
        	
        case 3:
        	numStr = "Three";
        	break;
        	
        case 4:
        	numStr = "Four";
        	break;
        	
        case 5:
        	numStr = "Five";
        	break;
        	
        case 6:
        	numStr = "Six";
        	break;
        	
        case 7:
        	numStr = "Seven";
        	break;
        	
        case 8:
        	numStr = "Eight";
        	break;
        	
        case 9:
        	numStr = "Nine";
        	break;
        	
        case 10:
        	numStr = "Ten";
        	break;
        	
        case 11:
        	numStr = "Jack";
        	break;
        	
        case 12:
        	numStr = "Queen";
        	break;
        	
        case 13:
        	numStr = "King";
        	break;
        }
        
      return numStr + " of " + this.suit.toString();
               
    }
}
