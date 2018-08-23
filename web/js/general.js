/*显示分类的帖子*/
function homeShow(classId) {
    $.ajax({
        type: "POST",
        url: "/showShare?classId=" + classId,
        dataType: "json",
        success: function (data) {
            var string = "";
            for (var i = 0; i < data.length; i++) {
                if (data[i].enable == 1) {
                    data[i].enable = "未完";
                } else {
                    data[i].enable = "已结";
                }
                if (data[i].replyCount == null) {
                    data[i].replyCount = 0;
                }
                string = string +
                    "<li><a href=\"user/home.html\" class=\"fly-avatar\"><img src=\"" + data[i].imgUrl + "\"></a>\n" +
                    "<h2><a class=\"layui-badge\">" + data[i].className + "</a><a href=\"detail.html?topic=" + data[i].id + "\">" + data[i].title + "</a></h2>\n" +
                    "<div class=\"fly-list-info\">\n" +
                    "<a href=\"user/home.html\" link><cite>" + data[i].userName + "</cite></a>\n" +
                    "<span>" + new Date(parseInt(data[i].createOn)).toLocaleString().replace(/:\d{1,2}$/, ' ') + "</span>\n" +
                    "<span class=\"fly-list-kiss layui-hide-xs\" title=\"fly点\"><i class=\"iconfont icon-kiss\"></i>" + data[i].rank + "</span>\n" +
                    "<span class=\"fly-list-nums\"><i class=\"iconfont icon-pinglun1\" title=\"回答\"></i>" + data[i].replyCount + "</span>\n" +
                    "</div></li>";
            }
            $("#ulShow").html(string);

            var count = Math.ceil(data.length / 2);
            if (count >= 2) {
                var page = "";
                for (var j = 1; j <= count; j++) {
                    page = page + "<a id=\"" + j + "\" href=\"javascript:void(0)\">" + j + "</a>";
                }
                $("#page").html(page);
            } else {
                $("#page").html("");
            }
        }
    });
}

/*退出*/
function logOut() {
    layer.confirm("确定退出吗？", {btn: ["在留一会", "拂袖而去"]}, function () {
        layer.msg("德丽莎世界第一可爱", {icon: 1});
    }, function () {
        layer.msg("您已退出", {icon: 1})
        $.post("/logout");
        window.location.href = "/html/index.html";
    })
}

/*已结帖未结帖*/
function showByEnable(enable) {
    $.ajax({
        type: "POST",
        url: "/showByEnable?enable=" + enable,
        dataType: "json",
        success: function (data) {
            var string = "";
            for (var i = 0; i < data.length; i++) {

                var insertClass = "fly-badge-accept";

                if (data[i].enable == 1) {
                    data[i].enable = "已结";
                } else {
                    data[i].enable = "未完";
                    insertClass = "";
                }

                string = string +
                    "<li><a href=\"user/home.html\" class=\"fly-avatar\"><img src=\"" + data[i].imgUrl + "\"></a>\n" +
                    "<h2><a class=\"layui-badge\">" + data[i].className + "</a><a href=\"jie/detail.html?topic=" + data[i].id + "\">" + data[i].title + "</a></h2>\n" +
                    "<div class=\"fly-list-info\">\n" +
                    "<a href=\"user/home.html\" link><cite id=\"cite" + i + "\">" + data[i].userName + "</cite></a>\n" +
                    "<span>发表于：" + new Date(parseInt(data[i].createOn)).toLocaleString().replace(/:\d{1,2}$/, ' ') + "</span>\n" +
                    "<span class=\"fly-list-kiss layui-hide-xs\" title=\"悬赏Fly点\">悬赏fly点<i class=\"iconfont icon-kiss\"></i>" + data[i].rank + "</span>\n" +
                    "状态：<span class=\"layui-badge " + insertClass + " layui-hide-xs\">" + data[i].enable + "</span>\n" +
                    "<span class=\"fly-list-nums\"><i class=\"iconfont icon-pinglun1\" title=\"回答\"></i> " + data[i].replyCount + "</span>\n" +
                    "</div>\n" +
                    "<div class=\"fly-list-badge\"></div></li>";
                /*<span class="layui-badge layui-bg-red">精帖</span>*/
                /*<i class="iconfont icon-renzheng" title="认证信息：XXX"></i><i class="layui-badge fly-badge-vip">VIP3</i>*/
            }
            $("#ulShow").html(string);
        }
    })
}

