package momo.seoul.dulleapp.controller;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public class DistanceController {

	Context mCtx;

	LocationManager mLocManager;
	GPSProvider gps;
	
	double[] loc_first, loc_last;
	float[] distance;

	public DistanceController(Context ctx) {
		this.mCtx = ctx;

	}

	public void gpsOn() {
		mLocManager = (LocationManager) mCtx.getSystemService(Context.LOCATION_SERVICE);
		gps = new GPSProvider(mLocManager);
		

		loc_first = new double[2];
		loc_first[0] = gps.getLatitude();
		loc_first[1] = gps.getLongtitude();
		

	}

	public void gpsOff() {
		
		
		
		
	}

	public int showDistance() {
		return 0;
	}

	public void recordDistance() {
		
		loc_last = new double[2];
		loc_last[0] = gps.getLatitude();
		loc_last[1] = gps.getLongtitude();
		
		Location.distanceBetween(loc_first[0], loc_first[1], loc_last[0], loc_last[1], distance);
		
		// distance ¿˙¿Â
	}

}
