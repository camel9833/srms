package com.company.DAO;

import java.util.List;
import com.company.VO.RecipeManageVO;

public interface RecipeManageDAO {

	int selectRecipeGrpTotalCnt(RecipeManageVO vo);
	
	List<RecipeManageVO> selectRecipeGroup(RecipeManageVO vo);
}