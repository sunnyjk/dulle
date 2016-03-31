package momo.seoul.dulleapp;

import momo.seoul.dulleapp.view.DistancePageActivity;
import momo.seoul.dulleapp.view.StampPageActivity;
import momo.seoul.dulleapp.view.TimePageActivity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFrontFragment extends Fragment implements OnClickListener {

	ImageView imageV;
	ImageButton imgBtn;
	TextView detail1, detail2, detail3;

	View v;

	public MainFrontFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		v = inflater.inflate(R.layout.fragment_main_front, container, false);

		imgBtn = (ImageButton) v.findViewById(R.id.btnOnOff);
		detail1 = (TextView) v.findViewById(R.id.front_detail1);
		detail2 = (TextView) v.findViewById(R.id.front_detail2);
		detail3 = (TextView) v.findViewById(R.id.front_detail3);

		imgBtn.setOnClickListener(this);
		detail1.setOnClickListener(this);
		detail2.setOnClickListener(this);
		detail3.setOnClickListener(this);

		return v;

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnOnOff:
			
			break;
		case R.id.front_detail1:
		//	startActivity(new Intent(getActivity(), StampPageActivity.class));
			break;
		case R.id.front_detail2:
		//	startActivity(new Intent(getActivity(), DistancePageActivity.class));
			break;
		case R.id.front_detail3:
		//	startActivity(new Intent(getActivity(), TimePageActivity.class));
			break;

		default:
			break;
		}

	}
}
