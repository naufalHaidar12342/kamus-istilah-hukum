package com.example.kamusistilahhukum.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kamusistilahhukum.databinding.FragmentSaranBinding;
import com.google.android.material.textfield.TextInputLayout;


public class SaranFragment extends Fragment {

    /*rumus nama binding:
    nama file xml/ layoutnya, dibuat pascal case
    misal: fragment_comment
        menjadi FragmentComment + Binding
        jadinya : FragmentCommentBinding
    */
    private FragmentSaranBinding bindingSaran;
    private Button submitBtn;
    private TextInputLayout teksNama, teksShortDesc, teksLongDesc;



    public SaranFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //
        bindingSaran =FragmentSaranBinding.inflate(inflater,container,false);
        View viewBaruBinding= bindingSaran.getRoot();

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_comment, container, false);
        return viewBaruBinding;
    }

    /*alt +insert atau klik kanan->override->pilih onviewcreated
    * catatan: onviewcreated tidak di generate otomatis */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(),"Komen disini, ya!",Toast.LENGTH_SHORT).show();

        teksNama= bindingSaran.textInputLayoutNama;
        teksShortDesc = bindingSaran.textInputLayoutShortDesc;
        teksLongDesc= bindingSaran.textInputLayoutLongDesc;


        submitBtn= bindingSaran.submitButton;
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ambilInput();
            }
        });

    }

    public void ambilInput(){
        String nama= String.valueOf(teksNama.getEditText().getText());
        String komentar= String.valueOf(teksShortDesc.getEditText().getText());




    }
}