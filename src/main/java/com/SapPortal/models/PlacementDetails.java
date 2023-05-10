package com.SapPortal.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="placement_datails")
public class PlacementDetails {


		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@Column(name="packages")
		private Float packages;
		private String name;
		private String companyname;
		private String module;
		private String placementYear;
	    private String studentfilename;
	    private String studentfiletype;
	    @Lob
	    @Column(name = "imagedata",length = 1000)
	    private byte[] studentimageData;
	    
	    

		public String getStudentfilename() {
			return studentfilename;
		}
		public void setStudentfilename(String studentfilename) {
			this.studentfilename = studentfilename;
		}
		public String getStudentfiletype() {
			return studentfiletype;
		}
		public void setStudentfiletype(String studentfiletype) {
			this.studentfiletype = studentfiletype;
		}
		public byte[] getStudentimageData() {
			return studentimageData;
		}
		public void setStudentimageData(byte[] studentimageData) {
			this.studentimageData = studentimageData;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
	

		
	
		
		public Float getPackages() {
			return packages;
		}
		public void setPackages(Float packages) {
			this.packages = packages;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCompanyname() {
			return companyname;
		}
		public void setCompanyname(String companyname) {
			this.companyname = companyname;
		}
		public String getModule() {
			return module;
		}
		public void setModule(String module) {
			this.module = module;
		}
		public String getPlacementYear() {
			return placementYear;
		}
		public void setPlacementYear(String placementYear) {
			this.placementYear = placementYear;
		}
		
		
		
		

	
		

	}



