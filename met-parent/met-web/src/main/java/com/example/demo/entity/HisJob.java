/**
 * 
 */
package com.example.demo.entity;

import javax.persistence.Table;

/**
 * @author Stronger
 * 历史执行任务
 */
@Table(name="TB_HISJOB")
public class HisJob {
	private int HISID;
	private String JOB_NAME;
	private String JOB_GROUP;
	private String JOB_CLASS_NAME;
	private String DESCRIPTION;

	public int getHISID() {
		return HISID;
	}

	public void setHISID(int hISID) {
		HISID = hISID;
	}

	public String getJOB_NAME() {
		return JOB_NAME;
	}

	public void setJOB_NAME(String jOB_NAME) {
		JOB_NAME = jOB_NAME;
	}

	public String getJOB_GROUP() {
		return JOB_GROUP;
	}

	public void setJOB_GROUP(String jOB_GROUP) {
		JOB_GROUP = jOB_GROUP;
	}

	public String getJOB_CLASS_NAME() {
		return JOB_CLASS_NAME;
	}

	public void setJOB_CLASS_NAME(String jOB_CLASS_NAME) {
		JOB_CLASS_NAME = jOB_CLASS_NAME;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

}
