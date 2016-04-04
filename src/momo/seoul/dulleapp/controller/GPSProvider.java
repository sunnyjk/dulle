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
				// 사용자의 위치가 변할 때마다 이를 감지해내는 메소드
				loc.getLatitude();
				loc.getLongitude();
			}
		};
		
		// 위치 정보를 가져올 때 고려되는 옵션
		criteria = new Criteria();	
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setSpeedRequired(false);
		criteria.setCostAllowed(true);
		
		// 주어진 옵션 조건에 가장 적합한 위치정보 제공자 설정
		bestProvider = mLocManager.getBestProvider(criteria, true);
		// 마지막으로 감지된 사용자의 위치 찾아내는 메소드
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
