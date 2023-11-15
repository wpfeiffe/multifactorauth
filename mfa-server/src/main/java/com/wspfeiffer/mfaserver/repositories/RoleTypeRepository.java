package com.wspfeiffer.mfaserver.repositories;

import com.wspfeiffer.mfaserver.entities.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleTypeRepository extends JpaRepository<RoleType, String> {
}
