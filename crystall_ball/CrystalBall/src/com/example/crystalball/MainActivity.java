package com.example.crystalball;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crystalball.ShakeDetector.OnShakeListener;

public class MainActivity extends ActionBarActivity {
	private CrystalBall mCrystalBall = new CrystalBall();
	private TextView mAnswerLabel;
	private ImageView mCrystalBallImage;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakeDetector;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Assign the Views from the layout file
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
        mCrystalBallImage = (ImageView) findViewById(R.id.imageView1);
        
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new OnShakeListener() {
			
			@Override
			public void onShake() {
				handleNewAnswer();
				
			}
		});
        
    }
    
    private void animateCrystalBall() {
    	
    	mCrystalBallImage.setImageResource(R.drawable.ball_animation);
    	AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();
    	if (ballAnimation.isRunning()) {
    		ballAnimation.stop();
    	}
    	ballAnimation.start();
    }


    private void animateAnswer() {
    	AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
    	fadeInAnimation.setDuration(1500);
    	fadeInAnimation.setFillAfter(true);
    	
    	mAnswerLabel.setAnimation(fadeInAnimation);
    }
    
    private void playSound() {
    	MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
    	player.start();
    	player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
				
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

	private void handleNewAnswer() {
		String answer = mCrystalBall.getAnAnswer();
		
		
		// Update the label with or dynamic answer
		mAnswerLabel.setText(answer);
		
		animateCrystalBall();
		animateAnswer();
		playSound();
	}
    
}
