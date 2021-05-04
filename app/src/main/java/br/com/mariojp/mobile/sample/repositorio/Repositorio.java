package br.com.mariojp.mobile.sample.repositorio;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.mariojp.mobile.sample.api.ContatoService;
import br.com.mariojp.mobile.sample.model.Contato;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositorio {

    private ContatoDao dao;
    private ContatoService api;
    private LiveData<List<Contato>> contatos;

    public Repositorio(Context context) {
        BancoDados bd = BancoDados.getInstance(context);
        dao = bd.getContatoDao();
        contatos = dao.obterTodos();
        api = ContatoService.create();
        Call<List<Contato>> listCall = api.listContatos("mariojp");
        listCall.enqueue(new Callback<List<Contato>>() {
            @Override
            public void onResponse(Call<List<Contato>> call, Response<List<Contato>> response) {
//                response.body().forEach(contato -> {
//                    dao.insere(contato);
//                });
                List<Contato> contatos = response.body();
                BancoDados.dbWriteExecutor.execute(() -> {
                    dao.insere(contatos.toArray(new Contato[contatos.size()]));
                });
            }

            @Override
            public void onFailure(Call<List<Contato>> call, Throwable t) {
                Log.e("Falhou ", "Erro ao usar a api do github");
            }
        });
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
