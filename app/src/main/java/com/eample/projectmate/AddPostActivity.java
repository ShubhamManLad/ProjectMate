package com.eample.projectmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class AddPostActivity extends AppCompatActivity {

    private String projectName;
    private String projectDesc;
    private String projectLink;

    private EditText projectName_editText;
    private EditText projectDesc_editText;
    private EditText projectLink_editText;
    private Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        projectName_editText = findViewById(R.id.projectName_edittext);
        projectDesc_editText = findViewById(R.id.projectDesc_edittext);
        projectLink_editText = findViewById(R.id.projectLink_edittext);

        next_button = findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                projectName = projectName_editText.getText().toString();
                projectDesc = projectDesc_editText.getText().toString();
                projectLink = projectLink_editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(),RequirementActivity.class);
                intent.putExtra("projectName",projectName);
                intent.putExtra("projectDesc",projectDesc);
                intent.putExtra("projectLink",projectLink);

                startActivity(intent);

            }
        });



    }
}