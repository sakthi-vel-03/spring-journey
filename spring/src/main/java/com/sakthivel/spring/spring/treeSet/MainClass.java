package com.sakthivel.spring.spring.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

import com.sun.source.util.Trees;

public class MainClass {
	
    static class Player implements Comparable<Player>{
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + ":" + score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player that = (Player) o;
            return this.name.equals(that.name) && this.score == that.score;
        }

        
		@Override
		public int compareTo(Player o) {
			
			int result = Integer.compare(this.score, o.score);
		    if (result == 0) {
		        return this.name.compareTo(o.name);
		    }
		    return result;
		}
    }

    public static void main(String[] args) {
        TreeSet<Player> leaderboard = new TreeSet<>();
        
        TreeSet<Player> byScore = new TreeSet<Player>(Comparator.comparingInt(p -> p.score));
        TreeSet<Player> byName = new TreeSet<Player>(Comparator.comparing(p -> p.name));

        leaderboard.add(new Player("Alice", 85));
        leaderboard.add(new Player("Bob", 42));
        leaderboard.add(new Player("Charlie", 96));
        
        byScore.add(new Player("Alice", 85));
        byScore.add(new Player("Bob", 42));
        byScore.add(new Player("Charlie", 96));
        
        byName.add(new Player("Alice", 85));
        byName.add(new Player("Bob", 42));
        byName.add(new Player("Charlie", 96));

//        System.out.println(leaderboard);
//        System.out.println("Lowest: " + leaderboard.first());
//        System.out.println("Highest: " + leaderboard.last());
////        
//        System.out.println("By score: " + byScore);
//        System.out.println("By name:  " + byName);
        
//        check();
//          methods();
//        checkFloor();
//        rangeMethods();
        getAndRemove();
    }
    
    public static void check() {
    	
    	TreeSet<Player> leaderboard = new TreeSet<>();

        leaderboard.add(new Player("Alice", 85));
        leaderboard.add(new Player("Bob", 85));   // different name, same score

        System.out.println("Size: " + leaderboard.size());
        System.out.println("Leaderboard: " + leaderboard);
    	
		
	}
    
    public static void methods() {
    	
    	TreeSet<Integer> prices = new TreeSet<>();

        prices.add(120);
        prices.add(340);
        prices.add(480);
        prices.add(500);
        prices.add(550);
        prices.add(890);
        prices.add(1200);

        int budget = 500;

        System.out.println("All prices: " + prices);
        System.out.println("floor(500):   " + prices.floor(500));
        System.out.println("ceiling(500): " + prices.ceiling(500));
        System.out.println("lower(500):   " + prices.lower(500));
        System.out.println("higher(500):  " + prices.higher(500));
        
		
	}
    
    // floor return null whenn there is no previous small element
    public static void checkFloor() {
    	 TreeSet<Integer> prices = new TreeSet<>();

         prices.add(120);
         prices.add(340);
         prices.add(480);

         Integer result = prices.floor(100);
         System.out.println("floor(100): " + result);

         if (result != null) {
             System.out.println("Most expensive within budget: " + result);
         } else {
             System.out.println("No product within budget");
         }
	}
    
    public static void rangeMethods() {
    	TreeSet<Integer> prices = new TreeSet<>();

        prices.add(120);
        prices.add(340);
        prices.add(480);
        prices.add(500);
        prices.add(550);
        prices.add(890);
        prices.add(1200);

        System.out.println("All prices: " + prices);
        System.out.println("headSet(500):        " + prices.headSet(500));
        System.out.println("headSet(500, true):  " + prices.headSet(500, true));
        System.out.println("tailSet(500):        " + prices.tailSet(500));
        System.out.println("tailSet(500, false): " + prices.tailSet(500, false));
        System.out.println("subSet(340, 890):    " + prices.subSet(340, 890));
		
	}
    
    public static void getAndRemove() {
    	
    	TreeSet<Integer> scores = new TreeSet<>();

        scores.add(42);
        scores.add(85);
        scores.add(17);
        scores.add(96);
        scores.add(73);

        System.out.println("Before: " + scores);

        Integer lowest = scores.pollFirst();
        System.out.println("Polled lowest: " + lowest);
        System.out.println("After:  " + scores);

        Integer highest = scores.pollLast();
        System.out.println("Polled highest: " + highest);
        System.out.println("After:  " + scores);
		
	}
}