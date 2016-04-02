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

//格式化日期格式为MM/dd
function getDateShortFormat(date){
	var months = date.getMonth()+1;
	if(months < 10){
		months = "0" + months;
	}
	var days = date.getDate();
	if(days < 10){
		days = "0" + days;
	}
	return months + "/" +days;
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

//根据给定日期获取周几
function getWeekShotName(date){
	var weekday=new Array(7);
	weekday[0]="周日";
	weekday[1]="周一";
	weekday[2]="周二";
	weekday[3]="周三";
	weekday[4]="周四";
	weekday[5]="周五";
	weekday[6]="周六";
	
	return weekday[date.getDay()];
}

//由 时间段编码转换为时间段字符串
function letterToStr(timeSole){
	// 获取上午下午晚上标识码
	var x ;
	if(timeSole=="S"){
		x = "上午";
	}else if(timeSole=="X"){
		x = "下午";
	}else if(timeSole == "Y"){
		x = "晚上";
	}else{
		return timeSole;
	}
	return x;
}

//由 时间段字符串转换为时间段编码 
function strToLetter(timeSole){
	// 获取上午下午晚上标识码
	var x ;
	if(timeSole=="上午"){
		x = "S";
	}else if(timeSole=="下午"){
		x = "X";
	}else if(timeSole == "晚上"){
		x = "Y";
	}else{
		return timeSole;
	}
	return x;
}




// 获取可用预约号数量
function getAvailableNum(availabelNumStr){
	var num = Number(availabelNumStr);
	if(isNaN(num)){
		var result = 0;
		$.each(availabelNumStr.split(","),function(index,obj){
			var numArr = obj.split(";");
			if(numArr.length > 1){
				var n = parseInt(numArr[1]);
				if(!isNaN(n)){
					result += n;
				}
			}
		})
		return result;
	}else{
		return num;
	}
}