package com.example.kamusistilahhukum.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {IstilahHukum.class},version = 1,exportSchema = false)
public abstract class IstilahHukumDatabase extends RoomDatabase {
    public abstract IstilahHukumDao istilahDao();

    private static volatile IstilahHukumDatabase INSTANCE;
    static final ExecutorService dbWriter = Executors.newFixedThreadPool(4);

    public static synchronized IstilahHukumDatabase getDatabaseInstance(Context context){
        if (INSTANCE==null){
            INSTANCE=Room.databaseBuilder(context.getApplicationContext(),
                    IstilahHukumDatabase.class,"database_istilah")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(dbCallback)
                    .build();
        }
        return INSTANCE;
    }
    //pre populated database
    // semacam dummy data untuk dimasukkan ke database
    private static final RoomDatabase.Callback dbCallback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            dbWriter.execute(() -> {
                IstilahHukumDao istilahDao= INSTANCE.istilahDao();
                istilahDao.insertIstilah(
                        new IstilahHukum("abolisi",
                                "peniadaan pidana",
                                "Abolisi adalah peniadaan/penghapusan peristiwa pidana. " +
                                        "Hak ini diberikan kepada narapidana yang sedang menjalani" +
                                        "persidangan dan belum ada keputusan dari sidang"));

                istilahDao.insertIstilah(
                        new IstilahHukum("amnesti",
                                "pengurangan masa tahanan",
                                "Amnesti adalah pengurangan masa tahanan. " +
                                        "Hak ini diberikan kepada narapidana yang dianggap " +
                                        "berkelakuan baik selama menjalani masa tahanan"));

                istilahDao.insertIstilah(
                        new IstilahHukum("KUHP",
                                "Kitab Undang-Undang Hukum Pidana",
                                "Buku yang dijadikan dasar hukum dalam menyelesaikan " +
                                        "kasus yang menyangkut kepentingan umum, " +
                                        "misal dalam kasus lembaga pemerintah vs. perseorangan/ kelompok"));

                istilahDao.insertIstilah(
                        new IstilahHukum("KUHPer",
                                "Kitab Undang-Undang Hukum Perdata",
                                "Buku yang dijadikan dasar hukum dalam menyelesaikan " +
                                        "kasus yang menyangkut permasalahan privat, " +
                                        "seperti perseorangan vs. perseorangan/kelompok"));

            });
        }
    };

//    private static RoomDatabase.Callback dbCallback=new RoomDatabase.Callback(){
//        IstilahHukumDao daos;
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDBAsyncTask(daos).execute();
//        }
//    };

//    private static class PopulateDBAsyncTask extends AsyncTask<Void,Void,Void>{
//        private IstilahHukumDao istilahDao;
//
//        public PopulateDBAsyncTask(IstilahHukumDao istilahDao) {
//            this.istilahDao = istilahDao;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            istilahDao.insertIstilah(new IstilahHukum("abolisi",
//                    "peniadaan pidana",
//                    "Abolisi adalah peniadaan/penghapusan peristiwa pidana. " +
//                            "Hak ini diberikan kepada narapidana yang sedang menjalani" +
//                            "persidangan dan belum ada keputusan dari sidang"));
//
//            istilahDao.insertIstilah(new IstilahHukum("abolisi",
//                    "peniadaan pidana",
//                    "Abolisi adalah peniadaan/penghapusan peristiwa pidana. " +
//                            "Hak ini diberikan kepada narapidana yang sedang menjalani" +
//                            "persidangan dan belum ada keputusan dari sidang"));
//
//            istilahDao.insertIstilah(new IstilahHukum("abolisi",
//                    "peniadaan pidana",
//                    "Abolisi adalah peniadaan/penghapusan peristiwa pidana. " +
//                            "Hak ini diberikan kepada narapidana yang sedang menjalani" +
//                            "persidangan dan belum ada keputusan dari sidang"));
//            return null;
//        }
//    }


}
