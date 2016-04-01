package momo.seoul.dulleapp.view;

import momo.seoul.dulleapp.R;
import momo.seoul.dulleapp.controller.StampController;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class StampActivity extends Activity{
	
	ListView listV;
	
	StampController stampController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stamp_page);
		
		stampController = new StampController(this);
		
		listV = (ListView) findViewById(R.id.stampDetailList);
		
	}
	
	private void showStampList(){
		
	}
}
