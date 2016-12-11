package manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.*;
import javax.sql.DataSource;

public class DAO {
	
	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	// Delete a Manufacturer of cars
	public void delete(Manufacturer m) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("delete from manufacturer where manu_code ='" + m.getCode() + "' and manu_name ='" + m.getName() + "' and manu_details ='" + m.getDetails() + "'");

		statement.executeUpdate();
	} // delete

	// Update Details of a car manufacturer
	public void updateManufacturer(Manufacturer m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("update manufacturer set manu_code = ?, manu_name = ?, manu_details = ? where manu_code = ?");
		
		statement.setString(1, m.getCode());
		statement.setString(2, m.getName());
		statement.setString(3, m.getDetails());
		statement.setString(4, m.getCode());
		
		statement.executeUpdate();
	} // end update

	// Functions to add to the database
	// Add a Manufacturer
	public void add(Manufacturer m) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("INSERT INTO manufacturer values(?, ?, ?)");

		statement.setString(1, m.getCode());
		statement.setString(2, m.getName());
		statement.setString(3, m.getDetails());
		
		statement.executeUpdate();
		
	} // end add
	
	// Add a new model of vehicle 
	public void addModel(Model m) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("INSERT INTO model values(?, ?, ?, ?)");

		statement.setString(1, m.getManCode());
		statement.setString(2, m.getCarCode());
		statement.setString(3, m.getName());
		statement.setString(4, m.getDescribtion());

		statement.executeUpdate();
		
	} // end addModel
	
	// Add a unique vehicle to the database
	public void addVehicle(Vehicle v) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement satement = conn.prepareStatement("INSERT INTO vehicle values(?, ?, ?, ?, ?, ?, ?)");

		satement.setString(1, v.getReg());
		satement.setString(2, v.getManu_code());
		satement.setString(3, v.getModel_code());
		satement.setInt(4, v.getMileage());
		satement.setFloat(5, v.getPrice());
		satement.setString(6, v.getColour());
		satement.setString(7, v.getFuel());

		satement.executeUpdate(); 
		
	} // end addVehicle

	// Generating ArrayLists to display the required information
	// Manufacturer Lists
	public ArrayList<Manufacturer> getManufacturer() throws Exception {

		ArrayList<Manufacturer> manufacturer = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from manufacturer");

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			String code = result.getString("manu_code");
			String name = result.getString("manu_name");
			String details = result.getString("manu_details");

			manufacturer.add(new Manufacturer(code, name, details));
		}

		return manufacturer;
	} // end getManufacturer
	
	// Vehicle Model lists
	public ArrayList<Model> getModel() throws Exception {

		ArrayList<Model> model = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from model");

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			String manCode = result.getString("manu_code");
			String carCode = result.getString("model_code");
			String name = result.getString("model_name");
			String describtion = result.getString("model_desc");

			model.add(new Model(manCode, carCode, name, describtion));
		}

		return model;
	} // end getModel
	
	// Generate the details of a vehicle to a list
	public ArrayList<Vehicle> getVehicle() throws Exception {

		ArrayList<Vehicle> vehicle = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from vehicle");

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			String reg = result.getString("reg");
			String manu_code = result.getString("manu_code");
			String model_code = result.getString("model_code");
			int mileage = result.getInt("mileage");
			float price = result.getFloat("price");
			String colour = result.getString("colour");
			String fuel = result.getString("fuel");

			vehicle.add(new Vehicle(reg, manu_code, model_code, mileage, price, colour, fuel));
		}

		return vehicle;
	} // end getVehicle
	
	// Generate the details of a vehicle to a list
	public ArrayList<Vehicle> getVehicleDetails(Vehicle v) throws SQLException {

		ArrayList<Vehicle> vehicle = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from vehicle where reg = ?");

		ResultSet result = statement.executeQuery();

		statement.setString(1, v.getReg());
		String reg = result.getString("reg");
		String manu_code = result.getString("manu_code");
		String model_code = result.getString("model_code");
		int mileage = result.getInt("mileage");
		float price = result.getFloat("price");
		String colour = result.getString("colour");
		String fuel = result.getString("fuel");
		
		vehicle.add(new Vehicle(reg, manu_code, model_code, mileage, price, colour, fuel));
		
		return vehicle;
		
	} // end getVehicle
}