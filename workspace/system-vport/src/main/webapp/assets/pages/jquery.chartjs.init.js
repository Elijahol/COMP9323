/**
Template Name: Highdmin - Responsive Bootstrap 4 Admin Dashboard
Author: CoderThemes
Email: coderthemes@gmail.com
File: Chartjs
*/


!function($) {
    "use strict";

    var ChartJs = function() {};

    ChartJs.prototype.respChart = function(selector,type,data, options) {
        // get selector by context
        var ctx = selector.get(0).getContext("2d");
        // pointing parent container to make chart js inherit its width
        var container = $(selector).parent();

        // enable resizing matter
        $(window).resize( generateChart );

        // this function produce the responsive Chart JS
        function generateChart(){
            // make chart width fit with its container
            var ww = selector.attr('width', $(container).width() );
            switch(type){
                case 'Line':
                    new Chart(ctx, {type: 'line', data: data, options: options});
                    break;
                case 'Doughnut':
                    new Chart(ctx, {type: 'doughnut', data: data, options: options});
                    break;
                case 'Pie':
                    new Chart(ctx, {type: 'pie', data: data, options: options});
                    break;
                case 'Bar':
                    new Chart(ctx, {type: 'bar', data: data, options: options});
                    break;
                case 'Radar':
                    new Chart(ctx, {type: 'radar', data: data, options: options});
                    break;
                case 'PolarArea':
                    new Chart(ctx, {data: data, type: 'polarArea', options: options});
                    break;
            }
            // Initiate new chart or Redraw

        };
        // run function - render chart at first load
        generateChart();
    },

    //init
    ChartJs.prototype.init = function() {
        
        //skills
        var skillsLastTimeData = [];
        var skillsAverageData = [];
        var skillsByTimeData = [];
        var skillsByTimeLabel = []
        var skillsScoreByTime=[];
        //physical ability
        var physicalLastTimeData = [];
        var physicalAverageData = [];
        var physicalByTimeData = [];
        var physicalScoreByTime=[];
        //end
        

      //ajax get arrays 
        var studentId = $("#studentId").text();
        console.log(studentId);
        $.ajax({
			url:"http://www.vport.com/rest/common/showData?id="+studentId,
			async:false,
			type:"get",
			dataType:"json",
			success:function(data){
				console.log(data);
				//skillsByTimeLabel
				$(data.skillsByTimeData).each(function(i,n){
					skillsByTimeLabel[i] = n.visualTime;
				});
				
				//skillsLastTimeData
				$(data.skillsLastTimeData).each(function(i,n){
					skillsScoreByTime[i] = new Array();
					for(var j = 0; j < skillsByTimeLabel.length;j++){
						skillsScoreByTime[i][j] = 0;
					}
					skillsLastTimeData[i] = n.score;
				});
				//skillsAverageData
				$(data.skillsAverageData).each(function(i,n){
					skillsAverageData[i] = n.score;
				});
				//skillsByTimeData
				$(data.skillsByTimeData).each(function(i,n){
					skillsByTimeData[i] = n.score;
				});
				
				
				//skillsScoreByTime
				for(var i = 0; i < data.skillsScoreByTime.length;i++){
					for(var j = 0; j < data.skillsScoreByTime[i].length;j++){
						skillsScoreByTime[j][i] = data.skillsScoreByTime[i][j].score * 100 /5;
					}
				}
				
				//physicalLastTimeData
				$(data.physicalLastTimeData).each(function(i,n){
					physicalScoreByTime[i] = new Array();
					for(var j = 0; j < skillsByTimeLabel.length;j++){
						physicalScoreByTime[i][j] = 0;
					}
					physicalLastTimeData[i] = n.score;
				});
				//physicalAverageData
				$(data.physicalAverageData).each(function(i,n){
					physicalAverageData[i] = n.score;
				});
				//physicalByTimeData
				$(data.physicalByTimeData).each(function(i,n){
					physicalByTimeData[i] = n.score;
				});
				
				//physicalScoreByTime
				for(var i = 0; i < data.physicalScoreByTime.length;i++){
					for(var j = 0; j < data.physicalScoreByTime[i].length;j++){
						physicalScoreByTime[j][i] = data.physicalScoreByTime[i][j].score * 100 /5;
					}
				}
				
			}
		});
        
        
        
        //

        var skillsLabel = ["Front Hand", "Back Hand", "Front Volley", "Back Volley", "Smash", "serve"];
        var physicalLabel = ["Speed", "Strength", "Explosive Force", "Flexibility", "Coordination"];
       //class data
        var classId = $("#classId").val();
        if(classId != ''&&　typeof classId != "undefined"){
        	var classSkillsAverageData = [65, 59, 90, 81, 56, 55];
            var classPhysicalAverageData = [59, 90, 81, 56, 55];
        	console.log("classID: " + classId);
        	$.ajax({
    			url:"http://www.vport.com/rest/performance/suggestion?classId="+classId,
    			async:false,
    			type:"get",
    			dataType:"json",
    			success:function(data){
    				console.log("sec:" +data);
    				$("#suggestion").append(data["advice"]);
    				$.each(data.physical,function(i,n){
    					classPhysicalAverageData[i] = n.score;
    				});
    				$.each(data.skills,function(i,n){
    					classSkillsAverageData[i] = n.score;
    				});
    			}
        	});
        	 
             var classSkillsRadarChart = {
                 labels: skillsLabel,
                 datasets: [
                     {
                         label: "Skills",
                         backgroundColor: "rgba(2, 192, 206, 0.3)",
                         borderColor: "#02c0ce",
                         pointBackgroundColor: "#EC492A",
                         pointBorderColor: "#fff",
                         pointHoverBackgroundColor: "#fff",
                         pointHoverBorderColor: "#02c0ce",
                         data: classSkillsAverageData
                     }
                 ]
             };
             var classPhysicalRadarChart = {
                 labels: physicalLabel,
                 datasets: [
                     {
                         label: "Physical Ability",
                         backgroundColor: "rgba(2, 192, 206, 0.3)",
                         borderColor: "#02c0ce",
                         pointBackgroundColor: "#EC492A",
                         pointBorderColor: "#fff",
                         pointHoverBackgroundColor: "#fff",
                         pointHoverBorderColor: "#02c0ce",
                         data: classPhysicalAverageData
                     }
                 ]
             };
             this.respChart($("#classSkills"),'Radar',classSkillsRadarChart);
             this.respChart($("#classPhysical"),'Radar',classPhysicalRadarChart);
        }
       
        // 

        var skillsRadarChart = {
            labels: skillsLabel,
            datasets: [
                {
                    label: "The last time",
                    backgroundColor: "rgba(2, 192, 206, 0.3)",
                    borderColor: "#02c0ce",
                    pointBackgroundColor: "#02c0ce",
                    pointBorderColor: "#fff",
                    pointHoverBackgroundColor: "#fff",
                    pointHoverBorderColor: "#02c0ce",
                    data: skillsLastTimeData
                },
                {
                    label: "Average",
                    backgroundColor: "rgba(179,181,198,0.2)",
                    borderColor: "rgba(179,181,198,1)",
                    pointBackgroundColor: "rgba(179,181,198,1)",
                    pointBorderColor: "#fff",
                    pointHoverBackgroundColor: "#fff",
                    pointHoverBorderColor: "rgba(179,181,198,1)",
                    data: skillsAverageData
                }
            ]
        };
        this.respChart($("#skills"),'Radar',skillsRadarChart);
        

        //barchart
        var skillsBarChart = {
            labels: skillsByTimeLabel,
            datasets: [
                {
                    label: "Average Score",
                    backgroundColor: "rgba(2, 192, 206, 0.3)",
                    borderColor: "#02c0ce",
                    borderWidth: 1,
                    hoverBackgroundColor: "rgba(2, 192, 206, 0.7)",
                    hoverBorderColor: "#02c0ce",
                    data: skillsByTimeData
                }
            ]
        };
        this.respChart($("#skillsByTime"),'Bar',skillsBarChart);

        //creating lineChart
        var skillsLineChart = {
            labels: skillsByTimeLabel,
            datasets: [{
                label: "Front Hand",
                fill: false,
                backgroundColor: "#02c0ce",
                borderColor: "#02c0ce",
                data: skillsScoreByTime[0],
            }, {
                label: "Back Hand",
                fill: false,
                backgroundColor: "#7DCEA0",
                borderColor: "#7DCEA0",
                data: skillsScoreByTime[1]
            },{
               label: "Front Volley",
                fill: false,
                backgroundColor: '#F7DC6F',
                borderColor: "#F7DC6F",
                data: skillsScoreByTime[2]
            },
            {
               label: "Back Volley",
                fill: false,
                backgroundColor: '#F0B27A',
                borderColor: "#F0B27A",
                data: skillsScoreByTime[3]
            },
            {
               label: "Smash",
                fill: false,
                backgroundColor: '#F1948A',
                borderColor: "#F1948A",
                data: skillsScoreByTime[4]
            },
            {
               label: "serve",
                fill: false,
                backgroundColor: '#808B96',
                borderColor: "#808B96",
                data: skillsScoreByTime[5]
            },
            ]
        };

        var lineOpts = {
            animation: {
                duration: 700, // general animation time
            },

            responsive: true,
            // title:{
            //     display:true,
            //     text:'Chart.js Line Chart'
            // },
            tooltips: {
                mode: 'index',
                intersect: false
            },
            hover: {
                animationDuration: 500,
                mode: 'nearest',
                intersect: true
            },
            scales: {
                xAxes: [{
                    display: true,
                    // scaleLabel: {
                    //     display: true,
                    //     labelString: 'Month'
                    // },
                    gridLines: {
                        color: "rgba(0,0,0,0.1)"
                    }
                }],
                yAxes: [{
                    gridLines: {
                        color: "rgba(255,255,255,0.05)",
                        fontColor: '#fff'
                    },
                    ticks: {
                        max: 100,
                        min: 0,
                        stepSize: 10
                    }
                }]
            },
            responsiveAnimationDuration: 500,
        };

        this.respChart($("#skillsByScore"),'Line',skillsLineChart, lineOpts);


        
        var physicalRadarChart = {
            labels: physicalLabel,
            datasets: [
                {
                    label: "The last time",
                    backgroundColor: "rgba(2, 192, 206, 0.3)",
                    borderColor: "#02c0ce",
                    pointBackgroundColor: "#02c0ce",
                    pointBorderColor: "#fff",
                    pointHoverBackgroundColor: "#fff",
                    pointHoverBorderColor: "#02c0ce",
                    data: physicalLastTimeData
                },
                {
                    label: "Average",
                    backgroundColor: "rgba(179,181,198,0.2)",
                    borderColor: "rgba(179,181,198,1)",
                    pointBackgroundColor: "rgba(179,181,198,1)",
                    pointBorderColor: "#fff",
                    pointHoverBackgroundColor: "#fff",
                    pointHoverBorderColor: "rgba(179,181,198,1)",
                    data: physicalAverageData
                }
            ]
        };
        this.respChart($("#physical"),'Radar',physicalRadarChart);
        //barchart
        var physicalBarChart = {
            labels: skillsByTimeLabel,
            datasets: [
                {
                    label: "Average Score",
                    backgroundColor: "rgba(2, 192, 206, 0.3)",
                    borderColor: "#02c0ce",
                    borderWidth: 1,
                    hoverBackgroundColor: "rgba(2, 192, 206, 0.7)",
                    hoverBorderColor: "#02c0ce",
                    data: physicalByTimeData
                }
            ]
        };
        this.respChart($("#phsicalByTime"),'Bar',physicalBarChart);
        //creating lineChart
        var physicalLineChart = {
            labels: skillsByTimeLabel,
            datasets: [{
                label: "Speed",
                fill: false,
                backgroundColor: "#02c0ce",
                borderColor: "#02c0ce",
                data: physicalScoreByTime[0],
            }, {
                label: "Strength",
                fill: false,
                backgroundColor: "#7DCEA0",
                borderColor: "#7DCEA0",
                data: physicalScoreByTime[1]
            },{
               label: "Explosive Force",
                fill: false,
                backgroundColor: '#F7DC6F',
                borderColor: "#F7DC6F",
                data: physicalScoreByTime[2]
            },
            {
               label: "Flexibility",
                fill: false,
                backgroundColor: '#F0B27A',
                borderColor: "#F0B27A",
                data: physicalScoreByTime[3]
            },
            {
               label: "Coordination",
                fill: false,
                backgroundColor: '#F1948A',
                borderColor: "#F1948A",
                data: physicalScoreByTime[4]
            },
            ]
        };

        this.respChart($("#physicalByScore"),'Line',physicalLineChart, lineOpts);
        

        

        //Polar area chart
        // var polarChart = {
        //     datasets: [{
        //         data: [
        //             11,
        //             16,
        //             7,
        //             18
        //         ],
        //         backgroundColor: [
        //             "#297ef6",
        //             "#45bbe0",
        //             "#ebeff2",
        //             "#1ea69a"
        //         ],
        //         label: 'My dataset', // for legend
        //         hoverBorderColor: "#fff"
        //     }],
        //     labels: [
        //         "Series 1",
        //         "Series 2",
        //         "Series 3",
        //         "Series 4"
        //     ]
        // };
        // this.respChart($("#polarArea"),'PolarArea',polarChart);
        //donut chart
        // var donutChart = {
        //     labels:skillsLabel,
        //     datasets: [
        //         {
        //             data: skillsAverageData,
        //             backgroundColor: [
        //                 "#02c0ce",
        //                 "#4eb7eb",
        //                 "#e3eaef",
        //                 "#2d7bf4",
        //                 "#98a6ad"
        //             ],
        //             hoverBackgroundColor: [
        //                 "#02c0ce",
        //                 "#4eb7eb",
        //                 "#e3eaef",
        //                 "#2d7bf4",
        //                 "#98a6ad"
        //             ],
        //             hoverBorderColor: "#fff"
        //         }]
        // };
        // this.respChart($("#skillsByScore"),'Doughnut',donutChart);

        //Pie chart
        // var pieChart = {
        //     labels:skillsLabel,
        //     datasets: [
        //         {
        //             data: skillsAverageData,
        //             backgroundColor: [
        //                 "#02c0ce",
        //                 "#4eb7eb",
        //                 "#e3eaef",
        //                 "#2d7bf4",
        //                 "#98a6ad"
        //             ],
        //             hoverBackgroundColor: [
        //                 "#02c0ce",
        //                 "#4eb7eb",
        //                 "#e3eaef",
        //                 "#2d7bf4",
        //                 "#98a6ad"
        //             ],
        //             hoverBorderColor: "#fff"
        //         }]
        // };
        // this.respChart($("#skillsByScore"),'Pie',pieChart);
    },
    $.ChartJs = new ChartJs, $.ChartJs.Constructor = ChartJs

}(window.jQuery),

//initializing
function($) {
    "use strict";
    $.ChartJs.init()
}(window.jQuery);

