package com.example.mvc_example.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.app.Dialog;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.mvc_example.LoginController;
import com.example.mvc_example.views.MVCLoginView;
import com.example.mvc_example.listeners.LoginControllerListener;
import com.example.mvc_example.R;

public class MainActivity extends AppCompatActivity implements LoginControllerListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LoginController loginController = new
				LoginController(this.findViewById(R.id.activity_login), this);
		((MVCLoginView) this.findViewById(R.id.activity_login)).setListeners(loginController);
	}

	/**
	 * Controller calls this method if the login was successful
	 */
	@Override
	public void onLoginSuccess()
	{
		//Show a dialog with success animation...
		Dialog lDialog = new Dialog(this);
		lDialog.setCancelable(true);
		lDialog.setCanceledOnTouchOutside(true);
		View lView = LayoutInflater.from(this).inflate(
				R.layout.done, null,false);
		lDialog.setContentView(lView);
		ImageView lDoneView = lView.findViewById(R.id.done_imageView);
		lDoneView.setVisibility(View.VISIBLE);
		Drawable lDrawable = lDoneView.getDrawable();
		if(lDrawable instanceof AnimatedVectorDrawableCompat)
		{
			((AnimatedVectorDrawableCompat) lDrawable).start();
		} else if(lDrawable instanceof AnimatedVectorDrawable)
		{
			((AnimatedVectorDrawable) lDrawable).start();
		}
		lDialog.getWindow().setBackgroundDrawable(
				new ColorDrawable(android.graphics.Color.TRANSPARENT));
		lDialog.show();
	}
}