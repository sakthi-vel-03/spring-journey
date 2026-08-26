package com.sakthivel.spring.spring.thread;

import java.util.concurrent.*;

public class FutureDemo {

    public static void successCase() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(1000); // simulate work
            return 42;
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("Task submitted. Main is free to do other work now.");

        Integer result = future.get(); // BLOCKS here until task finishes
        System.out.println("Result received: " + result);

        executor.shutdown();
    }

    public static void failureCase() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(500);
            throw new ArithmeticException("Simulated divide by zero inside worker task");
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("Task submitted (will fail).");
//        Integer result = future.get();
        try {
            Integer result = future.get(); // this is where the exception surfaces
            System.out.println("Result: " + result); // never reached
        } catch (ExecutionException e) {
            System.out.println("Caught ExecutionException in main thread!");
            System.out.println("Original exception type: " + e.getCause().getClass().getSimpleName());
            System.out.println("Original exception message: " + e.getCause().getMessage());
        }

        executor.shutdown();
    }
    
    
	public static void computeNumbers() throws InterruptedException {
		
    	ExecutorService ex = Executors.newFixedThreadPool(1);
    	
    	Future<Integer> num = ex.submit(() -> {
    		System.out.println("Worker Thread is starting to compute");
    		int count = 0;
    		long start = System.currentTimeMillis();
    		while(System.currentTimeMillis() - start < 1000) {
    			count++;
    		}
    		System.out.println("Worker Thread is finished");
    		return count;
    	});
//    	Thread.sleep(1500);
    	try {
			System.out.println(num.get()*2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
    	
    	ex.shutdown();
	}
	
	// Compute Numbers Without Blocked
	    public static void computeNumbers2() {
	        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
	            System.out.println("Inside Worker Thread");
	            try { Thread.sleep(5000); } catch (InterruptedException e) {}
	            System.out.println("Worker Thread Finished...");
	            return 42;
	        });

	        CompletableFuture<Integer> ccf = cf.thenApply((i) -> {
	            System.out.println("the incremented value is " + i);
	            return i * 2;
	        }).exceptionally((t) -> {
	            return 0;
	        });

//	        ccf = cf.exceptionally((Throwable)-> {
//	        	return 0; 
//	        });
//	        		
	        System.out.println("Main Thread Continues to work..");
	        try {
				Integer count =  ccf.get();
				System.out.println("count is : "+ count);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
	    }
	    
	// Computing with async inside then apply 
	    public static void MultiAsync() {
			
	    	CompletableFuture<Integer> i = CompletableFuture.supplyAsync(()->{
	    		System.out.println("Fetching User Id...");
	    		return 001;
	    	});
	    	
	    	CompletableFuture<String> s = i.thenComposeAsync((id)->{
	    		System.out.println("Fetching User User details...");
	    		return CompletableFuture.supplyAsync(()->{
	    			return "User"+id;
	    		});
	    		
//	    		 userDetails;
	    	});
	    	
	    	System.out.println("Main Thread Continues the Execution");
	    	
	        try {
				Object user = s.get();
				System.out.println("User Name is "+user);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
	    	
		}
	    
	    public static void parallelAsync() {
			
	    	CompletableFuture<String> name = CompletableFuture.supplyAsync(()->{
	    		return "Sakthivel";
	    	});

	    	CompletableFuture<Integer> age = CompletableFuture.supplyAsync(()->{
	    		return 22;
	    	});
	    	
	    	CompletableFuture<String> sentence = name.thenCombine(age, (strName,StrAge)->{
	    		return strName+" age is "+StrAge;
	    	});
	    	
	    	try {
				String stmt = sentence.get();
				System.out.println(stmt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		}
	    
	    // more than 2 sync
	    public static void parallelAsync2() {
			
	    	CompletableFuture<String> name = CompletableFuture.supplyAsync(()->{
	    		try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		return "Sakthivel";
	    	});
	    	CompletableFuture<Integer> age = CompletableFuture.supplyAsync(()->{
	    		try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		return 22;
	    	});
	    	CompletableFuture<String> city = CompletableFuture.supplyAsync(()->{
	    		try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		return "Chennai";
	    	});
	    	
	    	CompletableFuture<String> strname = name.thenCombine(age,(strName,StrAge)->{
	    		return strName+" is "+ StrAge;
	    	}).thenCombine(city,(strnameWithAge,strCity)->{
	    		return strnameWithAge+ " from "+strCity;
	    	});
	    	
	    	CompletableFuture<Void> allvalues = CompletableFuture.allOf(name,age, city);
	    	CompletableFuture<Object> anyvalue = CompletableFuture.anyOf(name,age, city);
	    	
	    	try {
	    		
//				String stmt = strname.get();
//				System.out.println(stmt);
	    		
//	    		allvalues.get();
//	    		String strName = name.get();
//	    		Integer strAge = age.get();
//	    		String strCity = city.get();
//	    		System.out.println(strName + " is "+strAge+" from "+strCity);
	    		
	    		Object obj = anyvalue.get();
	    		System.out.println(obj);
	    		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		}

    public static void main(String[] args) throws Exception {
//        System.out.println("=== SUCCESS CASE ===");
//        successCase();
//
//        System.out.println();
//        System.out.println("=== FAILURE CASE ===");
//        failureCase();
//    	  computeNumbers();
//    	 computeNumbers2();
//	     System.out.println("main() has reached its final line and is returning now.");
//    	 MultiAsync();
//    	parallelAsync();
    	parallelAsync2();
    }
}