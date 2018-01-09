package com.itorbital.fbcomments;

import java.util.ArrayList;
import java.util.List;

import com.itorbital.fbcommentspersistance.Fbpersistance;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Comment;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Reactions;
import com.restfb.types.Post.Shares;
import com.restfb.types.Reactions.ReactionItem;

public class FBcomments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Fbpersistance> fbrecords=new ArrayList<Fbpersistance>();
		String reactionfacebook[]={"NONE", "LIKE", "LOVE", "WOW", "HAHA", "SAD", "ANGRY"};
		String accestoken="EAACEdEose0cBAHu35tE2HyzZA7PhdfB029XteksrRvy2UsEKS3vAzOVnZAZCluL1RHDMMHQ71ee304hfJrbkVR37ZC9zgvJxuqtqZBy8dOhU2ZCOybsHZAuEdG9aUYk4RMqWpvyFRWZAqgcZB2lw1GdGFB4M80wCkT7kIZCeWGZCDrmhaI92pkxEAe4dFUvqTbhS07IfOW41IOEwwZDZD";
		@SuppressWarnings("deprecation")
		
		FacebookClient fbclient=new DefaultFacebookClient(accestoken,Version.VERSION_2_10);//ownapp
		//Connection<Post> resultfb=fbclient.fetchConnection(page.getId()+"/feed", Post.class,Parameter.with("fields","reactions.summary(1)"));
	
		//Connection<Group> result=fbclient.fetchConnection("me/groups", Group.class);
		Page page=fbclient.fetchObject("AdeccoUK", Page.class);
		Connection<Post> result=fbclient.fetchConnection(page.getId()+"/feed", Post.class,Parameter.with("limit", 20));//,Parameter.with("fields","reactions.summary(1)"));
		Connection<Post> resultfb=fbclient.fetchConnection(page.getId()+"/feed", Post.class,Parameter.with("fields","reactions.summary(1)"));
		Connection<Post> resultfbs=fbclient.fetchConnection(page.getId()+"/feed", Post.class,Parameter.with("fields","shares.summary(1)"));
		Connection<Post> resultfbc=fbclient.fetchConnection(page.getId()+"/feed", Post.class,Parameter.with("fields","shares.summary(1)"));
		
		
		//Scanner input=new Scanner(System.in);
		int ic=0;
		int listcount=0;
		//while(true){
	 for(List<Post> feed : result){
		  
        	 for(Post apage : feed){
        		// System.out.println(apage.getMessage());
        		 //System.out.println("The post is:>   "+apage.getMessage());
        		 System.out.println(apage.getMessage());
        	// System.out.println("The post id is:>   "+apage.getId());
        		 
        			 Fbpersistance fb=new Fbpersistance();
        		  fb.setPostid(apage.getId());
        		  
        		 /*
        		  * 
        		  * Comments of a particular Post 
        		  * 
        		  */
        		 Connection<Comment> comments=fbclient.fetchConnection(apage.getId()+"/comments", Comment.class);
        		
        		 int counter=0;	 
        		 if(comments!=null){
        			 
        			 List<Comment> commentlist=comments.getData();
        			
        			// System.out.println("Underlying comments are:");
        			for(Comment comment:commentlist){
        				// System.out.println("Person who made the comment  :"+comments.getData().get(counter).getFrom().getName());
        				//System.out.println("Comments : "+comment.getMessage());
        				//System.out.println(comment.getMessage());
        			     counter++;
        			    // if(comment.equals(commentlist.lastIndexOf(commentlist)))
        			    //	 break;
        			     
        			     
        			 }
        			fb.setComment_count(counter);
        			
        			//System.out.println("No of comments:"+counter);
        		 }else{
        			 //System.out.println("No of comments :" +counter);
        			 fb.setComment_count(counter);
        			 
        		 }
        		fbrecords.add(ic, fb); 
        		 ic++;
        		 listcount++;
        		 if(listcount>1400)
        			 break;
        		 
        	 }
        	
		 }	
	 int is=0;
	 listcount=0;
		for(List<Post> feeds : resultfbs){
			
            for(Post apages : feeds){
            	//System.out.println("post id-->"+apages.getId());
            	
            	Shares share=apages.getShares();
            	 
            	
            	Fbpersistance fb=new Fbpersistance();
            	
            	 if(share!=null){
          
            		fbrecords.get(is).setShare_count(share.getCount()); 
            		 //fb.setShare_count(share.getCount());
     	         //   System.out.println("No of shares :"+share.getCount().toString());
            	 }else{
            		// System.out.println("0");
            		 //fb.setShare_count(00000000000000L);
            		 fbrecords.get(is).setShare_count(000000000000L); 
            	 }
            	//fbrecords.set(is, fb);
            	 is++;
        		 listcount++;
        		 if(listcount>1400)
        			 break;
        		 
            }
            
		}
        	       
        		 /*
        		  * 
        		  * Reactions of  particular Post
        		  * 
        		  * 
        		  */
        		int ir=0; 
        		listcount=0;
      for(List<Post> feeds : resultfb){
                for(Post apages : feeds){
                		 System.out.println(apages.getMessage());
                		 //System.out.println("The post is:>   "+apages.getMessage());
                		// System.out.println("The post id is:>   "+apage.getId());
        		 // Long reactionsCount=apages.getReactionsCount();
        	      //  System.out.println("post id-->"+apages.getId());//"  reactionsCounts--->"+reactionsCount);
        	        //Shares share=apages.getShares();
        	        
        	       
        	        Reactions reactionsObj=apages.getReactions();
        	        Fbpersistance fb=new Fbpersistance();
        	        int wow=0,haha=0,likes=0,sad=0,angry=0,none= 0,love=0;
        	    	
        	       if(reactionsObj!=null)
                   {
        	    	  
                    //   System.out.println("bring it on reactions-------");
                           for (ReactionItem reactionListItem : reactionsObj.getData()) 
                           {
                               /*System.out.println("id"+ reactionListItem.getId());
                               System.out.println("id"+ reactionListItem.getName());
                               //reactionsMap.put("name", reactionListItem.getName() );
                               System.out.println("type"+reactionListItem.getType() );
                                */
                        	// if(reactionListItem.getType().toString().equals(reactionfacebook[0]))
                        	  //    none++;	
                        	 //if(reactionListItem.getType().toString().equals(reactionfacebook[1]))
                        		// likes++;
                        //	 else if(reactionListItem.getType().toString().equals(reactionfacebook[2]))
                        	//	 love++;
                        	// else if(reactionListItem.getType().toString().equals(reactionfacebook[3]))
                        		// wow++;
                        //	 else if(reactionListItem.getType().toString().equals(reactionfacebook[4]))
                        	//	 haha++;
                       // 	 else if(reactionListItem.getType().toString().equals(reactionfacebook[5]))
                        //		 sad++;
                        	// else
                        	//	 angry++;
                  
                    
                        	   

                           }
                       // fb.setLike_count(likes);
                         //  fbrecords.get(ir).setLike_count(likes);
                         // System.out.println("likes:"+likes);
                          /* System.out.println("loves:"+love);
                           System.out.println("haha:"+haha);
                           System.out.println("sad:"+sad);
                           System.out.println("angry:"+angry);
                           System.out.println("wow:"+wow);
                           System.out.println("none:"+none);*/
                          // break;
                    }
        	       else{
        	    	 // fb.setLike_count(likes);
        	    	   //fbrecords.get(ir).setLike_count(0);
        	       }
        	 
        	       ir++;
        	       listcount++;
          		 if(listcount>1400)
          			 break;
           		 
        	      }
                }
        		 // System.out.println(apage.getMessage());
        		// System.out.println(apage.getComments().getData().get(counter).getMessage());
        		 //System.out.println(apage.getCreatedTime().toString());
        		 //System.out.println(apage.getMessage());
        		 //counter++;
        		 //Connection<Comment> comments=fbclient.fetchConnection(apage.getId().get)
        	 //}
        	 
         //}
		 
		/* for(List<Post> pages : result){
			 int Counter=0;
        	 for(Post apage : pages){
        		// System.out.println(apage.getMessage());
        		// System.out.println(apage.getComments().getData().get(counter).getMessage());
        		/* System.out.println(apage.getCreatedTime().toString());
        		 System.out.println(apage.getMessage());
        		 counter++;
        	System.out.println("Postid   "+"Commentcount"+"Shares"+"Likes");	 
        	for(Fbpersistance fb1:fbrecords){
        		System.out.println(fb1.getPostid()+"  "+fb1.getComment_count()+"  "+fb1.getShare_count()+"  "+fb1.getLike_count());
        		
        	}	*/ 
        	
        	 
        }

}
