package com.gongdel.jpa.domain.capter6;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity : '객체 세상'에서 부르는 이름
 *  보통 클래스와 같은 이름을 사용하기 떄문에 값을 변경하지 않음
 *  - 다르게 사용하고 싶을 경우? @Entity(name = "users"),
 *    But 불필요한 코드가 많아 지는 걸 방지하기 위해 일치시켜서 'name'을 생략하자
 *  엔티티의 이름은 JQL에서 쓰임
 *
 * Table : '릴레이션' 세상에서 부르는 이름
 *  @Entity의 이름이 기본 값
 *  테이블의 이름을 SQL에서 쓰임
 */
@Entity
@Table
public class Account {

    /**
     * @Id
     *  엔티티의 주키를 맵핑할 때 사용
     *  자바의 모든 primitive 타입과 그 래퍼 타입을 사용할 수 있음
     *  - Date랑 BigDecimal, BigInteger도 사용가능
     *  복합키를 만드는 맵핑 방법도 있음
     *
     * @GeneratedValue
     *  주키의 생성 방법을 맵핑하는 어노테이션
     *  생성 전략과 생성기를 설정할 수 있다.
     *  - 기본 전략은 Auto : 사용하는  DB에 따라 적절한 전략 선택
     *  - TABLE, SEQUENCE, IDENTITY 중 하나
     */
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    // @Column 생략
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    @Transient // 컬럼으로 맵핑하고 싶지 않은 멤버 변수에 사용
    private String no;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 반드시 맵핑할 때 getter/setter가 필요한 것은 아님
     */
}
