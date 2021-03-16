package com.hciulica.springbootecommerce.config;

import com.hciulica.springbootecommerce.entity.Product;
import com.hciulica.springbootecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        //disable HTTP methods for Product: PUT, POST AND DELETE

        config.getExposureConfiguration()
                .forDomainType(Product.class) //-> httpMethods.disable(theUnsupportedActions)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        //disable HTTP methods for ProductCategory: PUT, POST AND DELETE

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class) //-> httpMethods.disable(theUnsupportedActions)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
