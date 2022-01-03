package com.example.kamusistilahhukum.view;

import static android.os.Build.VERSION_CODES.R;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kamusistilahhukum.R;
import com.example.kamusistilahhukum.databinding.FragmentSaranBinding;
import com.example.kamusistilahhukum.model.IstilahHukum;
import com.example.kamusistilahhukum.viewmodel.IstilahHukumViewModel;
import com.google.android.material.textfield.TextInputEditText;
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
    private TextInputEditText editNama, editShortDesc,editLongDesc;
    private IstilahHukumViewModel viewModel;



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

        editNama=bindingSaran.editTextNama;
        editShortDesc=bindingSaran.editTextShortDesc;
        editLongDesc=bindingSaran.editTextLongDesc;

        submitBtn= bindingSaran.submitButton;
        submitBtn.setOnClickListener(v -> {
            ambilInput();
            successDialog();

        });

    }


    public void ambilInput(){
        String namaIstilahBaru= String.valueOf(teksNama.getEditText().getText());
        String shortDescIstilahBaru= String.valueOf(teksShortDesc.getEditText().getText());
        String detailDescIstilahBaru= String.valueOf(teksLongDesc.getEditText().getText());

        IstilahHukum simpanIstilahBaru= new IstilahHukum(namaIstilahBaru, shortDescIstilahBaru,detailDescIstilahBaru);

        viewModel= new ViewModelProvider(getActivity()).get(IstilahHukumViewModel.class);
        viewModel.insert(simpanIstilahBaru);

        bindingSaran.textInputLayoutNama.getEditText().getText().clear();
        bindingSaran.textInputLayoutShortDesc.getEditText().getText().clear();
        bindingSaran.textInputLayoutLongDesc.getEditText().getText().clear();

    }

    public void successDialog(){
        int themeResID=com.example.kamusistilahhukum.R.style.dialog_styling;
        Dialog saranSuccess= new Dialog(getActivity(), themeResID);

        int customLayout= com.example.kamusistilahhukum.R.layout.custom_success_dialog;
        saranSuccess.setContentView(customLayout);

        int OK_buttonID=com.example.kamusistilahhukum.R.id.buttonOkDialog;
        Button confirmButton=saranSuccess.findViewById(OK_buttonID);

        confirmButton.setOnClickListener(v -> {
            saranSuccess.dismiss();
        });


    }

    public void validateIstilah(){
        editNama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}