package com.kookies.persistence.repository;

import com.kookies.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepo extends IGenericRepo<Product, Integer> {

    Optional<List<Product>> findAllBySizeId(Integer sizeId);

    Optional<List<Product>> findAllByActive(Boolean active);
}
