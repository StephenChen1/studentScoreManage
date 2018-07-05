<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@include file="common/head.jsp"%>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="description" content="左右结构项目，成绩管理">
   <meta name="keywords" content="左右结构项目 成绩 管理 ">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
   <meta name="format-detection" content="telephone=no">
   <title>成绩管理系统</title>
   <script src="${basePath}resources/js/jquery.min.js"></script>
   <script src="${basePath}resources/js/bootstrap.min.js"></script>
    <script>
            $(function() {
                $(".meun-item").click(function() {
                    $(".meun-item").removeClass("meun-item-active");
                    $(this).addClass("meun-item-active");
                    var itmeObj = $(".meun-item").find("img");
                    itmeObj.each(function() {
                        var items = $(this).attr("src");
                        items = items.replace("_grey.png", ".png");
                        items = items.replace(".png", "_grey.png")
                        $(this).attr("src", items);
                    });
                    var attrObj = $(this).find("img").attr("src");
                    ;
                    attrObj = attrObj.replace("_grey.png", ".png");
                    $(this).find("img").attr("src", attrObj);
                });
                $("#topAD").click(function() {
                    $("#topA").toggleClass(" glyphicon-triangle-right");
                    $("#topA").toggleClass(" glyphicon-triangle-bottom");
                });
                $("#topBD").click(function() {
                    $("#topB").toggleClass(" glyphicon-triangle-right");
                    $("#topB").toggleClass(" glyphicon-triangle-bottom");
                });
                $("#topCD").click(function() {
                    $("#topC").toggleClass(" glyphicon-triangle-right");
                    $("#topC").toggleClass(" glyphicon-triangle-bottom");
                });
                $(".toggle-btn").click(function() {
                    $("#leftMeun").toggleClass("show");
                    $("#rightContent").toggleClass("pd0px");
                })
            })
       </script>
        <!--[if lt IE 9]>
        <script src="js/html5shiv.min.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        <link href="${basePath}resources/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${basePath}resources/css/common.css" />
        <link rel="stylesheet" type="text/css" href="${basePath}resources/css/slide.css" />
        <link rel="stylesheet" type="text/css" href="${basePath}resources/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${basePath}resources/css/flat-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="${basePath}resources/css/jquery.nouislider.css">
        
