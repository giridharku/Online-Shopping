package net.giri.onlineshoppingbackend.dao;

import java.util.List;

import net.giri.onlineshoppingbackend.dto.Category;

public interface CategoryDao {
    
    public List<Category>getAllCategory();
    
    public Category get(int id);

}
