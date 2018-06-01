package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet(name = "FetchFromS3Servlet")
public class FetchFromS3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //  System.out.println("Fetch from S3 servlet talking..");
        String link1;
        String date1;
        String reason1;
        String link2;
        String reason2;
        String date2;
        String link3;
        String reason3;
        String date3;
        String link4;
        String reason4;
        String date4;
        String link5;
        String reason5;
        String date5;
        String patient_id = request.getParameter("patient_id");
        String [] dates = new String [5];
        String [] links = new String [5];
        String [] reasons = new String [5];
        //System.out.println("outside try\n" + patient_id);
        try {
            URL url;
            url = new URL("http://13.127.188.57:8080/PatientHealthHistoryAPI/webapi/patient_history/all_history/"+patient_id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            int n = 0;

            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);


                JSONParser parser = new JSONParser();
                Object obj = parser.parse(output);
                JSONArray json = (JSONArray) obj;
                n=0;
                while(n<json.size()){
                JSONObject jobj = (JSONObject) json.get(n);
                dates[n] = (String) jobj.get("date");
                reasons[n] = (String) jobj.get("visit_reason");
                String temp = "https://s3.ap-south-1.amazonaws.com/patient-history/";
                String filename = (String) jobj.get("prescription_file_url");
                temp = temp.concat(filename);
              //  System.out.println(temp);
                links[n] =temp;
                n++;
                }
            }
            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();
            System.out.println(e);

        } catch (IOException e) {

            e.printStackTrace();
            System.out.println(e);

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        date1 = dates[0];
        date2 = dates[1];
        date3 = dates[2];
        date4 = dates[3];
        date5 = dates[4];

        link1 = links[0];
        link2 = links[1];
        link3 = links[2];
        link4 = links[3];
        link5 = links[4];

        reason1 = reasons[0];
        reason2 = reasons[1];
        reason3 = reasons[2];
        reason4 = reasons[3];
        reason5 = reasons[4];
      //  System.out.println("over");

        request.setAttribute("date1", date1);
        request.setAttribute("date2", date2);
        request.setAttribute("date3", date3);
        request.setAttribute("date4", date4);
        request.setAttribute("date5",date5);
        request.setAttribute("link1", link1);
        request.setAttribute("link2", link2);
        request.setAttribute("link3", link3);
        request.setAttribute("link4", link4);
        request.setAttribute("link5", link5);
        request.setAttribute("reason1", reason1);
        request.setAttribute("reason2", reason2);
        request.setAttribute("reason3", reason3);
        request.setAttribute("reason4", reason4);
        request.setAttribute("reason5", reason5);

        String redirect = "/showPrevFiveDocuments.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
        dispatcher.include(request, response);

    }
}
