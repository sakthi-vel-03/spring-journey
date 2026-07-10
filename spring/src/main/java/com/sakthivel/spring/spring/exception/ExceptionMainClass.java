package com.sakthivel.spring.spring.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionMainClass {
	
	public static void main(String[] args) {
//		checkedPain();
		 UncheckedPain();
	}
	
	public static void checkedPain() {
		try {
	    FileReader reader = new FileReader("transactions.txt");
	    System.out.println("File opened");
		} catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
	}
	
    public static void UncheckedPain() {
        String value = null;
        System.out.println(value.length());
    }

}
