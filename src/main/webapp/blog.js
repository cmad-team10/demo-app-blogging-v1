$(document).ready(function() {
	
	
	$("#create-blog-icon").click(function(e) {
		console.log("create blog");
	    var token =	localStorage.getItem('token');
	    if(token == undefined || token == ""){
	    	alert("Not LogedIn");
	    }
		$("#list-blog").hide();
		$("#view-blog").hide();
		$("#create-blog").show();		
	});
	
	$("#profile-icon").click(function(e) {
		console.log("profile");	
	});
	
	$("#create-blog-submit").click(function(e){
		console.log('inside create-blog-submit:'+blog);
		var title = $("#create-blog-title").val();
		var content = $("#create-blog-content").val();
		var blog = {
			"title" : title,
			"details" : content
		}
		console.log('calling:'+blog);
		$.ajax({
			url : 'rest/blogging/blog',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				("#list-blog-icon a").trigger('click');
			},
			data : JSON.stringify(blog)
		});	
		console.log("here");
	})
	
	$("#list-blog-icon").click(function(e) {
		$("#create-blog").hide();
		$("#view-blog").hide();
		$("#list-blog").show();
		viewList();
	});
	
	//when ckicked on blog from the blog list
	$("#list-blog-list").on("click", ".list-blog", function(event){
		$("#blog-comment-list").empty();
		console.log("id:"+this.id);
		$("#create-blog").hide();
		$("#list-blog").hide();
		$("#view-blog").show();
		$("#create-comment-blogId").val(this.id);
		$.ajax({
			url : 'rest/blogging/blog/'+this.id,
			type : 'get',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				console.log(data);
				$('#view-blog-title').html(data.title);
				$('#view-blog-content').html(data.details.replace(/\n/g, '<br>'));
			}
		});
		$.ajax({
			url : 'rest/blogging/blog/'+this.id+'/comment',
			type : 'get',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				console.log(data);
				$.each(data, function(idx, data){
				     $("#blog-comment-list").append( '<li class="list-group-item">'+data.commentData+'</li>');
				   });
			}
		});
		
	});
	
	$("#create-comment-submit").click(function(){
		var blogId = $("#create-comment-blogId").val();
		var commentData = $("#create-blog-comment").val();	
		var comment = {
				"blogId" : blogId,
				"commentData" : commentData
			}
		$.ajax({
			url : 'rest/blogging/blog/'+blogId+'/comment',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				console.log("create-comment-submit:"+data);
				$("#blog-comment-list").append( '<li class="list-group-item">'+commentData+'</li>');
			},
			data : JSON.stringify(comment)
		});	
	});
	
	function performLogin(){
		var login = {
				"userId" : "harsha",
				"password" : "pwd"
			}
		$.ajax({
			url : 'rest/users/login',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(response) {
				console.dir("login response:"+response);
				localStorage.setItem("userName", response.firstName);
				localStorage.setItem("token", response.token);
				setLoginView(true);
			},
			error : function(xhr, ajaxOptions, thrownError){
				console.log("login not successfull xhr :"+xhr.responseText);
				console.log("login not successfull ajaxOptions:"+ajaxOptions);
				console.log("login not successfull thrownError:"+thrownError);
			},
			data : JSON.stringify(login)
		});
	}
	
	function viewList(){
		console.log("calling viewList");
		$("#list-blog-list").empty();
		$.ajax({
			url : 'rest/blogging/blog',
			type : 'get',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			headers: {"Authorization": "Bearer "+localStorage.getItem('token')},
			success : function(data) {
				//var returnedData = JSON.parse(data);
				console.log(data);
				console.log('Data received;'+data[0].title);
				//console.log('Data returnedData;'+returnedData);
				
				console.log(JSON.stringify(data));
				   $.each(data, function(idx, blog){
				     //$("#nav").html('<a href="' + blog.blogId + '">' + topic.title + "</a>");
				     $("#list-blog-list").append( '<li class="list-group-item list-blog" id="'+blog.blogIdString+'"><a>'+blog.title+'</a></li>');
				   });
			}
		});
	}
	
	$("#logout-icon").click(function(){
		logOut();
		setLoginView(false);
	});
	
	$("#login-icon").click(function(){
		performLogin();
		setLoginView(true);
	});
	
	function logOut(){
		localStorage.setItem("userName", "");
		localStorage.setItem("token", "");
	}
	
	function setLoginView(isLogedIn){
		if(isLogedIn == true){
			$("#logout-icon").show();
			$("#login-icon").hide();
			$("#profile-icon p").html(localStorage.getItem("userName"));
		}else{
			$("#logout-icon").hide();
			$("#login-icon").show();
			$("#profile-icon p").html("Profile");
		}
	}
	
	viewList();
	
	if(localStorage.getItem('token') != ""){
		setLoginView(true);
	}else{
		setLoginView(false);
	}

});