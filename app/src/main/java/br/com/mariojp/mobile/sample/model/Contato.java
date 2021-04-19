package br.com.mariojp.mobile.sample.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contato {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
