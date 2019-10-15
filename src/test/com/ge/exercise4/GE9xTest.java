package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

public class GE9xTest {

    GE9x testEngine;

    @Before
    public void setUp() {
        testEngine = new GE9x("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GE9x SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
    
    @Test
    //New Test case added
    public void TestGE9x() {
    	Scanner in = new Scanner(System.in); 
    	System.out.println("enter flight hours: ");
		double hours = in.nextDouble();
    	testEngine.setFlightHours(hours);
        System.out.println("Thrust to Weight Ratio of GE9x = "+testEngine.thrustToWeightRatio());
        System.out.println("Flight Hours before rebuild GE9x = "+testEngine.hoursLeftBeforeRebuild());
        System.out.println("Service life in Hours left for GE9x = "+testEngine.serviceLifeLeftInEngine());
    }
}
