package momo.seoul.dulleapp.view;

import momo.seoul.dulleapp.R;
import momo.seoul.dulleapp.controller.AccountController;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MyAccountActivity extends Activity implements OnClickListener{
	
	Button btnLogin, btnLogout;
	
	AccountController accountController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_account);
		
		accountController = new AccountController(this);
		
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogout = (Button) findViewById(R.id.btnLogout);
		
		btnLogin.setOnClickListener(this);
		btnLogout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnLogin:
			Toast.makeText(this, "Login clicked!!", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnLogout:
			Toast.makeText(this, "Logout clicked!!", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
		
	}

	
}
