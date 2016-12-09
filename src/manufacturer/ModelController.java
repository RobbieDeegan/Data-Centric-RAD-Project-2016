package manufacturer;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ModelController {

	private ArrayList<Model> model;
	private DAO dao;

	public ModelController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Model> getModel() {
		return model;
	}

	public void load() throws Exception {
		model = dao.getModel();
	}

	public String add(Model m) throws Exception {
		try {
			dao.addModel(m);
			return "Model";
		} catch (Exception e) {
			return e.toString();
		}
	}
}
