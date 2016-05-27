package com.rupert.yatzyrefactor;

public class Yatzy {


    static int[] dice = new int[5];
    
    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
        
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
    }
    
    public int chance() {
    	int score = 0;
    	for (int i = 0; i <= 4; i++) {
    		score += dice[i];
    	}
    	return score;
    }

    public int yatzy() {
    	String same = "Y";
    	for (int i = 0; i <= 3; i++) {
    		if (dice[i]!=dice[1+i]) {
    			same = "N";
    		}
    	}
    	return (same.equals("Y")) ? 50 : 0;
    }
    
    public int ones() {
        return sameValueOnAllDice(1);
    }

    public int twos() {
    	return sameValueOnAllDice(2);
    }

    public int threes() {
    	return sameValueOnAllDice(3);
    }

    public int fours() {
    	return sameValueOnAllDice(4);
    }

    public int fives() {
    	return sameValueOnAllDice(5);
    }

    public int sixes() {
    	return sameValueOnAllDice(6);
    }

    private int sameValueOnAllDice(int n) {
    	int score = 0;
        for (int i = 0 ; i <= 4 ; i++) {
        	if (dice[i] == n) {
        		score += n;
        	}
        }
        return score;
    }
    
    public int score_pair() {
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

    public int two_pair() {
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
    
    public int three_of_a_kind() {
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
    
    public int four_of_a_kind() {
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

    public int smallStraight() {
        String smallStraight = "Y";
	    for (int i = 0 ; i <= 4 ; i++) {
        	if (dice[i] != i+1) {
	        	smallStraight = "N";
	        }
	    }
        return (smallStraight.equals("Y")) ? 15 : 0;
    }

    public int largeStraight () {
        String smallStraight = "Y";
	    for (int i = 0 ; i <= 4 ; i++) {
        	if (dice[i] != i+2) {
	        	smallStraight = "N";
	        }
	    }
        return (smallStraight.equals("Y")) ? 20 : 0;
    }

    public int fullHouse() {
    	int score = 0;
    	if (dice[0] == dice[1] && dice[1] == dice[2] && dice[3] == dice[4]) {
        	for (int i = 0; i <= 4; i++) {
        		score += dice[i];
        	}
        	return score;
    	}
    	
    	if (dice[4] == dice[3] && dice[3] == dice[2] && dice[1] == dice[0]) {
        	for (int i = 0; i <= 4; i++) {
        		score += dice[i];
        	}
        	return score;
    	}  	
    	return score;
    }
    
}