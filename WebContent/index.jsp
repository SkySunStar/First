<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="prc" value="${pageContext.request.contextPath }" />
<title>随风旅行网</title>
<style type="text/css">
	body{
		background-color: #c0c0c0;
	}
	#title{
		font:600 50px "KaiTi";
		color:#ff8000;
	}
	#subheading{
		color:#ff00ff;
		text-align: center;
		font:600 50px "KaiTi";
	}
	.travel{
		display: inline-block;
		width: 600px;
		margin: 30px;
		color:#8080c0;
		font:600 40px "KaiTi";
		text-align: center;
	}
	.travel img{
		width: 600px;
		height:400px;
		border-radius: 20px;
	}
</style>
</head>
<body>
	<div>
		<div id="title">随风旅行，欢迎您<br/><a href="home.do">进入主页</a></div>
		<div id="subheading">中国十大名胜古迹</div>
		<div>哈哈哈"${prc }"</div>
		<div class="travel"><div>万里长城</div><img alt="万里长城" src="${prc }/common/images/index/id1.gif"></div>
		<div class="travel"><div>桂林山水</div><img alt="桂林山水" src="${prc }/common/images/index/id2.gif"></div>
		<div class="travel"><div>北京故宫</div><img alt="北京故宫" src="${prc }/common/images/index/id3.gif"></div>
		<div class="travel"><div>杭州西湖</div><img alt="杭州西湖" src="${prc }/common/images/index/id4.gif"></div>
		<div class="travel"><div>苏州园林</div><img alt="苏州园林" src="${prc }/common/images/index/id5.gif"></div>
		<div class="travel"><div>安徽黄山</div><img alt="安徽黄山" src="${prc }/common/images/index/id6.gif"></div>
		<div class="travel"><div>长江三峡</div><img alt="长江三峡" src="${prc }/common/images/index/id7.gif"></div>
		<div class="travel"><div>台湾日月潭</div><img alt="台湾日月潭" src="${prc }/common/images/index/id8.gif"></div>
		<div class="travel"><div>承德避暑山庄</div><img alt="承德避暑山庄" src="${prc }/common/images/index/id9.gif"></div>
		<div class="travel"><div>西安秦兵马俑</div><img alt="西安秦兵马俑" src="${prc }/common/images/index/id10.gif"></div>
	</div>
</body>
</html>