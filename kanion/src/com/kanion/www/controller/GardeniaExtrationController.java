/**
 * Filename: GardeniaExtration.java
 * Project Name: kanion
 * @author: cyz	63954008(at)qq.com
 * @version: 1.0
 * @since: JDK 1.7.0_45
 * Copyright © 2014 CCNT. All Rights Reserved
 * Create at: 2014-9-22  下午6:41:48
 * Description:处理“栀子提取浓缩数据”批数据的controller
 *
 * Modification History:
 * Date			Author		Version		Description
 * ------------------------------------------------------------------
 * 2014-9-22	cyz    		1.0			1.0 Version
 */
package com.kanion.www.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kanion.www.service.GardeniaExtrationService;

/**
 * @ClassName: GardeniaExtration
 * @Description: TODO
 * @date 2014-9-22 下午6:41:48
 * 
 */
@Controller
@RequestMapping("GardeniaExtration")
public class GardeniaExtrationController {

	@Autowired
	private GardeniaExtrationService gardeniaExtrationService;

	@Autowired
	public void setGardeniaExtrationService(
			GardeniaExtrationService gardeniaExtrationService) {
		this.gardeniaExtrationService = gardeniaExtrationService;
	}

	// 获取干膏范围
	@RequestMapping("/getDryConcreteWeights")
	@ResponseBody
	public String getDryConcreteWeights(HttpServletRequest request,
			HttpServletResponse response) {
		List<Double> dryconcreteweights = gardeniaExtrationService
				.getDryConcreteWeights();
		System.out.println("查询栀子干膏范围:" + dryconcreteweights.toString());
		return dryconcreteweights.toString();
	}

	// 获取含量范围
	@RequestMapping("/getContents")
	@ResponseBody
	public String getContents(HttpServletRequest request,
			HttpServletResponse response) {
		List<Double> contents = gardeniaExtrationService.getContents();
		System.out.println("查询栀子含量范围：" + contents.toString());
		return contents.toString();
	}

	// 获取批次范围
	@RequestMapping("/getBatchNos")
	@ResponseBody
	public String getBatchNos(HttpServletRequest request,
			HttpServletResponse response) {
		List<BigDecimal> batchNos = gardeniaExtrationService.getBatchNos();
		System.out.println("获取栀子批次范围成功：" + batchNos.toString());
		return batchNos.toString();
	}

	// 参数均值分析
	@RequestMapping("/contentAverageAnalysis")
	@ResponseBody
	public Map<String, Double> argsAverageAnalysis(
			HttpServletRequest request, HttpServletResponse response) {
		Double minDryConcreteWeight = Double.parseDouble(request
				.getParameter("minDryConcreteWeight"));
		Double maxDryConcreteWeight = Double.parseDouble(request
				.getParameter("maxDryConcreteWeight"));
		Double minContent = Double.parseDouble(request
				.getParameter("minContent"));
		Double maxContent = Double.parseDouble(request
				.getParameter("maxContent"));
		Map<String, Double> returnData = gardeniaExtrationService
				.argsAverageAnalysis(minDryConcreteWeight, maxDryConcreteWeight,
						minContent, maxContent);
		return returnData;
	}

	// 质量均值分析
	@RequestMapping("/qualityAverageAnalysis")
	@ResponseBody
	public Map<String,Object> qualityAverageAnalysis(
			HttpServletRequest request, HttpServletResponse response) {
		Integer minBatchNo = Integer.parseInt(request
				.getParameter("minBatchNo"));
		Integer maxBatchNo = Integer.parseInt(request
				.getParameter("maxBatchNo"));
		Map<String,Object> returnData = gardeniaExtrationService
				.qualityAverageAnalysis(minBatchNo, maxBatchNo);
		return returnData;
	}

}
