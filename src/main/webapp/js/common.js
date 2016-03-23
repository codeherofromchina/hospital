$(function(){
	$(document).click(function(){ 
		if(!$("#sbArea_h").is(":hidden")){
			$("#sbArea_h").hide();
		}
    }); 
	
	// 首页选中按照科室还是医生查找
	$("#wn_h_div").click(function(event){
		$("#sbArea_h").show();
		event.stopPropagation(); 
	});
	
	// 选中科室或者医生
	$("div[id^='wv_h_']").click(function(){
		var name = $(this).html();
		$("#wn_h").html(name);
		$("#sbArea_h").hide();
	});
	
	
	
	
});