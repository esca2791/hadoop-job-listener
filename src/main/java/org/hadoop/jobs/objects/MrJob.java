package org.hadoop.jobs.objects;

public class MrJob {

	private long mrJobId;

	private String jobId;

	private String jobName;

	private String jobStatus;

	private String owner;
	
	public long getMrJobId() {
		return mrJobId;
	}

	public void setMrJobId(long mrJobId) {
		this.mrJobId = mrJobId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
