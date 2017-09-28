package net.giri.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import net.giri.onlineshoppingbackend.dao.CategoryDao;
import net.giri.onlineshoppingbackend.dao.ProductDao;
import net.giri.onlineshoppingbackend.dto.Category;
import net.giri.onlineshoppingbackend.dto.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManageProductController {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductDao productDao;

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public ModelAndView manageProduct(@RequestParam(required = false, value = "createProduct") String createProduct) {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "Manage Products");
	mv.addObject("userClickedManageProduct", true);
	if (!StringUtils.isEmpty(createProduct)) {
	    mv.addObject("createProductMsg", "product saved successfully");

	}
	Product newProduct = new Product();
	mv.addObject("product", newProduct);
	return mv;

    }

    @ModelAttribute("categoryList")
    public List<Category> getCategoryList() {
	return categoryDao.getAllCategory();

    }

    @RequestMapping(method = RequestMethod.POST, path = "/products")
    public String saveProduct(@Valid @ModelAttribute("product") Product formProduct, BindingResult results, Model model) {
	// If validation fails than redirect to create page with validation message
	if (results.hasErrors()) {
	    model.addAttribute("title", "Manage Products");
	    model.addAttribute("userClickedManageProduct", true);
	    return "page";
	}
	productDao.add(formProduct);
	// After saving product redirect control to create new Product page
	return "redirect:/manage/products?createProduct=success";

    }

}
