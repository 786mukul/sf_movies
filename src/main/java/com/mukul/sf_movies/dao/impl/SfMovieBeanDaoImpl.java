package com.mukul.sf_movies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.dao.SfMovieBeanDao;
import com.mukul.sf_movies.helper.ApplicationContextProvider;
import com.mukul.sf_movies.helper.Page;
import com.mukul.sf_movies.helper.PaginationHelper;

public class SfMovieBeanDaoImpl extends JdbcDaoSupport implements SfMovieBeanDao{

	public static final String SELECT_COUNT_QUERY ="SELECT count(*) FROM raw_data";
	public static final String SELECT_TITLE_QUERY ="SELECT DISTINCT title FROM raw_data";
	public static final String SELECT_ROW_QUERY ="SELECT * FROM raw_data";
	public static final String WHERE_CLAUSE = " WHERE";
	public static final String ID_FILTER = " id = ?";
	public static final String TITLE_PREFIX_FILTER = " lower(title) like ?";
	public static final String TITLE_FILTER = " title = ?";
	public static final String LIMIT_FILTER = " limit ?";
	
	
	private PaginationHelper<SfMovieBean> paginationHelper = new PaginationHelper<SfMovieBean>();
	private static ParameterizedRowMapper<SfMovieBean> ROW_MAPPER = new ParameterizedRowMapper<SfMovieBean>() {
	
		public SfMovieBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			SfMovieBean sfMovieBean = new SfMovieBean();
			sfMovieBean.setTitle(rs.getString("title"));
			sfMovieBean.setActor1(rs.getString("actor1"));
			sfMovieBean.setActor2(rs.getString("actor2"));
			sfMovieBean.setActor3(rs.getString("actor3"));
			sfMovieBean.setAddress(rs.getString("location"));
			sfMovieBean.setDirector(rs.getString("director"));
			sfMovieBean.setDistributor(rs.getString("distributor"));
			sfMovieBean.setFunfacts(rs.getString("fun_facts"));
			sfMovieBean.setId(rs.getLong("id"));
			sfMovieBean.setProduction(rs.getString("production"));
			sfMovieBean.setReleaseYear(rs.getString("release_year"));
			sfMovieBean.setWriter(rs.getString("writer"));
			return sfMovieBean;
		}
	};
	
	
	
	public Page<SfMovieBean> getMovieBeans(int pageNo, int pageSize) {
		return paginationHelper.fetchPage(getJdbcTemplate(), SELECT_COUNT_QUERY, SELECT_ROW_QUERY, new Object[]{}, pageNo, pageSize,ROW_MAPPER);
	}
	
	public SfMovieBean getMovieBean(Long id) {
		List<SfMovieBean> sfMovieBeans = getJdbcTemplate().query(SELECT_ROW_QUERY+WHERE_CLAUSE+ID_FILTER, new Object[]{id}, ROW_MAPPER);
			if(sfMovieBeans!=null && sfMovieBeans.size() ==1){
				return sfMovieBeans.get(0);
			}
			return null;
	}


	public List<String> getMovieTitle(String namePrefix, int limit) {
		List<String> movieTitles =  (List<String>)getJdbcTemplate()
				.queryForList(SELECT_TITLE_QUERY + WHERE_CLAUSE + TITLE_PREFIX_FILTER + LIMIT_FILTER, new Object[]{namePrefix.toLowerCase()+"%", limit}, String.class);
				return movieTitles;
	}

	public Page<SfMovieBean> getMovieBeans(final String title,final int pageNo,
			final int pageSize) {
		String selectSql = SELECT_ROW_QUERY;
		String selectCountSql = SELECT_COUNT_QUERY;
		Object[] objects = new Object[]{};
		if(title !=  null){
			selectSql+= WHERE_CLAUSE+TITLE_FILTER;
			selectCountSql+= WHERE_CLAUSE+TITLE_FILTER;
			objects = new Object[]{title};
		}
		return paginationHelper.fetchPage(getJdbcTemplate(), selectCountSql, selectSql, objects, pageNo, pageSize, ROW_MAPPER);
	}

	
}
