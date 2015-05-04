/**
* Filename: Highchart.java
* Project Name: kanion
* @author: cyz	63954008(at)qq.com
* @version: 1.0
* @since: JDK 1.7.0_45
* Copyright © 2014 CCNT. All Rights Reserved
* Create at: 2014年11月6日  下午1:48:56
* Description:数据分析页面展示的图表类
*
* Modification History:
* Date			Author		Version		Description
* ------------------------------------------------------------------
* 2014年11月6日	cyz    		1.0			1.0 Version
*/
package com.kanion.www.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Highchart
 * @Description: TODO
 * @date 2014年11月6日 下午1:48:56
 *
 */
public class HighchartUtil {
	
	public class Chart{
		//图标类型，默认为折线图
		private String type="";

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
	}

	//图标主标题
	public class Title{
		
		public class Style{
			private String color;
			private String fontSize;
			private String fontFamily;
			public Style(String color,String fontSize,String fontFamily){
				this.color=color;
				this.fontSize=fontSize;
				this.fontFamily=fontFamily;
				
			}
			public String getColor() {
				return color;
			}

			public void setColor(String color) {
				this.color = color;
			}

			public String getFontSize() {
				return fontSize;
			}

			public void setFontSize(String fontSize) {
				this.fontSize = fontSize;
			}

			public String getFontFamily() {
				return fontFamily;
			}

			public void setFontFamily(String fontFamily) {
				this.fontFamily = fontFamily;
			}

			
		}
		//标题文字文本
		private String text="";
		//标题位置，默认居中，X指偏离中心的大小
		private int x=0;
		//标题文字颜色、大小、字体
		private Style style=new Style("#64B9C9","18px","微软雅黑");
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public Style getStyle() {
			return style;
		}
		public void setStyle(Style style) {
			this.style = style;
		}	
		
		
	}
	//图表副标题
	public class Subtitle{
		private String text="Source:www.kanion.com";
		private int x=0;
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		
	}
	//X轴属性设置
	public class XAxis{
		//X轴目录
		private List<String> categories=new ArrayList<String>();

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}
		
	}
	
	//标示线
	public static class PlotLine{
		//标示线的值
		private double value=0;
		//标示线的宽度
		private int width=1;
		//标示线的颜色
		private String color="#808080";
		//标示线的样式,默认为实线
		private String dashStyle="solid";
		
		private Label label=new Label();
		
		//标示线的标签
		public class Label{
			private String text="";
			private String align="left";
			private int x=500;
			public String getText() {
				return text;
			}
			public void setText(String text) {
				this.text = text;
			}
			public String getAlign() {
				return align;
			}
			public void setAlign(String align) {
				this.align = align;
			}
			public int getX() {
				return x;
			}
			public void setX(int x) {
				this.x = x;
			}
			
		}
		
		
		
		
		public Label getLabel() {
			return label;
		}
		public void setLabel(Label label) {
			this.label = label;
		}
		public String getDashStyle() {
			return dashStyle;
		}
		public void setDashStyle(String dashStyle) {
			this.dashStyle = dashStyle;
		}
		public double getValue() {
			return value;
		}
		public void setValue(double value) {
			this.value = value;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
	}
	//Y轴属性
	public class YAxis{
		//Y轴标题
		private Title title=new Title();
		//标示线数组
		private List<PlotLine> plotLines=new ArrayList<PlotLine>();
		public Title getTitle() {
			return title;
		}
		public void setTitle(Title title) {
			this.title = title;
		}
		public List<PlotLine> getPlotLines() {
			return plotLines;
		}
		public void setPlotLines(List<PlotLine> plotLines) {
			this.plotLines = plotLines;
		}
		
	}
	//数据提示框
	public class Tooltip{
		//值得后缀
		private String valueSuffix="";

		public String getValueSuffix() {
			return valueSuffix;
		}

		public void setValueSuffix(String valueSuffix) {
			this.valueSuffix = valueSuffix;
		}
	}
	//图例的设置
	public class Legend{
		private String layout="vertical";
		private String align="right";
		private String verticalAlign="middle";
		private int borderWidth=0;
		public String getLayout() {
			return layout;
		}
		public void setLayout(String layout) {
			this.layout = layout;
		}
		public String getAlign() {
			return align;
		}
		public void setAlign(String align) {
			this.align = align;
		}
		public String getVerticalAlign() {
			return verticalAlign;
		}
		public void setVerticalAlign(String verticalAlign) {
			this.verticalAlign = verticalAlign;
		}
		public int getBorderWidth() {
			return borderWidth;
		}
		public void setBorderWidth(int borderWidth) {
			this.borderWidth = borderWidth;
		}
		
		
	}
	//数据
	public static class Series{
		//数据的含义，显示在图例上
		private String name="";
		//数据值数组
		private List<Object> data=new ArrayList<Object>();
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Object> getData() {
			return data;
		}
		public void setData(List<Object> data) {
			this.data = data;
		}
		
	}
	
	private Chart chart;
	private Title title;
	private Subtitle subtitle;
	private XAxis xAxis;
	private YAxis yAxis;
	private Tooltip tooltip;
	private Legend legend;
	private List<Series> series;
	
	
	
	public Chart getChart() {
		return chart;
	}



	public void setChart(Chart chart) {
		this.chart = chart;
	}



	public HighchartUtil(){
		chart=new Chart();
		title=new Title();
		subtitle=new Subtitle();
		xAxis=new XAxis();
		yAxis=new YAxis();
		tooltip=new Tooltip();
		legend=new Legend();
		series=new ArrayList<Series>();
		
	}



	public Title getTitle() {
		return title;
	}



	public void setTitle(Title title) {
		this.title = title;
	}



	public Subtitle getSubtitle() {
		return subtitle;
	}



	public void setSubtitle(Subtitle subtitle) {
		this.subtitle = subtitle;
	}



	public XAxis getxAxis() {
		return xAxis;
	}



	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}



	public YAxis getyAxis() {
		return yAxis;
	}



	public void setyAxis(YAxis yAxis) {
		this.yAxis = yAxis;
	}



	public Tooltip getTooltip() {
		return tooltip;
	}



	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}



	public Legend getLegend() {
		return legend;
	}



	public void setLegend(Legend legend) {
		this.legend = legend;
	}



	public List<Series> getSeries() {
		return series;
	}



	public void setSeries(List<Series> series) {
		this.series = series;
	}
	
	
	
	
	
	
	
	

	
	
	

}
