package com.project.myprojects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView Adapter for displaying a list of Project items.
 */
public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private Project[] projects; // dataset for the RecyclerView

    public ProjectsAdapter(Project[] projects) {
        this.projects = projects;
    }

    @Override
    public int getItemCount() {
        return projects.length; // number of items in the list
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout for a single project item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        // Bind project data to the current ViewHolder
        holder.bind(projects[position]);
    }

    /**
     * ViewHolder class that holds references to UI components for a single project item.
     */
    static class ProjectViewHolder extends RecyclerView.ViewHolder {

        private ImageView appImage;
        private TextView appTitle;
        private TextView appDescription;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views for each item
            appImage = itemView.findViewById(R.id.image_view_project_icon);
            appTitle = itemView.findViewById(R.id.text_view_project_title);
            appDescription = itemView.findViewById(R.id.text_view_project_description);
        }

        // Bind a Project object's data to the views
        public void bind(Project project) {
            appTitle.setText(project.name);
            appDescription.setText(project.description);
            appImage.setImageResource(project.image);
        }
    }
}
