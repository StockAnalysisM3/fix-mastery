package com.fixmastery.categories.dao;

import com.fixmastery.categories.dto.FixData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixRepository extends CrudRepository<FixData, Integer>, JpaSpecificationExecutor<FixData> {
    Iterable<FixData> findAllByTag(int tag);
}
