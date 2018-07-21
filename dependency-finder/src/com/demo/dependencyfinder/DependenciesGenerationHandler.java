package com.demo.dependencyfinder;

import com.demo.dependencyfinder.service.IDependencyPathGenerator;
import com.demo.dependencyfinder.service.IDependencyStructure;


public class DependenciesGenerationHandler {

    private IDependencyStructure dependencyStructure;

    private IDependencyPathGenerator dependencyPathGenerator;

    public DependenciesGenerationHandler(IDependencyStructure dependencyStructure, IDependencyPathGenerator dependencyPathGenerator) {
        this.dependencyStructure = dependencyStructure;
        this.dependencyPathGenerator = dependencyPathGenerator;
    }

    public void print() {
        String dependencyPath = dependencyPathGenerator.handleDependency(dependencyStructure.generate());
        if (!dependencyPath.isEmpty()) {
            System.out.println("Output: " + dependencyPath);
        }
    }

}
