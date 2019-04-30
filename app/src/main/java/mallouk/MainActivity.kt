package mallouk;

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import mallouk.R
import mallouk.retrofit.APIKindaStuff
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.graphics.PorterDuff
import android.R.attr.textColorPrimary
import android.graphics.drawable.Drawable



class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        /*btnPOST.setOnClickListener {
            val jsonObj = JsonObject()
            jsonObj.addProperty("title", "rhythm")
            jsonObj.addProperty("singer", "meee")
            jsonObj.addProperty("text", "Jack and jill went up the hill to fetch a pail of water!")
            //  POST demo
            APIKindaStuff
                    .service
                    .getVectors(jsonObj)
                    .enqueue(object : Callback<ResponseBody> {
                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            println("---TTTT :: POST Throwable EXCEPTION:: " + t.message)
                        }

                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                            if (response.isSuccessful) {
                                val msg = response.body()?.string()
                                println("---TTTT :: POST msg from server :: " + msg)
                                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
        }

        btnGET.setOnClickListener {
            APIKindaStuff
                    .service
                    .greetUser("Audhil")
                    .enqueue(object : Callback<ResponseBody> {
                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            println("---TTTT :: GET Throwable EXCEPTION:: " + t.message)
                        }

                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                            if (response.isSuccessful) {
                                val msg = response.body()?.string()
                                println("---TTTT :: GET msg from server :: " + msg)
                                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        getMenuInflater().inflate(R.menu.popup_menu_music, menu);

        for (i in 0 until menu!!.size()) {
            val drawable = menu!!.getItem(i).icon
            if (drawable != null) {
                drawable.mutate()
                drawable.setColorFilter(resources.getColor(R.color.accent_material_light), PorterDuff.Mode.SRC_ATOP)
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId;
        if (id == R.id.item1_id){
            Toast.makeText(applicationContext, "Item 1", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.item2_id){
            Toast.makeText(applicationContext, "Item 2", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.item3_id){
            Toast.makeText(applicationContext, "Item 3", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item)
    }
}