package com.gongdel.jpa.chap3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "gongdel";
        String password = "pass";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created : " + connection);
//            String sql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255))";
            String sql = "INSERT INTO  ACCOUNT VALUES (1, 'gongdel', 'pass')";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        }
    }
}
/**
 * 위의 내용을 보아, ORM을 왜 사용하면 좋은가?
 * SQL을 실행하는 비용이 비싸다.
 * SQL이 데이터베이스 마다 다르다.
 * 스키마를 바꿨더니 코드가 너무 많이 바뀌네...
 * 반복적인 코드가 너무 많아.
 * 당장은 필요가 없는데 언제 쓸 줄 모르니까 미리 다 읽어와야 하나...
 */
