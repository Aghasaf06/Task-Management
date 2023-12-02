package taskmanagement.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username")
    String username;

    String email;

    @Column(name = "password",nullable = false)
    String password;

    //Set<Role> roles;

    @Column(name = "is_active")
    @Builder.Default
    Boolean isActive = true;

    @Column(name = "is_remembre_me")
    @Builder.Default
    Boolean isRememberMe= true;
    //true?
}
