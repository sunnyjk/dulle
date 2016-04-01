package momo.seoul.dulleapp.controller;

import android.content.Context;
import android.content.Intent;
import momo.seoul.dulleapp.model.User;
import momo.seoul.dulleapp.view.DistanceActivity;
import momo.seoul.dulleapp.view.MyAccountActivity;
import momo.seoul.dulleapp.view.SharingActivity;
import momo.seoul.dulleapp.view.StampActivity;
import momo.seoul.dulleapp.view.TimeActivity;


/*	MainController는 
 * 	Customize한 DulleListener interface를 implements 받아서
 * 	Activity(Controller)와 View를 연결시켜주는 역할	*/
public class MainController implements DulleListener{

	public static final String packageName = "momo.seoul.dulleapp";

	Context mCtx;
	
	public MainController(Context ctx) {
		this.mCtx = ctx;
	}
	
	public void switchOnOffService(){
		
	}
	
	@Override
	public void onGoToMyAccount(User user) {
		
		Intent i = new Intent(mCtx, MyAccountActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra("userId", user.getUserId());
		mCtx.startActivity(i);
		
	}

	@Override
	public void onGoToStamp() {
		
		Intent i = new Intent(mCtx, StampActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mCtx.startActivity(i);
	}

	@Override
	public void onGoToTime() {
		
		Intent i = new Intent(mCtx, TimeActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mCtx.startActivity(i);
	}

	@Override
	public void onGoToDistance() {
		
		Intent i = new Intent(mCtx, DistanceActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mCtx.startActivity(i);
		
	}

	@Override
	public void onGoToShare() {
		
		Intent i = new Intent(mCtx, SharingActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mCtx.startActivity(i);
		
	}


	
}
