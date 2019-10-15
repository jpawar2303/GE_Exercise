package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

public class GEPassportTest {

    GEPassport testEngine;

    @Before
    public void setUp() {
        testEngine = new GEPassport("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GEPassport SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
    

    @Test
    
    public void TestGEPassport() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("enter flight hours: ");
		double hours = in.nextDouble();
    	testEngine.setFlightHours(hours);
    	System.out.println("Thrust to Weight Ratio of GEPassport = "+testEngine.thrustToWeightRatio());
        System.out.println("Flight Hours before rebuild GEPassport = "+testEngine.hoursLeftBeforeRebuild());
        System.out.println("Service life in Hours left for GEPassport = "+testEngine.serviceLifeLeftInEngine());
    }
}