</head>
<body>
	
	
	<div id="wrap">
            <!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><img id="logo" alt="成绩管理系统" src="${basePath}resources/images/logo.png"><span>成绩管理系统</span></p>
                </div>
                <div id="personInfor">
                    <!-- 左上侧的登录人员信息 -->
                    <p id="userName"></p>
                    <p><span id = "userId"></span></p>
                    <p>
                        <!-- <a href = "/login/index">退出登录</a> -->
                        <!-- 退出登录按钮 -->
						<button type="button" class="btn btn-default btn-sm" id = "exitLogin">退出登录</button>
                    </p>
                </div>
                <div class="meun-title">教务员功能</div>
                <div class="meun-item meun-item-active" href="#arrangeCourse" aria-controls="arrangeCourse" role="tab" data-toggle="tab"><img src="${basePath}resources/images/icon_chara_grey.png">安排课程</div>
                <div class="meun-item" 					href="#showTeacher" aria-controls="showTeacher" role="tab" data-toggle="tab" id = "scoreEnterPane"><img src="${basePath}resources/images/icon_source_grey.png">查看教师</div>
                <div class="meun-item" 					href="#addTeacher"  aria-controls="addTeacher" role="tab" data-toggle="tab"><img src="${basePath}resources/images/icon_change_grey.png">添加教师</div>
                <div class="meun-item" 					href="#addStudent"  aria-controls="addStudent" role="tab" data-toggle="tab"><img src="${basePath}resources/images/icon_change_grey.png">添加学生</div>
			    <div class="meun-item" 					href="#modifyPassword"  aria-controls="modifyPassword" role="tab" data-toggle="tab"><img src="${basePath}resources/images/icon_change_grey.png">修改密码</div>
			</div>
			
            <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
                <a class="toggle-btn" id="nimei">
                    <i class="glyphicon glyphicon-align-justify"></i>
                </a>
                <!-- Tab panes -->
                <div class="tab-content">
                   
                    <!-- 安排课程模块 -->
                    <div role="tabpanel" class="tab-pane" id="arrangeCourse">

                        <div class="check-div">
                            <button class="btn btn-yellow btn-xs" id ="arrangeBtn" data-toggle="modal" data-target="#inputTeachMessage">安排课程</button>
                        </div>
                        <div class="data-div">                  
                            
							<!--自己写table -->
							<table class = "table" id = "teachTable">
							   <caption><div align="center" class="text-success" id = "teachTableTip">课程安排表</div></caption>
							   <thead class="row tableHeader">
							     <tr>
								    <th class="col-xs-3">教师ID</th>
									<th class="col-xs-3">课程ID</th>
									<th class="col-xs-3">学年</th>
									<th class="col-xs-3">学期</th>
								 </tr>
							   </thead>
							   <tbody class="tablebody" id = "teachTableBody">
							     
							   </tbody>
							</table>
				   </div>

                	<!--安排课程的弹出界面-->
                	<div class="modal fade" id="inputTeachMessage" role="dialog" aria-labelledby="gridSystemModalLabel">
                    	<div class="modal-dialog" role="document">
                        	<div class="modal-content">
                            	<div class="modal-header">
                                	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                	<h4 class="modal-title" id="gridSystemModalLabel">安排课程</h4>
                            	</div>
                            	<div class="modal-body">
                                	<div class="container-fluid">
                                    	<form class="form-horizontal">
                                        	<div class="form-group ">
                                            	<label for="teacherIdOptions" class="col-xs-3 control-label">教师ID：</label>
                                            	<div class="col-xs-6 ">
													<select  class="form-control input-sm duiqi" id="teacherIdOptions" >
																	
													</select>		
                                            	</div>
                                        	</div>
                                        	
                                        	<div class="form-group">
                                            	<label for="courseIDOptions" class="col-xs-3 control-label" >课程ID：</label>
                                            	<div class="col-xs-6 ">
                                                	
													<select class="form-control input-sm duiqi " id="courseIDOptions">
																					
													</select>
                                            	</div>
                                        	</div>
                                        	
                                        	<div class="form-group">
                                            	<label for="yearInput" class="col-xs-3 control-label" >学年：</label>
                                            	<div class="col-xs-6 ">
													<input type="text"class="form-control input-sm duiqi" id="yearInput">
							
                                            	</div>
                                        	</div>
                                        	
                                        	<div class="form-group">
                                            	<label for="semesterOptions" class="col-xs-3 control-label" >学期：</label>
                                            	<div class="col-xs-6 ">
                                                	<!-- <textarea class="form-control input-sm duiqi"></textarea> -->
													<select class="form-control input-sm duiqi " id="semesterOptions">
														<option value ="1">1</option>
														<option value ="2">2</option>
																					
													</select>
                                            	</div>
                                        	</div>
                                        	

                                    	</form>
                                	</div>
                             	</div>
								<!-- 查询条件弹出框的确定与取消按钮-->
                            	<div class="modal-footer">
                                	<button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id = "cancelArrange">取 消</button>
                                	<button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "arrange">安排</button>
                            	</div>
                        	</div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

            </div>
            		<!--安排课程模块结束 -->
            		
            		
            		
            		<!-- 查看课程教师模块 -->
                    <div role="tabpanel" class="tab-pane" id="showTeacher">

                        <div class="check-div">
                            <button class="btn btn-yellow btn-xs" id="showTeacherBtn" data-toggle="modal" data-target="#chooseTeacherCondition">查看教师</button>
                        </div>
                        <div class="data-div">                  
                            
							<!--自己写table -->
							<table class = "table" id = "teacherTable">
							   <caption><div align="center" class="text-success"><span id = "courseTeachers">教师列表</span></div></caption>
							   <thead class="row tableHeader">
							     <tr>
								    <th class="col-xs-4">教师ID</th>
									<th class="col-xs-4">姓名</th>
									<th class="col-xs-4">电话</th>
									
								 </tr>
							   </thead>
							   <tbody class="tablebody" id = "teacherTableBody">
							     
							   </tbody>
							</table>
				   </div>
					
                   
                <!--选择录入成绩的课程的查询条件的弹出界面-->
                <div class="modal fade" id="chooseTeacherCondition" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel">查询条件</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label for="courseIDSelect" class="col-xs-3 control-label">课程ID:</label>
                                            <div class="col-xs-6 ">
													<select  class="form-control input-sm duiqi " id="courseIDSelect" >
																		
													</select>		
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="yearSelect" class="col-xs-3 control-label" >学年：</label>
                                            <div class="col-xs-6 ">
												<select class="form-control input-sm duiqi " id="yearSelect">
																							
												</select>
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="semesterSelect" class="col-xs-3 control-label" >学期：</label>
                                            <div class="col-xs-6 ">
													<select class="form-control input-sm duiqi" id="semesterSelect">
															<option value ="1">1</option>
															<option value ="2">2</option>				
													</select>		
												
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
							<!-- 查询条件弹出框的确定与取消按钮-->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id = "cancelSerchTeacher">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "serchTeacher">确定</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

            </div>
            		<!--成绩录入模块结束 -->
            		
            		
            		
                    <!-- 添加教师模块 -->
                    <div role="tabpanel" class="tab-pane" id="addTeacher">

                        <div class="check-div">
                            <button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addTeacherMessage">添加教师</button>
                        </div>
                        <div class="data-div">                  
                            
							<!--显示教师列表 -->
							<table class = "table" id = "teacherTable">
							   <caption><div align="center" class="text-success"><span id = "teacherTableTip">教师列表</span></div></caption>
							   <thead class="row tableHeader">
							     <tr>
								    <th class="col-xs-4">教师ID</th>
									<th class="col-xs-4">姓名</th>
									<th class="col-xs-4">电话</th>
									
								 </tr>
							   </thead>
							   <tbody class="tablebody" id = "teacherTableBody">
							     
							   </tbody>
							</table>
				   </div>
					
                   
                <!--添加教师的弹出界面-->
                <div class="modal fade" id="addTeacherMessage" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel">添加教师</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label for="teacherIDInput" class="col-xs-3 control-label">教师ID：</label>
                                            <div class="col-xs-6 ">
													<input  type = "text" class="form-control input-sm duiqi " id="teacherIDInput" >
																			
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="teacherNameInput" class="col-xs-3 control-label" >姓名：</label>
                                            <div class="col-xs-6 ">
                                                
												<input type = "text" class="form-control input-sm duiqi " id="teacherNameInput">

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="teacherPhoneInput" class="col-xs-3 control-label" >手机：</label>
                                            <div class="col-xs-6 ">
                                                
												<input type = "text" class="form-control input-sm duiqi " id="teacherPhoneInput">

                                            </div>
                                        </div>
                                        

                                    </form>
                                </div>
                            </div>
							<!-- 添加教师弹出框的添加与取消按钮-->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id = "cancelAddTeacherBtn">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "addTeacherBtn">添加</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

            </div>
            		<!--添加教师模块结束 -->
            		
            		<!-- 添加学生模块 -->
                    <div role="tabpanel" class="tab-pane" id="addStudent">

                        <div class="check-div">
                            <button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addStudentMessage">添加学生</button>
                        </div>
                        <div class="data-div">                  
                            
							<!--显示学生列表 -->
							<table class = "table" id = "studentTable">
							   <caption><div align="center" class="text-success"><span id = "studentTableTip">学生列表</span></div></caption>
							   <thead class="row tableHeader">
							     <tr>
								    <th class="col-xs-3">学生ID</th>
									<th class="col-xs-3">姓名</th>
									<th class="col-xs-3">班级</th>
									<th class="col-xs-3">电话</th>
									
								 </tr>
							   </thead>
							   <tbody class="tablebody" id = "studentTableBody">
							     
							   </tbody>
							</table>
				   </div>
					
                   
                <!--添加学生的弹出界面-->
                <div class="modal fade" id="addStudentMessage" role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="gridSystemModalLabel">添加学生</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <div class="form-group ">
                                            <label for="studentIDInput" class="col-xs-3 control-label">学生ID：</label>
                                            <div class="col-xs-6 ">
													<input  type = "text" class="form-control input-sm duiqi " id="studentIDInput" >
																			
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="studentNameInput" class="col-xs-3 control-label" >姓名：</label>
                                            <div class="col-xs-6 ">
                                                
												<input type = "text" class="form-control input-sm duiqi " id="studentNameInput">

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="studentClassInput" class="col-xs-3 control-label" >班级：</label>
                                            <div class="col-xs-6 ">
                                                
												<input type = "text" class="form-control input-sm duiqi " id="studentClassInput">

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="studentPhoneInput" class="col-xs-3 control-label" >手机：</label>
                                            <div class="col-xs-6 ">
                                                
												<input type = "text" class="form-control input-sm duiqi " id="studentPhoneInput">

                                            </div>
                                        </div>
                                        

                                    </form>
                                </div>
                            </div>
							<!-- 查询条件弹出框的确定与取消按钮-->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id = "cancelAddOneStudent">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "addOneStudent">确定</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

            </div>
            		<!--添加学生模块结束 -->	
            		
            		
            		
           
            		<!-- 修改密码模块 -->
            		<div role="tabpanel" class="tab-pane" id="modifyPassword"> 
                		<div class="check-div">
                                 <!-- 原始密码为12312313 -->
                                 <!-- 用于显示用户修改密码操作结果 -->
                   				 <div align="center"><span id="isTwoPassSame"></span></div>
                		</div>
                		<div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                    		<div class="form-horizontal">
                        		<div class="form-group">
                            		<label for="userId" class="col-xs-4 control-label">ID：</label>
                            		<div class="col-xs-5">
                                		<input type="text" class="form-control input-sm duiqi" id="userIdModify" placeholder="" style="margin-top: 7px;">
                                    </div>
                                </div>
                                <div class="form-group">
                                	<label for="sKnot" class="col-xs-4 control-label">新密码：</label>
                            		<div class="col-xs-5">
                                		<input type="text" class="form-control input-sm duiqi" id="newPassword" placeholder="" style="margin-top: 7px;">
                            		</div>
                        		</div>
                        		<div class="form-group">
                            		<label for="sKnot" class="col-xs-4 control-label" >确认密码：</label>
                            		<div class="col-xs-5">
                                		<input type="text" class="form-control input-sm duiqi" id="defineNewPassword" placeholder="" style="margin-top: 7px;">
                            		</div>
                        		</div>
                        		<div class="form-group text-right">
                            		<div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                		<button type="reset" class="btn btn-xs btn-white">取 消</button>
                                		<button type="submit" class="btn btn-xs btn-green" id = "modifyBtn">修改</button>
                            		</div>
                        		</div>
                    		</div>
                		</div>
            		</div>
		     		<!--修改密码模块结束(上面的div) -->
          </div> 
            
        </div>
    </div>
