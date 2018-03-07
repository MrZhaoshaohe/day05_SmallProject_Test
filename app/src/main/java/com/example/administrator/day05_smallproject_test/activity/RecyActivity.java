package com.example.administrator.day05_smallproject_test.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.administrator.day05_smallproject_test.R;
import com.example.administrator.day05_smallproject_test.adapter.RecyAdapter;
import com.example.administrator.day05_smallproject_test.bean.ApiService;
import com.example.administrator.day05_smallproject_test.bean.Constant;
import com.example.administrator.day05_smallproject_test.bean.User;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyActivity extends AppCompatActivity {

    private Banner banner;
    private RecyclerView lv_recy;
    private List<User.ResultBean.DataBean> beanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);
        initView();
        initData();
        initJsonData();

    }

    private void initJsonData() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> call = apiService.getDataUrl(Constant.URL);
        call.enqueue(new Callback<User>() {


            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                beanList = response.body().getResult().getData();
                LinearLayoutManager manager =new LinearLayoutManager(RecyActivity.this,LinearLayoutManager.VERTICAL,false);
                lv_recy.setLayoutManager(manager);
                RecyAdapter adapter =new RecyAdapter(beanList,RecyActivity.this);
                lv_recy.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void initData() {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/28531/cut-20141105163424-649077356.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/5744/cut-20141105163400-882181576.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/10642/cut-20141105163509-311046641.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/27226/cut-20141105163259-200124067.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic/31024/cut-20140303113915-424758572.jpg/0");

        List<String> list = new ArrayList<>();
        list.add("艾露莎");
        list.add("格雷");
        list.add("纳兹");
        list.add("露西");
        list.add("温蒂");
        banner.setImages(arrayList)
                .setDelayTime(2000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setImageLoader(new BitmapPicasso())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setBannerTitles(list)
                .start();

    }
    class BitmapPicasso extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context).load((String) path).into(imageView);
        }
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        lv_recy = (RecyclerView) findViewById(R.id.lv_recy);
    }
}
