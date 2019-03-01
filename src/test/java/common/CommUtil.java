package common;

import com.github.pagehelper.StringUtil;
import com.squareup.okhttp.*;

import java.util.Map;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSONObject;

import java.lang.Exception;

public class CommUtil {
    private static final Logger LOGGER = Logger.getLogger(CommUtil.class.getName());

    public static final OkHttpClient client = new OkHttpClient();
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

    /**
     * 不包含特殊header的get请求
     *
     * @return
     */
    public String doGet(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            LOGGER.fine("Request Fail: " + response);
        }
        return StringUtil.isEmpty(response.body().string()) ? "" : response.body().string();
    }

    /**
     * 包含特殊header的get请求
     *
     * @return
     */
    public String doGetWithHeader(String url, Map<String, String> headers) {
        try {
            Headers headerbuild = Headers.of(headers);
            Request request = new Request.Builder().url(url).headers(headerbuild).
                    build();
            Response response = client.newCall(request).execute();
            return StringUtil.isEmpty(response.body().string()) ? "" : response.body().string();
        } catch (Exception e) {
            LOGGER.fine("Request Fail: " + e);
        } finally {
            return "";
        }
    }

    /**
     * 不包含header的post请求
     *
     * @return
     */
    public String doPost(String url, JSONObject json) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, json.toString()))
                    .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                LOGGER.fine("Request Fail: " + response);
            }
            return StringUtil.isEmpty(response.body().string()) ? "" : response.body().string();
        } catch (Exception e) {
            LOGGER.fine("Request Fail: " + e);
        } finally {
            return "";
        }
    }

    /**
     * 包含header的post请求
     *
     * @return
     */
    public String doPostWithHeader(String url, Map<String, String> headers, JSONObject json) {
        try {
            Headers headerbuild = Headers.of(headers);
            Request request = new Request.Builder()
                    .url(url)
                    .headers(headerbuild)
                    .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, json.toString()))
                    .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                LOGGER.fine("Request Fail: " + response);
            }
            return StringUtil.isEmpty(response.body().string()) ? "" : response.body().string();
        }catch (Exception e){
            LOGGER.fine("Request Fail: " + e);
        }finally {
            return "";
        }
    }
}
