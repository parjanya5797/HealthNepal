package com.example.healthnepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<ExampleItem> mExampleList;
//    private TextView textViewResult;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Toast.makeText(DashboardActivity.this, "Welcome to Dashboard", Toast.LENGTH_LONG).show();
//        RetrofitClass retrofitClass = RetrofitClass.getInstance();
//        textViewResult = findViewById(R.id.text_view_result);
        FloatingActionButton logout = findViewById(R.id.logout_button);
//
//        Call<List<Post>> call = retrofitClass.getJsonApi().getPosts();
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<Post>> call, Response<List<Post>> response) {
//
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code:" + response.code());
//                    return;
//                }
//
//                List<Post> posts = response.body();
//
//                for (Post post : posts) {
//                    String content = "";
//                    content += "ID: " + post.getId() + "\n";
//                    content += "User ID: " + post.getUserId() + "\n";
//                    content += "Title: " + post.getTitle() + "\n";
//                    content += "Text: " + post.getBody() + "\n";
//
//                    textViewResult.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//            }
//        });
//
        logout.setOnClickListener(this);

        createExampleList();
        buildRecyclerView();
        buttonInsert =findViewById(R.id.button_insert);
        buttonRemove =findViewById(R.id.button_remove);
        editTextInsert =findViewById(R.id.editText_insert);
        editTextRemove = findViewById(R.id.editText_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });



    }

    @Override
    public void onClick(View v) {
        SplashActivity.sharedPreferences.edit().clear().apply();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    public void insertItem(int position)
    {
    mExampleList.add(position, new ExampleItem(R.drawable.ic_three_dots,"Item at Position" + position,"This is Line 2"));
    mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position)
    {
    mExampleList.remove(position);
    mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position,String text)
    {
    mExampleList.get(position).changeText1(text);
    mAdapter.notifyItemChanged(position);
    }


    public void createExampleList()
    {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android_phone,"Line1","Line2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_three_dots,"Line3","Line4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_room_service,"Line5","Line6"));
//        exampleList.add(new ExampleItem(R.drawable.ic_android_phone,"Line7","Line8"));
//        exampleList.add(new ExampleItem(R.drawable.ic_three_dots,"Line9","Line10"));
//        exampleList.add(new ExampleItem(R.drawable.ic_room_service,"Line11","Line12"));
//        exampleList.add(new ExampleItem(R.drawable.ic_android_phone,"Line13","Line14"));
//        exampleList.add(new ExampleItem(R.drawable.ic_three_dots,"Line15","Line16"));
//        exampleList.add(new ExampleItem(R.drawable.ic_room_service,"Line17","Line18"));
//        exampleList.add(new ExampleItem(R.drawable.ic_android_phone,"Line19","Line20"));
//        exampleList.add(new ExampleItem(R.drawable.ic_three_dots,"Line21","Line22"));
//        exampleList.add(new ExampleItem(R.drawable.ic_room_service,"Line23","Line24"));
//        exampleList.add(new ExampleItem(R.drawable.ic_android_phone,"Line25","Line26"));
//        exampleList.add(new ExampleItem(R.drawable.ic_three_dots,"Line27","Line28"));
//        exampleList.add(new ExampleItem(R.drawable.ic_room_service,"Line29","Line30"));
    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position,"Clicked");
            }
        });
    }

}