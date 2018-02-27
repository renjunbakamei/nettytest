package com.jfpay.entity.DO;

import org.apache.ibatis.type.Alias;

import com.jfpay.base.entity.BaseEntity;

@Alias(value="LinkBlacklistPic")
public class LinkBlacklistPic extends BaseEntity{

		private static final long serialVersionUID = -8057169641501207022L;
		//columns START
		/** 变量 id . */
		private Integer id;
		/** 变量 mobileNo . */
		private String mobileNo;
		/** 变量 picPath . */
		private String picPath;
		
		private int num;
		private String fileName;
		private String imageId;
		private String personUuid;
		private String dbName;
		private String status;
		//columns END

		/**
		* LinkBlacklistPic 的构造函数
		*/
		public LinkBlacklistPic() {
		}
		/**
		* LinkBlacklistPic 的构造函数
		*/
		public LinkBlacklistPic(
			Integer id
		) {
			this.id = id;
		}


		public void setId(Integer value) {
			this.id = value;
		}
		
		public Integer getId() {
			return this.id;
		}
		
		//public Integer getPk() {
			//return this.id;
		//}

		public void setMobileNo(String value) {
			this.mobileNo = value;
		}
		
		public String getMobileNo() {
			return this.mobileNo;
		}

		public void setPicPath(String value) {
			this.picPath = value;
		}
		
		public String getPicPath() {
			return this.picPath;
		}
		
		public int getNum() {
			return num;
		}
		
		public void setNum(int num) {
			this.num = num;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getImageId() {
			return imageId;
		}
		public void setImageId(String imageId) {
			this.imageId = imageId;
		}
		public String getPersonUuid() {
			return personUuid;
		}
		public void setPersonUuid(String personUuid) {
			this.personUuid = personUuid;
		}
		public String getDbName() {
			return dbName;
		}
		public void setDbName(String dbName) {
			this.dbName = dbName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		

	}