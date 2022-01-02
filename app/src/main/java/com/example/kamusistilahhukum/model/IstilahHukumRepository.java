package com.example.kamusistilahhukum.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class IstilahHukumRepository {
    private final IstilahHukumDao panggilIstilahDao;
    private final LiveData<List<IstilahHukum>> semuaIstilah;

    public IstilahHukumRepository(Application application) {
        IstilahHukumDatabase panggilDB=IstilahHukumDatabase.getDatabaseInstance(application);
        panggilIstilahDao=panggilDB.istilahDao();
        semuaIstilah=panggilIstilahDao.getIstilahAlphaOrdered();
    }

    public LiveData<List<IstilahHukum>> getIstilahs(){
        return semuaIstilah;
    }
    public void insert(IstilahHukum istilahHukumnya){
        IstilahHukumDatabase.dbWriter.execute(() -> {
            panggilIstilahDao.insertIstilah(istilahHukumnya);
        });
    }

    public void delete(IstilahHukum istilahHukumnya){
        IstilahHukumDatabase.dbWriter.execute(() -> {
            panggilIstilahDao.deleteIstilah(istilahHukumnya);
        });
    }
}
