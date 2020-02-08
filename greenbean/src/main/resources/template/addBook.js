(function () {

    $(function(){
        bindNextButtonClickEvent();
        bindCancelButtonClickEvent();
        bindAddButtonClickEvent()
    });

    function bindNextButtonClickEvent() {
        const nextButton = $('#nextButton');
        nextButton.on("click",function(){
            // TODO first step ： 验证ISBN
            $('.d-none').removeClass("d-none");
            $('#isbn').attr('readonly','');
        });
    };

    function bindCancelButtonClickEvent() {
        const cancelButton = $('#cancelButton');
        cancelButton.on('click',function () {
            window.location.href="home";
        });
    };

    function bindAddButtonClickEvent(){
        const addButton = $('.addButton');
        addButton.on('click',function(event){
            debugger;
            const target = $(event.currentTarget);
            const dataNumber = target.attr("data-number");
            // TODO to do
        });

    };


})();