(function(){
    $(document).ready(function () {
        var activeClassName = "active";
        var signInTab = $("#signInTab");
        var signUpTab = $("#signUpTab");
        var submitButton = $("#submitButton");
        var tabArray = new Array(signInTab,signUpTab);

        var handlerDataObject = {
            activeClassName: activeClassName,
            tabArray: tabArray,
            submitButton: submitButton
        }

        var tabOnClickHandler = function(event) {
            var handlerDataObject = event.data;
            var tabDomObject = $(event.target);
            for (var i = 0; i < tabArray.length; i++) {
                if(tabArray[i].is(tabDomObject)){
                    if(!tabDomObject.hasClass(handlerDataObject.activeClassName)) {
                        tabDomObject.addClass(handlerDataObject.activeClassName);
                        handlerDataObject.submitButton.text(tabDomObject.text());
                    } else {
                        tabDomObject.removeClass(handlerDataObject.activeClassName);
                    }
                }
            }
        }

        for (var i = 0; i < tabArray.length ; i++) {
            tabArray[i].click(handlerDataObject,tabOnClickHandler);
        }

    });
})();