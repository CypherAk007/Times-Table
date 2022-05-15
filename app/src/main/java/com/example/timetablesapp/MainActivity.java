package com.example.timetablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void genrateTimesTable(int timesTable){
        ArrayList<String> timesTableContent =new ArrayList<String>();
        for (int i=1;i<=10;i++){
            timesTableContent.add(Integer.toString(i*timesTable));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTablesSeekBar = (SeekBar)findViewById(R.id.timesTableSeekBar);
        timesTableListView = (ListView) findViewById(R.id.timesTablesListView);

        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);// initially the progress is at the initial of the seek bar.

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTable;
                if (i<min){
                    timesTable=min;
                    timesTablesSeekBar.setProgress(min);// stops the seek bar pointer at 1 and not at zero.

                }
                else{
                    timesTable=i;

                }
//                Log.i("seekbar value",Integer.toString(timesTable));
                genrateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        genrateTimesTable(10);

    }
}