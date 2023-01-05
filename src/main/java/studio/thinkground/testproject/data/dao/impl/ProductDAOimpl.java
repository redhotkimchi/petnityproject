package studio.thinkground.testproject.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.testproject.data.dao.ProductDAO;
import studio.thinkground.testproject.data.entity.ProductEntity;
import studio.thinkground.testproject.data.repository.ProductRepository;

@Service
public class ProductDAOimpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOimpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
