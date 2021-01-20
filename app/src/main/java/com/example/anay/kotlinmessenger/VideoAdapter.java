package com.example.anay.kotlinmessenger;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private Context mcontext;
    private MediaController mc;
    private List<upload> muploads;
    String vr = "0";
    public VideoAdapter(Context context,List<upload> uploads){
        mcontext=context;
        muploads=uploads;
    }
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.video_item, viewGroup, false);
        return new VideoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder videoViewHolder, int i) {
        String string;
        upload uploadCurrent=muploads.get(i);
        videoViewHolder.txtView.setText(uploadCurrent.getName());
        string=uploadCurrent.getUrl();
        Uri uri=Uri.parse(string);
        videoViewHolder.videoView.setVideoURI(uri);

        videoViewHolder.txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vr.equals("0"))
                {
                    videoViewHolder.videoView.start();
                    vr="1";
                }
                else if (vr.equals("1"))
                {
                    videoViewHolder.videoView.pause();
                    vr="0";
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return muploads.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        public TextView txtView;
        public VideoView videoView;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView=itemView.findViewById(R.id.text_name);
            videoView=itemView.findViewById(R.id.video_view_upload);

        }
    }
}
