package com.eample.projectmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.eample.projectmate.model.ProjectsModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RequirementActivity extends AppCompatActivity {

    private String projectId;
    private String ownerId;
    private String ownerName;
    private String projectName;
    private String projectDesc;
    private String projectLink;
    private List<String> requirements;

    private Button create_button;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReferenceUser;
    private DatabaseReference databaseReferenceSortedProject;
    private DatabaseReference databaseReferenceProject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement);

        Intent getintent = getIntent();
        projectName = getintent.getStringExtra("projectName");
        projectDesc = getintent.getStringExtra("projectDesc");
        projectLink = getintent.getStringExtra("projectLink");

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        ownerId = mUser.getUid();
        ownerName = mUser.getDisplayName();

        Date date = new Date();
        long time = date.getTime();
        String timestamp = String.valueOf(time);
        projectId = timestamp + UUID.randomUUID().toString();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReferenceUser = firebaseDatabase.getReference("Users");
        databaseReferenceSortedProject = firebaseDatabase.getReference("Sorted_Projects");
        databaseReferenceProject = firebaseDatabase.getReference("Projects");

        create_button = findViewById(R.id.create_button);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getRequirements();
                ProjectsModel projectModel = new ProjectsModel(projectId,ownerId,ownerName,projectName,projectDesc,projectLink,requirements);
                for (String requirement : requirements) {
                    databaseReferenceSortedProject.child(requirement).child(projectId).setValue(projectModel);
                }
                databaseReferenceProject.child(projectId).setValue(projectModel);
                databaseReferenceUser.child("My_Projects").child(projectId).setValue(projectModel);

            }
        });

    }


    public void getRequirements(){
        CheckBox cb1 = findViewById(R.id.fwebCB);
        CheckBox cb2 = findViewById(R.id.bwebCB);
        CheckBox cb3 = findViewById(R.id.webCB);
        CheckBox cb4 = findViewById(R.id.jappCB);
        CheckBox cb5 = findViewById(R.id.kappCB);
        CheckBox cb6 = findViewById(R.id.fappCB);

        if (cb1.isChecked()){
            requirements.add(cb1.getText().toString());
        }
        if (cb2.isChecked()){
            requirements.add(cb2.getText().toString());
        }
        if (cb3.isChecked()){
            requirements.add(cb3.getText().toString());
        }
        if (cb4.isChecked()){
            requirements.add(cb4.getText().toString());
        }
        if (cb5.isChecked()){
            requirements.add(cb5.getText().toString());
        }
        if (cb6.isChecked()){
            requirements.add(cb6.getText().toString());
        }

    }




}