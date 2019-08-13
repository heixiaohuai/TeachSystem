$(function(){
    $.ajaxSetup({
        contentType:"application/x-www-form-urlencoded;charset=utf-8"
    });

    function showTeachers(){
        $.post("/TeachSystem/getmyscorecount",{},function(count){
            $.post("/TeachSystem/getmyscorepagestotal",{},function(pagestotal){
                //显示第一页数据
                $.post("/TeachSystem/getmyscorepages",{"curPage":1},function(myscore){
                    var thead="";
                    var content="";
                    $.each(myscore,function(index,score){
                        content+="<tr id='data'>" +
                            "<td>"+score.no+"</td>"+
                            "<td>"+score.grade+"</td>"+
                            "<td>"+score.cname+"</td>"+
                            "<td>"+
                            "<a href='inputscore.html' id='input'>录入</a>"+
                            "</td>"
                        "</tr>";
                    });
                    $(".table .tablebd tbody").empty();
                    $(".table .tablebd tbody").append(content);
                    $(".table .tablehd").find("tr").not(".tablehd #first").remove();
                },"json");

                //分页
                // pageMe.js 使用方法
                $("#page").paging({
                    pageNum: 1, // 当前页面
                    totalNum: pagestotal, // 总页码
                    totalList: count, // 记录总数量
                    callback: function (num) { //回调函数
                        console.log(num);
                        //取消全选
                        $(".tablehd #all").prop({"checked":false});

                        $.post("/TeachSystem/getmyscorepages",{"curPage":1},function(scores){
                            var thead="";
                            var content="";
                            $.each(scores,function(index,score){
                                content+="<tr id='data'>" +
                                    "<td>"+score.no+"</td>"+
                                    "<td>"+score.grade+"</td>"+
                                    "<td>"+score.cname+"</td>"+
                                    "<td>"+
                                    "<a href='inputscore.html' id='input'>录入</a>"+
                                    "</td>"
                                "</tr>";
                            });
                            $(".table .tablebd tbody").empty();
                            $(".table .tablebd tbody").append(content);
                            $(".table .tablehd").find("tr").not(".tablehd #first").remove();
                        },"json");
                    }
                });

            },"json");

        },"json");
    }
    showTeachers();

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

	//更新课程信息数据回显
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
    	$(".updatestu .main .stuform #updateform #uname").val(arr[1]);
    	$(".updatestu .main .stuform #updateform #ucredit").val(arr[2]);
    	$(".updatestu .main .stuform #updateform #uteacher").val(arr[3]);
    	$(".updatestu .main .stuform #updateform #ustart").val(arr[4]);
    	$(".updatestu .main .stuform #updateform #uaddr").val(arr[5]);
    	$(".updatestu .main .stuform #updateform #ukind").val(arr[6]);
 		arr=[];
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


    //增加课程信息表单验证
    $("#addform").validate({
    	rules:{
    		cno:{
    			required:true,
    			maxlength:18
    		},
    		cname:{
    			required:true,
    			maxlength:20
    		},
    		ccredit:{
    			required:true,
                digits:true
    		},
    		cteacher:{
    			required:true,
    			maxlength:20
    		},
    		cstart:{
    			required:true,
    			dateISO:true
    		},
    		caddr:{
    			required:true,
    			maxlength:50
    		},
    		ckind:{
    			required:true,
    			maxlength:20
    		}
    	},
    	messages:{
    		cno:{
    			required:"请输入课程号",
    			maxlength:"课程号长度不能超出18个字符"
    		},
    		cname:{
    			required:"请输入课程名",
    			maxlength:"课程名长度不能超出20个字符"
    		},
    		ccredit:{
                required:"请输入学分",
                digits:"学分必须为数字"
            },
            cteacher:{
                required:"请输入教师名",
                maxlength:"教师名长度不能超出20个字符"
            },
            cstart:{
                required:"请输入上课时间",
                dateISO:"不是有效时间格式，时间格式为yyyy-MM-dd"
            },
            caddr:{
                required:"请输入上课地点",
                maxlength:"上课地点长度不能超出50个字符"
            },
            ckind:{
                required:"请输入课程类型",
                maxlength:"课程类型长度不能超出20个字符"
            }
    	}
    });

   //修改教师信息表单验证
    $("#updateform").validate({
    	rules:{
            uno:{
                required:true,
                maxlength:18
            },
            uname:{
                required:true,
                maxlength:20
            },
            ucredit:{
                required:true,
                digits:true
            },
            uteacher:{
                required:true,
                maxlength:20
            },
            ustart:{
                required:true,
                dateISO:true
            },
            uaddr:{
                required:true,
                maxlength:50
            },
            ukind:{
                required:true,
                maxlength:20
            }
        },
        messages:{
            uno:{
                required:"请输入课程号",
                maxlength:"课程号长度不能超出18个字符"
            },
            uname:{
                required:"请输入课程名",
                maxlength:"课程名长度不能超出20个字符"
            },
            ucredit:{
                required:"请输入学分",
                digits:"学分必须为数字"
            },
            uteacher:{
                required:"请输入教师名",
                maxlength:"教师名长度不能超出20个字符"
            },
            ustart:{
                required:"请输入上课时间",
                dateISO:"不是有效时间格式，时间格式为yyyy-MM-dd"
            },
            uaddr:{
                required:"请输入上课地点",
                maxlength:"上课地点长度不能超出50个字符"
            },
            ukind:{
                required:"请输入课程类型",
                maxlength:"课程类型长度不能超出20个字符"
            }
        }
    });

    $.post("/TeachSystem/getteachers",{},function(teachers){
        var content="";
        $.each(teachers,function(index,teacher){
            content+="<option value="+teacher.tid+">"+teacher.tname+"</option>";
        });
        $("#addform #cteacher").empty();
        $("#addform #cteacher").append(content);
    },"json");


});


