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
                    <p id="userName">stephen</p>
                    <p><span id = "userId">201525010507</span></p>
                    <p>
                        <!-- 返回登录界面，删除cookie -->
                        <a href = "../login/index">退出登录</a>
                    </p>
                </div>
                <div class="meun-title">账号管理</div>
                <div class="meun-item meun-item-active" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="${basePath}resources/images/icon_chara_grey.png">查询成绩</div>
                <div class="meun-item" 					href="#scoreEnter" aria-controls="scoreEnter" role="tab" data-toggle="tab" id = "scoreEnterPane"><img src="${basePath}resources/images/icon_source_grey.png">录入成绩</div>
                <div class="meun-item" 					href="#chan"  aria-controls="chan" role="tab" data-toggle="tab"><img src="${basePath}resources/images/icon_change_grey.png">修改密码</div>
			</div>
			
            <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
                <a class="toggle-btn" id="nimei">
                    <i class="glyphicon glyphicon-align-justify"></i>
                </a>
                <!-- Tab panes -->
                <div class="tab-content">
                   
                    <!-- 成绩查询模块 -->
                    <div role="tabpanel" class="tab-pane" id="char">

                        <div class="check-div">
                            <button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addChar">选择查询条件</button>
                        </div>
                        <div class="data-div">                  
                            
							<!--自己写table -->
							<table class = "table" id = "scoreTable">
							   <caption><div align="center" class="text-success" id = "courseName">成绩单</div></caption>
							   <thead class="row tableHeader">
							     <tr>
								    <th class="col-xs-3">学号</th>
									<th class="col-xs-3">姓名</th>
									<th class="col-xs-3">班级</th>
									<th class="col-xs-3">成绩</th>
								 </tr>
							   </thead>
							   <tbody class="tablebody" id = "scoreTableBody">
							     
							   </tbody>
							</table>
				   </div>

                	<!--选择成绩查询条件的弹出界面-->
                	<div class="modal fade" id="addChar" role="dialog" aria-labelledby="gridSystemModalLabel">
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
                                            	<label for="yearOptions" class="col-xs-3 control-label">学年：</label>
                                            	<div class="col-xs-6 ">
													<select  class="form-control input-sm duiqi yearOrSemester" id="yearOptions" >
														<!-- <option value ="2012-2013">2012-2013</option>
														<option value ="2013-2014">2013-2014</option>
														<option value ="2014-2015">2014-2015</option>
														<option value ="2015-2016">2015-2016</option>
														<option value ="2017-2018">2017-2018</option>	 -->						
													</select>		
                                            	</div>
                                        	</div>
                                        	<div class="form-group">
                                            	<label for="semesterOptions" class="col-xs-3 control-label" >学期：</label>
                                            	<div class="col-xs-6 ">
                                                	<!-- <textarea class="form-control input-sm duiqi"></textarea> -->
													<select class="form-control input-sm duiqi yearOrSemester" id="semesterOptions">
														<option value ="1">1</option>
														<option value ="2">2</option>
																					
													</select>
                                            	</div>
                                        	</div>
                                        	<div class="form-group ">
                                            	<label for="courseOptions" class="col-xs-3 control-label" >课程：</label>
                                            	<div class="col-xs-6 ">
													<select class="form-control input-sm duiqi" id="courseOptions">
																			
													</select>		
												
                                            	</div>
                                        	</div>

                                    	</form>
                                	</div>
                             	</div>
								<!-- 查询条件弹出框的确定与取消按钮-->
                            	<div class="modal-footer">
                                	<button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id = "cancel">取 消</button>
                                	<button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "serch">查询</button>
                            	</div>
                        	</div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

            </div>
            		<!--成绩查询模块结束 -->
            		
            		
            		
            		<!-- 成绩录入模块 -->
                    <div role="tabpanel" class="tab-pane" id="scoreEnter">

                        <div class="check-div">
                            <button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#chooseCondition">选择查询条件</button>
                        </div>
                        <div class="data-div">                  
                            
							<!--自己写table -->
							<table class = "table" id = "scoreEnterTable">
							   <caption><div align="center" class="text-success"><span id = "courseEnterName">成绩单</span></div></caption>
							   <thead class="row tableHeader">
							     <tr>
								    <th class="col-xs-3">学号</th>
									<th class="col-xs-3">姓名</th>
									<th class="col-xs-3">班级</th>
									<th class="col-xs-3">成绩</th>
								 </tr>
							   </thead>
							   <tbody class="tablebody" id = "scoreEnterTableBody">
							     
							   </tbody>
							</table>
				   </div>
					<!-- 底部提交  查询 按钮 -->
					<footer align = "center" class="footer">
                   		<div class="footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id = "commitEnter">提交</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "cancelEnter">取消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "saveEnter">保存</button>
                    	</div>
                    </footer>
                   
                <!--选择录入成绩的课程的查询条件的弹出界面-->
                <div class="modal fade" id="chooseCondition" role="dialog" aria-labelledby="gridSystemModalLabel">
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
                                            <label for="yearOptionsEnter" class="col-xs-3 control-label">学年：</label>
                                            <div class="col-xs-6 ">
													<select  class="form-control input-sm duiqi yearOrSemesterEnter" id="yearOptionsEnter" >
														<!-- <option value ="2012-2013">2012-2013</option>
														<option value ="2013-2014">2013-2014</option>
														<option value ="2014-2015">2014-2015</option>
														<option value ="2015-2016">2015-2016</option>
														<option value ="2017-2018">2017-2018</option>	 -->						
													</select>		
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="semesterOptionsEnter" class="col-xs-3 control-label" >学期：</label>
                                            <div class="col-xs-6 ">
                                                <!-- <textarea class="form-control input-sm duiqi"></textarea> -->
												<select class="form-control input-sm duiqi yearOrSemesterEnter" id="semesterOptionsEnter">
														<option value ="1">1</option>
														<option value ="2">2</option>
																					
													</select>
                                            </div>
                                        </div>
                                        <div class="form-group ">
                                            <label for="courseOptionsEnter" class="col-xs-3 control-label" >课程：</label>
                                            <div class="col-xs-6 ">
													<select class="form-control input-sm duiqi" id="courseOptionsEnter">
																			
													</select>		
												
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
							<!-- 查询条件弹出框的确定与取消按钮-->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-xs btn-white" data-dismiss="modal" id = "cancelEnter">取 消</button>
                                <button type="button" class="btn btn-xs btn-green" data-dismiss="modal" id = "serchEnter">确定</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

            </div>
            		<!--成绩录入模块结束 -->
            		
            		
            		
            		
           
            		<!-- 修改密码模块 -->
            		<div role="tabpanel" class="tab-pane" id="chan"> 
                		<div class="check-div">
                                                                      原始密码为12312313
                		</div>
                		<div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                    		<form class="form-horizontal">
                        		<div class="form-group">
                            		<label for="sKnot" class="col-xs-4 control-label">原密码：</label>
                            		<div class="col-xs-5">
                                		<input type="" class="form-control input-sm duiqi" id="sKnot" placeholder="" style="margin-top: 7px;">
                                    </div>
                                </div>
                                <div class="form-group">
                                	<label for="sKnot" class="col-xs-4 control-label">新密码：</label>
                            		<div class="col-xs-5">
                                		<input type="" class="form-control input-sm duiqi" id="sKnot" placeholder="" style="margin-top: 7px;">
                            		</div>
                        		</div>
                        		<div class="form-group">
                            		<label for="sKnot" class="col-xs-4 control-label">重复密码：</label>
                            		<div class="col-xs-5">
                                		<input type="" class="form-control input-sm duiqi" id="sKnot" placeholder="" style="margin-top: 7px;">
                            		</div>
                        		</div>
                        		<div class="form-group text-right">
                            		<div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                		<button type="reset" class="btn btn-xs btn-white">取 消</button>
                                		<button type="submit" class="btn btn-xs btn-green">保存</button>
                            		</div>
                        		</div>
                    		</form>
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
	<script src="${basePath}resources/js/teacher.js"  type="text/javascript"></script>
</body>
</html>