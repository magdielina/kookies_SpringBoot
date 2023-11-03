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
public class SubProductDetail extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false, length = 255)
    private String ingredients;

    @Column(nullable = false)
    private Boolean vegan;

    @Column(nullable = false)
    private Boolean glutenFree;

    @Column(nullable = false)
    private Boolean sugarFree;

}
