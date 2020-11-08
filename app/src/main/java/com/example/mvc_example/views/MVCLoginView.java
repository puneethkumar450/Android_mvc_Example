package com.example.mvc_example.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;

import com.example.mvc_example.R;

/**
 * Login view cares about the login form...
 * @author puneeth kumar
 *
 */

public class MVCLoginView extends LinearLayout
{

	/**
	 * Login view
	 * @Context  a Context
	 */

	public MVCLoginView(@NonNull Context aContext, AttributeSet attrs)
	{
		super(aContext, attrs);
	}

	/**
	 * Login view
	 * @OnClickListener  a OnClickListener
	 *
	 */
	public void setListeners(@NonNull OnClickListener aOnClickListener){
		findViewById(R.id.activity_login_sign_in_button).setOnClickListener(aOnClickListener);
	}

	public void setPasswordError(@NonNull String aError)
	{
		((EditText) this.findViewById(
				R.id.activity_login_password_edittext)).setError(aError);
	}
	public void setLoginError(@NonNull String aError)
	{
		((EditText) this.findViewById(
				R.id.activity_login_email_edittext)).setError(aError);
	}


	@NonNull
	public String getEmailAddress()
	{
		return ((EditText) this.findViewById(
				R.id.activity_login_email_edittext)).getText().toString();
	}

	@NonNull
	public String getPassword()
	{
		return ((EditText) this.findViewById(
				R.id.activity_login_password_edittext)).getText().toString();
	}

}

