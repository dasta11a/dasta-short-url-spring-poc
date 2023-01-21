/**
 * 
 */
package com.dasta.shorturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasta.shorturl.repository.ShortURLDatabase;

/**
 * @author dasta
 *
 */
@Service
public class ShortURLService {

	@Autowired
    private ShortURLDatabase shortURLDatabase;

    public String getShortURL(String fullURL) {
        return shortURLDatabase.getShortURL(fullURL);
    }

    public String getFullURL(String shortURL) {
        return shortURLDatabase.getFullURL(shortURL);
    }
}
