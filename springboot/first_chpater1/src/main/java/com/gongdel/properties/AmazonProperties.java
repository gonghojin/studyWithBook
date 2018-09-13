package com.gongdel.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon") // "amazon" 접두가 붙은 프로퍼티 주입 == @ConfigurationProperties(prefix = "amazon")
public class AmazonProperties {

    private String associatedId;

    public String getAssociatedId() {
        return associatedId;
    }

    public void setAssociatedId(String associatedId) {
        this.associatedId = associatedId;
    }
}
