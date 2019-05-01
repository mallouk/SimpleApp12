package mallouk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;

import mallouk.retrofit.MusicResourceImplRetrofit2;
import mallouk.retrofit.MusicResourceService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.sql.DriverManager.println;

/**
 * Created by MatthewJallouk on 4/29/2019.
 */

public class MainActivity2 extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPOST = (Button) findViewById(R.id.btnPOST);
        Button btnGET = (Button) findViewById(R.id.btnGET);

        btnPOST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObject jsonObj = new JsonObject();
                jsonObj.addProperty("title", "rhythm");
                jsonObj.addProperty("singer", "meee");
                jsonObj.addProperty("text", "Jack and jill went up the hill to fetch a pail of water!");

                MusicResourceImplRetrofit2 m = new MusicResourceImplRetrofit2();
                try {
                    MusicResourceService what = m.getVectors(jsonObj);
                    what.getVectors(jsonObj).enqueue(new Callback<ResponseBody>(){

                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                String msg = null;
                                try {
                                    msg = response.body().string();
                                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                                    Log.d("pass-post", msg);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.d("error-post", "ERROR: " + t.getMessage());
                        }
                    });

                } catch (Exception e){
                    Log.d("tag-post", "tag " + e );
                }
            }
        });

        btnGET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicResourceImplRetrofit2 m = new MusicResourceImplRetrofit2();
                try {
                    MusicResourceService what = m.greetUser("{Matthew}");

                    what.greetUser("Matthew").enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                String msg = null;
                                try {
                                    msg = response.body().string();
                                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                                    Log.d("pass-get", msg);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "ERROR: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.d("error-get", "ERROR: " + t.getMessage());
                        }
                    });
                }catch(Exception e){
                    Log.d("tag-get", "tag " + e );
                }
            }
        });

    }
}
