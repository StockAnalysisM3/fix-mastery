package com.fixmastery.mic.dao;

import com.fixmastery.mic.dto.MarketInstitutionData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MicDataRepository extends CrudRepository<MarketInstitutionData, Integer>, JpaSpecificationExecutor<MarketInstitutionData> {}
