package com.demo.reservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_today, tv_year, tv_month, tv_day, tv_hour, tv_min;
    RadioButton rd_date, rd_time;
    CalendarView cal;
    TimePicker time;
    Button bt_reserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_today = (TextView)findViewById(R.id.tv_today);
        tv_year = (TextView)findViewById(R.id.tv_year);
        tv_month = (TextView)findViewById(R.id.tv_month);
        tv_day = (TextView)findViewById(R.id.tv_day);
        tv_hour = (TextView)findViewById(R.id.tv_hour);
        tv_min = (TextView)findViewById(R.id.tv_min);
        rd_date =(RadioButton)findViewById(R.id.rd_date);
        rd_time =(RadioButton)findViewById(R.id.rd_time);
        rd_date.setOnClickListener(this);
        rd_time.setOnClickListener(this);
        bt_reserve.setOnClickListener(this);
        //소스는 존재하나 사용자 눈에는 보이지 않는다.
        time.setVisibility(View.INVISIBLE);
        cal.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rd_date:
                time.setVisibility(View.INVISIBLE);
                cal.setVisibility(View.VISIBLE);
                break;
            case R.id.rd_time:
                time.setVisibility(View.VISIBLE);
                cal.setVisibility(View.INVISIBLE);
                break;
            case R.id.bt_reserve:

                break;

        }

    }



}
