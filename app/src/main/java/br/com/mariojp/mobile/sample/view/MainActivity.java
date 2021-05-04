package br.com.mariojp.mobile.sample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.mobile.sample.R;
import br.com.mariojp.mobile.sample.model.Contato;
import br.com.mariojp.mobile.sample.repositorio.BancoDados;

public class MainActivity extends AppCompatActivity {

    private ContatoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_lista_nomes);
        CustomAdapter customAdapter = new CustomAdapter(new CustomAdapter.ContatoDiff());
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ContatoViewModel.class);

        viewModel.getContatos().observe(this, contatos -> {
            customAdapter.submitList(contatos);
        });

    }



//    public void adicionar(View v){
//        Contato c = new Contato();
//        c.setNome( "Nome X" );
//        viewModel.inserir(c);
//    }
}