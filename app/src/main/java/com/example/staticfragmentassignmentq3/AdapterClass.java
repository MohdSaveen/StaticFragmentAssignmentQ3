package com.example.staticfragmentassignmentq3;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<ViewHolderClass> {

    private List<ResponseDTO> responseDTOArrayList=new ArrayList<>();

    public AdapterClass( List<ResponseDTO> responseDTOArrayList) {
        this.responseDTOArrayList = responseDTOArrayList;
    }
    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolderClass(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        Log.d(TAG, "onBindViewHolder: enterbind");
        ResponseDTO data=responseDTOArrayList.get(position);
        Log.d(TAG, "onBindViewHolder: enter setdataholder");
        holder.setData(data);
    }
    @Override
    public int getItemCount() {
        return responseDTOArrayList.size();
    }

    public void update(List<ResponseDTO> responseDTOArrayList) {
        this.responseDTOArrayList=responseDTOArrayList;
        notifyDataSetChanged();
    }
}
