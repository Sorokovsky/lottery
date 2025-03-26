package org.sorokovsky.lottery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Column(nullable = false)
    @ColumnDefault("")
    private String name;
    @Column(nullable = false)
    @ColumnDefault("")
    private String surname;
    @Column(nullable = false)
    @ColumnDefault("")
    private String middleName;
    @Column(nullable = false)
    @ColumnDefault("")
    private String avatarPath;
}
