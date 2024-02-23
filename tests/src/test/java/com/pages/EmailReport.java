package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.base.BaseClass;

public class EmailReport extends BaseClass {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		final String username = "mullai.m@greatify.ai";
		final String password = "xuvg szvx oase mysp";
		final String sender = "mullai.m@greatify.ai";
		final String receiver = "mullahrtr2@gmail.com";
		final String subject = "Subject: Completion of Automation Testing - Report Attached";
		final String body = "Hi Mullai,\n\nI hope this email finds you well.\nI am pleased to inform you that the automation testing has been successfully completed.\nThe detailed report has been compiled for your reference.\n\nAttachment Details:\n"
				+ "Report File: Automation Report\n" + "Instructions:\n"
				+ "Download the attached file. Open the file in a web browser for optimal\n"
				+ "viewing. Should you have any questions or require further clarification,\n"
				+ "please don't hesitate to reach out.\n" + "\n" + "Thank you for your attention to this matter.\n"
				+ "\n" + "Best Regards,\n" + "Mullai\n" + "Automation Tester\n" + "Greatify.ai\n";

		/*
		 * 
		 * Subject: Completion of Automation Testing - Report Attached
		 * 
		 * Hi [Recipient's Name],
		 * 
		 * I hope this email finds you well. I am pleased to inform you that the
		 * automation testing has been successfully completed. The detailed report has
		 * been compiled for your reference.
		 * 
		 * Attachment Details:
		 * 
		 * Report File: [Your_Attachment_File_Name.pdf] Instructions:
		 * 
		 * Download the attached file. Open the file in a web browser for optimal
		 * viewing. Should you have any questions or require further clarification,
		 * please don't hesitate to reach out.
		 * 
		 * Thank you for your attention to this matter.
		 * 
		 * Best Regards, [Your Name] [Your Position] [Your Company]
		 * 
		 */

		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);

			}

		});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress(sender));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));

			// Add the subject link
			message.setSubject(subject);

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText(body);

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = getPropertyFileValue("report");

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Has Been Sent Successfully=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

}
