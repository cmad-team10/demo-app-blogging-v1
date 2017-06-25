$(document).ready(function() {
	
	
	$("#create-blog-icon").click(function(e) {
		console.log("create blog");
	    var token =	localStorage.getItem('token');
	    if(token == undefined || token == ""){
	    	showDiv("login-signup");
	    }else{
	    	showDiv("create-blog");
	    }
	    
	});
	
	$("#profile-icon").click(function(e) {
		console.log("profile");	
	});
	
	$("#create-blog-submit").click(function(e){
		e.preventDefault();
		console.log('inside create-blog-submit:'+blog);
		var title = $("#create-blog-title").val();
		var content = $("#create-blog-content").val();
		var userId = localStorage.getItem("userName");
		var blog = {
			"title" : title,
			"details" : content,
			"userId" : userId
			
		}
		console.log('calling:'+blog);
		$.ajax({
			url : 'rest/blogging/blog',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			headers: {"Authorization": "Bearer "+localStorage.getItem('token')},
			success : function(data) {
				$("#create-blog-title").val('');
				$("#create-blog-content").val('');
				showDiv("list-blog");
				viewList();				
			},
			error : function(xhr, ajaxOptions, thrownError){
			   console.log("create-blog-submit not successfull xhr :"+xhr.responseText);
			   console.log("create-blog-submit not successfull ajaxOptions:"+ajaxOptions);
			   console.log("create-blog-submit not successfull thrownError:"+thrownError);
			   if(thrownError == "Unauthorized"){
				   logOut();
				   setLoginView(false);
				   $("#login-icon").trigger('click');
				}
			},
			data : JSON.stringify(blog)
		});	
		console.log("here");
	})
	
	$("#list-blog-icon").click(function(e) {
		showDiv("list-blog");
		viewList();
	});
	
	//when ckicked on blog from the blog list
	$("#list-blog-list").on("click", ".list-blog", function(event){
		$("#blog-comment-list").empty();
		console.log("id:"+this.id);
		showDiv("view-blog");
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
	
	$("#create-comment-submit").click(function(e){
		e.preventDefault();
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
			headers: {"Authorization": "Bearer "+localStorage.getItem('token')},
			success : function(data) {
				console.log("create-comment-submit:"+data);
				$("#blog-comment-list").append( '<li class="list-group-item">'+commentData+'</li>');
			},
			data : JSON.stringify(comment)
		});	
	});
	
	function performLogin(userId, password){
		console.log("performLogin:"+userId+" "+password);
		var login = {
				"userId" : userId,
				"password" : password
			}
		$.ajax({
			url : 'rest/users/login',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(response) {
				console.dir("login response:"+response);
				localStorage.setItem("userName", response.userId);
				localStorage.setItem("token", response.token);
				setLoginView(true);
				showDiv("list-blog");
			},
			error : function(xhr, ajaxOptions, thrownError){
				//console.log("login not successfull xhr :"+xhr.responseText);
				//console.log("login not successfull ajaxOptions:"+ajaxOptions);
				console.log("login not successfull thrownError:"+thrownError);
				if(thrownError == "Unauthorized"){
                    $("#login-failure p").html("Login/Password incorrect !!");
				}
			},
			data : JSON.stringify(login)
		});	
		
	}
	

	
	function viewList(){
		console.log("calling viewList");
		showDiv("list-blog");
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
		showDiv("list-blog");
	});
	
	$("#login-icon").click(function(){
		$("#login-failure p").html("");
		showDiv("login-signup");
	});
	
	$("#login-button").click(function(e){
		e.preventDefault();
		var userId = $("#login-userId").val();
		var password = $("#login-pwd").val();
		performLogin(userId,password);
		
	});
	
	$("#signup-button").click(function(e){
		e.preventDefault();
		var userId = $("#signup-userId").val();
		var password = $("#signup-password").val();
		var firstName = $("#signup-firstName").val();
		var lastName = $("#signup-lastName").val();
		var emailId = $("#signup-emailId").val();
		var userData = {
				"userId" : userId,
				"password" : password,
				"firstName" : firstName,
				"lastName" : lastName,
				"emailId" : emailId
		}
		$.ajax({
			url : 'rest/users/user',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(response) {
				console.dir("register response:"+response);
				localStorage.setItem("userName", response.firstName);
				localStorage.setItem("token", response.token);
				setLoginView(true);
				showDiv("list-blog");
			},
			error : function(xhr, ajaxOptions, thrownError){
				console.log("register not successfull xhr :"+xhr.responseText);
				console.log("register not successfull ajaxOptions:"+ajaxOptions);
				console.log("register not successfull thrownError:"+thrownError);
			},
			data : JSON.stringify(userData)
		});
		
	});
	
	function logOut(){
		localStorage.setItem("userName", "");
		localStorage.setItem("token", "");
	}
	
	function setLoginView(isLogedIn){
		if(isLogedIn == true){
			$("#logout-icon").show();
			$("#login-icon").hide();
			$("#profile-icon-span").show();
			$("#profile-icon p").html(localStorage.getItem("userName"));
		}else{
			$("#logout-icon").hide();
			$("#login-icon").show();
			$("#profile-icon-span").hide();
			$("#profile-icon p").html(localStorage.getItem(""));
		}
	}
	
	viewList();
	
	if(localStorage.getItem('token') != ""){
		setLoginView(true);
	}else{
		setLoginView(false);
	}
	
	function showDiv(id){
		$("#list-blog").hide();
		$("#view-blog").hide();
		$("#login-signup").hide();
		$("#create-blog").hide();
		$("#"+id).show();
	}
	
	function loginAgain(){
		logOut();
		setLoginView(false);
	}

});