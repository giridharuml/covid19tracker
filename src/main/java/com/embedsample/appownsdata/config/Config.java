package com.embedsample.appownsdata.config;

/**
 * Configuration class
 */
public abstract class Config {
	
	// Set this to true, to show debug statements in console
	public static final boolean DEBUG = false;
	
	//	Two possible Authentication methods: 
	//	- For authentication with master user credential choose MasterUser as AuthenticationType.
	//	- For authentication with app secret choose ServicePrincipal as AuthenticationType.
	//	More details here: https://aka.ms/EmbedServicePrincipal
	public static final String authenticationType = "ServicePrincipal";
	
	// Enter workspaceId / groupId
	//	Common configuration properties for both authentication types
	public static final String groupId = "190fe96d-e7e4-430d-8a35-7a7a9adfcf46";
	

	// The id of the report to embed.
	public static final String reportId = "2c4029a8-6e1a-4076-bfda-b66d1ca46176";

	// Enter Application Id / Client Id
	public static final String clientId = "a1eaa85f-8992-47fa-8fbe-9af3af9ec392";
			

	// Enter MasterUser credentials
	public static final String pbiUsername = "powerbiadmin@giridharumlhotmail.onmicrosoft.com";
		
	public static final String pbiPassword = "Boston123!";

	
	// Enter ServicePrincipal credentials
	public static final String tenantId = "f15161a5-852a-4793-bcbc-c9da0844640d";
	
	public static final String appSecret = "jgV+h0oFCXOt9eDoCnY36s+iTiT/+5CRNbK8t/UuLOs=";
		
	//	DO NOT CHANGE
	public static final String authorityUrl = "https://login.microsoftonline.com/";
	
	public static final String scopeUrl = "https://analysis.windows.net/powerbi/api/.default";
	
	
	private Config(){
		//Private Constructor will prevent the instantiation of this class directly
		throw new IllegalStateException("Config class");
	}
	
}