/*显示所有*/
function showAllByEc(ec) {
    $.ajax({
        type: "POST",
        url: "/showAll?ec=" + ec,
        dataType: "json",
        success: function (data) {
            var string = "";
            for (var i = 0; i < data.length; i++) {

                var insertClass = "fly-badge-accept";

                if (data[i].enable == 1) {
                    data[i].enable = "已结";
                } else {
                    data[i].enable = "未完";
                    insertClass = "";
                }

                string = string +
                    "<li><a href=\"user/home.html\" class=\"fly-avatar\"><img src=\"" + data[i].imgUrl + "\"></a>\n" +
                    "<h2><a class=\"layui-badge\">" + data[i].className + "</a><a href=\"jie/detail.html?topic=" + data[i].id + "\">" + data[i].title + "</a></h2>\n" +
                    "<div class=\"fly-list-info\">\n" +
                    "<a href=\"user/home.html\" link><cite id=\"cite" + i + "\">" + data[i].userName + "</cite></a>\n" +
                    "<span>发表于：" + new Date(parseInt(data[i].createOn)).toLocaleString().replace(/:\d{1,2}$/, ' ') + "</span>\n" +
                    "<span class=\"fly-list-kiss layui-hide-xs\" title=\"悬赏Fly点\">悬赏fly点<i class=\"iconfont icon-kiss\"></i>" + data[i].rank + "</span>\n" +
                    "状态：<span class=\"layui-badge " + insertClass + " layui-hide-xs\">" + data[i].enable + "</span>\n" +
                    "<span class=\"fly-list-nums\"><i class=\"iconfont icon-pinglun1\" title=\"回答\"></i> " + data[i].replyCount + "</span>\n" +
                    "</div>\n" +
                    "<div class=\"fly-list-badge\"></div></li>";
                /*<span class="layui-badge layui-bg-red">精帖</span>*/
                /*<i class="iconfont icon-renzheng" title="认证信息：XXX"></i><i class="layui-badge fly-badge-vip">VIP3</i>*/
            }
            $("#ulShow").html(string);
        }
    })
}

/*获取地址栏参数*/
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return unescape(r[2]);
    return null;
}

/*点击评论*/
function subComment() {

    var topicId = getUrlParam("topic");
    $.ajax({
        type: "POST",
        url: "/comment?topicId=" + topicId,
        data: $("#replyForm").serialize(),
        dataType: "json",
        success: function (data) {
            if (data.status == "ok") {
                $("#L_content").val("");
                layer.msg("评论成功", {icon: 6});
                showComment();
            } else {
                layer.msg("评论失败", {icon: 5});
            }
        }
    })

}

/*显示评论*/
function showComment() {
    var topicId = getUrlParam("topic");
    alert(topicId);
    $.ajax({
        type:"POST",
        url:"/showComment?topicId="+topicId,
        dataType:"json",
        success:function (data) {
            var st = '';
            if(data == null){
                $("#jieda").html("<li class=\"fly-none\">消灭零回复</li>");
            }else {
                for(var i=0;i<data.length;i++){
                    st = st + '<li data-id="111">\n' +
                        '                        <div class="detail-about detail-about-reply">\n' +
                        '                            <a class="fly-avatar" href="user/home.html">\n' +
                        '                                <img src="'+data[i].userImg+'">\n' +
                        '                            </a>\n' +
                        '                            <div class="fly-detail-user">\n' +
                        '                                <a href="" class="fly-link">\n' +
                        '                                    <cite>'+data[i].userName+'</cite>\n' +
                        '                                </a>\n' +
                        '                            </div>\n' +
                        '                            <div class="detail-hits">\n' +
                        '                                <span>'+new Date(parseInt(data[i].createOn)).toLocaleString().replace(/:\d{1,2}$/, ' ')+'</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="detail-body jieda-body photos">\n' +
                        '                            <p>'+data[i].comment+'</p>\n' +
                        '                        </div>\n' +
                        '                        <div class="jieda-reply">\n' +
                        '                            <span class="jieda-zan" type="zan">\n' +
                        '                                <i class="iconfont icon-zan"></i>\n' +
                        '                                <em>'+data[i].zanCount+'</em>\n' +
                        '                            </span>\n' +
                        '                            <span type="reply">\n' +
                        '                                <i class="iconfont icon-svgmoban53"></i>\n' +
                        '                                回复\n' +
                        '                            </span>\n' +
                        '                            <div class="jieda-admin">\n' +
                        '                                <span type="edit">编辑</span>\n' +
                        '                                <span type="del">删除</span>\n' +
                        '                                <span class="jieda-accept" type="accept">采纳</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                    </li>';
                }
                $("#jieda").html(st);
            }
        }
    })
}
