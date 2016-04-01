package momo.seoul.dulleapp.view;

import momo.seoul.dulleapp.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ShareFragment extends Fragment{
	
	View v;

	public ShareFragment(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_sharing, container, false);
		
		return v;
	}
}
