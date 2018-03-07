package com.example.administrator.day05_smallproject_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.day05_smallproject_test.R;
import com.example.administrator.day05_smallproject_test.bean.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User.ResultBean.DataBean> beanList;
    private Context context;

    public RecyAdapter(List<User.ResultBean.DataBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        int type = 0;
        if (TextUtils.isEmpty(beanList.get(position).getThumbnail_pic_s02())) {
            type = 1;
        } else if (TextUtils.isEmpty(beanList.get(position).getThumbnail_pic_s03())) {
            type = 2;
        } else {
            type = 3;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;

        switch (viewType) {

            case 1:
                View inflate = LayoutInflater.from(context).inflate(R.layout.recy_item1, parent, false);
                holder = new FirstViewHoler(inflate);

                break;
            case 2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.recy_item2, parent, false);
                holder = new SecondViewHoler(inflate2);


                break;
            case 3:
                View inflate3 = LayoutInflater.from(context).inflate(R.layout.recy_item3, parent, false);
                holder = new ThirdViewHoler(inflate3);

                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (TextUtils.isEmpty(beanList.get(position).getThumbnail_pic_s02())) {

            ((FirstViewHoler)holder).title1.setText(beanList.get(position).getTitle());
            ((FirstViewHoler)holder).date1.setText(beanList.get(position).getDate());
            Picasso.with(context).load(beanList.get(position).getThumbnail_pic_s()).into(((FirstViewHoler) holder).img1);


        } else if (TextUtils.isEmpty(beanList.get(position).getThumbnail_pic_s03())) {


            ((SecondViewHoler)holder).title2.setText(beanList.get(position).getTitle());
            ((SecondViewHoler)holder).date2.setText(beanList.get(position).getDate());
            Picasso.with(context).load(beanList.get(position).getThumbnail_pic_s()).into(((SecondViewHoler) holder).img1);
            Picasso.with(context).load(beanList.get(position).getThumbnail_pic_s02()).into(((SecondViewHoler) holder).img2);


        } else {


            ((ThirdViewHoler)holder).title3.setText(beanList.get(position).getTitle());
            ((ThirdViewHoler)holder).date3.setText(beanList.get(position).getDate());
            Picasso.with(context).load(beanList.get(position).getThumbnail_pic_s()).into(((ThirdViewHoler) holder).img1);
            Picasso.with(context).load(beanList.get(position).getThumbnail_pic_s02()).into(((ThirdViewHoler) holder).img2);
            Picasso.with(context).load(beanList.get(position).getThumbnail_pic_s03()).into(((ThirdViewHoler) holder).img3);

        }


    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class FirstViewHoler extends RecyclerView.ViewHolder {

        private final ImageView img1;
        private final TextView title1;
        private final TextView date1;

        public FirstViewHoler(View itemView) {
            super(itemView);


            img1 = itemView.findViewById(R.id.img1);
            title1 = itemView.findViewById(R.id.title1);
            date1 = itemView.findViewById(R.id.date1);

        }
    }

    class SecondViewHoler extends RecyclerView.ViewHolder {

        private final TextView date2;
        private final TextView title2;
        private final ImageView img2;
        private final ImageView img1;

        public SecondViewHoler(View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            title2 = itemView.findViewById(R.id.title2);
            date2 = itemView.findViewById(R.id.date2);
        }
    }

    class ThirdViewHoler extends RecyclerView.ViewHolder {

        private final TextView date3;
        private final TextView title3;
        private final ImageView img3;
        private final ImageView img2;
        private final ImageView img1;

        public ThirdViewHoler(View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            img3 = itemView.findViewById(R.id.img3);
            title3 = itemView.findViewById(R.id.title3);
            date3 = itemView.findViewById(R.id.date3);
        }
    }
}
