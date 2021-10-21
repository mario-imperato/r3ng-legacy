<div class="box-footer timelinecomment">

  <div class="box-comment">
  
{% 
   if (o.currentUserEnabledRoles.listofroles && o.currentUserEnabledRoles.listofroles.length && o.currentUserEnabledRoles.listofroles.length > 1)
   {
 %}  
    <div class="dropdown user-block user-menu">
	<img class="postauthorphoto img-circle img-sm"
		src="{%=o.currentUserEnabledRoles.current.getAuthorphotourl()%}"
		alt="Alt Text">

	<div >
	<div data-toggle="dropdown" class="dropdown-toggle">
		<span class="username" style='height: 40px; display: block'>
		<span class="authorname postauthorname"><a href="#">{%=o.currentUserEnabledRoles.current.authorname%}  <i class="fa fa-caret-down"></i></a></span>
		</span>
	</div>
	<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" >
{% 

   if (o.currentUserEnabledRoles.listofroles && o.currentUserEnabledRoles.listofroles.length)
   {
     for(var i = 0; i < o.currentUserEnabledRoles.listofroles.length; i++)
     {
        var r = o.currentUserEnabledRoles.listofroles[i];
%}		
         <li class="clearfix" data-action="switch-user-role:{%=r.author%}" >
         <img class="img-circle" 
				src="{%=r.getAuthorphotourl()%}" alt="User Image"> 
         <span class="username" style='margin-top: 10px'>{%=r.authorname%}</span></li>         
{% 
     }
   }
%}
      </ul>
      </div>
      </div>          
 {% 
   }
   else {
%}
  
	<img class="img-circle img-sm"
		src="{%=o.currentUserEnabledRoles.current.getAuthorphotourl()%}"
		alt="Alt Text">

	<div class="comment-text" style='margin-left: 40px'>
		<span class="username" style='height: 40px; display: block'>
		<span class="authorname">{%=o.currentUserEnabledRoles.current.authorname%}</span>
		</span>
	</div>		
	{% 
   }   
%}
				
	<!-- .img-push is used to add margin to elements next to floating images -->
	<div >
        <div class="mongotimeline_postcomment_content" ></div> 	
	</div>
	

</div>	
</div>	