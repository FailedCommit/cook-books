package com.cook.generics.demo.container;

public class ContainerDemo {
    public static void main(String[] args) {
        RawBox rb = new RawBox();
        rb.set(new Integer(10));
        Integer integerValue = (Integer) rb.get(); // cast needed
        System.out.println(integerValue);

        rb.set("Dada");
        final String stringValue = (String) rb.get();
        System.out.println(stringValue);

        rb.set(new TypedBox<>("mohit"));
        final TypedBox typedBoxInstance = (TypedBox) rb.get();
        System.out.println(typedBoxInstance.get());

//        final Object typedBoxInstanceWithoutCasting = rb.get();
//        System.out.println(typedBoxInstanceWithoutCasting.get()); // getter won't be available in uncasted version

        TypedBox<Integer> boxOfIntegers = new TypedBox<>();
        boxOfIntegers.set(new Integer(100));
        final Integer intVal = boxOfIntegers.get();
        System.out.println(intVal);
    }
}
