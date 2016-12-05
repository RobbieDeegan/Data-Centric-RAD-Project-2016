package garage;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ModelController {

	private ArrayList<Model> garage;
	private DAO dao;

	public ModelController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Model> getGarage() {
		return garage;
	}

	public void load() throws Exception {
		garage = dao.getModel();
	}

	public String add(Model g) throws Exception {
		try {
			dao.addModel(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}

	}

	public String update(Model g) throws Exception {
		try {
			dao.updateModel(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String delete(Model g) throws Exception {

		try {
			dao.deleteModel(g);
			return "helloOutput";
		} catch (Exception e) {
			return e.toString();
		}

	}
}
