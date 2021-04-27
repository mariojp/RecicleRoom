package br.com.mariojp.mobile.sample.repositorio;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.mariojp.mobile.sample.model.Contato;

@Database(entities = {Contato.class},version = 1,exportSchema = false)
public abstract class BancoDados extends RoomDatabase {


    public abstract ContatoDao getContatoDao();

    public static BancoDados bancoDados = null;

    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(4);

    public static BancoDados getInstance(Context context){
        if(bancoDados == null){
            synchronized (BancoDados.class) {
                if(bancoDados == null) {
                    bancoDados = Room.databaseBuilder(context, BancoDados.class, "banco")
                            //.allowMainThreadQueries()
                            .build();
                }
            }
        }
        return bancoDados;
    }

}
