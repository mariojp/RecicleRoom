package br.com.mariojp.mobile.sample.repositorio;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.mariojp.mobile.sample.model.Contato;

@Database(entities = {Contato.class},version = 1,exportSchema = false)
public abstract class BancoDados extends RoomDatabase {

    public static BancoDados bancoDados = null;

    public abstract ContatoDao getContatoDao();


    public static BancoDados getInstance(Context context){
        if(bancoDados == null){
            bancoDados =  Room.databaseBuilder(context,BancoDados.class, "banco")
                    .allowMainThreadQueries()
                    .build();
        }
        return bancoDados;
    }

}
