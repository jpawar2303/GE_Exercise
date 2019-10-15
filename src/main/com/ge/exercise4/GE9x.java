package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE9x {
    private static final Logger logger = LogManager.getLogger(GE90.class);

    private static final String ENGINE_MODEL = GE9x.class.getSimpleName();
    private final String serialNumber;

    public final int maxNumRebuilds = 5;
    public final double flightHoursBeforeRebuild = 30_000;
    public final double dryWeight = 15_505;
    public final double wetWeight = 15_900;
    public final double takeoffThrust = 100_000;

    private double flightHours;
    private int numRebuilds;

    public GE9x(String serialNumber, double flightHours, int numRebuilds) {
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    public GE9x(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE9x(String serialNumber) {
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
