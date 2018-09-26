
public class PokerHand {
	
	int[] values = new int[5]; // T=10, J=11, Q=12, K=13, A=14
	int[] suits = new int[5]; // S=1, H=2, C=3, D=4
	
	int[] handStrength;
	
	public PokerHand(String str) {
		String[] cards = str.split(" ");
		for (int i = 0; i < cards.length; i++) {
			char v = cards[i].charAt(0);
			char s = cards[i].charAt(1);
			
			if (v == 'A') { values[i] = 14; }
			else if (v == 'T') { values[i] = 10; }
			else if (v == 'J') { values[i] = 11; }
			else if (v == 'Q') { values[i] = 12; }
			else if (v == 'K') { values[i] = 13; }
			else { values[i] = v-'0'; }
			
			if (s == 'S') { suits[i] = 1; }
			else if (s == 'H') { suits[i] = 2; }
			else if (s == 'C') { suits[i] = 3; }
			else if (s == 'D') { suits[i] = 4; }
			else { suits[i] = 0; }
		}
	}
	
	public int[] calculateStrength() {
		this.sort();
		
		if (this.isRoyalFlush()) {
			this.handStrength = new int[] {10};
		} else if (this.isStraightFlush()) {
			this.handStrength = new int[] {9, this.values[4]};
		} else if (this.isFourOfAKind()) {
			this.handStrength = new int[3];
			this.handStrength[0] = 8;
			this.handStrength[1] = this.values[2];
			if (this.values[0] == this.values[1]) {
				this.handStrength[2] = this.values[4];
			} else {
				this.handStrength[2] = this.values[0];
			}
		} else if (this.isFullHouse()) {
			this.handStrength = new int[3];
			this.handStrength[0] = 7;
			if (this.values[0] == this.values[2]) {
				this.handStrength[1] = this.values[0];
				this.handStrength[2] = this.values[3];
			} else {
				this.handStrength[1] = this.values[2];
				this.handStrength[2] = this.values[0];
			}
		} else if (this.isFlush()) {
			this.handStrength = new int[] {6, this.values[4], this.values[3], this.values[2], this.values[1], this.values[0]};
		} else if (this.isStraight()) {
			this.handStrength = new int[] {5, this.values[4]};
		} else if (this.isThreeOfAKind()) {
			this.handStrength = new int[4];
			this.handStrength[0] = 4;
			if (this.values[0] == this.values[2]) {
				this.handStrength[1] = this.values[0];
				this.handStrength[2] = this.values[4];
				this.handStrength[3] = this.values[3];
			} else if (this.values[1] == this.values[3]) {
				this.handStrength[1] = this.values[1];
				this.handStrength[2] = this.values[4];
				this.handStrength[3] = this.values[0];
			} else {
				this.handStrength[1] = this.values[2];
				this.handStrength[2] = this.values[1];
				this.handStrength[3] = this.values[0];
			}
		} else if (this.isTwoPair()) {
			this.handStrength = new int[4];
			this.handStrength[0] = 3;
			this.handStrength[1] = this.values[3];
			this.handStrength[2] = this.values[1];
			if (this.values[0] != this.values[1]) {
				this.handStrength[3] = this.values[0];
			} else if (this.values[3] != this.values[4]) {
				this.handStrength[3] = this.values[4];
			} else {
				this.handStrength[3] = this.values[2];
			}
		} else if (this.isPair()) {
			this.handStrength = new int[5];
			this.handStrength[0] = 2;
			if (this.values[0] == this.values[1]) {
				this.handStrength[1] = this.values[0];
				this.handStrength[2] = this.values[4];
				this.handStrength[3] = this.values[3];
				this.handStrength[4] = this.values[2];
			} else if (this.values[1] == this.values[2]) {
				this.handStrength[1] = this.values[1];
				this.handStrength[2] = this.values[4];
				this.handStrength[3] = this.values[3];
				this.handStrength[4] = this.values[0];
			} else if (this.values[2] == this.values[3]) {
				this.handStrength[1] = this.values[2];
				this.handStrength[2] = this.values[4];
				this.handStrength[3] = this.values[1];
				this.handStrength[4] = this.values[0];
			} else {
				this.handStrength[1] = this.values[3];
				this.handStrength[2] = this.values[2];
				this.handStrength[3] = this.values[1];
				this.handStrength[4] = this.values[0];
			}
		} else {
			this.handStrength = new int[] {1, this.values[4], this.values[3], this.values[2], this.values[1], this.values[0]};
		}
		
		return this.handStrength;
	}
	
	private boolean isRoyalFlush() {
		if (this.isFlush() && this.isStraight() && values[4] == 14) {
			return true;
		}
		return false;
	}
	
	private boolean isStraightFlush() {
		if (this.isStraight() && this.isFlush()) {
			return true;
		}
		return false;
	}
	
	private boolean isFourOfAKind() {
		if (values[4] == values[1] || values[0] == values[3]) {
			return true;
		}
		return false;
	}
	
	private boolean isFullHouse() {
		if ((values[4] == values[2] && values[1] == values[0]) || (values[4] == values[3] && values[2] == values[0])) {
			return true;
		}
		else return false;
	}
	
	private boolean isFlush() {
		for (int i = 0; i < 4; i++) {
			if (suits[i] != suits[4]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isStraight() {
		if (values[0] == 2 && values[1] == 3 && values[2] == 4 && values[3] == 5 && values[4] == 14) {
			return true;
		}
		for (int i = 0; i < 4; i++) {
			if (values[i] + 1 != values[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isThreeOfAKind() {
		for (int i = 0; i < 3; i++) {
			if (values[i] == values[i+2]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isTwoPair() {
		if ((values[0] == values[1] && values[2] == values[3])
				|| (values[0] == values[1] && values[3] == values[4])
				|| (values[1] == values[2] && values[3] == values[4])) {
			return true;
		}
		return false;
	}
	
	private boolean isPair() {
		for (int i = 0; i < 4; i++) {
			if (values[i] == values[i+1]) {
				return true;
			}
		}
		return false;
	}
	
	private void sort() {
		for (int i = 0; i < 4; i++) {
			if (values[i] > values[i+1]) {
				int tempV = values[i];
				int tempS = suits[i];
				values[i] = values[i+1];
				suits[i] = suits[i+1];
				values[i+1] = tempV;
				suits[i+1] = tempS;
				i = -1;
			} else if (values[i] == values[i+1] && suits[i] > suits[i+1]) {
				int temp = suits[i];
				suits[i] = suits[i+1];
				suits[i+1] = temp;
				i = -1;
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < 5; i++) {
			if (values[i] == 14) str += 'A';
			else if (values[i] == 13) str += 'K';
			else if (values[i] == 12) str += 'Q';
			else if (values[i] == 11) str += 'J';
			else if (values[i] == 10) str += 'T';
			else str += values[i];
			
			if (suits[i] == 4) str += 'D';
			else if (suits[i] == 3) str += 'C';
			else if (suits[i] == 2) str += 'H';
			else str += 'S';
			
			str += " ";
		}
		return str;
	}
	
}
