



layui.use(['table', 'util'], function(){
    var table = layui.table
        ,util = layui.util;

    //监听单元格编辑
    table.on('edit(test3)', function(obj){
        var value = obj.value //得到修改后的值
            ,data = obj.data //得到所在行所有键值
            ,field = obj.field; //得到字段
        $.ajax({
            url: "/newVersion/superTeacher/editCourseDetail",
            type: "post",
            data: {"courseId":data.courseId,"courseDetailId":data.courseDetailId,"courseName":data.courseName,"startSchoolYear":data.startSchoolYear,"endSchoolYear":data.endSchoolYear,"startTerm":data.startTerm,"courseCondition":data.courseCondition,"teacherName":data.teacherName,"teachingLocation":data.teachingLocation},
            success:function (data){
                layer.msg("修改成功");
            },
            error:function (xhr, textStatus, errorThrown){
                layer.msg("修改失败");
            }
        })

        layer.msg('[ID: '+ data.courseId +'] ' + field + ' 字段更改值为：'+ util.escape(value));
    });
    //监听行工具事件
    table.on('tool(test3)', function(obj){
        var data = obj.data;
        //console.log(obj)
        if(obj.event === 'del'){
            layer.confirm('真的删除吗？', function(index){
                $.ajax({
                    url: "/newVersion/superTeacher/deleteCourseDetail",
                    type: "post",
                    data: {"courseDetailId":data.courseDetailId},
                    success:function (data){
                        layer.msg("删除成功");
                        obj.del();
                        layer.close(index);
                    },
                    error:function (xhr, textStatus, errorThrown){
                        layer.msg("删除失败");
                    }
                })
            });
        }
    });
});