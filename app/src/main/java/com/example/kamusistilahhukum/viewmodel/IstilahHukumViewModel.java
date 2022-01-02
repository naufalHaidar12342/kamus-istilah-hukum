package com.example.kamusistilahhukum.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kamusistilahhukum.model.IstilahHukum;
import com.example.kamusistilahhukum.model.IstilahHukumDatabase;
import com.example.kamusistilahhukum.model.IstilahHukumRepository;

import java.util.List;

public class IstilahHukumViewModel extends AndroidViewModel {
    private final IstilahHukumRepository repo;
    private final LiveData<List<IstilahHukum>> allIstilahs;
    private final MutableLiveData<IstilahHukum> mutableDetailIstilah=new MutableLiveData<>();

    public IstilahHukumViewModel(@NonNull Application application) {
        super(application);
        repo=new IstilahHukumRepository(application);
        allIstilahs=repo.getIstilahs();
    }

    public LiveData<List<IstilahHukum>> getIstilah(){
        return allIstilahs;
    }

    public void insert(IstilahHukum istilahHukum){
        repo.insert(istilahHukum);
    }

    public void delete(IstilahHukum istilahHukum){
        repo.delete(istilahHukum);
    }

    public void setTextIstilahDetail(IstilahHukum istilahHukum){
        mutableDetailIstilah.setValue(istilahHukum);
    }

    public LiveData<IstilahHukum> getTextIstilahDetail(){
        return mutableDetailIstilah;
    }

}
