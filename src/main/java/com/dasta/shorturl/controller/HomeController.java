/**
 * 
 */
package com.dasta.shorturl.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dasta.shorturl.model.ShortURL;

/**
 * @author dasta
 *
 */
@RestController
public class HomeController {

	private static final String HOME_PAGE_PATH = "index.html";
	  private static final String NO_PAGE_FOUND = "404.html";


	  @RequestMapping("/")
	  public ModelAndView home(ModelMap model) {
		model.addAttribute("formData", new ShortURL());
	    ModelAndView modelAndView = new ModelAndView(HOME_PAGE_PATH, model);
	    return modelAndView;
	  }

	  @RequestMapping("/NoPageFound")
	  public ModelAndView noPageFound() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName(NO_PAGE_FOUND);
	    return modelAndView;
	  }
}
