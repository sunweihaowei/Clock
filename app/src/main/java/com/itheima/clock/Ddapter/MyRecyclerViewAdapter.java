package com.itheima.clock.Ddapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.itheima.clock.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter <MyRecyclerViewAdapter.MyViewHolder> {
    private final Context context;
    private final List <Map<String,Object>> list;

    public MyRecyclerViewAdapter(Context context, List <Map<String,Object>> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View inflate = View.inflate ( context, R.layout.clock_list_item, null );

        return new MyViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_time.setText ( list.get ( 1 ).get ( "time" )+"" );
        myViewHolder.tv_repetition.setText ( list.get ( 1 ).get ( "type" )+"" );
        myViewHolder.tv_name.setText ( list.get ( 1 ).get ( "content" )+"" );
        myViewHolder.tv_switch.setText ( list.get ( 1 ).get ( "mswitch" )+"" );
    }

    @Override
    public int getItemCount() {
        return list.size ( );
    }
    public void addData(Map<String,Object> map) {
        list.add ( map );
        notifyItemInserted ( 1 );
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_time;
        private TextView tv_repetition;
        private TextView tv_name;
        private Switch sw;
        private TextView tv_switch;

        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );
            tv_time=itemView.findViewById ( R.id.tv_time );
            tv_repetition=itemView.findViewById ( R.id.tv_repetition );
            tv_name=itemView.findViewById ( R.id.tv_name );
            tv_switch=itemView.findViewById ( R.id.tv_switch );
            sw=itemView.findViewById ( R.id.sw );
        }
    }

}
