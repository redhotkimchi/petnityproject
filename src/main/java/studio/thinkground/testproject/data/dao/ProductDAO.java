package studio.thinkground.testproject.data.dao;

import studio.thinkground.testproject.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);


    ProductEntity getProduct(String productId);
}
