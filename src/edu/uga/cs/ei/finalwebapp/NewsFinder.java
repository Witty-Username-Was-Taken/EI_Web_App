package edu.uga.cs.ei.newsfinder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


public class NewsFinder {

    public static final String BASE_URL = "https://newsapi.org/v2/everything";
    public static final String API_KEY = "860b17df0dc746e7ac67a941e0f5b53a";

    // Function to return html to be displayed
    public static String getArticles(String q) {

        // Start the html with some basic html, setting some styling and preparing the table and headers
        String html = "<html lang='en'>" +
                "<head> <meta charset='UTF-8'><title>Newsfinder Results</title> <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-4.0.0.css\">" +
                "</head>><body style=\"background-color: #6f42c1\"><div class='container'><h2>Search Results</h2><table border='1'><tr> <td><b>Title</b></td> " +
                "<td><b>Author</b></td>  <td><b>Date</b></td> <td><b>Description</b></td> <td><b>URL</b></td> <td><b>Image</b></td> </tr>";

        // Get the search terms
        String query = q;

        try {

            System.out.println();
            System.out.println("Searching for articles...");

            // Create the query to the NewsApi, passing in our apiKey as well
            MultivaluedMap<String, Object> queryParams = new MultivaluedMapImpl<String, Object>();
            queryParams.add("q", query);
            queryParams.add("apiKey", API_KEY);

            ResteasyClient client = new ResteasyClientBuilder()
                    .hostnameVerification(ResteasyClientBuilder.HostnameVerificationPolicy.ANY)
                    .build();
            ResteasyWebTarget target = client.target( BASE_URL );
            target = target.queryParams(queryParams);

            System.out.println("Target URI: " + target.getUri());

            Response response = target.request().get();

            System.out.println("Response received!");

            // If we don't have a successful query, throw an exception
            if (response.getStatus() != 200 ) {
                throw new RuntimeException( "GET request failed: HTTP code: " + response.getStatus());
            }

            // We had a successful query, so get the response
            else {
                System.out.println("Response status: " + response.getStatus());

                // Map the JSON object to our SearchResult Class
                SearchResult searchResult = response.readEntity(SearchResult.class);

                // Take each Article from our JSON Object and create a row in our html string for it
                if (searchResult != null) {
                    System.out.println( "NewsFinder: Number of articles received: " + searchResult.getTotalResults() );
                    for(Article article : searchResult.getArticles()) {
                        System.out.println("\n" + article);
                        html+="<tr><td>"+article.getTitle()+"</td>";
                        html+="<td>"+article.getAuthor()+"</td>";
                        html+="<td>"+article.getPublishedAt()+"</td>";
                        html+="<td>"+article.getDescription()+"</td>";
                        html+="<td><a href='"+article.getUrl()+"'>"+article.getUrl()+"</a></td>";
                        html+="<td><img src='"+article.getUrlToImage()+"' height=\"75\" width=\"75\"></td>";
                        html+="</tr>";
                    }
                }
                else {
                    System.out.println( "NewsFinder: null searchResult" );
                }

                response.close();
            }
        }

        catch (Exception e) {
            System.out.println( e );
            e.printStackTrace();
        }

        html+="</table></div></body></html>";
        return html;

    }
}
