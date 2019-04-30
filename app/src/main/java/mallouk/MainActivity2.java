package mallouk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.JsonObject;

import mallouk.retrofit.MusicResourceImplRetrofit2;
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

        btnPOST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObject jsonObj = new JsonObject();
                jsonObj.addProperty("title", "rhythm");
                jsonObj.addProperty("singer", "meee");
                jsonObj.addProperty("text", "Jack and jill went up the hill to fetch a pail of water!");

                MusicResourceImplRetrofit2 m = new MusicResourceImplRetrofit2();
                m.getVectors(jsonObj)


            }
        });
    }
}
