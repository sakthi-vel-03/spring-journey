package com.sakthivel.spring.spring.generics;

public class Boxes<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}