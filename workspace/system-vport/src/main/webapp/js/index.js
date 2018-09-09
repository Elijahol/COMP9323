


$(".training-block a").mouseenter(function () {

    $(this).stop();
    var json = {"top": -2,
        "left": -6,
        "width": 367,
        "height": 214};
    $(this).animate(json,200);
})
$(".training-block a").mouseleave(function () {
    $(this).stop();
    var json = {
        "width": 355,
        "height": 205,
        "top": +2,
        "left": +1,};
    $(this).animate(json,200);
})
var color = null;
$(".view-course-icon").mouseenter(function () {
    var viewCourse = $(".view-course");
    viewCourse.animate({"left":8},300);
    color = viewCourse.css("color");
    viewCourse.css("color", "grey");
})
$(".view-course-icon").mouseleave(function () {
    var viewCourse = $(".view-course");
    viewCourse.animate({"left":0},300);
    viewCourse.css("color",color);
})

// $.stellar({
//     horizontalScrolling: false,
//     responsive: true
// });
$(".bg").stellar();