package dev.mayankg.lambdas.unit1Excercise1;

import dev.mayankg.lambdas.common.Footballers;

@FunctionalInterface
public interface Condition {
    boolean test(Footballers player);
}