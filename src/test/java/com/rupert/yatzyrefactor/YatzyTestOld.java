package com.rupert.yatzyrefactor;

import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTestOld {

	 @Test
	    public void chance_scores_sum_of_all_dice() {
	        int expected = 15;
	        int actual = YatzyOld.chance(2,3,4,5,1);
	        assertEquals(expected, actual);
	        assertEquals(16, YatzyOld.chance(3,3,4,5,1));
	    }

	    @Test public void yatzy_scores_50() {
	        int expected = 50;
	        int actual = YatzyOld.yatzy(4,4,4,4,4);
	        assertEquals(expected, actual);
	        assertEquals(50, YatzyOld.yatzy(6,6,6,6,6));
	        assertEquals(0, YatzyOld.yatzy(6,6,6,6,3));
	    }

	    @Test public void test_1s() {
	        assertTrue(YatzyOld.ones(1,2,3,4,5) == 1);
	        assertEquals(2, YatzyOld.ones(1,2,1,4,5));
	        assertEquals(0, YatzyOld.ones(6,2,2,4,5));
	        assertEquals(4, YatzyOld.ones(1,2,1,1,1));
	    }

	    @Test
	    public void test_2s() {
	        assertEquals(4, YatzyOld.twos(1,2,3,2,6));
	        assertEquals(10, YatzyOld.twos(2,2,2,2,2));
	    }

	    @Test
	    public void test_threes() {
	        assertEquals(6, YatzyOld.threes(1,2,3,2,3));
	        assertEquals(12, YatzyOld.threes(2,3,3,3,3));
	    }

	    @Test
	    public void fours_test() 
	    {
	        assertEquals(12, new YatzyOld(4,4,4,5,5).fours());
	        assertEquals(8, new YatzyOld(4,4,5,5,5).fours());
	        assertEquals(4, new YatzyOld(4,5,5,5,5).fours());
	    }

	    @Test
	    public void fives() {
	        assertEquals(10, new YatzyOld(4,4,4,5,5).fives());
	        assertEquals(15, new YatzyOld(4,4,5,5,5).fives());
	        assertEquals(20, new YatzyOld(4,5,5,5,5).fives());
	    }

	    @Test
	    public void sixes_test() {
	        assertEquals(0, new YatzyOld(4,4,4,5,5).sixes());
	        assertEquals(6, new YatzyOld(4,4,6,5,5).sixes());
	        assertEquals(18, new YatzyOld(6,5,6,6,5).sixes());
	    }

	    @Test
	    public void one_pair() {
	        assertEquals(6, YatzyOld.score_pair(3,4,3,5,6));
	        assertEquals(10, YatzyOld.score_pair(5,3,3,3,5));
	        assertEquals(12, YatzyOld.score_pair(5,3,6,6,5));
	    }

	    @Test
	    public void two_Pair() {
	        assertEquals(16, YatzyOld.two_pair(3,3,5,4,5));
	        assertEquals(16, YatzyOld.two_pair(3,3,5,5,5));
	    }

	    @Test
	    public void three_of_a_kind() 
	    {
	        assertEquals(9, YatzyOld.three_of_a_kind(3,3,3,4,5));
	        assertEquals(15, YatzyOld.three_of_a_kind(5,3,5,4,5));
	        assertEquals(9, YatzyOld.three_of_a_kind(3,3,3,3,5));
	    }

	    @Test
	    public void four_of_a_knd() {
	        assertEquals(12, YatzyOld.four_of_a_kind(3,3,3,3,5));
	        assertEquals(20, YatzyOld.four_of_a_kind(5,5,5,4,5));
	        assertEquals(9, YatzyOld.three_of_a_kind(3,3,3,3,3));
	    }

	    @Test
	    public void smallStraight() {
	        assertEquals(15, YatzyOld.smallStraight(1,2,3,4,5));
	        assertEquals(15, YatzyOld.smallStraight(2,3,4,5,1));
	        assertEquals(0, YatzyOld.smallStraight(1,2,2,4,5));
	    }

	    @Test
	    public void largeStraight() {
	        assertEquals(20, YatzyOld.largeStraight(6,2,3,4,5));
	        assertEquals(20, YatzyOld.largeStraight(2,3,4,5,6));
	        assertEquals(0, YatzyOld.largeStraight(1,2,2,4,5));
	    }

	    @Test
	    public void fullHouse() {
	        assertEquals(18, YatzyOld.fullHouse(6,2,2,2,6));
	        assertEquals(0, YatzyOld.fullHouse(2,3,4,5,6));
	    }
	}