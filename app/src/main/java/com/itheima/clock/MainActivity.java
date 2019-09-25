package com.itheima.clock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TimePicker timePicker;
    private Button set;
    private Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        initView ( );
        c=Calendar.getInstance ();
        Log.i ( "孙伟豪",c.get ( Calendar.YEAR )+"" );
    }

    private void initView() {
        timePicker = (TimePicker) findViewById ( R.id.timePicker );
        set = (Button) findViewById ( R.id.set );

        set.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.set:
                Intent intent=new Intent ( MainActivity.this,AlarmActivity.class );//1.为闹钟设置一个提醒内容的activity
                PendingIntent pendingIntent=PendingIntent//2.pendingIntent:Pending：将发生，即PendingIntent即将发生，PendingIntent有其他程序调用
                        .getActivity ( MainActivity.this,0,intent,0 );

                AlarmManager alarmManager= (AlarmManager) getSystemService ( Context.ALARM_SERVICE );//获取AlarmManager（警报管理者）
                //获取日历对象

                //获取时间拾取器上的小时数和分钟数
                Log.i ( "孙伟豪","年："+c.get ( Calendar.YEAR ));
                int month=1+c.get ( Calendar.MONTH );
                Log.i ( "孙伟豪","月："+month);
                Log.i ( "孙伟豪","日："+c.get ( Calendar.DATE ));
                Log.i ( "孙伟豪","小时："+c.get ( Calendar.HOUR_OF_DAY ));
                Log.i ( "孙伟豪","分钟："+c.get ( Calendar.MINUTE ));
                Log.i ( "孙伟豪","秒："+c.get ( Calendar.SECOND ));
                c.set ( Calendar.YEAR,Calendar.MONTH,Calendar.DATE,Calendar.HOUR_OF_DAY,Calendar.MINUTE,Calendar.SECOND+1);

               /* c.set ( Calendar.HOUR_OF_DAY,timePicker.getHour () );//第一个参数为类型，第二个是小时数
                c.set ( Calendar.MINUTE,timePicker.getMinute () );//类型，分钟
                c.set (Calendar.SECOND,0);//类型为秒，0秒就开始*/
                alarmManager.set ( AlarmManager.RTC_WAKEUP,c.getTimeInMillis (),pendingIntent );//类型，哪个时间，做什么
                Toast.makeText ( this, "闹钟设置成功", Toast.LENGTH_SHORT ).show ( );
                     break;
        }
    }
}
