package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer;

    private int startTime = 0;
    private int finalTime = 0;

    private int currentTime = 0;
    private Handler myHandler = new Handler();

    private int forwardTime = 5000;
    private int backwardTime = 5000;

    public static int oneTimeOnly = 0;

    public int unitTime = 0;

    public int oneitemtime;

    private int iteration = 1;


    private int item = 0;

    public int progresses = 1;

    Button click;

    public List<Progress> progressList = new ArrayList<>();
    public RecyclerView seekbar;
    public ProgressAdapter progressAdapter;
    private int currentApiVersion;

    RelativeLayout rel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = findViewById(R.id.click);
        rel = findViewById(R.id.rel);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentApiVersion >= Build.VERSION_CODES.KITKAT && progresses == 10)
                {
//                    getWindow().getDecorView().setSystemUiVisibility(
//                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
//                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


                    // MainActivity.this.recreate();
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  |
                                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

//                    getWindow().getDecorView().setSystemUiVisibility(0);
//


                    progresses = 1;
                }

                if(currentApiVersion >= Build.VERSION_CODES.KITKAT && progresses == 1)
                {
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                    progresses = 10;
                }


            }
        });
//        rel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(currentApiVersion >= Build.VERSION_CODES.KITKAT && progresses == 10)
//                {
////                    getWindow().getDecorView().setSystemUiVisibility(
////                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
////                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
////                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
////                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
////                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
////                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//
//
//                   // MainActivity.this.recreate();
//                                        getWindow().getDecorView().setSystemUiVisibility(
//                              View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  |
//                                      View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//
////                    getWindow().getDecorView().setSystemUiVisibility(0);
////
//
//
//                            progresses = 1;
//                }
//
//                if(currentApiVersion >= Build.VERSION_CODES.KITKAT && progresses == 1)
//                {
//                    getWindow().getDecorView().setSystemUiVisibility(
//                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                                    | View.SYSTEM_UI_FLAG_FULLSCREEN);
//                    progresses = 10;
//                }
//
//            }
//        });

        currentApiVersion = android.os.Build.VERSION.SDK_INT;

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if(currentApiVersion >= Build.VERSION_CODES.KITKAT && progresses==10)
        {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            final View decorView = getWindow().getDecorView();
            decorView
                    .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
                    {

                        @Override
                        public void onSystemUiVisibilityChange(int visibility)
                        {
                            if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                            {
                                decorView.setSystemUiVisibility(flags);
                            }
                        }
                    });
        }

    }


    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if(currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus && progresses==2)
        {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


}
//
//        for (int i = 0; i < 100; i++) {
//            Progress progress = new Progress(0);
//            progressList.add(progress);
//        }
//        seekbar = (RecyclerView) findViewById(R.id.seekbar);
//
//
//        mediaPlayer = MediaPlayer.create(this, R.raw.song);
//        Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
//        mediaPlayer.start();
//        myHandler.postDelayed(UpdateSongTime, 1000);
//
//
//        finalTime = mediaPlayer.getDuration();
//
//        unitTime = finalTime / 5000;
//
//        oneitemtime = finalTime / 50;
//
//        startTime = mediaPlayer.getCurrentPosition();
//
//        if (oneTimeOnly == 0) {
////            seekbar.setMax((int) finalTime);
//            oneTimeOnly = 1;
//        }
//
//        progressAdapter = new ProgressAdapter(progressList);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), progressList.size());
//        seekbar.setLayoutManager(mLayoutManager);
//        seekbar.setItemAnimator(new DefaultItemAnimator());
//        seekbar.setAdapter(progressAdapter);
//
//
//        //      seekbar.setProgress((int) startTime);
//
//
//    }
//
//    private Runnable UpdateSongTime = new Runnable() {
//        public void run() {
//            currentTime = mediaPlayer.getCurrentPosition();
//            //        seekbar.setProgress((int) startTime);
//
//
////            finalTime = mediaPlayer.getDuration();
////
////            unitTime = finalTime / 5000;
////
////            oneitemtime = finalTime / 50;
////
////            startTime = mediaPlayer.getCurrentPosition();
//
//
//            System.out.println("Current Time : " + currentTime);
//
// //           if(currentTime > oneitemtime)
//
//            progresses =  ((currentTime / finalTime) * 100 );
//
//            Progress progress = new Progress(progresses);
//
//            progressList.add(item, progress);
//
//            progressAdapter.notifyDataSetChanged();
//
//            iteration++;
//            progresses++;
//
//            if (progresses > 100) {
//                progresses = 1;
//                item++;
//            }
//            myHandler.postDelayed(this, 1000);
//
//        }
//    };
//}