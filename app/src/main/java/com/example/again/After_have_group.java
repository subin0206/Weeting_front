package com.example.again;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class After_have_group extends AppCompatActivity {
    private ImageView firstRecommendMoim, secondRecommendMoim, firstMyMoim, secondMyMoim;

    String firstRecommendMoimImage;
    String secondRecommendMoimImage;
    String firstMyMoimImage;
    String secondMyMoimImage;

    MainMoimThumbnailData.serviceApi serviceApi;
    MainMoimThumbnailData.MaimMoimThumbnailDataResponse dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_have_group);

        TextView main = findViewById(R.id.mainpage);
        ImageButton search = findViewById(R.id.search);

        ImageButton toHome = findViewById(R.id.toHome);
        ImageButton toList = findViewById(R.id.toList);
        ImageButton toMap = findViewById(R.id.toMap);
//        ImageButton toCalender = (ImageButton) findViewById(R.id.toCalender);
        ImageButton toMypage = findViewById(R.id.toMypage);

        firstRecommendMoim = findViewById(R.id.firstRandomMoim);
        secondRecommendMoim = findViewById(R.id.secondRandomMoim);

        firstMyMoim = findViewById(R.id.firstMyMoim);
        secondMyMoim = findViewById(R.id.secondMyMoim);

        serviceApi = RetrofitClient.getClient().create(MainMoimThumbnailData.serviceApi.class);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });

        toHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        toList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MoimList.class);
                intent.putExtra("category", "all");
                startActivity(intent);
            }
        });

        toMap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Create.class);
                startActivity(intent);
            }
        });

//        toCalender.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), ToCalender.class);
//                startActivity(intent);
//            }
//        });

        toMypage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mypage.class);
                startActivity(intent);
            }
        });

        serviceApi.getAfterHaveMoimMain().enqueue(new Callback<MainMoimThumbnailData.MaimMoimThumbnailDataResponse>() {
            @Override
            public void onResponse(Call<MainMoimThumbnailData.MaimMoimThumbnailDataResponse> call, Response<MainMoimThumbnailData.MaimMoimThumbnailDataResponse> response) {
                dataList = response.body();

                for(MainMoimThumbnailData mainMoimThumbnailData : dataList.getRecommend_mettings()){



                }
            }

            @Override
            public void onFailure(Call<MainMoimThumbnailData.MaimMoimThumbnailDataResponse> call, Throwable t) {

            }
        });


    }
}
