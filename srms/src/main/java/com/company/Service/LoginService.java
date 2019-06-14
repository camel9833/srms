package com.company.Service;

import java.util.List;

import com.company.VO.LoginVO;

public interface LoginService {

	public String loginCheck(LoginVO vo);

	public List<LoginVO> selectUserInfo(LoginVO vo);

}