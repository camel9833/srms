package com.company.Service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.company.DAO.RecipeManageDAO;
import com.company.VO.RecipeManageVO;

@Service("recipeManageService")
public class RecipeManageServiceImpl implements RecipeManageService {

	@Resource(name = "recipeManageDAO")
	private RecipeManageDAO recipeManageDAO;

	@Override
	public int selectRecipeGrpTotalCnt(RecipeManageVO vo) {
		return recipeManageDAO.selectRecipeGrpTotalCnt(vo);
	}	
	
	@Override
	public List<RecipeManageVO> selectRecipeGroup(RecipeManageVO vo) {
		return recipeManageDAO.selectRecipeGroup(vo);
	}

}