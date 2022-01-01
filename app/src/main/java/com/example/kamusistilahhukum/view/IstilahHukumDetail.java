package com.example.kamusistilahhukum.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kamusistilahhukum.databinding.FragmentIstilahHukumDetailBinding;
import com.example.kamusistilahhukum.viewmodel.IstilahHukumViewModel;

public class IstilahHukumDetail extends Fragment {
    FragmentIstilahHukumDetailBinding bindingDetail;
    TextView istilah, penjelasanIstilah;
    private IstilahHukumViewModel modelDetail;

    public IstilahHukumDetail() {
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
        //return inflater.inflate(R.layout.fragment_istilah_hukum_detail, container, false);
        bindingDetail=FragmentIstilahHukumDetailBinding.inflate(inflater,container,false);
        View view = bindingDetail.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        istilah=bindingDetail.tvIstilahDetail;
        penjelasanIstilah=bindingDetail.tvIsiPenjelasan;

        Bundle bundleTerima=this.getArguments();
        istilah.setText(bundleTerima.getString("istilah_dipilih"));
        penjelasanIstilah.setText(bundleTerima.getString("penjelasan_lengkap_dipilih"));



    }


}