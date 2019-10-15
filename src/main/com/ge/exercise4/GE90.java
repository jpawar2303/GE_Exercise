package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE90 {
    private static final Logger logger = LogManager.getLogger(GE90.class);

    private static final String ENGINE_MODEL = GE90.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 3;
    public final double flightHoursBeforeRebuild = 25_000;
    public final double dryWeight = 14_502;
    public final double wetWeight = 15_100;
    public final double takeoffThrust = 81_070;

    
    private double flightHours;
    private int numRebuilds;

    public GE90(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GE90(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE90(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    public double thrustToWeightRatio() {
        return takeoffThrust / dryWeight;
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }
    
    public double hoursLeftBeforeRebuild() {
		// TODO Auto-generated method stub
    	double hrsLeftForRebuild;
    	numRebuilds = (int)(flightHours/flightHoursBeforeRebuild);
    	//hrsLeftForRebuild = flightHours - (numRebuilds * flightHoursBeforeRebuild);
    	hrsLeftForRebuild = (numRebuilds+1) * flightHoursBeforeRebuild - flightHours;
    	return hrsLeftForRebuild; 
	}
    
    public double serviceLifeLeftInEngine() {
		// TODO Auto-generated method stub
    	double serviceHrsLeft, currentFlightHrs ;
    	numRebuilds = (int)(flightHours/flightHoursBeforeRebuild);
    	currentFlightHrs = flightHoursBeforeRebuild - hoursLeftBeforeRebuild();
    	serviceHrsLeft = (maxNumRebuilds - numRebuilds) * flightHoursBeforeRebuild - currentFlightHrs;
    	return serviceHrsLeft;
	}

}
