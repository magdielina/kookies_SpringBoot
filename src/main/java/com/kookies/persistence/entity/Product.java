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
public class Product extends Auditable implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30, unique = true)
    private String  name;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false)
    private Integer itemsNumber;

    @Column(nullable = false)
    private Double price;

    private Double discount;

    @Column(nullable = false)
    private Boolean active;

    private Integer sizeId;
    @ManyToOne
    @JoinColumn(name = "sizeId", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_SIZE"))
    private Size size;

}
