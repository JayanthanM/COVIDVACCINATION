package com.cvm.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cvm.entity.Slot;
import com.cvm.exception.NoSlotFoundException;

@Repository("slotdao")
public interface SlotDao extends JpaRepository<Slot , Integer> {
	Optional<Slot> findSlotBySlotLocation(String sLocation) throws NoSlotFoundException;
}
