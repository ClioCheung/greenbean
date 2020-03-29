(function () {
    $(function(){
        bindAddButtonClickEvent();
        initAutoComplete($('input[name="author"]'),'getAuthorSuggestion');
        initAutoComplete($('input[name="translator"]'),'getTranslatorSuggestion');
        bindDateChangeEvent();
    });
    
    function bindDateChangeEvent(){
        const publicationDate = $('#publicationYear,#publicationMonth');
        publicationDate.on('change',function () {
            const publicationDayElement = $('#publicationDay');
            publicationDayElement.children(':not(:first-child)').remove();
            //XXX 切换年月时，当月的天数一致时，日无需归零
            const publicationMonthValue = $('#publicationMonth').val();
            if(publicationMonthValue != 0){
                const publicationYearValue = $('#publicationYear').val();
                const dayNumber = new Date(publicationYearValue,publicationMonthValue,0).getDate();
                for(let i = 0; i < dayNumber; i++){
                    const dayOption = $('<option></option>');
                    dayOption.val(i + 1);
                    dayOption.text(i + 1);
                    publicationDayElement.append(dayOption);
                }
            }
        });
    }
    
    //XXX 在后台进行 type 的区分
    function initAutoComplete(selector,url){
        selector.autocomplete({
            minLength : 1,
            source : function (request,response) {
                $.ajax({
                    url : url,
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
    
    function bindAddButtonClickEvent(){
        const addButton = $('.addButton');
        addButton.on('click',function(event){
            const addButton = $(event.currentTarget);
            const dataNumber = parseInt(addButton.attr("data-number"));
            const row = addButton.parent().prev().children(":last-child");
            const cloneRow = row.clone();
            
            const cloneRowInput = cloneRow.find("input");
            cloneRowInput.val("");
            const inputName = cloneRowInput.attr("name");
            let url = "get" + inputName.substr(0,1).toUpperCase()+ inputName.substr(1) + "Suggestion";
            initAutoComplete(cloneRowInput,url);
            
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