package com.gongdel.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JdbcTemplateCondition implements Condition {

    /**
     * 스프링 부트를 이용하면 구성 클래스를 몇개 포함하는 Jar 파일인 spring-boot-autoconfigurer를 추가하는데,
     * 그 구성 클래스 중 필요한 걸 간추릴 수 있음
     * 즉 JdbcTemplate이 클래스패스에 있을 때만 통과한다. (조건부 구성)
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            context.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
