package manufacturer;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
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

	public String add(Vehicle g) throws Exception {
		try {
			dao.addVehicle(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
	}

}