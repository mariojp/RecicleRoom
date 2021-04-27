package br.com.mariojp.mobile.sample.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.mariojp.mobile.sample.model.Contato;
import br.com.mariojp.mobile.sample.repositorio.Repositorio;

public class ContatoViewModel extends AndroidViewModel {

    private Repositorio repositorio;
    private LiveData<List<Contato>> contatos;


    public ContatoViewModel(@NonNull Application application) {
        super(application);
        repositorio = new Repositorio(application);
        contatos = repositorio.getAllContatos();
    }

    public LiveData<List<Contato>> getContatos() {
        return contatos;
    }

    public void inserir(Contato contato){
        repositorio.insert(contato);
    }


}
