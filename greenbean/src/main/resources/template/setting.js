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
                headers : headerObject,
                contentType : "multipart/form-data",
                data : formData,
                processData : false
            }).done(function () {
            //    TODO  the message of success!
                $("#userNicknameHeaderSpan").text(nickname);
                $('.toast').toast('show');
            }).fail(function () {

            });
            $('.toast').toast({delay : 2000});
        });
    });
})();