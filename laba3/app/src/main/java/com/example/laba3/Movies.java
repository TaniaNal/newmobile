package com.example.laba3;

public class Movies {

    private final String title;
    private final String year;
    private final String description;
    private final String poster;

    public Movies(final String title, final String year, final String description,
                  final String poster) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getPoster() {
        return poster;
    }
}