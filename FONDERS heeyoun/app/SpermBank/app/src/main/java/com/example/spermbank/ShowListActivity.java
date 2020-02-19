package com.example.spermbank;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;
    //Button btnAddNew;
    Button btnEnter;
    Button btnAddNew, btnFirst ;
    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<SpermData> spermData;
    LineAdapter lineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_main);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        btnAddNew = findViewById(R.id.btnAddNew);

        btnFirst = findViewById(R.id.btnFirst);
//        btnAddNew = findViewById(R.id.btnAddNew);
        btnEnter = findViewById(R.id.btnEnter);

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        btnAddNew.setTypeface(MLight);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ShowListActivity.this,NewListAct.class);
                startActivity(a);
            }
        });
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ShowListActivity.this,MainActivity.class);
                startActivity(a);
            }
        });

        // customize font
        titlepage.setTypeface(MMedium);
        subtitlepage.setTypeface(MLight);
        endpage.setTypeface(MLight);

//        btnAddNew.setTypeface(MLight);
//
//        btnAddNew.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent a = new Intent(StartLineActivity.this, NewStoreAct.class);
//                startActivity(a);
//            }
//        });


        // working with data
        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        spermData = new ArrayList<SpermData>();

        // get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("StoreApp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // set code to retrive data and replace layout
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    SpermData p = dataSnapshot1.getValue(SpermData.class);
                    spermData.add(p);
                }
                lineAdapter = new LineAdapter(ShowListActivity.this, spermData);
                ourdoes.setAdapter(lineAdapter);
                lineAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // set code to show an error
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}