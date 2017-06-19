$(document).ready(function() {
	
	
	$("#create-blog-icon").click(function(e) {
		console.log("create blog");
		$("#list-blog").hide();
		$("#view-blog").hide();
		$("#create-blog").show();		
	});
	
	$("#create-blog-submit").click(function(e){
		console.log('inside create-blog-submit:'+blog);
		var title = $("#create-blog-title").val();
		var content = $("#create-blog-content").val();
		var blog = {
			"titile" : title,
			"details" : content
		}
		console.log('calling:'+blog);
		$.ajax({
			url : 'rest/blogging/blog',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				//("#list-blog-icon a").trigger('click');
			},
			error : function(XMLHttpRequest, textStatus, errorThrown){
				alert("unauth");
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
				$('#view-blog-title').html(data.titile);
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
	
	function viewList(){
		console.log("calling viewList");
		$("#list-blog-list").empty();
		$.ajax({
			url : 'rest/blogging/blog',
			type : 'get',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				//var returnedData = JSON.parse(data);
				console.log(data);
				console.log('Data received;'+data[0].titile);
				//console.log('Data returnedData;'+returnedData);
				
				console.log(JSON.stringify(data));
				   $.each(data, function(idx, blog){
				     //$("#nav").html('<a href="' + blog.blogId + '">' + topic.titile + "</a>");
				     $("#list-blog-list").append( '<li class="list-group-item list-blog" id="'+blog.blogId+'"><a>'+blog.titile+'</a></li>');
				   });
			}
		});
	}
	
	viewList();

});