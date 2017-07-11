package org.huangpu.mydog.plugins.ormapping;

/**
 * Created by zzs
 */
public class MyBatisGeneratorConfig {
    /**
     * jdbc jar包
     */
    private String connectorJarFilePath;
    /**
     * 数据驱动class
     */
    private String driverClass;
    /**
     * 数据库连接
     */
    private String connectionURL;
    /**
     * 数据连接用户名
     */
    private String userName;
    /**
     * 数据库连接密码
     */
    private String passWord;
    /**
     * 文件编码
     */
    private String charset="UTF-8";
    /**
     * 工程磁盘目录
     */
    private String targetProject;
    /**
     * mapping 存放目录
     */
    private String clientGeneratorTargetPackage;
    /**
     * 生成方式 默认代码方式
     * TODO: 要支持XML方式
     */
    private String clientGeneratorType = "ANNOTATEDMAPPER";
    /**
     * model 存放目录
     */
    private String modelGeneratorTargetPackage;
    /**
     * control 生成的包
     */
//    private String controlGeneratorTargetPackage;
//    /**
//     * service 生成的包
//     */
//    private String serviceGeneratorTargetPackage;
    /**
     * domainName
     */
//    private String domainObjectName;
    /**
     * 表名
     */
//    private String tableName;
    /***
     * 是够分页
     */
    private boolean offsetLimit;
    /**
     * 注释
     */
    private boolean comment;
    /**
     * 注解
     */
    private boolean annotation;
    /**
     * 主键
     */
    private String key;
    /**
     * 注解类型
     */
    private String keyClass;
//    public String getTableName() {
//        return tableName;
//    }

//    public void setTableName(String tableName) {
//        this.tableName = tableName;
//    }

//    public String getDomainObjectName() {
//        return domainObjectName;
//    }
//
//    public void setDomainObjectName(String domainObjectName) {
//        this.domainObjectName = domainObjectName;
//    }


    public String getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(String targetProject) {
        this.targetProject = targetProject;
    }

    public String getClientGeneratorTargetPackage() {
        return clientGeneratorTargetPackage;
    }

    public void setClientGeneratorTargetPackage(String clientGeneratorTargetPackage) {
        this.clientGeneratorTargetPackage = clientGeneratorTargetPackage;
    }

    public String getClientGeneratorType() {
        return clientGeneratorType;
    }

    public void setClientGeneratorType(String clientGeneratorType) {
        this.clientGeneratorType = clientGeneratorType;
    }

    public String getModelGeneratorTargetPackage() {
        return modelGeneratorTargetPackage;
    }

    public void setModelGeneratorTargetPackage(String modelGeneratorTargetPackage) {
        this.modelGeneratorTargetPackage = modelGeneratorTargetPackage;
    }

    public boolean isOffsetLimit() {
        return offsetLimit;
    }

    public void setOffsetLimit(boolean offsetLimit) {
        this.offsetLimit = offsetLimit;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isAnnotation() {
        return annotation;
    }

    public void setAnnotation(boolean annotation) {
        this.annotation = annotation;
    }

    public String getConnectorJarFilePath() {
        return connectorJarFilePath;
    }

    public void setConnectorJarFilePath(String connectorJarFilePath) {
        this.connectorJarFilePath = connectorJarFilePath;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }




    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyClass() {
        return keyClass;
    }

    public void setKeyClass(String keyClass) {
        this.keyClass = keyClass;
    }

    @Override
    public String toString() {
        return "MyBatisGeneratorConfig{" +
                "connectorJarFilePath='" + connectorJarFilePath + '\'' +
                ", driverClass='" + driverClass + '\'' +
                ", connectionURL='" + connectionURL + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", charset='" + charset + '\'' +
                ", targetProject='" + targetProject + '\'' +
                ", clientGeneratorTargetPackage='" + clientGeneratorTargetPackage + '\'' +
                ", clientGeneratorType='" + clientGeneratorType + '\'' +
                ", modelGeneratorTargetPackage='" + modelGeneratorTargetPackage + '\'' +
//                ", controlGeneratorTargetPackage='" + controlGeneratorTargetPackage + '\'' +
//                ", serviceGeneratorTargetPackage='" + serviceGeneratorTargetPackage + '\'' +
//                ", domainObjectName='" + domainObjectName + '\'' +
//                ", tableName='" + tableName + '\'' +
                ", offsetLimit=" + offsetLimit +
                ", comment=" + comment +
                ", annotation=" + annotation +
                ", key='" + key + '\'' +
                ", keyClass='" + keyClass + '\'' +
                '}';
    }
}
