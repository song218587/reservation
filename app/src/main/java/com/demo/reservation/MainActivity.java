package com.demo.reservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_today, tv_year, tv_month, tv_day, tv_hour, tv_min;
    RadioButton rd_date, rd_time;
    CalendarView cal;
    TimePicker time;
    Button bt_reserve;
    String date = "";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_reserve = (Button) findViewById(R.id.bt_reserve);
        tv_today = (TextView) findViewById(R.id.tv_today);
        tv_year = (TextView) findViewById(R.id.tv_year);
        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_day = (TextView) findViewById(R.id.tv_day);
        tv_hour = (TextView) findViewById(R.id.tv_hour);
        tv_min = (TextView) findViewById(R.id.tv_min);
        rd_date = (RadioButton) findViewById(R.id.rd_date);
        rd_time = (RadioButton) findViewById(R.id.rd_time);
        rd_date.setOnClickListener(this);
        rd_time.setOnClickListener(this);
        bt_reserve.setOnClickListener(this);
        cal = (CalendarView) findViewById(R.id.cal);
        time = (TimePicker) findViewById(R.id.time);

 /*       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String today = sdf.format(d);
        tv_today.setText("Today:"+today);*/
        //속도는 네배
        tv_today.setText("Today:" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //new 컨트롤+스페이스
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                //month는 배열로 정의 되어서 인덱스 값이 0부터 시작이니 1을 더해준다.ㄴ
                date = year + "-" + (month + 1) + "-" + day;
            }
        });
        //소스는 존재하나 사용자 눈에는 보이지 않는다.
        time.setVisibility(View.INVISIBLE);
        cal.setVisibility(View.INVISIBLE);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rd_date:
                time.setVisibility(View.INVISIBLE);
                cal.setVisibility(View.VISIBLE);
                break;
            case R.id.rd_time:
                time.setVisibility(View.VISIBLE);
                cal.setVisibility(View.INVISIBLE);
                break;
            case R.id.bt_reserve:
                //date
                String[] arr = date.split("-");
                tv_year.setText(arr[0]);
                tv_month.setText(arr[1]);
                tv_day.setText(arr[2]);
                tv_hour.setText(Integer.toString(time.getHour()));
                tv_min.setText(Integer.toString(time.getMinute()));
                break;
        }

    }

}
