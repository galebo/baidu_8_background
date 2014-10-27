package com.galebo.fang.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.galebo.fang.models.Summery;
import com.galebo.fang.models.Summery.Data;
@Service("fangDao")
public class FangDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Data> getDatas(){
		return jdbcTemplate.query("select * from data t order by t.key", new RowMapper<Summery.Data>(){

			@Override
			public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
				Summery.Data data=new Data();
				data.setKey(rs.getString("key"));
				data.setJson(rs.getString("json"));
				return data;
			}
			
		});
	}
}
