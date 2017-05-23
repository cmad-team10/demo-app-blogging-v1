$(document).ready(function() {
	
	
	$("#create-blog-icon").click(function(e) {
		console.log("create blog");
		$("#list-blog").hide();
		$("#view-blog").hide();
		$("#create-blog").show();
	});
	
	$("#list-blog-icon").click(function(e) {
		$("#create-blog").hide();
		$("#view-blog").hide();
		$("#list-blog").show();
		viewList();
	});
	
	$(".list-blog").click(function(e) {
		console.log("id:"+this.id);
		$("#create-blog").hide();
		$("#list-blog").hide();
		$("#view-blog").show();
		
	});
	
	/*$("#addBlog").click(function() {
		$("#addForm").hide();
		$.ajax({
			url : 'rest/blogging/blog',
			type : 'get',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				alert('Data received;'+data);
			}
		});
	});*/
	
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