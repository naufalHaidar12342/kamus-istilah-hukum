package com.example.kamusistilahhukum.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IstilahHukumDao {

    @Query("SELECT * FROM daftar_istilah ORDER BY nama_istilah ASC")
    LiveData<List<IstilahHukum>> getIstilahAlphaOrdered();

    @Insert
    void insertIstilah(IstilahHukum simpanIstilah);

    @Delete
    void deleteIstilah(IstilahHukum hapusIstilah);

    @Update
    void updateIstilah(IstilahHukum updateIstilah);
}
