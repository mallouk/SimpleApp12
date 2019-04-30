package mallouk.retrofit;

import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by MatthewJallouk on 4/29/2019.
 */

public interface MusicResourceService {
    @Headers({"Accept: application/json"})
    @GET("/users/{user}")
    Call<List<ResponseBody>> greetUser(@Path("user") String user) throws Exception;

    @Headers("Content-type: application/json")
    @POST("/api/post_some_data")
    Call<List<ResponseBody>> getVectors(@Body JsonObject jsonObj);

}
