package pojos;

//type (enum), year , % marks
import javax.persistence.*;

@Embeddable
public class EducationalQualification {
	@Enumerated(EnumType.STRING)
	@Column(name = "edu_type", length = 20)
	private EduType type;
	private int year;
	@Column(name = "marks")
	private double percentageMarks;

	public EducationalQualification() {
		// TODO Auto-generated constructor stub
	}

	public EducationalQualification(EduType type, int year, double percentageMarks) {
		super();
		this.type = type;
		this.year = year;
		this.percentageMarks = percentageMarks;
	}

	public EduType getType() {
		return type;
	}

	public void setType(EduType type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPercentageMarks() {
		return percentageMarks;
	}

	public void setPercentageMarks(double percentageMarks) {
		this.percentageMarks = percentageMarks;
	}

	@Override
	public String toString() {
		return "EducationalQualification [type=" + type + ", year=" + year + ", percentageMarks=" + percentageMarks
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EducationalQualification other = (EducationalQualification) obj;
		if (type != other.type)
			return false;
		return true;
	}
	

}
