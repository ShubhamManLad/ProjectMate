package com.eample.projectmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.eample.projectmate.model.UsersModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InterestsActivity extends AppCompatActivity {

    private Button saveInterest_button;

    private String id;
    private String name;
    private String uni;
    private List <String> interests;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        id = mUser.getUid();

        Intent getintent = getIntent();

        saveInterest_button = findViewById(R.id.saveInterest_button);

        saveInterest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interests = new ArrayList<>();
                getInterests();

                name = getintent.getStringExtra("Name");
                uni = getintent.getStringExtra("Uni");

                UsersModel userModel = new UsersModel(id,name,uni);
                userModel.setInterests(interests);

                databaseReference.child(id).child("Interests").setValue(interests);

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public void getInterests(){
        CheckBox rb1 = findViewById(R.id.fwebRB);
        CheckBox rb2 = findViewById(R.id.bwebRB);
        CheckBox rb3 = findViewById(R.id.webRB);
        CheckBox rb4 = findViewById(R.id.jappRB);
        CheckBox rb5 = findViewById(R.id.kappRB);
        CheckBox rb6 = findViewById(R.id.fappRB);

        if (rb1.isChecked()){
            interests.add(rb1.getText().toString());
        }
        if (rb2.isChecked()){
            interests.add(rb2.getText().toString());
        }
        if (rb3.isChecked()){
            interests.add(rb3.getText().toString());
        }
        if (rb4.isChecked()){
            interests.add(rb4.getText().toString());
        }
        if (rb5.isChecked()){
            interests.add(rb5.getText().toString());
        }
        if (rb6.isChecked()){
            interests.add(rb6.getText().toString());
        }

    }
}