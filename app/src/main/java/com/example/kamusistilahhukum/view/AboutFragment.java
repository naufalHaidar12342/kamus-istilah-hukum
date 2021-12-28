package com.example.kamusistilahhukum.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamusistilahhukum.R;
import com.example.kamusistilahhukum.databinding.FragmentAboutBinding;
import com.google.android.material.imageview.ShapeableImageView;

public class AboutFragment extends Fragment {
    FragmentAboutBinding bindingAbout;
    ShapeableImageView img;
    TextView aboutMe;

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_about, container, false);

        bindingAbout=FragmentAboutBinding.inflate(inflater,container,false);
        View view=bindingAbout.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img=bindingAbout.shapeableImageViewMe;
        aboutMe=bindingAbout.tvAboutMe;
        img.setImageResource(R.drawable.ic_launcher_foreground);

    }
}