package org.neojo.web.entity;

public class M3U8 {
	private Integer PROGRAM_ID;
	private Integer BANDWIDTH;
	private String RESOLUTION;
	private Integer RESOLUTION_INT;
	private String CODECS;
	private Float EXTINF;
	private String FILENAME;
	public Integer getPROGRAM_ID() {
		return PROGRAM_ID;
	}
	public void setPROGRAM_ID(Integer pROGRAM_ID) {
		PROGRAM_ID = pROGRAM_ID;
	}
	public Integer getBANDWIDTH() {
		return BANDWIDTH;
	}
	public void setBANDWIDTH(Integer bANDWIDTH) {
		BANDWIDTH = bANDWIDTH;
	}
	public String getRESOLUTION() {
		return RESOLUTION;
	}
	public void setRESOLUTION(String rESOLUTION) {
		RESOLUTION = rESOLUTION;
		String temp[] = rESOLUTION.split("x");
		if(temp.length==2){
			RESOLUTION_INT = Integer.parseInt(temp[0])*Integer.parseInt(temp[1]);
		}
	}
	public Integer getRESOLUTION_INT() {
		if(RESOLUTION_INT == null)
			return 0;
		return RESOLUTION_INT;
	}
	public String getCODECS() {
		return CODECS;
	}
	public void setCODECS(String cODECS) {
		CODECS = cODECS;
	}
	public String getFILENAME() {
		return FILENAME;
	}
	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}
	public Float getEXTINF() {
		if(EXTINF == null)
			return 0F;
		return EXTINF;
	}
	public void setEXTINF(float eXTINF) {
		EXTINF = eXTINF;
	}
	
	
}
