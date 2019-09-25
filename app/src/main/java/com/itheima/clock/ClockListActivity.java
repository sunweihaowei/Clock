package com.itheima.clock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.itheima.clock.Ddapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClockListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List <Map<String,Object>> list = new ArrayList <> ( );
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private Button add;
    private RecyclerView recycleView;
    private String time="03:30";
    private String type="每天";
    private String content="起床";
    private String mswitch="开";
    private Map<String,Object> map;
    private Map<String,Object> map1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_clock_list );
        initView ( );
        map=new HashMap <String, Object> (  );
        map.put ( "time",time );
        map.put ( "type",type );
        map.put ( "content",content  );
        map.put ( "mswitch", mswitch );
        list.add ( map );
        map1=new HashMap <String, Object> (  );
        map1.put ( "time",time );
        map1.put ( "type",type );
        map1.put ( "content",content  );
        map1.put ( "mswitch", mswitch );
        list.add ( map1 );
        myRecyclerViewAdapter = new MyRecyclerViewAdapter ( ClockListActivity.this, list );
        recyclerView.setAdapter ( myRecyclerViewAdapter );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( ClockListActivity.this, LinearLayoutManager.VERTICAL, false ) );
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById ( R.id.recycleView );
        add = (Button) findViewById ( R.id.add );
        add.setOnClickListener ( this );
        recycleView = (RecyclerView) findViewById ( R.id.recycleView );
        recycleView.setOnClickListener ( this );
    }
    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.add:
              myRecyclerViewAdapter.addData(map);
                break;
        }
    }
}
