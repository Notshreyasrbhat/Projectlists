package com.project.myprojects;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * MainActivity - Displays a list of sample projects using RecyclerView.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this); // enables fullscreen layout with system bar handling
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recycle_view_projects);

        // Predefined sample projects to populate the RecyclerView

        Project[] projects = {
                new Project("Getting Started App", "Basic App of hello world", R.drawable.getting_started),
                new Project("Motivation", "App displaying motivation quotes", R.drawable.quote),
                new Project("BMI Calculator", "App with buttons to calc BMI", R.drawable.calculator),
                new Project("Inches Converter", "Basic conversion app", R.drawable.tape),
                new Project("Namdaddy", "Restaurant menu app", R.drawable.hungry_developer),
        };

        ProjectsAdapter adapter = new ProjectsAdapter(projects);
        list.setAdapter(adapter); // attach adapter to RecyclerView

        // Adjusts padding for system UI insets (status/navigation bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycle_view_projects), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
