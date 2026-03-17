package com.webportfolio.career.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "careers")
public class Career {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String company;
    @Column(nullable = false) private String position;
    @Column(nullable = false) private String period;
    @Column(nullable = false, length = 1000) private String summary;

    protected Career() {}

    public Career(String company, String position, String period, String summary) {
        this.company = company;
        this.position = position;
        this.period = period;
        this.summary = summary;
    }

    public Long getId() { return id; }
    public String getCompany() { return company; }
    public String getPosition() { return position; }
    public String getPeriod() { return period; }
    public String getSummary() { return summary; }
}
