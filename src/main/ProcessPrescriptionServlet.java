package main;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet(name = "main.ProcessPrescriptionServlet")
public class ProcessPrescriptionServlet extends HttpServlet {
    static String doctor_id;
    static  String conditions;
    static  String symptoms;
    static String medication;
    static boolean isTobacco;
    static boolean isAlchoholic;
    static String allergies;
    static String reason;
    static Double sugar;
    static long bp;
    static Double weight;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String patient_id = request.getParameter("patient_id");

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
            while ((output = br.readLine()) != null) {

                JSONParser parser = new JSONParser();
                Object obj = parser.parse(output);
                JSONArray json = (JSONArray) obj;
                if(!json.isEmpty()) {
                    JSONObject jobj = (JSONObject) json.get(0);
                    doctor_id = (String) jobj.get("doctorId");
                    conditions = (String) jobj.get("conditions");
                    patient_id = (String) jobj.get("patientId");
                    symptoms = (String) jobj.get("symptoms");
                    isTobacco = (boolean ) jobj.get("isTobbaco");
                    medication = (String) jobj.get("prevMedication");
                    isAlchoholic = (boolean) jobj.get("isAlohocolic");
                    allergies = (String) jobj.get("allergies");
                    bp = (Long) jobj.get("bloodPressure");
                    sugar = (Double) jobj.get("sugarLevel");
                    weight = (Double) jobj.get("weight");
                    reason = (String) jobj.get("visit_reason");

                }
                else{
                    String redirect = "/ViewPatient.html";

                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
                    dispatcher.include(request, response);
                }

                //output.
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
        System.out.println("symptoms: "+symptoms);
        System.out.println("symptoms: "+allergies);
        System.out.println("symptoms: "+isTobacco);

        request.setAttribute("Condition", conditions);
        request.setAttribute("Symptoms", symptoms);
        request.setAttribute("Tobacco", isTobacco);
        request.setAttribute("Medication", medication);
        request.setAttribute("Allergies", allergies);
        request.setAttribute("Alchohol", isAlchoholic);
        request.setAttribute("Sugar", sugar);
        request.setAttribute("BP", bp);
        request.setAttribute("weight", weight);
        request.setAttribute("PatientId", patient_id);
        request.setAttribute("DoctorId", doctor_id);
        request.setAttribute("Reason", reason);

        String redirect = "/PrescriptionForm_Doctor.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
        dispatcher.include(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
