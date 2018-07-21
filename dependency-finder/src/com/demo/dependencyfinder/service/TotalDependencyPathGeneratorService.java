package com.demo.dependencyfinder.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.demo.dependencyfinder.model.DependentNode;
import com.demo.dependencyfinder.model.Node;

public class TotalDependencyPathGeneratorService implements IDependencyPathGenerator {

    public String handleDependency(DependencyHolder dependencyHolder) {

        Map<String, Set<String>> dependencyDataHolderMap = new HashMap<>();

        for (Node rootNode : dependencyHolder.getDependencyList()) {
            Set<String> dependencySet = new TreeSet<>();
            dependencyDataHolderMap.put(rootNode.getRootNode(), dependencySet);
            findDependency(rootNode, dependencyHolder, dependencySet);
        }

        String dependencies = prepareDependencyPath(dependencyDataHolderMap);

        System.out.println("Calculated full set of dependencies done.");

        return dependencies;
    }

    private static void findDependency(Node rootNode, DependencyHolder dependencyHolder, Set<String> dependencySet) {

        for (DependentNode dependentNodes : rootNode.getDependentNodes()) {
            findDependency(dependentNodes, dependencyHolder, dependencySet);
        }
    }

    private static void findDependency(DependentNode dependentNodes, DependencyHolder dependencyHolder, Set<String> dependencySet) {

        Optional<Node> dependentNode = dependencyHolder.findByRootDependency(dependentNodes.getName());
        if (dependentNode.isPresent()) {
            dependencySet.add(dependentNode.get().getRootNode());
            findDependency(dependentNode.get(), dependencyHolder, dependencySet);
        } else {
            dependencySet.add(dependentNodes.getName());
        }
    }

    private String prepareDependencyPath(Map<String, Set<String>> dependencyDataHolderMap) {
        StringBuilder dependencies = new StringBuilder();

        for (Map.Entry<String, Set<String>> nodeDependencies : dependencyDataHolderMap.entrySet()) {
            dependencies.append(nodeDependencies.getKey()).append(" ").append(nodeDependencies.getValue().stream().collect(Collectors.joining(" ")));
            dependencies.append(" ");
        }

        return dependencies.toString().trim();
    }

}
