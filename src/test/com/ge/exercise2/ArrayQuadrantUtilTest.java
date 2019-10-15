package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {
	
	char[][] data = {
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p'}
    };

	ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);;
	
    @Test
    public void getQuadrantValuesTest() {
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));

        char[] expectedResult = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0));
    }
    
    
    @Test
	public void getValueLeftToRightTest() {
		Assume.assumeNotNull(util.getValueLeftToRight(1));

        char[] expectedResult = {'e','f','g','h'};
        assertArrayEquals(expectedResult, util.getValueLeftToRight(1));
		
	}
    
    @Test
	public void getValueTopToBottom() {
    	Assume.assumeNotNull(util.getValueTopToBottom(0));

        char[] expectedResult = {'a', 'e', 'i', 'm'};
        assertArrayEquals(expectedResult, util.getValueTopToBottom(0));
	}
	

}