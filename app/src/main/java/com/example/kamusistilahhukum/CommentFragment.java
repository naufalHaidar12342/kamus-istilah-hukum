package com.example.kamusistilahhukum;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamusistilahhukum.databinding.FragmentCommentBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommentFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommentFragment extends Fragment {

    /*rumus nama binding:
    nama file xml/ layoutnya, dibuat pascal case
    misal: fragment_comment
        menjadi FragmentComment + Binding
        jadinya : FragmentCommentBinding
    */
    private FragmentCommentBinding bindCommentary;
    private Button submitBtn;
    private TextInputLayout teksNama,teksKomentar;
    private TextView testNama,testKomentar;


    public CommentFragment() {
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
        bindCommentary=FragmentCommentBinding.inflate(inflater,container,false);
        View viewBaruBinding=bindCommentary.getRoot();

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

        teksNama=bindCommentary.textInputLayoutNama;
        teksKomentar=bindCommentary.textInputLayoutKomentar;

        testNama=bindCommentary.textViewNama;
        testKomentar=bindCommentary.textViewKomen;

        submitBtn=bindCommentary.submitButton;
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ambilInput();
            }
        });

    }

    public void ambilInput(){
        String nama= String.valueOf(teksNama.getEditText().getText());
        String komentar= String.valueOf(teksKomentar.getEditText().getText());

        testNama.setText(nama);
        testKomentar.setText(komentar);

        teksNama.getEditText().setText("");
        teksNama.clearFocus();
        teksKomentar.getEditText().setText("");
        teksKomentar.clearFocus();



    }
}