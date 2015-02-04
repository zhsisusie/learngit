/**
 * Filename: GardeniaExtrationServiceImpl.java
 * Project Name: kanion
 * @author: cyz	63954008(at)qq.com
 * @version: 1.0
 * @since: JDK 1.7.0_45
 * Copyright © 2014 CCNT. All Rights Reserved
 * Create at: 2014-9-22  下午7:44:48
 * Description:
 *
 * Modification History:
 * Date			Author		Version		Description
 * ------------------------------------------------------------------
 * 2014-9-22	cyz    		1.0			1.0 Version
 */
package com.kanion.www.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanion.www.dao.GardeniaExtrationMapper;
import com.kanion.www.model.GardeniaExtration;
import com.kanion.www.util.ArithUtil;
import com.kanion.www.util.HighchartUtil;
import com.kanion.www.util.TempretureUtil;
import com.kanion.www.util.TimeUtil;
import com.kanion.www.util.Util;

/**
 * @ClassName: GardeniaExtrationServiceImpl
 * @Description: TODO
 * @date 2014-9-22 下午7:44:48
 * 
 */
@Service("GardeniaExtrationService")
public class GardeniaExtrationServiceImpl implements GardeniaExtrationService {

	private GardeniaExtrationMapper gardeniaExtrationMapper;

	@Autowired
	public void setGardeniaExtrationMapper(
			GardeniaExtrationMapper gardeniaExtrationMapper) {
		this.gardeniaExtrationMapper = gardeniaExtrationMapper;
	}

	@Override
	public List<GardeniaExtration> selectAll() {
		return gardeniaExtrationMapper.selectAll();
	}

	@Override
	public List<Double> getDryConcreteWeights() {

		return gardeniaExtrationMapper.getDryConcreteWeights();
	}

	@Override
	public List<Double> getContents() {
		return gardeniaExtrationMapper.getContents();
	}

	//需要优化，勿参考
	@Override
	public Map<String, Double> argsAverageAnalysis(Double minDryConcreteWeight,
			Double maxDryConcreteWeight, Double minContent, Double maxContent) {

		List<GardeniaExtration> gardeniaExtrations = gardeniaExtrationMapper
				.argsAverageAnalysis(minDryConcreteWeight, maxDryConcreteWeight,
						minContent, maxContent);
		int totleRecords = gardeniaExtrations.size();
		GardeniaExtration sumGardeniaExtration=null; 
		// 统计各项参数总值
		if(0!=totleRecords){			
			for (GardeniaExtration item : gardeniaExtrations) {
				if(null==sumGardeniaExtration){
					sumGardeniaExtration=item;
				}else{
					sumGardeniaExtration=sumGardeniaExtration.add(item);
				}
			}
		}
		GardeniaExtration avgGardeniaExtration=sumGardeniaExtration.divide(totleRecords);
		Map<String, Double> averages=new HashMap<String,Double>();
		averages.put("concentrationExtractionWeight", avgGardeniaExtration.getConcentrationextractionweight().doubleValue());
		averages.put("originalPH", avgGardeniaExtration.getOriginalph());
		averages.put("HCLVolume", avgGardeniaExtration.getHclvolume().doubleValue());
		averages.put("PHWithHCL", avgGardeniaExtration.getPhwithhcl());
		averages.put("heatTreatmentTime", TimeUtil.changeToHour(avgGardeniaExtration.getHeattreatmenttime()));
		averages.put("extractionWeight", avgGardeniaExtration.getExtractionweight().doubleValue());
		averages.put("extractionTempreture", TempretureUtil.stringToVal(avgGardeniaExtration.getExtractiontempreture()));
		averages.put("cyclingButanol", avgGardeniaExtration.getCyclingbutanol().doubleValue());
		averages.put("cyclingMaxTempreture", TempretureUtil.stringToVal(avgGardeniaExtration.getCyclingmaxtempreture()));
		averages.put("cyclingMinKPA", avgGardeniaExtration.getCyclingminkpa());
		averages.put("scraperEnrichmentMaxTempreture", TempretureUtil.stringToVal(avgGardeniaExtration.getScraperenrichmentmaxtempreture()));
		averages.put("scraperEnrichmentMinKPA", avgGardeniaExtration.getScraperenrichmentminkpa());
		averages.put("scraperTotleTime", TimeUtil.changeToHour(avgGardeniaExtration.getScrapertotletime()));
		averages.put("wetConcreteWeight", avgGardeniaExtration.getWetconcreteweight().doubleValue());
		averages.put("dryMaxTempreture", TempretureUtil.stringToVal(avgGardeniaExtration.getDrymaxtempreture()));
		averages.put("dryTime", TimeUtil.changeToHour(avgGardeniaExtration.getDrytime()));
		System.out.println("栀子干膏与含量范围的均值分析结果："+averages);
		return averages;
	}

