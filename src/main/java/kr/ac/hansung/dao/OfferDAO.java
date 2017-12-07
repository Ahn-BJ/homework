package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public Offer getOffer(String code) {
		String sqlStatement = "select * from  offers where name=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[]{code},
				new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setName(rs.getString("name"));
				offer.setDivide(rs.getString("divide"));
				offer.setCredit(rs.getString("credit"));

				return offer;
			}

		});
	}
	
	// query and return a multiple object
	public List<Offer> getOffers() {
		String sqlStatement = "select * from  offers";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setCode(rs.getString("code"));
				offer.setName(rs.getString("name"));
				offer.setDivide(rs.getString("divide"));
				offer.setCredit(rs.getString("credit"));

				return offer;
			}

		});
	}

	public boolean insert(Offer offer) {

		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String name = offer.getName();
		String divide = offer.getDivide();
		String credit = offer.getCredit();

		String sqlStatement = "insert into offers (year, semester, code, name, divide, credit) values (?, ?, ?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, code, name, divide, credit }) == 1);

	}

	public boolean update(Offer offer) {

		int id = offer.getId(); 
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String name = offer.getName();
		String divide = offer.getDivide();
		String credit = offer.getCredit();
	
		String sqlStatement = "update offers set year=?, semester=?, code=?, name=?, divide=?, credit=? where id=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] {  year, semester, code, name, divide, credit, id }) == 1);
	}
	
	public boolean delete(int id) {
		String sqlStatement = "delete from offers where id=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] {id }) == 1);
	}
}
