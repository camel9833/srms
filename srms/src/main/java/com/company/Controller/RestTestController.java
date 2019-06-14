package com.company.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.common.logger.LoggerInterceptor;
import com.company.Service.RecipeManageService;
import com.company.VO.RecipeManageVO;

/**
 * 
 * Handles requests for the application home page.
 * 
 */

@RestController
public class RestTestController {

	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	@Resource(name = "recipeManageService")
	private RecipeManageService recipeManageService;
	
	@RequestMapping("/restTest.do")
	public @ResponseBody List<RecipeManageVO> recipeManageSearch() throws Exception{

		ModelAndView mv = new ModelAndView();

		RecipeManageVO vo = new RecipeManageVO();

		vo.setSysRegId("111");
		vo.setPageNo(0);

		return recipeManageService.selectRecipeGroup(vo);
	}

}