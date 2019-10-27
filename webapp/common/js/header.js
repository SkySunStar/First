/**
 * 主页操作
 */

	var $reg_form=$("#reg_form");
	var $log_form=$("#log_form");
	var $span1=$("#top>span:first-child");
	var $span2=$("#top>span:last-child");
	
	$span1.click(function(){
		login();
	})
	$span2.click(function(){
		register();
	})
	
	//切换为登录界面
	function login(){
		$span1.attr("class","top1");
		$span2.attr("class","top2");
		$reg_form.css("display","none");
		$log_form.css("display","block");
	}
	
	//切换为注册界面
	function register(){
		$span1.attr("class","top2");
		$span2.attr("class","top1");
		$log_form.css("display","none");
		$reg_form.css("display","block");
	}
	
	//点击注册或登录按钮显示模态框以及登录注册界面
	$("#header").on("click","#login",function(){
		$("#modal-overlay").css("visibility","visible");
		login();
	}).on("click","#register",function(){
		$("#modal-overlay").css("visibility","visible");
		register();
	})
	
	//关闭模态框
	$("#close").click(function(){
		$("#modal-overlay").css("visibility","hidden");
	})

//查看更多时跳转页面
$(".more>span").click(function(){
	sessionStorage.table=$(this).attr("name");
	thisName=sessionStorage.table.split(";");
	table=thisName[0];
	goodsTypeId=thisName[1];
	$.post("count.do",{"table":table,"goodsTypeId":goodsTypeId},function(data){
		$("body").fadeOut(500);
		setTimeout("location='front.do'",200);
	})
})

//显示找回密码框
$("#forget").click(function(){
	$("#foundPwd").css("visibility","visible");
})


//窗体滚动时标题随之滚动
$foundPwd=$("#foundPwd");
$(window).scroll(function(){
	$foundPwd.css("top",$(document).scrollTop());
})