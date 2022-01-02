package com.example.kamusistilahhukum.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "daftar_istilah")
public class IstilahHukum implements Parcelable {
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

    public static final String ISTILAH_PARCEL="parcel_istilah_hukum";

    protected IstilahHukum(Parcel in) {
        uid = in.readInt();
        istilah = in.readString();
        description = in.readString();
        detailDesc = in.readString();
    }

    public static final Creator<IstilahHukum> CREATOR = new Creator<IstilahHukum>() {
        @Override
        public IstilahHukum createFromParcel(Parcel in) {
            return new IstilahHukum(in);
        }

        @Override
        public IstilahHukum[] newArray(int size) {
            return new IstilahHukum[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(uid);
        parcel.writeString(istilah);
        parcel.writeString(description);
        parcel.writeString(detailDesc);
    }
}
