package com.kookies.service.mapper;


import com.kookies.persistence.entity.Product;
import com.kookies.service.dto.ProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper extends IMapper<Product, ProductDTO>{

    @Override
    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "itemsNumber", target = "itemsNumber"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "sizeId", target = "sizeId"),
    })
    ProductDTO toDTO(Product product);

    @Override
    List<ProductDTO> toDTOList(List<Product> products);

    @Override
    @InheritInverseConfiguration
    @Mapping(target = "size", ignore = true)
    Product toEntity(ProductDTO dto);
}
