package com.eample.projectmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eample.projectmate.model.UsersModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {


    private EditText name_edittext;
    private EditText uni_edittext;
    private Button save_button;

    private String id;
    private String name;
    private String uni;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name_edittext = findViewById(R.id.name_edittext);
        uni_edittext = findViewById(R.id.uni_edittext);
        save_button = findViewById(R.id.save_button);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = mUser.getUid();
                name = name_edittext.getText().toString();
                uni = uni_edittext.getText().toString();

                UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                mUser.updateProfile(userProfileChangeRequest);

                UsersModel userModel = new UsersModel(id, name, uni);
                databaseReference.child(id).setValue(userModel);

                Intent intent = new Intent(getApplicationContext(),InterestsActivity.class);
                intent.putExtra("Name",name);
                intent.putExtra("Uni",uni);
                startActivity(intent);
                finish();


            }
        });



    }

    @Override
    public void onBackPressed() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(mUser.getUid())){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onBackPressed();
    }
}