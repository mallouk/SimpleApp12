package mallouk.retrofit;

import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MatthewJallouk on 4/29/2019.
 */

public class MusicResourceImplRetrofit2 {
    private static final String URI = "http://10.0.0.17:5000";

    public List<ResponseBody> greetUser(String user) throws Exception{
        //Create retrofit, set the API base URL and GSonConverterFactory
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URI)
                .addConverterFactory(GsonConverterFactory.create()).build();
        //Create service
        MusicResourceService musicResourceService = retrofit.create(MusicResourceService.class);
        Call<List<ResponseBody>> resp_body = musicResourceService.greetUser(user);

        return resp_body.execute().body();
    }

    public List<ResponseBody> getVectors(JsonObject jsonObj) throws Exception{
        //Create retrofit, set the API base URL and GSonConverterFactory
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URI)
                .addConverterFactory(GsonConverterFactory.create()).build();
        //Create service
        MusicResourceService musicResourceService = retrofit.create(MusicResourceService.class);

        return musicResourceService.getVectors(jsonObj).execute().body();
    }
}
