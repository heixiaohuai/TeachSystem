$(function(){
	//显示首页
	$(".hd .setting li:first").click(function(){
		$(".tab").find('li').eq(0).find("a").click();
	});

	//更换导航栏图标
	$(".desc").mouseenter(function(){
		$(".desc img").attr({"src":"../images/lefticon.png"});
	});
	$(".desc").mouseleave(function(){
		$(".desc img").attr({"src":"../images/left_tree.png"});
	});

	//显示/隐藏导航栏
	var flag=true;
	$(".toleft").click(function(){
		$(".nav").toggle(500);
		if(flag){
			$(this).animate({"top":"0px","left":"0px"},500,function(){
				$(this).css({"background":"url('../images/toright.png') no-repeat"});	
			});
			flag=false;	
		}else{
			$(this).animate({"top":"7px","left":"184px"},500,function(){
				$(this).css({"background":"url('../images/toleft.png') no-repeat"});	
			});
			flag=true;
		}
	});

	//左侧导航菜单栏控制
	$(".menus dd").css({"display":"none"});
	$(".menus dt").click(function(){
		if($(this).siblings("dd").css("display")=="none"){
			$(this).siblings("dd").show(10);
			$(this).find(".menus-text").css({"color":"#047db6"});
			$(this).find(".menus-icon").css({"background":"url('../images/leftmenu1.png') no-repeat center center"});
		}else{
			$(this).siblings("dd").hide(10);
			$(this).find(".menus-text").css({"color":"#4a4a4a"});
			$(this).find(".menus-icon").css({"background":"url('../images/leftmenu.png') no-repeat center center"});
		}
	});

	//tabpage的实现
	var cacheOpen={};
	$(".menus dd a").click(function(){
		var id=$(this).attr("data-id");
		var href=$(this).attr("href");
		if(cacheOpen[id])
 			return false;
 		var title="<li data-id="+id+"> \
						<a href='javascript:void(0)' class='tagpage'> \
						   <span>"+$(this).text()+"</span> \
						   <i class='close-tab'></i> \
						</a> \
 					 </li>";	
 		
 		var iframe = '<iframe data-id="'+ id +'" width="100%" height="100%" frameborder="0" name="tabpage" src="'+ href +'"></iframe>';
 		cacheOpen[id]={};
 		console.log(cacheOpen);	 
 		$(".tab").append($(title));
 		$(".content").append($(iframe));
	});


	$(".menus dd a").bind("click",function(){
		var str=$(this).text();
		var addr=$(this).attr("href");
		$(this).parent().parent().css({"background-color":"#38a3d5","color":"#333","border":"none"});
		$(".menus dd").not($(this).parent().parent()).css({"background-color":"#fff"});
		$(".tab a").each(function(i){
			if($(this).find("span").text()==str){
				$(this).css({"background":"url('../images/tab2.png') repeat-x","color":"#37a8dd","font-size": "15px"});
				$(".tab a").not($(this)).css({"background":"url('../images/tab1.png') repeat-x","color":"#000","font-size": "14px"});
			}
		});

		$(".content iframe").each(function(i){
			if($(this).attr("src")==addr){
				$(this).show();
				$(".content iframe").not($(this)).hide();
			}
		});

		//tabpage数量超出范围的处理
		if($(window).width()-$(".tab").find("li").last().offset().left-203<50){
			var str="<div class='more'></div>";
			$(".title").append($(str));
		}
		
	});

	//显示/隐藏第二行的tagpage
	var flag=true;
	$(".title").on("click","div.more",function(){
		if(flag){
			$(".main .title").css({"overflow-y":"visible"});
			$(this).css({"background":"url('../images/up.png') no-repeat","background-size":"cover"});
			flag=false;	
		}else{
			$(".main .title").css({"overflow-y":"hidden"});
			$(this).css({"background":"url('../images/down.png') no-repeat","background-size":"cover"});
			flag=true;	
		}
		
	});

	//激活tabpage
	$(".tab").on("click","a",function(){
		var id = $(this).parent().attr("data-id");
		$(this).css({"background":"url('../images/tab2.png') repeat-x","color":"#5773DC","font-size": "15px"});
		$(".tab a").not($(this)).css({"background":"url('../images/tab1.png') repeat-x","color":"#000","font-size": "14px"});

		$(".content iframe").each(function(i){
			if($(this).attr("data-id")==id){
				$(this).show();
				$(".content iframe").not($(this)).hide();
			}
		});
	});

	//关闭tabpage
	$(".tab").on("click",".close-tab",function(e){
		//JS点击子元素不触发父元素点击事件(js阻止冒泡)
		e = e || window.event;  
        if(e.stopPropagation) { //W3C阻止冒泡方法  
            e.stopPropagation();  
        } else {  
            e.cancelBubble = true; //IE阻止冒泡方法  
        }  

		var id=$(this).parent().parent().attr("data-id");
		index = $(this).parent().parent().index();
		$tab = $(".tab").find('li').eq(index - 1).find("a");//找到上一个tabpage
		
		if($(this).parent().parent().offset().top <= 78){
			//tabpage数量在正常范围的处理
			if($(window).width()-$(".tab").find("li").last().offset().left>30){
				$(".more").remove();
			}
		}

		delete cacheOpen[id];
		
		$(".tab").get(0).removeChild($(this).parent().parent().get(0));

		$tab.click(); //点击这个tabpage，让其激活

		$(".content iframe").each(function(i){
			if($(this).attr("data-id")==id){
				$(this).remove();
			}
		});
	});

	function move(event){  
        $(this).css({  
            "left":(event.clientX-gapX)+"px",  
            "top":(event.clientY-gapY)+"px"  
        });  
        return false;//阻止默认事件或冒泡  
    } 
    
	//退出提示框鼠标拖拽功能
	$(".exit").bind("mousedown",function(event){
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

	//打开退出框
	$(".hd .setting .quit").click(function(){
		$(".exit").show();
	});
	//关闭退出框
	$(".exit .top i").click(function(){
		$(".exit").hide();
	});
	$(".buttons .cancel").click(function(){
		$(".exit").hide();
	});

	$.ajaxSetup({
		contentType:"application/x-www-form-urlencoded;charset=utf-8"
	});

	//注销登陆
	// $(".buttons .ok").click(function(){
	// 	$.post("/TeachSys/logout",{},function(data){
	// 		console.log(data);
	// 		window.location.href = "../login.html";
	// 	},"text");
		
	// });

	function getId(){
		var str=location.search;//获得整个URL地址
		var pos=str.lastIndexOf("=")+1;
		var id=str.substr(pos);
		return id;
	}
	
	 //显示用户名
	 $.post("/TeachSystem/getUserInfo",{"id":getId()},function(user){
	 	$("#username").html(user.uaccount);
	 	$(".userinfo img").attr({"src":user.uimg});
	 },"json");

});	