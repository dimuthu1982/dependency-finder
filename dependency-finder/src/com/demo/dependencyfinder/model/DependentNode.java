package com.demo.dependencyfinder.model;

public class DependentNode {

    private String name;

    public DependentNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