<!-- 滑块js -->
<!--	<script type="text/javascript">
        scale = function(btn, bar, title, unit) {
                this.btn = document.getElementById(btn);
                this.bar = document.getElementById(bar);
                this.title = document.getElementById(title);
                this.step = this.bar.getElementsByTagName("div")[0];
                this.unit = unit;
                this.init();
        };
        scale.prototype = {
                init: function() {
                        var f = this,
                                g = document,
                                b = window,
                                m = Math;
                        f.btn.onmousedown = function(e) {
                                var x = (e || b.event).clientX;
                                var l = this.offsetLeft;
//						var max = f.bar.offsetWidth - this.offsetWidth;
                                var max = f.bar.offsetWidth-20 ;
                                g.onmousemove = function(e) {
                                        var thisX = (e || b.event).clientX;
                                        var to = m.min(max, m.max(-2, l + (thisX - x)));
                                        f.btn.style.left = to+ 'px';
                                        f.ondrag(m.round(m.max(0, to / max) * 100), to);
                                        b.getSelection ? b.getSelection().removeAllRanges() : g.selection.empty();
                                };
                                g.onmouseup = new Function('this.onmousemove=null');
                        };
                },
                ondrag: function(pos, x) {
                        this.step.style.width = Math.max(0, x) +2+ 'px';
                        this.title.innerHTML = pos / 10 + this.unit + "";
                }
        }
        new scale('btn0', 'bar0', 'title0', "分钟");
        new scale('btn1', 'bar1', 'title1', "分钟");
        new scale('btn2', 'bar2', 'title2', "天");
        new scale('btn3', 'bar3', 'title3', "次");
