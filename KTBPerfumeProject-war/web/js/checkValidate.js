$(document).ready(function() {
                var x_timer;
                $("#email").keyup(function() {
                    clearTimeout(x_timer);
                    var email = $(this).val();
                    x_timer = setTimeout(function() {
                        check_email_ajax(email);
                    }, 1000);
                });
                
                
                $("#re_pass").keyup(function() {
                    clearTimeout(x_timer);
                    var re_pass = $(this).val();
                    var pass = $(this).val();
                    x_timer = setTimeout(function() {
                        check_pass_ajax(re_pass,pass);
                    }, 1000);
                });

                function check_email_ajax(email) {
                    $("#user-result").html('<img src="images/check/ajax-loader.gif"/>');                            
                    $.post('checkEmailServlet', {'email': email}, function(data) {
                        $("#user-result").html(data);
                    });
                }
                
                function check_pass_ajax(re_pass, pass) {
                    $("#pass-result").html('<img src="images/check/ajax-loader.gif"/>');                            
                    $.post('checkConfirmPassServlet', {'re_pass': re_pass}, {'pass': pass}, function(data) {
                        $("#pass-result").html(data);
                    });
                }
            });


