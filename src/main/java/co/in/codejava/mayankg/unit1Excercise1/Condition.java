package co.in.codejava.mayankg.unit1Excercise1;

import co.in.codejava.mayankg.common.Footballers;

@FunctionalInterface
public interface Condition {
    boolean test(Footballers player);
}
