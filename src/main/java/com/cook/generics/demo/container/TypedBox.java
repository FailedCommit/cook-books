package com.cook.generics.demo.container;

public class TypedBox<T> {
    private T t;

    public TypedBox() {
    }

    public TypedBox(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    @Override
    public String toString() {
        return "TypedBox{" +
                "t=" + t +
                '}';
    }
}
