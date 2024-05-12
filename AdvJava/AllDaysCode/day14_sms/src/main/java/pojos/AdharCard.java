package pojos;

import java.time.LocalDate;
import javax.persistence.*;

//card number , creation date , location
@Embeddable // MANDATORY anno : To tell hibernate , that follo. class DOES NOT separate identity , BUT will
			// be embedded in the owning entity
public class AdharCard {
	@Column(length = 20,unique = true,name="card_no")
	private String cardNo;
	@Column(name ="created_on")
	private LocalDate createdOn;
	@Column(length = 20)
	private String location;

	public AdharCard() {
		// TODO Auto-generated constructor stub
	}

	public AdharCard(String cardNo, LocalDate createdOn, String location) {
		super();
		this.cardNo = cardNo;
		this.createdOn = createdOn;
		this.location = location;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AdharCard [cardNo=" + cardNo + ", createdOn=" + createdOn + ", location=" + location + "]";
	}

}
