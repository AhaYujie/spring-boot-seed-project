import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 输入要自动生成的数据表名
        generate("user", "role");
    }

    private static final String MAPPER_TEMPLATE_PATH = "generator/template/mapper"; //mapper模板文件路径, 设置为null则使用默认模板
    private static final String SERVICE_TEMPLATE_PATH = null; //service模板文件路径, 设置为null则使用默认模板
    private static final String SERVICE_IMPL_TEMPLATE_PATH = null; //service-impl模板文件路径, 设置为null则使用默认模板
    private static final String CONTROLLER_TEMPLATE_PATH = null; //controller模板文件路径, 设置为null则使用默认模板

    private static final String BASE_PACKAGE = "online.ahayujie.project"; //项目包名
    private static final String MODEL_PACKAGE = "bean.model"; //model包名
    private static final String MAPPER_PACKAGE = "mapper"; //mapper包名
    private static final String MAPPER_XML_PACKAGE = "mapper.xml"; //mapper.xml包名
    private static final String SERVICE_PACKAGE = "service"; //service包名
    private static final String SERVICE_IMPL_PACKAGE = "service.impl"; //service.impl包名
    private static final String CONTROLLER_PACKAGE = "controller"; //controller包名

    // 数据库配置
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/project";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String TABLE_PREFIX = ""; //数据表前缀, 例如：数据表名称是foo_user, 设置这个参数为foo_, 则生成的model为User; 设置这个参数为空字符串, 则model为foo_user

    private static final String MAPPER_NAME = "%sMapper"; //mapper类名称 %s代表model类名
    private static final String SERVICE_NAME = "%sService"; //service类名, %s代表model类名
    private static final String SERVICE_IMPL_NAME = "%sServiceImpl"; //service-impl类名, %s代表model类名
    private static final String CONTROLLER_NAME = "%sController"; //controller类名, %s代表model类名

    private static final String AUTHOR = "aha"; //@author

    private static final boolean FILE_OVERRIDE = false; //是否覆盖已有文件
    private static final boolean SWAGGER_COMMENT = true; //是否使用swagger注释model类
    private static final boolean BASE_RESULT_MAPPER = true; //mapper.xml文件是否生成默认resultMap
    private static final boolean LOMBOK_MODE = true; //是否使用lombok注释生成model类
    private static final DateType DATE_TYPE = DateType.ONLY_DATE; //model类的时间字段类型
    private static final IdType ID_TYPE = IdType.AUTO; //model类主键类型

    private static final Class SUPER_ENTITY_CLASS = null; //model类的父类, 无则设置为null

    private static void generate(String... tableNames) {
        AutoGenerator autoGenerator = new AutoGenerator();

        autoGenerator.setGlobalConfig(getGlobalConfig());

        autoGenerator.setDataSource(getDataSourceConfig());

        autoGenerator.setPackageInfo(getPackageConfig());

        autoGenerator.setTemplate(getTemplateConfig());

        autoGenerator.setStrategy(getStrategyConfig(tableNames));

        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.execute();
    }

    private static GlobalConfig getGlobalConfig() {
         return new GlobalConfig()
                 .setOpen(false)
                 .setAuthor(AUTHOR)
                 .setSwagger2(SWAGGER_COMMENT)
                 .setIdType(ID_TYPE)
                 .setDateType(DATE_TYPE)
                 .setFileOverride(FILE_OVERRIDE)
                 .setBaseResultMap(BASE_RESULT_MAPPER)
                 .setMapperName(MAPPER_NAME)
                 .setServiceName(SERVICE_NAME)
                 .setServiceImplName(SERVICE_IMPL_NAME)
                 .setControllerName(CONTROLLER_NAME)
                 .setOutputDir(System.getProperty("user.dir") + "/src/main/java");
    }

    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(JDBC_URL)
                .setUsername(JDBC_USERNAME)
                .setPassword(JDBC_PASSWORD)
                .setDriverName(JDBC_DIVER_CLASS_NAME);
    }

    private static PackageConfig getPackageConfig() {
        return new PackageConfig()
                .setParent(BASE_PACKAGE)
                .setController(CONTROLLER_PACKAGE)
                .setService(SERVICE_PACKAGE)
                .setServiceImpl(SERVICE_IMPL_PACKAGE)
                .setMapper(MAPPER_PACKAGE)
                .setXml(MAPPER_XML_PACKAGE)
                .setEntity(MODEL_PACKAGE);
    }

    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig =  new TemplateConfig();
        if (MAPPER_TEMPLATE_PATH != null) {
            templateConfig.setMapper(MAPPER_TEMPLATE_PATH);
        }
        if (SERVICE_TEMPLATE_PATH != null) {
            templateConfig.setService( SERVICE_TEMPLATE_PATH);
        }
        if (SERVICE_IMPL_TEMPLATE_PATH != null) {
            templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH);
        }
        if (CONTROLLER_TEMPLATE_PATH != null) {
            templateConfig.setController(CONTROLLER_TEMPLATE_PATH);
        }
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig(String[] tableNames) {
        StrategyConfig strategyConfig = new StrategyConfig()
                .setInclude(tableNames)
                .setEntityLombokModel(LOMBOK_MODE)
                .setTablePrefix(TABLE_PREFIX)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel);
        if (SUPER_ENTITY_CLASS != null) {
            strategyConfig.setSuperEntityClass(SUPER_ENTITY_CLASS);
        }
        return strategyConfig;
    }

}
