package com.fixmastery.categories.dao;

import com.fixmastery.categories.dto.Fix;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixRepository extends CrudRepository<Fix, Integer>, JpaSpecificationExecutor<Fix> {
    Iterable<Fix> findAllByTag(int tag);

}
