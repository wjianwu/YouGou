package darian.dao;

import darian.entity.Comment;
import darian.entity.Define;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    //查询当前帖子的所有评论
	List<Comment> showComment(@Param("topicId") int topicId);

	//回帖周榜
	List<Define> huiTie();

	int updateCommentImg(@Param("userId")int userId,@Param("filename")String filename);
}