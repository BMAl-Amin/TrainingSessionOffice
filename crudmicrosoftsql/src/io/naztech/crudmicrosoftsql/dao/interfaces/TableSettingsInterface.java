package io.naztech.crudmicrosoftsql.dao.interfaces;

import java.util.ArrayList;

import io.naztech.crudmicrosoftsql.models.CrudModel;

public interface TableSettingsInterface {

	public int createTable(String newTableName);
	
	public int deleteTable(String newTableName);
	
	public boolean deleteValuesOFTable(String newTableName);
	
	public ArrayList<CrudModel> showTopValueByQuantity(int numberOfRecords);
}
