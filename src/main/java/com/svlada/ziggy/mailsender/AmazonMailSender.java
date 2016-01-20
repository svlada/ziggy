package com.svlada.ziggy.mailsender;

import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.svlada.ziggy.Email;

public class AmazonMailSender implements MailSender {
	
	private static final Logger logger = Logger.getLogger(AmazonMailSender.class);

	private final Regions region; 
	
	private AmazonMailSender(final Regions region) {
		this.region = region;
	}
	
	public static AmazonMailSender of(final Regions region) {
		return new AmazonMailSender(region);
	}
	
	public void send(Email email) {
		send(email, this.region);
	}
	
	public void send(Email email, Regions region) {
		// Setup recepient list
		Destination destination = new Destination().withToAddresses(
				email.getTo().stream().map(e -> e.toString()).collect(Collectors.toList()));
		
		// Create the subject and body of the message.
	    Content emailSubject = new Content().withData(email.getSubject().toString());
	    Body emailBody = new Body().withHtml(new Content().withData(email.getContent().toString()));
	    
        // Create a message with the specified subject and body.
        Message message = new Message().withSubject(emailSubject).withBody(emailBody);
        
        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest().withSource(email.getFrom().toString()).withDestination(destination).withMessage(message);
		
        logger.info("Attempting to send an email through Amazon SES by using the AWS SDK for Java.");
        
        // Instantiate an Amazon SES client, which will make the service call. The service call requires your AWS credentials. 
        // Because we're not providing an argument when instantiating the client, the SDK will attempt to find your AWS credentials 
        // using the default credential provider chain. The first place the chain looks for the credentials is in environment variables 
        // AWS_ACCESS_KEY_ID and AWS_SECRET_KEY. 
        // For more information, see http://docs.aws.amazon.com/AWSSdkDocsJava/latest/DeveloperGuide/credentials.html
        AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient();
        
        // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your sandbox 
        // status, sending limits, and Amazon SES identity-related settings are specific to a given AWS 
        // region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using 
        // the US West (Oregon) region. Examples of other regions that Amazon SES supports are US_EAST_1 
        // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html 
        client.setRegion(Region.getRegion(region));
        
        // Send the email.
        client.sendEmail(request); 
	}
	
}
