package com.example.kamusistilahhukum.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kamusistilahhukum.R;
import com.example.kamusistilahhukum.databinding.FragmentHomeBinding;
import com.example.kamusistilahhukum.databinding.FragmentIstilahHukumDetailBinding;
import com.example.kamusistilahhukum.model.IstilahHukum;
import com.example.kamusistilahhukum.model.IstilahHukumAdapter;
import com.example.kamusistilahhukum.viewmodel.IstilahHukumViewModel;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    public IstilahHukumViewModel istilahModel;
    ArrayList<IstilahHukum> listIstilahnya;
    RecyclerView rvIstilah;
    IstilahHukumAdapter adapter;
    FragmentHomeBinding bindingHome;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvIstilah=bindingHome.recyclerViewHome;

        listIstilahnya=new ArrayList<>();
        adapter=new IstilahHukumAdapter(listIstilahnya);
        rvIstilah.setAdapter(adapter);
        rvIstilah.setLayoutManager(
                new LinearLayoutManager(getContext()));

        istilahModel=new ViewModelProvider(getActivity()).get(IstilahHukumViewModel.class);
        istilahModel.getIstilah().observe(getActivity(), new Observer<List<IstilahHukum>>() {
            @Override
            public void onChanged(List<IstilahHukum> istilahHukums) {
                //adapter.submitList(istilahHukums);
                listIstilahnya.clear();
                listIstilahnya.addAll(istilahHukums);
                adapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindingHome=FragmentHomeBinding.inflate(inflater,container,false);
        View view=bindingHome.getRoot();
        //view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container,false);


        // Inflate the layout for this fragment
        return view;


    }
}