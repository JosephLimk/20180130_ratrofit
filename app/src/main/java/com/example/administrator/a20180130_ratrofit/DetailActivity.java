package com.example.administrator.a20180130_ratrofit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.detail_img) ImageView detail_img;
    @BindView(R.id.detail_text1) TextView detail_text1;
    @BindView(R.id.detail_text2) TextView detail_text2;
    @BindView(R.id.detail_text3) TextView detail_text3;

    /*ImageView imageView;
    TextView text1;
    TextView text2;
    TextView text3;
    Context context;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        /*
        imageView= findViewById(R.id.detail_img);
        text1 = findViewById(R.id.detail_text1);
        text2 = findViewById(R.id.detail_text2);
        text3 = findViewById(R.id.detail_text3);
        */

        Intent intent = getIntent();
        Integer id = intent.getIntExtra("id",0);
        String name = intent.getStringExtra("name");
        Integer price = intent.getIntExtra("price",0);
        String img = intent.getStringExtra("img");

        Glide.with(DetailActivity.this).load(img).centerCrop().into(detail_img);
        //액티비티에 context말고  DetailActivity.this이거 넣어야합니다.
        detail_text1.setText(id.toString());
        detail_text2.setText(name);
        detail_text3.setText(price.toString());






    }
}
