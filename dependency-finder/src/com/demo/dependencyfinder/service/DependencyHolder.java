package com.demo.dependencyfinder.service;

import com.demo.dependencyfinder.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DependencyHolder {

    private List<Node> dependencyList = new ArrayList<>();

    public void add(String rootNode) {
        dependencyList.add(new Node(rootNode));
    }

    public void add(String rootNode, String dependentNode) {

        Optional<Node> nodeOpt = findByRootDependency(rootNode);
        nodeOpt.ifPresent(node -> node.addDependent(dependentNode));
    }

    public List<Node> getDependencyList() {
        return dependencyList;
    }

    public Optional<Node> findByRootDependency(String nodeName) {
        return dependencyList
                .stream()
                .filter(node -> nodeName.equals(node.getRootNode()))
                .findFirst();
    }
}
