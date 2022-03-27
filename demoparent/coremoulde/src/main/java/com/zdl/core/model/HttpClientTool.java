package com.zdl.core.model;

import com.zdl.core.exception.RestApiException;
import lombok.extern.log4j.Log4j;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Log4j
public class HttpClientTool {

    // 发送GET请求
    public static String getRequest(String path, List<NameValuePair> parametersBody) throws RestApiException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(path);
        uriBuilder.setParameters(parametersBody);
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(get);
            int code = response.getStatusLine().getStatusCode();
            if (code >= 400)
                throw new RuntimeException((new StringBuilder()).append("Could not access protected resource. Server returned http code: ").append(code).toString());
            return EntityUtils.toString(response.getEntity());
        }
        catch (ClientProtocolException e) {
            throw new RestApiException("postRequest -- Client protocol exception!", e);
        }
        catch (IOException e) {
            throw new RestApiException("postRequest -- IO error!", e);
        }
        finally {
            get.releaseConnection();
        }
    }

    // 发送POST请求（普通表单形式）
    private static String postForm(String path, List<NameValuePair> parametersBody) throws RestApiException {
        HttpEntity entity = new UrlEncodedFormEntity(parametersBody, Charsets.UTF_8);
        return postRequest(path, "application/x-www-form-urlencoded", entity);
    }

    // 发送POST请求（JSON形式）
    public static String postJSON(String path, String json) throws RestApiException {
        StringEntity entity = new StringEntity(json, Charsets.UTF_8);
        return postRequest(path, "application/json", entity);
    }

    // 发送POST请求
    private static String postRequest(String path, String mediaType, HttpEntity entity) throws RestApiException {

        HttpPost post = new HttpPost(path);
        post.addHeader("Content-Type", mediaType);
        post.addHeader("Accept", "application/json");
        post.setEntity(entity);
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code >= 400)
                throw new RestApiException();
            return EntityUtils.toString(response.getEntity());
        }
        catch (ClientProtocolException e) {
            throw new RestApiException("postRequest -- Client protocol exception!", e);
        }
        catch (IOException e) {
            throw new RestApiException("postRequest -- IO error!", e);
        }
        finally {
            post.releaseConnection();
        }
    }
}


//使用实例:
//    GET请求:
//    List<NameValuePair> parametersBody = new ArrayList();
//    parametersBody.add(new BasicNameValuePair("userId", "admin"));
//    String result = HttpClientUtil.getRequest("http://www.test.com/user",parametersBody);
//
//    POST请求:
//        List<NameValuePair> parametersBody = new ArrayList();
//        parametersBody.add(new BasicNameValuePair("username", "admin"));
//        parametersBody.add(new BasicNameValuePair("password", "123456"));
//        String result = HttpClientUtil.postForm("http://www.test.com/login",parametersBody);
//
//    POST请求（JSON形式）:
//        Map<String,String> map = new HashMap<>();
//        map.put("username", "admin");
//        map.put("password", "123456");
//        Gson gson = new Gson();
//        String json = gson.toJson(map, new TypeToken<Map<String, String>>() {}.getType());
//        String result = HttpClientUtil.postJSON("http://www.test.com/login", json);
