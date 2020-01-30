(function () {
    $(function () {
        const settingsForm = $("#settingForm");
        settingsForm.validate({
            rules : {
                nickname : {
                    required : true
                }
            },
            message : {
                nickname : {
                    required : "Please input your nickname."
                }
            },
            validClass: "is-valid",
            errorClass: "is-invalid",
            errorElement: "div",
            showErrors: function () {
                this.defaultShowErrors();
                $("div.is-invalid").addClass("invalid-feedback");
            },
            submitHandler : function () {
                submitOptions();
            },
            invalidHandler : function () {
                return false;
            }

        });

        function submitOptions() {
            const headerObject = {};
            headerObject[csrfObject.headerName] = csrfObject.token;

            const nickname =  $("#nicknameInput").val();
            const avatar = $("#avatarInput")[0].files[0];
            const formData = new FormData();
            formData.append("nickname", nickname);
            formData.append("avatar", avatar);

            $.ajax({
                url : "updateSettings",
                method : "POST",
                contentType : false,
                headers : headerObject,
                data : formData,
                processData : false
            }).done(function (data) {
                if(data !== undefined && data !== ""){
                    //XXX 处理URL
                    const avatarSrc = "/greenbean/static/picture/avatars/" + data;
                    const avatar = $(".avatar");
                    if(avatar.length > 0) {
                        avatar.attr("src", avatarSrc);
                    } else {
                        const avatarElement = $("<img src='' alt='avatar'>");
                        avatarElement.addClass("avatar");
                        avatarElement.attr("src", avatarSrc);
                        $(".avatarWrapperDiv").append(avatarElement);
                        // avatarElement.appendTo(".avatarWrapperDiv");
                    }
                }
                $("#userNicknameHeaderSpan").text(nickname);
                dealTips("Update successfully!", "#32CD32");
            }).fail(function () {
                dealTips("Update unSuccessfully.", "#FF0000");
            });
            $('.toast').toast({delay : 5000});

            function dealTips(message, rectcolor){
                $("#toastBody").text(message);
                $("#toastSvgRect").attr("fill",rectcolor);
                $('.toast').toast('show');
            };
        };

    });
})();