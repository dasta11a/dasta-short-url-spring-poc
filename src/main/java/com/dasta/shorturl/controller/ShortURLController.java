/**
 * 
 */
package com.dasta.shorturl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dasta.shorturl.service.ShortURLService;

/**
 * @author dasta
 *
 */
@RestController
public class ShortURLController {

	@Autowired
	private ShortURLService shortURLService;

	@RequestMapping(value = "/shorturl", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam(value = "url", required = true) String url) {
    	ModelMap model = new ModelMap();
        model.put("shorturl", shortURLService.getShortURL(url));
        return new ModelAndView("shorturl", model);
	}

	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("url") String shortURL, HttpServletRequest request) {
		String fullURL = shortURLService.getFullURL(shortURL);
		if (fullURL == null) {
            ModelMap model = new ModelMap();
            model.put("uri", request.getRequestURL());
            return new ModelAndView("404", model);
        } else {
        	ModelMap model = new ModelMap();
            model.put("uri", fullURL);
            return new ModelAndView("success", model);
        }
	}
}
