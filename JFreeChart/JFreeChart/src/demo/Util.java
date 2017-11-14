package demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Bool;

import demo.jfreechart.Piechart;

public class Util {

	public static List<String> getArea(JSONArray array,String xzqh){
		List<String>  list=new ArrayList<String>();
 		for (int i = 0; i < array.size(); i++) {
			JSONObject obj=array.getJSONObject(i);
			JSONObject attribute=obj.getJSONObject("attributes");
			JSONObject geometry=obj.getJSONObject("geometry");
			String areaXZQH=attribute.getString("XZQH");
			if(xzqh.equals(areaXZQH)){
				list.add(areaXZQH);
				list.add(attribute.getString("NAME"));
				list.add(geometry.getString("x"));
				list.add(geometry.getString("y"));
				break;
			}
		}
		return list;	
		
	}
	
	public static void createPng(double[] values,String[] keys,String title,String pngName,String dirs){
		
		  PieDataset dataset=Piechart.getDataPieSetByUtil(values, keys);
	      JFreeChart chart=Piechart.createPieChart3D(title, dataset, keys);
	      try {
				FileOutputStream fos = new FileOutputStream("e:/"+dirs+"/"+pngName+".png");
				//ChartUtilities.writeChartAsPNG(fos,chart ,500, 500);
				ChartUtilities.writeChartAsPNG(fos, chart, 80, 80, true, 100);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}
}
