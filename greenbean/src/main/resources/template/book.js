(function () {
    $(function () {
        const ratingClickStar = $('#ratingClickStar');
        ratingClickStar.on('mouseover',function (event) {
            const target = event.target;
            let star = 'solid';
            ratingClickStar.children().each(function (index, element) {
                $(element.firstElementChild).attr('src',ratingClickStar.attr('data-' + star));
                if(element.firstElementChild === target){
                    star = 'hollow';
                }
            });
        });
    
        ratingClickStar.on('mouseleave', function () {
            ratingClickStar.children().each(function (index, element) {
                $(element.firstElementChild).attr('src',ratingClickStar.attr('data-hollow'));
            });
        });
    });
})();
