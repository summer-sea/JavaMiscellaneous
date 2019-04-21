package com.ztx.test;

public class Hello{
	public static void main(String[] args){
		new People().printPerson();
		new Student().printPerson();

		
	}
}

class Student extends People{
	public String getInfo(){
		return "Student";
	}

}

class People{
	//public String getInfo(){
	private String getInfo(){
		return "Person";
	}
	
	public void printPerson(){
		System.out.println(getInfo());
	}
}