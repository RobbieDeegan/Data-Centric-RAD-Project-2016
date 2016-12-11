package manufacturer;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
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
			return "Manufacturer";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public void delete(Manufacturer m) {
		try {		
			dao.delete(m);
			FacesContext.getCurrentInstance().getExternalContext().redirect("Manufacturer.xhtml");	
		} catch (SQLException e) {	
			FacesMessage msg = new FacesMessage("Error" + e);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
