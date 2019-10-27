/**
 * 用于登录和注册的验证与传递信息
 */
$(function(){
	$("#log_btn").click(function(){
		var $mess=$("#mess>td");
		var name=$("#log_name").val();
		var password=$("#log_pwd").val();
		var checkTxt=$("#save").is(":checked");
		$mess.html("");
		if(name.trim().length<2||name.trim().length>10){
			$mess.html("登录名由2-10位字母、数字及下划线组成");
		}else if(password.trim().length<6||password.trim().length>16){
			$mess.html("密码由6-16位非空字符组成");
		}else{
			$.post("login.do",{"name":name,"password":password,"checkTxt":checkTxt},function(data){
				if(data=="false"){
					$mess.html("用户名或密码有误");
				} else{
					if(data=="manage"){
						location="manage.do";
					}else{
						$("#header").load("common/jsp/header.jsp");
						$("#modal-overlay").css("visibility","hidden");
					}
				}
			})
		}
	})

	//注册时验证
	var $reg_form=$("#reg_form");
	$reg_form.validate({
		rules:{
            name:{
            	regExp:/^\w{2,10}$/,//在validate中自定义的正则表达式属性
            	remote:{//validate中类似ajax的异步请求
            		url:"validate.do",
            		type:"post",
            		data:{
            			"table":"user",
            			"param":"name",
            			"value":function(){return $("#name").val()}//最后一个变量传输到selvlet中后必须得到一个返回值以便不会让表单提交
            		}
            	}
            },
            password:{
            	regExp:/^\S{6,16}$/
            },
            confirm_password:{
            	equalTo:".input[name='password']"
            },
            realname:{
            	regExp:/^[\u4e00-\u9fa5]{2,5}$/
            },
           telephone:{
            	regExp:/^1[345789]\d{9}$/,
            	remote:{
            		url:"validate.do",
            		type:"post",
            		data:{
            			"table":"user_info",
            			"param":"telephone",
            			"value":function(){return $("#telephone").val()}
            		}
            	}
            },
            address:{
            	regExp:/^[\u4e00-\u9fa5]{5,30}$/
            }
        },
        messages:{
        	 name:{
        		 regExp:"登录名由2-10位字母、数字及下划线组成",
        		 remote:"用户名已存在"
        	 },
             password:"密码由6-16位非空字符组成",
             confirm_password:"两次密码不一致",
             realname:"真实姓名由两个至五个汉字组成",
             telephone:{
        		 regExp:"手机号格式不正确",
        		 remote:"手机号已被使用"
        	 },
        	 address:"地址不合法"
        },
        success:function(){
        	$(this).addClass("valid")
        },
        submitHandler:function(){//点击提交后当之前的验证通过后才会触发此函数
        	$.post("userAdd.do",$reg_form.serialize(),function(data){
				if(data=="true"){
					alert("注册成功")
				}else{
					alert("注册失败")
				}
			})
        } 
	})
})