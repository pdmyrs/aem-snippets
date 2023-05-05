package org.example;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import com.adobe.aem.graphql.client.AEMHeadlessClient;
import com.adobe.aem.graphql.client.AEMHeadlessClientException;
import com.adobe.aem.graphql.client.GraphQlResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println("Hello World!");

        getWebPage();

        AEMHeadlessClient aemHeadlessClient = AEMHeadlessClient.builder()
                // .endpoint(new
                // URI("http://localhost:4502/content/cq%3Agraphql/global/endpoint.json"))
                .endpoint(new URI("https://wwwdev.troweprice.com/content/cq%3Agraphql/global/endpoint.json"))
                // .endpoint(new
                // URI("http://localhost:4502/content/cq%3Agraphql/we-retail/endpoint.json"))
                .basicAuth("admin", "admin")
                .build();

        // AEMHeadlessClient aemHeadlessClient = AEMHeadlessClient.builder()
        // .endpoint(new URI("http://localhost:4502/graphql/execute.json"))
        // .basicAuth("admin", "admin")
        // .build();

        // String query = "{\n" +
        // " teamList{\n" +
        // " items{ \n" +
        // " _path\n" +
        // " } \n" +
        // " }\n" +
        // "}";

        try {
            GraphQlResponse response = aemHeadlessClient.runQuery(getQuery("disclaimerList"));
            // GraphQlResponse response =
            // aemHeadlessClient.runPersistedQuery("/my-project/all-teams");
            JsonNode data = response.getData();
            System.out.println(prettyPrintJsonString(data));
            // ... use the data
        } catch (AEMHeadlessClientException e) {
            // e.getMessage() will contain an error message (independent of type of error)
            // if a response was received, e.getGraphQlResponse() will return it (otherwise
            // null)

            if (e.getGraphQlResponse() != null) {
                System.out.println(e.getGraphQlResponse());
            } else {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String prettyPrintJsonString(JsonNode jsonNode) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(jsonNode.toString(), Object.class);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (Exception e) {
            return "Sorry, pretty print didn't work";
        }
    }

    public static String getQuery(String queryName) {

        String query = "";

        if (queryName.equals("teamList")) {
            query = "{\n" +
                    " teamList{\n" +
                    " items{ \n" +
                    "   _path\n" +
                    "   title\n" +
                    "   shortName\n" +
                    "     teamMembers {\n" +
                    "        fullName\n" +
                    "        occupation\n" +
                    "     } \n" +
                    "   } \n" +
                    " }\n" +
                    "}";
        } else if (queryName.equals("allSchemas")) {
            query = "{\n" +
                    " __schema {\n" +
                    "   types {\n" +
                    "     name\n" +
                    "   } \n" +
                    " }\n" +
                    "}";

        } else if (queryName.equals("disclaimerList")) {
            query = "{\n" +
                    " disclaimerList {\n" +
                    " items{ \n" +
                    "   _path\n" +
                    "   disclaimer {\n" +
                    "     plaintext\n" +
                    "   }" +
                    "   disclaimerCode\n" +
                    "   } \n" +
                    " }\n" +
                    "}";
        }
        return query;
    }

    public static void getWebPage() throws IOException {


      //Creating a HttpGet object
      final HttpGet httpget = new HttpGet("http://httpbin.org/status/200");


        int timeout = 5;
        RequestConfig config = RequestConfig.custom()
          .setConnectTimeout(timeout * 1000)
          .setConnectionRequestTimeout(timeout * 1000)
          .setSocketTimeout(timeout * 1000).build();
      CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
      
      //Executing the Get request
      HttpResponse httpresponse = httpclient.execute(httpget);
      Scanner sc = new Scanner(httpresponse.getEntity().getContent());
      //Instantiating the StringBuffer class to hold the result
      StringBuffer sb = new StringBuffer();
      while(sc.hasNext()) {
         sb.append(sc.next());
         //System.out.println(sc.next());
      }
      //Retrieving the String from the String Buffer object
      String result = sb.toString();
      System.out.println(result);
      //Removing the HTML tags
      result = result.replaceAll("<[^>]*>", "");
      System.out.println("Contents of the web page: "+result);
    }

}
