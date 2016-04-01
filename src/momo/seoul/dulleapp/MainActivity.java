package momo.seoul.dulleapp;

import momo.seoul.dulleapp.controller.NfcController;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private static final int MODE_TODAY = 0;
	private static final int MODE_TOTAL = 1;
	private static final int MODE_SHARE = 2;

	private Handler mHandler = new Handler();

	/**
	 * Related with ViewPager
	 */

	Button btn[] = new Button[3];
	ViewPager viewPager = null;
	Thread thread = null;
	Handler handler = null;

	private boolean mShowingFront = false;
	
	NfcController nfcController;
	
	public MainActivity() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		/* viewPager */
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		MyViewPagerAdapter adapter = new MyViewPagerAdapter(
				getSupportFragmentManager());

		viewPager.setAdapter(adapter);
		viewPager.setOffscreenPageLimit(2);

		btn[0] = (Button) findViewById(R.id.btnToday);
		btn[1] = (Button) findViewById(R.id.btnTotal);
		btn[2] = (Button) findViewById(R.id.btnShare);

		for (int i = 0; i < btn.length; i++) {
			btn[i].setOnClickListener(this);
		}
		
		/* NFC Controller */
	
		// 에뮬레이터는 NFC 사용 불가
/*		nfcController = new NfcController(this);
		
		if(!nfcController.checkNfcAdapter()){
			finish();
		}
		
		nfcController.getNfcData(getIntent());*/
	
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		
		if(intent.getStringExtra("stamp_result")!=null){
			// setContentView(MODE_STAMPBOOK);
			// Stamp 관련 Activity로 보내주기
		}

//		setIntent(intent);
//		nfcController.getNfcData(intent);
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnToday:
			viewPager.setCurrentItem(MODE_TODAY);
			break;
		case R.id.btnTotal:
			viewPager.setCurrentItem(MODE_TOTAL);
			break;
		case R.id.btnShare:
			viewPager.setCurrentItem(MODE_SHARE);
			break;

		default:
			break;
		}
		
	}


}
