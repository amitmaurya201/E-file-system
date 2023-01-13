package io.jetprocess.core.util;

import java.util.HashMap;
import java.util.Map;

public class Pagination {

	public static Map<String, Integer> getOffset(int delta, int currentPage, int count, int preDelta) {
		int start = delta * (currentPage - 1);
		int currPage = currentPage;
		Map<String, Integer> config = new HashMap<>();

		if (delta != preDelta) {
			if (delta * (currPage - 1) > count) {
				currPage = getCurrentPage(currPage, delta, count);
				System.out.println("inside iF-2 " + currPage);
				start = delta * (currPage - 1);
				System.out.println("inside iF-1 " + start);
			} else if (delta < preDelta) {
				start = delta * (currPage - 1);
				System.out.println("inside iF-3 " + start);
			} else {

				start = 0;
				System.out.println("inside ELSE-4 " + start);
			}

		} else if (delta * (currPage - 1) > count) {
			currPage = getCurrentPage(currPage, delta, count);
			start = delta * (currPage - 1);
			System.out.println("inside ELSE IF- " + start);
			System.out.println("inside ELSE IF- " + currPage);

		}

		if (start < 0) {
			start = 0;
			System.out.println("inside ELSE-5- " + start);
		}

		if (delta == count) {
			start = 0;
			System.out.println("inside ELSE-5- " + start);
		}

		System.out.println("final currPage " + currPage);
		System.out.println("final start " + start);
		config.put("currentPage", currPage);
		config.put("start", start);
		return config;
	}

	private static int getCurrentPage(int currentPage, int delta, int count) {
		currentPage = currentPage - 1;

		if (delta * (currentPage - 1) < count) {
			return currentPage;
		} else {
			return getCurrentPage(currentPage, delta, count);
		}

	}

}
