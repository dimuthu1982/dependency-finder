package com.demo.dependencyfinder.model;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String rootNode;
    private List<DependentNode> dependentNodes = new ArrayList<>();

    public Node(String rootNode) {
        this.rootNode = rootNode;
    }

    public void addDependent(String dependentNode) {
        dependentNodes.add(new DependentNode(dependentNode));
    }

    public String getRootNode() {
        return rootNode;
    }

    public List<DependentNode> getDependentNodes() {
        return dependentNodes;
    }

    @Override
    public String toString() {
        return "Main Module: " + rootNode + " " + dependentNodes.toString();
    }
}
