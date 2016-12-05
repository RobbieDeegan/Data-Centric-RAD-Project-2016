package garage;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class VehicleController {

	private ArrayList<Vehicle> garage;
	private DAO dao;

	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Vehicle> getGarage() {
		return garage;
	}

	public void load() throws Exception {
		garage = dao.getVehicle();
	}

	public String add(Vehicle g) throws Exception {
		try {
			dao.addVehicle(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}

	}

	public String update(Vehicle g) throws Exception {
		try {
			dao.updateVehicle(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String delete(Vehicle g) throws Exception {

		try {
			dao.deleteVehicle(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}

	}
}
