package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTool {

	 public static JSONObject jsonData(String pathname){//filename assets目录下的json文件名  
	        JSONObject jsonDate=null;  
	        try {
	        	File  file=new File(pathname);
	        	InputStream in=new FileInputStream(file);
	            InputStreamReader inputStreamReader=new InputStreamReader(in,"UTF-8");  
	            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);  
	            String line;  
	            StringBuilder stringBuilder=new StringBuilder();  
	            while ((line=bufferedReader.readLine())!=null){  
	                stringBuilder.append(line);  
	            }  
	            bufferedReader.close();  
	            inputStreamReader.close();  
	            jsonDate=JSON.parseObject(stringBuilder.toString());//得到JSONobject对象   
	            /*JSONArray  toolsArray=jsonDate.getJSONArray("tools");//得到tools节点  
	            List<Tools> listTools=JSON.parseArray(toolsArray.toString(),Tools.class);  
	            for(Tools tools:listTools){  
	                Log.e("tools.getType","="+tools.getType());  
	            }*/  
	  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return jsonDate;  
	    }  
}
