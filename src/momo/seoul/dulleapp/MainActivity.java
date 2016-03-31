package momo.seoul.dulleapp;

import android.app.Activity;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements
		OnBackStackChangedListener {
	
	private static final int MODE_TODAY = 0;
	private static final int MODE_TOTAL = 1;
	private static final int MODE_SHARE = 2;

	private Handler mHandler = new Handler();

	private boolean mShowingFront = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new MainFrontFragment()).commit();
		} else {
			mShowingFront = (getFragmentManager().getBackStackEntryCount() > 0);
		}

		getFragmentManager().addOnBackStackChangedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuItem item = menu.add(Menu.NONE, R.id.action_flip, Menu.NONE,
				mShowingFront ? R.string.action_flip_front
						: R.string.action_flip_back);
		item.setIcon(mShowingFront ? R.drawable.alert
				: R.drawable.search103);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
			return true;

		case R.id.action_flip:
			flipCard();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void flipCard() {
		if (mShowingFront) {
			getFragmentManager().popBackStack();
			return;
		}
		// Flip to the front.
		mShowingFront = true;

		getFragmentManager()
				.beginTransaction()
				.setCustomAnimations(R.animator.card_flip_right_in,
						R.animator.card_flip_right_out,
						R.animator.card_flip_left_in,
						R.animator.card_flip_left_out)
				.replace(R.id.container, new MainBackFragment())
				.addToBackStack(null).commit();
		
		mHandler.post(new Runnable() {
			
			@Override
			public void run() {
				invalidateOptionsMenu();
				
			}
		});

	}

	@Override
	public void onBackStackChanged() {
		mShowingFront = (getFragmentManager().getBackStackEntryCount() > 0);
		invalidateOptionsMenu();

	}
}
