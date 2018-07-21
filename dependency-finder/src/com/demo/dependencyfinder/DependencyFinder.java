package com.demo.dependencyfinder;

import com.demo.dependencyfinder.service.DependencyStructureGeneratorService;
import com.demo.dependencyfinder.service.TotalDependencyPathGeneratorService;

public class DependencyFinder {

    public static void main(String[] args) {

        System.out.println(">>>>> The Exercise prints transitive dependencies for a group of items <<<<<");

        String inputDependencies = "A B C B C E C G D A F E F F H";

        DependencyStructureGeneratorService dependencyStructureGeneratorService = new DependencyStructureGeneratorService(inputDependencies);

        TotalDependencyPathGeneratorService dependencyPathGeneratorService = new TotalDependencyPathGeneratorService();

        DependenciesGenerationHandler handler = new DependenciesGenerationHandler(dependencyStructureGeneratorService, dependencyPathGeneratorService);

        handler.print();
    }

}
