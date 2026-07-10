package com.sakthivel.spring.spring.generics;

public class Box<T> {
	
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	public static void printBox(Box<?> box) {
	    System.out.println(box.getItem());
	}
	
	public static double addBox(Box<? extends Number> box) {
	    return box.getItem().doubleValue();
	}

}


