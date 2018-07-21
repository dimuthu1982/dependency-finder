package com.demo.dependencyfinder.service;

import java.util.function.Predicate;

public class DependencyStructureGeneratorService implements IDependencyStructure {

    private String[] dependencyArray;

    public DependencyStructureGeneratorService(String inputDependencies) {

        if (inputDependencies == null || inputDependencies.trim().isEmpty()) {
            System.out.println("Invalid input. Unable to proceed.");
            dependencyArray = new String[0];

        } else {
            System.out.println("Items to be processed: " + inputDependencies);
            dependencyArray = inputDependencies.split(" ");
        }

    }

    public DependencyHolder generate() {
        DependencyHolder dependencyHolder = new DependencyHolder();

        if (dependencyArray.length == 0) {
            return dependencyHolder;
        }

        Predicate<String> rootDependencyFinder = node -> dependencyHolder.findByRootDependency(node).isPresent();

        String mainNode = dependencyArray[0];
        String edgeNode = mainNode;

        dependencyHolder.add(mainNode);

        for (int i = 1; i < dependencyArray.length; i++) {
            if (isMainNodeListed(edgeNode, dependencyArray[i], rootDependencyFinder)) {
                dependencyHolder.add(mainNode, dependencyArray[i]);
                edgeNode = dependencyArray[i];
            } else {
                mainNode = dependencyArray[i];
                dependencyHolder.add(mainNode);
                edgeNode = mainNode;
            }
        }
        return dependencyHolder;
    }

    private boolean isMainNodeListed(String edgeNode, String pivotNode, Predicate<String> rootDependencyFinder) {
        return edgeNode.charAt(0) < pivotNode.charAt(0) || rootDependencyFinder.test(pivotNode);
    }

}
