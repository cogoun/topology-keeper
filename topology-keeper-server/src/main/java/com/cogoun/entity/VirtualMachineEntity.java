package com.cogoun.entity;

import com.cogoun.domain.Environment;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "virtual_machine")
public class VirtualMachineEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "host_name")
    private String hostName;

    @OneToOne
    private EnvironmentEntity environment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public EnvironmentEntity getEnvironment() {
        return environment;
    }

    public void setEnvironment(EnvironmentEntity environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachineEntity that = (VirtualMachineEntity) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
