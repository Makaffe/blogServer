package com.lrm.service;

import com.lrm.dao.CommentRepository;
import com.lrm.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        return commentRepository.findByBlogId(blogId,sort);
    }
    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        if(parentCommentId!=-1){
            comment.setParentComment((Comment) commentRepository.findByBlogId(parentCommentId,sort));
        }else{
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }
}
