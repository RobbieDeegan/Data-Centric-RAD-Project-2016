package manufacturer;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class VehicleController {

	private ArrayList<Vehicle> vehicle;
	private DAO dao;

	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Vehicle> getVehicle() {
		return vehicle;
	}

	public void load() throws Exception {
		vehicle = dao.getVehicle();
	}
	
	public void loadDetails(Vehicle v) throws Exception {
		vehicle = dao.getVehicleDetails(v);
	}

	public String add(Vehicle v) throws Exception {
		try {
			dao.addVehicle(v);
			return "Vehicle";
		} catch (Exception e) {
			return e.toString();
		}
	}
}
