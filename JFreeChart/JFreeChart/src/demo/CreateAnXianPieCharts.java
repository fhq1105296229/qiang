package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import demo.jfreechart.Piechart;
import javafx.scene.chart.Chart;

public class CreateAnXianPieCharts {

	

	public static void main(String[] args) {
		
		String u=System.getProperty("user.dir");
		String anxianUrl=u+"/src/data/HDAXStatictis.json";
		String areaUrl=u+"/src/data/area.json";
		JSONObject  object=JsonTool.jsonData(anxianUrl);
		JSONObject  areaObject=JsonTool.jsonData(areaUrl);
		
        JSONArray  anxianData=object.getJSONArray("datalist");
        JSONArray  areaData=areaObject.getJSONArray("features");
        
       List<List<String>> xzqh=new ArrayList<List<String>>();
       List<String[]> data1keys=new ArrayList<String[]>();
       List<String[]> data2keys=new ArrayList<String[]>();
       List<double[]> data1values=new ArrayList<double[]>();
       List<double[]> data2values=new ArrayList<double[]>();
       JSONArray  areaJson=new JSONArray();

        for(int i=0;i<anxianData.size();i++){
        	JSONObject obj= anxianData.getJSONObject(i);
        	JSONArray  data1=obj.getJSONArray("data1");
        	JSONArray  data2=obj.getJSONArray("data2");
        	String[] data1NameArray=new String[data1.size()];
        	String[] data2NameArray=new String[data2.size()];
        	double[] data1ValueArray=new double[data1.size()];
        	double[] data2ValueArray=new double[data2.size()];
        	List<String>  exist=Util.getArea(areaData, obj.getString("xzqh"));

        	if(!exist.isEmpty()){       		
        		
            	
        		for(int j=0;j<data1.size();j++){
            		JSONObject data1Detail= data1.getJSONObject(j);
            		JSONObject data2Detail= data2.getJSONObject(j);        		
            		data1NameArray[j]=data1Detail.getString("name");
            		data2NameArray[j]=data2Detail.getString("name");
            		data1ValueArray[j]=Double.parseDouble(data1Detail.getString("value"));
            		data2ValueArray[j]=Double.parseDouble(data2Detail.getString("value"));
            	}
        		JSONObject  areaObj=new JSONObject();
            	areaObj.put("xzqh", exist.get(0));
            	areaObj.put("name", exist.get(1));
            	areaObj.put("x", exist.get(2));
            	areaObj.put("y", exist.get(3));
            	areaObj.put("data1", data1);
            	areaObj.put("data2", data2);
        		areaJson.add(areaObj);
        		data1keys.add(data1NameArray);
            	data2keys.add(data2NameArray);
            	data1values.add(data1ValueArray);
            	data2values.add(data2ValueArray);
            	xzqh.add(exist);
            	Util.createPng(data1ValueArray, data1NameArray,"2012年岸线管理-"+exist.get(1),"2012年岸线管理-"+exist.get(1),"岸线管理");
            	Util.createPng(data1ValueArray, data1NameArray,"2016年岸线管理-"+exist.get(1),"2016年岸线管理-"+exist.get(1),"岸线管理");
        	}  	
        	
        }
		       
		System.out.println("end");
	}
}
