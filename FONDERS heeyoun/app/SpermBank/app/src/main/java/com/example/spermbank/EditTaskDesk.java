package com.example.spermbank;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditTaskDesk extends AppCompatActivity {

    EditText titleDoes, titleDoes1, titleDoes2, titleDoes3;
    Button btnSaveUpdate, btnDelete;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task_desk);


        titleDoes = findViewById(R.id.titledoes);
        titleDoes1 = findViewById(R.id.titledoes1);
        titleDoes2 = findViewById(R.id.titledoes2);
        titleDoes3 = findViewById(R.id.titledoes2);

        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        titleDoes.setText(getIntent().getStringExtra("titledoes"));
        titleDoes1.setText(getIntent().getStringExtra("titledoes1"));
        titleDoes2.setText(getIntent().getStringExtra("titledoes2"));
        titleDoes3.setText(getIntent().getStringExtra("titledoes3"));

        final String keykeyDoes = getIntent().getStringExtra("keydoes");

        reference = FirebaseDatabase.getInstance().getReference().child("StoreApp").
                child("Store" + keykeyDoes);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent a = new Intent(EditTaskDesk.this, ShowListActivity.class);
                            startActivity(a);
                        } else {
                            Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        //make an event for button
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        dataSnapshot.getRef().child("titledoes").setValue(titleDoes.getText().toString());
                        dataSnapshot.getRef().child("titledoes1").setValue(titleDoes1.getText().toString());
                        dataSnapshot.getRef().child("titledoes2").setValue(titleDoes2.getText().toString());
                        dataSnapshot.getRef().child("titledoes3").setValue(titleDoes3.getText().toString());
                        dataSnapshot.getRef().child("keydoes").setValue(keykeyDoes);

                        Intent a = new Intent(EditTaskDesk.this,ShowListActivity.class);
                        startActivity(a);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        // customize font
        //titlepage.setTypeface(MMedium);
        titleDoes.setTypeface(MMedium);

        //addtitle.setTypeface(MLight);
        titleDoes1.setTypeface(MMedium);

       // adddesc.setTypeface(MLight);
        titleDoes2.setTypeface(MMedium);

        //adddate.setTypeface(MLight);
        titleDoes3.setTypeface(MMedium);

        btnSaveUpdate.setTypeface(MMedium);
        btnDelete.setTypeface(MLight);

    }
}