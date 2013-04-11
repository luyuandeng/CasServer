package com.gzeport.casserver.common;


public class ManifestFileManagerBean {
	String userName;//FTP用户�?
	String userPwd;//FTP密码
	String hostIp;//主机ip
	int  port = 0;//端口
	String remoteUploadDir;//上传文件�?
	String remoteDownDir;//下载文件�?
	boolean localbool=true  ;//是否备份本地目录
	String loccalBaseDir ;//本地根目�?
	String localBackupDir ;//本地备份目录
	
	public ManifestFileManagerBean() {
		super();
	}
	public ManifestFileManagerBean(String userName, String userPwd,
			String hostIp, int port, String remoteUploadDir,
			String remoteDownDir, boolean localbool, String loccalBaseDir,
			String localBackupDir) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.hostIp = hostIp;
		this.port = port;
		this.remoteUploadDir = remoteUploadDir;
		this.remoteDownDir = remoteDownDir;
		this.localbool = true;
		this.loccalBaseDir = loccalBaseDir;
		this.localBackupDir = localBackupDir;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getRemoteUploadDir() {
		return remoteUploadDir;
	}
	public void setRemoteUploadDir(String remoteUploadDir) {
		this.remoteUploadDir = remoteUploadDir;
	}
	public String getRemoteDownDir() {
		return remoteDownDir;
	}
	public void setRemoteDownDir(String remoteDownDir) {
		this.remoteDownDir = remoteDownDir;
	}
	public boolean isLocalbool() {
		return localbool;
	}
	public void setLocalbool(boolean localbool) {
		this.localbool = localbool;
	}
	public String getLoccalBaseDir() {
		return loccalBaseDir;
	}
	public void setLoccalBaseDir(String loccalBaseDir) {
		this.loccalBaseDir = loccalBaseDir;
	}
	public String getLocalBackupDir() {
		return localBackupDir;
	}
	public void setLocalBackupDir(String localBackupDir) {
		this.localBackupDir = localBackupDir;
	}
	

}
