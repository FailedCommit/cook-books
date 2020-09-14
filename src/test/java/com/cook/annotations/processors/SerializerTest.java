package com.cook.annotations.processors;

import com.cook.annotations.beans.Student;
import com.cook.annotations.exceptions.SerializationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SerializerTest {

    @Test
    public void serializeNullObject() {
        Object object = new Object();
        Serializer serializer = new Serializer();
        assertThrows(SerializationException.class, () -> {
            serializer.serialize(object);
        });
    }

    @Test
    public void serializeValidObject() throws SerializationException {
        Student mohit = new Student("Mohit", "Kumar", 35D);
        Serializer serializer = new Serializer();
        String jsonString = serializer.serialize(mohit);
        assertEquals("{\"firstName\":\"Mohit\",\"lastName\":\"Kumar\",\"studentAge\":\"35.0\"}", jsonString);
    }

    @Test
    public void serializeInValidObject_nullAge() throws SerializationException {
        Student mohit = new Student("Mohit", "Kumar", null);
        Serializer serializer = new Serializer();
        assertThrows(SerializationException.class, () -> {
            serializer.serialize(mohit);
        });
    }

}
