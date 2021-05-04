package br.com.mariojp.mobile.sample.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Contato {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @SerializedName(value = "login")
    private String nome;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @ColumnInfo(name = "avatar_url")
    @SerializedName(value = "avatar_url")
    private String avatar;


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
