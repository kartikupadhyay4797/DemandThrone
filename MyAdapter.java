package com.example.demandthrone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<Heir> list;

    public MyAdapter(ArrayList<Heir> list) {
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context=viewGroup.getContext();
        int layoutIdForListItem=R.layout.list_item;
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        boolean attachToParentImm=false;

        View view=layoutInflater.inflate(layoutIdForListItem,viewGroup,attachToParentImm);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv,tv2;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv=(TextView)itemView.findViewById(R.id.tv);
            tv2=(TextView)itemView.findViewById(R.id.tv2);
            image=(ImageView)itemView.findViewById(R.id.img);
        }
        void bind(Heir heir){
            switch (heir.getHouse()) {
                case "stark":
                    image.setImageResource(R.drawable.stark);
                    break;

                case "arryn":
                    image.setImageResource(R.drawable.arryn);
                    break;

                case "baratheon":
                    image.setImageResource(R.drawable.baratheon);
                    break;

                case "greyjoy":
                    image.setImageResource(R.drawable.greyjoy);
                    break;

                case "lannister":
                    image.setImageResource(R.drawable.lannister);
                    break;

                case "martell":
                    image.setImageResource(R.drawable.martell);
                    break;

                case "tully":
                    image.setImageResource(R.drawable.tully);
                    break;

                case "tyrell":
                    image.setImageResource(R.drawable.tyrell);
                    break;

                case "targaryen":
                    image.setImageResource(R.drawable.targaryndany);
                    break;

                default:
                    image.setImageResource(R.drawable.got_swords);
                    break;

            }
            tv.setText(heir.getName().toUpperCase());
            tv2.setText("House : "+heir.getHouse().toUpperCase());
        }
    }
}
