<div class="box box-widget timelinepost"  style='display: none'>
	<div class="box-header with-border">
{% 
   if (o.currentUserEnabledRoles.listofroles && o.currentUserEnabledRoles.listofroles.length && o.currentUserEnabledRoles.listofroles.length > 1)
   {
 %}  	
		<div class="dropdown user-block user-menu">
		<div data-toggle="dropdown" class="dropdown-toggle">
			<img class="postauthorphoto img-circle" 
				src="{%=o.currentUserEnabledRoles.current.getAuthorphotourl()%}" alt="User Image"> 
				<span class="postauthorname username"><a href="#">{%=o.currentUserEnabledRoles.current.authorname%} <i class="fa fa-caret-down"></i></a></span> 				
				<span class="description">{%#$.r3Utils.formatDateAsBadge()%} - {%=org.r3.message.no_second_ago%}</span>
				<span class="infomessage" >MESSAGE</span>
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
{% 
   }
   else {
%}
		<div class="user-block">
			<img class="img-circle" 
				src="{%=o.currentUserEnabledRoles.current.getAuthorphotourl()%}" alt="User Image"> 
				<span class="username">{%=o.currentUserEnabledRoles.current.authorname%}</span> 				
				<span class="description">{%#$.r3Utils.formatDateAsBadge()%} - {%=org.r3.message.no_second_ago%}</span>
				<span class="infomessage" >MESSAGE</span>
				
		</div>
{% 
   }   
%}

		<div class="box-tools">
{% if (o.contentClassObj.shouldGeoLocationBeAcquired()) { %}		
			<button type="button" class="btn btn-box-tool" data-action='primary-edit-position' >
				<i class="fa fa-map-marker"></i>
			</button>
{% } %}								
			<button type="button" class="btn btn-box-tool" data-action='primary-edit-cancel' data-widget="remove">
				<i class="fa fa-times"></i>
			</button>
			
		</div>
		<!-- /.box-tools -->
	</div>
	<!-- /.box-header -->
	<div class="box-body">
	<div class="mongotimeline_primarypost_content" ></div> 
	</div>
</div>
