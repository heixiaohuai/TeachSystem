$(function(){
	//搜索栏日期确定
	var times=document.getElementsByName("time");
	$(times).bind("click",function(){
		if($(this).val()!="userdef"){
			$(".hd input[type='text']").hide();
		}
		switch($(this).val())
		{
			case "today":
				alert("today");
				break;
			case "threeday":
				alert("threeday");
				break;
			case "oneweek":
				alert("oneweek");
				break;
			case "onemonth":
				alert("onemonth");
				break;
			case "userdef":
				$(".hd input[type='text']").show();
				break;
			default:
				break;				
		}
	});

	//导入文件控制
	//显示隐藏文件导入对话框
	$(".toolbar .inoutarea .import").click(function(){
		$(".container .browse").show();
	});

	$(".container .browse .top i").click(function(){
		$(".container .browse").hide();
	});

	$(".container .browse .content .buttons .cancel").click(function(){
		$(".container .browse").hide();
	});

	//显示隐藏增加学生信息对话框
	$(".toolbar .optarea .add").click(function(){
		$(".addstu").show();
	});

	$(".addstu .top i").click(function(){
		$(".addstu").hide();
	});

	$(".addstu .main .stuform .cancel").click(function(){
		$(".addstu").hide();
	});

	//显示隐藏修改学生信息对话框
	$(".tablebd tr#data a#update").click(function(){
		$(".updatestu").show();
	});

	$(".updatestu .top i").click(function(){
		$(".updatestu").hide();
	});

	$(".updatestu .main .stuform .cancel").click(function(){
		$(".updatestu").hide();
	});

	//导入文件提示框鼠标拖拽功能
	$(".browse").bind("mousedown",function(event){
		obj=$(this);
		if(event.button==0){
			 gapX=event.clientX-obj.offset().left;  
             gapY=event.clientY-obj.offset().top;

             $(document).bind("mousemove",function(e){
				obj.css({  
				            "left":(e.clientX-gapX)+"px",  
				            "top":(e.clientY-gapY)+"px"  
				        });  
				return false;//阻止默认事件或冒泡  
             }); 

             $(document).bind("mouseup",function(){
             	$(document).unbind("mousemove");  
                $(document).unbind("mouseup"); 
             });
		}	
	});

	
	//增加学生信息对话框鼠标拖拽功能
	$(".addstu").blur(function(){
			$(this).unbind("mousedown");
		});
	$(".addstu").focus(function(){
		$(".addstu").bind("mousedown",function(event){
				obj=$(this);
				if(event.button==0){
					 gapX=event.clientX-obj.offset().left;  
		             gapY=event.clientY-obj.offset().top;

		             $(document).bind("mousemove",function(e){
						obj.css({  
						            "left":(e.clientX-gapX)+"px",  
						            "top":(e.clientY-gapY)+"px"  
						        });  
						return false;//阻止默认事件或冒泡  
		             }); 

		             $(document).bind("mouseup",function(){
		             	$(document).unbind("mousemove");  
		                $(document).unbind("mouseup"); 
		             });
				}	
			});
	});
	
	//修改学生信息对话框鼠标拖拽功能
	$(".updatestu").blur(function(){
			$(this).unbind("mousedown");
		});
	$(".updatestu").focus(function(){
		$(".updatestu").bind("mousedown",function(event){
				obj=$(this);
				if(event.button==0){
					 gapX=event.clientX-obj.offset().left;  
		             gapY=event.clientY-obj.offset().top;

		             $(document).bind("mousemove",function(e){
						obj.css({  
						            "left":(e.clientX-gapX)+"px",  
						            "top":(e.clientY-gapY)+"px"  
						        });  
						return false;//阻止默认事件或冒泡  
		             }); 

		             $(document).bind("mouseup",function(){
		             	$(document).unbind("mousemove");  
		                $(document).unbind("mouseup"); 
		             });
				}	
			});
	});


	//工具栏鼠标hover变换图标
	$(".toolbar .optarea a").mouseenter(function(){
		if($(this).hasClass("add")){
			$(this).find(".icon").css({"background":"url('../images/ico01.png')"});
		}else if($(this).hasClass("delete")){
			$(this).find(".icon").css({"background":"url('../images/ico02.png')"});
		}else if($(this).hasClass("statistics")){
			$(this).find(".icon").css({"background":"url('../images/ico03.png')"});
		}	
	});
	$(".toolbar .optarea a").mouseleave(function(){
		if($(this).hasClass("add")){
			$(this).find(".icon").css({"background":"url('../images/ico01_1.png')"});
		}else if($(this).hasClass("delete")){
			$(this).find(".icon").css({"background":"url('../images/ico02_1.png')"});
		}else if($(this).hasClass("statistics")){
			$(this).find(".icon").css({"background":"url('../images/ico03_1.png')"});
		}	
	});

	$(".toolbar .inoutarea a").mouseenter(function(){
		if($(this).hasClass("export")){
			$(this).find(".icon").css({"background":"url('../images/export.png')","background-size":"cover"});
		}else if($(this).hasClass("import")){
			$(this).find(".icon").css({"background":"url('../images/import.png')","background-size":"cover"});
		}	
	});

	$(".toolbar .inoutarea a").mouseleave(function(){
			if($(this).hasClass("export")){
				$(this).find(".icon").css({"background":"url('../images/export1.png')","background-size":"cover"});
			}else if($(this).hasClass("import")){
				$(this).find(".icon").css({"background":"url('../images/import1.png')","background-size":"cover"});
			}	
		});
	//判断文字是否超出
	$(".table .tablebd #data td").mouseenter(function(){
		var thisWidth = $(this).width(); // td的宽度
        var wordWidth = $(this)[0].scrollWidth; // 先转为js对象; 文字的宽度
        if(wordWidth > thisWidth+5){// 加5是为了让td宽度多一点,比文字不超出时多宽,因为文字不超出,那么宽度为td的宽度
            $(this).attr({"title":$(this).text()});
            $(this).css({"cursor":"context-menu"});
        }
	});

	//数据升序降序排序图标切换
	var sflag=true;
	$(".table table tr#head td a#sort").click(function(){
		if(sflag){
			$(this).css({"background":"url('../images/new_icon2.png') no-repeat -32px 0px"});
			$(".table table tr#head td a#sort").not($(this)).css({"background":"url('../images/new_icon2.png') no-repeat -16px 0px"});
			sflag=false;	
		}else{
			$(this).css({"background":"url('../images/new_icon2.png') no-repeat -48px 0px"});
			$(".table table tr#head td a#sort").not($(this)).css({"background":"url('../images/new_icon2.png') no-repeat -16px 0px"});
			sflag=true;
		}
		
	});

	//更新用户信息数据回显
    $(".tablebd tr#data a#update").bind("click",function(){
    	var arr=[];
    	$(this).parent().parent().find("td")
    		.not($(this).parent().parent().find("td").first())
    		.not($(this).parent().parent().find("td").last())
    		.each(function(i){
    			var data=$(this).text();
    			arr.push(data);
    		});
    	console.log(arr);	
    	$(".updatestu .main .stuform #updateform #uno").val(arr[0]);
    	$(".updatestu .main .stuform #updateform .preview").attr({"src":$(this).parent().parent().find("td").eq(3).find("a").attr("src")});
 		arr=[];
    });


    //增加管理员表单验证
    $.validator.addMethod("checkpic",function(value,element,params){
				var name=value;
				var pos=name.indexOf(".");
				var suffix=name.slice(pos+1);
				if(suffix==params[0]||suffix==params[1]||suffix==params[2])
					return true;
				else
					return false;		
			},"请选择后缀名为JPG/PNG/BMP的文件上传");

    $("#addform").validate({
    	rules:{
    		ano:{
    			required:true,
    			maxlength:30
    		},
    		apwd:{
    			required:true,
    			maxlength:30
    		},
    		arepwd:{
    			required:true,
    			maxlength:30,
    			equalTo:"#apwd"
    		},
    		simg:{
    			required:true,
		    	checkpic:["jpg","png","bmp"]
    		}
    	},
    	messages:{
    		ano:{
    			required:"请输入账号",
    			maxlength:"账号不能超出30个字符"
    		},
    		apwd:{
    			required:"请输入密码",
    			maxlength:"密码不能超出30个字符"
    		},
    		arepwd:{
    			required:"请输入确认密码",
    			maxlength:"确认密码长度不能超出30个字符",
    			equalTo:"两次输入的密码不一致"
    		},
    		simg:{
    			required:"请选择上传图片"
    		}
    	}
    });

   //修改管理员表单验证
    $("#updateform").validate({
    	rules:{
    		uno:{
    			required:true,
    			maxlength:30
    		},
    		upwd:{
    			required:true,
    			maxlength:30
    		},
    		urepwd:{
    			required:true,
    			maxlength:30,
    			equalTo:"#upwd"
    		},
    		uimg:{
    			required:true,
		    	checkpic:["jpg","png","bmp"]
    		}
    	},
    	messages:{
    		uno:{
    			required:"请输入账号",
    			maxlength:"账号不能超出30个字符"
    		},
    		upwd:{
    			required:"请输入密码",
    			maxlength:"密码不能超出30个字符"
    		},
    		urepwd:{
    			required:"请输入确认密码",
    			maxlength:"确认密码长度不能超出30个字符",
    			equalTo:"两次输入的密码不一致"
    		},
    		uimg:{
    			required:"请选择上传图片"
    		}
    	}
    });  

   	//点击查看图片,对于AJAX中新增的元素要用这种事件监听
    $(".table").on("click",".tablebd #data #showimg",function(e){
    	var div="<div id='imgdiv'> \
    					<img src="+$(this).attr('src')+">"+ 
    				"</div>";
    	$(".table").append(div);
    	$(".table #imgdiv").css({width:"240px",height:"240px",border:"1px solid #ccc",position:"absolute",left:e.clientX,top:e.clientY});
    	$(".table #imgdiv img").css({width:"240px",height:"240px"});	
    	return false; //阻止默认事件或冒泡。  		
    });

    //点击其他地方消失
    $("body").not(".table .tablebd #data #showimg").bind("click",function(){
    	$(".table #imgdiv").remove();
    });




	//分页
    // pageMe.js 使用方法
    $("#page").paging({
        pageNum: 1, // 当前页面
        totalNum: 30, // 总页码
        totalList: 300, // 记录总数量
        callback: function (num) { //回调函数
            console.log(num);
        }
    });
    
});


