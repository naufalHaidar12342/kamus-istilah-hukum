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
import com.example.kamusistilahhukum.model.IstilahHukum;
import com.example.kamusistilahhukum.viewmodel.IstilahHukumViewModel;

public class IstilahHukumDetail extends Fragment {
    FragmentIstilahHukumDetailBinding bindingDetail;
    TextView istilah, penjelasanIstilah;
    private IstilahHukumViewModel modelDetail;
    private IstilahHukumDetail detailHukum;


    public IstilahHukumDetail() {
        // Required empty public constructor
    }

    public IstilahHukumDetail newInstance(){
        if (this.detailHukum==null){
            detailHukum=new IstilahHukumDetail();
        }
        return this.detailHukum;
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
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments()!=null && getArguments().containsKey(IstilahHukum.ISTILAH_PARCEL)){
            IstilahHukum panggilIstilah=getArguments().getParcelable(IstilahHukum.ISTILAH_PARCEL);
            bindingDetail.tvIstilahDetail.setText(panggilIstilah.getIstilah());
            bindingDetail.tvIsiPenjelasan.setText(panggilIstilah.getDetailDesc());
        }
    }
}