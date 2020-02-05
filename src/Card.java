public class Card {
	public enum SuitType {OROS,COPAS,ESPADAS, BASTOS};
	private int number;
	private SuitType suit;
	
	public Card(int number, SuitType suit) {
		this.number= number ;
		this.suit = suit;
	}
	public String toString() {
		String suitString="";
		switch (suit) {
			case OROS: suitString="oros";
				break;
			case COPAS: suitString="copas";
				break;
			case ESPADAS: suitString="espadas";
				break;
			case BASTOS: suitString="bastos";
				break;
		}
		return number+" de "+suitString;
	}
}