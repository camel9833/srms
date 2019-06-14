package com.company.DAO;

import java.util.List;
import javax.inject.Inject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.company.VO.LoginVO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSessionTemplate sqlSession;

	public String loginCheck(LoginVO vo) {
		return sqlSession.selectOne("LoginMapper.loginCheck", vo);
	}

	public List<LoginVO> selectUserInfo(LoginVO vo) {
		return sqlSession.selectList("LoginMapper.selectUserInfo", vo);
	}

}
