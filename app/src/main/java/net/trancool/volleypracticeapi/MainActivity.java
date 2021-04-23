package net.trancool.volleypracticeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {


    Button add,  update;
    EditText fName, lName, email_add;
    TextView tester;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //access the resources
        add = findViewById(R.id.btn_add);
        update = findViewById(R.id.btn_update);
        fName =findViewById(R.id.et_fname);
        lName =findViewById(R.id.et_lname);
        email_add = findViewById(R.id.et_email_add);
        tester = findViewById(R.id.tv_tester);


        add.setOnClickListener(addClickListener);
        update.setOnClickListener(updateClickListener);

        //RequestQueue queue = Vo
        //JsonObjectRequest jsonObjectRequest





       // Singleton.getInstance(this).addToRequestQueue(stringRequest);


        //addFullName(profile);

        //TODO: create a model class

        //TODO: create create a server class



    }
    /**
     *
     * ONCREATE ENDS HERE
     *
     * */





    //TODO  create clicklistener method

    private final View.OnClickListener addClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            UserModel profile = new UserModel(fName.getText().toString(), lName.getText().toString(), email_add.getText().toString());
            addFullName(profile);
           // Toast.makeText(MainActivity.this, "Add Button Clicked!", Toast.LENGTH_SHORT).show();
        }
    };


    private final View.OnClickListener updateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {

            // addFullName();
            //Toast.makeText(MainActivity.this, "Update Button Clicked!", Toast.LENGTH_SHORT).show();

            getUsers();
        }
    };

    //TODO  create a getFullName to access fName and lName


    //TODO:  create add
    //this method take UserModel and  send it to the server using Volley
   public void addFullName(UserModel user)
   {
       //UserModel userProfile = new UserModel(fName,lName);

       //TODO: check that any of the field are empty
       //TODO: post the data to the Json file


       Toast.makeText(this, "User profile: " + user.getfName().toString() + " " + user.getlName().toString() + " " +user.getEmail_add().toString()
               , Toast.LENGTH_SHORT).show();

       getUsers();





      // return userProfile;
   }


   public void getUsers()
   {
       String url = "http://localhost:3000/users";
       JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
           @Override
           public void onResponse(JSONArray response) {
               Toast.makeText(MainActivity.this, "The response is: " + response.toString(), Toast.LENGTH_SHORT).show();

               try {
                   JSONObject userInfo = response.getJSONObject(0);
                   String user = userInfo.getString("id");
                   tester.setText(user);

               } catch (JSONException e) {
                   e.printStackTrace();
               }
               //tester.setText("Response:" + response.toString());
           }
       },
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       Toast.makeText(MainActivity.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                       Log.e("Error", error.toString());

                   }
               }
       );

       Singleton.getInstance(MainActivity.this).addToRequestQueue(jsonArrayRequest);

   }








}