package com.SapPortal.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="placement_datails")
public class PlacementDetails {


		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String placementpackage;
		private String imageUrl;
		private String name;
		private String companyname;
		private String module;
		private String placementYear;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPlacementpackage() {
			return placementpackage;
		}
		public void setPlacementpackage(String placementpackage) {
			this.placementpackage = placementpackage;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
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
		@Override
		public String toString() {
			return "PlacementDetails [id=" + id + ", placementpackage=" + placementpackage + ", imageUrl=" + imageUrl
					+ ", name=" + name + ", companyname=" + companyname + ", module=" + module + ", placementYear="
					+ placementYear + "]";
		}
		
		
		

	
		

	}



