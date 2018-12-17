package com.tyh.java.androidcommontimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tyh.java.androidcommontimer.timer.ITimeObserver;
import com.tyh.java.androidcommontimer.timer.TimeObservable;

public class MainActivity extends AppCompatActivity implements ITimeObserver {

    TextView time;
    int count = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeObservable.getInstance().subscribe(this);
        time = findViewById(R.id.time);
    }

    @Override
    public void update(long curTime) {
        if (count > 0) {
            time.setText(String.valueOf(count--));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TimeObservable.getInstance().unSubscribe(this);
    }
}
