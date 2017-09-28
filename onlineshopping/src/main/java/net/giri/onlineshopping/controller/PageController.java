package net.giri.onlineshopping.controller;

import net.giri.onlineshopping.exception.ProductNotFoundException;
import net.giri.onlineshoppingbackend.dao.CategoryDao;
import net.giri.onlineshoppingbackend.dao.ProductDao;
import net.giri.onlineshoppingbackend.dto.Category;
import net.giri.onlineshoppingbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = { "/", "/home", "/index" })
    public ModelAndView index() {
	ModelAndView model = new ModelAndView("page");
	model.addObject("title", "Home");
	model.addObject("userClickedHome", true);
	model.addObject("categories", categoryDao.getAllCategory());
	return model;

    }

    @RequestMapping("/about")
    public ModelAndView about() {
	ModelAndView model = new ModelAndView("page");
	model.addObject("title", "About Us");
	model.addObject("userClickedAbout", true);
	return model;

    }

    @RequestMapping("/contact")
    public ModelAndView contact() {
	ModelAndView model = new ModelAndView("page");
	model.addObject("title", "Contact Us");
	model.addObject("userClickedContact", true);
	return model;

    }

    @RequestMapping(value = "/show/all/products")
    public ModelAndView getAllProdcuts() {
	ModelAndView model = new ModelAndView("page");
	model.addObject("title", "All Products");
	model.addObject("userClickedAllProduct", true);
	model.addObject("categories", categoryDao.getAllCategory());
	return model;

    }

    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView getCategoryAllProdcuts(@PathVariable("id") int categoryId) {
	Category category = categoryDao.get(categoryId);
	ModelAndView model = new ModelAndView("page");
	model.addObject("title", category.getName());
	model.addObject("userClickedCategoryProduct", true);
	model.addObject("categories", categoryDao.getAllCategory());
	model.addObject("category", category);

	return model;

    }

    @RequestMapping("/show/{id}/product")
    public ModelAndView getProductDetails(@PathVariable("id") int productId) throws ProductNotFoundException {
	Product product = productDao.get(productId);

	if (null == product) {

	    throw new ProductNotFoundException("The product you are looking for is not available");
	}

	ModelAndView model = new ModelAndView("page");
	model.addObject("title", product.getName());
	model.addObject("userClickedViewProduct", true);
	model.addObject("product", product);
	// increment number of views
	product.setViews(product.getViews() + 1);
	productDao.update(product);
	return model;

    }

}
