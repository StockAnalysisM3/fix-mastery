package com.fixmastery.categories.dao;

import com.fixmastery.categories.dto.RawFixData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawFixDataRepository extends CrudRepository<RawFixData, Integer>, JpaSpecificationExecutor<RawFixData> {
    Iterable<RawFixData> findAllByTag(int tag);
}
