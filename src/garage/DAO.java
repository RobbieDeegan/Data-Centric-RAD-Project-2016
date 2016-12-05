package garage;

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

	// Delete functions for separate classes
	// Delete a Manufacturer of cars
	public void delete(Manufacturer g) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from manufacturer where manu_code ='" + g.getCode() + "' and manu_name ='" + g.getName() + "' and manu_details ='" + g.getDetails() + "'");

		stmt.executeUpdate();
	} // delete
	
	// Delete a model of car
	public void deleteModel(Model g) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from model where manu_code ='" + g.getManCode() + "' and model_code ='" + g.getCarCode() + "' and model_name ='" + g.getName() + "' and model_desc ='"+ g.getDescribtion() + "'");

		stmt.executeUpdate();
	} // end deleteModel
	
	// Delete a unique vehicle from the database
	public void deleteVehicle(Vehicle g) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		//PreparedStatement stmt = conn.prepareStatement("delete from vehicle where manu_code ='" + g.getManCode() + "' and model_code ='" + g.getCarCode() + "' and model_name ='" + g.getName() + "' and model_desc ='"+ g.getDescribtion() + "'");

		//stmt.executeUpdate();
		
	} // end deleteVehicle

	// Update functions for the separate classes
	// Update Details of a car manufacturer
	public void update(Manufacturer g) throws SQLException {
	 
		 Connection conn = mysqlDS.getConnection(); 
		 PreparedStatement myStmt = conn.prepareStatement("update manufacturer set manu_code='" + g.getCode() + "', manu_name ='" + g.getName() + "'");
		 
		 myStmt.setString(1, g.getCode()); 
		 myStmt.setString(2, g.getName());
		 myStmt.executeUpdate();
	} // end update

	// Update a model if car
	public void updateModel(Model g) throws SQLException {
		 
		 Connection conn = mysqlDS.getConnection(); 
		 PreparedStatement myStmt = conn.prepareStatement("update manufacturer set manu_code='" + g.getManCode() + "', manu_name ='" + g.getName() + "'");
		 
		 myStmt.setString(1, g.getManCode()); 
		 myStmt.setString(2, g.getName());
		 myStmt.executeUpdate(); 
		 
	} // end updateModel
	
	// Update the details of a unique vehicle
	public void updateVehicle(Vehicle g) throws SQLException {
		 
		 Connection conn = mysqlDS.getConnection(); 
		 /*PreparedStatement myStmt = conn.prepareStatement("update manufacturer set manu_code='" + g.getManCode() + "', manu_name ='" + g.getName() + "'");
		 
	
		 myStmt.setString(1, g.getManCode()); 
		 myStmt.setString(2, g.getName());
		 myStmt.executeUpdate(); */
		 
	} // end updateVehicle

	// Functions to add to the database
	// Add a Manufacturer
	public void add(Manufacturer g) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO manufacturer values(?, ?, ?)");

		stmt.setString(1, g.getCode());
		stmt.setString(2, g.getName());
		stmt.setString(3, g.getDetails());
		

		stmt.executeUpdate();
		
	} // end add
	
	// Add a new model of vehicle 
	public void addModel(Model g) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO model values(?, ?, ?, ?)");

		stmt.setString(1, g.getManCode());
		stmt.setString(2, g.getCarCode());
		stmt.setString(3, g.getName());
		stmt.setString(4, g.getDescribtion());

		stmt.executeUpdate();
		
	} // end addModel
	
	// Add a unique vehicle to the database
	public void addVehicle(Vehicle g) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO model values(?, ?, ?, ?, ?, ?, ?)");

		stmt.setString(1, g.getReg());
		stmt.setString(2, g.getManu_code());
		stmt.setString(3, g.getModel_code());
		stmt.setInt(4, g.getMileage());
		stmt.setFloat(5, g.getPrice());
		stmt.setString(6, g.getColour());
		stmt.setString(7, g.getFuel());

		stmt.executeUpdate(); 
		
	} // end addVehicle

	// Generating ArrayLists to display the required information
	// Manufacturer Lists
	public ArrayList<Manufacturer> getManufacturer() throws Exception {

		ArrayList<Manufacturer> garage = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from manufacturer");

		ResultSet result = myStmt.executeQuery();

		while (result.next()) {

			String code = result.getString("manu_code");
			String name = result.getString("manu_name");
			String details = result.getString("manu_details");

			garage.add(new Manufacturer(code, name, details));
		}

		return garage;
	} // end getManufacturer
	
	// Vehicle Model lists
	public ArrayList<Model> getModel() throws Exception {

		ArrayList<Model> garage = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from model");

		ResultSet result = myStmt.executeQuery();

		while (result.next()) {

			String manCode = result.getString("manu_code");
			String carCode = result.getString("model_code");
			String name = result.getString("model_name");
			String describtion = result.getString("model_desc");

			garage.add(new Model(manCode, carCode , name, describtion));
		}

		return garage;
	} // end getModel
	
	// Generate the details of a vehicle to a list
	public ArrayList<Vehicle> getVehicle() throws Exception {

		ArrayList<Vehicle> garage = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from vehicle");

		ResultSet result = myStmt.executeQuery();

		while (result.next()) {

			String reg = result.getString("reg");
			String manu_code = result.getString("manu_code");
			String model_code = result.getString("model_code");
			int mileage = result.getInt("mileage");
			float price = result.getFloat("price");
			String colour = result.getString("colour");
			String fuel = result.getString("fuel");

			garage.add(new Vehicle(reg, manu_code, model_code, mileage, price, colour, fuel));
		}

		return garage;
	} // end getVehicle
}