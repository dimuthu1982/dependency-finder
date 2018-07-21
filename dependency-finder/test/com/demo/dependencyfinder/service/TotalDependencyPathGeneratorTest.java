package com.demo.dependencyfinder.service;

import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

public class TotalDependencyPathGeneratorTest {

	@Test
	public void shouldGetValidPathWhenDependencyProvided() {

		String inputDependencies = "A B C B C E C G D A F E F F H";
		DependencyStructureGeneratorService dependencyStructureGenerator = new DependencyStructureGeneratorService(inputDependencies);

		TotalDependencyPathGeneratorService dependencyPathGenerator = new TotalDependencyPathGeneratorService();
		String actualDependencyPath = dependencyPathGenerator.handleDependency(dependencyStructureGenerator.generate());

		Assert.assertThat("A B C E F G H B C E F G H C G D A B C E F G H E F H F H", is(actualDependencyPath));
	}

}
