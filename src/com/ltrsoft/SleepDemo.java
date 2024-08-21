package com.ltrsoft;

public class SleepDemo extends Thread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SleepDemo s1=new SleepDemo();
		SleepDemo s2=new SleepDemo();
		s1.setDaemon(true);
		s1.start();
		s2.start();
		for(int i=0;i<5;i++)
		{
			sleep(2000);
			System.out.println("I am in main method"+Thread.currentThread());
		}
	}
	public void run() {
		for(int i=0;i<5;i++)
		{
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("I am in run method"+Thread.currentThread());
		}
		
	}
}
