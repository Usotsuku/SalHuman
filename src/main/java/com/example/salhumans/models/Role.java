
package com.example.salhumans.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

enum UserRoleEnum {
    EMPLOYEE,
    MANAGER,
    HR,
    ADMIN
}
@Setter
@Getter
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RoleId;
    @Enumerated(EnumType.STRING)
    private UserRoleEnum name;

}
