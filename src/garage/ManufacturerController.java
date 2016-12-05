package garage;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ManufacturerController {

	private ArrayList<Manufacturer> garage;
	private DAO dao;

	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Manufacturer> getGarage() {
		return garage;
	}

	public void load() throws Exception {
		garage = dao.getManufacturer();
	}

	public String add(Manufacturer g) throws Exception {
		try {
			dao.add(g);
			return "Manufacturer";
		} catch (Exception e) {
			return e.toString();
		}

	}

	public String update(Manufacturer g) throws Exception {
		try {
			dao.update(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String delete(Manufacturer g) throws Exception {

		try {
			dao.delete(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}

	}
}
