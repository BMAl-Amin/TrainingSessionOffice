package io.naztech.crudmicrosoftsql.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import io.naztech.crudmicrosoftsql.dao.interfaces.GroupBySqlInterface;
import io.naztech.crudmicrosoftsql.models.CrudModel;
import io.naztech.crudmicrosoftsql.utils.DBConnection;


public class GroupBySqlImplement implements GroupBySqlInterface{

	Connection conn=DBConnection.getDbInstance().getConnection();
	CrudModel crudModel= new CrudModel();
	String query=null;
	PreparedStatement statement=null;
	ResultSet rSet=null;
	ArrayList<CrudModel> orderedRecords= new ArrayList<CrudModel>();
	
	@Override
	public double findMaxValueFromTable() {

		query="select c_name, max(c_salary) as maxsalary from T_bmemployee";
		try {
			statement=conn.prepareStatement(query);
			
			rSet= statement.executeQuery();
			
			rSet.next();
			crudModel.setMaxValue(rSet.getDouble("maxsalary"));
			
			return crudModel.getMaxValue();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}	
	}

	@Override
	public double findMinValueFromTable() {
		query="select min(c_salary) as minsalary from T_bmemployee";
		try {
			statement=conn.prepareStatement(query);
			
			rSet= statement.executeQuery();
			
			rSet.next();
			crudModel.setMinValue(rSet.getDouble("minsalary"));
			
			return crudModel.getMinValue();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}	
	}

	@Override
	public int countNumberOfMaxValueFromTable() {
		
		query= "select count(c_salary) as countmax from T_bmemployee where c_salary="+crudModel.getMaxValue();
		
		try {
			statement=conn.prepareStatement(query);
			
			rSet=statement.executeQuery();
			
			rSet.next();
			crudModel.setCountMax(rSet.getInt("countmax"));
			
			return crudModel.getCountMax();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int countNumberOfMinValueFromTable() {
		query= "select count(c_salary) as countmin from T_bmemployee where "
				+ "c_salary="+crudModel.getMinValue();
		
		try {
			statement=conn.prepareStatement(query);
			
			rSet=statement.executeQuery();
			
			rSet.next();
			crudModel.setCountMin(rSet.getInt("countmin"));
			
			return crudModel.getCountMin();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public ArrayList<CrudModel> orderByPracticeMethod(String orderedField) {
		
		crudModel.setOrderedField(orderedField);
		query= "select * from T_bmemployee order by " + crudModel.getOrderedField()+" desc";
		
		try {
			statement= conn.prepareStatement(query);
			rSet=statement.executeQuery();
			while(rSet.next()) {
				crudModel = new CrudModel();
				crudModel.setId(rSet.getInt(1));
				crudModel.setName(rSet.getString(2));
				crudModel.setSalary(rSet.getDouble(3));
				crudModel.setCauntry(rSet.getString(4));
				crudModel.setZipcode(rSet.getString(5));
				crudModel.setSalution(rSet.getString(6));
				orderedRecords.add(crudModel);
			}
			return orderedRecords;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
