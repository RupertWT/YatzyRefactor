package com.rupert.yatzyrefactor;

public class Yatzy {


    static int[] dice = new int[5];
    
    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
    	dice[0] = d1; dice[1] = d2; dice[2] = d3; dice[3] = d4; dice[4] = d5;
        
        int temp;
        for ( int i = 0; i <= 4; i ++ )  {
             for ( int j = i + 1; j <= 4; j ++) {
                  if( dice[ i ] > dice[ j ] ) {
                	  temp = dice[ i ];
                	  dice[ i ] = dice[ j ];
                	  dice[ j ] = temp; 
                  }           
             }
        }
        System.out.print(dice[0]);
        System.out.print(dice[1]);
        System.out.print(dice[2]);
        System.out.print(dice[3]);
        System.out.println(dice[4]);
    }
 
    public int chanceCategory() {
    	int score = 0;
    	for (int i = 0; i <= 4; i++) {
    		score += dice[i];
    	}
    	return score;
    }

    public int yatzyCategory() {
    	for (int i = 0; i <= 3; i++) {
    		if (dice[i]!=dice[1+i]) {
    			return 0;
    		}
    	}
    	return 50;
    }

    public int onesCategory() {
        return checkForValueOnAllDiceAndAddToScore(1);
    }

    public int twosCategory() {
    	return checkForValueOnAllDiceAndAddToScore(2);
    }

    public int threesCategory() {
    	return checkForValueOnAllDiceAndAddToScore(3);
    }

    public int foursCategory() {
    	return checkForValueOnAllDiceAndAddToScore(4);
    }

    public int fivesCategory() {
    	return checkForValueOnAllDiceAndAddToScore(5);
    }

    public int sixesCategory() {
    	return checkForValueOnAllDiceAndAddToScore(6);
    }
    
    private int checkForValueOnAllDiceAndAddToScore(int n) {
    	int score = 0;
        for (int i = 0 ; i <= 4 ; i++) {
        	if (dice[i] == n) {
        		score += n;
        	}
        }
        return score;
    }    
    
    public int smallStraightCategory() {
    	return (checkForStraights(1)) ? 15 : 0;
    }

    public int largeStraightCategory () {
        return (checkForStraights(2)) ? 20 : 0;
    }

    private boolean checkForStraights(int type) {
		
	    for (int i = 0 ; i <= 4 ; i++) {
        	if (dice[i] != i+type) {
        		return false;
	        }
	    }
	    return true;
	}
    
    public int fullHouseCategory() {
       
    	if (dice[0] == dice[1] && dice[1] == dice[2] && dice[3] == dice[4]) {
    		return sumAllDiceInPool();
    	}
    	
    	if (dice[4] == dice[3] && dice[3] == dice[2] && dice[1] == dice[0]) {
    		return sumAllDiceInPool();
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
    
    
    
    
    
    
    
    
    
    
    
    public int onePairCategory() {
        int[] counts = new int[6];
        counts[dice[0]-1]++;
        counts[dice[1]-1]++;
        counts[dice[2]-1]++;
        counts[dice[3]-1]++;
        counts[dice[4]-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public int twoPairCategory() {
        int[] counts = new int[6];
        counts[dice[0]-1]++;
        counts[dice[1]-1]++;
        counts[dice[2]-1]++;
        counts[dice[3]-1]++;
        counts[dice[4]-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }
    
    public int threeOfAKindCategory() {
        int[] t;
        t = new int[6];
        t[dice[0]-1]++;
        t[dice[1]-1]++;
        t[dice[2]-1]++;
        t[dice[3]-1]++;
        t[dice[4]-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }
    
    public int fourOfAKindCategory() {
        int[] tallies;
        tallies = new int[6];
        tallies[dice[1]-1]++;
        tallies[dice[2]-1]++;
        tallies[dice[2]-1]++;
        tallies[dice[3]-1]++;
        tallies[dice[4]-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }
    
}