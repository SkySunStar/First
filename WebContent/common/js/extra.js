
/**
 * 
 */
//分页跳转
var $pageNo=$("input[name='pageNo']");
var $pageSize=$("input[name='pageSize']");
var $startPage=$("input[name='startPage']");
var $totalCount=$("#totalCount");
var $totalPage=$("#totalPage");
var pageNo=1;//当前页码
var pageSize=5;//当前页面容量
var totalPage=1;//总页数
var originPageNo=1;//上一次的页码
var originPageSize=5;//上一次的页面容量
var keyword=null;//搜索关键字
var table=null;//表名
var typeId=null;//商品基本类别
var url=null;//局部加载路径
var thisName=null;//类别标签值
var $pageForm=$("#pageForm");//分页标签
$pageForm.hide();

//计算页码
function byPage(jumpPage){
	pageNo=parseInt($pageNo.val());
	pageSize=parseInt($pageSize.val());
	if(isNaN(pageNo)){
		$pageNo.val(originPageNo);
		pageNo=originPageNo;
	}
	pageNo+=parseInt(jumpPage);
	if(isNaN(pageSize)||pageSize<1){
		$pageSize.val(originPageSize);
		pageSize=originPageSize;
	}
	
	totalPage=Math.ceil(parseInt($totalCount.html())/pageSize);
	$totalPage.html(totalPage);
	$startPage.val((pageNo-1)*pageSize);
}

//局部加载页面
function load(url,func){
	if(pageNo>0&&pageNo<=totalPage&&pageSize<100||totalPage==0){
		$pageNo.val(pageNo);
		if(totalPage!=0){
			originPageNo=pageNo;
			originPageSize=pageSize;
		}else{
			$pageNo.val(originPageNo);
			$pageSize.val(originPageSize);
		}
		$.post(table+"List.do",{"startPage":$startPage.val(),"pageSize":pageSize,"typeId":typeId,"keyword":keyword},function(data){
			$("#module").load(url,func);
		})
	}else{
		$pageNo.val(originPageNo);
		$pageSize.val(originPageSize);
	}
}

