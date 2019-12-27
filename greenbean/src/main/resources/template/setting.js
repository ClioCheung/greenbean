// TODO 验证表单
(function () {
    $(function () {
        const updateSettingsButton = $("#updateSettingsButton");
        updateSettingsButton.on("click", function () {
            debugger;

            const nicknameObject = {
                nickname : $("#nicknameInput").val()
            };
            const headerObject = {};
            headerObject[csrfObject.headerName] = csrfObject.token;

            $.ajax({
                url : "updateSettings",
                method : "POST",
                headers : headerObject,
                contentType : 'application/json',
                data : JSON.stringify(nicknameObject)
            }).done(function () {
            //    TODO  the message of success!
            });
        });
    });
})();