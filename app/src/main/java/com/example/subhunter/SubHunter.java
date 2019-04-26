/*
Created by Andrzej Ciepiela 2019
Followed: Learning Java by Building Android Games by John Horton
 */

package com.example.subhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.util.Log;
import android.widget.ImageView;
import java.util.Random;

public class SubHunter extends AppCompatActivity {

    int numberHorizontalPixels;
    int numberVerticalPixels;
    int blockSize;
    int gridWidth = 40;
    int gridHeight;
    float horizontalTouched = -100;
    float verticalTouched = -100;
    int subHorizontalPosition;
    int subVerticalPosition;
    boolean hit = false;
    int shotsTaken;
    int distanceFromSub;
    boolean debugging = true;

    /*
    Android runs this code just before the app is seen by the player.
    This makes it a good place to add the code that is needed for the one-time setup.
     */
    ImageView gameView;
    Bitmap blankBitmap;
    Canvas canvas;
    Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the current device's screen resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Initialized our size based variables based on the screen resolution
        numberHorizontalPixels = size.x;
        numberVerticalPixels = size.y;
        blockSize = numberHorizontalPixels / gridWidth;
        gridHeight = numberVerticalPixels / blockSize;

        // Initialize all the objects ready for drawing
        blankBitmap = Bitmap.createBitmap(numberHorizontalPixels, numberVerticalPixels, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(blankBitmap);
        gameView = new ImageView(this);
        paint = new Paint();

        //Tell Android to set our drawing as the view for this app
        setContentView(gameView);

        // Log.d prints out messages to show that methods work
        Log.d("Debugging", "In onCreate");
        newGame();
        draw();
    }

    /*
    This code will execute when a new game needs to be started.
    It will happen when the app is first started and after
    the player wins a game.
     */
    public void newGame(){
        Random random = new Random();
        subHorizontalPosition = random.nextInt(gridWidth);
        subVerticalPosition = random.nextInt(gridHeight);
        shotsTaken = 0;

        Log.d("Debugging","In newGame");
    }

    /*
    Here we will do all the drawing.
    The grid lines, the HUD and the touch indicator
    and the "BOOM" when the sub is hit
     */
    void draw(){
        // Wipe the screen with a white color canvas.drawColor(Color.argb(255,255,255,255));
        gameView.setImageBitmap(blankBitmap);

        Log.d("Debugging", "In draw");
        printDebuggingText();
    }

    /*
    This part of the code will handle detecting that the player
    has tapped the screen.
     */
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){

        Log.d("Debugging","In onTouchEvent");
        takeShot();

        return true;
    }

    /*
    The code here will execute when the player tapes the screen.
    It will calculate the distance from the sub and decide a hit or miss.
     */
    void takeShot(){
        Log.d("Debugging","In takeShot");
        draw();
    }

    // This code says "BOOM!"
    void boom(){

    }

    // This code prints the debugging text
    void printDebuggingText(){
        Log.d("numberHorizontalPixels",""+numberHorizontalPixels);
        Log.d("numberVerticalPixels",""+numberVerticalPixels);
        Log.d("blockSize",""+blockSize);
        Log.d("gridWidth",""+gridWidth);
        Log.d("gridHeight",""+gridHeight);
        Log.d("horizontalTouched",""+horizontalTouched);
        Log.d("verticalTouched",""+verticalTouched);
        Log.d("subHorizontalPosition",""+subHorizontalPosition);
        Log.d("subVerticalPosition",""+subVerticalPosition);
        Log.d("hit",""+hit);
        Log.d("shotsTaken",""+shotsTaken);
        Log.d("debugging",""+debugging);
        Log.d("distanceFromSub",""+distanceFromSub);
    }

}
