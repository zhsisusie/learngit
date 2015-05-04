package com.kanion.www.model;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import com.kanion.www.util.ArithUtil;
import com.kanion.www.util.TempretureUtil;
import com.kanion.www.util.TimeUtil;

public class GardeniaExtration {
	private BigDecimal batchno;
	// 浓缩浸膏重量(Kg)
	private BigDecimal concentrationextractionweight;
	// 原始pH值
	private Double originalph;
	// 加入1:1盐酸量（ml）
	private BigDecimal hclvolume;
	// 调酸后pH值
	private Double phwithhcl;
	// 热处理时间
	private String heattreatmenttime;

	private String solidparaffinweight;

	private String microboilingtime;

	private String refrigeratetempreture;

	private String refrigeratetime;

	private String filterclothnum;
	// 浸膏重量（kg）
	private BigDecimal extractionweight;
	// 萃取环境温度
	private String extractiontempreture;

	private String extractionvelocity;

	private String butanolweight;

	private String butanolmaker;

	private String butanolbatchno;
	// 回收正丁醇使用量(kg)
	private BigDecimal cyclingbutanol;

	private Double cyclingstreampressure;
	// 回收过程最高温度（℃）
	private String cyclingmaxtempreture;
	// 回收过程最低真空度（Mpa）
	private Double cyclingminkpa;
	// 刮板浓缩过程最高温度（℃）
	private String scraperenrichmentmaxtempreture;
	// 刮板浓缩过程最低真空度（Mpa）
	private Double scraperenrichmentminkpa;

	private String wateradditionweight;

	private BigDecimal wateradditiontimes;
	// 刮板总时间
	private String scrapertotletime;

	private Double concretedensity;
	// 湿膏
	private BigDecimal wetconcreteweight;

	private String drycustomtempreture;
	// 干燥最高温度（℃）
	private String drymaxtempreture;
	// 干燥时间(h)
	private String drytime;

	private Double drykpa;
	// 干膏
	private Double dryconcreteweight;
	// 含量
	private String content;
	
