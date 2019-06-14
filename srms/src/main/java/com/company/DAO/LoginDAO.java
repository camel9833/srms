package com.company.DAO;

import java.util.List;

import com.company.VO.LoginVO;

public interface LoginDAO {

	String loginCheck(LoginVO vo);

	List<LoginVO> selectUserInfo(LoginVO vo);
}