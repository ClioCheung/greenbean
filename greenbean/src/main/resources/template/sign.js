(function(){
    $(document).ready(function () {
        var signInTab = $("#signInTab");
        var signUpTab = $("#signUpTab");
        var submitButton = $("#submitButton");

        signInTab.click(function(){
            if(!signInTab.hasClass("active")){
                signInTab.addClass("active");
                signUpTab.removeClass("active");
                submitButton.text("Sign In");
            }
        });
        signUpTab.click(function(){
            if(!signUpTab.hasClass("active")){
                signUpTab.addClass("active");
                signInTab.removeClass("active");
                submitButton.text("Sign Up");
            }
        });
    });

})();