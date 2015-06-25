package org.hadoop.jobs.dao;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobStatus;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.hadoop.jobs.MrListenerConfiguration;
import org.hadoop.jobs.objects.MrJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobHistoryService {

	@Autowired
	MrListenerConfiguration mrListenerConfiguration;

	public List<MrJob> getAllJobs() {
		List<MrJob> jobs = new ArrayList<MrJob>();
		String configurationPath = mrListenerConfiguration.getConfFilesPath();
		// Create JobClient
		YarnConfiguration yarnConfiguration = new YarnConfiguration();
		yarnConfiguration.addResource(new Path(configurationPath
				+ "core-site.xml"));
		yarnConfiguration.addResource(new Path(configurationPath
				+ "hdfs-site.xml"));
		yarnConfiguration.addResource(new Path(configurationPath
				+ "mapred-site.xml"));
		yarnConfiguration.addResource(new Path(configurationPath
				+ "yarn-site.xml"));
		Configuration configuration = new Configuration();
		configuration
				.addResource(new Path(configurationPath + "core-site.xml"));
		configuration
				.addResource(new Path(configurationPath + "hdfs-site.xml"));
		configuration.addResource(new Path(configurationPath
				+ "mapred-site.xml"));
		configuration
				.addResource(new Path(configurationPath + "yarn-site.xml"));

		UserGroupInformation.setConfiguration(configuration);
		try {
			UserGroupInformation.loginUserFromKeytab(
					mrListenerConfiguration.getKerberosUser(),
					mrListenerConfiguration.getKerberosKeytab());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String mrJobAddress = yarnConfiguration.get(mrListenerConfiguration
				.getJobHistoryServerProperty());
		String[] parts = mrJobAddress.split(":");
		InetSocketAddress jobtracker = null;
		jobtracker = new InetSocketAddress(parts[0], Integer.parseInt(parts[1]));
		JobClient jobClient = null;
		long counter = 0;
		try {
			jobClient = new JobClient(jobtracker, yarnConfiguration);
			for (JobStatus jobStatus : jobClient.getAllJobs()) {
				MrJob tmpjob = new MrJob();
				tmpjob.setJobId(jobStatus.getJobID().toString());
				tmpjob.setJobName(jobStatus.getJobName());
				tmpjob.setJobStatus(JobStatus.getJobRunState(jobStatus
						.getRunState()));
				tmpjob.setMrJobId(counter);
				tmpjob.setOwner(jobStatus.getUsername());
				counter++;
				jobs.add(tmpjob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobs;
	}

}
