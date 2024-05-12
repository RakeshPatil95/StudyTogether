package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// =new HttpTransport();// dependency

	// constr based D.I
	public ATMImpl(Transport t123456) {
		this.myTransport = t123456;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);// not null
	}

//B.L methods
	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj(ATMImpl) invoking a method of dependency (transport layer) to
										// inform underlying bank

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	// init style method
	public void anyInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// destroy style method
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
