package io.naztech.crudmicrosoftsql.dao.interfaces;

import java.util.ArrayList;

import io.naztech.crudmicrosoftsql.models.CrudModel;

public interface CrudDaoInterface {
	
	
	public int insertData(String customerName, double customerSalary, 
			String customerCountry, String customerZipcode, String salution);
	
	public int editData(int customerId,String fieldName,String newDataForCustomerId);
	
	public int deleteRecord(String customerName);
	
	public CrudModel showRecord(int customerId);
	
	public ArrayList<CrudModel> showAll();
	
	public String foundSalaryMax();
	
	
}
