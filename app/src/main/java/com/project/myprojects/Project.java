package com.project.myprojects;

/**
 * Model class representing a single project item.
 */
public class Project {

    String name;        // project title
    String description; // short project description
    int image;          // resource ID for project icon

    // Constructor to initialize a project object
    public Project(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
