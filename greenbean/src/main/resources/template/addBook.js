(function () {
    $(function(){
        bindNextButtonClickEvent();
        bindCancelButtonClickEvent();
        bindAddButtonClickEvent();
        bindAuthorChangeEvent();
    });

    function bindAuthorChangeEvent(){
        const authorSuggestion = $("input[name='author']");
        authorSuggestion.on('input',function (event) {
            //TODO 关键词为空时，不发请求
            //TODO 点击选择后，不发请求
            $.ajax({
                url : "getAuthorSuggestion",
                method : "GET",
                data : {
                    keyword : $(event.currentTarget).val()
                },
                dataType : "json"
            }).done(function (data) {
                const dataList = $("#authorSuggestion");
                dataList.children().remove();
                for(let dataElement of data){
                    const option = $("<option></option>");
                    option.attr("data-value",dataElement.id);
                    option.text(dataElement.name);
                    dataList.append(option);
                    //TODO 切换下一个<input>时，清空之前的查询结果
                }
                debugger;
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