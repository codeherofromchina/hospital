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

function getDateFormat(date){
	var years = date.getFullYear();
	var months = date.getMonth()+1;
	if(months < 10){
		months = "0" + months;
	}
	var days = date.getDate();
	if(days < 10){
		days = "0" + days;
	}
	return years +"-" + months + "-" +days;
}


function addDate(dd,dadd){
	var a = new Date(dd)
	a = a.valueOf()
	a = a + dadd * 24 * 60 * 60 * 1000
	a = new Date(a)
	return a;
}