
(function ($) {
        /*//函数定义，查找课程列表，显示在课程下拉框
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
            
        }*/
    })(jQuery);


$(document).ready(function(){
	
	
	//通过教师id查到教师信息,显示在界面左上角，教师Id由后台调用cookie得到
	$.ajax({
    	  type : "post",
    	  url:"../student/getStudentMessage",
    	  contentType:"application/json",
          
          success:function(result){
        	  /*alert(result.name);
        	  alert(result.id);*/
        	 //界面左上角显示教师信息
        	  $("#userName").text(result.name);
        	  $("#userId").text(result.id);  
        }
	});
	
	//初始化年份下拉框
	$.ajax({
  	      type : "post",
  	      //教师与学生获取年份方式一样，直接在教师基础上改
  	      url:"../student/getStudentYears",
  	  	  contentType:"application/json",
        
          success:function(result){
        	  //alert("result.length: "+result.length);
        	  //把年份下拉框填上
      	      for(var i = 0 ; i < result.length ; i ++){
      	    	  var text = result[i];
      	    	  $("#yearOptions").append("<option value='"+text+"'>"+text+"</option>"); 
      	      }
      	   
      	  }
	});
	
	
	//点击查询事件
	$("#serch").click(function(){
		
		//得到下拉框的年份
		var year = $("#yearOptions option:selected").val();
		//得到下拉框的学期
		var semester = $("#semesterOptions option:selected").val();
		//封装参数
		var data = {				
				year:year,
				semester:semester
        }
		
		//AJAx
		$.ajax({
        	  type : "post",
        	  //获取学生课程成绩
        	  url:"../course/getScores",
        	  contentType:"application/json",
              data:JSON.stringify(data),
              success:function(result){
            	  if(result.length==0){
            		  $('#queryResult').html("没有对应学年、学期的的成绩记录");
            		  document.getElementById("queryResult").style.color="red";
            		  $("#tablebody").empty();
            	  }else{
            		//在遍历数据之前清空上次查询结果
                	  $('#queryResult').empty();
                	  $("#tablebody").empty();
                	  //遍历展示数据
                	  for(var i = 0 ; i < result.length ; i ++){
                    	  var text = result[i].courseName +"(" + result[i].courseId + ")";
                    	  $("#scoreTable").append("<tr><td>"+result[i].courseId+"</td>"+
                    			       					"<td>"+result[i].courseName+"</td>"+
                    			       					"<td>"+result[i].teacherName+"</td>"+
                    			       					"<td>"+result[i].score+"</td></tr>"
                    	  						);
                      }
            	  }
              }  	
         });		
		
		
	});
	
	
	//点击保存密码事件
	$("#save").click(function(){
		
		//得到原密码
		var rawPassword = $("#rawPassword").val();
		
		//得到新密码
		var newPassword = $("#newPassword").val();
		
		//得到新密码确认
		var confirmPassword = $("#confirmPassword").val();
		
		//没有设置判断密码输入为空，若有时间可设置
		
		//封装参数
		var data = {				
				rawPassword:rawPassword,
				newPassword:newPassword,
				confirmPassword:confirmPassword
        }
		
		//AJAx
		$.ajax({
        	  type : "post",
        	  //修改学生密码
        	  url:"../student/modifyStudentPassword",
        	  contentType:"application/json",
              data:JSON.stringify(data),
              success:function(result){
            	  //设置返回结果判断是否已修改密码成功
            		  $('#modifyResult').html(result.modifyResult);
            		  document.getElementById("modifyResult").style.color="red";  	 
              }  	
         });		
		
		
	});
			
  
});