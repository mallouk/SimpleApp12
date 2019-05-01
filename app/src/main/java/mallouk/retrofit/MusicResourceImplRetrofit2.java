package mallouk.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    public MusicResourceService greetUser(String user) throws Exception{
        Gson gson = new GsonBuilder().setLenient().create();

        //Create retrofit, set the API base URL and GSonConverterFactory
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URI)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        //Create service
        MusicResourceService musicResourceService = retrofit.create(MusicResourceService.class);
        Call<ResponseBody> resp_body = musicResourceService.greetUser(user);

        return musicResourceService;
    }

    public MusicResourceService getVectors(JsonObject jsonObj) throws Exception{
        Gson gson = new GsonBuilder().setLenient().create();

        //Create retrofit, set the API base URL and GSonConverterFactory
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URI)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        //Create service
        MusicResourceService musicResourceService = retrofit.create(MusicResourceService.class);

        return musicResourceService;
    }
}
