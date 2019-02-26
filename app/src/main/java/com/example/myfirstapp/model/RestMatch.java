package com.example.myfirstapp.model;

import java.util.List;

public class RestMatch {

    private Integer count;
    private String next;
    private String previous;
    private List<FootMatch> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<FootMatch> getResults() {
        return results;
    }

    public void setResults(List<FootMatch> results) {
        this.results = results;
    }

}
