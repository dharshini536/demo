package com.example.Project.Example1.Student_Managment.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentIdGenerator implements IdentifierGenerator {

    @Value("${generator.PREFIX}")
    private String PREFIX ;

    @Value("${generator.NUMBER_LENGTH}")
    private int NUMBER_LENGTH ;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Use doReturningWork to safely get a JDBC connection and run query
        String maxId = session.doReturningWork(connection -> {
            String sql = "SELECT MAX(student_id) FROM student_entity";
            try (PreparedStatement ps = connection.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                }
            }
            return null;
        });

        String newId;
        if (maxId != null) {
            // Suppose maxId = "POCO005", extract numeric part
            String numberPart = maxId.substring(PREFIX.length());
            int num = 0;
            try {
                num = Integer.parseInt(numberPart);
            } catch (NumberFormatException ex) {
                // fallback if parsing fails
                num = 0;
            }
            num++;  // next number

            // zero-pad to required length
            String formatted = String.format("%0" + NUMBER_LENGTH + "d", num);
            newId = PREFIX + formatted;
        } else {
            // No records yet — start with 1
            String formatted = String.format("%0" + NUMBER_LENGTH + "d", 1);
            newId = PREFIX + formatted;
        }

        return newId;
    }

}