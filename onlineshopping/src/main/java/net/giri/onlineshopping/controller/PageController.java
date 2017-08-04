package net.giri.onlineshopping.controller;

import net.giri.onlineshoppingbackend.dao.CategoryDao;
import net.giri.onlineshoppingbackend.dto.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private CategoryDao categoryDao;

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

}
