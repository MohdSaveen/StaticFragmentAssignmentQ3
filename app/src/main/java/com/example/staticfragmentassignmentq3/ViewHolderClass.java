package com.example.staticfragmentassignmentq3;

import static android.content.ContentValues.TAG;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolderClass extends RecyclerView.ViewHolder {

    private TextView mTvName;
    private TextView mtvLogin;
    private ImageView mIvImage;

    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);
        Log.d(TAG, "ViewHolderClass: entering");
        mTvName=itemView.findViewById(R.id.tvName);
        mtvLogin=itemView.findViewById(R.id.tvLogin);
        mIvImage=itemView.findViewById(R.id.imageView);
        Log.d(TAG, "ViewHolderClass: going");
    }

    public void setData(ResponseDTO responseDTO){
        Log.d(TAG, "setData: tvname");
        mTvName.setText(responseDTO.getFullName());
        Log.d(TAG, "setData: enterlogin");
        mtvLogin.setText(responseDTO.getOwner().getLogin());
        Log.d(TAG, "setData: enterAvtaar");
        Glide.with(mIvImage).load(responseDTO.getOwner().getAvatarUrl()).into(mIvImage);
        Log.d(TAG, "setData: goingoutside");
    }
}
