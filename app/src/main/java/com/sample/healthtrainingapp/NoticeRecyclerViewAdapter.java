package com.sample.healthtrainingapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoticeRecyclerViewAdapter extends RecyclerView.Adapter<NoticeRecyclerViewAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<NoticeData> noticeDataList;

    // 리스트 포지션 저장할 내부 인터페이스 타입 멤버변수
    private OnItemClickListener mListener = null;

    public NoticeRecyclerViewAdapter(Context context, ArrayList<NoticeData> noticeDataList) {
        this.context = context;
        this.noticeDataList = noticeDataList;
    }

    @NonNull
    @Override
    public NoticeRecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeRecyclerViewAdapter.CustomViewHolder holder, int position) {
        try{
            holder.tvNo.setText(noticeDataList.get(position).getNo());
        }catch (Exception e){
            e.printStackTrace();
        }
        holder.tvTitle.setText(noticeDataList.get(position).getTitle());
        holder.tvContent.setText(noticeDataList.get(position).getContent());
        holder.tvWriteDate.setText(noticeDataList.get(position).getWriteDate());
        holder.tvAuthor.setText(noticeDataList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return (noticeDataList != null) ? noticeDataList.size() : 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle, tvWriteDate, tvContent, tvNo, tvAuthor;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvWriteDate = itemView.findViewById(R.id.tvWriteDate);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        mListener.onItemClick(view,position);
                    }
                }
            });

        }   // end of Constructor
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){this.mListener = listener;}

}
