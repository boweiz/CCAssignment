package cc333;

import java.util.LinkedList;
import java.util.Stack;

public class Solution06 {

	
	public static abstract class Animal {
		
		int order;
		String name;
		Animal(String n) {
			this.name = n;
		}
		
		public void setOrder(int ord) {
			this.order = ord;
		}
		
		public int getOrder(int ord) {
			return this.order;
		}
		
		public boolean isOrderThan(Animal A) {
			return this.order < A.order;
		}
		
	}
	
	public static class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}
	}
	
	public static class Cat extends Animal {
		public Cat(String n) {
			super(n);
			
		}
	}
	
	static LinkedList<Dog> dogs = new LinkedList<>();
	static LinkedList<Cat> cats = new LinkedList<>();
	
	public static class AnimalQueue {
		
		private int order = 0;
		
		public void enqueue(Animal a) {
			a.setOrder(order);
			order++;
			
			// put Animal a either in dogs or cats linkedlists.
			if(a instanceof Dog) dogs.add((Dog)a);
			else if(a instanceof Cat) cats.add((Cat)a);
			
		}				
	}
	
	public static Animal dequeueAny() {
		
		if(dogs.size() == 0) return dequeueDogs();
		else if(cats.size() == 0) return dequeueCats();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		// to find the oldest one to dequeue
		if(dog.isOrderThan(cat)) return dequeueDogs();
		else return dequeueCats();
				
	}
	
	
	public static Dog dequeueDogs() {
		
		// return the first element of the linkedlist, which means the oldest one.
		return dogs.poll();
		
	}
	
	public static Cat dequeueCats() {
		return cats.poll();
	}
	
	public static void main(String[] args)  {
		
		AnimalQueue que = new AnimalQueue();
		que.enqueue(new Dog("dog1"));
		que.enqueue(new Cat("cat2"));
		que.enqueue(new Cat("cat3"));
		que.enqueue(new Dog("dog4"));
	
		System.out.println(dequeueDogs().name);
		System.out.println(dequeueAny().name);
	
		
	}
	
}

// referring to cc150 6th