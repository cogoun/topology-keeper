package com.cogoun.domain;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class Environment {

    private long id;
    private String name;
    private List<VirtualMachine> vms = new ArrayList<>();

    public Environment() {
    }

    public Environment(String name) {
        this.name = name;
    }

    public void add(VirtualMachine vm) {
        vms.add(vm);
    }

    public int virtualMachineCount() {
        return vms.size();
    }

    public void remove(VirtualMachine vm) {
        vms.remove(vm);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
