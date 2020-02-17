(function () {
    $(function(){
        bindNextButtonClickEvent();
        bindCancelButtonClickEvent();
        bindAddButtonClickEvent();
        bindAuthorChangeEvent();
    });

    function bindAuthorChangeEvent(){
        const  authorSuggestion = $("input[name='author']");
        authorSuggestion.on('input',function (event) {
           console.log("aaaa");
           //TODO  发起ajax请求，获取提示数据，放在页面datalist
            $.ajax({
                url : "getAuthorSuggestion",
                method : "GET",
                data : {
                    keyword : $(event.currentTarget).val()
                },
                dataType : "json"
            }).done(function () {

            }).fail(function () {

            });
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