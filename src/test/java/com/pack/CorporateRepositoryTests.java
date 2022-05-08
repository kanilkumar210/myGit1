package com.pack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pack.model.Corporate;
import com.pack.repository.CorporateRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CorporateRepositoryTests {

	@Autowired
	CorporateRepository corRepository;

	static Corporate corporate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corporate = new Corporate("virtusa", "Hyderabad", "9876567889", true, 1);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corporate = null;
	}

	@Test
	public void saveCorporateTests() {
		Corporate corObj = corRepository.save(corporate);
		Assertions.assertEquals(corObj.getCorporate_id(), corporate.getCorporate_id());
	}

	@Test
	public void findByCorporateId() {
		Corporate obj = corRepository.findById(corporate.getCorporate_id()).get();
		Assertions.assertEquals(obj.getCorporate_id(), corporate.getCorporate_id());
	}

	@Test
	public void deleteCorporate() {
		Corporate obj = corRepository.findById(corporate.getCorporate_id()).get();
		obj.setActive(false);
		Corporate obj2 = corRepository.save(obj);
		Assertions.assertFalse(obj2.isActive());
	}

}
