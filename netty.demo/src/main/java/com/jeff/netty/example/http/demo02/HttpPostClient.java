package com.jeff.netty.example.http.demo02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpPostClient {

	public static void main(String[] args) {
		HttpClient httpclient = new DefaultHttpClient();  
        String url="http://127.0.0.1:8081/aaa";  
        HttpPost httppost = new HttpPost(url);  
        String strResult = "";  
        try {  
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
                JSONObject jobj = new JSONObject();  
                jobj.put("username", "jack");  
                jobj.put("password", "123456");  
                jobj.put("content","============================================================");
                  
                for(Entry<String, Object> e : jobj.entrySet()) {
                	nameValuePairs.add(new BasicNameValuePair(e.getKey(), (String) e.getValue()));  
                }
                
                httppost.addHeader("Content-type", "application/x-www-form-urlencoded");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));  
                  
                HttpResponse response = httpclient.execute(httppost);  
                if (response.getStatusLine().getStatusCode() == 200) {  
                    String conResult = EntityUtils.toString(response.getEntity());  
                    JSONObject sobj = JSON.parseObject(conResult);
                    String result = sobj.getString("result");  
                    String code = sobj.getString("code");  
                    if(result.equals("1")){  
                        strResult += "发送成功";  
                    }else{  
                        strResult += "发送失败，"+code;  
                    }  
                      
                } else {  
                    String err = response.getStatusLine().getStatusCode()+"";  
                    strResult += "发送失败:"+err;  
                }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
}
