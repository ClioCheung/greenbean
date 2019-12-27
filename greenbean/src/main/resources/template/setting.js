// TODO 验证表单
(function () {
    $(function () {
        const updateSettingsButton = $("#updateSettingsButton");
        updateSettingsButton.on("click", function () {
            const nicknameObject = {
                nickname : $("#nicknameInput").val()
            };
            const headerObject = {};
            headerObject[csrfObject.headerName] = csrfObject.token;

            $.ajax({
                url : "updateSettings",
                method : "POST",
                headers : headerObject,
                data : nicknameObject
            }).done(function () {
            //    TODO  the message of success!
                $("#userNicknameHeaderSpan").text(nicknameObject.nickname);
            }).fail(function () {

            });
        });
    });
})();