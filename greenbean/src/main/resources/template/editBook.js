(function () {
    $(function () {
        bindCancelButtonClickEvent();
    });
    
    function bindCancelButtonClickEvent() {
        const cancelButton = $('#cancelButton');
        cancelButton.on('click',function () {
            window.history.back();
        });
    }
})();