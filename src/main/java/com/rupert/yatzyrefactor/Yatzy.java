package com.rupert.yatzyrefactor;

public class Yatzy {

    static int[] dice = new int[5];
    
    public Yatzy(int d1, int d2, int d3, int d4, int d5) { 	
    	setArray(d1, d2, d3, d4, d5);   
        sortToNumericalOrder();
    }

	private void setArray(int d1, int d2, int d3, int d4, int d5) {
		dice[0] = d1; 
    	dice[1] = d2; 
    	dice[2] = d3; 
    	dice[3] = d4; 
    	dice[4] = d5;
	}

	private void sortToNumericalOrder() {
		int temp;
        for (int i = 0; i <= 4; i++)  {
             for (int j = i+1; j <= 4; j++) {
                  if(dice[i] > dice[j]) {
                	  temp = dice[i];
                	  dice[i] = dice[j];
                	  dice[j] = temp; 
                  }           
             }
        }
	}
 
	
    public int chanceCategory() {
    	return sumAllDiceInPool();
    }

    public int yatzyCategory() {
    	for (int i = 0; i < 4; i++) {
    		if (dice[i] != dice[1+i]) {
    			return 0;
    		}
    	}
    	return 50;
    }

    public int onesCategory() {
    	return (countOfDieWithValueX(1)*1);
    }

    public int twosCategory() {
    	return (countOfDieWithValueX(2)*2);
    }

    public int threesCategory() {
    	return (countOfDieWithValueX(3)*3);
    }

    public int foursCategory() {
    	return (countOfDieWithValueX(4)*4);
    }

    public int fivesCategory() {
    	return (countOfDieWithValueX(5)*5);
    }

    public int sixesCategory() {
    	return (countOfDieWithValueX(6)*6);
    }

    public int smallStraightCategory() {
    	return (checkForStraights(1)) ? 15 : 0;
    }

    public int largeStraightCategory () {
    	return (checkForStraights(2)) ? 20 : 0;
    }
    
    public int fullHouseCategory() {
    	if (firstThreeDiceTheSame() && lastTwoDiceTheSame()) {
    		return sumAllDiceInPool();
    	}
    	if (firstTwoDiceTheSame() && lastThreeDiceTheSame()) {
    		return sumAllDiceInPool();
    	}  	
    	return 0;
    }
    
    public int onePairCategory() {
    	int score = 0;
    	for (int i = 0; i < 4; i++) {
    		if (dice[i] == dice[i+1] && dice[i] > score) {
    			score = dice[i];
    		}
    	}
    	return score*2;
    }    

    public int twoPairCategory() {
    	int countOfDifferentPairs = 0;
    	int currentDiceValue = 0;
    	int previousDiceValue = 0;
    	for (int i = 0; i < 4; i++) {
        	if (currentDiceValue != dice[i] && dice[i] == dice[i+1]) {
        		previousDiceValue = currentDiceValue;
        		currentDiceValue = dice[i];
        		countOfDifferentPairs++;
	        }
    	}
    	
    	if (countOfDifferentPairs == 2) {
    		return previousDiceValue * 2 + currentDiceValue * 2;
    	}	
    	return 0;
    }
    
    public int threeOfAKindCategory() {
    	if (findXNumberOfAKind(3)) {
    		return dice[2] * 3;
    	}
     	return 0;
    }
        
    public int fourOfAKindCategory() {	
    	if (findXNumberOfAKind(4)) {
    		return dice[2] * 4;
    	}
     	return 0;
    }
        
    private int sumAllDiceInPool() {  	
    	int score = 0;
    	for (int i = 0; i <= 4; i++) {
        	score += dice[i];
        }
        return score;
    }
    
    private boolean checkForStraights(int type) {	
    	for (int i = 0 ; i <= 4 ; i++) {
        	if (dice[i] != i+type) {
        		return false;
	        }
	    }
	    return true;
	}
    
    private boolean firstThreeDiceTheSame() {
		return dice[0] == dice[1] && dice[1] == dice[2];
	}
	
	private boolean lastTwoDiceTheSame() {
		return dice[3] == dice[4];
	}
	
	private boolean firstTwoDiceTheSame() {
		return dice[1] == dice[0];
	}

	private boolean lastThreeDiceTheSame() {
		return dice[2] == dice[3] && dice[3] == dice[4];
	}
    
    private int countOfDieWithValueX(int n) {
    	int score = 0;
        for (int i = 0 ; i <= 4 ; i++) {
        	if (dice[i] == n) {
        		score ++;
        	}
        }
        return score;
    }    
        
    private boolean findXNumberOfAKind(int x) {
    	for(int i = 1; i <= 6; i++) {
    		if (countOfDieWithValueX(i) >= x) {
    			return true;
    		}
    	}
    	return false;
    }
    
}














