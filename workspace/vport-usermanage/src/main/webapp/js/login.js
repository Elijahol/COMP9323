
$("input[name=email]").on('invalid',function () {
    this.setCustomValidity("Please enter the correct email");
});
$("input[name=password]").on('invalid',function () {
    this.setCustomValidity("Please enter the correct password");
});
$("input[name=username]").on('invalid',function () {
    this.setCustomValidity("Please enter the username");
});

$(".logbt").on('click', function () {
    $(".login-form").css("display", "block");
    $(".signup-form").css("display", "none");
})
$(".signbt").on('click', function () {
    $(".login-form").css("display", "none");
    $(".signup-form").css("display", "block");
})

$(".login-form .button").click(function () {
    // alert(1);
    $.ajax({
        url:'',
        type: 'post',
        data:$('.login-form').serialize(),
        dataType: 'json',
        success: function(res) {
            alert(res);
        }
    })
});

$(".signup-form .button").click(function () {
    // alert(2);
    $.ajax({
        url:'',
        type: 'post',
        data:$('.signup-form').serialize(),
        dataType: 'json',
        success: function(res) {
            alert(res);
        }
    })
});
