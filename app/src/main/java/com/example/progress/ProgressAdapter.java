package com.example.progress;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.MyViewHolder> {

    private List<Progress> progressList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            progressBar = (ProgressBar) view.findViewById(R.id.SingleProgress);
//            progressBar.getLayoutParams().height = new Random().nextInt((50 - 20) + 1) + 20;

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(progressBar.getLayoutParams().width, new Random().nextInt((250 - 50) + 1) + 50);
            progressBar.setLayoutParams(params);




        }
    }


    public ProgressAdapter(List<Progress> progressList) {
        this.progressList = progressList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_progress, parent, false);

//        GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) itemView.getLayoutParams();
//        lp.height = parent.getMeasuredHeight() / 4;
//        itemView.setLayoutParams(lp);

//        int height = parent.getMeasuredHeight() / new Random().nextInt((4 - 2) + 1) + 2;;
//        itemView.setMinimumHeight(height);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Progress progress = progressList.get(position);

//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(holder.progressBar.getLayoutParams().width, new Random().nextInt((250 - 50) + 1) + 50);
//        holder.progressBar.setLayoutParams(params);


        holder.progressBar.setProgress(progress.getProgressDone());

    }

    @Override
    public int getItemCount() {
        return progressList.size();
    }

}
