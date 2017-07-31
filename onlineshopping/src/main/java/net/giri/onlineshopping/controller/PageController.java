package net.giri.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping(value = { "/", "/home", "/index" })
    public ModelAndView index() {
	ModelAndView model = new ModelAndView("page");
	model.addObject("title", "Home");
	model.addObject("userClickedHome", true);
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

}
