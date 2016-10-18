package com.example.hemanth.transitionanimation.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hemanth.transitionanimation.activity.DetailView;
import com.example.hemanth.transitionanimation.R;

/**
 * Created by hemanth on 13/10/16.
 */

public class AndroidFragment extends Fragment {

    TextView desc,textView,type;
    String lang,typeValue,det;
    int position;
    public static  RelativeLayout androidLayout;



    public AndroidFragment() {

    }

    public AndroidFragment(String language, String typed, String detail, int posi) {
        lang=language;
        typeValue=typed;
        det=detail;
        position=posi;


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.android_layout,container,false);
        textView= (TextView)view.findViewById(R.id.heading);
        type= (TextView)view.findViewById(R.id.language);
        desc=(TextView)view.findViewById(R.id.desc);
        androidLayout = (RelativeLayout) view.findViewById(R.id.androidLayout);
        if(position==0){
            androidLayout.setBackgroundColor(getResources().getColor(R.color.md_light_green_900));
        }
        if(position==1){
            androidLayout.setBackgroundColor(getResources().getColor(R.color.md_amber_A700));
        }
        if(position==2){
            androidLayout.setBackgroundColor(getResources().getColor(R.color.md_pink_A700));
        }
        if(position==3){
            androidLayout.setBackgroundColor(getResources().getColor(R.color.md_brown_800));
        }

        textView.setText(lang);
        type.setText(typeValue);
        desc.setText(det);
        DetailView.isAndroid="ANDROID";
        DetailView.isFirstposi=true;

        return view;
    }
}
