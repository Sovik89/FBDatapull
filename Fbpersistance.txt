package com.itorbital.fbcommentspersistance;

public class Fbpersistance {
	String postid;
	int comment_count;
	Long share_count;
	int like_count;
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public Long getShare_count() {
		return share_count;
	}
	public void setShare_count(Long share_count) {
		this.share_count = share_count;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
}
