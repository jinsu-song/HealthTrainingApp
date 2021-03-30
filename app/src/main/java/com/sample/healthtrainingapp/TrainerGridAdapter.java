package com.sample.healthtrainingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrainerGridAdapter extends BaseAdapter {
    Context context;
    private ArrayList<TrainerData> trainerList ;

    public TrainerGridAdapter(Context context, ArrayList<TrainerData> trainerList) {
        this.context = context;
        this.trainerList = trainerList;
    }

    @Override
    public int getCount() {
        return (trainerList != null) ? trainerList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView ivTrainer;
        TextView tv_TrainerName, tv_TrainerPosition, tv_TrainerCareer;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_grid_view,parent,false);
        }
        ivTrainer = convertView.findViewById(R.id.ivTrainer);
        tv_TrainerName = convertView.findViewById(R.id.tv_TrainerName);
        tv_TrainerPosition = convertView.findViewById(R.id.tv_TrainerPosition);
        tv_TrainerCareer = convertView.findViewById(R.id.tv_TrainerCareer);

        Glide.with(ivTrainer).load(trainerList.get(position).getPicture()).circleCrop().into(ivTrainer);
        tv_TrainerName.setText(trainerList.get(position).getTrainerName());
        tv_TrainerPosition.setText(trainerList.get(position).getTrainerPosition());
        tv_TrainerCareer.setText(trainerList.get(position).getTrainerCareer());

        return convertView;
    }
}
