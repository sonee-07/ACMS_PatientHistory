package main;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "SendToS3Servlet")
public class SendToS3Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Send to S3 servlet talking..");
        String patient_id = request.getParameter("patient_id");
        String medicines = request.getParameter("medication");
        String alergies = request.getParameter("allergies");
        String symptoms=request.getParameter("symptoms");
        String tobacco = request.getParameter("tobacco");
        String alchohol = request.getParameter("alchohol");
        String patient_weight = request.getParameter("weight");
        String patient_sugar = request.getParameter("sugar");
        String patient_bp = request.getParameter("bp");
        String doctor_id = request.getParameter("doctor_id");
        String condition=request.getParameter("condition");

        LocalDate dtf =java.time.LocalDate.now();

        System.out.println("doctid " +doctor_id);

        String patient_alc = alchohol;

        PDDocument document = new PDDocument();

        //Saving the document
        String file_name = "/home/lenovo/Desktop/"+patient_id+"";
        document.save(file_name);
        for (int i=0; i<1; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();

            //Adding the blank page to the document
            document.addPage( blankPage );
        }


        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        //Begin the Content stream
        contentStream.beginText();

        //Setting the font to the Content stream
        contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );

        //Setting the leading
        contentStream.setLeading(14.5f);

        //Setting the position for the line
        contentStream.newLineAtOffset(25, 725);


        //Adding text in the form of string
        contentStream.showText("Patient Id:   " +patient_id);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Patient Weight Recorded: " + patient_weight);
        contentStream.newLine();
        contentStream.newLine();


        contentStream.showText("Patient SugarLevel Recorded: " + patient_sugar);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Patient Bp recorded: " + patient_bp);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Condition:   " + condition);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Symptoms Observed:   " + symptoms);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Medication: " + medicines);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Alergies Found: " + alergies);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Alchohol: " + patient_alc);
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Tobacco: " + tobacco);
        contentStream.newLine();
        contentStream.newLine();


        //Ending the content stream
        contentStream.endText();

     //   System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        document.save(new File(file_name));
        document.close();
        //call the wrapper class to S3
        String keyStr = uploadDoc(file_name,patient_id,dtf.toString(),doctor_id);

        File f = new File(file_name);
        f.delete();

        //add location of form in the database
        //Call to api
        updateTable(patient_id, doctor_id, keyStr);
      //  System.out.println("doc closed");




        RequestDispatcher rd=request.getRequestDispatcher("ViewPatient.html");

        rd.include(request,response);

    }

    public  String uploadDoc(String filepath, String patient_id, String date_of_visit, String doctor_id){

        S3wrapper w = new S3wrapper();
        return w.uploadToS3(filepath,patient_id,date_of_visit, doctor_id);

    }

    public static void updateTable(String patient_id, String doctor_id, String link){

         	/*	try {
		  		URL url = new URL("http://ec2-52-66-43-37.ap-south-1.compute.amazonaws.com:8080/EHR-PatientHistoryService/api/patientHistory/Zf7NwmWcchWg4ztNFnWlaKrPFOlPFrtr");
		  		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		  		conn.setRequestMethod("GET");
		  		conn.setRequestProperty("Accept", "application/json");

		  		if (conn.getResponseCode() != 200) {
		  			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		  		}

		  		BufferedReader br = new BufferedReader(new InputStreamReader(
		  			(conn.getInputStream())));

		  		String output;
		  		System.out.println("Output from Server .... \n");
		  		while ((output = br.readLine()) != null) {
		  			System.out.println("hey output");
		  			System.out.println(output);
		  		}

		  		conn.disconnect();

		  	  } catch (MalformedURLException e) {

		  		e.printStackTrace();

		  	  } catch (IOException e) {

		  		e.printStackTrace();

		  	  }

		  	  */

    }
}
