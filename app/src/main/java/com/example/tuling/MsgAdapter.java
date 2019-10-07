package com.example.tuling;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.tuling.Bean.Msg;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    List<Msg> msgList = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public MsgAdapter(List<Msg> list,Context context){
        this.msgList = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =inflater.inflate(R.layout.msg_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MsgAdapter.ViewHolder viewHolder, int i) {
        Msg msg = msgList.get(i);
        if (msg.getType() == Msg.TYPE_RECEIVED){
            viewHolder.left.setVisibility(View.VISIBLE);
            viewHolder.right.setVisibility(View.GONE);
            viewHolder.imageView_right.setVisibility(View.GONE);
            viewHolder.imageView_left.setVisibility(View.VISIBLE);
            viewHolder.left_msg.setText(msg.getContent());
        }else{
            viewHolder.left.setVisibility(View.GONE);
            viewHolder.right.setVisibility(View.VISIBLE);
            viewHolder.imageView_left.setVisibility(View.GONE);
            viewHolder.imageView_right.setVisibility(View.VISIBLE);
            viewHolder.right_msg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout left;
        RelativeLayout right;
        CircleImageView imageView_left;
        CircleImageView imageView_right;
        TextView left_msg;
        TextView right_msg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_left = itemView.findViewById(R.id.image_left);
            imageView_right = itemView.findViewById(R.id.right_image);
            Glide.with(context).load(R.drawable.seretary).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.seretary).into(imageView_left);
            Glide.with(context).load(R.drawable.me).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.me).into(imageView_right);
            left = itemView.findViewById(R.id.left_layout);
            right = itemView.findViewById(R.id.right_layout);
            left_msg = itemView.findViewById(R.id.left_mag);
            right_msg = itemView.findViewById(R.id.right_msg);
        }
    }
}
