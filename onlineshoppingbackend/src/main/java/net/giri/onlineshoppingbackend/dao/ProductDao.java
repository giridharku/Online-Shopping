package net.giri.onlineshoppingbackend.dao;

import java.util.List;

import net.giri.onlineshoppingbackend.dto.Product;

public interface ProductDao {

    public List<Product> getAllProducts();

    public Product get(int id);

    public boolean add(Product product);

    public boolean update(Product product);

    public boolean remove(int id);

    public List<Product> getAllActiveProducts();

    public List<Product> getActiveProductsByCategory(int categoryId);
    
    public List<Product> getLatestActiveProducts(int count);
    

}
