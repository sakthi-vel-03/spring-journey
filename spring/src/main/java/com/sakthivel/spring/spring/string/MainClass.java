package com.sakthivel.spring.spring.string;

public class MainClass {
		
	public static void main(String[] args) {
//		string();
//		stringIntern();
//		stringImmutability();
//		StringBuilderDemo();
		StringVsBuilder();
	}
	
	public static void string() {
		
		String a = "hello";
//	    String b = "hello";
		String b = new String("hello");
	    System.out.println("a == b: " + (a == b));
	    System.out.println("a.equals(b): " + (a.equals(b)));
	}
	
    public static void stringIntern() {
        String a = "hello";
        String b = new String("hello");
        String c = b.intern();

        System.out.println("a == b: " + (a == b));
        System.out.println("a == c: " + (a == c));
    }
    
    public static void stringImmutability() {
    	String original = "hello";
        String upper = original.toUpperCase();

        System.out.println("original: " + original);
        System.out.println("upper: " + upper);
        System.out.println("original == upper: " + (original == upper));
    
        System.out.println("original == upper.toLowerCase(): " + (original == upper.toLowerCase()));
        System.out.println("original.toUpperCase() == upper: " + (original.toUpperCase() == upper));
        
        String c = upper.toLowerCase().intern();
        System.out.println("original == upper.toLowerCase() using intern: " + (original == c));
    }
    
        public static void StringBuilderDemo() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                sb.append(i).append(",");
            }

            System.out.println("Result: " + sb.toString());
            System.out.println("Class: " + sb.getClass().getSimpleName());
        }
        
        public static void StringVsBuilder() {
            int iterations = 10000;

            // String concatenation in loop
            long start1 = System.currentTimeMillis();
            String result = "";
            for (int i = 0; i < iterations; i++) {
                result = result + i + ",";
            }
            long end1 = System.currentTimeMillis();

            // StringBuilder
            long start2 = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < iterations; i++) {
                sb.append(i).append(",");
            }
            String result2 = sb.toString();
            long end2 = System.currentTimeMillis();

            System.out.println("String concat:  " + (end1 - start1) + "ms");
            System.out.println("StringBuilder:  " + (end2 - start2) + "ms");
        }
        
        
}
