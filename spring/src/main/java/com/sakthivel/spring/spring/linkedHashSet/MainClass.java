package com.sakthivel.spring.spring.linkedHashSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class MainClass {
    static class Page {
        String url;

        Page(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return url;
        }
        
        @Override
        public boolean equals(Object o) {
        	if(this == o) return true;
        	if(o == null || getClass() != o.getClass()) return false;
        	Page that = (Page) o;
        	return this.url.equals(that.url);
        	
        }
        
        @Override
        public int hashCode() {
        	return url.hashCode();
        }
    }

    public static void main(String[] args) {
//    	linkedHashMapWithoutOverride();
//    	hashvslinkedHashSet();
    	treeSet();
    }
    
	// 1. LinkedHashSet Working
	public static void LinkedHashSet() {
		
		 LinkedHashSet<String> pages = new LinkedHashSet<>();

	        pages.add("home");
	        pages.add("products");
	        pages.add("cart");
	        pages.add("home");      // duplicate
	        pages.add("checkout");
	        pages.add("products");  // duplicate

	        System.out.println("Size: " + pages.size());
	        System.out.println("Order: " + pages);
		
	}
	
	// 2. Breaking LinkedhashMap
	public static void linkedHashMapWithoutOverride() {
		
		LinkedHashSet<Page> visited = new LinkedHashSet<>();

        Page p1 = new Page("home");
        Page p2 = new Page("products");
        Page p3 = new Page("home");

        visited.add(p1);
        visited.add(p2);
        visited.add(p3);

        System.out.println("Size: " + visited.size());
        System.out.println("Pages: " + visited);
		
	}
	 public static void hashvslinkedHashSet() {
	        HashSet<String> hashSet = new HashSet<>();
	        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

	        String[] pages = {"checkout", "home", "cart", "products", "about"};

	        for (String page : pages) {
	            hashSet.add(page);
	            linkedHashSet.add(page);
	        }

	        System.out.println("Insertion order: checkout → home → cart → products → about");
	        System.out.println("HashSet:         " + hashSet);
	        System.out.println("LinkedHashSet:   " + linkedHashSet);
	    }
	 
	 public static void treeSet() {
		 TreeSet<Integer> scores = new TreeSet<>();

	        scores.add(85);
	        scores.add(42);
	        scores.add(96);
	        scores.add(42); // duplicate
	        scores.add(17);
	        scores.add(73);

	        System.out.println("Size: " + scores.size());
	        System.out.println("Scores: " + scores);
	        System.out.println("Lowest: " + scores.first());
	        System.out.println("Highest: " + scores.last());
	 }
}
