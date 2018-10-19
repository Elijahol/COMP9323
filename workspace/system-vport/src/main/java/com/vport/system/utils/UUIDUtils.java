package com.vport.system.utils;

import java.util.UUID;
/**
 * Generate the unique code
 * @author Siyu Wang
 *
 */
public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
