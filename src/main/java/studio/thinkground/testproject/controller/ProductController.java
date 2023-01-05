package studio.thinkground.testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.common.Constants;
import studio.thinkground.testproject.common.exception.TestException;
import studio.thinkground.testproject.data.dto.ProductDto;
import studio.thinkground.testproject.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId){

        return productService.getProduct(productId);
    }
    @PostMapping(value = "/product")
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @DeleteMapping(value = ("/product/{productId}"))
    public ProductDto deleteProduct(@PathVariable String productId){return null;}

    @PostMapping(value = ("/product/exception"))
    public void exceptionTest() throws TestException {
        throw new TestException(Constants.ExceptionClass.PRODUCT , HttpStatus.FORBIDDEN, "의도한 에러 발생");

    }

}
