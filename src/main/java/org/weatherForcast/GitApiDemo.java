package org.weatherForcast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

//import static javax.management.MBeanServerFactory.builder;

public class GitApiDemo {
    public static void main(String[] args) {
        try {
            CallGitApi();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void CallGitApi() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast");
        HttpGet getData = new HttpGet(builder.build());

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(getData);

        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity responseEntity = httpResponse.getEntity();

            String result = EntityUtils.toString(responseEntity);
            System.out.println(result);
        } else {
            //System.out.println("Something went wrong !");
            throw new NoAPIException("Something went wrong !");
        }
        httpClient.close();
    }
}
