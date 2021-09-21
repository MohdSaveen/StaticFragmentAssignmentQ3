package com.example.staticfragmentassignmentq3;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {

    private List<ResponseDTO> responseDTOArrayList=new ArrayList<>();
    private RecyclerView recyclerView;
    private EditText etName;
    private Button mBtnApi;
    private AdapterClass adapterClass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setRecyclerData();
    }


    private void initViews(View view) {
        recyclerView=view.findViewById(R.id.recyclerView);
        etName=view.findViewById(R.id.etName);
        mBtnApi=view.findViewById(R.id.btnSave);

        mBtnApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              callApi();
            }
        });


    }

    private void callApi() {
        ApiService apiService=Network.getInstance().create(ApiService.class);
        Call<List<ResponseDTO>> call= apiService.getData(etName.getText().toString());
        call.enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                if(response.body()!=null){
                    responseDTOArrayList=response.body();
                    adapterClass.update(responseDTOArrayList);

                }
            }
            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {
                Toast.makeText(getActivity(), "Not showing", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setRecyclerData() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterClass=new AdapterClass(responseDTOArrayList);
        recyclerView.setAdapter(adapterClass);

    }
}