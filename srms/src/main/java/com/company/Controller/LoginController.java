package com.company.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.logger.LoggerInterceptor;
import com.company.Service.LoginService;
import com.company.VO.LoginVO;

/**
 * 
 * Handles requests for the application home page.
 * 
 */

@Controller
public class LoginController {

	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	@Autowired private Environment env;

	@Resource(name = "loginService")
	private LoginService loginService;

	
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login() throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("/login/login");
		return mv;
	}

	
	
	@RequestMapping(value = "/logout.do")
	public ModelAndView logout(HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();

		session.invalidate();
		mv.setViewName("/login/login");
		return mv;
	}	


	
	
	
	@RequestMapping(value = "/loginCheck.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView loginCheck(HttpServletRequest request, HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();

		
		// profile 체크
		String[] profiles = env.getActiveProfiles();
		for(String profile : profiles ) {
			log.debug("profile : " + profile);
		}
		
		
		LoginVO vo = new LoginVO();

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		vo.setUserId(userId);
		vo.setUserPw(userPw);

		
//		/*
		LoginManager loginManager = LoginManager.getInstance();
		
		// 사용자 정보의 id/pw 확인
		String loginYn = loginService.loginCheck(vo);
		
		
		// id/ pw가 성공인 경우
		if ("Y".equals(loginYn)) {
			// 사용자 정보 조회
			List<LoginVO> userInfo = loginService.selectUserInfo(vo);
			session.setAttribute("sessionUserId", userInfo.get(0).getUserId());
			session.setAttribute("sessionUserNm", userInfo.get(0).getUserNm());

			// 이미 사용중인 id 인지 체크  (동시접속 체크)
			if(loginManager.isUsing(userId)){
				if(userId != null){
					loginManager.removeSession(userId);
					
//					mv.addObject("msg", "기존 세션 로그아웃되었습니다. 다시 로그인해 주시기 바랍니다.");
//					mv.setViewName("/login/login");
				    session = request.getSession();
				    session.setAttribute("sessionUserId", userInfo.get(0).getUserId());
					session.setAttribute("sessionUserNm", userInfo.get(0).getUserNm());
					loginManager.setSession(session, userId);
					mv.setViewName("/body/RecipeManage");
				}
			}else {
				loginManager.setSession(session, userId);	
				mv.setViewName("/body/RecipeManage");
			}
			
			log.debug("total Count : " + loginManager.getUserCount());

			
		// id/pw 틀린경우 	
		}else {
			session.invalidate();
			mv.setViewName("/login/logout");
		}
// */	

/*		
		String loginYn = loginService.loginCheck(vo);

		if ("Y".equals(loginYn)) {
			// �궗�슜�옄 �젙蹂� 議고쉶 諛� �꽭�뀡 �벑濡�
			List<LoginVO> userInfo = loginService.selectUserInfo(vo);
			log.debug("getUserId : " + userInfo.get(0).getUserId());
			log.debug("getUserNm : " + userInfo.get(0).getUserNm());
			session.setAttribute("sessionUserId", userInfo.get(0).getUserId());
			session.setAttribute("sessionUserNm", userInfo.get(0).getUserNm());
		
			mv.setViewName("/body/RecipeManage");
		} else {
			// 로그인 실패
			session.invalidate();
			mv.setViewName("/login/login");
		}
*/
		
		
		return mv;
	}

}