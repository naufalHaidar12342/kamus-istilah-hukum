package com.example.kamusistilahhukum.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kamusistilahhukum.databinding.FragmentAboutBinding;
import com.google.android.material.imageview.ShapeableImageView;

public class AboutFragment extends Fragment {
    FragmentAboutBinding bindingAbout;
    ShapeableImageView img;
    TextView aboutMe;
    Button github, telegram;

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
        github=bindingAbout.buttonGithub;
        telegram=bindingAbout.buttonTelegram;

        github.setOnClickListener(view1 -> {
            Intent githubProflile= new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/naufalHaidar12342"));
            startActivity(githubProflile);

        });

        telegram.setOnClickListener(view1 -> {
            Intent telegramProfile= new Intent(Intent.ACTION_VIEW,Uri.parse("https://t.me/heydar12342"));
            startActivity(telegramProfile);
        });


    }
}