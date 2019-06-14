package com.company.Service;

import java.util.List;

import com.company.VO.RecipeManageVO;

public interface RecipeManageService {
	
	public int selectRecipeGrpTotalCnt(RecipeManageVO vo);

	public List<RecipeManageVO> selectRecipeGroup(RecipeManageVO vo);

}