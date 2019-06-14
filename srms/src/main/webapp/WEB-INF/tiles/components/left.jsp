<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	function btn01() {
		var f = document.tmp; //폼 name

		f.action = "recipeManageSearch.do"; //이동할 페이지
		f.method = "post"; //POST방식
		f.submit();
	}
</script>


<body>
	<nav></nav>
	<form name="tmp">

		<tr>
			<th>메뉴</th>

			<td><a href="javascript:btn01()">Recipe그룹 관리</a></td>
			<td>Recipe그룹 이력관리</td>
			<td>측정기준 정보 관리</td>
			<td>측정기준 정보 이력 관리</td>
			<td>Recipe Confirm</td>
			<td>Recipe Event 관리</td>
		</tr>
	</form>
</body>
