$(document).ready(function() {
	$("ul.navbar-nav li").each(function() {
		$(this).on("click", function(e) {
			var newPage = $(this).attr("data-page");
			navi2page(newPage);
		})
	});

	$("#logoutBtn").unbind("click");
	$("#logoutBtn").click(function(){
		$.ajax("/login/logout",{
			success: function(data){
				console.log("logout success "+JSON.stringify(data));
			},
			error:function(msg){
				console.log("logout failed "+JSON.stringify(msg));
			}
		});
		location.href='/login.html'
	});

	//navi2page("ldhomework-list.html");

})