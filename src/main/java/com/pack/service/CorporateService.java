package com.pack.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Corporate;
import com.pack.repository.CorporateRepository;

@Service
public class CorporateService {
	@Autowired
	CorporateRepository corRepo;

	public List<Corporate> getAllRecords() {
		List<Corporate> corporateList = new ArrayList<Corporate>();
		List<Corporate> corList = corRepo.findAll();
		for (Corporate corporate : corList) {
			if (corporate.isActive() == true) {
				corporateList.add(corporate);
			}
		}
		Comparator<Corporate> corporates = Comparator.comparing(Corporate::getCorporate_id);
		corporateList.sort(corporates);
		return corporateList;
	}

	public Corporate deleteCorporate(int id) {
		Corporate corporate = corRepo.findById((long) id).orElseThrow(NoSuchElementException::new);
		corporate.setActive(false);
		return corRepo.save(corporate);
	}

	public Corporate getCorporate(long l) {
		return corRepo.findById(l).get();
	}

	public void updateCorporate(Corporate corporateBean) {
		Corporate corporate = corRepo.findById((long) corporateBean.getCorporate_id()).get();
		corporate.setAddress(corporateBean.getAddress());
		corporate.setPhoneNumber(corporateBean.getPhoneNumber());
		corRepo.save(corporate);
	}

	public Corporate addCorporate(Corporate corporateBean) {
		corporateBean.setActive(true);
		return corRepo.save(corporateBean);
	}
}
