package org.hadoop.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MrListenerConfiguration {

	@Autowired
	public MrListenerConfiguration(
			@Value("${conf.files.path}") String configurationPath,
			@Value("${kerberos.user}") String kerberosUser,
			@Value("${kerberos.realm}") String kerberosRealm,
			@Value("${kerberos.keytab}") String kerberosKeytab,
			@Value("${job.history.server.property}") String jobHistoryServerProperty) {
		this.setConfFilesPath(configurationPath);
		this.setKerberosUser(kerberosUser);
		this.setKerberosRealm(kerberosRealm);
		this.setKerberosKeytab(kerberosKeytab);
		this.setJobHistoryServerProperty(jobHistoryServerProperty);
	}

	private String confFilesPath;

	private String kerberosUser;

	private String kerberosRealm;

	private String kerberosKeytab;

	private String jobHistoryServerProperty;

	public String getConfFilesPath() {
		return confFilesPath;
	}

	public void setConfFilesPath(String confFilesPath) {
		this.confFilesPath = confFilesPath;
	}

	public String getKerberosUser() {
		return kerberosUser;
	}

	public void setKerberosUser(String kerberosUser) {
		this.kerberosUser = kerberosUser;
	}

	public String getKerberosRealm() {
		return kerberosRealm;
	}

	public void setKerberosRealm(String kerberosRealm) {
		this.kerberosRealm = kerberosRealm;
	}

	public String getKerberosKeytab() {
		return kerberosKeytab;
	}

	public void setKerberosKeytab(String kerberosKeytab) {
		this.kerberosKeytab = kerberosKeytab;
	}

	public String getJobHistoryServerProperty() {
		return jobHistoryServerProperty;
	}

	public void setJobHistoryServerProperty(String jobHistoryServerProperty) {
		this.jobHistoryServerProperty = jobHistoryServerProperty;
	}

}
