package com.kookies.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@IdClass(OrderSubProductPK.class)
@Entity
public class OrderSubProduct {

    @Id
    private OrderProduct orderProduct;

    @Id
    private SubProduct subProduct;

    @Column(nullable = false)
    private Integer quantity;

}
