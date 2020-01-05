package com.taweesak.myappfmrvcommultiview;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    ArrayList<MyChidModel> listData;
    MyListener listener;

    public MyAdapter(Context context, ArrayList<MyChidModel> listData, MyListener listener) {
        this.context = context;
        this.listData = listData;
        this.listener = listener;
    }


    public class VH extends RecyclerView.ViewHolder{
        ImageView imageFlag;
        TextView tv_country,tv_rate;

        public VH(@NonNull View itemView) {
            super(itemView);
            imageFlag = itemView.findViewById(R.id.imageFlag);
            tv_country = itemView.findViewById(R.id.tv_country);
            tv_rate = itemView.findViewById(R.id.tv_rate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickItem = (int) view.getTag();
                    listener.myCallback(listData.get(clickItem));
                    Toast.makeText(context,"data is "+clickItem,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class VH2 extends RecyclerView.ViewHolder{
        ImageView imageFlag;
        TextView tv_country,tv_setTextTest;

        public VH2(@NonNull View itemView) {
            super(itemView);
            imageFlag = itemView.findViewById(R.id.imageFlag);
            tv_country = itemView.findViewById(R.id.tv_country);
            tv_setTextTest = itemView.findViewById(R.id.tv_setTextTest);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickItem = (int) view.getTag();
                    listener.myCallback(listData.get(clickItem));
                    Toast.makeText(context,"data is "+clickItem,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType){
            case MyChidModel.TYPE_A:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item,parent,false);
                return new VH(itemView);
            case MyChidModel.TYPE_B:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item2,parent,false);
                return new VH2(itemView);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyChidModel object = listData.get(position);
        if (object != null){
            switch (object.Type){
                case MyChidModel.TYPE_A:
                    ((VH)holder).tv_country.setText(object.getCountry());
                    ((VH)holder).tv_rate.setText(""+object.getRate());
                    ((VH)holder).imageFlag.setImageResource(object.getImage());
                    break;

                case MyChidModel.TYPE_B:
                    ((VH2)holder).tv_country.setText(object.getCountry());
                    ((VH2)holder).tv_setTextTest.setText(""+object.getSetTextText());
                    ((VH2)holder).imageFlag.setImageResource(object.getImage());
                    break;
            }
        }
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemViewType(int position) {
        // return super.getItemViewType(position);

        switch (listData.get(position).Type){
            case 0:
                return MyChidModel.TYPE_A;
            case 1:
                return MyChidModel.TYPE_B;
            default:
                return -1;
        }

        //return position%2;
    }



    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (context instanceof MyListener){
            listener = (MyListener) context;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }
}
