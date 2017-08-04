package net.giri.onlineshoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.giri.onlineshoppingbackend.dao.CategoryDao;
import net.giri.onlineshoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    private static List<Category> categoryList = new ArrayList<Category>();
    static {

	Category category = new Category();
	category.setId(123);
	category.setName("Mobile");
	category.setDescription("You can find all mobiles");
	category.setImgUrl("Img.png");
	category.setActive(true);
	categoryList.add(category);
	category = new Category();
	category.setId(1423);
	category.setName("Laptops");
	category.setDescription("You can find all Laptops");
	category.setImgUrl("Img.png");
	category.setActive(true);
	categoryList.add(category);
	category = new Category();
	category.setId(14273);
	category.setName("Television");
	category.setDescription("You can find all Tv");
	category.setImgUrl("Img.png");
	category.setActive(true);
	categoryList.add(category);
    }

    @Override
    public List<Category> getAllCategory() {
	return categoryList;
    }

    @Override
    public Category get(int id) {

	for (Category category : categoryList) {

	    if (id == category.getId()) {
		return category;
	    }
	}
	return null;
    }

}