	@Override
	public List<BigDecimal> getBatchNos() {
		return gardeniaExtrationMapper.getBatchNos();
	}

	//分析栀子干膏与含量的平均值，看各批次与均值的差异，分析离异点形成的原因。
	@Override
	public Map<String,Object> qualityAverageAnalysis(
			Integer minBatchNo, Integer maxBatchNo) {
		Map<String,Object> returnData=null;
		List<GardeniaExtration> gardeniaExtrations = gardeniaExtrationMapper.qualityAverageAnalysis(minBatchNo, maxBatchNo);		
		int totleRecords = gardeniaExtrations.size();
		if(0!=totleRecords){
			returnData=new HashMap<String,Object>();
			GardeniaExtration sumGardeniaExtration=GardeniaExtration.sum(gardeniaExtrations); 	
			//计算均值
			GardeniaExtration avgGardeniaExtration=sumGardeniaExtration.divide(totleRecords);
				
			/**
			 * 计算返回的数据
			 */
			//返回的X轴下标
			List<String> batchNos=new ArrayList<String>();
			//返回各批号的干膏和含量
			List<Object> dryconcreteweights=new ArrayList<Object>();
			List<Object> contents=new ArrayList<Object>();
			//返回各批号的干膏和含量和均值的差值
			List<Object> dryconcreteweightsDifference=new ArrayList<Object>();
			List<Object> contentsDifference=new ArrayList<Object>();	
			//返回加入1：1盐酸量（L）
			List<Object> hclvolumes=new ArrayList<Object>();
			// 浸膏重量（kg）
			List<Object> extractionweights=new ArrayList<Object>();
			// 萃取环境温度
			List<Object> extractiontempretures=new ArrayList<Object>();
			// 回收过程最高温度（℃）
			List<Object> cyclingmaxtempretures=new ArrayList<Object>();
			// 回收过程最低真空度（Kpa）			
			List<Object> cyclingminkpas=new ArrayList<Object>();
			// 刮板浓缩过程最低真空度（Kpa）
			List<Object> scraperenrichmentminkpas=new ArrayList<Object>();
			// 湿膏
			List<Object> wetconcreteweights=new ArrayList<Object>();
			// 干燥最高温度（℃）
			List<Object> drymaxtempretures=new ArrayList<Object>();
			//获取上述需返回的数据			
			for (GardeniaExtration item : gardeniaExtrations) {
				Double dw=item.getDryconcreteweight();				
				batchNos.add(item.getBatchno().toString());
				dryconcreteweights.add(dw);
				contents.add(Double.valueOf(item.getContent())*100);
				dryconcreteweightsDifference.add(item.getDryconcreteweight()-avgGardeniaExtration.getDryconcreteweight());
				contentsDifference.add((Double.parseDouble(item.getContent())-Double.parseDouble(avgGardeniaExtration.getContent()))*100);
				hclvolumes.add(item.getHclvolume().divide(new BigDecimal(1000)));
				extractionweights.add(item.getExtractionweight());
				extractiontempretures.add(TempretureUtil.stringToVal(item.getExtractiontempreture()));
				cyclingmaxtempretures.add(TempretureUtil.stringToVal(item.getCyclingmaxtempreture()));
				cyclingminkpas.add(item.getCyclingminkpa()*1000);
				scraperenrichmentminkpas.add(item.getScraperenrichmentminkpa()*1000);
				wetconcreteweights.add(item.getWetconcreteweight());
				drymaxtempretures.add(TempretureUtil.stringToVal(item.getDrymaxtempreture()));
			}
		
			//*******************************************************************************************
			/**
			 * 各批次栀子干膏与含量的均值差分析
			 */
			HighchartUtil avgChart=new HighchartUtil();
			//X轴目录			
			avgChart.getTitle().setText("各批次栀子干膏与含量的均值差分析");
			avgChart.getxAxis().setCategories(batchNos);
			//各批号干膏
			HighchartUtil.Series dryconcreteweightsSeries=new HighchartUtil.Series();
			dryconcreteweightsSeries.setName("干膏");
			dryconcreteweightsSeries.setData(dryconcreteweights);
			//各批号含量
			HighchartUtil.Series contentsSeries=new HighchartUtil.Series();
			contentsSeries.setName("含量(%)");
			contentsSeries.setData(contents);
			//各批号干膏与均值的差
			HighchartUtil.Series dryconcreteweightsDifferenceSeries=new HighchartUtil.Series();
			dryconcreteweightsDifferenceSeries.setName("干膏均值差");
			dryconcreteweightsDifferenceSeries.setData(dryconcreteweightsDifference);
			//各批号含量与均值的差
			HighchartUtil.Series contentsDifferenceSeries=new HighchartUtil.Series();
			contentsDifferenceSeries.setName("含量均值差(%)");
			contentsDifferenceSeries.setData(contentsDifference);
			
			avgChart.getSeries().add(dryconcreteweightsSeries);
			avgChart.getSeries().add(contentsSeries);
			avgChart.getSeries().add(dryconcreteweightsDifferenceSeries);
			avgChart.getSeries().add(contentsDifferenceSeries);
			/**
			 * 设置均值的标示线
			 */
			//干膏均值标示线
			HighchartUtil.PlotLine avgDryconcreteweightPotline=new HighchartUtil.PlotLine();
			avgDryconcreteweightPotline.setValue(avgGardeniaExtration.getDryconcreteweight());
			avgDryconcreteweightPotline.setColor("red");
			//avgDryconcreteweightPotline.getLabel().setText("各批号干膏值与选定批号["+batchNos.get(0)+","+batchNos.get(batchNos.size()-1)+"]均值的差");
			//含量均值标示线
			HighchartUtil.PlotLine avgContentPotline=new HighchartUtil.PlotLine();
			avgContentPotline.setValue(Double.valueOf(avgGardeniaExtration.getContent())*100);
			avgContentPotline.setColor("red");
			//avgContentPotline.setDashStyle("longdashdot");
			//长虚线
			//avgContentPotline.getLabel().setText("各批号含量值与选定批号["+batchNos.get(0)+","+batchNos.get(batchNos.size()-1)+"]均值的差");
			avgChart.getyAxis().getPlotLines().add(avgDryconcreteweightPotline);
			avgChart.getyAxis().getPlotLines().add(avgContentPotline);	
			returnData.put("avgChart", avgChart);
			
		
		
			//*******************************************************************************************
	
			/**
			 * 与干膏相关性较大的控制参数，需调用相关性分析算子
			 */
			/**
			 * 构建返回的图表
			 */
			HighchartUtil avgRelatedToDryconcreteweightsChart=new HighchartUtil();
			//X轴目录			
			avgRelatedToDryconcreteweightsChart.getTitle().setText("各批次与干膏相关性较大的控制参数表");
			avgRelatedToDryconcreteweightsChart.getxAxis().setCategories(batchNos);
			
			HighchartUtil.Series hclvolumesSeries=new HighchartUtil.Series();
			hclvolumesSeries.setName("加入1:1盐酸量(l)");
			hclvolumesSeries.setData(hclvolumes);
			
			HighchartUtil.Series extractionweightsSeries=new HighchartUtil.Series();
			extractionweightsSeries.setName("浸膏重量(kg)");
			extractionweightsSeries.setData(extractionweights);
			
			HighchartUtil.Series cyclingminkpasSeries=new HighchartUtil.Series();
			cyclingminkpasSeries.setName("回收过程最低真空度(Kpa)");
			cyclingminkpasSeries.setData(cyclingminkpas);
			
			HighchartUtil.Series scraperenrichmentminkpasSeries=new HighchartUtil.Series();
			scraperenrichmentminkpasSeries.setName("刮板浓缩过程最低真空度(Kpa)");
			scraperenrichmentminkpasSeries.setData(scraperenrichmentminkpas);
			
			HighchartUtil.Series wetconcreteweightsSeries=new HighchartUtil.Series();
			wetconcreteweightsSeries.setName("湿膏");
			wetconcreteweightsSeries.setData(wetconcreteweights);
			
			HighchartUtil.Series drymaxtempreturesSeries=new HighchartUtil.Series();
			drymaxtempreturesSeries.setName("干燥最高温度(℃)");
			drymaxtempreturesSeries.setData(drymaxtempretures);
			
			avgRelatedToDryconcreteweightsChart.getSeries().add(dryconcreteweightsSeries);
			avgRelatedToDryconcreteweightsChart.getSeries().add(hclvolumesSeries);			
			avgRelatedToDryconcreteweightsChart.getSeries().add(extractionweightsSeries);
			avgRelatedToDryconcreteweightsChart.getSeries().add(cyclingminkpasSeries);
			avgRelatedToDryconcreteweightsChart.getSeries().add(scraperenrichmentminkpasSeries);
			avgRelatedToDryconcreteweightsChart.getSeries().add(wetconcreteweightsSeries);
			avgRelatedToDryconcreteweightsChart.getSeries().add(drymaxtempreturesSeries);
			returnData.put("avgRelatedToDryconcreteweightsChart", avgRelatedToDryconcreteweightsChart);
			
			//*******************************************************************************************
			
			
			/**
			 * 与含量相关性较大的控制参数，需调用相关性分析算子
			 */
			/**
			 * 构建返回的图表
			 */
					
			HighchartUtil avgRelatedToContentsChart=new HighchartUtil();
			//X轴目录			
			avgRelatedToContentsChart.getTitle().setText("各批次与含量相关性较大的控制参数表");
			avgRelatedToContentsChart.getxAxis().setCategories(batchNos);
			
			HighchartUtil.Series extractiontempreturesSeries=new HighchartUtil.Series();
			extractiontempreturesSeries.setName("萃取环境温度(℃)");
			extractiontempreturesSeries.setData(extractiontempretures);
			
			HighchartUtil.Series cyclingmaxtempreturesSeries=new HighchartUtil.Series();
			cyclingmaxtempreturesSeries.setName("回收过程最高温度(℃)");
			cyclingmaxtempreturesSeries.setData(cyclingmaxtempretures);
			
			avgRelatedToContentsChart.getSeries().add(contentsSeries);
			avgRelatedToContentsChart.getSeries().add(extractiontempreturesSeries);			
			avgRelatedToContentsChart.getSeries().add(cyclingmaxtempreturesSeries);
			avgRelatedToContentsChart.getSeries().add(cyclingminkpasSeries);
			returnData.put("avgRelatedToContentsChart", avgRelatedToContentsChart);
			
			//*******************************************************************************************
			
			/**
			 * 分析干膏的区间分布情况，以及奇异点
			 */
		
			//放置奇异点的列表
			List<GardeniaExtration> singularity=new ArrayList<GardeniaExtration>();		
			
			Double avgDW=avgGardeniaExtration.getDryconcreteweight();
			
			//按干膏量升序排序
			java.util.Collections.sort(gardeniaExtrations, new GardeniaExtration.CmpByDryconcreteweight());
			
			//计算干膏的分布区间，step是分区步长
			double min=gardeniaExtrations.get(0).getDryconcreteweight();
			double max=gardeniaExtrations.get(gardeniaExtrations.size()-1).getDryconcreteweight();
			Map<String,List<GardeniaExtration>> sections=new LinkedHashMap<String,List<GardeniaExtration>>();
			double step=ArithUtil.div(ArithUtil.sub(max,min),Util.categoryCount,2);
			//构造区间划分的对应Map,以及每个区间对应的批号
			double sectionLeft=min,sectionRight=ArithUtil.add(sectionLeft, step),sectionLeftEnd=ArithUtil.sub(max, step);
			int index=0;
			GardeniaExtration item=null;
			while(sectionLeft<=sectionLeftEnd){
				sectionRight=ArithUtil.add(sectionLeft, step);		
				ArrayList<GardeniaExtration> tmp=new ArrayList<GardeniaExtration>();			
				while(index<totleRecords){
					item=gardeniaExtrations.get(index);
					//加入离异点的条件
					if(0.1<=ArithUtil.abs((item.getDryconcreteweight()-avgDW))/avgDW){
						singularity.add(item);
					}	
					if(item.getDryconcreteweight()>=sectionLeft&&item.getDryconcreteweight()<=sectionRight)
						tmp.add(item);
					else break;
					index++;							
				}		
				sections.put("["+sectionLeft+","+sectionRight+"]",tmp);					
				sectionLeft=sectionRight;
			}	
			System.out.println("栀子萃取数据干膏和含量均值分析奇异点："+singularity);
			/**
			 * 构建图表
			 */
			HighchartUtil normalChart=new HighchartUtil();
			normalChart.getTitle().setText("栀子干膏分布区间统计表");

			//X轴目录
			List<String> normalChartCategories=normalChart.getxAxis().getCategories();
			//统计每个区间所含批数
			List<Object> batchCounts=new ArrayList<Object>();			
			Iterator<Entry<String, List<GardeniaExtration>>> iter=sections.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, List<GardeniaExtration>> e=(Map.Entry<String, List<GardeniaExtration>>) iter.next();
				normalChartCategories.add(e.getKey().toString());
				batchCounts.add(((List<GardeniaExtration>)e.getValue()).size());				
			}
			HighchartUtil.Series batchCountsSeries=new HighchartUtil.Series();
			batchCountsSeries.setName("批数");
			batchCountsSeries.setData(batchCounts);
			normalChart.getSeries().add(batchCountsSeries);
			returnData.put("normalChart", normalChart);					
			
			System.out.println("栀子萃取数据干膏和含量均值分析正太分布区间："+normalChartCategories);
			System.out.println("栀子萃取数据干膏和含量均值分析正太分布区间对应批数："+batchCounts);
			
			/**
			 * 各个区间的批号
			 */
			returnData.put("sections", sections);
			
			/**
			 * 奇异点分析
			 */
			
			
		}
		
		return returnData;
		
	}
}
