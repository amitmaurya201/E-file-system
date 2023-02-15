package io.jetprocess.core.util;

import java.util.HashMap;
import java.util.Map;

public class Pagination {

	public static Map<String, Integer> getOffset(int delta, int currentPage, int count, int preDelta) {
		int start = delta * (currentPage - 1);
		int currPage = currentPage;
		Map<String, Integer> config = new HashMap<>();
		if (delta * (currPage - 1) > count) {
			currPage = getCurrentPage(currPage, delta, count);
		} 
		start = delta * (currPage - 1);
		config.put("currentPage", currPage);
		config.put("start", start);
		return config;
	}

	//recournation method
	private static int getCurrentPage(int currentPage, int delta, int count) {
		currentPage = currentPage - 1;
		if (delta * (currentPage - 1) < count) {
			return currentPage;
		}
		return getCurrentPage(currentPage, delta, count);
	}
}
