package com.kanion.www.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kanion.www.model.GardeniaExtration;

public interface GardeniaExtrationMapper {
    int insert(GardeniaExtration record);

    int insertSelective(GardeniaExtration record);
    
    List<GardeniaExtration> selectAll();
    
    List<Double> getDryConcreteWeights();

	List<Double> getContents();
	
	List<BigDecimal> getBatchNos();
	
	List<GardeniaExtration> argsAverageAnalysis(@Param("minDryConcreteWeight")Double minDryConcreteWeight,@Param("maxDryConcreteWeight")Double maxDryConcreteWeight,@Param("minContent")Double minContent,@Param("maxContent")Double maxContent);

	List<GardeniaExtration> qualityAverageAnalysis(@Param("minBatchNo")Integer minBatchNo,@Param("maxBatchNo")Integer maxBatchNo);

}