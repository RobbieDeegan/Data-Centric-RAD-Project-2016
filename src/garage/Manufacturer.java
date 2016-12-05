package garage;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Manufacturer {

	private String code;
	private String name;
	public String details;

	public Manufacturer() {
	}

	public Manufacturer(String code, String name, String details) {
		super();
		this.code = code;
		this.name = name;
		this.details = details;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}