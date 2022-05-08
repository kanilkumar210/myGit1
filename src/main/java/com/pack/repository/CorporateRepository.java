package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.model.Corporate;

@Repository
public interface CorporateRepository extends JpaRepository<Corporate, Long> {
//	@Query(value = "update spring_project.corporate_setup set is_active=0 where corporate_id=?1", nativeQuery = true)
//	void deleteByCorporateId(long id);

}