	/**
	* 使用BigDecimal与ArithUtil来保护精度。
	* @Title: add
	* @Description: GardeniaExtration的加法运算。
	* @param @param ge
	* @param @return    
	* @return GardeniaExtration    
	* @throws
	*/
	public GardeniaExtration add(GardeniaExtration ge) {
		GardeniaExtration result=new GardeniaExtration();
		result.concentrationextractionweight = this.concentrationextractionweight.add(ge.concentrationextractionweight);
		result.originalph =ArithUtil.add(this.originalph, ge.originalph);
		result.hclvolume = this.hclvolume.add(ge.hclvolume);
		result.phwithhcl =ArithUtil.add(this.phwithhcl, ge.phwithhcl);
		result.heattreatmenttime=TimeUtil.minutesToString(ArithUtil.add(TimeUtil.changeToHour(this.heattreatmenttime),TimeUtil.changeToHour(ge.heattreatmenttime)));
		result.extractionweight = this.extractionweight.add(ge.extractionweight);
		result.extractiontempreture=TempretureUtil.add(this.extractiontempreture,ge.extractiontempreture);
		result.cyclingbutanol=this.cyclingbutanol.add(ge.cyclingbutanol);
		result.cyclingmaxtempreture=TempretureUtil.add(this.cyclingmaxtempreture,ge.cyclingmaxtempreture);
		result.cyclingminkpa=ArithUtil.add(this.cyclingminkpa, ge.cyclingminkpa);
		result.scraperenrichmentmaxtempreture=TempretureUtil.add(this.scraperenrichmentmaxtempreture,ge.scraperenrichmentmaxtempreture);
		result.scraperenrichmentminkpa=ArithUtil.add(this.scraperenrichmentminkpa, ge.scraperenrichmentminkpa);
		result.scrapertotletime=TimeUtil.minutesToString(ArithUtil.add(TimeUtil.changeToHour(this.scrapertotletime),TimeUtil.changeToHour(ge.scrapertotletime)));
		result.wetconcreteweight=this.wetconcreteweight.add(ge.wetconcreteweight);
		result.drymaxtempreture=TempretureUtil.add(this.drymaxtempreture,ge.drymaxtempreture);
		result.drytime=TimeUtil.minutesToString(ArithUtil.add(TimeUtil.changeToHour(this.drytime),TimeUtil.changeToHour(ge.drytime)));
		result.dryconcreteweight=ArithUtil.add(this.dryconcreteweight, ge.dryconcreteweight);
		result.content=(new BigDecimal(this.content).add(new BigDecimal(ge.content))).toString();
		return result;
	}

	
	public GardeniaExtration divide(double n){
		GardeniaExtration result=new GardeniaExtration();
		BigDecimal bn=new BigDecimal(n);
		result.concentrationextractionweight = this.concentrationextractionweight.divide(bn,0,BigDecimal.ROUND_HALF_UP);
		result.originalph =ArithUtil.div(this.originalph,n);
		result.hclvolume = this.hclvolume.divide(bn,0,BigDecimal.ROUND_HALF_UP);
		result.phwithhcl =ArithUtil.div(this.phwithhcl, n);
		result.heattreatmenttime=TimeUtil.div(this.heattreatmenttime, n);
		result.extractionweight = this.extractionweight.divide(bn,0,BigDecimal.ROUND_HALF_UP);
		result.extractiontempreture=TempretureUtil.div(this.extractiontempreture, n);
		result.cyclingbutanol = this.cyclingbutanol.divide(bn,0,BigDecimal.ROUND_HALF_UP);
		result.cyclingmaxtempreture=TempretureUtil.div(this.cyclingmaxtempreture, n);
		result.cyclingminkpa =ArithUtil.div(this.cyclingminkpa, n);
		result.scraperenrichmentmaxtempreture=TempretureUtil.div(this.scraperenrichmentmaxtempreture, n);
		result.scraperenrichmentminkpa =ArithUtil.div(this.scraperenrichmentminkpa, n);
		result.scrapertotletime=TimeUtil.div(this.scrapertotletime, n);
		result.wetconcreteweight = this.wetconcreteweight.divide(bn,0,BigDecimal.ROUND_HALF_UP);
		result.drymaxtempreture=TempretureUtil.div(this.drymaxtempreture, n);	
		result.drytime=TimeUtil.div(this.drytime, n);
		result.dryconcreteweight =ArithUtil.div(this.dryconcreteweight, n);
		result.content=(new BigDecimal(this.content)).divide(bn,3,BigDecimal.ROUND_HALF_UP).toString();
//		System.out.println(result.concentrationextractionweight+","+result.originalph+","+result.hclvolume+","+result.phwithhcl+","+result.heattreatmenttime+","+result.extractionweight
//				+","+result.extractiontempreture+","+result.cyclingbutanol+","+result.cyclingmaxtempreture+","+result.cyclingminkpa+","+result.scraperenrichmentmaxtempreture+","+
//				result.scraperenrichmentminkpa+","+result.scrapertotletime+","+result.wetconcreteweight+","+result.drymaxtempreture+","+result.drytime+","+result.dryconcreteweight
//				+","+result.content);
		return result;
	}
	
	
	public static GardeniaExtration sum(List<GardeniaExtration> gardeniaExtrations){
		int totleRecords = gardeniaExtrations.size();
		GardeniaExtration sumGardeniaExtration=null; 
		//统计各项参数均值
		if(0!=totleRecords){			
			for (GardeniaExtration item : gardeniaExtrations) {
				if(null==sumGardeniaExtration){
					sumGardeniaExtration=item;
				}else{
					sumGardeniaExtration=sumGardeniaExtration.add(item);
				}
			}
		}
		return sumGardeniaExtration;
		
	}
	
	
	public static class CmpByDryconcreteweight implements Comparator<GardeniaExtration>{

