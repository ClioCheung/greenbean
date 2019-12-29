// TODO 验证表单
(function () {
    $(function () {
        const updateSettingsButton = $("#updateSettingsButton");
        updateSettingsButton.on("click", function () {
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
                    $(".avatar").attr("src", "/greenbean/static/picture/avatars/" + data);
                }
                $("#userNicknameHeaderSpan").text(nickname);

                dealTips("Update successfully!", "#32CD32");
            }).fail(function () {
                dealTips("Update unSuccessfully.", "#FF0000");
            });

            function dealTips(message, rectcolor){
                $("#toastBody").text(message);
                $("#toastSvgRect").attr("fill",rectcolor);
                $('.toast').toast('show');
            };
            $('.toast').toast({delay : 5000});


        });
    });
})();