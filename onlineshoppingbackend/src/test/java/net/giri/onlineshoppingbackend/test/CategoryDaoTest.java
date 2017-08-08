package net.giri.onlineshoppingbackend.test;

import java.util.List;

import junit.framework.Assert;
import net.giri.onlineshoppingbackend.dao.CategoryDao;
import net.giri.onlineshoppingbackend.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryDaoTest {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDao categoryDao;

    @BeforeClass
    public static void setUp() {
	context = new AnnotationConfigApplicationContext();
	context.scan("net.giri.onlineshoppingbackend");
	context.refresh();
	categoryDao = context.getBean(CategoryDao.class);

    }

    public void testAddCategory() {

	Category category = new Category();
	category.setName("Mobile");
	category.setDescription("You can find all mobiles");
	category.setImgUrl("Img.png");
	category.setActive(true);
	categoryDao.add(category);

	category = new Category();
	category.setName("Laptops");
	category.setDescription("You can find all Laptops");
	category.setImgUrl("Img.png");
	category.setActive(true);
	categoryDao.add(category);

	category = new Category();
	category.setName("Television");
	category.setDescription("You can find all Tv");
	category.setImgUrl("Img.png");
	category.setActive(true);
	categoryDao.add(category);

    }

    public void testGetCategory() {
	Category category = categoryDao.get(4);
	Assert.assertEquals(category.getDescription(), "You can find all Laptops");

    }

    @Test
    public void testGetAllCategory() {
	List<Category> category = categoryDao.getAllCategory();
	System.out.println("category.size()"+category.size());
	Assert.assertEquals(category.size(), 3);

    }
}
