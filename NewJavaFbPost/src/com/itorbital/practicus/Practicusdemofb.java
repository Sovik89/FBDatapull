package com.itorbital.practicus;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Comment;
import com.restfb.types.Page;
import com.restfb.types.Post;

public class Practicusdemofb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String accestoken="EAACEdEose0cBAKG5eiSZCxyJHDeNlN8ZAfsYLl2icrh8EGvlyjKDdjl4bZATcdbZCkxpPHxMaHcNZAD0obQgZB6YgGKGZC1go3jVFbbQAbkEvkNqUe2HmWcN7A2jBFKek4D6E0oDICkhEvZBhuLp98iLLWWoaf5TdpdBaULlDfl21aC4ZAj3cvkRWaZCxRFWbmQStKwhYe3jC4UQZDZD";
		@SuppressWarnings("deprecation")
		FacebookClient fbclient=new DefaultFacebookClient(accestoken);//ownapp
			
		//Connection<Group> result=fbclient.fetchConnection("me/groups", Group.class);
		Page page=fbclient.fetchObject("lockheedmartin", Page.class);
		Connection<Post> result=fbclient.fetchConnection(page.getId()+"/feed", Post.class,Parameter.with("limit", 20));
		
		//Scanner input=new Scanner(System.in);
		
		
		 for(List<Post> feed : result){
        	 for(Post apage : feed){
        		 System.out.println("The post is:>   "+apage.getMessage());
        		 System.out.println("The post id is:>   "+apage.getId());
        		 
        		 
        		 Connection<Comment> comments=fbclient.fetchConnection(apage.getId()+"/comments", Comment.class);
        		 if(comments!=null){
        			 int counter=0;	 
        			 List<Comment> commentlist=comments.getData();
        			
        			 System.out.println("Underlying comments are:");
        			 for(Comment comment:commentlist){
        				 System.out.println("Person who made the comment"+comments.getData().get(counter).getFrom().getName());
        				 System.out.println("Comments : "+comment.getMessage());
        			     counter++;
        			 }
        		 }else{
        			 System.out.println("Sorry no comments are available for this post");
        			 
        		 }
        		 
        		 
        		 // System.out.println(apage.getMessage());
        		// System.out.println(apage.getComments().getData().get(counter).getMessage());
        		 //System.out.println(apage.getCreatedTime().toString());
        		 //System.out.println(apage.getMessage());
        		 //counter++;
        		 //Connection<Comment> comments=fbclient.fetchConnection(apage.getId().get)
        	 }
        	 
         }
		 
		/* for(List<Post> pages : result){
			 int Counter=0;
        	 for(Post apage : pages){
        		// System.out.println(apage.getMessage());
        		// System.out.println(apage.getComments().getData().get(counter).getMessage());
        		/* System.out.println(apage.getCreatedTime().toString());
        		 System.out.println(apage.getMessage());
        		 counter++;*/
        		 
        		 
        	// }
        	 
         //}
	}

}
