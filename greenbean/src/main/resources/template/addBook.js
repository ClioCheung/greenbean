(function () {
    $(function(){
        bindNextButtonClickEvent();
        bindCancelButtonClickEvent();
        bindAddButtonClickEvent();
        initAutoComplete("author");
        initAutoComplete("translator");
    });

    //XXX 在后台进行 type 的区分
    function initAutoComplete(type){
        const suggestion = $('input[name="' + type + '"]');
        const getSuggestionUrl = "get" + type.substring(0,1).toUpperCase()+ type.substring(1) + "Suggestion";
        suggestion.autocomplete({
            minLength : 1,
            source : function (request,response) {
                $.ajax({
                    url : getSuggestionUrl,
                    method : "GET",
                    data : {
                        keyword : request.term
                    },
                    dataType : "json"
                }).done(function (data) {
                    response(data);
                }).fail(function () {
                });
            }
        });
    }

    function bindNextButtonClickEvent() {
        const nextButton = $('#nextButton');
        nextButton.on("click",function(){
            // TODO first step ： 验证ISBN
            $('.d-none').removeClass("d-none");
            $('#isbn').attr('readonly','');
            nextButton.hide();
            $("#submitButton").show();
        });
    }

    function bindCancelButtonClickEvent() {
        const cancelButton = $('#cancelButton');
        cancelButton.on('click',function () {
            window.location.href="home";
        });
    }

    function bindAddButtonClickEvent(){
        const addButton = $('.addButton');
        addButton.on('click',function(event){
            const addButton = $(event.currentTarget);
            const dataNumber = parseInt(addButton.attr("data-number"));
            const row = addButton.parent().prev().children(":last-child");
            const cloneRow = row.clone();
            row.after(cloneRow);
            cloneRow.find("span:first").text(dataNumber+1);
            addButton.attr("data-number",dataNumber+1);
            // TODO 修正此处硬代码，有没更好的方法
            const lineHeight = 32;
            addButton.css("top",dataNumber * lineHeight + "px");
        });
    }

    $("#authorSuggestion").on("keyPress",function () {

    });


})();