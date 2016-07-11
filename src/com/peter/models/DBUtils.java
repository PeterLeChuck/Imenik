package com.peter.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void initialize() {
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("DROP TABLE IF EXISTS Zaposleni");
			statement.executeUpdate("CREATE TABLE Zaposleni("
					+ "id INTEGER Primary key AUTOINCREMENT, " + "ime varchar(30) not null, "
					+ "priimek varchar(30) not null, "
					+ "oddelek varchar(30), "
					+ "interna_telefonska_stevilka varchar(3))");

			statement.executeUpdate("INSERT INTO ZAPOSLENI "
					+ "(ime,priimek,oddelek,interna_telefonska_stevilka) "
					+ "VALUES " + "('Donald', 'Trump','Finance','233')");
			statement.executeUpdate("INSERT INTO ZAPOSLENI "
					+ "(ime,priimek,oddelek,interna_telefonska_stevilka) "
					+ "VALUES " + "('Hilary', 'Clinton','Prodaja','111')");
			statement.close();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}