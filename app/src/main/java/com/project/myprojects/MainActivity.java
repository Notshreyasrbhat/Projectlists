package com.project.myprojects;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView list = findViewById(R.id.recycle_view_projects);
        Project[] projects = {
                new Project("Getting Started App", "Basic App of hello world", R.drawable.getting_started),
                new Project("Motivation", "App displaying motivation quotes", R.drawable.quote),
                new Project("BMI Calculator", "App with  buttons to calc BMI", R.drawable.calculator),
                new Project("Inches Convertor", "Basic convertion app", R.drawable.tape),
                new Project("Namdaddy", "Restaurant menu app", R.drawable.hungry_developer),
        };
        ProjectsAdapter adapter =new ProjectsAdapter(projects);
        list.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycle_view_projects), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}