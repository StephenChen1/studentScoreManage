
(function ($) {
        //函数定义，查找课程列表，显示在课程下拉框
        $.showCourses = function (year,semester,isEntered) {
        	//参数有教师Id,年份，学期,教师id由后台从cookie获取
            var data = {
            		year:year,
            		semester:semester,
            		isEntered:isEntered
              }
              
              $.ajax({
              	  type : "post",
              	  url:"../course/serchOneTeacherCourses",
              	  contentType:"application/json",
                  data:JSON.stringify(data),
                  success:function(result){
                   
                	  
                	  //true说明更新查询学生成绩弹出框的课程下拉框
                	 if(isEntered == true){
                		 
                	 
                		 //妈的，试了几百个方法，options.length不起作用
                		 //最后才找到这个方法清除下拉框
                		 $("#courseOptions").find("option").remove();   
                    
                		 //把课程添加到课程下拉框
                		 for(var i = 0 ; i < result.length ; i ++){
                			 var text = result[i].courseName +"(" + result[i].courseId + ")";
                			 $("#courseOptions").append("<option value='"+result[i].teachId+"'>"+text+"</option>");
                		 }
                	 }else if(isEntered == false){
                		//false说明更新录入学生成绩弹出框的课程下拉框
                		 $("#courseOptionsEnter").find("option").remove();   
                         
                		 //把课程添加到课程下拉框
                		 for(var i = 0 ; i < result.length ; i ++){
                			 var text = result[i].courseName +"(" + result[i].courseId + ")";
                			 $("#courseOptionsEnter").append("<option value='"+result[i].teachId+"'>"+text+"</option>");
                		 }
                	 }else{
                		 consolg.log("isEntered:" + isEntered);
                	 }
                  }
              });
            
        }
        
        
        //初始化年份下拉框
        $.initYearsAndCourses = function (isEntered) {
        	//初始化年份下拉框
        	$.ajax({
          	      type : "post",
          	      url:"../teacher/getYear",
          	  	  contentType:"application/json",
                
                  success:function(result){
                	  //alert("result.length: "+result.length);
                	  
              	    if(isEntered == true){
              	    	
              	    	 //先删除下拉框内容
              	    	 $("#yearOptions").find("option").remove();   
              	         //把查询学生成绩页面  年份下拉框填上
                	      for(var i = 0 ; i < result.length ; i ++){
                	    	  var text = result[i];
                	    	  $("#yearOptions").append("<option value='"+text+"'>"+text+"</option>"); 
                	      }
              	      }else if(isEntered == false){
              	    	
              	    	  //先删除下拉框内容
              	    	  $("#yearOptionsEnter").find("option").remove();   
              	    	  //把录入学生成绩页面  年份下拉框填上
              	    	  for(var i = 0 ; i < result.length ; i ++){
              	    		  var text = result[i];
              	    		  $("#yearOptionsEnter").append("<option value='"+text+"'>"+text+"</option>"); 
              	    	  }
              	    }else{
              	    	console.log("isEntered:"+isEntered);
              	    }
              	    //初始化课程下拉框
              		//得到年份下拉框中的第一个值，因为得不到选中的值（技术问题）option:selected 改成first也行
              	    //后来发现不是技术问题，而是因为异步的原因，把下面的代码放到外面的话，会同时执行，娶不到想要的值
              	    var year = $("#yearOptions option:selected").val();
              	    //console.log("year:" + year);
              	    //得到学期
              	    var semester = $("#semesterOptions option:selected").val();
              	    //console.log("semester:" + semester);
              	    /*//是否已录入过标识
              	    var isEntered = true ;*/
              	    //alert("isEntered:" + isEntered);
              	    //调用方法去更新下拉框,根据isEntered的值去确定更新哪个弹出框的课程下拉值
              	    $.showCourses(year,semester,isEntered);
              	  }
        	});
        }
        
        
        
    })(jQuery);


