(function ($) {
        //函数定义，得到所有教师ID，展示在教师ID下拉框
        $.showAllTeacher = function () {
        	  //参数 ：无
              //返回教师ID数组
              $.ajax({
              	  type : "post",
              	  url:"../teacher/all",
              	  contentType:"application/json",   
                  success:function(result){
                	  $("#teacherIdOptions").find("option").remove();   
           	         //把安排课程页面  教师ID下拉框填上
             	      for(var i = 0 ; i < result.length ; i ++){            
             	    	  var text = result[i];
             	    	  $("#teacherIdOptions").append("<option value='"+text+"'>"+text+"</option>"); 
             	      }
                  } 	       
              });
        }
        
        
        //函数定义，得到所有课程ID和课程名，展示在名称为theSelect的select下拉框     课程名（ID）
        $.showAllCourseInSelect = function (theSelect) {
        	  //参数 ：无
              //返回课程ID和课程名的对象数组
              $.ajax({
              	  type : "post",
              	  url:"../course/all",
              	  contentType:"application/json",
                  success:function(result){
                	  $("#courseIDOptions").find("option").remove();   
           	         //把安排课程页面  教师ID下拉框填上
             	      for(var i = 0 ; i < result.length ; i ++){   
             	    	  //教师ID,存于value，方便后面获取
             	    	  var courseId = result[i].courseId;
             	    	  // 教师名（ID）
             	    	  var text = result[i].courseName +"("+courseId+")";
             	    	  theSelect.append("<option value='"+courseId+"'>"+text+"</option>"); 
             	      }
                  } 	       
              });
        }
        
        //函数定义，得到所有学年，展示在查看教师界面的学年下拉框(后台已实现）
        $.showAllYearInSelect = function () {
        	  //参数 ：无
              //返回学年数组
        	$.ajax({
        	      type : "post",
        	      url:"../teacher/getYear",
        	  	  contentType:"application/json",
              
        	  	  success:function(result){
        	  		  //alert("result.length: "+result.length);
        	  		  //先删除下拉框内容
        	  		  $("#yearSelect").find("option").remove();   
        	  		  //把查询学生成绩页面  年份下拉框填上
        	  		  for(var i = 0 ; i < result.length ; i ++){
        	  			  var text = result[i];
              	   $	  ("#yearSelect").append("<option value='"+text+"'>"+text+"</option>"); 
        	  		  }
            	  }
        	});
        }
        
        
        
    })(jQuery);


