package momo.seoul.dulleapp;

import momo.seoul.dulleapp.view.DistancePageActivity;
import momo.seoul.dulleapp.view.MyAccountActivity;
import momo.seoul.dulleapp.view.SharingPageActivity;
import momo.seoul.dulleapp.view.StampPageActivity;
import momo.seoul.dulleapp.view.TimePageActivity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainBackFragment extends Fragment implements OnClickListener {
	
	View v;
	ImageView imgView;
	ImageButton btnProfile;
	LinearLayout layout1;
	TextView dash1, dash2, dash3, dash4, dash5;
	
	
	public MainBackFragment(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		v = inflater.inflate(R.layout.fragment_main_back, container, false);
		
		btnProfile = (ImageButton) v.findViewById(R.id.btnProfil);
		
		dash1 = (TextView) v.findViewById(R.id.textDash1);
		dash2 = (TextView) v.findViewById(R.id.textDash2);
		dash3 = (TextView) v.findViewById(R.id.textDash3);
		dash4 = (TextView) v.findViewById(R.id.textDash4);
		dash5 = (TextView) v.findViewById(R.id.textDash5);
		
		btnProfile.setOnClickListener(this);
		dash1.setOnClickListener(this);
		dash2.setOnClickListener(this);
		dash3.setOnClickListener(this);
		dash4.setOnClickListener(this);
		dash5.setOnClickListener(this);
		
		return v;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btnProfil:
			startActivity(new Intent(getActivity(), MyAccountActivity.class));
			break;
		case R.id.textDash1:
			Toast.makeText(getActivity(), "DashBoard1 clicked!!", Toast.LENGTH_SHORT).show();
		//	startActivity(new Intent(getActivity(), StampPageActivity.class));
		case R.id.textDash2:
		//	startActivity(new Intent(getActivity(), DistancePageActivity.class));
			break;
		case R.id.textDash3:
		//	startActivity(new Intent(getActivity(), TimePageActivity.class));
			break;
		case R.id.textDash4:
		//	startActivity(new Intent(getActivity(), SharingPageActivity.class));
			break;
		case R.id.textDash5:
			Toast.makeText(getActivity(), "인스타공유 기능 버튼", Toast.LENGTH_SHORT).show();
			break;
		
		}
		
	}

}
