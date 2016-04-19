var webRootPath = "";
$(function(){
	webRootPath = $("#rootWebPath").val() + "/";
	
	autoComplete(1,"words"); // 科室医生表单栏自动提示
	
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
		var oldName = $("#wn_h").html();
		if(name!=oldName){
			if(name=="医生"){
				autoComplete(2,"words");
			}else if(name="科室"){
				autoComplete(1,"words");
			}
			$("#wn_h").html(name);
		}
		$("#sbArea_h").hide();
	});
	
	
	// 头部搜索框事件
	$("#top_search_btn").click(function(){
		var wordsValue = $("#words").val();
		var wnhValue = $("#wn_h").html();
		if(wordsValue=="" || wordsValue=="请输入搜索内容"){
			var msg ;
			if(wnhValue=="科室"){
				msg = "请输入科室名称或者从提示中选取科室名称。";
			}else if(wnhValue == "医生"){
				msg = "请输入医生姓名或者从提示中选取医生姓名。";
			}else{
				msg = "请输入内容或者从提示中选取内容。";
			}
			
			alertMsg(msg);
			return;
		}
		
		// 如果选择的是科室
		if(wnhValue=="科室"){
			$.post(webRootPath + "search/department/asyncQueryDepartmentByName.htm",{deptName:wordsValue},function(data){
				if(data.success){
					  window.location.href=webRootPath + "search/schedule/department.htm?deptCode="+data.result.departmentCode; 
				}else{
					alertMsg(data.msg);
				}
			},"json");
		}else if(wnhValue == "医生"){
			// 如果选择的是医生
			window.location.href=webRootPath + "search/doctor/deptDoctorList.htm?doctorName="+encodeURI(wordsValue); 
		}else{
			// 如果其他
			alertMsg("页面错误，请尝试刷新后重新操作");
		}
		
	})
	
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


//自动提示 ,flagNum分别科室为1(全部科室信息)、2（全部医生信息）、3（科室医生信息）,id为要自动提示的控件
function autoComplete(flagNum,id,deptVal){
	if(flagNum==1){
		$.post(webRootPath + "search/department/asyncAllDepartments.htm",function(data){
			if(data.success){
				var arr = new Array();
				
				$.each(data.result,function(index,obj){
					arr.push(obj.departmentName);
				})
				
				completeArr(arr.unique4(),id);
			}
		},"json");
	}else if(flagNum==2){
		$.post(webRootPath + "search/doctor/asyncAllDoctors.htm",function(data){
			if(data.success){
				var arr = new Array();
				
				$.each(data.result,function(index,obj){
					arr.push(obj.doctorName);
				})
				
				completeArr(arr.unique4(),id);
			}
		},"json");
	}else if(flagNum==3){
		$.post(webRootPath + "search/doctor/asyncDoctorsByDeparmentName.htm",{deptName:deptVal},function(data){
			if(data.success){
				var arr = new Array();
				
				$.each(data.result,function(index,obj){
					arr.push(obj.doctorName);
				})
				
				completeArr(arr.unique4(),id);
			}
		},"json");
	}
}

// 自动补充表单提示 arr 要提示的数据   id：要控制的表单ID
function completeArr(arr,id){
	try{
		$("#"+id).autocomplete( "destroy" );
	}catch(e){
		//console.log(e.message);
	}
	$("#"+id).autocomplete({
		source: arr,
		minLength: 0
	});
	$("#"+id).focus(function(){
		$("#"+id).autocomplete( "search", $("#"+id).val());
	})
	if("department_fast_search"==id){
		$("#"+id).autocomplete({
			select: function( event, ui ) {
				autoComplete(3,"doctor_fast_search",ui.item.value)
			}
		});
	}
}


// 数组去重
Array.prototype.unique4 = function()
{
	this.sort(function(a,b){
        return  b - a ;
	});
	var re=[this[0]];
	for(var i = 1; i < this.length; i++)
	{
		if( this[i] !== re[re.length-1])
		{
			re.push(this[i]);
		}
	}
	return re;
}

// 弹出警告信息
function alertMsg(msg){
	// 更换提示信息并显示警告信息
	$("#top_alert_div_msg").html(msg);
	$("#top_alert_div").slideDown();
	
	try{
		// 清除定时器，预防上次操作还没有过3秒后又操作引起bug
		clearTimeout(commonJsTimeOutVari);
	}catch(ex){
		//console.log(ex.message);
	}
	
	// 定时3秒后隐藏警告信息
	commonJsTimeOutVari = setTimeout(function(){
		$("#top_alert_div").slideUp();
	},5000);
}

var commonJsTimeOutVari;



