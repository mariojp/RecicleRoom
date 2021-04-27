package br.com.mariojp.mobile.sample.repositorio;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.mariojp.mobile.sample.model.Contato;

public class Repositorio {

    private ContatoDao dao;
    //private ContatoApi api;
    private LiveData<List<Contato>> contatos;

    public Repositorio(Context context) {
        BancoDados bd = BancoDados.getInstance(context);
        dao = bd.getContatoDao();
        contatos = dao.obterTodos();
    }

    public LiveData<List<Contato>> getAllContatos(){
        return contatos;
    }

    public void insert(Contato contato){
        BancoDados.dbWriteExecutor.execute(() -> {
                    dao.insere(contato);
        });
//        BancoDados.dbWriteExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                dao.insere(contato);
//            }
//        });
    }

}
