package com.sakthivel.spring.spring.test;

public class Student implements Comparable<Student>{
	
	private String name;
	private int rollNumber;
	
	public Student(String name, int rollNumber) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
	}

	@Override
	public int compareTo(Student o) {
		return this.rollNumber - o.rollNumber ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNumber=" + rollNumber + "]";
	}

}
