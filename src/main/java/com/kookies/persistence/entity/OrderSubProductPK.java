package com.kookies.persistence.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class OrderSubProductPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_product_id")
    private OrderProduct orderProduct;

    @ManyToOne
    @JoinColumn(name = "sub_product_id")
    private SubProduct subProduct;
}
