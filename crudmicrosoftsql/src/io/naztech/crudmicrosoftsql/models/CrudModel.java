package io.naztech.crudmicrosoftsql.models;

public class CrudModel {

	private int id;
	private String name;
	private double salary;
	private String cauntry;
	private String cityName;
	private String zipcode;
	private String fieldName;
	private String salution;
	private String tableName;
	private String newDataForCustomerId;
	private String newTableName;
	private double maxValue;
	private double minValue;
	private int countMax;
	private int countMin;
	private int numberOfRecords;
	private String orderedField;
	
	//setters
	
	public void setCountMax(int countMax) {
		this.countMax = countMax;
	}
	public void setOrderedField(String orderedField) {
		this.orderedField = orderedField;
	}
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}
	public void setCountMin(int countMin) {
		this.countMin = countMin;
	}
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}
	public void setTableName(String tableName) {
		this.tableName=tableName;
	}
	public void setSalution(String salution) {
		this.salution=salution;
	}
	public void setNewTableName(String newTableName) {
		this.newTableName=newTableName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setCauntry(String cauntry) {
		this.cauntry = cauntry;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setFieldName(String fieldName) {
		this.fieldName=fieldName;
	}
	public void setNewDataForCustomerId(String newDataForCustomerId) {
		this.newDataForCustomerId = newDataForCustomerId;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public String getCauntry() {
		return cauntry;
	}
	public String getCityName() {
		return cityName;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getNewDataForCustomerId() {
		return newDataForCustomerId;
	}
	public String getNewTableName() {
		return newTableName;
	}
	public String getSalution() {
		return salution;
	}
	public String getTableName() {
		return tableName;
	}
	public double getMaxValue() {
		return maxValue;
	}
	public double getMinValue() {
		return minValue;
	}
	
	public int getCountMax() {
		return countMax;
	}
	public int getCountMin() {
		return countMin;
	}
	public int getNumberOfRecords() {
		return numberOfRecords;
	}
	
	public String getOrderedField() {
		return orderedField;
	}
	@Override
	public String toString() {
		return "CrudModel [id=" + id + ", name=" + salution+" "+name + ", "
				+ "salary=" + salary + ", cauntry=" + cauntry + ", "
						+ "zipcode=" + zipcode + "]";
	}
	
	
}
