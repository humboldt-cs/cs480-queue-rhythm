package com.example.qr.Models;

import java.util.ArrayList;
import java.util.Objects;

public class Search {
    private String href;
    private ArrayList<Objects> items;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;

    public String getHref() {
        return href;
    }

    public ArrayList<Objects> getItems() {
        return items;
    }

    public int getLimit() {
        return limit;
    }

    public String getNext() {
        return next;
    }

    public int getOffset() {
        return offset;
    }

    public String getPrevious() {
        return previous;
    }

    public int getTotal() {
        return total;
    }
}
