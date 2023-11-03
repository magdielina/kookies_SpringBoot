package com.kookies.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class OrderProduct {

   @Id
   @EqualsAndHashCode.Include
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(nullable = false)
   private Double subTotal;

   @ManyToOne
   @JoinColumn(name = "orderId", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDER_PRODUCT_ORDER"))
   private Order order;

   @ManyToOne
   @JoinColumn(name = "productId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_ORDER_PRODUCT"))
   private Product product;


}
