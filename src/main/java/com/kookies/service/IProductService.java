package com.kookies.service;

import com.kookies.service.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService extends ICRUDService<ProductDTO, Integer> {

    Optional<List<ProductDTO>> getBySize(Integer sizeId);

    Optional<List<ProductDTO>> getByActive(Boolean active);

}
