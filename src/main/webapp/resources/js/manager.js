(function ($) {
        //函数定义，得到所有教师ID，展示在教师ID下拉框
        $.showAllTeacher = function () {
        	  //参数 ：无
              //返回教师ID数组
              $.ajax({
              	  type : "post",
              	  url:"../teacher/getAllTeacherIDs",
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
        
        
        
    })(jQuery);


$(document).ready(function(){
	
	//通过教师id查到教师信息,显示在界面左上角，教师Id由后台调用cookie得到
	/*$.ajax({
    	  type : "post",
    	  url:"../manajor/getNowManager",
    	  contentType:"application/json",
          
          success:function(result){
        	  //alert(result.name);
        	 //界面左上角显示教师信息
        	  $("#userName").text(result.managerName);
        	  $("#userId").text(result.managerId);  
        }
	});*/
	
	
});
