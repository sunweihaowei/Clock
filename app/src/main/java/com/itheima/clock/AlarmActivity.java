package com.itheima.clock;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_alarm );
        final MediaPlayer mediaPlayer=MediaPlayer.create ( this,R.raw.clork);
        mediaPlayer.start ();
        AlertDialog alertDialog=new AlertDialog.Builder ( AlarmActivity.this ).create ();
        alertDialog.setTitle ( "闹钟响了" );
        alertDialog.setIcon ( R.drawable.time );
        alertDialog.setMessage ( "今天我要努力学习" );
        alertDialog.setButton ( DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener ( ) {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText ( AlarmActivity.this, "你延迟了闹钟", Toast.LENGTH_SHORT ).show ( );
            }
        } );
        alertDialog.setButton ( DialogInterface.BUTTON_POSITIVE, "确定", getDrawable ( R.drawable.time ), new DialogInterface.OnClickListener ( ) {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 mediaPlayer.stop ();
                 mediaPlayer.pause ();
            }
        } );
        alertDialog.show ();
    }
}
