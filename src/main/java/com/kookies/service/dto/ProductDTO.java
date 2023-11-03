package com.kookies.service.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class ProductDTO implements IDTO{
    private Integer productId;
    private String  productName;
    private String description;
    private Integer itemsNumber;
    private Double price;
    private Double discount;
    private Boolean active;
    private Integer sizeId;
}
