package com.programeiros.thisfinans.model.entities;


import com.programeiros.thisfinans.model.entities.ENUM.TypeUser;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userAccount;

    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    @Email
    private String email;
    @NonNull
    private TypeUser typeUser;
    @NonNull
    private Boolean status;
    @NonNull
    private Instant createDate;
    private Instant updateDate;

    @OneToMany(mappedBy = "user")
    @Setter(AccessLevel.NONE)
    List<Account> accounts = new ArrayList<>();
}
