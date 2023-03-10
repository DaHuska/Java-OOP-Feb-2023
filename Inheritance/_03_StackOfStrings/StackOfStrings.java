package com.company.Inheritance._03_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data = new ArrayList<>();

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        return this.data.remove(this.getSize() - 1);
    }

    public String peek() {
        return this.data.get(this.getSize() - 1);
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    private int getSize() {
        return this.data.size();
    }
}
