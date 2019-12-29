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
                $('.toast').toast('show');
            }).fail(function () {

            });
            $('.toast').toast({delay : 2000});
        });
    });
})();