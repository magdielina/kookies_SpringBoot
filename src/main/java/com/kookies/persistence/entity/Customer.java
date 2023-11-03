package com.kookies.persistence.entity;

import com.kookies.persistence.audit.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
public class Customer extends Auditable implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 15)
    private String phone;

    @Column(length = 60, unique = true)
    private String email;

    @Column(length = 200)
    private String address;

}
