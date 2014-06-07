package com.cytedesign.rainbow;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity{
	
	int i = 0;
	Button button, swipeOnly, both, buttonsOnly;
	View view;
	private static final int SWIPE_MIN_DISTANCE = 120;
//  private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 50;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.bChangeColour);
	    button.setOnClickListener(MyListener);
	    button.setVisibility(View.INVISIBLE);
	    buttonsOnly = (Button) findViewById(R.id.bButtonsOnly);
	    buttonsOnly.setOnClickListener(ButtonsOnlyListener);
	    swipeOnly = (Button) findViewById(R.id.bSwipeOnly);
	    swipeOnly.setOnClickListener(MySwipeOnlyListener);
	    both = (Button) findViewById(R.id.bButtonAndSwipe);
	    both.setOnClickListener(MyBothListener);
	    view = this.getWindow().getDecorView();
	    
	    //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    	    
	    gestureDetector = new GestureDetector(this, new MyGestureDetector());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        
        //view.setOnTouchListener(gestureListener);

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}
	
	public void enableSwipes(){
		view.setOnTouchListener(gestureListener);
	}
	
    public OnClickListener MySwipeOnlyListener = new OnClickListener() {
        public void onClick(View v) {
        	enableSwipes();
        	buttonsOnly.setVisibility(View.INVISIBLE);
        	button.setVisibility(View.INVISIBLE);
        	both.setVisibility(View.INVISIBLE);
        	swipeOnly.setVisibility(View.INVISIBLE);
        	doNextRainbow();        	
        }
    };
    
    public OnClickListener ButtonsOnlyListener = new OnClickListener() {
        public void onClick(View v) {
        	buttonsOnly.setVisibility(View.INVISIBLE);
        	both.setVisibility(View.INVISIBLE);
        	swipeOnly.setVisibility(View.INVISIBLE);
        	button.setVisibility(View.VISIBLE);
        	doNextRainbow();        	
        }
    };
    
    public OnClickListener MyBothListener = new OnClickListener() {
        public void onClick(View v) {
        	enableSwipes();
        	buttonsOnly.setVisibility(View.INVISIBLE);
         	both.setVisibility(View.INVISIBLE);
        	swipeOnly.setVisibility(View.INVISIBLE);
        	button.setVisibility(View.VISIBLE);
        	doNextRainbow();
        }
    };
    
    public OnClickListener MyListener = new OnClickListener() {
        public void onClick(View v) {
        	//button.setLayoutParams(new RelativeLayout.LayoutParams(130, 80));
        	
        	doNextRainbow();        	
        }
    };
    
    public void doNextRainbow(){
    	switch(i){
    	case 0: 
    		setActivityBackgroundColor(0xFFFF0000);// FF0000 red
    		button.setText("Red");
    	break;
    	case 1: 
    		setActivityBackgroundColor(0xFFFF9900); // FF9900 orange
    		button.setText("Orange");
    	break;
    	case 2: 
    		setActivityBackgroundColor(0xFFFFFF00); // FFFF00 yellow
    		button.setText("Yellow");
    	break;
    	case 3: 
    		setActivityBackgroundColor(0xFF7CCD24); // 7CCD24 green
    		button.setText("Green");
    	break;
    	case 4: 
    		setActivityBackgroundColor(0xFF0000FF); // 0000FF blue
    		button.setText("Blue");        	
    	break;
    	case 5: 
    		setActivityBackgroundColor(0xFF990099); // 990099 indigo
    		button.setText("Indigo");
    	break;
    	case 6: 
    		setActivityBackgroundColor(0xFFCC33FF); // CC33FF violet
    		button.setText("Violet");
    	break;
    	}
    	
        int x = (int) (Math.random() * (view.getWidth() - button.getWidth())); 
        int y = (int) (Math.random() * ((view.getHeight() - 100) - button.getHeight()));
    	
    	button.setX(x);        
        button.setY(y); 
        
        //TextView tv = (TextView)findViewById(R.id.textView2);
	    //tv.setText(Integer.toString(x) + " , " + Integer.toString(y));
        
	    //tv.setVisibility(View.VISIBLE);
    	
    	i++;
    	
    	if(i > 6)
    		i = 0;
    	//tv.setText(Integer.toString(i));
    }
    
    public void doPreviousRainbow(){
       	switch(i){
    	case 2: 
    		setActivityBackgroundColor(0xFFFF0000);// FF0000 red
    		button.setText("Red");
    	break;
    	case 3: 
    		setActivityBackgroundColor(0xFFFF9900); // FF9900 orange
    		button.setText("Orange");
    	break;
    	case 4: 
    		setActivityBackgroundColor(0xFFFFFF00); // FFFF00 yellow
    		button.setText("Yellow");
    	break;
    	case 5: 
    		setActivityBackgroundColor(0xFF7CCD24); // 7CCD24 green
    		button.setText("Green");
    	break;
    	case 6: 
    		setActivityBackgroundColor(0xFF0000FF); // 0000FF blue
    		button.setText("Blue");        	
    	break;
    	case 0: 
    		setActivityBackgroundColor(0xFF990099); // 990099 indigo
    		button.setText("Indigo");
    	break;
    	case 1: 
    		setActivityBackgroundColor(0xFFCC33FF); // CC33FF violet
    		button.setText("Violet");
    	break;
    	}
    	
        int x = (int) (Math.random() * (view.getWidth() - button.getWidth())); 
        int y = (int) (Math.random() * ((view.getHeight() - 100) - button.getHeight()));
    	
    	button.setX(x);        
        button.setY(y); 
        
        //TextView tv = (TextView)findViewById(R.id.textView2);
	    //tv.setText(Integer.toString(x) + " , " + Integer.toString(y));
        //tv.setText(Integer.toString(i));
	    
	    
    	i--;
    	
    	if(i < 0)
    		i = 6;
    	//tv.setVisibility(View.VISIBLE);
    	
    }
	
	public void setActivityBackgroundColor(int color) {
	    view.setBackgroundColor(color);
	    TextView tv = (TextView)findViewById(R.id.textView1);
	    tv.setText(Integer.toString(view.getWidth()) + " x " + Integer.toString(view.getHeight()));
	}
	
	class MyGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
//                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
//                    return false;
            	if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                	doPreviousRainbow();
                	//left swipe
                }  else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                	doNextRainbow();
                }
            	
                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                	doNextRainbow();
                	//left swipe
                }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                	doPreviousRainbow();
                }
            } catch (Exception e) {
                // nothing
            }
            return false;
        }
	}
	
	@Override
	 public boolean onKeyDown(int keyCode, KeyEvent event)  {
	     if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	    	 both.setVisibility(View.VISIBLE);
	         swipeOnly.setVisibility(View.VISIBLE);
	         buttonsOnly.setVisibility(View.VISIBLE);
	         button.setVisibility(View.INVISIBLE);
	         setActivityBackgroundColor(0xFFFFFFFF);
	         view.setOnTouchListener(null);
	         return true;
	     }

	     return super.onKeyDown(keyCode, event);
	 }
		
}
