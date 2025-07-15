package com.javaex.vo;

public class FileVO {
	
	//필드
	private String orgName;
	private String exname;
	private String savename;
	private String filePath;
	private Long filesize;
	
	
	//생성자
	public FileVO() {
	}
	public FileVO(String orgName, String exname, String savename, String filePath, Long filesize) {
		this.orgName = orgName;
		this.exname = exname;
		this.savename = savename;
		this.filePath = filePath;
		this.filesize = filesize;
	}
	
	
	//메소드 gs
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getExname() {
		return exname;
	}
	public void setExname(String exname) {
		this.exname = exname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Long getFilesize() {
		return filesize;
	}
	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	
	
	//메소드일반
	@Override
	public String toString() {
		return "FileVO [orgName=" + orgName + ", exname=" + exname + ", savename=" + savename + ", filePath=" + filePath
				+ ", filesize=" + filesize + "]";
	}
	
	

}
