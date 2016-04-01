package momo.seoul.dulleapp;

import momo.seoul.dulleapp.view.DashBoardFragment;
import momo.seoul.dulleapp.view.ShareFragment;
import momo.seoul.dulleapp.view.TodayFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

	/*
	 * �� Ŭ������ �θ������ ȣ��� �μ��� �ݵ�� FragmentManager��ü�� �Ѱܾ��Ѵ�.
	 * �� ��ü�� Activity������ ����� �ְ�, ���⼭������� Fragment�� v4�̱� ������
	 * Activity�߿����� ActionBarActivity���� ���;��Ѵ�.
	 */
	
	Fragment[] fragments = new Fragment[3];
	
	public MyViewPagerAdapter(FragmentManager fm) {
		super(fm);
		fragments[0] = new TodayFragment();
		fragments[1] = new DashBoardFragment();
		fragments[2] = new ShareFragment();
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragments[arg0];
	}

	
	@Override
	public int getCount() {
		return fragments.length;
	}
}