$(document).ready(function(){
	
	
	//通过教师id查到教师信息,显示在界面左上角，教师Id由后台调用cookie得到
	$.ajax({
    	  type : "post",
    	  url:"../teacher/getTeacherMessage",
    	  contentType:"application/json",
          
          success:function(result){
        	  //alert(result.name);
        	 //界面左上角显示教师信息
        	  $("#userName").text(result.name);
        	  $("#userId").text(result.id);  
        }
	});
	
	
	//是否已录入过标识,这里是查询成绩页面，所以是true
	var isEntered = true ;
	//初始化年份下拉框
	$.initYearsAndCourses(isEntered);
	
	
	
	
	//查询条件弹出框的年份和学期下拉框选择内容改变
	$(".yearOrSemester").bind("change",function(){
		//得到下拉框中被选中的值   年份
        var year = $("#yearOptions option:selected").val();
        //alert("year:" + year);
        //得到学期
        var semester = $("#semesterOptions option:selected").val();
        //alert("semester:" + semester);
        //alert("name:" + $(this).attr("name"));
        //console.log("dataname1:" + semester);
        //是否已录入过标识
        var isEntered = true ;
        //调用方法去更新下拉框
        $.showCourses(year,semester,isEntered);   
     });
	
	//点击查询事件
	$("#serch").click(function(){
		//显示课程名
		var courseName = $("#courseOptions option:selected").text();
		$("#courseName").text(courseName +"成绩单");
		   
		
		//得到教学id
		var teachId = $("#courseOptions option:selected").val();
		//console.log("teachId:" + teachId);
		//封装参数
		var data = {				
        		teachId:teachId
        }
		
		//AJAx
		$.ajax({
        	  type : "post",
        	  url:"../course/serchOneCourseScores",
        	  contentType:"application/json",
              data:JSON.stringify(data),
              success:function(result){
            	  //alert(result.length);
            	 //先删除表格中的内容
       	    	 $("#scoreTableBody").find("tr").remove();   
            	  //遍历展示数据
            	  for(var i = 0 ; i < result.length ; i ++){
                	  var text = result[i].courseName +"(" + result[i].courseId + ")";
                	  $("#scoreTable").append("<tr><td>"+result[i].studentId+"</td>"+
                			       					"<td>"+result[i].studentName+"</td>"+
                			       					"<td>"+result[i].classes+"</td>"+
                			       					"<td>"+result[i].score+"</td></tr>"
                	  						);
                  }
              }  	
         });
		
	});
		
	
	
	//录入学生成绩界面js开始
	
	//点击左侧录入学生成绩按钮事件
	$("#scoreEnterPane").click(function(){
		//更新选择条件下拉框 年份 课程
		//alert("处理绝对经典");
		//是否已录入过标识,这里是录入成绩页面，所以是false
		var isEntered = false ;
		//初始化年份下拉框
		$.initYearsAndCourses(isEntered);
		//alert("处理绝典" +isEntered);
	})
	
	
	//弹出框确认按钮点击事件，展示课程的学生列表，待输入分数
	$("#serchEnter").click(function(){
		
		//得到课程名
		var courseName = $("#courseOptionsEnter option:selected").text();
		$("#courseNameEnter").text(courseName);
		//alert(courseName);
		//得到教学id
		var teachId = $("#courseOptionsEnter option:selected").val();
		//console.log("teachId:" + teachId);
		
		//封装参数
		var data = {				
        		teachId:teachId
        }
		
		//AJAx
		$.ajax({
        	  type : "post",
        	  url:"../course/serchOneCourseScores",
        	  contentType:"application/json",
              data:JSON.stringify(data),
              success:function(result){
            	  //alert(result.length);
            	  //先删除表格中的内容
        	      $("#scoreEnterTableBody").find("tr").remove(); 
            	  //遍历展示数据
            	  for(var i = 0 ; i < result.length ; i ++){
                	  var text = result[i].courseName +"(" + result[i].courseId + ")";
                	  $("#scoreEnterTable").append("<tr><td>"+result[i].studentId+"</td>"+
                			       					"<td>"+result[i].studentName+"</td>"+  +result[i].score+
                			       					"<td>"+result[i].classes+"</td>"+
                			       					"<td><input type ='text' value = " + result[i].score + "></input></td></tr>"
                	  						);
                  }
              }  	
         });
	})
	
	
	//查询条件弹出框的年份和学期下拉框选择内容改变
	$(".yearOrSemesterEnter").bind("change",function(){
		//得到下拉框中被选中的值   年份
        var year = $("#yearOptionsEnter option:selected").val();
        
        //得到学期
        var semester = $("#semesterOptionsEnter option:selected").val();
        
        //是否已录入过标识
        var isEntered = false ;
        //调用方法去更新下拉框
        $.showCourses(year,semester,isEntered);   
    });
	
	
	//提交按钮点击事件
	$("#commitEnter").click(function(){
		//得到教学id
		var teachId = $("#courseOptionsEnter option:selected").val();
		//声明数组存储学生id和成绩的对象
		var scoreData = new Array();
		
		
		//遍历Tablebody得到每行的学生id和成绩
		$('#scoreEnterTableBody tr').each(function(i){
			
			//alert("第"+(i+1)+"行：""studentId："+$(this).text()+"。");
			//第二列单元格的值eq(索引)
			//alert($(this).children('td:eq(0)').text());
			//alert($(this).children('td:eq(3)').children('input').val());
			//得到第一列的值
			var studentId = $(this).children('td:eq(0)').text();
			//得到第四列的值
			var studentScore = $(this).children('td:eq(3)').children('input').val();
			//声明对象了来存储id和成绩
			var studentOdj = new Object();
			studentOdj.studentId = studentId ;
			//转换为double类型
			studentOdj.studentScore = parseFloat(studentScore) ;
			//把对象放进数组
			scoreData.push(studentOdj);
		});
		
		//异步传送数据到后台，提交成功则显示成绩，不成功则继续留在该页面（一般都会成功）
		//1、封装数据
		var data = {				
        		teachId:teachId,
        		studentIdAndScores:scoreData
        }
		/*alert("teachId:"+ data.teachId);
		alert("ss:" + data.studentIdAndScore.length);
		for(var a = 0 ; a < data.studentIdAndScore.length ; a++){
			alert("a:"+data.studentIdAndScore[a]);
			alert("a:i"+data.studentIdAndScore[a].studentId);
			alert("a:s"+data.studentIdAndScore[a].studentScore);
		}
		alert("s3:"+ data.studentIdAndScore.toString());*/
		//提交改动后的数据
		$.ajax({
        	  type : "post",
        	  url:"../major/commitScores",
        	  contentType:"application/json",
              data:JSON.stringify(data),
              
              success:function(result){
            	  //alert(result.length);
            	//此时的result应该是String值，用parseJSON把其转换为boolean值
              	result = $.parseJSON(result);
              	//返回true说明成功提交，展示提交后的成绩
              	if(result){
              		alert("提交成功！！")
              	  //清空表格
          	      $("#scoreEnterTableBody").find("tr").remove(); 
              	}else{
              		alert("提交失败！！")
              	}
            	  
              }  	
         });
		
		
		
		
		         
	});
	
	
	
	
	
	//录入学生成绩界面js结束
			
  
});