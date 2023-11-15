package com.wspfeiffer.mfaserver.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role_type")
public class RoleType {
    @Id
    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @Column(name = "description", nullable = false, length = 60)
    private String description;

}
