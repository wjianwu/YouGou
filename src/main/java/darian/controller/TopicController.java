package darian.controller;

import darian.entity.SmallBlock;
import darian.entity.Topic;
import darian.entity.User;
import darian.service.SmallBlockService;
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
public class TopicController {

	@Resource
	private TopicService topicService;
	@Resource
	private SmallBlockService smallBlockService;

	//发帖子
	@RequestMapping("/issue")
	@ResponseBody
	public Map issue(HttpServletRequest request){

		HttpSession session = request.getSession();
		Map<String,Object> result = new HashMap<String, Object>();

		User user = (User)session.getAttribute("user");

		Topic topic1 = new Topic();
		SmallBlock smallBlock = smallBlockService.classify(Integer.parseInt(request.getParameter("class")));

		topic1.setClassid(Integer.parseInt(request.getParameter("class")));		//所属分类
		topic1.setUserid(user.getId());												//发表人userId
		topic1.setClassName(smallBlock.getName());									//所属分类名
		topic1.setUserName(user.getNickname());										//用户名
		topic1.setTitle(request.getParameter("title"));							//标题title
		topic1.setBody(request.getParameter("content"));							//内容body
		topic1.setImgUrl(user.getHeadUrl());										//贴图img
		topic1.setRank(Integer.parseInt(request.getParameter("experience")));		//悬赏积分rank
		topic1.setModifiedOn(new Timestamp(new Date().getTime()));					//最近一次修改时间
		topic1.setHits(0);															//点击量
		topic1.setReplyCount(0);													//答复量
		topic1.setEnable(true);														//状态
		topic1.setCreateOn(new Timestamp(new Date().getTime()));					//创建时间crateOn

		if(topicService.issueTopic(topic1)){
			result.put("status","ok");
		}else {
			result.put("status","error");
		}

		return result;
	}

	//显示发的帖子(个人)
	@RequestMapping("/showTopic")
	@ResponseBody
	public List showTopic(HttpServletRequest request){

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		return topicService.getAllTopics(user.getId());
	}

	//显示所有帖子（前十条，其余会按照分类分页显示）
	@RequestMapping("/showAll")
	@ResponseBody
	public List showAll(HttpServletRequest request){
		int ec = Integer.parseInt(request.getParameter("ec"));
		return topicService.getAll(ec);
	}

	//按分类显示（分享类）
	@RequestMapping("/showShare")
	@ResponseBody
	public List showAllByShare(HttpServletRequest request){
		int classId = Integer.parseInt(request.getParameter("classId"));
		return topicService.getAllByClass(classId);
	}

	//结贴未结帖
	@RequestMapping("/showByEnable")
	@ResponseBody
	public List showByEnable(HttpServletRequest request){
		int enable = Integer.parseInt(request.getParameter("enable"));
		return topicService.getByEnable(enable);
	}

	//显示细节
	@RequestMapping("/detail")
	@ResponseBody
	public Topic showDetail(HttpServletRequest request){
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		return topicService.getDetail(topicId);
	}
}
