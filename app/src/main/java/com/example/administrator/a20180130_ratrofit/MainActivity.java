package com.example.administrator.a20180130_ratrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.a20180130_ratrofit.adapter.ListViewAdapter;
import com.example.administrator.a20180130_ratrofit.model.Item;
import com.example.administrator.a20180130_ratrofit.retrofit.RetrofitService;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ListViewAdapter listViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        listview = findViewById(R.id.listview);



        Call<ArrayList<Item>> obser = RetrofitService.getInstance().getRetrofitRequest().getGoods();

        obser.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                if(response.isSuccessful()){
                    final ArrayList<Item> items = response.body();
                    listViewAdapter = new ListViewAdapter(items,MainActivity.this);
                    listview.setAdapter(listViewAdapter);
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Item item2 = items.get(i);

                            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                            intent.putExtra("id",item2.getId());
                            intent.putExtra("name",item2.getName());
                            intent.putExtra("price",item2.getPrice());
                            intent.putExtra("img",item2.getImg());
                            startActivity(intent);
                        }
                    });

                    for(int i = 0 ; i < items.size(); i++){
                        Log.d("joseph",i + " " + items.get(i).toString());
                    }

                    Log.d("ksj",items.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {
                t.printStackTrace();
            }
        });






    }



}
