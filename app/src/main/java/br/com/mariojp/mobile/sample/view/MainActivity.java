package br.com.mariojp.mobile.sample.view;

import androidx.appcompat.app.AppCompatActivity;
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

    List<Contato> dados = new ArrayList<>();
    CustomAdapter customAdapter;
    static BancoDados bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd = BancoDados.getInstance(this);
        dados = bd.getContatoDao().obterTodos();
        if (dados.size() == 0) {
            geraContatos();
            dados = bd.getContatoDao().obterTodos();
        }
        RecyclerView recyclerView = findViewById(R.id.main_lista_nomes);
         customAdapter = new CustomAdapter(dados);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }


    private void geraContatos(){
        for(int i = 0 ; i < 20; i++){
            Contato c = new Contato();
            c.setNome( "Nome "+ i );
            dados.add(c);
        }
        bd.getContatoDao().insere(dados.toArray(new Contato[dados.size()]));
    }


    public void adicionar(View v){
        Contato c = new Contato();
        c.setNome( "Nome X" );
        bd.getContatoDao().insere(c);
        dados.add(c);
        customAdapter.notifyDataSetChanged();
    }
}