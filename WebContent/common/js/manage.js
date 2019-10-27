/**
 * 进行管理模块操作
 */

	//跳转页码
	$(".btnPage").click(function(){
		byPage($(this).attr("value"));
		url="common/jsp/manageModule/"+table+".jsp";
		load(url,function(){goodsLoad();});
	})
	//后台搜索框
	$("#search").click(function(){
		$pageNo.val(1);
		$pageSize.val(5);
		thisName=$("#searchDiv>select").val().split(";");
		table=thisName[0];
		typeId=thisName[1];
		if(typeId!=""){
			$queryThis=$(".queryList").eq(typeId+2);
		}
		keyword=$("#content").val();
		$.post("count.do",{"table":table,"typeId":typeId,"keyword":keyword},function(data){
			$("#add").html("新增"+$("#searchDiv option:checked").html());
			$totalCount.html(data);
			$pageForm.show();
			totalPage=Math.ceil(parseInt($totalCount.html())/parseInt($pageSize.val()));
			$totalPage.html(totalPage);
			byPage(0);
			url="common/jsp/manageModule/"+table+".jsp";
			load(url,function(){goodsLoad();});
		})
	})
	//查询信息
	var $queryThis=null;//查询标题标签
	$(".queryList").click(function(){
		$pageNo.val(1);
		$pageSize.val(5);
		$queryThis=$(this);
		$("#otherDetail").css("visibility","hidden");
		$queryThis.css("background-color","#400040");
		$queryThis.siblings().css("background-color","#c0c0c0");
		var thisName=$queryThis.attr("name").split(";");
		table=thisName[0];
		typeId=thisName[1];
		$.post("count.do",{"table":table,"typeId":typeId},function(data){
			$totalCount.html(data);
			$("#add").html("新增"+$queryThis.html());
			$pageForm.show();
			keyword=null;
			byPage(0);
			url="common/jsp/manageModule/"+table+".jsp";
			load(url,function(){goodsLoad();});
		})
	})
	function goodsLoad(){
		if(table=="goods"){
			$(".goodsName").html($queryThis.html());
			$goodsType=$("#goodsType");
			$add.attr("value",typeId);
			$.post("goods_typeList.do",{"startPage":0,"pageSize":50,"typeId":$add.attr("value")},function(data){//增加商品时选择商品分类
				for(var i=0;i<data.length;i++){
					$goodsType.append("<option value="+data[i].id+">"+data[i].name+"</option>")
				}
			},"json")
		}
	}
	$("#other").click(function(){
		var $this=$(this);
		$this.css("background-color","#400040");
		$this.siblings().css("background-color","#c0c0c0");
		$("#otherDetail").css("visibility","visible");
	})
	
	//增改信息
	var $thisTdSiblings=null;
	var $inputList=null;
	var $keyword=null;//搜索商家关键字标签
	var $sellerId=null;//商家ID隐藏域标签
	var $souSeller=null;//搜索列表栏标签
	var keyword=null;//关键字值
	var $sellerDt=null;//搜索列表栏子标签
	var $goodsType=null;//商品分类下拉框
	var $add=$("#add");//新增标签
	$("#searchDiv>select").prepend("<option value='user'>用户</option>").append("<option value='seller'>商家</option><option value='goods_type'>商品分类</option>");
	$("#module").on("click",".mod",function(){
		$("#btn").val("修改");
		$("#modal-overlay").css("visibility","visible");
		$thisTdSiblings=$(this).parent().siblings();
		$inputList=$(".input");
		
		for(var i=0;i<$thisTdSiblings.length;i++){
			if($thisTdSiblings.eq(i).attr("value")=="undefined"){
				$inputList.eq(i).val($thisTdSiblings.eq(i).html());
			}else{
				$inputList.eq(i).val($thisTdSiblings.eq(i).attr("value"));
			}
		}
	}).on("click","#btn",function(){
		var submit=null;
		var thisBool=$(this).val()=="添加";
		if(thisBool){
			submit=table+"Add.do";
		}else{
			submit=table+"Mod.do";
		}
		$("#typeId").val($add.attr("value"));
		/*alert($(".subList").eq(0).serialize())
		var xml = new XMLHttpRequest();
		xml.open("post",submit,true);//post方式提交
			//3.向服务器发送请求
		//xml.setRequestHeader("content-type","multipart/form-data");//post方式设置请求头
		xml.send(new FormData($(".subList")[0]));//post方式发送
			//4.创建回调函数，根据响应状态动态更新页面
		xml.onreadystatechange=function() {
			if (xml.readyState==4 && xml.status==200){
				alert("提交成功");
	        }else{
	        	alert("提交失败");
	        }
       }*/
		$.ajax({
            url:submit,
            type: "post",
            data:new FormData($(".subList")[0]),
            cache:false,
            contentType: false,//必须false才会自动加上正确的Content-Type
            processData: false,//必须false才会避开jQuery对 formdata 的默认处理,而XMLHttpRequest会对 formdata进行正确的处理
            success:function(data){
            	if(data=="true"){
            		if(thisBool){
            			$totalCount.html(parseInt($totalCount.html())+1);
            			$totalPage.html(Math.ceil(parseInt($totalCount.html())/parseInt($pageSize.val())));
            		}
            		byPage(0);
            		url="common/jsp/manageModule/"+table+".jsp";
            		load(url,function(){goodsLoad();});
            		alert("提交成功");
            	}
            },
            error:function(){
            	alert("提交失败");
            }
		})
	}).on("click",".del",function(){//删除信息
		var $thisTd=$(this).parent();
		$.post(table+"Del.do","id="+$thisTd.siblings().eq(0).html(),function(data){
			if(data="true"){
				byPage(0);
				$totalCount.html(parseInt($totalCount.html())-1);
				$totalPage.html(Math.ceil(parseInt($totalCount.html())/parseInt($pageSize.val())));
				url="common/jsp/manageModule/"+table+".jsp";
				alert("删除成功")
			}else{
				alert("删除失败")
			}
		})
	}).on("input","#keyword",function(){ //增加商品时选择商家
		$keyword=$("#keyword");//搜索商家关键字
		$sellerId=$("#sellerId");//商家ID隐藏域
		$souSeller=$("#souSeller");//搜索列表栏
		var keyword=$keyword.val();
		if(keyword!=null&&keyword!=""){
			$.post("sellerList.do",{"keyword":keyword,"startPage":0,"pageSize":10},function(data){
				$souSeller.html("");
				$(data).each(function(index,value){
					$souSeller.append("<dt class='sellerDt' value="+value.id+">"+value.name+"|&nbsp;&nbsp;&nbsp;电话："+value.telephone+"|&nbsp;&nbsp;&nbsp;地址："+value.address+"</dt>")
				})
				$sellerDt=$(".sellerDt").eq(0);
			},"json")
		};
	}).on("mouseover mouseout",".sellerDt",function(){
		$(this).toggleClass("sellerDtHover");
	}).on("click",".sellerDt",function(){
		$souSeller.html("");
		$keyword.val($(this).html().split("|")[0]);
		$sellerId.val($(this).attr("value"));
	}).on("blur","#keyword",function(){
		$souSeller.html("");
		$keyword.val($sellerDt.html().split("|")[0]);
		$sellerId.val($sellerDt.attr("value"));
	})
	
	//新增记录模态框显示
	$add.click(function(){
		$("#btn").val("添加");
		$("#modal-overlay").css("visibility","visible");
	})
	$("#module").on("click","#close",function(){
		$("#modal-overlay").css("visibility","hidden");
	})
	