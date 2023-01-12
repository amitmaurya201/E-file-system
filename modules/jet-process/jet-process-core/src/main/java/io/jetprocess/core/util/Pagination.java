package io.jetprocess.core.util;

import java.util.HashMap;
import java.util.Map;

public class Pagination {
	

	public static Map<String, Integer> getOffset(int delta,int currentPage, int count, int preDelta) {
		int start = 0;
		int currPage=currentPage;
		Map<String, Integer> config=new HashMap<>();
		
		System.out.println("running Pagination class of core package....");
		
		System.out.println("delta "+delta);
		
		System.out.println("currentPage "+currentPage);
		
		System.out.println("count "+count);
		
		System.out.println("preDelta "+preDelta);
		
		if(delta !=preDelta) {
			if(delta*currPage  > count) {
				if(delta*(currPage-1)  > count) {
					currPage = getCurrentPage(currPage, preDelta, count);
					System.out.println("inside iF-2 "+currPage);
				}
				start = delta*(currPage-1);
//				start=0;
				System.out.println("inside iF-1 "+start);
			} else if(delta <preDelta) {
					start = delta*(currPage-1);
					System.out.println("inside iF-3 "+start);
			}else {
				
				start=0;
				System.out.println("inside ELSE-4 "+start);
			}
			
		} else if(delta*(currPage-1)  > count) {
			currPage = getCurrentPage(currPage, preDelta, count);
			start = delta*(currPage-1);
			System.out.println("inside ELSE IF- "+start);
			System.out.println("inside ELSE IF- "+currPage);
		}
//		else {
//			start = 0;
//			
//		}
		

		if(start < 0) {
			start = 0;
			System.out.println("inside ELSE-5- "+start);
		}

		if(delta == count) {
			start = 0;
			System.out.println("inside ELSE-5- "+start);
		}
		
		System.out.println("final currPage "+currPage);
		System.out.println("final start "+start);
		config.put("currentPage", currPage);
		config.put("start", start);
		return config;
	}
	
	
	private static int getCurrentPage(int currentPage, int delta, int count) {
		currentPage = currentPage-1;
		
		if(delta*currentPage  < count) {
			return currentPage;
		} else {
			return getCurrentPage(currentPage, delta, count);
		}
	
}
	

}
