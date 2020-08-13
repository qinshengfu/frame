package com.qsf.frame.config;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * 代码生成器
 * @Author QSF
 * @Date 2020/8/6 14:09
 * @Version 1.0
 */
public class CodeGenerator {
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入").append(tip).append("：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mybatisPlusCodeGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        // 先得到当前工程目录
        String projectPath = System.getProperty("user.dir");
        // 是maven项目的结构，就是工程目录 + /src/main/java
        gc.setOutputDir(projectPath + "/src/main/java");

        //gc.setOutputDir("D:\\workspace-sts\\0520adv\\02_mp_springboot/src/main/java");

        // 设置生成文件的作者信息
        gc.setAuthor("qsf");

        //当代码生成完成之后是否打开代码所在的文件夹
        gc.setOpen(true);

        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        gc.setServiceName("%sService");

        // 将上述的全局配置注入
        mybatisPlusCodeGenerator.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dataSourceConfiguration = new DataSourceConfig();

        dataSourceConfiguration.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");

        // dataSourceConfiguration.setSchemaName("public");
        dataSourceConfiguration.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfiguration.setUsername("root");
        dataSourceConfiguration.setPassword("123456");

        mybatisPlusCodeGenerator.setDataSource(dataSourceConfiguration);

        // 包配置
        PackageConfig pc = new PackageConfig();

        // 设置父级包名
        pc.setParent("com.qsf");//controller entity  service  service.impl

        pc.setModuleName(scanner("模块名"));
        //pc.setModuleName("sys");

        // 实体类名称
        pc.setEntity("domain");

        // mapper包名称
        pc.setMapper("mapper");

        // mapper对应的映射器xml
//        pc.setXml("mapper.xml");

        // 业务包层名称
        pc.setService("service");

        // 业务接口的实现类包
        pc.setServiceImpl("service.impl");

        // 控制器包名称
        pc.setController("controller");

        // 装填包信息对象
        mybatisPlusCodeGenerator.setPackageInfo(pc);

/*        // 自定义配置
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                if (pc.getModuleName() == null) {
                    return projectPath + "/src/main/resources/mapper/"
                            + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                } else {
                    return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            }
        });
        cfg.setFileOutConfigList(focList);
        mybatisPlusCodeGenerator.setCfg(cfg);
        mybatisPlusCodeGenerator.setTemplate(new TemplateConfig().setXml(null));*/




        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        //设置字段和表名的是否把下划线完成驼峰命名规则
        strategy.setNaming(NamingStrategy.underline_to_camel);

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        //设置生成的实体类继承的父类
        //strategy.setSuperEntityClass("com.sxt.BaseEntity");

        //是否启动lombok
        strategy.setEntityLombokModel(true);

        //是否生成resetController
        strategy.setRestControllerStyle(true);

        // 公共父类
        //strategy.setSuperControllerClass("com.sxt.BaseController");

        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("person_id","person_name");

        //要设置生成哪些表 如果不设置就是生成所有的表
        //strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));

        strategy.setControllerMappingHyphenStyle(true);

        //strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setTablePrefix("tb_");

        mybatisPlusCodeGenerator.setStrategy(strategy);

        mybatisPlusCodeGenerator.execute();
    }
}
