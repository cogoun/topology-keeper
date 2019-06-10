package com.cogoun.domain;

public class VirtualizationRequirement {

    public enum Type {
        CPU_COUNT, MEMORY_SIZE_GB, DISK_SPACE_GB
    }

    private Type name;
    private int value;


    public VirtualizationRequirement(Type name, int value) {
        this.name = name;
        this.value = value;
    }

    public Type getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
