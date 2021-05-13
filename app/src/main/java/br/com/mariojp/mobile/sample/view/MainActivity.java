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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



//    public void adicionar(View v){
//        Contato c = new Contato();
//        c.setNome( "Nome X" );
//        viewModel.inserir(c);
//    }
}