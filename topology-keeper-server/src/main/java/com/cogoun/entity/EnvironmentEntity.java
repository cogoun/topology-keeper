package com.cogoun.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "environment")
public class EnvironmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "environment_id")
    private Set<VirtualMachineEntity> virtualMachines;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VirtualMachineEntity> getVirtualMachines() {
        return virtualMachines;
    }

    public void setVirtualMachines(Set<VirtualMachineEntity> virtualMachines) {
        this.virtualMachines = virtualMachines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnvironmentEntity that = (EnvironmentEntity) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