</script>
-->
<script src="${basePath}resources/js/jquery.nouislider.js"></script>

<!-- this page specific inline scripts -->
<script>
                                                //min/max slider
          function huadong(my, unit, def, max) {
                   $(my).noUiSlider({
                         range: [0, max],
                         start: [def],
                         handles: 1,
                         connect: 'upper',
                         slide: function() {
                         var val = Math.floor($(this).val());
                         $(this).find(".noUi-handle").text(
                               val + unit
                                );
                          console.log($(this).find(".noUi-handle").parent().parent().html());
                          },
                         set: function() {
                         var val = Math.floor($(this).val());
                         $(this).find(".noUi-handle").text(
                         val + unit
                         );
                         }
                         });
                         $(my).val(def, true);
                         }
                                                huadong('.slider-minmax1', "分钟", "5", 30);
                                                huadong('.slider-minmax2', "分钟", "6", 15);
                                                huadong('.slider-minmax3', "分钟", "10", 60);
                                                huadong('.slider-minmax4', "次", "2", 10);
                                                huadong('.slider-minmax5', "天", "3", 7);
                                                huadong('.slider-minmax6', "天", "8", 10);
</script>
	
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="${basePath}resources/js/manager.js"  type="text/javascript"></script>
	<script src="${basePath}resources/js/exitLogin.js"  type="text/javascript"></script>
</body>
</html>