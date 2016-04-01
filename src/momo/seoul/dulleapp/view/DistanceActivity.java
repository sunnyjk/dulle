package momo.seoul.dulleapp.view;

import momo.seoul.dulleapp.R;
import momo.seoul.dulleapp.controller.DistanceController;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DistanceActivity extends Activity{
	
	ListView listV;
	
	DistanceController distanceController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance_page);
		
		distanceController = new DistanceController(this);
		
		listV = (ListView) findViewById(R.id.distanceDetailList);
		
		
	}
}
