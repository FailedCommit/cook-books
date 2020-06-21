package com.cook.beans;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class SequenceGenerator {
    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public String getSequence() {
        String builder = prefix +
                initial +
                counter.getAndIncrement() +
                suffix;
        return builder;
    }
}