package com.sakthivel.spring.spring.enumDemo;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
	
	public static final int PENDING    = 0;
    public static final int PROCESSING = 1;
    public static final int COMPLETED  = 2;
    public static final int FAILED     = 3;

//    public static void processTransaction(int status) {
//        if (status == COMPLETED) {
//            System.out.println("Releasing funds");
//        } else if (status == FAILED) {
//            System.out.println("Alerting customer");
//        } else {
//            System.out.println("Unknown status: " + status);
//        }
//    }
    
    enum TransactionStatus {
        PENDING, PROCESSING, COMPLETED, FAILED
    }

    public static void processTransaction(TransactionStatus status) {
        if (status == TransactionStatus.COMPLETED) {
            System.out.println("Releasing funds");
        } else if (status == TransactionStatus.FAILED) {
            System.out.println("Alerting customer");
        } else {
            System.out.println("Status: " + status);
        }
    }
    
    public static void enumMethods() {
    	 TransactionStatus status = TransactionStatus.COMPLETED;

         System.out.println("name():    " + status.name());
         System.out.println("ordinal(): " + status.ordinal());
         System.out.println("toString(): " + status.toString());

         // proving it's an object
         System.out.println("Class: " + status.getClass().getSimpleName());
         System.out.println("Is Enum: " + status.getClass().isEnum());
	}
    
    enum TransactionStatuses {
        PENDING("Transaction is pending", 102),
        PROCESSING("Transaction is processing", 102),
        COMPLETED("Transaction completed successfully", 200),
        FAILED("Transaction failed", 402);

        private final String description;
        private final int httpCode;

        TransactionStatuses(String description, int httpCode) {
            this.description = description;
            this.httpCode = httpCode;
        }

        public String getDescription() { return description; }
        public int getHttpCode() { return httpCode; }
    }
    
    public static void transactionStatusList() {
    	
//        for (TransactionStatuses status : TransactionStatuses.values()) {
//            System.out.println(status.name() + " | " + status.getDescription() + " | HTTP " + status.getHttpCode());
//        }
        
//        for (TransactionStatuses status : TransactionStatuses.values()) {
//            process(status);
//        }
    	
//    	process(TransactionStatus.PENDING);
        
//      for (TransactionStatus status : TransactionStatus.values()) {
//    	  processArrowFunctions(status);
//	  }
      
      for (Transaction_Status status : Transaction_Status.values()) {
          System.out.print(status.name() + " → ");
          status.handle();
      }
      
    }
    
    public static void process(TransactionStatuses status) {
        switch (status) {
            case PENDING:
                System.out.println("Queuing transaction...");
                break;
            case PROCESSING:
                System.out.println("Waiting for bank response...");
                break;
            case COMPLETED:
                System.out.println("Releasing funds. HTTP " + status.getHttpCode());
                break;
            case FAILED:
                System.out.println("Alerting customer. HTTP " + status.getHttpCode());
                break;
        }
    }
 

    public static void process(TransactionStatus status) {
        switch (status) {
            case PENDING:
                System.out.println("Queuing transaction...");
                // forgot break here
            case PROCESSING:
                System.out.println("Waiting for bank response...");
                break;
            case COMPLETED:
                System.out.println("Releasing funds.");
                break;
            case FAILED:
                System.out.println("Alerting customer.");
                break;
        }
    }
    
    // after java 14 switch
    public static void processArrowFunctions(TransactionStatus status) {
        switch (status) {
            case PENDING    -> System.out.println("Queuing transaction...");
            case PROCESSING -> System.out.println("Waiting for bank response...");
            case COMPLETED  -> System.out.println("Releasing funds.");
            case FAILED     -> System.out.println("Alerting customer.");
        }
    }

    // enum with abstractMethods
    enum Transaction_Status {
        PENDING {
            @Override
            public void handle() {
                System.out.println("Queuing transaction for processing...");
            }
        },
        PROCESSING {
            @Override
            public void handle() {
                System.out.println("Waiting for bank response...");
            }
        },
        COMPLETED {
            @Override
            public void handle() {
                System.out.println("Releasing funds to merchant.");
            }
        },
        FAILED {
            @Override
            public void handle() {
                System.out.println("Alerting customer and reversing charges.");
            }
        };

        public abstract void handle();
    }
    
    
    enum Permission {
        READ, WRITE, DELETE, ADMIN, EXPORT
    }

    public static void enumSet() {
        EnumSet<Permission> userPerms = EnumSet.of(Permission.READ, Permission.WRITE);
        EnumSet<Permission> adminPerms = EnumSet.allOf(Permission.class);
        EnumSet<Permission> readOnly   = EnumSet.of(Permission.READ);
        System.out.println("Class: " + userPerms.getClass().getSimpleName());
        System.out.println("User perms:  " + userPerms);
        System.out.println("Admin perms: " + adminPerms);
        System.out.println("Read only:   " + readOnly);

        System.out.println("Has DELETE?: " + userPerms.contains(Permission.DELETE));
        userPerms.add(Permission.DELETE);
        System.out.println("After add:   " + userPerms);
    }
    
    
    public static void enumSetVsHashSet() {
    	 int iterations = 10_000_000;

         // HashSet
         Set<Permission> hashSet = new HashSet<>();
         hashSet.add(Permission.READ);
         hashSet.add(Permission.WRITE);

         long start1 = System.currentTimeMillis();
         for (int i = 0; i < iterations; i++) {
             hashSet.contains(Permission.DELETE);
         }
         long end1 = System.currentTimeMillis();

         // EnumSet
         EnumSet<Permission> enumSet = EnumSet.of(Permission.READ, Permission.WRITE);

         long start2 = System.currentTimeMillis();
         for (int i = 0; i < iterations; i++) {
             enumSet.contains(Permission.DELETE);
         }
         long end2 = System.currentTimeMillis();

         System.out.println("HashSet  contains: " + (end1 - start1) + "ms");
         System.out.println("EnumSet  contains: " + (end2 - start2) + "ms");
	}

    
    //enum map
    public static void enumMap() {
    	EnumMap<TransactionStatus, Integer> dashboard =  new EnumMap<>(TransactionStatus.class);

        dashboard.put(TransactionStatus.PENDING, 42);
        dashboard.put(TransactionStatus.PROCESSING, 17);
        dashboard.put(TransactionStatus.COMPLETED, 381);
        dashboard.put(TransactionStatus.FAILED, 9);

        System.out.println("Dashboard: " + dashboard);
        System.out.println("Completed: " + dashboard.get(TransactionStatus.COMPLETED));
        System.out.println("Class: " + dashboard.getClass().getSimpleName());

        // iterate in declaration order — always
        for (TransactionStatus status : TransactionStatus.values()) {
            System.out.println(status.name() + " → " + dashboard.get(status));
        }
	}
    
    // didnt work because of permission denial
    public static void enumMapInternals() throws Exception {
    	 EnumMap<TransactionStatus, Integer> map = new EnumMap<>(TransactionStatus.class);

         map.put(TransactionStatus.PENDING, 42);
         map.put(TransactionStatus.COMPLETED, 381);

         // peek inside the private array
         Field valuesField = EnumMap.class.getDeclaredField("vals");
         valuesField.setAccessible(true);
         Object[] vals = (Object[]) valuesField.get(map);

         System.out.println("Internal array length: " + vals.length);
         for (int i = 0; i < vals.length; i++) {
             System.out.println("index " + i + " → " + vals[i]);
         }
	}
    
    public static void enumMapWithNull() {
    	 HashMap<TransactionStatus, Integer> hashMap = new HashMap<>();
         hashMap.put(null, 99);
         System.out.println("HashMap with null key: " + hashMap);

         // EnumMap does not
         EnumMap<TransactionStatus, Integer> enumMap = new EnumMap<>(TransactionStatus.class);
         enumMap.put(null, 99);
         System.out.println("EnumMap with null key: " + enumMap);
	}
    
    // enum lowercase 
    public static void enumCase() {
    	 TransactionStatus s1 = TransactionStatus.valueOf("COMPLETED");
         System.out.println("Correct: " + s1);

         // wrong case — what a client might send
         TransactionStatus s2 = TransactionStatus.valueOf("completed");
         System.out.println("Lowercase: " + s2);
	}
    
	public static void main(String[] args) {
		
//		processTransaction(COMPLETED);  // correct usage
//        processTransaction(99);         // garbage value — compiler says nothing
//        processTransaction(1 + 1);      // equals COMPLETED by accident
		
//		 processTransaction(TransactionStatus.COMPLETED);
//		 processTransaction(99);
//		 processTransaction(1+1);
//		enumMethods();
//		transactionStatusList();
//		enumSet();
//		enumSetVsHashSet();
//		enumMap();
//		try {
//			enumMapInternals();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		enumMapWithNull();
		enumCase();
	}
	
	
}
