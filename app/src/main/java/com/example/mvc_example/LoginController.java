package com.example.mvc_example;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;

import com.example.mvc_example.listeners.LoginControllerListener;
import com.example.mvc_example.views.MVCLoginView;

/**
 * LoginController intercepts the on click login button event, verify the inputs
 * @author puneeth kumar
 *
 */

public class LoginController implements OnClickListener
{

	private static final String TAG = "Login controller";

	private MVCLoginView mLoginView;
	private LoginControllerListener mLoginListener;


	public LoginController(@NonNull MVCLoginView aLoginView,
						   @NonNull LoginControllerListener aLoginListener)
	{
		this.mLoginView = aLoginView;
		this.mLoginListener = aLoginListener;
	}

	/**
	 * Login button was clicked
	 */

	@Override
	public void onClick(View v)
	{
		Log.d(TAG, "onClick");
		// Check for a valid email address.
		if(mLoginView.getEmailAddress().isEmpty() || mLoginView.getEmailAddress().equals("")) {
			mLoginView.setLoginError(ErrorCodes.ERROR_FIELD_REQUIRED);
		}else if(!Patterns.EMAIL_ADDRESS.matcher(mLoginView.getEmailAddress()).matches()) {
			mLoginView.setLoginError(ErrorCodes.ERROR_INVALID_EMAIL);
			// Check for a valid password.
		}else if(mLoginView.getPassword().isEmpty() || mLoginView.getPassword().equals("")) {
			mLoginView.setPasswordError(ErrorCodes.ERROR_FIELD_REQUIRED);
		}else if(mLoginView.getPassword().length() < 3) {
			mLoginView.setPasswordError(ErrorCodes.ERROR_INVALID_PASSWORD);
		}else {
			//If all inputs are rights than login is successful
			mLoginListener.onLoginSuccess();
		}
	}
}
