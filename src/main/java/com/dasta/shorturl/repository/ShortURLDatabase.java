/**
 * 
 */
package com.dasta.shorturl.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dasta.shorturl.model.ShortURL;

/**
 * @author dasta
 *
 */
@Component
public class ShortURLDatabase {

	private Map<String, ShortURL> urlMap = new HashMap<>();
	private Map<String, ShortURL> fullURLMap = new HashMap<>();
	private long next = 9837912415197L;

	public String getShortURL(String fullURL) {
		ShortURL model = fullURLMap.get(fullURL);
		if (model == null) {
			model = new ShortURL(fullURL, next++);
			String shortURL = model.getShortURL();
			urlMap.put(shortURL, model);
			fullURLMap.put(shortURL, model);
			return shortURL;
		}
		return model.getUrl();
	}

	public String getFullURL(String shortURL) {
		ShortURL model = fullURLMap.get(shortURL);
		if (model == null)
			return null;
		model.touch();
		return model.getUrl();
	}
}
