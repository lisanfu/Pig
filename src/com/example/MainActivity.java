package com.example;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	private AnimationDrawable anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取要应用的动画效果的ImageView
		final ImageView iv=(ImageView)findViewById(R.id.imageView1);
		final Animation transtateright=AnimationUtils.loadAnimation(MainActivity.this, R.anim.translateright);
		final Animation translateleft=AnimationUtils.loadAnimation(MainActivity.this, R.anim.translateleft);
		anim=(AnimationDrawable)iv.getBackground();
		LinearLayout ll=(LinearLayout)findViewById(R.id.linearLayout1);
		Toast.makeText(MainActivity.this, "触摸屏开始播放中",Toast.LENGTH_SHORT).show();
		ll.setOnTouchListener(new OnTouchListener()
		{

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				anim.start();
				iv.startAnimation(transtateright);
				
				return false;
			}
			
		});
		transtateright.setAnimationListener(new AnimationListener()
		{

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				iv.setBackgroundResource(R.drawable.motionleft);
				iv.startAnimation(translateleft);
				anim=(AnimationDrawable)iv.getBackground();
				anim.start();
				
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
				
		});
		translateleft.setAnimationListener(new AnimationListener()
		{

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				iv.setBackgroundResource(R.drawable.motionright);
				iv.startAnimation(transtateright);
				anim=(AnimationDrawable)iv.getBackground();
				anim.start();
				
				
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
