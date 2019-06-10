package com.cogoun.repository;

import com.cogoun.entity.VirtualMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualMachineRepository extends JpaRepository<VirtualMachineEntity, Long> {
}
