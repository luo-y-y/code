package com.config.quartz;

import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author luoyang@Configuration
 * @EnableScheduling
 * @EnableAutoConfiguration
 *
 */
@Configuration
public class QuartzConfig {

	/**
	 * 如果多个项目共用同一个定时任务的 数据库，需要各自指定不通的组名
	 */
	public static final String Quartz_Group_Name = "smk_activity";
	
	/**
	 * 如果多个项目共用同一个定时任务的 数据库，需要各自指定不通的定时任务工厂名称
	 */
	public static final String Quartz_Scheduler_Name = "smk_activity_boot_scheduler";

	/*@Bean(name = Quartz_Scheduler_Name)
	public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("dataSource") DataSource dataSource, @Qualifier("jobTlTravelMinTaskTrigger") Trigger jobTlTravelMinTaskTrigger) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		// 用于quartz集群,QuartzScheduler
		// 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
		factory.setOverwriteExistingJobs(true);
		// 用于quartz集群,加载quartz数据源
		factory.setDataSource(dataSource);
		// QuartzScheduler 延时启动，应用启动完10秒后 QuartzScheduler 再启动
		factory.setStartupDelay(1);
		// 用于quartz集群,加载quartz数据源配置
		// factory.setQuartzProperties(quartzProperties());
		// factory.setAutoStartup(true);
		factory.setApplicationContextSchedulerContextKey("applicationContextKey");
		// 注册触发器
		// factory.getScheduler().pauseAll();
		factory.setTriggers(jobTlTravelMinTaskTrigger);// 直接使用配置文件
		// factory.setConfigLocation(new
		// FileSystemResource(this.getClass().getResource("/quartz.properties").getPath()));
		return factory;
	}

	*//**
	 * attention: Details：配置定时任务
	 *//*
	@Bean(name = "jobTlTravelMinTaskBean")
	public JobDetailFactoryBean createJobTlTravelMinTaskBean() {// ScheduleTask为需要执行的任务
		JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
		jobDetail.setJobClass(JobTlTravelMinTaskBean.class);
		jobDetail.setDurability(true);
		jobDetail.setRequestsRecovery(true);
		jobDetail.setGroup(Quartz_Group_Name);
		return jobDetail;
	}

	*//**
	 * attention: Details：配置定时任务的触发器，也就是什么时候触发执行定时任务
	 *//*
	@Bean(name = "jobTlTravelMinTaskTrigger")
	public CronTriggerFactoryBean cronJobTrigger(JobDetailFactoryBean jobTlTravelMinTaskBean) {
		CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
		tigger.setJobDetail(jobTlTravelMinTaskBean.getObject());
		tigger.setCronExpression("0 0/2 * * * ?");// 初始时的cron表达式 ，没2分钟执行一次
		tigger.setGroup(Quartz_Group_Name);
		return tigger;

	}*/

}
