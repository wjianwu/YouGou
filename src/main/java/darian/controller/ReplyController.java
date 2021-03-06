package darian.controller;

import darian.entity.Comment;
import darian.entity.Define;
import darian.entity.Topic;
import darian.entity.User;
import darian.service.ReplyService;
import darian.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

@Controller
public class ReplyController {

	@Resource
	private ReplyService replyService;
	@Resource
	private TopicService topicService;

	/*发表评论*/
	@RequestMapping("/comment")
	@ResponseBody
	public Map comment(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		User user = (User)session.getAttribute("user");

		Topic topic = topicService.getById(topicId);
		if(topic.getUserid().equals(user.getId())){
			map.put("eq",1);
		}else {
			map.put("eq",0);
		}

		String com = request.getParameter("content");

		Comment comment = new Comment();
		comment.setTopicId(topicId);//主题ID
		comment.setUserId(user.getId());//评论人ID
		comment.setUserName(user.getNickname());//评论人昵称
		comment.setUserImg(user.getHeadUrl());//评论人头像
		comment.setComment(com);//评论内容
		comment.setZanCount(0);//点赞数
		comment.setStatus(0);//是否被采纳（采纳程度默认为0-10之间）
		comment.setCreateOn(new Timestamp(new Date().getTime()));//评论时间

		//更新回复数量
		topicService.replyCount(topicId);

		if(replyService.subComment(comment)){
			map.put("status","ok");
		}else {
			map.put("status","error");
		}
		return map;
	}

	/*显示所有评论*/
	@RequestMapping("/showComment")
	@ResponseBody
	public List showComment(HttpServletRequest request){
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		return replyService.showComment(topicId);
	}
	/*回帖周榜*/
	@RequestMapping("/huiTie")
	@ResponseBody
	public List<Define> huiTie(){
		return replyService.huiTie();
	}

	/*显示用户的所有评论*/
	@RequestMapping("/showReply")
	@ResponseBody
	public List showReply(HttpServletRequest request){
		int userId = Integer.parseInt(request.getParameter("userId"));
		return replyService.showReply(userId);
	}

	/*点赞*/
	@RequestMapping("/dianZan")
	@ResponseBody
	public Map dianZan(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();

		//评论表Id
		int id = Integer.parseInt(request.getParameter("commentId"));
		Comment comment = replyService.dianZan(id);
		comment.setZanCount(comment.getZanCount()+1);
		if(replyService.updateZan(comment)){
			map.put("status","ok");
		}else {
			map.put("status","error");
		}
		return map;
	}
}
