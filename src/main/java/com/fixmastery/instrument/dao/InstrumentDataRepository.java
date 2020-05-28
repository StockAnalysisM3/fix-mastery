package com.fixmastery.instrument.dao;

import com.fixmastery.instrument.dto.InstrumentData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentDataRepository extends CrudRepository<InstrumentData, Integer>, JpaSpecificationExecutor<InstrumentData> {
    Iterable<InstrumentData> findById(int Id);

}
