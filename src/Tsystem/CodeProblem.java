package Tsystem;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by sachin on 15/6/19.
 */
public class CodeProblem {


    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Link{
        String link;

        @Override
        public int hashCode() {
            return Objects.hash(link);
        }

        @Override
        public boolean equals(Object obj) {
            return link.equals(((Link)obj).link);
        }

        @Override
        public String toString() {
            return link;
        }
    }

    static List<Link> traversedLinks=new ArrayList<>();

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader(new File("src/input.in")));

        String firstUrl = reader.readLine();

        List<Link> queue=new ArrayList<>();
        Link link = new Link();
        link.link= firstUrl;
        queue.add(link);

       traverses(queue);

        System.out.println(" \n\n traversed links "+ traversedLinks);

    }


    static void traverses(List<Link> links){

        if (links==null){
            return;
        }
        System.out.println("links came to traverse"+" >> "+ links);


        List<Link> queue= new ArrayList<>();

        for (Link link :links) {

            // unique and of yahoo links
            if (!traversedLinks.contains(link) && checkIfYahoo(link)){
                System.out.println("traverse link "+link);

                traversedLinks.add(link);

                System.out.println("fetching links");
                queue=generateLinks(link.link);
                traverses(queue);

            }else {
                System.out.println("rejected link "+link);

            }

        }
    }

    static boolean checkIfYahoo(Link link){
        return link.link.contains("yahoo");
    }


    // only add two links, just for simplicity
    static List<Link> generateLinks(String url){

        List<Link> linksOnPage = new ArrayList<>();
        try {

            String html = getAndParse("https://in.yahoo.com/");


            int count =Integer.parseInt(reader.readLine());

            while (count>0){
                String linksContained =reader.readLine();

                Link link = new Link();
                link.link=linksContained;
                linksOnPage.add(link);
                count--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("parsed links on page "+ url +" >> "+ linksOnPage);
        return linksOnPage;
    }

    static String getAndParse(String url){
        StringBuilder response = new StringBuilder();

        try {
            URL page = new URL(url);
            HttpURLConnection con = (HttpURLConnection) page.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(response);

        return response.toString();
    }


}
