package com.wspfeiffer.mfaserver.repositories;

import com.wspfeiffer.mfaserver.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("from UserRole ur where ur.user.id = :userId")
    List<UserRole> findByUserId(@Param("userId") Long userId);
}
