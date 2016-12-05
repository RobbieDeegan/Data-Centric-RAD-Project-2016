package garage;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Model{

	private String manCode;
	private String carCode;
	private String name;
	public String describtion;

	public Model() {
	}

	public Model(String manCode, String carCode, String name, String describtion) {
		super();
		this.manCode = manCode;
		this.carCode = carCode;
		this.name = name;
		this.describtion = describtion;
	}

	public String getManCode() {
		return manCode;
	}

	public void setManCode(String manCode) {
		this.manCode = manCode;
	}
	
	public String getCarCode() {
		return manCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

}