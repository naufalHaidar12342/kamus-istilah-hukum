package com.example.kamusistilahhukum.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamusistilahhukum.R;

import java.util.List;

public class IstilahHukumAdapter extends RecyclerView.Adapter<IstilahHukumAdapter.IstilahHukumViewHolder> {
    private final List<IstilahHukum> listIstilah;

    public IstilahHukumAdapter(List<IstilahHukum> listIstilah) {
        this.listIstilah = listIstilah;
    }
    //    public IstilahHukumAdapter() {
//        super(DIFF_CALLBACK);
//    }
//    private static final DiffUtil.ItemCallback<IstilahHukum> DIFF_CALLBACK= new DiffUtil.ItemCallback<IstilahHukum>() {
//        @Override
//        public boolean areItemsTheSame(@NonNull IstilahHukum oldItem, @NonNull IstilahHukum newItem) {
//            return oldItem.getUid()== newItem.getUid();
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull IstilahHukum oldItem, @NonNull IstilahHukum newItem) {
//            return oldItem.getIstilah().equals(newItem.getIstilah())
//                    && oldItem.getDescription().equals(newItem.getDescription())
//                    && oldItem.getDetailDesc().equals(newItem.getDetailDesc());
//        }
//    };

    @NonNull
    @Override
    public IstilahHukumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        IstilahHukumViewHolder holder= new IstilahHukumViewHolder(
                inflater.inflate(R.layout.istilah_hukum_view,viewGroup,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull IstilahHukumViewHolder istilahHukumViewHolder, int i) {
        //IstilahHukum istilahSaatIni= getItem(i);
        IstilahHukum istilahSaatIni= listIstilah.get(i);
        istilahHukumViewHolder.istilah.setText(istilahSaatIni.getIstilah());
        istilahHukumViewHolder.deskripsiSingkat.setText(istilahSaatIni.getDescription());

    }

    @Override
    public int getItemCount() {
        return listIstilah.size();
    }

    public IstilahHukum getIstilahAt(int position){
        //return getItem(position);
        return listIstilah.get(position);
    }

    public class IstilahHukumViewHolder extends RecyclerView.ViewHolder{
        public TextView istilah;
        public TextView deskripsiSingkat;
        public ConstraintLayout layoutIstilah;
        public ImageView paluHakim;

        public IstilahHukumViewHolder(@NonNull View itemView) {
            super(itemView);
            istilah=itemView.findViewById(R.id.textViewIstilah);
            deskripsiSingkat=itemView.findViewById(R.id.tvShortDesc);
            layoutIstilah=itemView.findViewById(R.id.layout_tiap_istilah_hukum);
            paluHakim=itemView.findViewById(R.id.imgGavelCourt);
            paluHakim.setImageResource(R.drawable.outline_gavel_black_36);

        }
    }


}
