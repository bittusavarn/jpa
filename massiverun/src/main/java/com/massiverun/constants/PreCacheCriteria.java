package com.massiverun.constants;


import java.io.InputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.codehaus.jettison.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 * @author Nilamber Kumar
 * Class to load and check whether 
 * data is cacheable a/c to Precache Criteria 
 */

public class PreCacheCriteria implements InitializingBean{

	Logger looger=LoggerFactory.getLogger(PreCacheCriteria.class);
	
	private List<SearchCityCiteria> searchcities;
	private Document document;
	public PreCacheCriteria()
	{
		
	}
	
	/**
	 * load pre cache criteria
	 * @param ins
	 */
	public void loadPreCacheCriteria(InputStream ins)
	{
		try
		{
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			try 
			{
				document = builder.parse(ins);
				populateSearchCitiesCriteria();
			} 
			catch(Exception ex) 
			{
				
					looger.debug("Exception in Parsing criteria"+ex.getMessage());
			}
			finally
			{
				ins.close();
			}
		} catch (Exception e)
		{
			looger.debug("Exception while creating document builder"+e);
		}
	}

	/**
	 * populate SearchCities Criteria
	 * @throws Exception
	 */
	public void populateSearchCitiesCriteria() throws Exception 
	{
		NodeList elems = document.getElementsByTagName("DmcCode");
		for (int i = 0; i < elems.getLength(); i++) 
		{
//			SearchCityCiteria criteria=new SearchCityCiteria();
//			Element element=(Element)elems.item(0);
//			criteria.setCityCode(element.getAttribute("citycode"));
//			criteria.setCountryCode(element.getAttribute("countrycode"));
//			criteria.setIdContext(element.getAttribute("idContext"));
//			String startDateString=element.getAttribute("startDate");
//			String numOfNights=element.getAttribute("numOfNights");
//			String numOfAdults=element.getAttribute("numOfAdults");
//			criteria.setStartDate(startDateString.split(","));
//			criteria.setNumOfAdults(numOfAdults.split(","));
//			criteria.setNumOfNights(numOfNights.split(","));
			//searchcities.add(criteria);
			Node node=(Node)elems.item(i);
			
			
		}
	}
	/**
	 * check whether result is cacheable or not
	 * @param cityCode
	 * @param countryCode
	 * @param idContext
	 * @param noOfNights
	 * @param numOfAdults
	 * @param checkInDate
	 * @return
	 */
	public Boolean isCacheable(String cityCode,String countryCode,String idContext,int noOfNights,int noOfAdults,Date checkInDate)
	{
		try
		{
			for(SearchCityCiteria searchCriteria:searchcities)
			{
				if(cityCode.equals(searchCriteria.getCityCode())&&(countryCode.equals(searchCriteria.getCountryCode()))&&(idContext.equals(searchCriteria.getIdContext()))&&(checkInDateValid(checkInDate, searchCriteria.getStartDate()))&&(noOfAdultsValid(noOfAdults, searchCriteria.getNumOfAdults())&&(noOfNightsValid(noOfNights, searchCriteria.getNumOfNights()))))
				{
					return Boolean.TRUE;
				}
			}
		}
		catch (Exception e) 
		{
			looger.error("Exception in Matching Criteria"+e.getMessage());
			return Boolean.FALSE;
		}
		
		return Boolean.FALSE;
	}
	
	private  class SearchCityCiteria
	{
		private String cityCode;
		private String countryCode;
		private String idContext;
		private String[]  startDate;
		private String[] numOfNights;
		private String[] numOfAdults;
		public String getCityCode() {
			return cityCode;
		}
		public void setCityCode(String cityCode) {
			this.cityCode = cityCode;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
		public String getIdContext() {
			return idContext;
		}
		public void setIdContext(String idContext) {
			this.idContext = idContext;
		}
		public String[] getStartDate() {
			return startDate;
		}
		public void setStartDate(String[] startDate) {
			this.startDate = startDate;
		}
		public String[] getNumOfNights() {
			return numOfNights;
		}
		public void setNumOfNights(String[] numOfNights) {
			this.numOfNights = numOfNights;
		}
		public String[] getNumOfAdults() {
			return numOfAdults;
		}
		public void setNumOfAdults(String[] numOfAdults) {
			this.numOfAdults = numOfAdults;
		}
		
		
		
	}
	
	/**
	 * 
	 * @param checkInDate
	 * @param dateNos
	 * @return
	 */
	private Boolean checkInDateValid(Date checkInDate,String[] dateNos)
	{
		long currentTime=new Date().getTime();
		long checkInTime=checkInDate.getTime();
		long dayDiff=(checkInTime-currentTime)/(1000*60*60*24);
		int firstDayNum=Integer.parseInt(dateNos[0]);
		int lastdayNum=Integer.parseInt(dateNos[dateNos.length-1]);
		if((dayDiff>=firstDayNum)&&(dayDiff<=lastdayNum))
		{
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	/**
	 * 
	 * @param checkInDate
	 * @param dateNos
	 * @return
	 */
	private Boolean noOfAdultsValid(int noOfAdults,String[] adults)
	{
		int firstAdultCount=Integer.parseInt(adults[0]);
		long lastAdultCount=Integer.parseInt(adults[adults.length-1]);
		if((noOfAdults>=firstAdultCount)&&(noOfAdults<=lastAdultCount))
		{
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	/**
	 * 
	 * @param checkInDate
	 * @param dateNos
	 * @return
	 */
	private Boolean noOfNightsValid(int noOfNights,String[] nights)
	{
		int firstNightCount=Integer.parseInt(nights[0]);
		long lastNightCount=Integer.parseInt(nights[nights.length-1]);
		if((noOfNights>=firstNightCount)&&(noOfNights<=lastNightCount))
		{
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public void afterPropertiesSet() throws Exception {
		searchcities=new ArrayList<PreCacheCriteria.SearchCityCiteria>();
		loadPreCacheCriteria(new ClassPathResource("preCache.xml").getInputStream());
	}
	
}
