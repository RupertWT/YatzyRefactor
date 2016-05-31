package com.rupert.yatzyrefactor;

import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chanceScoresSumOfAllDice() {
    	assertEquals(15, new Yatzy(2,3,4,5,1).chanceCategory());
        assertEquals(16, new Yatzy(3,3,4,5,1).chanceCategory());
    }

    @Test 
    public void yatzyScoresFifty() {
    	assertEquals(50, new Yatzy(4,4,4,4,4).yatzyCategory());
    	assertEquals(50, new Yatzy(6,6,6,6,6).yatzyCategory());
    	assertEquals(0, new Yatzy(6,6,6,6,3).yatzyCategory());
    	assertEquals(0, new Yatzy(5,4,6,5,5).yatzyCategory());
    }

    @Test 
    public void onesScoreSumOfAllOnes() {
    	assertEquals(1, new Yatzy(1,2,3,4,5).onesCategory());
        assertEquals(2, new Yatzy(1,2,1,4,5).onesCategory());
        assertEquals(0, new Yatzy(6,2,2,4,5).onesCategory());
        assertEquals(4, new Yatzy(1,2,1,1,1).onesCategory());
    }

    @Test
    public void twosScoreSumOfAllTwos() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twosCategory());
        assertEquals(10, new Yatzy(2,2,2,2,2).twosCategory());
    }

    @Test
    public void threesScoreSumOfAllThrees() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threesCategory());
        assertEquals(12, new Yatzy(2,3,3,3,3).threesCategory());
    }

    @Test
    public void foursScoreSumOfAllFours() {
        assertEquals(12, new Yatzy(4,4,4,5,5).foursCategory());
        assertEquals(8, new Yatzy(4,4,5,5,5).foursCategory());
        assertEquals(4, new Yatzy(4,5,5,5,5).foursCategory());
    }

    @Test
    public void fivesScoreSumOfAllFives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fivesCategory());
        assertEquals(15, new Yatzy(4,4,5,5,5).fivesCategory());
        assertEquals(20, new Yatzy(4,5,5,5,5).fivesCategory());
    }

    @Test
    public void sixesScoreSumOfAllSixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixesCategory());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixesCategory());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixesCategory());
    }

    @Test
    public void onePairScoresSumOfHighestPair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).onePairCategory());
        assertEquals(10, new Yatzy(5,3,3,3,5).onePairCategory());
        assertEquals(12, new Yatzy(5,3,6,6,5).onePairCategory());
    }

    @Test
    public void twoDifferentPairScoresSumOfHighestPairs() {
        assertEquals(16, new Yatzy(3,3,5,4,5).twoPairCategory());
        assertEquals(16, new Yatzy(3,3,5,5,5).twoPairCategory());
        assertEquals(14, new Yatzy(3,3,4,5,4).twoPairCategory());
    }

    @Test
    public void threeOfAKindScoresSumOfTheseDice() {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfAKindCategory());
        assertEquals(9, new Yatzy(4,3,3,3,5).threeOfAKindCategory());
        assertEquals(9, new Yatzy(4,5,3,3,3).threeOfAKindCategory());
        assertEquals(15, new Yatzy(5,3,5,4,5).threeOfAKindCategory());
        assertEquals(9, new Yatzy(3,3,3,3,5).threeOfAKindCategory());
        assertEquals(9, new Yatzy(3,3,3,3,3).threeOfAKindCategory());
    }

    @Test
    public void fourOfAKindScoresSumOfTheseDice() {
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfAKindCategory());
        assertEquals(20, new Yatzy(5,5,5,4,5).fourOfAKindCategory());
        assertEquals(20, new Yatzy(5,5,5,5,5).fourOfAKindCategory());

    }

    @Test
    public void smallStraightScoresFifteen() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraightCategory());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraightCategory());
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraightCategory());
    }

    @Test
    public void largeStraightScoresTwenty() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraightCategory());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraightCategory());
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraightCategory());
    }

    @Test
    public void fullHouseScoresSumOfAllDice() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouseCategory());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouseCategory());
    }
}