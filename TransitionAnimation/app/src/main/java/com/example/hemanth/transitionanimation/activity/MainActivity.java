package com.example.hemanth.transitionanimation.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hemanth.transitionanimation.model.Model;
import com.example.hemanth.transitionanimation.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Model> values = new ArrayList<Model>();
        values.add(new Model("Toll free", "All India", "1800-643-234"));
        values.add(new Model("Customer care", "Benagaluru", "080-26630182"));
        values.add(new Model("Toll free", "Mysore", "1800-643-234"));
        values.add(new Model("Customer care", "Mangalore", "080-26630182"));


        ListView listView = (ListView) findViewById(R.id.list_view);
        CustomAdapter adapter = new CustomAdapter(this, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailView.class);
                intent.putExtra("position",position);
                intent.putExtra("name",values.get(position).getName());
                intent.putExtra("place",values.get(position).getPlace());
                intent.putExtra("number",values.get(position).getNumber());

                intent.putExtra("name1",values.get(1).getName());
                intent.putExtra("place1",values.get(1).getPlace());
                intent.putExtra("number1",values.get(1).getNumber());

                intent.putExtra("name2",values.get(2).getName());
                intent.putExtra("place2",values.get(2).getPlace());
                intent.putExtra("number2",values.get(2).getNumber());

                intent.putExtra("name3",values.get(3).getName());
                intent.putExtra("place3",values.get(3).getPlace());
                intent.putExtra("number3",values.get(3).getNumber());


                // Get the transition name from the string
                String transitionName = getString(R.string.transition);

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                                view,   // Starting view
                                transitionName    // The String
                        );

                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        });
    }

    private static class CustomAdapter extends BaseAdapter{

        ArrayList<Model> arrayList;
        Context c;

        public CustomAdapter(Context c, ArrayList<Model> list) {
            arrayList = list;
            this.c = c;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View row = null;
            LayoutInflater inflater = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                row = inflater.inflate(R.layout.row_layout, parent,
                        false);
            } else {
                row = convertView;
            }
            Model detail = arrayList.get(position);

            RelativeLayout rl= (RelativeLayout)row.findViewById(R.id.rl);
            TextView name = (TextView) row.findViewById(R.id.primary_textview);
            name.setText(detail.getName());
            TextView email = (TextView) row.findViewById(R.id.textView);
            email.setText(detail.getPlace());

            return row;
        }
    }
}
