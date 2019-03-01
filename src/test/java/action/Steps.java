package action;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.OkHttpClient;
import common.CommUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;


import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class Steps {
    private static final Logger LOGGER = Logger.getLogger( Steps.class.getName() );

    public static final OkHttpClient client = new OkHttpClient();

    public CommUtil com = new CommUtil();

    @When("^设置项目名称后缀为:\"([^\"]*)\"$")
    public void setProjectAfterName(String names){
        LOGGER.fine("项目后缀名: " + names);
    }

    /**
     * 使用get请求方法
     * @param url
     */
    @When("^调用GET接口,url:\"([^\"]*)\"$")
    @Then("^调用GET接口,url:\"([^\"]*)\"$")
    public void getToUrl(String url) {
        LOGGER.fine("url: " + url);
        try {
            String resp = com.doGet(url);
            assertEquals(false, StringUtils.isEmpty(resp));
        }catch (Exception e){
            LOGGER.fine("Exception: " + e);
        }finally {
            return;
        }
    }

    /**
     * 使用post请求方法
     * @param url
     * @param json
     */
    @When("^调用POST接口,url:\"([^\"]*)\",json:\"([^\"]*)\"$")
    @Then("^调用POST接口,url:\"([^\"]*)\",json:\"([^\"]*)\"$")
    public void postToUrl(String url, JSONObject json) {
        LOGGER.fine("url: " + url);
        try {
            String resp = com.doPost(url,json);
            assertEquals(false, StringUtils.isEmpty(resp));
        }catch (Exception e){
            LOGGER.fine("Exception: " + e);
        }finally {
            return;
        }
    }

}
