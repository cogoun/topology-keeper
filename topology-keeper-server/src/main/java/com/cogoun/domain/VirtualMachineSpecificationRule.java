package com.cogoun.domain;

import java.util.function.Predicate;

public enum VirtualMachineSpecificationRule implements Predicate<VirtualizationRequirement>{

    MAX_CPU_COUNT(requirement ->  requirement.getValue() > 8 ?  false : true, VirtualizationRequirement.Type.CPU_COUNT),
    MAX_MEMORY_SIZE_IN_GB(requirement -> requirement.getValue() > 64 ? false : true, VirtualizationRequirement.Type.MEMORY_SIZE_GB),
    MAX_DISK_SIZE_IN_GB(requirement -> requirement.getValue() > 1024 ? false : true, VirtualizationRequirement.Type.DISK_SPACE_GB),
    MIN_CPU_COUNT(requirement ->  requirement.getValue() < 1 ?  false : true, VirtualizationRequirement.Type.CPU_COUNT),
    MIN_MEMORY_SIZE_IN_GB(requirement -> requirement.getValue() < 1 ? false : true, VirtualizationRequirement.Type.MEMORY_SIZE_GB),
    MIN_DISK_SIZE_IN_GB(requirement -> requirement.getValue() < 40 ? false : true, VirtualizationRequirement.Type.DISK_SPACE_GB);

    private Predicate<VirtualizationRequirement> virtualizationRequirementPredicate;
    private VirtualizationRequirement.Type applicableTo;

    private VirtualMachineSpecificationRule(Predicate<VirtualizationRequirement> vmPredicate, VirtualizationRequirement.Type applicableTo) {
        this.virtualizationRequirementPredicate = vmPredicate;
        this.applicableTo = applicableTo;
    }

    public VirtualizationRequirement.Type applicableTo() {
        return applicableTo;
    }

    @Override
    public boolean test(VirtualizationRequirement virtualizationRequirement) {
        return virtualizationRequirementPredicate.test(virtualizationRequirement);
    }
}
