package momo.seoul.dulleapp.controller;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GPSProvider {
	
	LocationManager mLocManager;
	LocationListener mLocListener;
	String provider;
	Location location;
	String bestProvider;
	Criteria criteria;
	
	public GPSProvider(LocationManager mLocManager){
		this.mLocManager = mLocManager;
		mLocListener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			
			@Override
			public void onProviderEnabled(String provider) {}
			
			@Override
			public void onProviderDisabled(String provider) {}
			
			@Override
			public void onLocationChanged(Location loc) {
				// ������� ��ġ�� ���� ������ �̸� �����س��� �޼ҵ�
				loc.getLatitude();
				loc.getLongitude();
			}
		};
		
		// ��ġ�� ������ ���� �ɼ�
		criteria = new Criteria();	
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setSpeedRequired(false);
		criteria.setCostAllowed(true);
		
		// �־��� �ɼ� ���ǿ� �´� ���� ������ ��ġ ���� ������ ����
		bestProvider = mLocManager.getBestProvider(criteria, true);
		// ���������� ������ ������� ��ġ �˻� �޼ҵ�
		location = mLocManager.getLastKnownLocation(bestProvider);
				
	}
	
	public double getLatitude(){
		bestProvider = mLocManager.getBestProvider(criteria, true);
		mLocManager.requestLocationUpdates(bestProvider, 0, 0, mLocListener);
		location = mLocManager.getLastKnownLocation(bestProvider);
				
		return location.getLatitude();
	}
	
	public double getLongtitude(){
		bestProvider = mLocManager.getBestProvider(criteria, true);
		mLocManager.requestLocationUpdates(bestProvider, 0, 0, mLocListener);
		location = mLocManager.getLastKnownLocation(bestProvider);
				
		return location.getLongitude();
	}

}
