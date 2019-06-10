package com.cogoun.cucumber.util;

import com.cogoun.domain.Environment;
import com.cogoun.domain.InfrastructureControl;
import com.cogoun.domain.VirtualMachine;
import com.cogoun.domain.VirtualizationRequirement;

import java.util.HashSet;
import java.util.Set;

public class DomainHelper {
    public static final String HOST_NAME = "host";
    private Environment environment;
    private VirtualMachine virtualMachine;
    private InfrastructureControl infrastructureControl;
    private Set<VirtualizationRequirement> virtualizationRequirements = new HashSet();

    public Environment environment() {
        if (environment == null) {
            environment = new Environment("Test environment");
        }
        return environment;
    }

    public VirtualMachine virtualMachine() {
        return virtualMachine(0, 0,0 );
    }

    public VirtualMachine newVirtualMachine(String name) {
        return new VirtualMachine.Builder().start().of(name).from(getVirtualizationRequirements(0, 0, 0)).build().get();
    }

    public VirtualMachine virtualMachine(int vCPU, int memorySizeInGB, int hardDiskSizeInGB) {
        if (virtualMachine == null) {
            Set<VirtualizationRequirement> set = getVirtualizationRequirements(vCPU, memorySizeInGB, hardDiskSizeInGB);
            virtualMachine = new VirtualMachine.Builder().start().of(HOST_NAME).from(set).build().get();
        }
        return virtualMachine;
    }

    private Set<VirtualizationRequirement> getVirtualizationRequirements(int vCPU, int memorySizeInGB, int hardDiskSizeInGB) {
        Set<VirtualizationRequirement> set = new HashSet<>();
        set.add(new VirtualizationRequirement(VirtualizationRequirement.Type.CPU_COUNT, vCPU));
        set.add(new VirtualizationRequirement(VirtualizationRequirement.Type.DISK_SPACE_GB, hardDiskSizeInGB));
        set.add(new VirtualizationRequirement(VirtualizationRequirement.Type.MEMORY_SIZE_GB, memorySizeInGB));
        return set;
    }

    public InfrastructureControl infrastructureControl() {
        if (infrastructureControl == null) {
            infrastructureControl = new InfrastructureControl();
        }
        return infrastructureControl;
    }

    public Set<VirtualizationRequirement> virtualizationRequirements() {
       return virtualizationRequirements(0, 0, 0);
    }


    public Set<VirtualizationRequirement> virtualizationRequirements(int vCPU, int memorySizeInGB, int hardDiskSizeInGB) {
        if (virtualizationRequirements == null || virtualizationRequirements.isEmpty()) {
            Set<VirtualizationRequirement> set = getVirtualizationRequirements(vCPU, memorySizeInGB, hardDiskSizeInGB);
            this.virtualizationRequirements = set;
        }
        return this.virtualizationRequirements;
    }
}
