package com.cook.annotations.processors;

import com.cook.annotations.custom.Init;
import com.cook.annotations.custom.JsonElement;
import com.cook.annotations.custom.JsonSerializable;
import com.cook.annotations.exceptions.SerializationException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class Serializer {
    public String serialize(Object obj) throws SerializationException {
        try {
            checkIfSerializable(obj);
            initializeObject(obj);
            return getJsonString(obj);
        } catch(Exception e) {
            throw new SerializationException(e.getMessage());
        }
    }


    private void checkIfSerializable(Object obj) {
        if(isNull(obj)) {
            throw new SerializationException("Can't serialize null object");
        }
        Class<?> clazz = obj.getClass();
        if(!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new SerializationException(
                    "The class " + clazz.getSimpleName() + " is not annotated with JsonSerializable annotation");
        }
    }

    private void initializeObject(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for(Method method : clazz.getDeclaredMethods()) {
            if(method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(obj);
            }
        }
    }

    private String getJsonString(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, String> elemMap = new HashMap<>();
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)) {
                elemMap.put(getKey(field), getStringValue(field, obj));
            }
        }
        String jsonString = elemMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getStringValue(Field field, Object obj) throws IllegalAccessException {
        final Object val = field.get(obj);
        if(isNull(val)) {
            throw new RuntimeException("Can't serialize field " + getKey(field) + " with null value");
        }
        return val.toString();
    }

    private String getKey(Field field) {
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty() ? field.getName() : value;
    }
}
