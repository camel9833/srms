package com.company.DAO;

import java.util.List;
import javax.inject.Inject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.company.VO.RecipeManageVO;

@Repository("recipeManageDAO")
public class RecipeManageDAOImpl implements RecipeManageDAO {

	@Inject
	private SqlSessionTemplate sqlSession;

	
	public int selectRecipeGrpTotalCnt(RecipeManageVO vo) {
		return sqlSession.selectOne("RecipeManageMapper.selectRecipeGrpTotalCnt", vo);
	}

	public List<RecipeManageVO> selectRecipeGroup(RecipeManageVO vo) {
		return sqlSession.selectList("RecipeManageMapper.selectRecipeGroup", vo);
	}

}
