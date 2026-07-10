package com.sakthivel.spring.spring.generics;

import java.util.ArrayList;
import java.util.List;

public class MainClass {


	public static void main(String[] args) {
//		GenericsPain();
//		TypeErasure();
//		ListSubtype();
//		boundedWildcards();
		LowerBoundedWildcard();
	}
	
	// throwing error in runtime
    public static void GenericsPain() {
    	Boxes box = new Boxes();
        box.set("1");

        Integer value = (Integer) box.get(); // cast to wrong type
        System.out.println(value);
    }
    
    // throwing error in compile time
    public static void Generics() {
		Boxes<String> boxes = new Boxes<String>();
		boxes.set("Hello");
		
//		Integer value = (Integer) boxes.get(); // throws error in compile time 
	}
    
    public static void TypeErasure() {
		List<String> stringList = new ArrayList<String>();
		List<Integer> integerList = new ArrayList<Integer>();
		
		System.out.println("Same Class? : " + (stringList.getClass() == integerList.getClass())); 
		System.out.println("Class name : " + stringList.getClass().getSimpleName()); 
		
		
		// cannot do in run time because of type erasure
		if (stringList instanceof List<String>) {
			// always false
		}
	
	}
    
    // unbounded wild cards
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
//            list.add("Hello"); // throws error 
            list.add(null);
        }
    }
    
    public static void ListSubtype() {
    	List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        printList(names);
        printList(numbers);
    }
    
    // bounded wildcards
    public static double sum(List<? extends Number> list) {
//    	list.add(0.00);
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }
    
    public static void  boundedWildcards() {
    	List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);

        List<Double> doubles = new ArrayList<>();
        doubles.add(1.5);
        doubles.add(2.5);
        doubles.add(3.0);
//        doubles.add(0);
        System.out.println("Sum of ints:    " + sum(ints));
        System.out.println("Sum of doubles: " + sum(doubles));
        
	}
    
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }
    
    public static void LowerBoundedWildcard() {
    	
    	List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        addNumbers(intList);
        addNumbers(numList);
        addNumbers(objList);

        System.out.println("intList: " + intList);
        System.out.println("numList: " + numList);
        System.out.println("objList: " + objList);
	}

}
