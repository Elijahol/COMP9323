$(function () {
	
	
	var totalPlanType = [];
	var subData = {};
	var plan = {"chiefTrainer":$("#chiefTrainer").val(),"classId":$("#classId").val()};
	
	$.ajax({
		url:"http://www.vport.com/rest/course/planTree?classId="+$("#classId").val(),
		async:false,
		type:"get",
		dataType:"json",
		success:function(res){
			totalPlanType = res;
		}
	});
	
	var physicalData = totalPlanType[0][0].children;
	var skillData = totalPlanType[0][1].children;
	var trainingTime = totalPlanType[1];
    //初始化弹框
    var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));

    elems.forEach(function(html) {
        var switchery = new Switchery(html,{color:'#3db9dc'});
    });
    
    $.each(trainingTime,function(i,n){
    	$("#plan-select-content").append("<option class='select-type' value='"+n.trainingTime+"'>"+
    										n.visualTime+"</option>");
    });
    $("#plan-select-content").change(function(){
    	plan["trainingTime"] = $(this).val();
    });

    
    var targetParent = null;
    var targetTypeId = null;
    var index = null;

    


    var choosedSkillData = {};
    var choosedPhysicalData = {};
    var modalTitle = '';
    var isEle = {
        "isLimitedTime":["Limited Time","Non-Limited Time"],
        "isContinuous":["Continuous","Non-Continuous"],
        "isMoved":["Move","Fixed"],
        "isMultiple":["Multi-Ball","Bandy"],
        "isTarget":["Target","Non-Target"]
    };
    var isCheck = {
        "Limited Time":"checked",
        "Continuous":"checked",
        "Move":"checked",
        "Multi-Ball":"checked",
        "Target":"checked",
        "Non-Limited Time":"",
        "Non-Continuous":"",
        "Fixed":"",
        "Bandy":"",
        "Non-Target":"",
    };
    var specialTraining = [];
    //加载技能类大项的子项
    //1.获得所有plan-content
    $(".plan-content").each(function (i,n) {
        //2.获得index
        var index = $(n).find("h5").attr("name");

        var contents = skillData[index].children;
        for (var k in contents){
            $(n).find("div.btn-group").append("<label id="+contents[k].id+" class='btn btn-outline-success waves-light waves-effect' >" +
                                                    "<input type='checkbox' name='"+contents[k].typeName+"' value="+contents[k].id+">"+contents[k].typeName+
                                                "</label>");
        }
    });
    //为add按钮绑定事件
    $(".btn-addcourse").click(function () {
        //1. 找到选中的那些项目
        var flag = true;
        var labels = $(this).siblings(".btn-group").find("label");
        $(labels).each(function (i,n) {
            if ($(this).hasClass("active") == true && $(this).hasClass("disabled") == false){
                //2. 加入到div里
                var typeName = $(this).children().attr("name");
                var typeOfSkill = $(this).children().val();
                $(this).parents(".card-body").append("<div id='tuple"+typeOfSkill+"' class='card'>"+
                                                            "<a class='collapsed text-dark pop-up' data-toggle='modal' data-target='#myModal' data-parent='#skillCat' href='#collapseLevelTwo11' aria-expanded='false' aria-controls='collapseLevelTwo11'>"+
                                                                "<div class='card-header second-type' role='tab'>"+
                                                                    "<i class='fa fa-check'hidden></i>"+
                                                                    "<h6 class='mb-0 mt-0'>"+typeName+"</h6>"+
                                                                    "<input type='hidden' name='"+typeName+"' value='"+typeOfSkill+"'>"+
                                                                    "<a></a><i class='mdi mdi-close-circle delete-icon'></i>"+
                                                                "</div>"+
                                                            "</a>"+
                                                        "</div>");
                //3. 禁用选中的checkbox class='btn btn-success waves-light waves-effect disabled'
                $(this).attr("class","btn btn-success waves-light waves-effect disabled");

                //4.绑定删除事件
                $(".delete-icon").click(function () {
                    $(this).parent("div").parent("div").remove();
                    //5. 解禁禁用选中的checkbox class='btn btn-success waves-light waves-effect disabled'
                    //并且删除choosedData中的数据，如果有
                    var id = $(this).siblings("a").children("input[type=hidden]").val();
                    $("#"+id).attr("class","btn btn-outline-success waves-light waves-effect");
                    delete choosedSkillData[id];
                });

                //6. 绑定弹框事件
                $(".pop-up").click(function () {
                    var typeName = $(this).find("input[type=hidden]").attr("name");
                    var typeOfSkill = $(this).find("input[type=hidden]").val();

                    //目标内容的id
                    targetTypeId = typeOfSkill;
                    if ((targetTypeId in choosedSkillData )) {//如果之前选过，数据回显
                        var data = choosedSkillData[targetTypeId];
                        var clickCheckbox = Array.prototype.slice.call(document.querySelectorAll('.js-check-click'));
                        $(clickCheckbox).each(function (i,n) {
                            var k = $(n).attr("name");
                            $(n).val(data[k]);
                            if(isCheck[data[k]] == "checked" && n.checked == false){
                                $(n).trigger('click');
                                $(n).prop("checked",true);
                            }else if (isCheck[data[k]] != "checked" && n.checked == true){
                                $(n).trigger('click');
                                $(n).prop("checked",false);
                            }
                        });
                        $("#myModal input[type=checkbox]").each(function (i,n) {
                            var k = $(n).attr("name");
                            $(n).val(data[k]);
                            $(n).prop(isCheck[data[k]],true);
                        });
                        $("#myModal input[type=number]").each(function (i,n) {
                            var k = $(n).attr("name");
                            $(n).val(data[k]);
                        });
                        $("#myModal input[type=radio]").each(function (i,n) {
                            var k = $(n).attr("name");
                            var dValue = data[k];
                            if ($(n).val() == dValue)
                                $(n).prop("checked",true);
                            else
                                $(n).prop("checked",false);
                        });
                    }else{//否则初始化modal
                        var clickCheckbox = Array.prototype.slice.call(document.querySelectorAll('.js-check-click'));
                        $(clickCheckbox).each(function (i,n) {
                            if(n.checked == true){
                                $(n).val(isEle[$(n).attr("name")][0]);
                                $(n).trigger('click');
                                $(n).prop("checked",false);
                            }
                        });
                        /*$("#myModal input[type=checkbox]").prop("checked",false);*/
                        $("#myModal input[type=number]").val('');
                        $("#myModal input[type=radio]").removeAttr("checked");
                        $("#radio1").prop("checked",true);
                    }
                    $("#myModal h4").text(typeName);
                    $("#myModal input[name=typeOfSkill]").val(typeOfSkill);
                });
            }
        });


    });
    //checkbox绑定事件
    $("#myModal input[type=checkbox]").change(function(){
        var key = $(this).attr("name");
        if($(this).is(":checked") == true){
            if (key == "isLimitedTime") {
                $("#requiredTime").show();
            }else if(key == "isTarget"){
                $("#numberSuccess").show();
            }
            $(this).val(isEle[key][0]);
        }else{
            if (key == "isLimitedTime") {
                $("#requiredTime input[name=requiredTime]").val('');
                $("#requiredTime").hide();
            }else if(key == "isTarget"){
                $("#numberSuccess input[name=numOfSuccess]").val('');
                $("#numberSuccess").hide();
            }
            $(this).val(isEle[key][1]);
        }
    });
    //教练选择完具体内容后，绑定点击事件
    $("#storeDataBtn").click(function () {
        var data = {};
        var isLimit = false;
        var isTarget = false;
        //得到选项的id
        var typeOfSkill = $("#myModal input[name=typeOfSkill]").val();

        //得到is什么那些checkbox的k,v
        var checkbox = $("#myModal input[type=checkbox]");
        $(checkbox).each(function(i,n){
            var k = $(n).attr("name");
            var v = $(n).val();
            data[k] = v;
            if (k == "isLimitedTime" && v == "Limited Time") isLimit = true;
            if (k == "isTarget" && v == "Target") isTarget = true;
        });
        //得到数字标签
        var complete = true;
        var numbers = $("#myModal input[type=number]");
        $(numbers).each(function (i,n) {
            var k = $(n).attr("name");
            var v = $(n).val();
            if((k == "groupNum" && (v == ''||v == 0))
                || (k == "countNumOfGroup" && (v == ''|| v == 0) )){
                $(n).addClass("error");
                setTimeout(function () {
                    $(n).removeClass("error");
                },2000);
                complete = false;
            }else if(isLimit == true && k == "requiredTime" && (v == ''||v==0)){
                $(n).addClass("error");
                setTimeout(function () {
                    $(n).removeClass("error");
                },2000);
                complete = false;
            }else if(isTarget == true && k == "numOfSuccess" && (v == ''||v == 0)){
                $(n).addClass("error");
                setTimeout(function () {
                    $(n).removeClass("error");
                },2000);
                complete = false;
            }else{
                data[k] = v;
            }
        });
        //获得isCombine
        var type = $("#myModal input[type=radio]:checked").attr("name");
        var typeV = $("#myModal input[type=radio]:checked").val();
        data[type] = typeV;

        data["typeOfSkill"] = typeOfSkill;

        //保存到choosedData中
        if (complete == true) {
            choosedSkillData[typeOfSkill] = data;
            $("#myModal .close").click();
            $("#tuple"+typeOfSkill).find(".fa-check").removeAttr("hidden");
            $("#tuple"+typeOfSkill).children("div").css("background-color","#0acf97");
        }
    });

    //加载体能类大项的子项
    //1.获得技能类大项的子项
    $(".physical-content").each(function (i,n) {
        var index = $(n).find("h5").attr("name");
        if (index == 1) specialTraining = physicalData[index].children;
        var contents = physicalData[index].children;
        if (index != 1) {
            for (var k in contents) {
                $(n).find("div.btn-group").append("<label id=" + contents[k].id + " class='btn btn-outline-success waves-light waves-effect' >" +
                    "<input type='checkbox' name='" + contents[k].typeName + "' value=" + contents[k].id + ">" + contents[k].typeName +
                    "<input type='hidden' name='unit' value='" + contents[k].unitName + "'>" +
                    "<input type='hidden' name='specialIndex' value='" + k + "'>" +
                    "</label>");

            }
        }else{
            for(var i in specialTraining){
                $(n).children("div.collapse").children("div").append("<div class='special-training-content'>\n" +
                                                                        "\t<a data-toggle='collapse' href='#"+specialTraining[i].id+"' class='text-dark' aria-expanded='true' aria-controls='\"+specialTraining[i].id+\"'>\n" +
                                                                        "\t\t<div class='card-header second-type no-margin-bottom' role='tab'>\n" +
                                                                        "\t\t\t<i class='fa fa-check'hidden></i>\n" +
                                                                        "\t\t\t<h6 class='mb-0 mt-0'>"+specialTraining[i].typeName+"</h6>\n" +
                                                                        "\t\t\t<span class='badge badge-custom badge-pill noti-icon-badge'></span>\n" +
                                                                        "\t\t\t<input type='hidden'>\n" +
                                                                        "\t\t\t<!--<i class='mdi mdi-arrow-down-drop-circle'></i>-->\n" +
                                                                        "\t\t\t<i class=' mdi mdi-arrow-right-drop-circle'></i>\n" +
                                                                        "\t\t</div>\n" +
                                                                        "\t</a>\n" +
                                                                        "\t<div id='"+specialTraining[i].id+"' class='collapse no-margin-top' role='tabpanel' aria-labelledby='headingOne1'>\n" +
                                                                        "\t\t<div class='card-body second-card-body'>\n" +
                                                                        "\t\t\t<div class='select'>\n" +
                                                                        "\t\t\t\t<div class='btn-group' data-toggle='buttons'>\n" +
                                                                        "\t\t\t\t</div>\n" +
                                                                        "\t\t\t\t<button class='btn btn-custom btn-addPhysical' style='margin-bottom: 10px;'>Add</button>\n" +
                                                                        "\t\t\t</div>\n" +
                                                                        "\t\t\t<div class='clearfix'></div>\n" +
                                                                        "\t\t</div>\n" +
                                                                        "\t</div>\n" +
                                                                        "</div>");




                //加载子内容
                var sonsOfson  = specialTraining[i].children;
                for(var j in sonsOfson) {
                    $("#"+specialTraining[i].id).find("div.btn-group").append("<label id=" + sonsOfson[j].id + " class='btn btn-outline-success waves-light waves-effect'>" +
                        "<input type='checkbox' name='" + sonsOfson[j].typeName + "' value='" + sonsOfson[j].id + "'>" + sonsOfson[j].typeName +
                        "<input type='hidden' name='unit' value='" + sonsOfson[j].unitName + "'>" +
                        "<input type='hidden' name='specialIndex' value='" + j + "'>" +
                        "</label>");
                }
            }
            //绑定下拉点击事件
            $(".special-training-content a.text-dark").click(function () {
                if($(this).siblings("div").hasClass("show"))
                    $(this).children("div").children("i:last-child").attr("class","mdi mdi-arrow-right-drop-circle");
                else
                    $(this).children("div").children("i:last-child").attr("class","mdi mdi-arrow-down-drop-circle");

            });
        }
    });
    //2.为add按钮绑定事件
    $(".btn-addPhysical").click(function () {
        //1. 找到选中的那些项目
        var labels = $(this).siblings(".btn-group").find("label");
        $(labels).each(function (i,n) {
            if ($(this).hasClass("active") == true && $(this).hasClass("disabled") == false){
                //2. 加入到div里
                var typeName = $(this).children("input[type=checkbox]").attr("name");
                var typeOfSkill = $(this).children("input[type=checkbox]").val();
                var unitName = $(this).children("input[name=unit]").val();
                if(unitName != '' && unitName != undefined ){
                    $(this).closest(".card-body").append("<div class='form-group physical-level1'>" +
                                                            "<i class='fa fa-check'hidden></i>"+
                                                            "<label class='col-form-label'>"+typeName+"</label>" +
                                                            "<a class='delete-icon'><i class='mdi mdi-close-circle'></i></a>" +
                                                            "<div class='inputNumber'>" +
                                                                "<i>"+unitName+"</i>" +
                                                                "<input name='"+typeOfSkill+"' type='number' class='form-control' placeholder='0-100' min='0' max='100'>" +
                                                            "</div>" +
                                                        "</div>");
                    //5.绑定删除事件
                    $(".delete-icon").click(function () {

                        //5. 解禁禁用选中的checkbox class='btn btn-success waves-light waves-effect disabled'
                        //并且删除choosedData中的数据，如果有
                        var id = $(this).siblings("div.inputNumber").children("input[type=number]").attr("name");
                        $("#"+id).attr("class","btn btn-outline-success waves-light waves-effect");
                        delete choosedPhysicalData[id];
                        var info = Number($(this).parents(".special-training-content").find("span").text());

                        var value = $(this).siblings("div").children("input[type=number]").val();
                        if(value != '' && value != 0) {
                            if (info > 1) {
                                $(this).parents(".special-training-content").find("span").text(info - 1);
                            } else {
                                $(this).parents(".special-training-content").find("span").text(null);
                            }
                        }
                        $(this).parent("div").remove();
                    });
                }

                //3.为input绑定blur和focus事件
                $(".inputNumber input[type=number]").focus(function () {
                    $(this).css("background-color","#FFFFCC");
                    $(this).parent("div").css("background-color","#FFFFCC");
                });
                $(".inputNumber input[type=number]").blur(function () {
                    var id = $(this).attr("name");
                    var info = Number($(this).parents(".special-training-content").find("span").text());
                    if($(this).val() != ''&& $(this).val() != 0){
                        $(this).css("background-color","#D6D6FF");
                        $(this).parent("div").css("background-color","#D6D6FF");
                        $(this).parents(".physical-level1").css("background-color","#0acf97");
                        $(this).parents(".physical-level1").children(".fa-check").removeAttr("hidden");


                        //记录数据
                        var data = {"physicalType":id,"count":$(this).val()};


                        if (info == 0){
                            $(this).parents(".special-training-content").find("span").text(1);
                        } else if (info != 0 && (id in choosedPhysicalData) == false){

                            $(this).parents(".special-training-content").find("span").text(info + 1);
                        }
                        choosedPhysicalData[id] = data;
                    }else if ($(this).val() == 0 ||$(this).val() == '' ) {
                        $(this).css("background-color","#fff");
                        $(this).parent("div").css("background-color","#fff");
                        $(this).parents(".physical-level1").css("background-color","#dee2e6");
                        $(this).parents(".physical-level1").children(".fa-check").attr("hidden",true);
                        if (id in choosedPhysicalData) {
                            delete choosedPhysicalData[id];
                            if (info != 0){
                                $(this).parents(".special-training-content").find("span").text(info - 1);
                                if (info - 1 == 0)
                                    $(this).parents(".special-training-content").find("span").text(null);
                            }
                        }
                    }
                });
                //4. 禁用选中的checkbox class='btn btn-success waves-light waves-effect disabled'
                $(this).attr("class","btn btn-success waves-light waves-effect disabled");
            }
        });
    });
    
    $("#submitBtn").click(function () {
    	var physicalDetails = [];
    	var skillDetails = [];
    	for(var k in choosedPhysicalData){
    		physicalDetails.push(choosedPhysicalData[k]);
    	}
    	for(var k in choosedSkillData){
    		skillDetails.push(choosedSkillData[k]);
    	}
    	if(typeof(plan["trainingTime"]) == "undefined"||plan["trainingTime"]==null){
    		$("#plan-select-content").addClass("error");
    		$("#alertInfo").html("<strong>Training Time Missing</strong>");
    		$("#alertInfo").show();
            setTimeout(function () {
            	$("#plan-select-content").removeClass("error");
                $("#alertInfo").hide();
            },2000);
    	}else if(skillDetails.length == 0){
    		$("#alertInfo").html("<strong>Skills Part Missing</strong>");
    		$("#alertInfo").show();
            setTimeout(function () {
                $("#alertInfo").hide();
            },2000);
    	}else if(physicalDetails.length == 0){
    		$("#alertInfo").html("<strong>Physical Part Missing</strong>");
    		$("#alertInfo").show();
            setTimeout(function () {
                $("#alertInfo").hide();
            },2000);
    	}else{
    		subData["plan"] = plan;
    		subData["physicalDetails"] = physicalDetails;
    		subData["skillDetails"] = skillDetails;
    		$.ajax({
    			url:"http://www.vport.com/rest/course/addNewPlan",
    			type:"post",
    			dataType:"json",
    			contentType:"application/json",
    			data:JSON.stringify(subData),
    			success:function(res){
    				if(res == 1){
    					window.location.href = "http://www.vport.com/rest/course/classInfoByClassId?classId="+$("#classId").val();
    				}else if (res == 0){
    					$("#alertInfo").html("<strong>Wrong Submission, please submit again!</strong>");
    		    		$("#alertInfo").show();
    		            setTimeout(function () {
    		                $("#alertInfo").hide();
    		            },2000);
    				}
    			}
    			
    		});
    	}
        
    });

});