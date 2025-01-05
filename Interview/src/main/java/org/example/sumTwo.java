package org.example;
@FunctionalInterface
public interface sumTwo {
    default int sum(int a, int b) {
        return 0;
    }

    int sub(int a, int b);
}
