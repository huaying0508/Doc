package com.soft.entity;

public class FindData {

    private String start;
    private String end;
    private String username;

    public FindData(String start, String end, String username) {
        this.start = start;
        this.end = end;
        this.username = username;
    }

    public FindData() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
