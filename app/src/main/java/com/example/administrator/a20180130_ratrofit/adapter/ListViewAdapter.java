package com.example.administrator.a20180130_ratrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.a20180130_ratrofit.R;
import com.example.administrator.a20180130_ratrofit.model.Item;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-01-30.
 */

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Item> item = new ArrayList<>(); // ★변수 이름 중복...체크
    Context context;

    public ListViewAdapter() {
    }

    public ListViewAdapter(ArrayList<Item> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int i) {
        return item.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();

        if(view == null){
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tmp,viewGroup,false);
        holder.text1 = view.findViewById(R.id.text1);
        holder.text2 = view.findViewById(R.id.text2);
        holder.text3 = view.findViewById(R.id.text3);
        holder.img = view.findViewById(R.id.img);

        view.setTag(holder);
    }else{
            holder = (Holder)view.getTag();
        }

        Item item2 = (Item)getItem(i);
        holder.text1.setText(item2.getId().toString());
        holder.text2.setText(item2.getName().toString());
        holder.text3.setText(item2.getPrice().toString());
        Glide.with(context).load(item2.getImg()).centerCrop().into(holder.img);




        return view;
    }

    private class Holder{
        TextView text1;
        TextView text2;
        TextView text3;
        ImageView img;

    }


}
