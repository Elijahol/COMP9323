package com.vport.system.utils;

import javax.servlet.http.Cookie;

/**
 * Provide the method to find a specific cookies
 * according to the cookie name
 * @author Siyu Wang
 *
 */
public class CookieUtils {
	public static Cookie findCookie(Cookie[] cookies, String name){
		if(cookies == null){
			return null;
		}else{
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName()))
					return cookie;
			}
			return null;
		}
	}
}
