package com.ltrsoft;

public class RunnableDemo implements Runnable{

	public static void main(String[] args) {
		RunnableDemo rd1=new RunnableDemo();
		Thread t1=new Thread(rd1);
		t1.setName("Akash");
		RunnableDemo rd2=new RunnableDemo();
		Thread t2=new Thread(rd2);
		t2.setName("Santosh");
		t1.start();
		t2.start();
		Thread.currentThread().setName("Sagar");
		for(int i=0;i<5;i++)
		{
			System.out.println("I am in main method"+Thread.currentThread());
		}
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++)
		{
			System.out.println("I am in run method"+Thread.currentThread());
		}
		
	}

}
