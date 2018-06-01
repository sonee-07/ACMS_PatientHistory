package main;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONObject;
import org.apache.http.client.HttpClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.http.impl.client.DefaultHttpClient;


@WebServlet(name = "PatientForm_HandlerServlet")
public class PatientForm_HandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String doctor_id = request.getParameter("doctor_id");
        String patient_id = request.getParameter("patient_id");
        String medicines = request.getParameter("Medication");
        String alergies = request.getParameter("alergies");
        String condition = request.getParameter("select_condition");
        String tobacco = request.getParameter("tobacco");
        String alchohol = request.getParameter("Alchohol");
        String[] check_box_symp = request.getParameterValues("symp");
        String patient_weight = request.getParameter("weightLevel");
        String patient_sugar = request.getParameter("sugarLevel");
        String patient_bp = request.getParameter("bpLevel");
        String[] symptoms = {"symptom1", "symptom2", "symptom3", "symptom4", "symptom5"};
        String visit_reason = request.getParameter("reason");
        String[] symptom1_conditions = {"Lower back pain", "Inability to stand", "Unable to bend", "Unable to walk", "Difficulty to sit"};
        String[] symptom2_conditions = {"Muscle pain", "Rashes", "Fever", "Nausea", "Loss of appetite"};
        String[] symptom3_conditions = {"Sudden weightloss", "Always thirsty", "Heavy breathing", "Slow healing cuts", "Nausea"};
        String[] symptom4_conditions = {"TenderScalp", "Mild Headache", "Depressed", "Dizziness", "Nasal congestion"};
        String[] symptom5_conditions = {"Head ache", "Fever", "Cold", "Cough", "Body pains"};
        LocalDate dtf =java.time.LocalDate.now();
        String urlName = dtf.toString() + patient_id + doctor_id ;
        String selectedSymps[] = {};

        if (condition.equals("Backpain")) {
            selectedSymps = symptom1_conditions.clone();
        } else if (condition.equals("Thyphoid")) {
            selectedSymps = symptom2_conditions.clone();
        } else if (condition.equals("Diabetes")) {
            selectedSymps = symptom3_conditions.clone();
        } else if (condition.equals("Migrane")) {
            selectedSymps = symptom4_conditions.clone();
        } else if (condition.equals("General")) {
            selectedSymps = symptom5_conditions.clone();
        }

        int checked_symps;

        String symptoms_patient = "";

        for (int i = 0; i < check_box_symp.length - 1; i++) {
            checked_symps = Integer.parseInt(check_box_symp[i]);
            //System.out.println(checked_symps);
            symptoms_patient = symptoms_patient + selectedSymps[checked_symps] + " , ";
        }
        if (check_box_symp.length > 0) {
            checked_symps = Integer.parseInt(check_box_symp[check_box_symp.length - 1]);
            symptoms_patient = symptoms_patient + selectedSymps[checked_symps];
        }

        String medications_taken = "none";
        if (medicines.equals("Yes")) {
            medications_taken = request.getParameter("text_medication");
        }

        String patient_alc = "none";

        if(alchohol.equals("Yes_alc")) {
            patient_alc = "Frequently";
        }
        else if(alchohol.equals("No_alc")) {
            patient_alc = "No";
        }
        else if(alchohol.equals("Week_alc")) {
            patient_alc = "Weekly";
        }
        else if(alchohol.equals("Month_alc")) {
            patient_alc = "Monthly";
        }
        String patient_alergies = "none";

        if (alergies.equals("Yes")) {
            patient_alergies = request.getParameter("text_alergies");
        }


     //   System.out.println(condition);


	put_data_patient_history_tbl(patient_id, doctor_id, condition, symptoms_patient, tobacco, medications_taken, patient_alc, patient_alergies, patient_weight, patient_bp, patient_sugar,visit_reason,urlName);
        String redirect = "/PatientForm_Nurse.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirect);
        dispatcher.include(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private static void put_data_patient_history_tbl(String patient_id, String doctor_id, String condition, String symptoms_patient, String tobacco, String medications_taken,String patient_alc, String patient_alergies,String patient_weight, String patient_bp,String patient_sugar, String visit_reason, String urlName) {
        String result = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost("http://13.127.188.57:8080/PatientHealthHistoryAPI/webapi/patient_history/add_history");


            JSONObject jsonParam = new JSONObject();

            boolean alc_taking = false;
            if(!patient_alc.equals("none"))
                alc_taking= true;
            boolean tobacco_taking = false;
            if(tobacco.equals("Yes"))
                tobacco_taking = true;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
            LocalDateTime now = LocalDateTime.now();

            String s = formatter.format(now);

            jsonParam.put("patientId", patient_id);
            jsonParam.put("conditions", condition);
            jsonParam.put("symptoms",  symptoms_patient);
            jsonParam.put("isTobbaco", tobacco_taking);
            jsonParam.put("prevMedication", medications_taken);
            jsonParam.put("isAlohocolic", alc_taking);
            jsonParam.put("allergies", patient_alergies);
            jsonParam.put("date", java.time.LocalDate.now().toString());
            jsonParam.put(  "prescription_file_url",urlName);
            jsonParam.put("doctorId", doctor_id);
            jsonParam.put("bloodPressure", patient_bp);
            jsonParam.put("sugarLevel", patient_sugar);
            jsonParam.put("weight", patient_weight);
            jsonParam.put("visit_reason", visit_reason);





            //  jsonParam.put("weight", Integer.parseInt(patient_weight));
            //jsonParam.put("sugar", Integer.parseInt(patient_sugar));
            //jsonParam.put("bp", Integer.parseInt(patient_bp));
            //jsonParam.put("weight", Integer.parseInt(patient_weight));
         //   System.out.println("Json"+jsonParam.toString());

            String json = jsonParam.toString();

            StringEntity se = new StringEntity(json);

            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
            InputStream inputStream;
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if(inputStream != null) {
                result = convertInputStreamToString(inputStream);
                System.out.println(result);
                System.out.println(result); System.out.println(result); System.out.println(result);
            }
            else
            {
                result = "Did not work!";
                System.out.println("Didnt work");
                System.out.println("Didnt work");System.out.println("Didnt work");System.out.println("Didnt work");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAlphaNumeric(int len) {
        char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z' };

        char[] c=new char[len];
        Random random=new Random();
        for (int i = 0; i < len; i++) {
            c[i]=ch[random.nextInt(ch.length)];
        }

        return new String(c);
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

}
