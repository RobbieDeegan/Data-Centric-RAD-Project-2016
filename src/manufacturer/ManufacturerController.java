package manufacturer;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ManufacturerController {

	private ArrayList<Manufacturer> manufacturer;
	private DAO dao;

	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Manufacturer> getManufacturer() {
		return manufacturer;
	}

	public void load() throws Exception {
		manufacturer = dao.getManufacturer();
	}

	public String add(Manufacturer m) throws Exception {
		try {
			dao.add(m);
			return "Manufacturer";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String update(Manufacturer m) throws Exception {
		try {
			dao.updateManufacturer(m);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String delete(Manufacturer m) throws Exception {

		try {
			dao.delete(m);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
	}
}
