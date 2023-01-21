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

	private Map<String, String> urlMap = new HashMap<>();
	private Map<String, ShortURL> fullURLMap = new HashMap<>();
	private long next = 9837912415197L;

	public String getShortURL(String fullURL) {
		String shortURL = urlMap.get(fullURL);
		if (shortURL == null) {
			ShortURL model = new ShortURL(fullURL, next++);
			shortURL = model.getShortURL();
			urlMap.put(fullURL, shortURL);
			fullURLMap.put(shortURL, model);
		}
		return shortURL;
	}

	public String getFullURL(String shortURL) {
		ShortURL model = fullURLMap.get(shortURL);
		if (model == null)
			return null;
		model.touch();
		return model.getUrl();
	}
}
