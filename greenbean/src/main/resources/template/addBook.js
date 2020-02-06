(function () {
    $(function(){
        debugger;
        const nextButton = $('#nextButton');
        const cancelButton = $('#cancelButton');
        nextButton.on("click",function(){
            // TODO first step ： 验证ISBN
            $('.d-none').removeClass("d-none");
            $('#isbn').attr('readonly','');
        })
    });
})();