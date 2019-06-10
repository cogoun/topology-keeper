package com.cogoun.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InfrastructureControl {

    public Optional<VirtualMachine> provision(String hostName, Set<VirtualizationRequirement> virtualizationRequirements) {
        Optional<VirtualMachine> result = Optional.empty();
        if (verify(virtualizationRequirements)) {
            result = new VirtualMachine.Builder().start().of(hostName).from(virtualizationRequirements).build();
        }
        return result;
    }

    private List<VirtualMachineSpecificationRule> virtualMachineSpecificationRules() {
        return Arrays.asList(VirtualMachineSpecificationRule.values());
    }

    private boolean verify(Set<VirtualizationRequirement> virtualizationRequirements) {
        Map<VirtualizationRequirement.Type, VirtualizationRequirement> requirementMap = virtualizationRequirements
                .stream()
                .collect(Collectors.toMap(VirtualizationRequirement::getName, Function.identity()));
        return virtualMachineSpecificationRules()
                .stream()
                .map(rule -> rule.test(requirementMap.get(rule.applicableTo())))
                .reduce(true, (subtotal, element) -> subtotal && element)
                .booleanValue();
    }
}
