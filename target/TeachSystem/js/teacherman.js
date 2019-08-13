$(function(){
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
	$(".table").on("click",".tablebd tr#data a#update", function () {
		$(".updatestu").show();
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
        if(arr[2]=="boy")
            $(".updatestu .main .stuform #updateform #uboy").attr({"checked":"checked"});
        else
            $(".updatestu .main .stuform #updateform #ugirl").attr({"checked":"checked"});
        $(".updatestu .main .stuform #updateform #uage").val(arr[3]);
        $(".updatestu .main .stuform #updateform #udept").val(arr[4]);
        $(".updatestu .main .stuform #updateform #utitle").val(arr[5]);
        $(".updatestu .main .stuform #updateform #upwd").val(arr[6]);
        $(".updatestu .main .stuform #updateform #uremark").val(arr[8]);
        $(".updatestu .main .stuform #updateform .preview").attr({"src":$(this).parent().parent().find("td").eq(8).find("a").attr("src")});
        arr=[];
    });
	/*$(".tablebd tr#data a#update").click(function(){
		$(".updatestu").show();
	});*/

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

	//更新学生信息数据回显
    /*$(".tablebd tr#data a#update").bind("click",function(){
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
    	if(arr[2]=="boy")
    		$(".updatestu .main .stuform #updateform #uboy").attr({"checked":"checked"});
    	else
    		$(".updatestu .main .stuform #updateform #ugirl").attr({"checked":"checked"});
    	$(".updatestu .main .stuform #updateform #uage").val(arr[3]);
    	$(".updatestu .main .stuform #updateform #udept").val(arr[4]);
    	$(".updatestu .main .stuform #updateform #utitle").val(arr[5]);
    	$(".updatestu .main .stuform #updateform #upwd").val(arr[6]);
    	$(".updatestu .main .stuform #updateform #uremark").val(arr[8]);
    	$(".updatestu .main .stuform #updateform .preview").attr({"src":$(this).parent().parent().find("td").eq(8).find("a").attr("src")});
 		arr=[];
    });*/

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


    //增加教师信息表单验证
 $.validator.addMethod("checkpic",function(value,element,params){
				var name=value;
				var pos=name.indexOf(".");
				var suffix=name.slice(pos+1);
				if(suffix==params[0]||suffix==params[1]||suffix==params[2])
					return true;
				else
					return false;		
			},"请选择后缀名为JPG/PNG/BMP的文件上传");
    $.validator.addMethod("checkphone",function(value,element,params){
    	var pnum=value;
    	if(pnum.match("^[1][3,4,5,7,8,9][0-9]{9}$")){
    		return true;
    	}else{
    		return false;
    	}
    },"请输入正确的手机号码");
    $("#addform").validate({
    	rules:{
    		tno:{
    			required:true,
    			maxlength:18
    		},
    		tname:{
    			required:true,
    			maxlength:20
    		},
    		tsex:{
    			required:true
    		},
    		tage:{
    			required:true,
    			min:0,
    			max:200
    		},
    		tdept:{
    			required:true,
    			maxlength:50
    		},
    		ttitle:{
    			required:true,
    			maxlength:20
    		},
    		tpwd:{
    			required:true,
    			maxlength:20
    		},
    		tremark:{
    			maxlength:500
    		},
    		timg:{
    			required:true,
		    	checkpic:["jpg","png","bmp"]
    		}
    	},
    	messages:{
    		tno:{
    			required:"请输入学号",
    			maxlength:"职工号长度不能超出18个字符"
    		},
    		tname:{
    			required:"请输入姓名",
    			maxlength:"姓名长度不能超出20个字符"
    		},
    		tsex:{
    			required:"请选择性别"
    		},
    		tage:{
    			required:"请输入年龄",
    			min:"年龄不能小于0",
    			max:"年龄不能超过200"
    		},
    		tdept:{
    			required:"请输入部门名",
    			maxlength:"部门名长度不能超过50个字符"
    		},
    		ttitle:{
    			required:"请输入职称",
    			maxlength:"职称名称不能超过20个字符"
    		},
    		tpwd:{
    			required:"请输入密码",
    			maxlength:"密码长度不能超过20个字符"
    		},
    		tremark:{
    			maxlength:"备注长度不超出500个字符"
    		},    		
    		timg:{
    			required:"请选择上传图片"
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
    		usex:{
    			required:true
    		},
    		uage:{
    			required:true,
    			min:0,
    			max:200
    		},
    		udept:{
    			required:true,
    			maxlength:50
    		},
    		utitle:{
    			required:true,
    			maxlength:20
    		},
    		upwd:{
    			required:true,
    			maxlength:20
    		},
    		uremark:{
    			maxlength:500
    		},
    		uimg:{
    			required:true,
		    	checkpic:["jpg","png","bmp"]
    		}
    	},
    	messages:{
    		uno:{
    			required:"请输入学号",
    			maxlength:"职工号长度不能超出18个字符"
    		},
    		uname:{
    			required:"请输入姓名",
    			maxlength:"姓名长度不能超出20个字符"
    		},
    		usex:{
    			required:"请选择性别"
    		},
    		uage:{
    			required:"请输入年龄",
    			min:"年龄不能小于0",
    			max:"年龄不能超过200"
    		},
    		udept:{
    			required:"请输入部门名",
    			maxlength:"部门名长度不能超过50个字符"
    		},
    		utitle:{
    			required:"请输入职称",
    			maxlength:"职称名称不能超过20个字符"
    		},
    		upwd:{
    			required:"请输入密码",
    			maxlength:"密码长度不能超过20个字符"
    		},
    		uremark:{
    			maxlength:"备注长度不超出500个字符"
    		},    		
    		uimg:{
    			required:"请选择上传图片"
    		}
    	}
    });

    function showUsers(){
        $.post("/TeachSystem/admin/getTeacherTotalRows",{},function(count){
            $.post("/TeachSystem/admin/getTeacherTotalPages",{},function(pagestotal){
                //显示第一页数据
                $.post("/TeachSystem/admin/getTeacherByPage",{"currPage":1},function(teacher){
                    var thead="";
                    var content="";
                    $.each(teacher,function(index,teacher){
                        content+="<tr id='data'>" +
                            "<td>"+teacher.tid+"</td>"+
                            "<td>"+teacher.tno+"</td>"+
                            "<td>"+teacher.tname+"</td>"+
                            "<td>"+teacher.tsex+"</td>"+
                            "<td>"+teacher.tage+"</td>"+
                            "<td>"+teacher.tdept+"</td>"+
                            "<td>"+teacher.ttitle+"</td>"+
                            "<td>"+teacher.tpwd+"</td>"+
                            "<td><a href='#' src='"+teacher.uimg+"' id='showimg'>查看</a></td>"+
                            "<td>"+teacher.tremark+"</td>"+
                            "<td>"+
                            "<a href='#' id='delete'>删除</a>"+
                            "&nbsp;"+
                            "<a href='#' id='update'>更新</a>"+
                            "</td>"
                        "</tr>";
                        thead+="<tr id='head"+index+"'>"+
                            "<td> \
                            <input type='checkbox' name='head"+index+"' id='head"+index+"' myid='"+teacher.tno+"'>"+
                            "</td> \
                                    </tr>";
                    });
                    $(".table .tablebd tbody").empty();
                    $(".table .tablebd tbody").append(content);
                    $(".table .tablehd").find("tr").not(".tablehd #first").remove();
                    $(".table .tablehd").append(thead);
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

                        $.post("/TeachSystem/admin/getTeacherByPage",{"currPage":num},function(teacher){
                            var thead="";
                            var content="";
                            $.each(teacher,function(index,teacher){
                                content+="<tr id='data'>" +
                                    "<td>"+teacher.tid+"</td>"+
                                    "<td>"+teacher.tno+"</td>"+
                                    "<td>"+teacher.tname+"</td>"+
                                    "<td>"+teacher.tsex+"</td>"+
                                    "<td>"+teacher.tage+"</td>"+
                                    "<td>"+teacher.tdept+"</td>"+
                                    "<td>"+teacher.ttitle+"</td>"+
                                    "<td>"+teacher.tpwd+"</td>"+
                                    "<td><a href='#' src='"+teacher.uimg+"' id='showimg'>查看</a></td>"+
                                    "<td>"+teacher.tremark+"</td>"+
                                    "<td>"+
                                    "<a href='#' id='delete'>删除</a>"+
                                    "&nbsp;"+
                                    "<a href='#' id='update'>更新</a>"+
                                    "</td>"
                                "</tr>";
                                thead+="<tr id='head"+index+"'>"+
                                    "<td> \
                                    <input type='checkbox' name='head"+index+"' id='head"+index+"' myid='"+teacher.tno+"'>"+
                                    "</td> \
                                            </tr>";
                            });
                            $(".table .tablebd tbody").empty();
                            $(".table .tablebd tbody").append(content);
                            $(".table .tablehd").find("tr").not(".tablehd #first").remove();
                            $(".table .tablehd").append(thead);
                        },"json");
                    }
                });

            },"json");

        },"json");
    }

    showUsers();

    //根据id删除，后面添加进来的元素的事件只能用on
    $(".table").on("click",".tablebd #data #delete",function(){
        var delNo = $(this).parents("tr#data").find("td").eq(1).text();
        var delName = $(this).parents("tr#data").find("td").eq(2).text();
        var flag = confirm("确定要删除"+delName+":"+delNo+"的信息吗？");
        if (flag){
            $.post("/TeachSystem/admin/deleteTeacherById",{"did":delNo},function(msg){
                window.location.href="/TeachSystem/admin/teacherman.html";
            },"text");
        }
        return false;
    });

    //批量删除
    $(".toolbar .optarea .delete").click(function(){
        var myids=[];
        var index=0;
        $(".table .tablehd").find("tr").not(".tablehd #first").each(function(i){
            var mycheck=$(this).find("input[type='checkbox']");
            if(mycheck.prop("checked")==true){
                console.log(mycheck.attr("myid"));
                myids.push(mycheck.attr("myid")); //数组是有序集合，对象是无序集合
            }
        });

        var flag = confirm("确定要删除所勾选的项目？");
        if (flag){
            $.post("/TeachSystem/admin/deleteTeacherByIds",{"myids":myids},function(msg){
                window.location.href="/TeachSystem/admin/teacherman.html";
            },"text");
        }
    });


});


