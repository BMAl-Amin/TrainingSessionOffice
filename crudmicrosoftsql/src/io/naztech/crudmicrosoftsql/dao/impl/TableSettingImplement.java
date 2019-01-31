package io.naztech.crudmicrosoftsql.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import io.naztech.crudmicrosoftsql.dao.interfaces.TableSettingsInterface;
import io.naztech.crudmicrosoftsql.models.CrudModel;
import io.naztech.crudmicrosoftsql.utils.DBConnection;

public class TableSettingImplement implements TableSettingsInterface {

	CrudModel crudModel= new CrudModel();
	Connection conn=DBConnection.getDbInstance().getConnection();
	String query;
	PreparedStatement statement=null;
	ResultSet rSet=null;
	ArrayList<CrudModel> topRecords= new ArrayList<CrudModel>();
	@Override
	public int createTable(String newTableName) { //create a new table
		query = "create table "+newTableName+"(" 
				+ "id int NOT NULL identity(1,1), " 
						+ "c_name varchar(30), "
						+ "c_salary int, "
						+ "c_country varchar(30), "
						+ "c_zipcode varchar(30), "
						+ "c_salution varchar(30), "
						+ "primary key(id))";
		
		try( PreparedStatement statement = conn.prepareStatement(query)) {
			return statement.executeUpdate(); //return 0 or greater than 0
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	public int deleteTable(String newTableName) { //delete a specific table 
		
		crudModel.setNewTableName(newTableName);
		query=String.format("drop table %s", crudModel.getNewTableName());
		
		try {
			statement=conn.prepareStatement(query);
			
			statement.execute();
			
			statement.close();
			conn.close();
			System.out.println("Successfully deleted");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
}
	@Override
	public boolean deleteValuesOFTable(String newTableName) { //delete all data from selected table
		
		crudModel.setNewTableName(newTableName);
		query=String.format("truncate table %s", crudModel.getNewTableName());
		
		try {
			statement=conn.prepareStatement(query);

			return statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public ArrayList<CrudModel> showTopValueByQuantity(int numberOfRecords) {
		
		crudModel.setNumberOfRecords(numberOfRecords);
		query="select top "+crudModel.getNumberOfRecords()+" * from T_bmemployee";
		
		try {
			statement=conn.prepareStatement(query);
			
			rSet=statement.executeQuery();
			while (rSet.next()) {
				crudModel = new CrudModel();
				crudModel.setId(rSet.getInt(1));
				crudModel.setName(rSet.getString(2));
				crudModel.setSalary(rSet.getDouble(3));
				crudModel.setCauntry(rSet.getString(4));
				crudModel.setZipcode(rSet.getString(5));
				crudModel.setSalution(rSet.getString(6));
				topRecords.add(crudModel);
			}
			return topRecords;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
