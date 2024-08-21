package com.ltrsoft;
class Wallet
{
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Wallet(int balance) {
		
		this.balance = balance;
	}
	public  synchronized void withdraw(int amount) 
	{
		System.out.println("Withdraw proccess started..");
		if(amount>balance)
		{
			System.out.println("You have insufficent balance in your account");
			System.out.println("please deposite some amount in your account.");
			System.out.println("deposite amount is"+(amount-balance)+" Rs.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.balance-=amount;		
		System.out.println("Withdraw proccess completed..");
		System.out.println("Your current balnce is "+balance+" Rs.");
		
	}
	public synchronized void deposite(int amount)
	{
		System.out.println("Deposite proccess started..");
		this.balance+=amount;
		System.out.println("you have successfully deposted amount in your account");
		System.out.println("Your current balnce is "+balance+" Rs.");
		notify();
	}
}
class MyThread1 extends Thread
{
	private Wallet w;

	public MyThread1(Wallet w) {

		this.w = w;
	}
	public void run()
	{
		
			w.withdraw(2000);
	
	}
	
}
class MyThread2 extends Thread
{
	private Wallet w;

	public MyThread2(Wallet w) {
		
		this.w = w;
	}
	public void run()
	{
		
			w.deposite(2000);
		
	}
	
}
public class ThreadDemo {

	public static void main(String[] args) {
		Wallet w =new Wallet(500);
		MyThread1 t1=new MyThread1(w);
		MyThread2 t2=new MyThread2(w);
		t1.start();
		t2.start();
	}

}
