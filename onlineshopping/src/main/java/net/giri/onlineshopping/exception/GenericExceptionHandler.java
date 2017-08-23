package net.giri.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GenericExceptionHandler {
    
    @ExceptionHandler(value=NoHandlerFoundException.class)
    public ModelAndView noHandlerFound(NoHandlerFoundException ex){
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("title","Page Not Found");
	mv.addObject("error", "Page You Are Looking Not Available");
	mv.addObject("errorMsg", ex.fillInStackTrace());	
	return mv;
	
    }
    
    @ExceptionHandler(value=ProductNotFoundException.class)
    public ModelAndView handleProductNotFound(ProductNotFoundException ex){
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("title","Product Not Found");
	mv.addObject("error", "Product is not available");
	mv.addObject("errorMsg", ex.getMsg());	
	return mv;
	
    }

    
    @ExceptionHandler(value=Exception.class)
    public ModelAndView handleAnyException(Exception ex){
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("title","Error Occured!");
	mv.addObject("error", "Contact Administrator!!!");
	mv.addObject("errorMsg", ex.toString());	
	return mv;
	
    }
}
