package net.giri.onlineshoppingbackend.dao;

import java.util.List;

import net.giri.onlineshoppingbackend.dto.Category;

public interface CategoryDao {

    public List<Category> getAllCategory();

    public Category get(long id);

    public boolean add(Category category);
    
    public boolean update(Category category);
    
    public boolean remove(long id);


}
