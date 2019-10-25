(function () {
    $(function () {
        const signOutLink = $("#signOutLink");
        const signOutForm = $("#signOutForm");
        signOutLink.on("click",function () {
            signOutForm.submit();
        })
    });
})();