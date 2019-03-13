package com.gongdel.jpa.domain.capter6;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JpaRunner implements ApplicationRunner {

    /**
     * EntityManager는 Jpa의 핵심
     */
    @PersistenceContext
    EntityManager entityManager;

    @Transactional // entityManager와 관련된 operation들은 한 transaction 안에서 작동해야 함
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();

        // - Tag : JPA
        account.setUsername("gongdel");
        account.setPassword("jpa");

        entityManager.persist(account);
        // - End

        // - Tag : Hibernate
        // Jpa의 밑단에는 hiberante가 있음
        Account accountHiberate = new Account();
        accountHiberate.setUsername("keusun");
        accountHiberate.setPassword("hibernate");

        Session session = entityManager.unwrap(Session.class);
        session.save(accountHiberate);
        // - End
    }
}
