package com.example.kamusistilahhukum.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "daftar_istilah")
public class IstilahHukum {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nama_istilah")
    public String istilah;

    @ColumnInfo(name = "penjelasan_singkat")
    public String description;

    @ColumnInfo(name = "penjelasan_detail")
    public String detailDesc;

    public IstilahHukum(String istilah, String description, String detailDesc) {
        this.istilah = istilah;
        this.description = description;
        this.detailDesc = detailDesc;
    }

    public int getUid() {
        return this.uid;
    }

    public String getIstilah() {
        return this.istilah;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDetailDesc() {
        return this.detailDesc;
    }
}
