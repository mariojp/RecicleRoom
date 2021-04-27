package br.com.mariojp.mobile.sample.repositorio;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.mariojp.mobile.sample.model.Contato;

@Dao
public interface ContatoDao {

    @Insert
    void insere(Contato... contato);

    @Query("SELECT * FROM CONTATO")
    LiveData<List<Contato>> obterTodos();

}
