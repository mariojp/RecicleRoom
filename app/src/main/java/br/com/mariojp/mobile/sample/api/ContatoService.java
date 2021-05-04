package br.com.mariojp.mobile.sample.api;



import java.util.List;

import br.com.mariojp.mobile.sample.model.Contato;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContatoService {

    //https://api.github.com/users/mariojp/followers
    @GET("users/{user}/followers")
    Call<List<Contato>> listContatos(@Path("user") String user);


    static ContatoService create() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ContatoService.class);
    }
}
