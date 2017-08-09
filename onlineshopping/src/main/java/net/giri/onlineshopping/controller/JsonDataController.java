/**
 * 
 */
package net.giri.onlineshopping.controller;

import java.util.List;

import net.giri.onlineshoppingbackend.dao.ProductDao;
import net.giri.onlineshoppingbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author giridhar
 *
 */
@RestController
@RequestMapping("/json/data")
@ResponseBody
public class JsonDataController {
    @Autowired
    private ProductDao productDao;

    @RequestMapping("/all/products")
    public List<Product> getAllProducts() {
	return productDao.getAllActiveProducts();

    }

    @RequestMapping("/category/{categoryId}/products")
    public List<Product> getAllProductsByCategory(@PathVariable("categoryId") int categoryId) {
	return productDao.getActiveProductsByCategory(categoryId);

    }

}
