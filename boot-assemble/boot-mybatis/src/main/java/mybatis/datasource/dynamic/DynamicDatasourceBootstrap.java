package mybatis.datasource.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/17
 */
@SpringBootApplication
public class DynamicDatasourceBootstrap implements CommandLineRunner {

    public static void main(String[] args) throws IOException {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        try {
            yaml.setResources(new ClassPathResource("classpath:application-dynamic.properties"));
        }catch (Exception e){

        }
        Properties properties =  yaml.getObject();
        SpringApplication springApplication=new SpringApplication();
        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
//        /**
//         * 获取maste数据库信息
//         */
//        DataSourceContextHolder.setDBType("default");
//        List<UserInfo> userInfoList = userService.getUserInfo();
//        userInfoList.stream().forEach(userInfo -> System.out.println("name is : " + userInfo.getName() + "; sex is : " + userInfo.getSex() + "; age is : " + userInfo.getAge()));
//
//        /**
//         * 根据slave数据源获取目标数据库信息
//         */
//        DataSourceContextHolder.setDBType("master");
//        int primayrId = 1;
//        DBInfo dbInfo = dbService.getDBInfoByprimayrId(primayrId);
//        System.out.println("dbName is -> " + dbInfo.getDbName() + "; dbIP is  -> " + dbInfo.getDbIp() + "; dbUser is  -> " + dbInfo.getDbUser() + "; dbPasswd is -> " + dbInfo.getDbPasswd());
//
//        DruidDataSource dynamicDataSource = new DruidDataSource();
//        dynamicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dynamicDataSource.setUrl("jdbc:mysql://" + dbInfo.getDbIp() + ":" + dbInfo.getDbPort() + "/" + dbInfo.getDbName() + "?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull");
//        dynamicDataSource.setUsername(dbInfo.getDbUser());
//        dynamicDataSource.setPassword(dbInfo.getDbPasswd());
//
//        /**
//         * 创建动态数据源
//         */
//        Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();
//        dataSourceMap.put("dynamic-slave", dynamicDataSource);
//        DynamicDataSource.getInstance().setTargetDataSources(dataSourceMap);
//        /**
//         * 切换为动态数据源实例，打印学生信息
//         */
//        DataSourceContextHolder.setDBType("dynamic-slave");
//        List<StudentInfo> studentInfoList = studentService.getStudentInfo();
//        studentInfoList.stream().forEach(studentInfo -> System.out.println("studentName is : " + studentInfo.getStudentName() + "; className is : " + studentInfo.getClassName() + "; gradeName is : " + studentInfo.getGradeName()));

    }
}