$(document).ready(function(){
	//TODO 测试
	//通过教务员id查到教务员信息,显示在界面左上角，教务员Id由后台调用cookie得到
	$.ajax({
    	  type : "post",
    	  url:"../manager/getCurrentManager",
    	  contentType:"application/json",
          
          success:function(result){
        	  //alert(result.name);
        	 //界面左上角显示教师信息
        	  $("#userName").text(result.managerName);
        	  $("#userId").text(result.managerId);  
        }
	});
	

	
	//安排课程界面事件开始
	
	//左上角安排课程按钮点击事件
	$("#arrangeBtn").click(function(){
		//刷新弹出框的内容
		//刷新教师ID下拉框
		$.showAllTeacherInSelect();
		
		//得到课程ID下拉框
		var theSelect = $("#courseIDOptions");
		//刷新课程ID下拉框
		$.showAllCourseInSelect(theSelect);
		
	});
	
	
	
	//弹出框的确认按钮点击事件
	$("#arrange").click(function(){
		//得到教师ID
		var teacherId = $("#teacherIdOptions option:selected").val();
		//得到课程ID
		var courseId = $("#courseIDOptions option:selected").val();
		//得到input输入的学年
		var year = $("yearInput").val();
		//得到学期
		var semester = $("#semesterOptions option:selected").val();
		//JSON封装数据
		var data = {
				teacherId:teacherId,
				courseId:courseId,
				year:year,
				semester:semester
		}
		//TODO 测试
		//AJAX交互，添加一条教学安排信息,返回布尔值
		$.ajax({
	    	  type : "post",
	    	  url:"../manager/arrange",
	    	  contentType:"application/json",
	    	  data:JSON.stringify(data),
	          success:function(result){
	        	  //此时的result应该是String值，用parseJSON把其转换为boolean值
	              result = $.parseJSON(result);
	              //如果添加成功，提示
	              if(result){
	            	  alert("添加成功！");
	            	  //显示新增数据在表格上
	            	  $("#teachTable").append("<tr><td>"+teacherId+"</td>"+
		       					"<td>"+courseId+"</td>"+
		       					"<td>"+year+"</td>"+
		       					"<td>"+semester+"</td></tr>"
						);
	              }else{
	            	  alert("添加失败！！");
	              }
	        }
		});
	});
	
	
	
	
	//安排课程界面事件结束
	
	//查看教师界面事件开始
	
	//左上角查看教师按钮点击事件
	$("#showTeacherBtn").click(function(){
		//刷新弹出框的内容
		
		//得到课程ID下拉框
		var theSelect = $("#courseIDSelect");
		//刷新课程ID下拉框
		$.showAllCourseInSelect(theSelect);
		
		//刷新学年下拉框
		$.showAllYearInSelect();
		
	});
	
	
	//弹出框查看按钮点击事件
	$("#serchTeacher").click(function(){
		//得到课程ID
		var courseId = $("#courseIDSelect option:selected").val();
		//得到学年
		var	year =  $("#yearSelect option:selected").val();
		//得到学期
		var semester = $("#semesterSelect option:selected").val();
		//封装数据
		var data = {
			    courseId:courseId,
			    year:year,
			    semester:semester
		}
		//TODO 测试
		//AJAX与后台交互，得到该课程的任课教师信息对象列表，并把循环展示在表格
		$.ajax({
      	  	type : "post",
      	  	url:"../manager/getTeachers",
      	  	contentType:"application/json",
            data:JSON.stringify(data),
            success:function(result){
            	//alert(result.length);
            	//先删除表格中的内容
            	$("#teacherTableBody").find("tr").remove();   
            	//遍历展示数据
            	for(var i = 0 ; i < result.length ; i ++){
              	  
              	  	$("#scoreTable").append("<tr><td>"+result[i].teacherId+"</td>"+
              			       					"<td>"+result[i].name+"</td>"+
              			       					"<td>"+result[i].phone+"</td></tr>"
              	  	);
            	}
            }  	
         });
	 });
	
	//查看教师界面事件结束
	
	//添加教师界面事件开始
	
	//弹出框确定按钮点击事件
	$("#addTeacherBtn").click(function(){
		
		//得到教师ID
		var teacherId = $("#teacherIDInput").val();
		//得到教师姓名
		var teacherName = $("#teacherNameInput").val();
		//得到教师手机号
		var teacherPhone = $("#teacherPhoneInput").val();
		//JSON封装参数
		var data = {
				teacherId : teacherId,
				teacherName: teacherName ,
				teacherPhone:teacherPhone
		}
		//TODO 测试
		//AJAX与后台交互，添加一名教师信息，返回布尔值
		$.ajax({
	    	  type : "post",
	    	  url:"../manager/addTeacher",
	    	  contentType:"application/json",
	    	  data:JSON.stringify(data),
	          success:function(result){
	        	  //此时的result应该是String值，用parseJSON把其转换为boolean值
	              result = $.parseJSON(result);
	              //如果添加成功，提示
	              if(result){
	            	  alert("添加成功！");
	            	  //显示新增数据在表格上
	            	  $("#teacherTableBody").append("<tr><td>"+teacherId+"</td>"+
		       					"<td>"+teacherName+"</td>"+
		       					"<td>"+teacherPhone+"</td></tr>"
						);
	              }else{
	            	  alert("添加失败！！");
	              }
	        }
		});
		
	});
	//添加教师界面事件结束
	
	//添加学生界面事件开始
	
	//弹出框确定按钮点击事件
	$("#addOneStudent").click(function(){
		
		//得到学生ID
		var studentId = $("#studentIDInput").val();
		//得到学生姓名
		var name = $("#studentNameInput").val();
		//得到班级
		var classes = $("#studentClassInput").val();
		//得到手机号
		var phone = $("#studentPhoneInput").val();
		//封装数据
		var data = {
			  studentId: studentId,
			  name: name,
			  classes:classes ,
			  phone:phone
		}
		//TODO 改后台
		//AJAX后台交互，添加一名学生，返回布尔值
		$.ajax({
	    	  type : "post",
	    	  url:"../manager/addStudent",
	    	  contentType:"application/json",
	    	  data:JSON.stringify(data),
	          success:function(result){
	        	  //此时的result应该是String值，用parseJSON把其转换为boolean值
	              result = $.parseJSON(result);
	              //如果添加成功，提示
	              if(result){
	            	  alert("添加成功！");
	            	  //显示新增数据在表格上
	            	  $("#studentTableBody").append("<tr><td>"+studentId+"</td>"+
		       					"<td>"+name+"</td>"+
		       					"<td>"+classes+"</td>"+
		       					"<td>"+phone+"</td></tr>"
						);
	              }else{
	            	  alert("添加失败！！");
	              }
	        }
		});
	});
	//添加学生界面事件结束
	
	//修改密码模块开始
	
	//修改按钮点击事件
	$("#modifyBtn").click(function(){
		//得到ID
		var id = $("#userId").val();
		//得到新密码
		var newpassword = $("#newPassword").val();
		//得到确认密码
		var defineNewPassword = $("#defineNewPassword").val();
		//判断两个密码是否相同,则与后台交互
		if(newpassword == defineNewPassword){
			//封装数据
			var data = {
					id: id ,
					password:newpassword
			}
			//TODO 改后台
			//AJAX后台交互,修改该ID的用户的密码
			$.ajax({
		    	  type : "post",
		    	  url:"../manager/modifyPassword",
		    	  contentType:"application/json",
		    	  data:JSON.stringify(data),
		          success:function(result){
		        	  //此时的result应该是String值，用parseJSON把其转换为boolean值
		              result = $.parseJSON(result);
		              //如果添加成功，提示
		              if(result){
		            	  alert("修改密码成功！");
		            	  
		              }else{
		            	  alert("修改密码失败！！");
		              }
		        }
			});
			
		}else{
			//若不相等，则给出提示
			alert("两个密码不一致！！")
		}
		
		
	});
	//修改密码模块结束
});
