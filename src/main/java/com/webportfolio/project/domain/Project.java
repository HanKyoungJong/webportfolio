package com.webportfolio.project.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String title;
    @Column(nullable = false) private String company;
    @Lob @Column(nullable = false) private String contents;
    @Lob @Column(nullable = false) private String techStacks;
    @Lob @Column(nullable = false) private String learnings;

    protected Project() {}

    public Project(String title, String company, String contents, String techStacks, String learnings) {
        this.title = title;
        this.company = company;
        this.contents = contents;
        this.techStacks = techStacks;
        this.learnings = learnings;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public String getContents() { return contents; }
    public String getTechStacks() { return techStacks; }
    public String getLearnings() { return learnings; }
}
