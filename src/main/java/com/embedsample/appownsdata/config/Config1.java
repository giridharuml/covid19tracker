package com.embedsample.appownsdata.config;

/**
 * Configuration class
 */
public abstract class Config1 {
	
	// Set this to true, to show debug statements in console
	public static final boolean DEBUG = false;
	
	//	Two possible Authentication methods: 
	//	- For authentication with master user credential choose MasterUser as AuthenticationType.
	//	- For authentication with app secret choose ServicePrincipal as AuthenticationType.
	//	More details here: https://aka.ms/EmbedServicePrincipal
	public static final String authenticationType = "ServicePrincipal";
	
	//	Common configuration properties for both authentication types
	// Enter workspaceId / groupId
	public static final String groupId = "5cd97831-92a2-45f5-a74b-86438f01b303";

	// The id of the report to embed.
	public static final String reportId = "96671aa9-968a-4218-9764-a8f83f490f1a";

	// Enter Application Id / Client Id
	public static final String clientId = "2da891d6-89ff-4675-acbd-eaa0cd3ce0a8";

	// Enter MasterUser credentials
	public static final String pbiUsername = "powerbiadmin@giridharumlhotmail.onmicrosoft.com";
	public static final String pbiPassword = "Boston123!";

	// Enter ServicePrincipal credentials
	public static final String tenantId = "f15161a5-852a-4793-bcbc-c9da0844640d";
	public static final String appSecret = "m8CGZ/+2XSIQjAy8wThlXbGjtwEDZvnfLVX5xdsDnmc=";
		
	//	DO NOT CHANGE
	public static final String authorityUrl =  //"https://login.microsoftonline.com/common/";
	//"https://login.microsoftonline.com/common/oauth2/authorize" ;// 
	"https://login.microsoftonline.com/";
	public static final String scopeUrl = //"https://analysis.windows.net/powerbi/api";
	"https://analysis.windows.net/powerbi/api/.default";
	
	
	private Config1(){
		//Private Constructor will prevent the instantiation of this class directly
		throw new IllegalStateException("Config class");
	}
	
}