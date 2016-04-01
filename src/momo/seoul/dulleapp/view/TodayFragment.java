package momo.seoul.dulleapp.view;

import momo.seoul.dulleapp.MainActivity;
import momo.seoul.dulleapp.R;
import momo.seoul.dulleapp.controller.MainController;
import momo.seoul.dulleapp.model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TodayFragment extends Fragment implements OnClickListener{
	
	TextView tvUserId, tvStamp, tvTime, tvDistance;
	Button btnOnOff, btnMyAccount;
	
	View view;

	MainController mController;
	Context mCtx;
	User user;
	
	public TodayFragment(){
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		mCtx = activity.getApplicationContext();
		Log.i("MyLog", "class path: " + mCtx.getPackageName());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mController = new MainController(mCtx); 
		
		view = inflater.inflate(R.layout.fragment_today, container, false);
		
		tvUserId = (TextView) view.findViewById(R.id.tvUserId);
		tvStamp = (TextView) view.findViewById(R.id.tvStamp);
		tvTime = (TextView) view.findViewById(R.id.tvTime);
		tvDistance = (TextView) view.findViewById(R.id.tvDistance);
		
		btnOnOff = (Button) view.findViewById(R.id.btnOnOff);
		btnMyAccount = (Button) view.findViewById(R.id.btnMyAccount);
		
		btnOnOff.setOnClickListener(this);
		btnMyAccount.setOnClickListener(this);
		
		user = new User();
		user.setUserId(tvUserId.getText().toString());
		
		
		return view;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnOnOff:
			
			break;

		case R.id.btnMyAccount:
			//startActivity(new Intent(mCtx.getApplicationContext(), MyAccountActivity.class));
			mController.onGoToMyAccount(user);
			break;
			
		default:
			break;
		}
	}

}
