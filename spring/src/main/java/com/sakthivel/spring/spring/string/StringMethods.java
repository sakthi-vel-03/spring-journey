package com.sakthivel.spring.spring.string;

public class StringMethods {

	public static void main(String[] args) {
		StringCompareTo();
//		StringValueOf();
//		StringFormat();
	}
	
    public static void StringCompareTo() {
        String a = "apple";
        String b = "banana";
        String c = "apple";
        String d = "app";

        System.out.println("apple vs banana: " + a.compareTo(b));
        System.out.println("apple vs apple:  " + a.compareTo(c));
        System.out.println("apple vs app:    " + a.compareTo(d));
        System.out.println("banana vs apple: " + b.compareTo(a));
        System.out.println("banana vs apple: " + a.compareTo(null));
        
    }
    
    public static void StringValueOf() {
        int amount = 1500;
        double rate = 0.18;
        boolean success = true;
        char code = 'T';
        Object obj = null;

        System.out.println(String.valueOf(amount));
        System.out.println(String.valueOf(rate));
        System.out.println(String.valueOf(success));
        System.out.println(String.valueOf(code));
        System.out.println(String.valueOf(obj));

        // prove null safety
        String s = null;
        System.out.println(String.valueOf(s));
    }
    
    public static void StringFormat() {
        int id = 10042;
        double amount = 1500.0;
        String status = "COMPLETED";
        boolean success = true;

        String receipt = String.format(
            "Transaction ID: %d%n" +
            "Amount:         Rs. %.2f%n" +
            "Status:         %s%n" +
            "Success:        %b",
            id, amount, status, success
        );

        System.out.println(receipt);
    }

}
