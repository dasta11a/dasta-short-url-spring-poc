/**
 * 
 */
package com.dasta.shorturl.model;

import java.util.Date;

import com.dasta.shorturl.util.ShortURLUtil;

/**
 * @author dasta
 *
 */
public class ShortURL {
	private String url;
    private long index;
    private Date createTime;
    private int numOfAccess;
    private Date lastAccessTime;
    
    
	/**
	 * 
	 */
	public ShortURL() {
		super();
	}

	/**
	 * @param url
	 * @param index
	 */
	public ShortURL(String url, long index) {
		this.url = url;
		this.index = index;
		this.createTime = new Date();
	}
	
    public String getUrl() {
		return url;
	}

	public long getIndex() {
		return index;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public int getNumOfAccess() {
		return numOfAccess;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void touch() {
        ++numOfAccess;
        lastAccessTime = new Date();
    }

    public String getShortURL() {
        return ShortURLUtil.getShortURL(index);
    }

    public String toString() {
        return getShortURL();
    }
    
}
