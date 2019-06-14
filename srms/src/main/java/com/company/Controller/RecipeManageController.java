package com.company.Controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.common.logger.LoggerInterceptor;
import com.company.Service.RecipeManageService;
import com.company.VO.PagingVO;
import com.company.VO.RecipeManageVO;

/**
 * 
 * Handles requests for the application home page.
 * 
 */

@Controller
public class RecipeManageController {

	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	@Resource(name = "recipeManageService")
	private RecipeManageService recipeManageService;

	@RequestMapping(value = "/recipeManageInit.do")
	public ModelAndView recipeManageInit(HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("sessionUserId")==null) {
			mv.setViewName("/login/login");
			return mv;
		}

		mv.setViewName("/body/RecipeManage");
		return mv;
	}

	@RequestMapping(value = "/recipeManageSearch.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView recipeManageSearch(HttpServletRequest request, HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();

		if(session.getAttribute("sessionUserId")==null) {
			mv.setViewName("/login/login");
			return mv;
		}
		
		RecipeManageVO vo = new RecipeManageVO();

		String userId = request.getParameter("userId");
		String pageNoStr = request.getParameter("pageNo")==null?"1": request.getParameter("pageNo");
		int pageNo = Integer.parseInt(pageNoStr);

		vo.setSysRegId(userId);
		vo.setPageNo((pageNo-1)*10);

		
		int totalCount = recipeManageService.selectRecipeGrpTotalCnt(vo);
		
		PagingVO paging = new PagingVO();
        paging.setPageNo(pageNo);
        paging.setPageSize(10);
        paging.setTotalCount(totalCount);
        mv.addObject("paging", paging);
        
		List<RecipeManageVO> rpList = recipeManageService.selectRecipeGroup(vo);
		mv.addObject("rpList", rpList);

		mv.setViewName("/body/RecipeManage");

		return mv;
	}

}