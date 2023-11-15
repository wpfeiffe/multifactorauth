package com.wspfeiffer.mfaserver.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_account")
public class UserAccount {
    public static final String DEFAULT_PASSWORD = "{noop}Password1";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_account_id_gen")
    @SequenceGenerator(name = "user_account_id_gen", sequenceName = "user_account_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "version")
    private Short version;

    @Column(name = "username", nullable = false, length = 60)
    private String username;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", length = 120)
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "totp_code", nullable = false, length = 200)
    private String totpCode;

}
