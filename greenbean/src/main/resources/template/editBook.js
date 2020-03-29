(function () {
    $(function () {
        bindCancelButtonClickEvent();
    });
    
    function bindCancelButtonClickEvent() {
        const cancelButton = $('#cancelButton');
        cancelButton.on('click',function () {
            window.location.href="book/{id}";
        });
    }
})();