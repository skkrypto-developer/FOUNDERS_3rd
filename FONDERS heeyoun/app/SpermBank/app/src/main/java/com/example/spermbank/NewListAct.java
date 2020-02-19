package com.example.spermbank;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewListAct extends AppCompatActivity {

    TextView titlepage, adddoes, adddoes1, adddoes2, adddoes3;
    EditText titledoes, titledoes1, titledoes2, titledoes3;
    Button btnSaveTask, btnCancel, btnBack;
    DatabaseReference reference;
    Integer doesNum = new Random().nextInt();
    String keydoes = Integer.toString(doesNum);
    Button btn_enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titlepage = findViewById(R.id.titlepage);

        adddoes = findViewById(R.id.adddoes);
        adddoes1 = findViewById(R.id.adddoes1);
        adddoes2 = findViewById(R.id.adddoes2);
        adddoes3 = findViewById(R.id.adddoes3);

        titledoes = findViewById(R.id.titledoes);
        titledoes1 = findViewById(R.id.titledoes1);
        titledoes2 = findViewById(R.id.titledoes2);
        titledoes3 = findViewById(R.id.titledoes3);

        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnCancel = findViewById(R.id.btnCancel);

        btnBack = findViewById(R.id.btnBack);
        btn_enter = findViewById(R.id.btnEnter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NewListAct.this, ShowListActivity.class);
                startActivity(a);
            }
        });
        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // insert data to database
                reference = FirebaseDatabase.getInstance().getReference().child("ListApp").
                        child("List" + doesNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        dataSnapshot.getRef().child("titledoes").setValue(titledoes.getText().toString());
                        dataSnapshot.getRef().child("titledoes1").setValue(titledoes1.getText().toString());
                        dataSnapshot.getRef().child("titledoes2").setValue(titledoes2.getText().toString());
                        dataSnapshot.getRef().child("titledoes3").setValue(titledoes3.getText().toString());
                        dataSnapshot.getRef().child("keydoes").setValue(keydoes);

                        Intent a = new Intent(NewListAct.this,ShowListActivity.class);
                        startActivity(a);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("Firebase", "Firebase : error" );
                    }
                });
            }
        });

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        // customize font
        titlepage.setTypeface(MMedium);

        adddoes.setTypeface(MLight);
        titledoes.setTypeface(MMedium);

        adddoes1.setTypeface(MLight);
        titledoes1.setTypeface(MMedium);

        adddoes2.setTypeface(MLight);
        titledoes2.setTypeface(MMedium);

        adddoes3.setTypeface(MLight);
        titledoes3.setTypeface(MMedium);


        btnSaveTask.setTypeface(MMedium);
        btnCancel.setTypeface(MLight);
        btnBack.setTypeface(MLight);
    }
}