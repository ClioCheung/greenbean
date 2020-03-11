(function () {
    $(function () {
        const ratingClickStar = $('#ratingClickStar');
        const ratingStarIntro = $('#ratingStarIntro');
        const ratingStarIntroText = ['Very bad', 'Bad', 'Average', 'Good', 'Very good'];
        ratingClickStar.on('mouseover',function (event) {
            const target = $(event.target);
            const imgIndex = target.data('index');
            ratingClickStar.children().each(function (index, element) {
                const img = $(element.firstElementChild);
                if(index <= imgIndex){
                    img.attr('src',ratingClickStar.attr('data-solid'));
                } else {
                    img.attr('src',ratingClickStar.attr('data-hollow'));
                }
            });
            ratingStarIntro.text(ratingStarIntroText[imgIndex]);
        });
    
        ratingClickStar.on('mouseleave', function () {
            ratingClickStar.children().each(function (index, element) {
                $(element.firstElementChild).attr('src',ratingClickStar.attr('data-hollow'));
            });
            ratingStarIntro.text('');
        });
    });
    
    $('#ratingDialog').on('show.bs.modal', function (event) {
        const button = $(event.relatedTarget);
        const recipient = button.data('status');
        const modal = $(this);
        modal.find('.modal-title>span').text(recipient);
    });
})();