		/* (比较器，根据干膏量升序)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(GardeniaExtration o1, GardeniaExtration o2) {
			if((o1.getDryconcreteweight()-o2.getDryconcreteweight())>=0)
				return 1;
			else return -1;			
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s=dryconcreteweight+","+content;
		return s;
	}
	public BigDecimal getBatchno() {
		return batchno;
	}

	public void setBatchno(BigDecimal batchno) {
		this.batchno = batchno;
	}

	public BigDecimal getConcentrationextractionweight() {
		return concentrationextractionweight;
	}

	public void setConcentrationextractionweight(
			BigDecimal concentrationextractionweight) {
		this.concentrationextractionweight = concentrationextractionweight;
	}

	public Double getOriginalph() {
		return originalph;
	}

	public void setOriginalph(Double originalph) {
		this.originalph = originalph;
	}

	public BigDecimal getHclvolume() {
		return hclvolume;
	}

	public void setHclvolume(BigDecimal hclvolume) {
		this.hclvolume = hclvolume;
	}

	public Double getPhwithhcl() {
		return phwithhcl;
	}

	public void setPhwithhcl(Double phwithhcl) {
		this.phwithhcl = phwithhcl;
	}

	public String getHeattreatmenttime() {
		return heattreatmenttime;
	}

	public void setHeattreatmenttime(String heattreatmenttime) {
		this.heattreatmenttime = heattreatmenttime == null ? null
				: heattreatmenttime.trim();
	}

	public String getSolidparaffinweight() {
		return solidparaffinweight;
	}

	public void setSolidparaffinweight(String solidparaffinweight) {
		this.solidparaffinweight = solidparaffinweight == null ? null
				: solidparaffinweight.trim();
	}

	public String getMicroboilingtime() {
		return microboilingtime;
	}

	public void setMicroboilingtime(String microboilingtime) {
		this.microboilingtime = microboilingtime == null ? null
				: microboilingtime.trim();
	}

	public String getRefrigeratetempreture() {
		return refrigeratetempreture;
	}

	public void setRefrigeratetempreture(String refrigeratetempreture) {
		this.refrigeratetempreture = refrigeratetempreture == null ? null
				: refrigeratetempreture.trim();
	}

	public String getRefrigeratetime() {
		return refrigeratetime;
	}

	public void setRefrigeratetime(String refrigeratetime) {
		this.refrigeratetime = refrigeratetime == null ? null : refrigeratetime
				.trim();
	}

	public String getFilterclothnum() {
		return filterclothnum;
	}

	public void setFilterclothnum(String filterclothnum) {
		this.filterclothnum = filterclothnum == null ? null : filterclothnum
				.trim();
	}

	public BigDecimal getExtractionweight() {
		return extractionweight;
	}

	public void setExtractionweight(BigDecimal extractionweight) {
		this.extractionweight = extractionweight;
	}

	public String getExtractiontempreture() {
		return extractiontempreture;
	}

	public void setExtractiontempreture(String extractiontempreture) {
		this.extractiontempreture = extractiontempreture == null ? null
				: extractiontempreture.trim();
	}

	public String getExtractionvelocity() {
		return extractionvelocity;
	}

	public void setExtractionvelocity(String extractionvelocity) {
		this.extractionvelocity = extractionvelocity == null ? null
				: extractionvelocity.trim();
	}

	public String getButanolweight() {
		return butanolweight;
	}

	public void setButanolweight(String butanolweight) {
		this.butanolweight = butanolweight == null ? null : butanolweight
				.trim();
	}

	public String getButanolmaker() {
		return butanolmaker;
	}

	public void setButanolmaker(String butanolmaker) {
		this.butanolmaker = butanolmaker == null ? null : butanolmaker.trim();
	}

	public String getButanolbatchno() {
		return butanolbatchno;
	}

	public void setButanolbatchno(String butanolbatchno) {
		this.butanolbatchno = butanolbatchno == null ? null : butanolbatchno
				.trim();
	}

	public BigDecimal getCyclingbutanol() {
		return cyclingbutanol;
	}

	public void setCyclingbutanol(BigDecimal cyclingbutanol) {
		this.cyclingbutanol = cyclingbutanol;
	}

	public Double getCyclingstreampressure() {
		return cyclingstreampressure;
	}

	public void setCyclingstreampressure(Double cyclingstreampressure) {
		this.cyclingstreampressure = cyclingstreampressure;
	}

	public String getCyclingmaxtempreture() {
		return cyclingmaxtempreture;
	}

	public void setCyclingmaxtempreture(String cyclingmaxtempreture) {
		this.cyclingmaxtempreture = cyclingmaxtempreture == null ? null
				: cyclingmaxtempreture.trim();
	}

	public Double getCyclingminkpa() {
		return cyclingminkpa;
	}

	public void setCyclingminkpa(Double cyclingminkpa) {
		this.cyclingminkpa = cyclingminkpa;
	}

	public String getScraperenrichmentmaxtempreture() {
		return scraperenrichmentmaxtempreture;
	}

	public void setScraperenrichmentmaxtempreture(
			String scraperenrichmentmaxtempreture) {
		this.scraperenrichmentmaxtempreture = scraperenrichmentmaxtempreture == null ? null
				: scraperenrichmentmaxtempreture.trim();
	}

	public Double getScraperenrichmentminkpa() {
		return scraperenrichmentminkpa;
	}

	public void setScraperenrichmentminkpa(Double scraperenrichmentminkpa) {
		this.scraperenrichmentminkpa = scraperenrichmentminkpa;
	}

	public String getWateradditionweight() {
		return wateradditionweight;
	}

	public void setWateradditionweight(String wateradditionweight) {
		this.wateradditionweight = wateradditionweight == null ? null
				: wateradditionweight.trim();
	}

	public BigDecimal getWateradditiontimes() {
		return wateradditiontimes;
	}

	public void setWateradditiontimes(BigDecimal wateradditiontimes) {
		this.wateradditiontimes = wateradditiontimes;
	}

	public String getScrapertotletime() {
		return scrapertotletime;
	}

	public void setScrapertotletime(String scrapertotletime) {
		this.scrapertotletime = scrapertotletime == null ? null
				: scrapertotletime.trim();
	}

	public Double getConcretedensity() {
		return concretedensity;
	}

	public void setConcretedensity(Double concretedensity) {
		this.concretedensity = concretedensity;
	}

	public BigDecimal getWetconcreteweight() {
		return wetconcreteweight;
	}

	public void setWetconcreteweight(BigDecimal wetconcreteweight) {
		this.wetconcreteweight = wetconcreteweight;
	}

	public String getDrycustomtempreture() {
		return drycustomtempreture;
	}

	public void setDrycustomtempreture(String drycustomtempreture) {
		this.drycustomtempreture = drycustomtempreture == null ? null
				: drycustomtempreture.trim();
	}

	public String getDrymaxtempreture() {
		return drymaxtempreture;
	}

	public void setDrymaxtempreture(String drymaxtempreture) {
		this.drymaxtempreture = drymaxtempreture == null ? null
				: drymaxtempreture.trim();
	}

	public String getDrytime() {
		return drytime;
	}

	public void setDrytime(String drytime) {
		this.drytime = drytime == null ? null : drytime.trim();
	}

	public Double getDrykpa() {
		return drykpa;
	}

	public void setDrykpa(Double drykpa) {
		this.drykpa = drykpa;
	}

	public Double getDryconcreteweight() {
		return dryconcreteweight;
	}

	public void setDryconcreteweight(Double dryconcreteweight) {
		this.dryconcreteweight = dryconcreteweight;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}