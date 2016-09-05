package com.exmple.administrator.shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private ViewFlipper viewFlipper;
    private static final String TAG="MainActivity";
    private GestureDetector detector;
    Animation leftInAnimation;
    Animation leftOutAnimation;
    Animation rightInAnimation;
    Animation rightOutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     viewFlipper= (ViewFlipper) findViewById(R.id.viewFlipper);
        detector=new GestureDetector(this);
  leftInAnimation= AnimationUtils.loadAnimation(this,R.anim.left_in);
        leftOutAnimation= AnimationUtils.loadAnimation(this,R.anim.left_out);
        rightInAnimation= AnimationUtils.loadAnimation(this,R.anim.right_in);
        rightOutAnimation= AnimationUtils.loadAnimation(this,R.anim.right_out);
    }
    private ImageView getImageView(int id){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(id);
        return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
       if (e1.getX()-e2.getX()>120){
           viewFlipper.setInAnimation(leftInAnimation);
         viewFlipper.setOutAnimation(leftOutAnimation);
          viewFlipper.showNext();
           return  true;
       }else if (e1.getX()-e2.getY()<-120){
           viewFlipper.setInAnimation(rightInAnimation);
           viewFlipper.setOutAnimation(rightOutAnimation);
           viewFlipper.showPrevious();
           return true;
       }
        return false;
    }
}

