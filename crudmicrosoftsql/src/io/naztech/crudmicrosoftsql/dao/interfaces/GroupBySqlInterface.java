package io.naztech.crudmicrosoftsql.dao.interfaces;

import java.util.ArrayList;

import io.naztech.crudmicrosoftsql.models.CrudModel;

public interface GroupBySqlInterface {

	public double findMaxValueFromTable();
	public double findMinValueFromTable();
	public int countNumberOfMaxValueFromTable();
	public int countNumberOfMinValueFromTable();
	public ArrayList<CrudModel> orderByPracticeMethod(String orderedField);
}
