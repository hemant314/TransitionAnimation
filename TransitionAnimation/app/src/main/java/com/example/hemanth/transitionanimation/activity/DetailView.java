package com.example.hemanth.transitionanimation.activity;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hemanth.transitionanimation.R;
import com.example.hemanth.transitionanimation.fragment.AndroidFragment;

/**
 * Created by hemanth on 13/10/16.
 */

public class DetailView extends AppCompatActivity {


    CursorAdapter cursorAdapter;
    TextView main,sub;
    int posi;
    TextView desc,textView,type;
    RelativeLayout rl;
    RelativeLayout relativeLayout;
    boolean isBottom = true;
    String language,typed,detail,lang1,type1,detail1,lang2,type2,detail2,lang3,type3,detail3;
    Fragment fragment;
    Animation in,out;
    AnimationSet as;
    Animation botoomUp,bottomIn,topOut;
    public static boolean isFirstposi,isSecposi,isThirdposi=true;

    public  static String isAndroid,isIos,isXamar,isPhone;
    String androidValue,iosValue,xamatinValue,phoneValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        textView= (TextView)findViewById(R.id.heading);
        type= (TextView)findViewById(R.id.language);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        main = (TextView) findViewById(R.id.main);
        sub = (TextView) findViewById(R.id.subText);
        desc=(TextView)findViewById(R.id.desc);
        rl= (RelativeLayout)findViewById(R.id.layout);


        bottomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_in);
        topOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_out);

        Intent i = getIntent();

        posi = i.getIntExtra("position",0);
        language = i.getStringExtra("name");
        typed = i.getStringExtra("place");
        detail = i.getStringExtra("number");

        lang1 = i.getStringExtra("name1");
        type1 = i.getStringExtra("place1");
        detail1=i.getStringExtra("number1");

        lang2 = i.getStringExtra("name2");
        type2 = i.getStringExtra("place2");
        detail2=i.getStringExtra("number2");

        lang3 = i.getStringExtra("name3");
        type3 = i.getStringExtra("place3");
        detail3 = i.getStringExtra("number3");


        if(posi==0){
            main.setText(lang1);
            sub.setText(type1);
        }
        if(posi==1){
            main.setText(lang2);
            sub.setText(type2);
        }
        if(posi==2){
            main.setText(lang3);
            sub.setText(type3);
        }

        if(posi==3){
            main.setText(lang3);
            sub.setText(type3);
            relativeLayout.setVisibility(View.GONE);
        }

        if (savedInstanceState == null) {
            // Do first time initialization -- add initial fragment.
            Fragment newFragment = new AndroidFragment(language,typed,detail,posi);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.simple_fragment, newFragment).commit();
        }


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", posi);
    }

    private void addFragment() {

       //AndroidFragment.androidLayout.startAnimation(bottomIn);
        AndroidFragment.androidLayout.startAnimation(topOut);
        posi++;

        if(posi>3){
            return;
        }

        if(posi==0){
            fragment = new AndroidFragment(language,typed,detail,posi);


        }else if(posi==1){
            fragment = new AndroidFragment(lang1,type1,detail1,posi);
            main.setText(lang2);
            sub.setText(type2);


        }else if(posi==2){
            fragment = new AndroidFragment(lang2,type2,detail3,posi);
            main.setText(lang3);
            sub.setText(type3);


        }else if(posi==3){
            fragment = new AndroidFragment(lang3,type3,detail3,posi);
            relativeLayout.setVisibility(View.GONE);

        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.simple_fragment, fragment);
        ft.addToBackStack(null);
        ft.commit();


    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }
}
