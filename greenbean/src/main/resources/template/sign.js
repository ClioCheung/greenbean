(function () {
    $(function () {
        const activeClassName = "active";
        const hideFormClassName = "hideForm";
        const signInTab = $("#signInTab");
        const signUpTab = $("#signUpTab");
        const signInForm = $("#signInForm");
        const signUpForm = $("#signUpForm");

        const signInObject = {
            tab: signInTab,
            form: signInForm
        };

        const signUpObject = {
            tab: signUpTab,
            form: signUpForm
        };

        const signObjectArray = [signInObject, signUpObject];

        let handlerDataObject = {
            activeClassName: activeClassName,
            hideFormClassName: hideFormClassName,
            signObjectArray: signObjectArray
        };

        const tabOnClickHandler = function (event) {
            handlerDataObject = event.data;
            const tabDomObject = $(event.target);
            for (let i = 0; i < signObjectArray.length; i++) {
                if (signObjectArray[i].tab.is(tabDomObject)) {
                    if (!tabDomObject.hasClass(handlerDataObject.activeClassName)) {
                        tabDomObject.addClass(handlerDataObject.activeClassName);
                        signObjectArray[i].form.removeClass(handlerDataObject.hideFormClassName);
                    }
                } else {
                    signObjectArray[i].tab.removeClass(handlerDataObject.activeClassName);
                    signObjectArray[i].form.addClass(handlerDataObject.hideFormClassName);
                }
            }
        };

        for (let i = 0; i < signObjectArray.length; i++) {
            signObjectArray[i].tab.on("click",handlerDataObject, tabOnClickHandler);
        }

        signUpForm.validate({
            // TODO 验证username、password的长度
            // FIXME 用户名重复时，提示信息是false (text -> jason)
            // XXX 验证用户名重复
            rules: {
                username: {
                    required: true,
                    remote: {
                        url: "signUp/validateUsername",
                        type: "GET",
                        data: {
                            username: function(){
                                return $("#userNameSignUp").val();
                            }
                        },
                        dataType: "text"
                    }
                },
                password: {
                    required: true
                },
                confirmPassword: {
                    required: true,
                    equalTo: "#passwordSignUp"
                }
            },
            messages: {
                username: {
                    required: "Please fill in your username.",
                    remote: "This username already exists."
                }
            },
            validClass: "is-valid",
            errorClass: "is-invalid",
            errorElement: "div",
            showErrors: function () {
                this.defaultShowErrors();
                $("div.is-invalid").addClass("invalid-feedback");
            },
        });
    });
})();