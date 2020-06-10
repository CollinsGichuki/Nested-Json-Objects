package com.snilloc.nestedjsonobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.snilloc.nestedjsonobjects.POJOS.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView fTextView;

    JsonPlaceHolderAPI placeHolderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fTextView = findViewById(R.id.tv1);

        //Building a Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())//Use Gson
                .build();

        //Use the retrofit instance to create the method body of JsonPlaceHolderApi Interface
        placeHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);

        getUser();
    }

    public void getUser(){
        //Execute the Network request
        Call<Users> call = placeHolderAPI.getUsers();
        //Do in the background
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (!response.isSuccessful()){
                    fTextView.setText("Code: " + response.code());
                    return;
                }
                if (response.body().getName() != null){
                    //Get the values
                    String userContent = "";
                    userContent += "ID: " + response.body().getId() + "\n";
                    userContent += "Name: " + response.body().getName() + "\n";
                    userContent += "UserName: " + response.body().getUserName() + "\n";
                    userContent += "Email: " + response.body().getEmail() + "\n";
                    userContent += "Street: " + response.body().getAddress().getStreet() + "\n";
                    userContent += "Suite: " + response.body().getAddress().getSuite() + "\n";
                    userContent += "City: " + response.body().getAddress().getCity() + "\n";
                    userContent += "ZipCode: " + response.body().getAddress().getZipCode() + "\n";
                    userContent += "Latitude: " + response.body().getAddress().getGeo().getLatitude() + "\n";
                    userContent += "Longitude: " + response.body().getAddress().getGeo().getLongitude() + "\n";
                    userContent += "Phone: " + response.body().getPhone() + "\n";
                    userContent += "website: " + response.body().getWebsite() + "\n";
                    userContent += "Company Name: " + response.body().getCompany().getName() + "\n";
                    userContent += "CS: " + response.body().getCompany().getCatchPhrase() + "\n";
                    userContent += "Company BS: " + response.body().getCompany().getBs() + "\n";

                    fTextView.setText(userContent);
                }

            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                fTextView.setText("Failure: " + t);
            }
        });
    }
}