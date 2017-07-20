<#assign prj=project["mydogProj"]/>
<#assign myb=ormapping["mybatis"]/>
<#assign tran=myb["transaction"]/>

package ${prj.basePackage}.config;

<#if imports??>
    <#list imports as import>
import ${import};
    </#list>
</#if>

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
<#if tran["on"]>
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
</#if>
public class BootConfig {

    protected static Logger log = LoggerFactory.getLogger(BootConfig.class);
    <#if tran["on"]>
        <#if tran["defaultStrategy"]>
    @Bean
    @Autowired
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
        PlatformTransactionManager transManager = new DataSourceTransactionManager(dataSource);
        return transManager;
    }

    @Bean
    public AspectJExpressionPointcutAdvisor aspectJExpressionPointcutAdvisor() {
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* ${prj.basePackage}.service.*.*(..)) ");
        advisor.setAdvice(transactionInterceptor());
        return advisor;
    }

    @Bean
    public TransactionInterceptor transactionInterceptor() {
        TransactionInterceptor interceptor = new TransactionInterceptor();
        interceptor.setTransactionAttributeSource(nameMatchTransactionAttributeSource());
        return interceptor;
    }

    @Bean
    public NameMatchTransactionAttributeSource nameMatchTransactionAttributeSource() {
    NameMatchTransactionAttributeSource attributeSource = new NameMatchTransactionAttributeSource();

        // 查询类操作 不需要事物
        // PROPAGATION_NOT_SUPPORTED：如果没有，就以非事务方式执行；如果有，就将当前事务挂起。即无论如何不支持事务。
        final RuleBasedTransactionAttribute transSupported = new RuleBasedTransactionAttribute();
        transSupported.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        transSupported.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transSupported.setReadOnly(Boolean.TRUE);

        //　持久化操作REQUIRED　事物
        //　PROPAGATION_REQUIRED：默认事务类型，如果没有，就新建一个事务；如果有，就加入当前事务。适合绝大多数情况。
        final RuleBasedTransactionAttribute transRequired = new RuleBasedTransactionAttribute();
        transRequired.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        transRequired.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        transRequired.setReadOnly(Boolean.FALSE);

        // 持久化操作 REQUIRES_NEW 事物
        // PROPAGATION_REQUIRES_NEW：如果没有，就新建一个事务；如果有，就将当前事务挂起。
        final RuleBasedTransactionAttribute transRrequires_new = new RuleBasedTransactionAttribute();
        transRrequires_new.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transRrequires_new.setReadOnly(Boolean.FALSE);

        attributeSource.setNameMap(new HashMap<String, TransactionAttribute>() {{
            put("get*", transSupported);
            put("find*", transSupported);
            put("query*", transSupported);

            put("do*", transRequired);
            put("create*", transRequired);
            put("insert*", transRequired);
            put("delete*", transRequired);
            put("update*", transRequired);

            put("log*", transRrequires_new);
        }});
        return attributeSource;
    }
        </#if>
    </#if>



}