package com.msedcl.mvc.main.util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.json.JSONObject;

public class CommonUtils {
	public static boolean sendEmail(final String fromEmail, final String password, String toEmail, String subject, String messageBody) {
        
        Properties props = new Properties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", "bulkmail.mahadiscom.in");
       props.put("mail.smtp.port", "587");
       
         Session session = Session.getInstance(props, new Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(fromEmail, password);
           }
       });
         
          try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(fromEmail));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
           message.setSubject(subject);
           message.setText(messageBody);

           Transport.send(message);
           System.out.println("Email sent successfully!");return true;
       } catch (MessagingException e) {
           e.printStackTrace();
           return false;
       }


         
         
         
       
       
       }
	
	public static void postOTPURL(String otp) throws MalformedURLException, IOException {

		 

        HttpURLConnection urlConnection = null;

        InputStream inputStream = null;

        InputStreamReader inputStreamReader = null;

        BufferedReader bufferedReader = null;

        String url = null;

        /**/

 

        JSONObject json = new JSONObject();

 

        /**/

        json.put("APPLICATION_ID", "80");

        json.put("SENDER_ID","MSEDCL");

     // need to find template number   
        json.put("SMS_TEMPLATE_NUMBER", "t400246");

           json.put("CARD_DATA","80-5555");

        //   json.put("CUST_REF_NUMBER","58-5555");
        
 String uniqueID = UUID.randomUUID().toString();
           json.put("CUST_REF_NUMBER","80-"+uniqueID);
 

       // json.put("MOBILE_NUMBER", obj.getMOBILE_NUMBER());
        
//hardcoded mobile no
     json.put("MOBILE_NUMBER", "7798089499");


        //params need to be passed by list

        json.put("F1", otp);

        //json.put("F2", obj.getF2());

 

        System.out.println(json.toString() + "json before calling");

 

                                               //URL urlObj = new URL("https://smsdlr.mahadiscom.in/smsReq/scheduleOTP");

     URL urlObj = new URL("http://10.10.130.162:8080/MsedclSMSApi-4.1/sendOTP");

        urlConnection = (HttpURLConnection) urlObj.openConnection();

 

        urlConnection.setRequestMethod("POST");

 

        urlConnection.setRequestProperty("Content-Type", "application/json");

        urlConnection.setRequestProperty("Accept", "application/json");

       

         urlConnection.setRequestProperty("X-API-BEARER", "80");

            urlConnection.setRequestProperty("X-API-TOKEN", "ETLRQEV5Y");

 

        urlConnection.setDoOutput(true);

 

        String smsResponse = "";

 

        try  {

 DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());

            //logger.info("JSON Input String for SMS: "+ json.toString());

            out.writeBytes(json.toString());

 

            out.flush();

 

            inputStream = urlConnection.getInputStream();

            if (inputStream != null) {

                inputStreamReader = new InputStreamReader(inputStream);

                bufferedReader = new BufferedReader(inputStreamReader);

                smsResponse = bufferedReader.readLine();

            }

            System.out.println("SMS Response: " + smsResponse);

        } catch (Exception e) {

            e.printStackTrace();

        }

 

    }




}
