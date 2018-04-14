package com.main.Log4j.Log4j_Dlog4j.configuration_03;


import org.apache.log4j.Logger;

/**
 * Created by asus on 2016/12/25.
 */
public class EmployeeService {
    public static final Logger logger = Logger.getLogger(UserService.class);

    /**
     * debug<info<warn<error<fatal   会显示日志级别设定值之上的日志
     */
    public void add() {
        logger.debug("debug 信息");
        logger.info("Info 信息");
        logger.warn("warn 信息");
        logger.error("error 信息");
        logger.fatal("fatal 信息");
    }
}
