package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.FoodOrderViewHolder> {
    private Context mContext;
    private ArrayList<Makanan> dataList;

    public OrderAdapter(Context context, ArrayList<Makanan> dataList) {
        mContext = context;
        this.dataList = dataList;
    }


    @Override
    public FoodOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_tugas4__adapter, parent, false);
        return new FoodOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodOrderViewHolder holder, int position) {
        Integer index = dataList.get(position).getIndex();
        holder.txtNamaMkn.setText(dataList.get(position).getNamaMakanan());
        holder.txtHargaMkn.setText(dataList.get(position).getHargaMakanan());


        final Intent intent = new Intent(mContext, ActivityCount2.class);
        intent.putExtra("index",index);
        intent.putExtra("txt_namaMkn",dataList.get(position).getNamaMakanan());
        intent.putExtra("txt_hargaMkn",dataList.get(position).getHargaMakanan());
        holder.layoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) mContext).startActivityForResult(intent,1);
                Toast.makeText(mContext.getApplicationContext(),"iso o", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class FoodOrderViewHolder extends RecyclerView.ViewHolder{
        public TextView txtNamaMkn, txtHargaMkn;
        public CardView layoutitem;

        public FoodOrderViewHolder(View itemView) {
            super(itemView);
            txtNamaMkn = (TextView) itemView.findViewById(R.id.txt_namaMkn);
            txtHargaMkn = (TextView) itemView.findViewById(R.id.txt_hargaMkn);
            layoutitem = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}

