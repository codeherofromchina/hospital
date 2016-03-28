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
// 格式化日期格式为yyyy-MM-dd
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

// 在给定日期dd上添加dadd天并返回添加后的日期
function addDate(dd,dadd){
	var a = new Date(dd)
	a = a.valueOf()
	a = a + dadd * 24 * 60 * 60 * 1000
	a = new Date(a)
	return a;
}
// 根据给定日期获取星期几
function getWeek(date){
	var weekday=new Array(7);
	weekday[0]="星期日";
	weekday[1]="星期一";
	weekday[2]="星期二";
	weekday[3]="星期三";
	weekday[4]="星期四";
	weekday[5]="星期五";
	weekday[6]="星期六";
	
	return weekday[date.getDay()];
}
