package momo.seoul.dulleapp.view;

import momo.seoul.dulleapp.R;
import momo.seoul.dulleapp.controller.MainController;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DashBoardFragment extends Fragment implements OnClickListener {

	View v;

	Button btnStamp, btnTime, btnDistance, btnShare;
	
	Context mCtx;
	MainController mainController;

	public DashBoardFragment() {

	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mCtx = activity.getApplicationContext();
		mainController = new MainController(mCtx);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_dashboard, container, false);

		btnStamp = (Button) v.findViewById(R.id.btnGoToStamp);
		btnTime = (Button) v.findViewById(R.id.btnGoToTime);
		btnDistance = (Button) v.findViewById(R.id.btnGoToDistance);
		btnShare = (Button) v.findViewById(R.id.btnGoToShare);

		btnStamp.setOnClickListener(this);
		btnTime.setOnClickListener(this);
		btnDistance.setOnClickListener(this);
		btnShare.setOnClickListener(this);

		return v;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnGoToStamp:
			mainController.onGoToStamp();
			break;
		case R.id.btnGoToTime:
			Toast.makeText(mCtx, "Go To Time!!", Toast.LENGTH_SHORT).show();
			break;

		case R.id.btnGoToDistance:
			Toast.makeText(mCtx, "Go To Distance!!", Toast.LENGTH_SHORT).show();
			break;

		case R.id.btnGoToShare:
			Toast.makeText(mCtx, "Go To Share!!", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}

}
