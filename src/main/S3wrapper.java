package main;
import java.io.*;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import static main.ProcessPrescriptionServlet.doctor_id;


public class S3wrapper {

    private static String bucket_name     = "patient-history";
    private static AmazonS3 client;

    S3wrapper(){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIEJSVFYSVM6S6WMA", "PhN9yIniM/dkacTU6dHHn/PxZea7GiDwgJ2i1Ak+");
        client = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        client.getBucketLocation(bucket_name);
    }

    public String uploadToS3(String filepath, String patient_id, String date_of_visit, String doctor_id)

    {
        File file = new File(filepath);
      //  System.out.println("Uploading a new object to S3 from a file\n");

        //   String keyName  = UUID.randomUUID().toString();

        String keyName = date_of_visit + patient_id + doctor_id ;

        try {

            client.putObject(new PutObjectRequest(bucket_name, keyName, file));

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
        return keyName;
    }

    public S3Object downloadFromS3(String keyName)
    {

        System.out.println("Downloading an object from S3\n");

        try {

            S3Object s3object = client.getObject(
                    new GetObjectRequest(bucket_name, keyName));
            return s3object;
            //  displayTextInputStream(s3object.getObjectContent());


        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
        return null;

    }
    private static void displayTextInputStream(InputStream input)
            throws IOException {
        // Read one text line at a time and display.
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("    " + line);
        }
        System.out.println();
    }

}