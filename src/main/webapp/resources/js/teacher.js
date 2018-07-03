
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
                   
                	//妈的，试了几百个方法，options.length不起作用
                	//最后才找到这个方法清除下拉框
                    $("#courseOptions").find("option").remove();   
                    
                	//把课程添加到课程下拉框
                    for(var i = 0 ; i < result.length ; i ++){
                	   var text = result[i].courseName +"(" + result[i].courseId + ")";
                	   $("#courseOptions").append("<option value='"+result[i].teachId+"'>"+text+"</option>");
                    }
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
	//初始化年份下拉框
	$.ajax({
  	      type : "post",
  	      url:"../teacher/getYear",
  	  	  contentType:"application/json",
        
          success:function(result){
        	  //alert("result.length: "+result.length);
        	  //把年份下拉框填上
      	      for(var i = 0 ; i < result.length ; i ++){
      	    	  var text = result[i];
      	    	  $("#yearOptions").append("<option value='"+text+"'>"+text+"</option>"); 
      	      }
      	      
      	    //初始化下拉框
      		//得到年份下拉框中的第一个值，因为得不到选中的值（技术问题）option:selected 改成first也行
      	    //后来发现不是技术问题，而是因为异步的原因，把下面的代码放到外面的话，会同时执行，娶不到想要的值
      	    var year = $("#yearOptions option:selected").val();
      	    //console.log("year:" + year);
      	    //得到学期
      	    var semester = $("#semesterOptions option:selected").val();
      	    //console.log("semester:" + semester);
      	    //是否已录入过标识
      	    var isEntered = true ;
      	    //调用方法去更新下拉框
      	    $.showCourses(year,semester,isEntered);
      	  }
	});
	
	
	
	
	
	
	
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
		//得到教师id
		   
		
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
		
	
	
	
	
			
  
});