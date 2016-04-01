package momo.seoul.dulleapp.controller;

import momo.seoul.dulleapp.model.User;

public interface DulleListener {
	
	void onGoToMyAccount(User user);
	
	void onGoToStamp();
	void onGoToTime();
	void onGoToDistance();
	void onGoToShare();

}
