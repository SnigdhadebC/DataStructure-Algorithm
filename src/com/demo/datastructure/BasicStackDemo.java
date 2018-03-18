package com.demo.datastructure;

public class BasicStackDemo<T> {

	T dataArray[];
	int stackPointer;

	public BasicStackDemo() {
		dataArray = (T[])new Object[1000];
		stackPointer = 0;
	}

	// 1. Push a data to stack
	public void push(T newItem) {
		dataArray[stackPointer++] = newItem;
	}

	// 2. Pop a data from stack
	public T pop() {
		if (stackPointer > 0) {
			return dataArray[--stackPointer];
		} else {
			throw new NullPointerException("The stack is empty and does not contain any value");
		}

	}

	// 3. Contains the value in the stack
	public boolean contains(T value) {
		boolean isAvailable = false;
		for (int i = 0; i < stackPointer; i++) {
			if (dataArray[i].equals(value)) {
				isAvailable = true;
				break;
			}
		}
		return isAvailable;
	}

	// 4. Access Element in the Stack, we need to pop all previous elements
	public T access(T item) {
		while(stackPointer > 0) {
			T tempObject = pop();
			if(item.equals(tempObject)) {
				return tempObject;
			}
		}
		throw new NullPointerException("Could not find item on the stack : "+item);
	}
	

	// 5. Display of data inside stack
	public void display() {
		System.out.println("-----------The data available in stack--------------");
		for (int i = 0; i < stackPointer; i++) {
			System.out.println(dataArray[i]);
		}

	}

	public static void main(String[] args) {
		BasicStackDemo stackDemo = new BasicStackDemo<>();
		// Push
		stackDemo.push(10);
		stackDemo.push(20);
		stackDemo.display();
		// Pop
		System.out.println("The data popped is : " + stackDemo.pop());
		stackDemo.display();
		// Contains
		try {
			System.out.println("Is data available : "+stackDemo.contains(20)); 
			System.out.println("Is data available : "+stackDemo.contains(10));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		 
		//Access
		try {
			System.out.println(stackDemo.access(20));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
}
