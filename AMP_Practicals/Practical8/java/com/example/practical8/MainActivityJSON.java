package com.example.practical8;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

// 8b: JSON Network Demo using Volley
// Add to build.gradle.kts dependencies:
//   implementation("com.android.volley:volley:1.2.1")
public class MainActivityJSON extends AppCompatActivity {
    Button btnFetch;
    ListView lvData;
    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_json);

        btnFetch = findViewById(R.id.btnFetch);
        lvData   = findViewById(R.id.lvData);
        dataList = new ArrayList<>();
        adapter  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        lvData.setAdapter(adapter);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { fetchJSONData(); }
        });
    }

    private void fetchJSONData() {
        String url = "https://jsonplaceholder.typicode.com/users";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    dataList.clear();
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject obj  = response.getJSONObject(i);
                            String name  = obj.getString("name");
                            String email = obj.getString("email");
                            String city  = obj.getJSONObject("address").getString("city");
                            dataList.add(name + " - " + email + " - " + city);
                        }
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivityJSON.this, "Parsing error", Toast.LENGTH_SHORT).show();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivityJSON.this, "Network error", Toast.LENGTH_SHORT).show();
                }
            });
        requestQueue.add(request);
    }
}
