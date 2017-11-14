package demo.jfreechart;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * 饼图
 * 
 * @author huozhicheng@gmail.com
 * @date 2013-1-10下午5:06:36
 * @version 1.0
 */
public class Piechart {

	/**
	 * 生成饼图
	 * @param chartTitle 图的标题
	 * @param dataset 数据集
	 * @param pieKeys 分饼的名字集
	 * @return
	 */
	public static JFreeChart createPieChart3D(String chartTitle,PieDataset dataset, String[] pieKeys) {
		
		JFreeChart chart = ChartFactory.createPieChart3D(
				chartTitle,
				dataset,
				true,//显示图例
				true, 
				false);

		//关闭抗锯齿，是字体清晰
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		chart.setTextAntiAlias(false);
		
		// 设置外层图片 无边框 无背景色 背景图片透明     
		chart.setBorderVisible(false);  
		chart.setBackgroundPaint(null);  
		chart.setBackgroundImageAlpha(0.0f);
		
		
		//图片背景色
		//chart.setBackgroundPaint(Color.white);
		//设置图标题的字体重新设置title
		Font font = new Font("隶书", Font.BOLD, 14);//25
		//chart.getTitle().setFont(font);
		chart.getTitle().setVisible(false);//去掉标题
		/*TextTitle title = new TextTitle(chartTitle);
		title.setFont(font);
		chart.setTitle(title);*/
		//设置图例字体
		//chart.getLegend().setItemFont(new Font("宋体",Font.PLAIN,12));//14
		chart.getLegend().setVisible(false);//去掉图例		
		//不显示3d
		//PiePlot3D plot = (PiePlot3D) chart.getPlot();
		  PiePlot  plot=(PiePlot) chart.getPlot();
		// 图片中显示百分比:默认方式
		  
		  plot.setCircular(true);
		  
		//图片显示字体
			plot.setLabelFont(new Font("宋体", Font.TRUETYPE_FONT, 0));//12
			
		  plot.setLabelBackgroundPaint(null);//标签背景颜色

		  plot.setLabelOutlinePaint(null);//标签边框颜色

		  plot.setLabelShadowPaint(null);//标签阴影颜色
		  
		  plot.setSimpleLabels(true);
		// 饼图上 无标签提示  
		plot.setLabelGenerator(null); 
		// 去除背景边框线  
		plot.setOutlinePaint(null);
		// 饼图的背景全透明  
		plot.setBackgroundAlpha(0.0f);

		// 指定饼图轮廓线的颜色
		// plot.setBaseSectionOutlinePaint(Color.BLACK);
		// plot.setBaseSectionPaint(Color.BLACK);
		//片区轮廓隐藏
		 plot.setSectionOutlinesVisible(false);

		// 设置无数据时的信息
		plot.setNoDataMessage("无对应的数据");

		// 设置无数据时的信息显示颜色
		plot.setNoDataMessagePaint(Color.red);

		// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));
		
		
		// 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})"));
		

		// 指定图片的透明度(0.0-1.0)
		plot.setForegroundAlpha(0.65f);
		// 指定显示的饼图上圆形(false)还椭圆形(true)
		plot.setCircular(true);

		plot.setLabelGap(0.02D); 
		// 设置第一个 饼块section 的开始位置，默认是12点钟方向
		plot.setStartAngle(90);

		// // 设置分饼颜色
		plot.setSectionPaint(pieKeys[0], new Color(244, 194, 144));
		plot.setSectionPaint(pieKeys[1], new Color(144, 233, 144));
		
		return chart;
	}
	// 饼状图 数据集
	public static PieDataset getDataPieSetByUtil(double[] data,
			String[] datadescription) {

		if (data != null && datadescription != null) {
			if (data.length == datadescription.length) {
				DefaultPieDataset dataset = new DefaultPieDataset();
				for (int i = 0; i < data.length; i++) {
					dataset.setValue(datadescription[i], data[i]);
				}
				return dataset;
			}
		}
		return null;
	}
}
