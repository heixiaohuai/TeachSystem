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
	$(".table").on("click",".tablebd tr#data a#update",function(){
		$(".updatestu").show();
        var arr=[];
        $(this).parent().parent().find("td")
            .not($(this).parent().parent().find("td").last())
            .each(function(i){
                var data=$(this).text();
                arr.push(data);
            });
        console.log(arr);
        $(".updatestu .main .stuform #updateform #uid").val(arr[0]);
        $(".updatestu .main .stuform #updateform #uno").val(arr[1]).attr("readonly",true);
        $(".updatestu .main .stuform #updateform #uname").val(arr[2]);
        if(arr[3]=="男")
            $(".updatestu .main .stuform #updateform #uboy").attr({"checked":"checked"});
        else
            $(".updatestu .main .stuform #updateform #ugirl").attr({"checked":"checked"});
        $(".updatestu .main .stuform #updateform #uage").val(arr[4]);
        $(".updatestu .main .stuform #updateform #umajor").val(arr[5]);
        $(".updatestu .main .stuform #updateform #uuniversity").val(arr[6]);
        $(".updatestu .main .stuform #updateform #uphone").val(arr[7]);
        $(".updatestu .main .stuform #updateform #uaddr").val(arr[8]);
        $(".updatestu .main .stuform #updateform #uindate").val(arr[9]);
        $(".updatestu .main .stuform #updateform #uoutdate").val(arr[10]);
        $(".updatestu .main .stuform #updateform #upwd").val(arr[11]);
        $(".updatestu .main .stuform #updateform #uclass").val(arr[12]);
        $(".updatestu .main .stuform #updateform .preview").attr({"src":$(this).parent().parent().find("td").eq(13).find("a").attr("src")});
        arr=[];
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

	//更新学生信息数据回显
   /* $(".tablebd tr#data a#update").bind("click",function(){
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
    	$(".updatestu .main .stuform #updateform #umajor").val(arr[4]);
    	$(".updatestu .main .stuform #updateform #uuniversity").val(arr[5]);
    	$(".updatestu .main .stuform #updateform #uphone").val(arr[6]);
    	$(".updatestu .main .stuform #updateform #uaddr").val(arr[7]);
    	$(".updatestu .main .stuform #updateform #uindate").val(arr[8]);
    	$(".updatestu .main .stuform #updateform #uoutdate").val(arr[9]);
    	$(".updatestu .main .stuform #updateform #upwd").val(arr[10]);
    	$(".updatestu .main .stuform #updateform .preview").attr({"src":$(this).parent().parent().find("td").eq(12).find("a").attr("src")});
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

//增加学生信息表单验证
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
    		sno:{
    			required:true,
    			maxlength:18
    		},
    		sname:{
    			required:true,
    			maxlength:20
    		},
    		ssex:{
    			required:true
    		},
    		sage:{
    			required:true,
    			min:0,
    			max:200
    		},
    		smajor:{
    			required:true,
    			maxlength:50
    		},
    		suniversity:{
    			required:true,
    			maxlength:50
    		},
    		sphone:{
    			required:true,
    			checkphone:true
    		},
    		saddr:{
    			required:true,
    			maxlength:100
    		},
    		sindate:{
    			required:true,
    			dateISO:true
    		},
    		soutdate:{
    			required:true,
    			dateISO:true
    		},
    		spwd:{
    			required:true,
    			maxlength:20
    		},
    		simg:{
    			required:true,
		    	checkpic:["jpg","png","bmp"]
    		}
    	},
    	messages:{
    		sno:{
    			required:"请输入学号",
    			maxlength:"学号长度不能超出18个字符"
    		},
    		sname:{
    			required:"请输入姓名",
    			maxlength:"姓名长度不能超出20个字符"
    		},
    		ssex:{
    			required:"请选择性别"
    		},
    		sage:{
    			required:"请输入年龄",
    			min:"年龄不能小于0",
    			max:"年龄不能超过200"
    		},
    		smajor:{
    			required:"请输入专业名",
    			maxlength:"专业名长度不能超过50个字符"
    		},
    		suniversity:{
    			required:"请输入学院名称",
    			maxlength:"学院名称不能超过50个字符"
    		},
    		sphone:{
    			required:"请输入电话号码"
    		},
    		saddr:{
    			required:"请输入地址",
    			maxlength:"地址长度不超出100个字符"
    		},
    		sindate:{
    			required:"请输入日期",
    			dateISO:"日期格式不正确"
    		},
    		soutdate:{
    			required:"请输入日期",
    			dateISO:"日期格式不正确"
    		},
    		spwd:{
    			required:"请输入密码",
    			maxlength:"密码长度不能超过20个字符"
    		},
    		simg:{
    			required:"请选择上传图片"
    		}
    	}
    });

   //修改学生信息表单验证
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
    		umajor:{
    			required:true,
    			maxlength:50
    		},
    		uuniversity:{
    			required:true,
    			maxlength:50
    		},
    		uphone:{
    			required:true,
    			checkphone:true
    		},
    		uaddr:{
    			required:true,
    			maxlength:100
    		},
    		uindate:{
    			required:true,
    			dateISO:true
    		},
    		uoutdate:{
    			required:true,
    			dateISO:true
    		},
    		upwd:{
    			required:true,
    			maxlength:20
    		},
    		uimg:{
    			required:true,
		    	checkpic:["jpg","png","bmp"]
    		}
    	},
    	messages:{
    		uno:{
    			required:"请输入学号",
    			maxlength:"学号长度不能超出18个字符"
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
    		umajor:{
    			required:"请输入专业名",
    			maxlength:"专业名长度不能超过50个字符"
    		},
    		uuniversity:{
    			required:"请输入学院名称",
    			maxlength:"学院名称不能超过50个字符"
    		},
    		uphone:{
    			required:"请输入电话号码"
    		},
    		uaddr:{
    			required:"请输入地址",
    			maxlength:"地址长度不超出100个字符"
    		},
    		uindate:{
    			required:"请输入日期",
    			dateISO:"日期格式不正确"
    		},
    		uoutdate:{
    			required:"请输入日期",
    			dateISO:"日期格式不正确"
    		},
    		upwd:{
    			required:"请输入密码",
    			maxlength:"密码长度不能超过20个字符"
    		},
    		uimg:{
    			required:"请选择上传图片"
    		}
    	}
    });

    $.ajaxSetup({
        contentType:"application/x-www-form-urlencoded;charset=utf-8"
    });

    function showUsers(){
        $.post("/TeachSystem/admin/getStuTotalRows",{},function(count){
            $.post("/TeachSystem/admin/getStuTotalPages",{},function(pagestotal){
                //显示第一页数据
                $.post("/TeachSystem/admin/getStuByPage",{"currPage":1},function(students){
                    var thead="";
                    var content="";
                    $.each(students,function(index,student){
                        content+="<tr id='data'>" +
                            "<td>"+student.id+"</td>"+
                            "<td>"+student.no+"</td>"+
                            "<td>"+student.name+"</td>"+
                            "<td>"+student.sex+"</td>"+
                            "<td>"+student.age+"</td>"+
                            "<td>"+student.major+"</td>"+
                            "<td>"+student.university+"</td>"+
                            "<td>"+student.mobile+"</td>"+
                            "<td>"+student.addr+"</td>"+
                            "<td>"+student.start+"</td>"+
                            "<td>"+student.end+"</td>"+
                            "<td>"+student.pwd+"</td>"+
                            "<td>"+student.grade+"</td>"+
                            "<td><a href='#' src='"+student.img+"' id='showimg'>查看</a></td>"+
                            "<td>"+
                            "<a href='#' id='delete'>删除</a>"+
                            "&nbsp;"+
                            "<a href='#' id='update'>更新</a>"+
                            "</td>"
                        "</tr>";
                        thead+="<tr id='head"+index+"'>"+
                            "<td> \
                            <input type='checkbox' name='head"+index+"' id='head"+index+"' myid='"+student.no +"'>"+
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

                        $.post("/TeachSystem/admin/getStuByPage",{"currPage":num},function(students){
                            var thead="";
                            var content="";
                            $.each(students,function(index,student){
                                content+="<tr id='data'>" +
                                    "<td>"+student.id+"</td>"+
                                    "<td>"+student.no+"</td>"+
                                    "<td>"+student.name+"</td>"+
                                    "<td>"+student.sex+"</td>"+
                                    "<td>"+student.age+"</td>"+
                                    "<td>"+student.major+"</td>"+
                                    "<td>"+student.university+"</td>"+
                                    "<td>"+student.mobile+"</td>"+
                                    "<td>"+student.addr+"</td>"+
                                    "<td>"+student.start+"</td>"+
                                    "<td>"+student.end+"</td>"+
                                    "<td>"+student.pwd+"</td>"+
                                    "<td>"+student.grade+"</td>"+
                                    "<td><a href='#' src='"+student.img+"' id='showimg'>查看</a></td>"+
                                    "<td>"+
                                    "<a href='#' id='delete'>删除</a>"+
                                    "&nbsp;"+
                                    "<a href='#' id='update'>更新</a>"+
                                    "</td>"
                                "</tr>";
                                thead+="<tr id='head"+index+"'>"+
                                    "<td> \
                                    <input type='checkbox' name='head"+index+"' id='head"+index+"' myid='"+student.no +"'>"+
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
            $.post("/TeachSystem/admin/deleteStuById",{"did":delNo},function(msg){
                window.location.href="/TeachSystem/admin/stuman.html";
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
            $.post("/TeachSystem/admin/deleteStuByIds",{"myids":myids},function(msg){
                window.location.href="/TeachSystem/admin/stuman.html";
            },"text");
        }
    });


});


