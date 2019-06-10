package com.cogoun.domain;

import java.util.*;

public class VirtualMachine {

    private String hostName;

    private Map<VirtualizationRequirement.Type, VirtualizationRequirement> virtualizationRequirements = new HashMap<>();

    private VirtualMachine() {
    }

    private void set(VirtualizationRequirement virtualizationRequirement) {
        virtualizationRequirements.put(virtualizationRequirement.getName(), virtualizationRequirement);
    }

    public VirtualizationRequirement get(VirtualizationRequirement.Type type) {
        return virtualizationRequirements.get(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine that = (VirtualMachine) o;
        return Objects.equals(hostName, that.hostName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostName);
    }

    public static class Builder {
        private VirtualMachine virtualMachine;

        public Builder start() {
            virtualMachine = new VirtualMachine();
            return this;
        }
        public Builder from(Set<VirtualizationRequirement> virtualizationRequirementsIn) {
            virtualizationRequirementsIn.stream().forEach(vr -> virtualMachine.set(vr));
            return this;
        }
        public Builder of(String name) {
            virtualMachine.hostName = name;
            return this;
        }

        public Optional<VirtualMachine> build() {
            if (virtualMachine.hostName == null && virtualMachine.virtualizationRequirements == null) {
                return Optional.empty();
            }
            return Optional.of(virtualMachine);
        }
    }
}
