package dependency;

import org.springframework.stereotype.Component;
//singleton n eager
@Component("test") //mandatory to tell SC , following is a spring bean i.e manage it's life cycle
public class TestTransport implements Transport {
	public TestTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
