package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

public class GENxTest {

    GENx testEngine;

    @Before
    public void setUp() {
        testEngine = new GENx("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GENx SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
   
    @Test
    public void TestGENx() {
    	Scanner in = new Scanner(System.in); 
    	System.out.println("enter flight hours: ");
		double hours = in.nextDouble();
    	testEngine.setFlightHours(hours);
    	System.out.println("Thrust to Weight Ratio of GENx = "+testEngine.thrustToWeightRatio());
        System.out.println("Flight Hours before rebuild GENx = "+testEngine.hoursLeftBeforeRebuild());
        System.out.println("Service life in Hours left for GENx = "+testEngine.serviceLifeLeftInEngine());
    }
}