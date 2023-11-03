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
public class SubProduct extends Auditable implements Serializable {

    public enum SubProductSize { MINI, REGULAR }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "detailId", nullable = false, foreignKey = @ForeignKey(name = "FK_SUB_PRODUCT_DETAIL"))
    private SubProductDetail detail;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false, length = 50)
    private String nutrition;
    @ManyToOne
    @JoinColumn(name = "sizeId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_SUB_PRODUCT_SIZE"))
    private Size size;
}
