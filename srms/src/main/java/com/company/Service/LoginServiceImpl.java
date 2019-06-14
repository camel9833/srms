package com.company.Service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.company.DAO.LoginDAO;
import com.company.VO.LoginVO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name = "loginDAO")
	private LoginDAO loginDAO;

	@Override
	public String loginCheck(LoginVO vo) {
		return loginDAO.loginCheck(vo);
	}

	@Override
	public List<LoginVO> selectUserInfo(LoginVO vo) {
		return loginDAO.selectUserInfo(vo);
	}

}