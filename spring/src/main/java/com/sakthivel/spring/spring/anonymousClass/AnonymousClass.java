package com.sakthivel.spring.spring.anonymousClass;

public class AnonymousClass {
	
	// Creating an object for interface
	
	public static void main(String[] args) {
		AnonymousInterface interfaceObj = new AnonymousInterface() {
			
			@Override
			public void display() {
				System.out.println("Object created with the intergace reference");
			}
		};
		
		interfaceObj.display();
		System.out.println("Interface object class : " + interfaceObj.getClass().getName());
	}
	

}
