(function () {
    $(function () {
        const ratingClickStar = $('#ratingClickStar');
        ratingClickStar.on('mouseover',function (event) {
            ratingClickStar.children().each(function (index, element) {
                const target = event.target;
                const solidStarAttr = ratingClickStar.attr('data-solid');
               /* element.firstElementChild.setAttribute('src',solidStarAttr);*/
                $(element.firstElementChild).attr('src',solidStarAttr);
                if(element.firstElementChild === target){
                    return false;
                }
            })
        })
    });
})();
