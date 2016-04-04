package momo.seoul.dulleapp;

import momo.seoul.dulleapp.controller.NfcController;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

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
		
		/* Action Bar */
		ActionBar actionBar = getSupportActionBar();
		if(actionBar != null){
			actionBar.setBackgroundDrawable(new ColorDrawable(191919));
			//actionBar.setTitle(title);
		}
		
		TextView actionTitle = new TextView(getApplicationContext());
		
		LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		actionTitle.setLayoutParams(lp);
		actionTitle.setText("둘레길 시작하기");
		actionTitle.setGravity(Gravity.CENTER);
		actionTitle.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.otf"));
		actionTitle.setTextSize(15);
		
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setCustomView(actionTitle);
	

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
			// Stamp ���� Activity�� �����ֱ�
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
