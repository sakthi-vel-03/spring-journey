package com.sakthivel.spring.spring.generics;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
//		Box<String> box = new Box();
//		box.setItem("Sakthivel");
//		System.out.println(box.getItem());
////		box.setItem(1);
////		System.out.println(box.getItem());
//		
//		Box<Integer> intBox = new Box<>();
//		intBox.setItem(42);
//		System.out.println(intBox.getItem());
		
		
//		Box<String> stringBox = new Box<>();
//		stringBox.setItem("Sakthivel");
//		Box.printBox(stringBox);
//		
//		Box<Integer> integerBox = new Box<>();
//		integerBox.setItem(42);
//		Box.printBox(integerBox);
		
		Box<Integer> integerBox = new Box<>();
		integerBox.setItem(42);
		Double d = Box.addBox(integerBox);
		System.out.println(d);

		Box<Double> dblBox = new Box<>();
		dblBox.setItem(3.14);
		Double d1 = Box.addBox(dblBox);
		System.out.println(d1);
		
//		Box<String> strBox = new Box<>();
//		strBox.setItem("Sakthivel");
//		Double d2 = Box.addBox(strBox);
//		System.out.println(d1);

	}

}
