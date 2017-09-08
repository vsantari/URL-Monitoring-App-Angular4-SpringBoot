package com.urlmonitor.model.Url;

public class URL {
	private int id;
	private String timestamp;
	private String url;
	private String status;
	private String responseTime;
	private int retry;
	private String error;

	public URL(){
	}

	public URL(String timestamp, String url, String status, String responseTime, int retry, String error ){
		this.timestamp = timestamp;
		this.url = url;
		this.status = status;
		this.responseTime = responseTime;
		this.retry = retry;
		this.error = error;
	}

	public URL(int id, String timestamp, String url, String status, String responseTime, int retry, String error ){
		this.id = id;
		this.timestamp = timestamp;
		this.url = url;
		this.status = status;
		this.responseTime = responseTime;
		this.retry = retry;
		this.error = error;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
	
	public String getTimestamp(){
		return this.timestamp;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return this.status;
	}

	public void setResponseTime(String responseTime){
		this.responseTime = responseTime;
	}

	public String getResponseTime(){
		return this.responseTime;
	}

	public void setRetry(int retry){
		this.retry = retry;
	}

	public int getRetry(){
		return this.retry;
	}

	public void setError(String error){
		this.error = error;
	}
	
	public String getError(){
		return this.error;
	}
}
