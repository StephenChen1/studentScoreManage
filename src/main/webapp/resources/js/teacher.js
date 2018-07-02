
$(document).ready(function(){
	
	//查询条件弹出框的年份和学期下拉框选择内容改变
	$(".yearOrSemester").bind("change",function(){
        var dataname = $(this).val();
        alert("dataname:" + dataname);
        alert("name:" + $(this).attr("name"));
        console.log("dataname:" + dataname);
        //var url = "basic/update/updateData?id="+$(this).attr("name");
       /* $.post(url,{"dataname":dataname},function(rd){
            if(rd.flag){
                layer.msg("修改成功");
                window.location.reload();
            }else{
                layer.alert(rd.msg);
            }
        })*/
    });
			
  
});