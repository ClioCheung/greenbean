// TODO 验证表单
(function () {
    $(function () {
        const updateSettingsButton = $("#updateSettingsButton");
        updateSettingsButton.on("click", function () {
            debugger;

            const nickname = {
                nickname : $("#nicknameInput").val()
            }

            $.ajax({
                url : "updateSettings",
                method : "POST",
                contentType : 'application/JSON',
                data : JSON.stringify(nickname)
            }).done(function () {
            //    TODO  the message of success!
            });
        });

    });
})();