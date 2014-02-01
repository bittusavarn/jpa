package com.massiverun.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author Nilamber Kumar
 *
 */
@Entity
@Table(name="material")
public class Material implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="url")
	private String url;
	
	@Column(name="file_name")
	private String fileName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="material_type")
	private MaterialType materialType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}




	/**
	 * 
	 * Material Type
	 *
	 */
	public static enum MaterialType
	{
		ADMIN("premium"),
		USER("user");
		
		private  String materialType;
		private MaterialType(String materialType)
		{
			this.materialType=materialType;
		}
		
		
		public static MaterialType getMaterialType(String materialTypeVal)
		{
			for(MaterialType materialType:values())
			{
				if(materialType.getMaterialType().equals(materialTypeVal))
				{
					return materialType;
				}
			}
			return null;
		}


		public String getMaterialType() {
			return materialType;
		}


		public void setMaterialType(String materialType) {
			this.materialType = materialType;
		}


		
	}
	
}
