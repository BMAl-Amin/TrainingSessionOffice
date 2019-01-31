package test.io.naztech.crudmicrosoftsql.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.naztech.crudmicrosoftsql.dao.impl.CrudDaoImplement;
import io.naztech.crudmicrosoftsql.dao.interfaces.CrudDaoInterface;
import io.naztech.crudmicrosoftsql.models.CrudModel;

class CrudDaoImplementTest {

	@Test
	void testInsertData() {
		CrudDaoInterface crudDaoInterface = new CrudDaoImplement();
		
		assertTrue(crudDaoInterface.insertData("Rumi", 45000, "Indonesia", "Z2345", "Mr.")>0);
	}

	@Test
	void testEditData() {
		CrudDaoInterface crudDaoInterface = new CrudDaoImplement();
		
		assertTrue(crudDaoInterface.editData(2, "c_salary", "98760")>0);
	}

	@Test
	void testDeleteRecord() {
		CrudDaoInterface crudDaoInterface = new CrudDaoImplement();
		
		assertTrue(crudDaoInterface.deleteRecord("Rumi")>0);
	}

	@Test
	void testShowRecord() {
		CrudDaoInterface crudDaoInterface= new CrudDaoImplement();
		
		assertTrue(crudDaoInterface.showRecord(3).getName().equals("Sekh"));
	}

	@Test
	void testShowAll()throws Exception {
		CrudDaoInterface crudDaoInterface= new CrudDaoImplement();
		int customerId=1;
       
		for(CrudModel crudModel : crudDaoInterface.showAll()) {
			assertTrue(crudModel.getId()==customerId);
			customerId++;
			if(customerId == 8)
				customerId=11;
		}
	}

}
