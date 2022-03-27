package com.zdl.core.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {
    public void sendRequest(String url) throws IOException,URISyntaxException{
        HttpClient client = HttpClientBuilder.create().build();
        // POST请求
        HttpPost post = new HttpPost(url);
        // GET请求，URL中带请求参数
        HttpGet get = new HttpGet(url);

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("username", "admin"));
        list.add(new BasicNameValuePair("password", "123456"));

//        普通形式：
        // GET请求方式
        // 由于GET请求的参数是拼装在URL后方，所以需要构建一个完整的URL，再创建HttpGet实例
//        URIBuilder uriBuilder = new URIBuilder("http://www.baidu.com");
//        uriBuilder.setParameters(list);
//        HttpGet get = new HttpGet(uriBuilder.build());

        // POST请求方式
//        post.setEntity(new UrlEncodedFormEntity(list, Charsets.UTF_8));

//        JSON形式
        Map<String,String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        Gson gson = new Gson();
        String json = gson.toJson(map, new TypeToken<Map<String, String>>() {}.getType());
        post.setEntity(new StringEntity(json, Charsets.UTF_8));
        post.addHeader("Content-Type", "application/json");

        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        post.releaseConnection();
    }
}
