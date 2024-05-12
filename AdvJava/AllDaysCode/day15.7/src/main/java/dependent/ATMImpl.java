package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;

//Singleton n eager, with id=my_atm
@Component("my_atm")
public class ATMImpl implements ATM {
	@Autowired//(required = false)//autowire=byType
	@Qualifier("httpTransport") // autowire=byName , SC tries to look for a bean with id=httpTransport123
	private Transport myTransport;// =new HttpTransport();// dependency

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
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
	@PostConstruct
	public void anyInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// destroy style method
	@PreDestroy
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
