package com.kookies.service.impl;

import com.kookies.persistence.entity.Product;
import com.kookies.persistence.repository.IGenericRepo;
import com.kookies.persistence.repository.IProductRepo;
import com.kookies.service.IProductService;
import com.kookies.service.dto.ProductDTO;
import com.kookies.service.mapper.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends CRUDService<Product, ProductDTO, IProductMapper, Integer> implements IProductService {

    private IProductRepo productRepo;
    private IProductMapper productMapper;

    @Autowired
    public ProductService(IProductRepo productRepo, IProductMapper productMapper) {
        super(productMapper);
        this.productMapper = productMapper;
        this.productRepo = productRepo;
    }

    @Override
    protected IGenericRepo<Product, Integer> getRepo() {
        return productRepo;
    }

    @Override
    public Optional<List<ProductDTO>> getBySize(Integer sizeId) {
        Optional<List<Product>> entityList = productRepo.findAllBySizeId(sizeId);
        return entityList.filter(products -> !products.isEmpty()).map(products ->  productMapper.toDTOList(products));
    }

    @Override
    public Optional<List<ProductDTO>> getByActive(Boolean active) {
        Optional<List<Product>> entityList = productRepo.findAllByActive(active);
        return entityList.filter(products -> !products.isEmpty()).map(products ->  productMapper.toDTOList(products));
    }


}
